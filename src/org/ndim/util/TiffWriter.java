/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * copyright (c) 2007 - 2012
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
package org.ndim.util;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.ndim.GridTopo;
import org.ndim.MemTopo;

/**
 *
 * @author Alexander Heusel
 */
public final class TiffWriter
{

    ImageWriter writer;

    public TiffWriter()
    {
        writer = null;
    }

    /**
     * Creates a new writer from a {@link java.io.File} and a format-string.
     *
     * @param file The target file to write to.
     * @param format An image-format string supported by {@link javax.imageio.ImageIO}.
     */
    public TiffWriter(File file, String format) throws IOException
    {
        open(file, format);
    }

    /**
     * Opens a file for output
     *
     * @param file The target {@link java.io.File} to write to.
     * @param format An image-format string supported by {@link javax.imageio.ImageIO}.
     */
    public void open(File file, String format) throws IOException
    {
        Iterator writers = ImageIO.getImageWritersByFormatName(format);
        writer = (ImageWriter) writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(file);
        writer.setOutput(ios);
    }

    /**
     * Closes the current target-file
     */
    public void close() throws IOException
    {
        writer = null;
    }

    /**
     * Writes the content of the {@link MemLayout} to the current target-file
     * using the given {@link GridLayout}.
     *
     * @param layout The layout to use for the write-procedure.
     * @param tupleSet The source MemLayout.
     */
    
    public interface StorageProvider
    {
        public void writeToRaster(GridTopo gridTopo, MemTopo memTopo, WritableRaster raster);
    }
    
    public void write(GridTopo gridTopo, MemTopo memTopo, StorageProvider storage) throws IOException
    {
        int imageType;
        switch(memTopo.nrElements())
        {
            case 1:
                imageType = BufferedImage.TYPE_BYTE_GRAY;
                break;
            case 2:
                imageType = BufferedImage.TYPE_3BYTE_BGR;
                break;
            case 3:
                imageType = BufferedImage.TYPE_3BYTE_BGR;
                break;
            case 4:
                imageType = BufferedImage.TYPE_4BYTE_ABGR;
                break;
            default:
                throw new java.io.IOException("Unsupported number of elements!");
        }
        BufferedImage bi = new BufferedImage(gridTopo.extent(GridTopo.X), gridTopo.extent(GridTopo.Y), imageType);
        WritableRaster wr = bi.getRaster();
        IIOImage iio = new IIOImage(bi, null, null);
        
        

//        int nrImages = gridTopo.extent(GridTopo.Z);
//        int incrZ = gridTopo.incr(GridTopo.Z);
//        GridTopo slice = gridTopo.subspace(0, 1);
//
//        //memTopo.writeToRaster(gridTopo, wr);
//        storage.writeToRaster(gridTopo, memTopo, wr);
//        writer.write(null, iio, null);
//        gridTopo.setOffset(gridTopo.offset() + incrZ);
//        for(int i = 1; i < nrImages; i++)
//        {
//            //memTopo.writeToRaster(gridTopo, wr);
//            storage.writeToRaster(gridTopo, memTopo, wr);
//            if(writer.canInsertImage(-1))
//            {
//                writer.writeInsert(-1, iio, null);
//            }
//            else
//            {
//                throw new java.io.IOException("Writer can't append a second image!");
//            }
//            gridTopo.setOffset(gridTopo.offset() + incrZ);
//        }
    }
}
