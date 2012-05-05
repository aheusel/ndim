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

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.TIFFEncodeParam;
import java.awt.image.DataBuffer;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.*;
import java.util.ArrayList;
import java.util.List;
import javax.media.jai.RasterFactory;
import javax.media.jai.TiledImage;
import org.ndim.DataContainer.Allocator;
import org.ndim.util.Pair;

/**
 *
 * @author Alexander Heusel
 */
public class TiffCODEC implements CODEC
{
    private static class TiffReader implements CODEC.Reader
    {
        public TiffReader(final String fname)
        {
        }
        
        @Override
        public Pair<GridTopo, ArrayList<MemTopo>> readHeader()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void readTo(DataContainer data)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public DataContainer read()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public DataContainer read(Allocator alloc)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    private static class TiffWriter implements CODEC.Writer
    {
        private FileOutputStream out;
        public TiffWriter(final String fname) throws IOException
        {
            out = new FileOutputStream(fname); 
        }

        @Override
        public void write(DataContainer data) throws java.io.IOException
        {
            GridTopo gridTopo = data.gridTopo();

            int width = gridTopo.extent(GridTopo.X);
            int height = gridTopo.extent(GridTopo.Y);
            int depth = gridTopo.extent(GridTopo.Z);
                 
            // Create a simple model with number of bands equal to the depth of the volume image.
            final MemTopo memTopo = data.layer(0).v1;
            final Object buffer = data.layer(0).v2;
            
            final int zIncr = gridTopo.incr(GridTopo.Z);
            gridTopo = gridTopo.subspace(GridTopo.X, GridTopo.Y);
            
                    
            TIFFEncodeParam params = new TIFFEncodeParam();
            ImageEncoder encoder = ImageCodec.createImageEncoder("tiff", out, params);
            List<RenderedImage> imageList = new ArrayList<RenderedImage>();
            final TiledImage cover = writeImage(gridTopo, memTopo, data);
            for(int i = 1; i < depth; i++)
            {
                gridTopo = gridTopo.shift(zIncr);
                imageList.add(writeImage(gridTopo, memTopo, data)); 
            }
            params.setExtraImages(imageList.iterator()); 
            encoder.encode(cover);
            out.close();
          
        }
        
        
        
        private static TiledImage writeImage(final GridTopo gridTopo, final MemTopo memTopo, final Object data)
        {
            final int width = gridTopo.extent(GridTopo.X);
            final int height = gridTopo.extent(GridTopo.Y);
            final int samples = memTopo.nrElements();
            
            final int[] pos = new int[2];
            final Stencil iter = new Stencil(gridTopo.extent());
            
            if(data instanceof byte[])
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_BYTE ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final byte[] buff = (byte[])data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff[gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)]);
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof ByteBuffer)
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_BYTE ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final ByteBuffer buff = (ByteBuffer)data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff.get(gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)));
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            
            if(data instanceof short[])
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_SHORT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final short[] buff = (short[])data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff[gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)]);
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof ShortBuffer)
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_SHORT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final ShortBuffer buff = (ShortBuffer)data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff.get(gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)));
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            if(data instanceof int[])
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_INT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final int[] buff = (int[])data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff[gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)]);
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof IntBuffer)
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_INT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final IntBuffer buff = (IntBuffer)data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (int)buff.get(gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)));
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof long[] || data instanceof LongBuffer)
            {
                throw new java.lang.UnsupportedOperationException("Unsupported datatype.");
            }
            
            
            if(data instanceof float[])
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_FLOAT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final float[] buff = (float[])data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (float)buff[gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)]);
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof FloatBuffer)
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_FLOAT ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final FloatBuffer buff = (FloatBuffer)data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (float)buff.get(gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)));
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            if(data instanceof double[])
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_DOUBLE ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final double[] buff = (double[])data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (double)buff[gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)]);
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            if(data instanceof DoubleBuffer)
            {
                SampleModel sampleModel = 
                    RasterFactory.createBandedSampleModel(DataBuffer.TYPE_DOUBLE ,width, height, samples);
                final TiledImage tiledImage = new TiledImage(0,0,width,height,0,0,sampleModel,null);
                
                final DoubleBuffer buff = (DoubleBuffer)data;
                while(iter.hasNext(pos))
                {
                    for(int i = 0; i < memTopo.nrElements(); i++)
                    {
                        tiledImage.setSample(pos[GridTopo.X], pos[GridTopo.Y], i,
                                (double)buff.get(gridTopo.addr(pos)*memTopo.tupleIncr() + memTopo.elementIncr(i)));
                    }
                    
                    iter.next(pos);
                }
                return tiledImage;
            }
            
            throw new java.lang.UnsupportedOperationException("Unsupported datatype.");
        }
        
    }
    
    
    private static boolean registered = register();
            
    private static boolean register()
    {
        TiffCODEC codec = new TiffCODEC();
        CODECRegistry.getInstance().put("tif", codec);
        CODECRegistry.getInstance().put("tiff", codec);
        CODECRegistry.getInstance().put("TIF", codec);
        CODECRegistry.getInstance().put("TIFF", codec);
        return true;
    }
    
    private TiffCODEC()
    {
    }

    @Override
    public CODEC.Reader read(String fname) throws java.io.IOException
    {
        return new TiffReader(fname);
    }

    @Override
    public CODEC.Writer write(String fname) throws java.io.IOException
    {
        return new TiffWriter(fname);
    }
    
}
