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

    protected final int[] _extent;
    protected int _nrEntities;

    /**
     */
    protected Grid(final int[] extent)
    {
        _extent = extent.clone();
        _nrEntities = (int) Vec.productOperator(extent);
    }

    /**
     * Returns a copy of the _extent of the grid
     * 
     * @return A copy of the _extent of the grid.
     */
    public final int[] extent()
    {
        return _extent.clone();
    }

    /**
     * Copies the _extent of the grid to the given array
     * 
     * @param _extent The array which contains the grid-_extent after the call.
     */
    public final void extent(final int[] extent)
    {
        System.arraycopy(_extent, 0, extent, 0, Math.min(extent.length, _extent.length));
    }

    /**
     * Returns the _extent of the <code>idx</code>-th dimension.
     *
     * @param idx The index of the dimension
     * @return The _extent of this dimension
     */
    public final int extent(int idx)
    {
        return _extent[idx];
    }

    /**
     * Returns the number of dimensions of the layout.
     *
     * @return The number of dimensions
     */
    public final int nrDims()
    {
        return _extent.length;
    }

    /**
     * Returns the number of entities in a field.
     *
     * @return The number of entities in a field.
     */
    public final int nrEntities()
    {
        return _nrEntities;
    }
    
}
