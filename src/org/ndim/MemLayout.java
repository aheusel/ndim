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
 * A <em>MemLayout</em> is a description of an arbitrary linear storage containing
 * a set of n-tuples succeding each other. There are two possiblities to store
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
 *	    <em>element-address</em> {@latex$ e_a}.
 *    <li>  The address of the <em>first</em> element of a tuple is
 *	    called the <em>tuple-address</em> {@latex$ t_a}.
 *    <li>  The address-distance between two succeeding tuples is called the
 *	    <em>tuple-increment</em> {@latex$ d_t}.
 *    <li>  The <em>element-increment</em> {@latex$ d_{e_j}} is the address-distance
 *	    between the first element of a tuple an the element with the index {@latex$ j}.
 * </ul>
 * 
 * }
 * 
 * Hence for a pair of integers {@latex$ i, j} the address {@latex$ t_a} of a tuple is given by:
 * 
 * <p align="center">{@latex[ t_{a_i} := d_t\cdot i}</p>
 * 
 * and the address {@latex$ e_a} of an element by:
 * 
 * <p align="center">{@latex[ e_{a_{i, j}} := d_t\cdot i + d_{e_j}}</p>
 * 
 * @author Alexander Heusel
 */
public abstract class MemLayout
{

    protected final int dataType;

    protected MemLayout(final int dataType)
    {
        this.dataType = dataType;
    }

    public final int dataType()
    {
        return dataType;
    }

    public final boolean isSigned()
    {
        return Arr.isSigned(dataType);
    }

}
