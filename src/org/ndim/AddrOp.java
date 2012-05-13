/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 2012, ndim.org
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright notice, this 
 *   list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or
 *   other materials provided with the distribution.
 * - Neither the name of ndim nor the names of its contributors may
 *   be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.ndim;

import org.ndim.math.Vec;

/**
 *
 * @author Alexander Heusel
 */
public final class AddrOp
{

    private int _offset;
    private int[] _incr;
    private int[] _elementIncr;
    
    public AddrOp(final GridTopo gridTopo, final MemTopo memTopo)
    {
        set(gridTopo, memTopo);
    }
    
    public AddrOp(final GridTopo gridTopo)
    {
        set(gridTopo);
    }
    
    public final void set(final GridTopo gridTopo, final MemTopo memTopo)
    {
        _offset = gridTopo.offset()*memTopo.tupleIncr();
	_incr = Vec.mul(gridTopo.incr(), memTopo.tupleIncr());
	_elementIncr = memTopo.elementIncr();
    }
    
    public final void set(final GridTopo gridTopo)
    {
        _offset = gridTopo.offset();
	_incr = gridTopo.incr();
	_elementIncr = new int[]{0};        
    }
    
    public final void shift(final int incr)
    {
        _offset += incr;
    }
    
    public final int addr(final int[] pos)
    {
        return _offset +  (int)Vec.dot(_incr, pos);
    }

    public final int addr(final int[] pos, final int elemIdx)
    {
        return _offset + (int)Vec.dot(_incr, pos) + _elementIncr[elemIdx];
    }

    public final void incr(int[] incr)
    {
        System.arraycopy(_incr, 0, incr, 0, _incr.length);
    }
    
    
    public final int incr(final int idx)
    {
            return _incr[idx];
    }

    public final int nrElements()
    {
        return _elementIncr.length;
    }
    
    public final void elementIncr(int[] elementIncr)
    {
        System.arraycopy(_elementIncr, 0, elementIncr, 0, _elementIncr.length);
    }

    
    public final int elementIncr(final int idx)
    {
            return _elementIncr[idx];
    } 
    
    
}
