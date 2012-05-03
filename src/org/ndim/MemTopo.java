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
 * The <em>immutable</em> class <em>MemTopo</em> is a description of an arbitrary linear
 * storage containing a set of n-tuples succeding each other. There are two possiblities to store
 * the elements of the tuples in the linear storage:
 * 
 * <ul>
 *    <li> In an <em>interleaved</em> ordering the elements follow each other. For a 3D vector
 *         this can be visualized like this: {@latex$ (x_0y_0z_0), (x_1y_1z_1), (x_2y_2z_2)\dots}
 *    <li> In a <em>non-interleaved</em> ordering all elements of the n-tuples are stored in
 *         one block, i.e.: {@latex$ x_0, x_1, x_2 \dots y_ 0, y_2, y_3 \dots z_0, z_1, z_2 \dots}
 * </ul>
 * 
 * {@stickyInfo "Definition:"
 * 
 * <ul>
 *    <li>  We call the integer which locates an element of a tuple in a linear storage its
 *	    <em>element-address</em> {@latex$ a_e}.
 *    <li>  The integer which determines the position of an element inside a tuple is
 *          the <em>tuple-index</em> of the element.
 *    <li>  The element-address of the element with the tuple-index of zero is
 *	    called the <em>tuple-address</em> {@latex$ a_t}.
 *    <li>  The address-distance between two succeeding tuples is called the
 *	    <em>tuple-increment</em> {@latex$ d_t}.
 *    <li>  The <em>element-increment</em> {@latex$ d_{e}(j)} is the difference between
 *	    the element with the tuple-index {@latex$ j} and the tuple-address {@latex$ a_t}.
 * </ul>
 * 
 * }
 * 
 * Hence for a pair of integers {@latex$ i, j} the address {@latex$ a_t} of a tuple is given by:
 * 
 * <p align="center">{@latex[ a_{t}(i) := d_t\cdot i}</p>
 * 
 * and the address {@latex$ a_e} of an element by:
 * 
 * <p align="center">{@latex[ a_{e}(i, j) := d_t\cdot i + d_{e}(j)}</p>
 * 
 * @author Alexander Heusel
 */
public final class MemTopo
{

    private final int tupleIncr;
    private final int[] elementIncr;


    /**
     * Creates a <em>MemTopo</em>.
     * 
     * @param size The number of tuples in the linear storage.
     * @param nrElements The number of elements per tuple.
     * @param interleaved The storage-format of the elements.
     */
    public MemTopo(final int size, final int nrElements, final boolean interleaved)
    {
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

    private MemTopo(final int tupleIncr, final int[] elementIncr)
    {
        this.tupleIncr = tupleIncr;
        this.elementIncr = elementIncr;
    }


    /**
     * Returns the tuple-increment {@latex$ d_t} for this MemTopo.
     * 
     * @return The tuple-increment.
     */
    public final int tupleIncr()
    {
        return tupleIncr;
    }

    /**
     * Returns the element-increment {@latex$ d_{e}(j)}.
     * 
     * @param idx The index of the element.
     * @return The element-increment.
     */
    public final int elementIncr(int idx)
    {
        return elementIncr[idx];
    }

    /**
     * Returns all element-increments {@latex$ d_{e}(j)}.
     * 
     * @return The element-increments.
     */    
    public final int[] elementIncr()
    {
        return elementIncr.clone();
    }

    /**
     * Returns all element-increments {@latex$ d_{e}(j)} in the argument.
     * 
     * @param elementIncr Contains the element-increments after the call.
     */    
    public final void elementIncr(final int[] elementIncr)
    {
        System.arraycopy(this.elementIncr, 0, elementIncr, 0, this.elementIncr.length);
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
     * Selects a subset of the elements of a MemTopo.
     * 
     * @param MemTopo The MemTopo to be used.
     * @param elemIdx The elements to select
     */
    public final MemTopo subset(final int... elemIdx)
    {
        final int[] newElementIncr = new int[elemIdx.length];
        Arr.coalesce(newElementIncr, elementIncr, elemIdx);
        return new MemTopo(tupleIncr, newElementIncr);
    }



}
