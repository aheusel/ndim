/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * copyright (c) 2007 - 2009
 * Goethe Center for Scientific Computing (G-CSC)
 * University of Frankfurt
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the distribution.
 * - Neither the name of the University of Frankfurt nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.ndim;

import org.ndim.math.Vec;
import org.ndim.util.Arr;

/**
 * This <em>immutable</em> class is a describes how entities which are stored in an arbitrary linear
 * storage can be accessed as a n-dimensonal array, i.e. grid.
 * 
 * {@stickyInfo "Definition:"
 * 
 * <ul>
 *      <li> We call the integer which denotes the position of an entity in its
 *      storage its <em>address a</em>.
 *      <li> The <em>index</em> of an entity is defined as its position in the
 *      lexicographic enumeration of all entities described by a GridTopo (grid-topology)
 *      which starts with the lowest dimension ("x").
 *      <li> An entity can be any kind of structured data, e.g. simple real or integer
 *      numbers as well as n-dimensional vectors or the like.
 * </ul>
 * 
 * }
 * 
 * It is required to make this distinction as it is possible to crop and resample
 * grid-topologies and therefore the index of an entity doesn't generally match its address. 
 * 
 * @author Alexander Heusel
 */
public final class GridTopo extends Grid
{
    /**
     * A constant for the index of the time-dimension.
     */
    public static final int T = 3;
    /**
     * A constant for the index of the x-dimension.
     */
    public static final int X = 0;
    /**
     * A constant for the index of the y-dimension.
     */
    public static final int Y = 1;
    /**
     * A constant for the index of the z-dimension.
     */
    public static final int Z = 2;

    private final int offset;
    private final int[] incr;
    private final int[] pageSize;
        
    /**
     * This constructor takes an arbitrary number of Integer objects. These
     * integers are interpreted as the extent of the grid. The number of
     * dimensions of the grid is implicitly given by the <em>number of arguments</em>.
     *
     * @param args The extent of the grid.
     */

    public GridTopo(final int... extent)
    {
        this(extent, Arr.calcVolumes(extent), Arr.calcVolumes(extent), 0);
    }

    private GridTopo(final int[] extent, final int[] pageSize, final int[] incr, final int offset)
    {
        super(extent);
        this.pageSize = pageSize;
        this.offset = offset;
        this.incr = incr;
        if(Vec.lessThan(incr, 1))
        {
            throw new java.lang.IllegalArgumentException("Illegal arguments in constructor!");
        }
    }

    /**
     * Returns the offset to the first entitiy of this grid.
     * 
     * @return The offset to the first entitiy.
     */
    public final int offset()
    {
        return offset;
    }

    /**
     * Returns the distance to the next entity in the denoted dimensions of a field.
     * 
     * @param idx The dimension-index
     * @return The distance to the next entity in the given dimension.
     */
    public final int incr(int idx)
    {
        return incr[idx];
    }

    /**
     * Returns the increments to the next entities in all dimensions of a field.
     * 
     * @return The distances to the next entities in all dimensions.
     */
    public final int[] incr()
    {
        return incr.clone();
    }

    /**
     * Copys the increments to the next entities in all dimensions into the given array.
     * 
     * @param incr The array containing the distances to the next entities in all dimensions.
     */
    public final void incr(int[] incr)
    {
        System.arraycopy(this.incr, 0, incr, 0, this.incr.length);
    }

    /**
     * Returns the address of the entity at the position pos
     * 
     * @param pos The coordinate.
     * @return The address of the entitiy at the position.
     */
    private int addr(final int... pos)
    {
        return offset + (int)Vec.dot(incr, pos);
    }
    
    /**
     * Clones this GridTopo
     * 
     * @return The clone of this GridTopo
     */
    @Override
    public GridTopo clone()
    {
        return new GridTopo(extent.clone(), pageSize.clone(), incr.clone(), offset);
    }
    
    /**
     * Adds to the offset of a GridTopo
     * 
     * @param offs The offs to add
     * @return The new GridTopo
     */
    public final GridTopo shift(final int offs)
    {
        return new GridTopo(extent.clone(), pageSize.clone(), incr.clone(), offset + offs);
    }
    
    /**
     * Selects a subspace of a grid.
     * 
     * @param dimIdx The dimensions to select
     */
    public final GridTopo subspace(final int... dimIdx)
    {
        final int[] newExtent = Arr.coalesce(extent, dimIdx);
        final int[] newPageSize = Arr.calcVolumes(newExtent);
        final int[] newIncr = Arr.coalesce(incr, dimIdx);
        return new GridTopo(newExtent, newPageSize, newIncr, offset);
    }

    /**
     * Resamples a field.
     * 
     * @param start The start position of the resampled entities. This position is forced
     * into the boundaries of the layout.
     * @param strides The strides to take in the resampling procedure
     * @return Reference to the new GridTopo.
     */
    public final GridTopo resample(int[] start, int[] strides)
    {
        final int[] newExtent = extent.clone();
        final int[] newIncr = incr.clone();
        int newOffset = offset;

        for (int i = 0; i < start.length; i++)
        {
            start[i] = normalizedStartPos(start[i], strides[i]);
            newExtent[i] = normalizedExtent(start[i], strides[i], newExtent[i]);
            newOffset += newIncr[i] * start[i];
            newIncr[i] *= strides[i];
        }

        final int[] newPageSize = Arr.calcVolumes(newExtent);
        return new GridTopo(newExtent, newPageSize, newIncr, newOffset);
    }

    /**
     * Inverts the denoted dimensions.
     * 
     * @param args The dimensions which shall be inverted.
     * @return Reference to this GridTopo.
     */
    public final GridTopo invert(final int... args)
    {
        final int[] endPos = new int[extent.length];
        final int[] newIncr = new int[extent.length];
        int argIter = 0;
        for(int i = 0; i < endPos.length; i++)
        {
            if (i == args[argIter])
            {
                endPos[i] = extent[i] - 1;
                newIncr[i] = -incr[i];
            }
            else
            {
                endPos[i] = 0;
                newIncr[i] = incr[i];
            }
        }

        return new GridTopo(extent.clone(), pageSize.clone(), newIncr, addr(endPos));
    }

    /**
     * Calculates the new offset and the new extents required to crop a field.
     * 
     * @param start The start-position of the crop-area
     * @param extent The extent of the field after cropping.
     * @return Reference to this GridTopo.
     */
    public final GridTopo crop(int[] start, int[] extent)
    {
        final int[] newExtent = extent.clone();
        for(int i = 0; i < extent.length; i++)
        {
            newExtent[i] = ((start[i] + extent[i] - 1) < newExtent[i]) ? extent[i] : newExtent[i] - start[i];
        }

        return new GridTopo(newExtent, Arr.calcVolumes(extent), incr.clone(), addr(start));
    }

    /**
     * Crops the borders of a GridTopo
     * 
     * @param borders The sizes of the borders.
     * @return Reference to this GridTopo.
     */
    public final GridTopo cropBorders(final int... borders)
    {
        if(!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }
        return crop(borders, Vec.addMul(new int[extent.length], extent, borders, -2));
    }


    public final GridTopo cropBorders(int size)
    {
        return cropBorders(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Removes the first elements of each dimension.
     * 
     * @param borders The number of elements to be removed from the GridTopo
     * @return Reference to this GridTopo.
     */
    public final GridTopo trimBegin(final int... borders)
    {
        if(!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }
        return crop(borders, Vec.sub(new int[extent.length], extent, borders));
    }

    public final GridTopo trimBegin(int size)
    {
        return trimBegin(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Removes the last elements of each dimension.
     * 
     * @param borders The number of elements to be removed from the GridTopo
     * @return Reference to this GridTopo.
     */
    public final GridTopo trimEnd(final int... borders)
    {
        if(!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }

        int[] nExtent = new int[extent.length];
        for(int i = 0; i < nExtent.length; i++)
        {
            nExtent[i] = extent[i] - borders[i];
            borders[i] = 0;
        }

        return crop(borders, nExtent);
    }


    public final GridTopo trimEnd(int size)
    {
        return trimEnd(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Shrinks the GridTopo by the given number of elements in all directions.
     * 
     * @param size The number of elements to crop from each side.
     * @return Reference to this GridTopo.
     */
    public final GridTopo shrink(int size)
    {
        return cropBorders(Arr.fillCreateInt(extent.length, size));
    }



}
