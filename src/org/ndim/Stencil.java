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

import java.util.BitSet;

/**
 * A class that performs a lexicographic iteration with given
 * start-coordinate.
 * 
 * {@example "Sample Usage"
 * int[] pos = {0, 0, 0};
 * Stencil it = new Stencil(100, 200, 300);
 * while(it.hasNext(pos))
 * {
 *    doSomethingWith(pos);
 *    it.next(pos);
 * }
 * }
 * @author Alexander Heusel
 */
public class Stencil extends Grid
{
    private final int last;

    public Stencil(final int nrDims)
    {
        super(new int[nrDims]);
        last = _extent.length - 1;
    }

    /**
     * Create a Stencil which will start at <code>0</code> and will iterate <code>_extent[i]</code>
     * strides in each dimension.
     */
    public Stencil(final int... extent)
    {
        super(extent);
        last = extent.length - 1;
    }


    @Override
    public final Stencil clone()
    {
        return new Stencil(_extent);
    }


    /**
     * Determines if there are additional steps in the iteration
     * 
     * @return <code>true</code> if there are additional steps, <code>false</code> otherwise.
     */
    public final boolean hasNext(final int[] pos)
    {
        return pos[last] != _extent[last];
    }

    /**
     * Goes to the next position of the iteration.
     */
    public final void next(final int[] pos)
    {
        // Go to the next element.
        for(int i = 0; i < last; i++)
        {
            pos[i]++;
            if(pos[i] < _extent[i])
            {
                return;
            }
            else
            {
                pos[i] = 0;
            }
        }
        pos[last]++;
        
    }

    /**
     * Determines whether the given position is located at the last valid element in
     * a dimension.
     * 
     * @param pos The position
     * @return <code>true</code>, if at the end of the grid, <code>false</code> otherwise
     */
    public final boolean isAtEnd(final int... pos)
    {
        for(int i = 0; i < _extent.length; i++)
        {
            if(pos[i] == (_extent[i] - 1))
            {
                return true;
            }
        }
        return false;   
    }
    
    /**
     * 
     * @param pos
     * @return 
     */
    public final int atEnd(final int... pos)
    {
        int res = 0;
        for(int i = 0; i < pos.length; i++)
        {
            if(pos[i] == (_extent[i] - 1))
            {
                res |= (1 << i);
            }
        }
        return res;
    }

    /**
     * 
     * @param bs
     * @param pos 
     */
    public final void atEnd(final BitSet bs, final int... pos)
    {
        for(int i = 0; i < pos.length; i++)
        {
            bs.set(i, pos[i] == (_extent[i] - 1));
        } 
    }
    
    
    /**
     * Determines whether the given position is at the last valid element of the
     * dimension denoted with idx or not.
     *
     * @param idx The dimension-index
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is at the end,
     * <code>false</code> if not.
     */
    public final boolean isAtEnd(final int idx, final int pos)
    {
        return pos == (_extent[idx] - 1);
    }

    /**
     * Determines whether the given position is in the _extent or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is inside, <code>false</code>
     * if it is outside the _extent.
     */
    public final boolean isIn(final int... pos)
    {
        for(int i = 0; i < _extent.length; i++)
        {
            if(!inRange(pos[i], _extent[i]))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the given position is in the _extent of the dimension
     * denoted with idx or not.
     *
     * @param idx The dimension-index
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is inside, <code>false</code>
     * if it is outside the _extent.
     */
    public final boolean isIn(final int idx, final int pos)
    {
        return inRange(pos, _extent[idx]);
    }

    /**
     * Determines whether the given position is on the border of a field or not.
     *
     * @param pos The coordinate.
     * @return <code>true</code> if the coordinate is on the border,
     * <code>false</code> if not.
     */
    public final boolean isOnBorder(final int... pos)
    {
        int currentDim;
        for (int i = 0; i < _extent.length; i++)
        {
            currentDim = pos[i];
            if (currentDim == 0 || currentDim == _extent[i] - 1)
            {
                return true;
            }
        }
        return false;
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
            pos[i] = forceToRng(pos[i], _extent[i]);
        }
    }

    /**
     * Forces the given coordinate inside the range of the grid
     * 
     * @param idx The dimension-index of the coordinate
     * @param pos The coodinate.
     * @return The new coordinate.
     */
    public final int forceToRange(final int idx, final int pos)
    {
        return forceToRng(pos, _extent[idx]);
    }
    
    
    /**
     * Forces a coordinate-value inside the grid. If the grid
     * is left the coordinate-value is mirrored back in.
     *
     * @param x The coordinate-value.
     */    
    public final void mirrorCoordinate(final int[] pos)
    {
        for(int i = 0; i < pos.length; i++)
        {
            pos[i] = mirrorCoor(pos[i], _extent[i]);
        }
    }

    
    /**
     * Forces a coordinate-value inside the grid. If the grid
     * is left the coordinate-value is mirrored back in.
     *
     * @param idx The dimension-index
     * @param pos The coordinate-value.
     * @return  The mirrored coordinate
     */    
    public final int mirrorCoordinate(final int idx, final int pos)
    {
        return mirrorCoor(pos, _extent[idx]);
    }
    

    /**
     * Forces a coordinate-value inside the grid. If the grid
     * is left on one border the coordinate-value reenters the grid
     * on the opposite border.
     *
     * @param pos The coordinate-value.
     */    
    public final void tileCoordinate(final int[] pos)
    {
        for(int i = 0; i < pos.length; i++)
        {
            pos[i] = tileCoor(pos[i], _extent[i]);
        }        
    }
    
    /**
     * Forces a coordinate-value inside the grid. If the grid
     * is left on one border the coordinate-value reenters the grid
     * on the opposite border.
     *
     * @param idx The dimension-index
     * @param pos The coordinate-value.
     * @return The tiled coordinate-value
     */    
    public final int tileCoordinate(final int idx, final int pos)
    {
        return tileCoor(pos, _extent[idx]);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // Private section
    ///////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Determines if a coordinate is in range.
     *
     * @param x The coordinate-value to check.
     * @param _extent The _extent of the coordinate-dimension.
     * @return <code>true</code> if <code>x > -1</code> and <code>x < _extent</code>
     */
    private static boolean inRange(final int x, final int extent)
    {
        return x > -1 && x < extent;
    }

    
    /**
     * Forces a coordinate to a given _extent
     * 
     * @param x The coordinate-value.
     * @param _extent The _extent of the coordinate-dimension
     * @return The corrected coordinate
     */
    private static int forceToRng(final int x, final int extent)
    {
        if(x < 0)
        {
            return 0;
        }
        if(x >= extent)
        {
            return extent - 1;
        }
        return x;
    }
    
    
    /**
     * Forces a coordinate-value to the given _extent. If the _extent
     * is left the coordinate-value is mirrored back in.
     *
     * @param x The coordinate-value.
     * @param _extent The _extent of the coordinate-dimension.
     * @return The mirrored coordinate-value
     */
    private static int mirrorCoor(final int x, final int extent)
    {
        if(inRange(x, extent))
        {
            return x;
        }
        int nx = x;
        return nx < 0 ? -nx : 2 * extent - nx - 1;
    }

    /**
     * Forces a coordinate-value to the given _extent. If the _extent
     * is left on one border the coordinate-value reenters the _extent
     * on the opposite border.
     *
     * @param x The coordinate-value.
     * @param _extent The _extent of the coordinate-dimension.
     * @return The tiled coordinate-value
     */
    private static int tileCoor(final int x, final int extent)
    {
        int nx = x % extent;
        return nx < 0 ? nx + extent : nx;
    }    
    
    
}
