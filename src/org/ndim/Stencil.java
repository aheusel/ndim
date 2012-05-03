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

/**
 * A class that performs a lexicographic iteration with given
 * start-coordinate.
 * 
 * {@example "Sample Usage"
 * int[] pos = {0, 0, 0};
 * Stencil it = new Stencil(100, 200, 300);
 * while(it.hasNext(pos))
 * {
 *    it.next(pos);
 *    doSomethingWith(pos);
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
        last = extent.length - 1;
    }

    /**
     * Create a Stencil which will start at <code>0</code> and will iterate <code>extent[i]</code>
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
        return new Stencil(extent);
    }


    /**
     * Determines if there are additional steps in the iteration
     * 
     * @return <code>true</code> if there are additional steps, <code>false</code> otherwise.
     */
    public final boolean hasNext(final int[] pos)
    {
        return pos[last] != extent[last];
    }

    /**
     * Goes to the next position of the iteration.
     */
    public final void next(final int[] pos)
    {
        // Go to the next element.
        for(int i = 0; i < pos.length; i++)
        {
            pos[i]++;
            if(pos[i] < extent[i])
            {
                return;
            }
            else
            {
                pos[i] = 0;
            }
        }
    }
}
