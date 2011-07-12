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
package org.ndim.math;

/**
 *
 * @author Alexander Heusel
 */
public class MathMisc
{

    public static float sqr(float a)
    {
        return a == 0.0f ? 0.0f : a * a;
    }

    public static double sqr(double a)
    {
        return a == 0.0 ? 0.0 : a * a;
    }

    public static float pythag(float a, float b)
    {
        float absa, absb;
        absa = Math.abs(a);
        absb = Math.abs(b);
        if(absa > absb)
        {
            return absa * (float) Math.sqrt(1.0f + sqr(absb / absa));
        }
        else
        {
            return (absb == 0.0f ? 0.0f : absb * (float) Math.sqrt(1.0f + sqr(absa / absb)));
        }
    }

    public static double pythag(double a, double b)
    {
        double absa, absb;
        absa = Math.abs(a);
        absb = Math.abs(b);
        if(absa > absb)
        {
            return absa * Math.sqrt(1.0 + sqr(absb / absa));
        }
        else
        {
            return (absb == 0.0 ? 0.0 : absb * Math.sqrt(1.0 + sqr(absa / absb)));
        }
    }

    public static float sign(float a, float b)
    {
        return (b >= 0.0f) ? Math.abs(a) : -Math.abs(a);
    }

    public static double sign(double a, double b)
    {
        return (b >= 0.0) ? Math.abs(a) : -Math.abs(a);
    }

    public static void bsplineKernel(float dx, float[] kernel, int kernelOffset)
    {
        kernel[kernelOffset + 0] = r(-1.0f - dx);
        kernel[kernelOffset + 1] = r(0.0f - dx);
        kernel[kernelOffset + 2] = r(1.0f - dx);
        kernel[kernelOffset + 3] = r(2.0f - dx);
    }

    public static float bspline(float dx, float[] source, int sourceOffset, int sourceIncr)
    {
        return  source[sourceOffset + 0*sourceIncr]*r(-1.0f - dx) +
                source[sourceOffset + 1*sourceIncr]*r(0.0f - dx) +
                source[sourceOffset + 2*sourceIncr]*r(1.0f - dx) +
                source[sourceOffset + 3*sourceIncr]*r(2.0f - dx);
    }

    public static void bsplineKernel(double dx, double[] kernel, int kernelOffset)
    {
        kernel[kernelOffset + 0] = r(-1.0f - dx);
        kernel[kernelOffset + 1] = r(0.0f - dx);
        kernel[kernelOffset + 2] = r(1.0f - dx);
        kernel[kernelOffset + 3] = r(2.0f - dx);
    }

    public static double bspline(double dx, double[] source, int sourceOffset, int sourceIncr)
    {
        return  source[sourceOffset + 0*sourceIncr]*r(-1.0f - dx) +
                source[sourceOffset + 1*sourceIncr]*r(0.0f - dx) +
                source[sourceOffset + 2*sourceIncr]*r(1.0f - dx) +
                source[sourceOffset + 3*sourceIncr]*r(2.0f - dx);
    }

    private static float p(float x)
    {
        return x > 0.0f ? x : 0.0f;
    }

    private static float r(float x)
    {
        float p4 = p(x + 2);
        float p3 = p(x + 1);
        float p2 = p(x);
        float p1 = p(x - 1);
        return (p4 * p4 * p4 - 4.0f * p3 * p3 * p3 + 6.0f * p2 * p2 * p2 - 4.0f * p1 * p1 * p1) / 6.0f;
    }

    private static double p(double x)
    {
        return x > 0.0 ? x : 0.0;
    }

    private static double r(double x)
    {
        double p4 = p(x + 2);
        double p3 = p(x + 1);
        double p2 = p(x);
        double p1 = p(x - 1);
        return (p4 * p4 * p4 - 4.0 * p3 * p3 * p3 + 6.0 * p2 * p2 * p2 - 4.0 * p1 * p1 * p1) / 6.0;
    }


}
