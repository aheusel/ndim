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

import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


/**
 *
 * @author Alexander Heusel
 */
public final class TiffCODEC implements CODEC
{

    private class TiffLayerReader implements CODEC.LayerReader
    {

        private ImageReader reader;
        private boolean hasNext = false;

        public TiffLayerReader(ImageReader reader)
        {
            this.reader = reader;
        }

        public final boolean hasNext()
        {
            return hasNext;
        }

        public final void next(Image image)
        {
            int incrZ = layout.incr(GridLayout.Z);
            layout.set(layout, Arr.createIndexSet(2));

            for(int i = 0; i < nrImages; i++)
            {

                tupleSet.readFromRaster(layout, reader.read(i).getData());
                layout.setOffset(layout.offset() + incrZ);
            }

        }

    }

    private TiffLayerReader reader = null;
    private GridLayout gridLayout = null;


    public TiffCODEC()
    {}

    public final void open(Object source, final char mode) throws IOException
    {
        if(mode == 'r')
        {
            Iterator readers = ImageIO.getImageReadersByFormatName("tif");
            ImageReader ir = (ImageReader) readers.next();
            ImageInputStream iis = ImageIO.createImageInputStream(source);
            ir.setInput(iis, false);
            int nrImages = ir.getNumImages(true);
            if(nrImages < 2)
            {
                gridLayout = new GridLayout(ir.getWidth(0), ir.getHeight(0));
            }
            else
            {
                gridLayout = new GridLayout(ir.getWidth(0), ir.getHeight(0), nrImages);
            }
            reader = new TiffLayerReader(ir);
        }
        else if(mode == 'w')
        {
        }
        else
        {
            throw new java.lang.IllegalArgumentException("Unknown mode of operation!");
        }
    }

    public final void close()
    {
        reader = null;
        gridLayout = null;
    }

    public final GridLayout getGridLayout()
    {
        return gridLayout;
    }

    public LayerReader getLayerReader()
    {
        return reader;
    }

    public void writeImage(Image image)
    {
        if(reader != null)
        {
            throw new java.lang.IllegalStateException("CODEC in wrong mode for operation!");
        }
    }

}
