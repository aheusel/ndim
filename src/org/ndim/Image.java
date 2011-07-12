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
 *
 * @author Alexander Heusel
 */
public class Image
{
    public class Layer
    {
        
        private final MemLayout memLayout;
        private final Object data;
        private final boolean signed;
        
        public Layer(final MemLayout memLayout, final Object data, final boolean signed)
        {
            this.memLayout = memLayout;
            this.data = data;
            this.signed = signed;
        }

        public final Object data()
        {
            return data;
        }

        public final MemLayout memLayout()
        {
            return memLayout;
        }

        public final GridLayout gridLayout()
        {
            return Image.this.gridLayout;
        }

        public final boolean isSigned()
        {
            return signed;
        }

        public final Image getImage()
        {
            return Image.this;
        }
    }

    private final GridLayout gridLayout;
    private final java.util.ArrayList<Layer> layers = new java.util.ArrayList<Layer>();


    public Image(final GridLayout gridLayout)
    {
        this.gridLayout = gridLayout;
    }

    public final GridLayout gridLayout()
    {
        return gridLayout;
    }

    public Layer addLayer(final MemLayout memLayout, final Object data, final boolean signed)
    {
        final Layer result = new Layer(memLayout, data, signed);
        layers.add(result);
        return result;
    }

    public void removeLayer(final Layer layer)
    {
        layers.remove(layer);

    }

    public final Layer getLayer(final int idx)
    {
        return layers.get(idx);
    }

}
