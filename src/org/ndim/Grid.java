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

/**
 *
 * @author Alexander Heusel
 */
public class Grid
{

    protected final int[] extent;
    protected int nrEntities;

    /**
     */
    protected Grid(final int[] extent)
    {
        this.extent = extent.clone();
        nrEntities = (int) Vec.productOperator(extent);
    }

    /**
     * Returns a copy of the extent of the grid
     * 
     * @return A copy of the extent of the grid.
     */
    public final int[] extent()
    {
        return extent.clone();
    }

    /**
     * Copies the extent of the grid to the given array
     * 
     * @param extent The array which contains the grid-extent after the call.
     */
    public final void extent(final int[] extent)
    {
        System.arraycopy(this.extent, 0, extent, 0, Math.min(extent.length, this.extent.length));
    }

    /**
     * Returns the extent of the <code>idx</code>-th dimension.
     *
     * @param idx The index of the dimension
     * @return The extent of this dimension
     */
    public final int extent(int idx)
    {
        return extent[idx];
    }

    /**
     * Forces the given coordinate inside the range of the grid.
     * 
     * @param pos The coordinate which will be forced to the range of the grid.
     */
    public final void forceToRange(final int[] pos)
    {
        for(int i = 0; i < nrDims(); i++)
        {
            pos[i] = forceToRange(i, pos[i]);
        }
    }

    /**
     * Forces the given coordinate inside the range of the grid
     * 
     * @param idx The dimension-index of the coordinate
     * @param pos The coodinate.
     * @return The new coordinate.
     */
    public final int forceToRange(int idx, int pos)
    {
        if(pos < 0)
        {
            return 0;
        }
        if(pos > extent[idx])
        {
            return extent[idx];
        }
        return pos;
    }
    
    /**
     * Determines whether the given position is at the last valid element of the
     * dimension denoted with idx or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is at the end,
     * <code>false</code> if not.
     */
    public final boolean isAtEnd(int idx, int pos)
    {
        return pos == (extent[idx] - 1);
    }

    /**
     * Determines whether the given position is in the extent or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is inside, <code>false</code> if it is outside the extent.
     */
    public final boolean isIn(final int... pos)
    {
        for(int i = 0; i < extent.length; i++)
        {
            if(!inRange(pos[i], extent[i]))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the given position is in the extent of the dimension
     * denoted with idx or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is inside, <code>false</code> if it is outside the extent.
     */
    public final boolean isIn(int idx, int pos)
    {
        return inRange(pos, extent[idx]);
    }

    /**
     * Determines whether the given position is on the border of a field or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is on the border, <code>false</code> if not.
     */
    public final boolean isOnBorder(final int... pos)
    {
        int currentDim;
        for (int i = 0; i < extent.length; i++)
        {
            currentDim = pos[i];
            if (currentDim == 0 || currentDim == extent[i] - 1)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of dimensions of the layout.
     *
     * @return The number of dimensions
     */
    public final int nrDims()
    {
        return extent.length;
    }

    /**
     * Returns the number of entities in a field.
     *
     * @return The number of entities in a field.
     */
    public final int nrEntities()
    {
        return nrEntities;
    }


    /**
     * Determines if a coordinate is in range.
     *
     * @param x The coordinate-value to check.
     * @param extent The extent of the coordinate-dimension.
     * @return <code>true</code> if <code>x > -1</code> and <code>x < extent</code>
     */
    protected static boolean inRange(int x, int extent)
    {
        return x > -1 && x < extent;
    }

    /**
     * Forces a coordinate-value to the given extent. If the extent
     * is left the coordinate-value is mirrored back in.
     *
     * @param x The coordinate-value.
     * @param extent The extent of the coordinate-dimension.
     * @return The mirrored coordinate-value
     */
    protected static int mirrorCoor(int x, int extent)
    {
        if(inRange(x, extent))
        {
            return x;
        }
        int nx = x;
        return nx < 0 ? -nx : 2 * extent - nx - 1;
    }

    /**
     * Calculates the extent for a resampled field.
     *
     * @param start The start-position for the resampling process
     * @param stride The stride-width for the resampling
     * @param extent The extent of the field before the resampling
     * @return The extent of the field after the resampling
     */
    protected static int normalizedExtent(int start, int stride, int extent)
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
    protected static int normalizedStartPos(int start, int stride)
    {
        return stride * (int) Math.ceil((double) (-start) / (double) (stride)) + start;
    }

    /**
     * Forces a coordinate-value to the given extent. If the extent
     * is left on one border the coordinate-value reenters the extent
     * on the opposite border.
     *
     * @param x The coordinate-value.
     * @param extent The extent of the coordinate-dimension.
     * @return The tiled coordinate-value
     */
    protected static int tileCoor(int x, int extent)
    {
        int nx = x % extent;
        return nx < 0 ? nx + extent : nx;
    }    
    
}
