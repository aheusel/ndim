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

/**
 *
 * @author Alexander Heusel
 */
public class TupleMemLayout extends MemLayout
{

    private final int tupleIncr;
    private final int[] elementIncr;


    /**
     * Creates a <em>TupleMemLayout</em>.
     *
     * @param size The number of tuples in the linear storage.
     * @param nrElements The number of elements per tuple.
     * @param interleaved The storage-format of the elements.
     */
    public TupleMemLayout(final int dataType, final int size, final int nrElements, final boolean interleaved)
    {
        super(dataType);
        if(interleaved)
        {
            tupleIncr = nrElements;
            elementIncr = Arr.createAscendingIndexSet(nrElements);
        }
        else
        {
            tupleIncr = 1;
            elementIncr = Arr.createAscendingIndexSet(nrElements, size);
        }
    }

    private TupleMemLayout(final int dataType, final int tupleIncr, final int[] elementIncr)
    {
        super(dataType);
        this.tupleIncr = tupleIncr;
        this.elementIncr = elementIncr;
    }


    /**
     * Returns the tuple-increment {@latex$ d_t} for this MemLayout.
     *
     * @return The tuple-increment.
     */
    public final int tupleIncr()
    {
        return tupleIncr;
    }

    /**
     * Returns the element-increment {@latex$ d_{e_j}}.
     *
     * @param idx The index of the element.
     * @return The element-increment.
     */
    public final int elementIncr(final int idx)
    {
        return elementIncr[idx];
    }

    /**
     * Returns all element-increments {@latex$ d_{e_j}}.
     *
     * @return The element-increments.
     */
    public final int[] elementIncr()
    {
        return elementIncr.clone();
    }

    /**
     * Returns the number of elements per tuple
     *
     * @return The number of elements per tuple
     */
    public final int nrElements()
    {
        return elementIncr.length;
    }

    /**
     * Selects a subset of the elements of a MemLayout.
     *
     * @param memLayout The MemLayout to be used.
     * @param elemIdx The elements to select
     */
    public final MemLayout subset(final int... elemIdx)
    {
        final int[] newElementIncr = new int[elemIdx.length];
        Arr.coalesce(newElementIncr, elementIncr, elemIdx);
        return new TupleMemLayout(dataType, tupleIncr, newElementIncr);
    }

}
