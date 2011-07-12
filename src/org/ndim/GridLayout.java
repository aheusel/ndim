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

import org.ndim.util.Arr;
import org.ndim.math.Vec;

/**
 * This class is a describes how entities which are stored in an arbitrary linear
 * storage can be accessed as a n-dimensonal array.
 * 
 * {@stickyInfo "Definition:"
 * 
 * <ul>
 *    <li> We call the integer which denotes the position of an entity in its
 *      storage its <em>address a</em>.
 *    <li> The <em>index</em> of an entity is defined as its position in the
 *	    lexicographic enumeration of all entities described by a GridLayout
 *      which starts with the lowest dimension ("x").
 * </ul>
 * 
 * }
 * 
 * It is required to make this distinction as it is possible to crop and resample
 * Layouts and therefore the index of an entity doesn't generally match its address. 
 * 
 * @author Alexander Heusel
 */
public final class GridLayout extends Grid
{

    public final class Descriptor
    {

        private final double[] spacing;

        private Descriptor(final double[] spacing)
        {
            this.spacing = spacing.clone();
        }

        /**
         * Returns the spacing of the <code>idx</code>-th dimension.
         *
         * @param idx The index of the dimension
         * @return The spacing of this dimension
         */
        public final double spacing(int idx)
        {
            return spacing[idx];
        }

        public final double[] spacing()
        {
            return spacing.clone();
        }

        public final void spacing(double[] spacing)
        {
            System.arraycopy(this.spacing, 0, spacing, 0, Math.min(spacing.length, this.spacing.length));
        }

        public final void spacing(float[] spacing)
        {
            int length = Math.min(spacing.length, this.spacing.length);
            for (int i = 0; i < length; i++)
            {
                spacing[i] = (float) this.spacing[i];
            }
        }

        /**
         * Returns the physical coordinates of a grid-node.
         *
         * @param gridIdx The discrete coordinate of the grid-node
         * @param pos Contains the physical coordinate of the node after the call.
         */
        public final void physCoordinate(final int[] gridIdx, final float[] pos)
        {
            for (int i = 0; i < gridIdx.length; i++)
            {
                pos[i] = (float)(gridIdx[i] * spacing[i]);
            }
        }

        /**
         * Returns the physical coordinates of a grid-node.
         *
         * @param gridIdx The discrete coordinate of the grid-node
         * @param pos Contains the physical coordinate of the node after the call.
         */
        public final void physCoordinate(final int[] gridIdx, final double[] pos)
        {
            for (int i = 0; i < gridIdx.length; i++)
            {
                pos[i] = gridIdx[i] * spacing[i];
            }
        }

        /**
         * Returns the physical coordinates of a grid-node.
         *
         * @param gridIdx The discrete coordinate of the grid-node
         * @return The physical coordinate of the node.
         */
        public final double[] physCoordinate(final int[] gridIdx)
        {
            double[] coor = new double[spacing.length];
            physCoordinate(gridIdx, coor);
            return coor;
        }

        /**
         * Returns the physical extent of a grid.
         *
         * @param gridLayout The layout of the grid.
         * @param physExtent The discreet extent of the grid.
         */
        public final void physExtent(final double[] physExtent)
        {
            for (int i = 0; i < extent.length; i++)
            {
                physExtent[i] = spacing[i] * (extent[i] - 1);
            }
        }

        /**
         * Returns the physical extent of the given dimension of a grid.
         *
         * @param gridLayout The layout of the grid.
         * @param dimIdx The index of the dimension to query
         * @return The extent of the dimension.
         */
        public final double physExtent(int dimIdx)
        {
            return spacing[dimIdx] * (extent[dimIdx] - 1);
        }

        /**
         * Returns the number of dimensions of the descriptor.
         *
         * @return The number of dimensions.
         */
        public final int nrDims()
        {
            return GridLayout.this.nrDims();
        }

    }
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
    // Geometry-like variables
    private final Descriptor descriptor;
    private final int[] pageSize;
    // Pointer-like variables
    private int offset;
    private final int[] incr;

    /**
     * This constructor takes an arbitrary number of Integer objects. These
     * integers are interpreted as the extent of the layout. The number of
     * dimensions of the layout is implicitly given by the <em>number of arguments</em>.
     *
     * @param args The extent of the layout.
     */
    public GridLayout(final int... extent)
    {
        super(extent);
        descriptor = new Descriptor(Arr.fillCreateDouble(extent.length, 1.0));
        pageSize = Arr.calcVolumes(extent);
        incr = Arr.calcVolumes(extent);
        if(checkIntegrity() == false)
        {
            throw new java.lang.IllegalArgumentException("Illegal arguments in constructor!");
        }
    }

    public GridLayout(final int[] extent, final double[] spacing)
    {
        super(extent);
        descriptor = new Descriptor(spacing);
        pageSize = Arr.calcVolumes(extent);
        incr = Arr.calcVolumes(extent);
        if(checkIntegrity() == false)
        {
            throw new java.lang.IllegalArgumentException("Illegal arguments in constructor!");
        }
    }

    private GridLayout(final int[] extent, final double[] spacing, final int[] pageSize, final int[] incr, final int offset)
    {
        super(extent);
        this.descriptor = new Descriptor(spacing);
        this.pageSize = pageSize;
        this.offset = offset;
        this.incr = incr;
    }

    private final boolean checkIntegrity()
    {
        if (extent.length != descriptor.spacing.length)
        {
            return false;
        }
        for (int i = 0; i < extent.length; i++)
        {
            if (extent[i] < 1)
            {
                return false;
            }
            if (descriptor.spacing[i] <= 0.0)
            {
                return false;
            }
        }
        return true;
    }



    /**
     * Returns the descriptor or the GridLayout.
     *
     * @return The descriptor of the grid.
     */
    public final Descriptor descriptor()
    {
        return descriptor;
    }

    /**
     * Returns the offset to the first entitiy of this layout.
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
     * Selects a subspace of a layout.
     * 
     * @param layout The layout to be used
     * @param dimIdx The dimensions to select
     */
    public final GridLayout subspace(final int... dimIdx)
    {

        int[] newExtent = new int[dimIdx.length];
        Arr.coalesce(newExtent, extent, dimIdx);

        int[] newPageSize = Arr.calcVolumes(newExtent);

        int[] newIncr = new int[dimIdx.length];
        Arr.coalesce(newIncr, incr, dimIdx);

        double[] newSpacing = new double[dimIdx.length];
        Arr.coalesce(newSpacing, descriptor.spacing, dimIdx);

        return new GridLayout(newExtent, newSpacing, newPageSize, newIncr, offset);
    }

    /**
     * Resamples a field.
     * 
     * @param start The start position of the resampled entities. This position is forced
     * into the boundaries of the layout.
     * @param strides The strides to take in the resampling procedure
     * @return Reference to the new GridLayout.
     */
    public final GridLayout resample(int[] start, int[] strides)
    {
        int[] newExtent = extent.clone();
        int[] newIncr = incr.clone();
        double[] newSpacing = descriptor.spacing.clone();
        int newOffset = offset;

        for (int i = 0; i < start.length; i++)
        {
            start[i] = normalizedStartPos(start[i], strides[i]);
            newExtent[i] = normalizedExtent(start[i], strides[i], newExtent[i]);
            newOffset += newIncr[i] * start[i];
            newIncr[i] *= strides[i];
            newSpacing[i] *= Math.abs(strides[i]);
        }

        int[] newPageSize = Arr.calcVolumes(newExtent);
        return new GridLayout(newExtent, newSpacing, newPageSize, newIncr, newOffset);
    }

    /**
     * Inverts the denoted dimensions.
     * 
     * @param args The dimensions which shall be inverted.
     * @return Reference to this GridLayout.
     */
    public final GridLayout invert(final int... args)
    {
        final int[] endPos = new int[extent.length];
        final int[] newIncr = new int[extent.length];
        int argIter = 0;
        for (int i = 0; i < endPos.length; i++)
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

        return new GridLayout(extent.clone(), descriptor.spacing.clone(), pageSize.clone(), newIncr, addr(endPos));
    }

    public final GridLayout invert(final int[] args, final GridLayout gridLayout)
    {
        final int[] endPos = new int[extent.length];
        for (int i = 0; i < endPos.length; i++)
        {
            gridLayout.extent[i] = extent[i];
            gridLayout.descriptor.spacing[i] = descriptor.spacing[i];
            gridLayout.pageSize[i] = pageSize[i];
            if (Arr.has(args, i) > 0)
            {
                endPos[i] = extent[i] - 1;
                gridLayout.incr[i] = -incr[i];
            }
            else
            {
                endPos[i] = 0;
                gridLayout.incr[i] = incr[i];
            }
        }
        return gridLayout;
    }

    /**
     * Calculates the new offset and the new extents required to crop a field.
     * 
     * @param start The start-position of the crop-area
     * @param extent The extent of the field after cropping.
     * @return Reference to this GridLayout.
     */
    public final GridLayout crop(int[] start, int[] extent)
    {
        final int[] newExtent = extent.clone();
        for (int i = 0; i < extent.length; i++)
        {
            newExtent[i] = ((start[i] + extent[i] - 1) < newExtent[i]) ? extent[i] : newExtent[i] - start[i];
        }

        return new GridLayout(newExtent, descriptor.spacing.clone(), Arr.calcVolumes(extent), incr.clone(), addr(start));
    }

    /**
     * Crops the borders of a GridLayout
     * 
     * @param borders The sizes of the borders.
     * @return Reference to this GridLayout.
     */
    public final GridLayout cropBorders(final int... borders)
    {
        if (!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }

        int[] nExtent = new int[extent.length];
        for (int i = 0; i < nExtent.length; i++)
        {
            nExtent[i] = extent[i] - 2 * borders[i];
        }

        return crop(borders, nExtent);
    }


    public final GridLayout cropBorders(int size)
    {
        return cropBorders(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Removes the first elements of each dimension.
     * 
     * @param borders The number of elements to be removed from the GridLayout
     * @return Reference to this GridLayout.
     */
    public final GridLayout trimBegin(final int... borders)
    {
        if (!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }

        int[] nExtent = new int[extent.length];
        for (int i = 0; i < nExtent.length; i++)
        {
            nExtent[i] = extent[i] - borders[i];
        }

        return crop(borders, nExtent);
    }

    public final GridLayout trimBegin(int size)
    {
        return trimBegin(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Removes the last elements of each dimension.
     * 
     * @param borders The number of elements to be removed from the GridLayout
     * @return Reference to this GridLayout.
     */
    public final GridLayout trimEnd(final int... borders)
    {
        if (!Vec.greaterThan(borders, -1))
        {
            throw new java.lang.ArithmeticException("Negative border-values given!");
        }

        int[] nExtent = new int[extent.length];
        for (int i = 0; i < nExtent.length; i++)
        {
            nExtent[i] = extent[i] - borders[i];
            borders[i] = 0;
        }

        return crop(borders, nExtent);
    }


    public final GridLayout trimEnd(int size)
    {
        return trimEnd(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Shrinks the GridLayout by the given number of elements in all directions.
     * 
     * @param size The number of elements to crop from each side.
     * @return Reference to this GridLayout.
     */
    public final GridLayout shrink(int size)
    {
        return cropBorders(Arr.fillCreateInt(extent.length, size));
    }

    /**
     * Returns the address of the entity at the position pos
     * 
     * @param pos The coordinate.
     * @return The address of the entitiy at the position.
     */
    private final int addr(final int... pos)
    {
        int res = offset;
        for (int i = 0; i < incr.length; i++)
        {
            res += incr[i] * pos[i];
        }
        return res;
    }


}
