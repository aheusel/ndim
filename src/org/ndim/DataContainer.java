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

import java.util.ArrayList;
import java.util.Observable;
import org.ndim.util.Pair;


/**
 *
 * @author Alexander Heusel
 */
public class DataContainer extends Observable
{
    
    public interface Allocator
    {
        public Object alloc(final int size, final Class cls);
        public void dealloc(Object mem);
    }
    
    public final static class StdAllocator implements Allocator
    {
        @Override
        public Object alloc(final int size, final Class cls)
        {
            if(!cls.isPrimitive())
            {
                throw new java.lang.IllegalArgumentException("Non-primitive class.");
            }

            if(cls.equals(byte.class))
            {
                return java.nio.ByteBuffer.allocate(size);
            }
            if(cls.equals(short.class))
            {
                return java.nio.ShortBuffer.allocate(size);
            }
            if(cls.equals(int.class))
            {
                return java.nio.IntBuffer.allocate(size);
            }
            if(cls.equals(long.class))
            {
                return java.nio.LongBuffer.allocate(size);
            }
            if(cls.equals(float.class))
            {
                return java.nio.FloatBuffer.allocate(size);
            }
            if(cls.equals(double.class))
            {
                return java.nio.DoubleBuffer.allocate(size);
            }
            throw new java.lang.IllegalArgumentException("Unknown primitive data-type.");
        }
        
        @Override
        public void dealloc(Object mem)
        {
            
        }
    }
    
    
    private final DataContainer.Allocator allocator;
    private final ArrayList<Pair<MemTopo, Object>> layers = new ArrayList<Pair<MemTopo, Object>>(); 
    private final GridTopo gridTopo;
    
    public DataContainer(final int... extent)
    {
        gridTopo = new GridTopo(extent);
        allocator = new DataContainer.StdAllocator();
    }
    
    public DataContainer(final GridTopo gridTopo)
    {
        this.gridTopo = gridTopo.clone();
        allocator = new DataContainer.StdAllocator();
    }
    
    public GridTopo gridTopo()
    {
        return gridTopo;
    }
    
    public Pair<MemTopo, Object> createLayer(Class cls, MemTopo memTopo)
    {
        Pair<MemTopo, Object> p = new Pair<MemTopo, Object>(memTopo, allocator.alloc(gridTopo.nrEntities()*memTopo.nrElements(), cls));
        layers.add(p);
        this.notifyObservers(p);
        return p;
    }
    
    public Pair<MemTopo, Object> removeLayer(final int idx)
    {
        Pair<MemTopo, Object> p = layers.remove(idx);
        this.notifyObservers(p);
        return p;
    }
    
    public final int nrLayers()
    {
        return layers.size();
    }
    
    public Pair<MemTopo, Object> layer(final int idx)
    {
        return layers.get(idx);
    }
    
    
    
}
