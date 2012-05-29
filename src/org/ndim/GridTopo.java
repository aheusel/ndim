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

import java.util.Arrays;
import org.ndim.math.Vec;
import org.ndim.Arrays.Algo;

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

    private final int _offset;
    private final int[] _incr;
    private final int[] _pageSize;
        
    /**
     * This constructor takes an arbitrary number of Integer objects. These
     * integers are interpreted as the _extent of the grid. The number of
     * dimensions of the grid is implicitly given by the <em>number of arguments</em>.
     *
     * @param args The _extent of the grid.
     */
    public GridTopo(final int... extent)
    {
        this(extent, 0, Vec.products(new int[extent.length], extent), Vec.products(new int[extent.length], extent));
    }

    private GridTopo(final int[] extent, final int offset, final int[] incr, final int[] pageSize)
    {
        super(extent);
        _pageSize = pageSize;
        _offset = offset;
        _incr = incr;
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
        return _offset;
    }

    /**
     * Returns the distance to the next entity in the denoted dimensions of a field.
     * 
     * @param idx The dimension-index
     * @return The distance to the next entity in the given dimension.
     */
    public final int incr(int idx)
    {
        return _incr[idx];
    }

    /**
     * Returns the increments to the next entities in all dimensions of a field.
     * 
     * @return The distances to the next entities in all dimensions.
     */
    public final int[] incr()
    {
        return _incr.clone();
    }

    /**
     * Copys the increments to the next entities in all dimensions into the given array.
     * 
     * @param incr The array containing the distances to the next entities in all dimensions.
     */
    public final void incr(int[] incr)
    {
        System.arraycopy(_incr, 0, incr, 0, _incr.length);
    }
    
    /**
     * Clones this GridTopo
     * 
     * @return The clone of this GridTopo
     */
    @Override
    public GridTopo clone()
    {
        return new GridTopo(_extent.clone(), _offset, _incr.clone(), _pageSize.clone());
    }
        
    /**
     * Selects a subspace of a grid.
     * 
     * @param dimIdx The dimensions to select
     */
    public final GridTopo subspace(final int... dimIdx)
    {
        final int[] cleanDimIdx = dimIdx.clone();
        Arrays.sort(cleanDimIdx);
        final int uniqueLength = Algo.unique(cleanDimIdx);
        
        if(uniqueLength > nrDims() || cleanDimIdx[uniqueLength - 1] > nrDims())
        {
            throw new java.lang.IllegalArgumentException("Argument contains to many or invalid dimension-indices.");
        }
        
        final int[] newExtent = Algo.coalesce(new int[dimIdx.length], _extent, dimIdx);
        final int[] newPageSize = Vec.products(new int[newExtent.length], newExtent);
        final int[] newIncr = Algo.coalesce(new int[dimIdx.length], _incr, dimIdx);
        return new GridTopo(newExtent, _offset, newIncr, newPageSize);
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
        final int[] newExtent = _extent.clone();
        final int[] newIncr = _incr.clone();
        int newOffset = _offset;

        for (int i = 0; i < start.length; i++)
        {
            start[i] = normalizedStartPos(start[i], strides[i]);
            newExtent[i] = normalizedExtent(start[i], strides[i], newExtent[i]);
            newOffset += newIncr[i] * start[i];
            newIncr[i] *= strides[i];
        }

        final int[] newPageSize = Vec.products(new int[newExtent.length], newExtent);
        return new GridTopo(newExtent, newOffset, newIncr, newPageSize);
    }

    /**
     * Inverts the denoted dimensions.
     * 
     * @param args The dimensions which shall be inverted.
     * @return Reference to this GridTopo.
     */
    public final GridTopo invert(final int... args)
    {
        final int[] endPos = new int[_extent.length];
        final int[] newIncr = new int[_extent.length];
        final int[] cleanArgs = args.clone();
       
        Arrays.sort(cleanArgs);
        final int uniqueLength = Algo.unique(cleanArgs);
        if(uniqueLength > nrDims() || cleanArgs[uniqueLength - 1] > nrDims())
        {
            throw new java.lang.IllegalArgumentException("Argument contains to many or invalid dimension-indices.");
        }
        
        int argIter = 0;
        for(int i = 0; i < endPos.length; i++)
        {
            if (i == args[argIter])
            {
                endPos[i] = _extent[i] - 1;
                newIncr[i] = -_incr[i];
                argIter++;
            }
            else
            {
                endPos[i] = 0;
                newIncr[i] = _incr[i];
            }
        }

        return new GridTopo(_extent.clone(),
                            addr(_offset, _incr, endPos),
                            newIncr, _pageSize.clone());
    }

    /**
     * Calculates the new offset and the new extents required to crop a field.
     * 
     * @param start The start-position of the crop-area
     * @param _extent The _extent of the field after cropping.
     * @return Reference to this GridTopo.
     */
    public final GridTopo crop(int[] start, int[] extent)
    {
        final int[] newExtent = _extent.clone();
        for(int i = 0; i < extent.length; i++)
        {
            newExtent[i] = ((start[i] + extent[i] - 1) < newExtent[i]) ? extent[i] : newExtent[i] - start[i];
        }

        return new GridTopo(newExtent,
                            addr(_offset, _incr, start),
                            _incr.clone(),
                            Vec.products(new int[extent.length], extent));
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
        return crop(borders, Vec.addMul(new int[_extent.length], _extent, borders, -2));
    }


    public final GridTopo cropBorders(int size)
    {
        return cropBorders(Algo.fill(new int[_extent.length], size));
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
        return crop(borders, Vec.sub(new int[_extent.length], _extent, borders));
    }

    public final GridTopo trimBegin(int size)
    {
        return trimBegin(Algo.fill(new int[_extent.length], size));
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
        int[] nExtent = Vec.sub(new int[_extent.length], _extent, borders);
        Arrays.fill(borders, 0);
        return crop(borders, nExtent);
    }


    public final GridTopo trimEnd(int size)
    {
        return trimEnd(Algo.fill(new int[_extent.length], size));
    }

    /**
     * Shrinks the GridTopo by the given number of elements in all directions.
     * 
     * @param size The number of elements to crop from each side.
     * @return Reference to this GridTopo.
     */
    public final GridTopo shrink(int size)
    {
        return cropBorders(Algo.fill(new int[_extent.length], size));
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private section
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Returns the address of the entity at the position pos
     * 
     * @param offset The offset of the grid
     * @param incr The increment-array of the grid
     * @param pos The coordinate.
     * @return The address of the entitiy at the position.
     */
    private static int addr(final int offset, final int[] incr, final int[] pos)
    {
        return offset + (int)Vec.dot(incr, pos);
    }
    
    /**
     * Calculates the _extent for a resampled field.
     *
     * @param start The start-position for the resampling process
     * @param stride The stride-width for the resampling
     * @param _extent The _extent of the field before the resampling
     * @return The _extent of the field after the resampling
     */
    private static int normalizedExtent(int start, int stride, int extent)
    {
        return (int) Math.floor((double) (extent - 1 - start) / (double) (stride)) + 1;
    }

    /**
     * Calculates the lowest possible start-position.
     *
     * @param start The start-position for a resampling process
     * @param stride The stride for the resampling
     * @return The lowest possible start-position
     */
    private static int normalizedStartPos(int start, int stride)
    {
        return stride * (int) Math.ceil((double) (-start) / (double) (stride)) + start;
    }
    

}
