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

import org.ndim.util.IdxValPair;

/**
 * This class contains methods for vector algebra.
 * 
 * 
 * @author Alexander Heusel
 */
public class Vec
{

    /**
     * Adds a scalar to every element of an a.
     * 
     * @param offset The index offset to the first element.
     * @param length The number of element of the vector.
     * @param source The a to which the scalar shall be added.
     * @param alpha The scalar.
     * return The parameter vector.
     */
    public static byte[] add(final int offset, final int length, final byte[] a, final byte alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    public static short[] add(final int offset, final int length, final short[] a, final short alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    public static int[] add(final int offset, final int length, final int[] a, final int alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    public static long[] add(final int offset, final int length, final long[] a, final long alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    public static float[] add(final int offset, final int length, final float[] a, final float alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    public static double[] add(final int offset, final int length, final double[] a, final double alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] += alpha;
        }
        return a;
    }

    /**
     * Adds a scalar to every element of an a.
     * 
     * @param a The a to which the scalar shall be added.
     * @param alpha The scalar.
     * @return The parameter vector.
     */
    public static byte[] add(final byte[] a, final byte alpha)
    {
        return add(0, a.length, a, alpha);
    }

    public static short[] add(final short[] a, final short alpha)
    {
        return add(0, a.length, a, alpha);
    }

    public static int[] add(final int[] a, final int alpha)
    {
        return add(0, a.length, a, alpha);
    }

    public static long[] add(final long[] a, final long alpha)
    {
        return add(0, a.length, a, alpha);
    }

    public static float[] add(final float[] a, final float alpha)
    {
        return add(0, a.length, a, alpha);
    }

    public static double[] add(final double[] a, final double alpha)
    {
        return add(0, a.length, a, alpha);
    }

    /**
     * Adds two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} + \vec{b}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param length The length of the vectors.
     * @param a The first vector.
     * @param b The second vector.
     * @return The left-hand-side.
     */
    public static byte[] add(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    public static short[] add(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    public static int[] add(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    public static long[] add(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    public static float[] add(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    public static double[] add(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += b[offb + i];
        }
        return a;
    }

    /**
     * Adds two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} + \vec{b}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @return The left-hand-side.
     */
    public static byte[] add(final byte[] a, final byte[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    public static short[] add(final short[] a, final short[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    public static int[] add(final int[] a, final int[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    public static long[] add(final long[] a, final long[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    public static float[] add(final float[] a, final float[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    public static double[] add(final double[] a, final double[] b)
    {
        return add(0, 0, a.length, a, b);
    }

    /**
     * Adds two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} + \vec{c}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param offc The offset for vector c.
     * @param length The length of the vectors.
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     * @return The result-vector
     */
    public static byte[] add(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] + c[offc + i]);
        }
        return a;
    }

    public static short[] add(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] + c[offc + i]);
        }
        return a;
    }

    public static int[] add(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
        return a;
    }

    public static long[] add(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
        return a;
    }

    public static float[] add(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
        return a;
    }

    public static double[] add(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
        return a;
    }

    /**
     * Adds two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} + \vec{c}}
     * 
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     * @return The result-vector
     */
    public static byte[] add(final byte[] a, final byte[] b, final byte[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    public static short[] add(final short[] a, final short[] b, final short[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    public static int[] add(final int[] a, final int[] b, final int[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    public static long[] add(final long[] a, final long[] b, final long[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    public static float[] add(final float[] a, final float[] b, final float[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    public static double[] add(final double[] a, final double[] b, final double[] c)
    {
        return add(0, 0, 0, a.length, a, b, c);
    }

    /**
     * Adds a vector multiplied by a scalar to another vectors. The result of
     * the operation is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} + \alpha\cdot\vec{b}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param length The length of the vectors.
     * @param a The first vector.
     * @param b The second vector.
     * @param alpha The scalar.
     * @return The left-hand-side.
     */
    public static byte[] addMul(final int offa, final int offb, final int length, final byte[] a, final byte[] b, final byte alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    public static short[] addMul(final int offa, final int offb, final int length, final short[] a, final short[] b, final short alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    public static int[] addMul(final int offa, final int offb, final int length, final int[] a, final int[] b, final int alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    public static long[] addMul(final int offa, final int offb, final int length, final long[] a, final long[] b, final long alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    public static float[] addMul(final int offa, final int offb, final int length, final float[] a, final float[] b, final float alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    public static double[] addMul(final int offa, final int offb, final int length, final double[] a, final double[] b, final double alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] += alpha * b[offb + i];
        }
        return a;
    }

    /**
     * Adds a vector multiplied by a scalar to another vectors. The result of
     * the operation is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} + \alpha\cdot\vec{b}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @param alpha The scalar.
     * @return The left-hand-side.
     */
    public static byte[] addMul(final byte[] a, final byte[] b, final byte alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    public static short[] addMul(final short[] a, final short[] b, final short alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    public static int[] addMul(final int[] a, final int[] b, final int alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    public static long[] addMul(final long[] a, final long[] b, final long alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    public static float[] addMul(final float[] a, final float[] b, final float alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    public static double[] addMul(final double[] a, final double[] b, final double alpha)
    {
        return addMul(0, 0, a.length, a, b, alpha);
    }

    /**
     * Adds a vector multiplied by a scalar to another vectors. The result of
     * the operation is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} + \alpha\cdot\vec{c}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param offc The offset for vector c.
     * @param length The length of the vectors.
     * @param a The first vector.
     * @param b The second vector.
     * @param c The third vector.
     * @param alpha The scalar.
     * @return The left-hand-side.
     */
    public static byte[] addMul(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c, final byte alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] + alpha * c[offc + i]);
        }
        return a;
    }
    
    public static short[] addMul(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c, final short alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] + alpha * c[offc + i]);
        }
        return a;
    }
    
    public static int[] addMul(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c, final int alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + alpha * c[offc + i];
        }
        return a;
    }

    public static long[] addMul(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c, final long alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + alpha * c[offc + i];
        }
        return a;
    }

    public static float[] addMul(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c, final float alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + alpha * c[offc + i];
        }
        return a;
    }
    
    public static double[] addMul(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c, final double alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + alpha * c[offc + i];
        }
        return a;
    }

    /**
     * Adds a vector multiplied by a scalar to another vectors. The result of
     * the operation is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} + \alpha\cdot\vec{c}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @param c The third vector.
     * @param alpha The scalar.
     * @return The left-hand-side.
     */
    public static byte[] addMul(final byte[] a, final byte[] b, final byte[] c, final byte alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    public static short[] addMul(final short[] a, final short[] b, final short[] c, final short alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    public static int[] addMul(final int[] a, final int[] b, final int[] c, final int alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    public static long[] addMul(final long[] a, final long[] b, final long[] c, final long alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    public static float[] addMul(final float[] a, final float[] b, final float[] c, final float alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    public static double[] addMul(final double[] a, final double[] b, final double[] c, final double alpha)
    {
        return addMul(0, 0, 0, a.length, a, b, c, alpha);
    }

    /**
     * Subtracts two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} - \vec{b}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param length The length of the vectors.
     * @param a The first vector.
     * @param b The second vector.
     * @return The left-hand-side.
     */
    public static byte[] sub(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    public static short[] sub(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    public static int[] sub(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    public static long[] sub(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    public static float[] sub(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    public static double[] sub(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] -= b[offb + i];
        }
        return a;
    }

    /**
     * Subtracts two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} - \vec{b}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @return The left-hand-side.
     */
    public static byte[] sub(final byte[] a, final byte[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    public static short[] sub(final short[] a, final short[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    public static int[] sub(final int[] a, final int[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    public static long[] sub(final long[] a, final long[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    public static float[] sub(final float[] a, final float[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    public static double[] sub(final double[] a, final double[] b)
    {
        return sub(0, 0, a.length, a, b);
    }

    /**
     * Subtracts two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} - \vec{c}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param offc The offset for vector c.
     * @param length The length of the vectors.
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     * @return Returns the lhs
     */
    public static byte[] sub(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] - c[offc + i]);
        }
        return a;
    }

    public static short[] sub(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] - c[offc + i]);
        }
        return a;
    }

    public static int[] sub(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
        return a;
    }

    public static long[] sub(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
        return a;
    }

    public static float[] sub(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
        return a;
    }

    public static double[] sub(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
        return a;
    }

    /**
     * Subtracts two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{b} - \vec{c}}
     * 
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     */
    public static byte[] sub(final byte[] a, final byte[] b, final byte[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    public static short[] sub(final short[] a, final short[] b, final short[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    public static int[] sub(final int[] a, final int[] b, final int[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    public static long[] sub(final long[] a, final long[] b, final long[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    public static float[] sub(final float[] a, final float[] b, final float[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    public static double[] sub(final double[] a, final double[] b, final double[] c)
    {
        return sub(0, 0, 0, a.length, a, b, c);
    }

    
    /**
     * Scales every element of an a by a given factor, i.e.<br>
     * 
     * {@latex[ \vec{a} = \alpha \cdot \vec{b}}
     * 
     * @param offa The offset of the first element of the vector a.
     * @param offb The offset of the first element of the vector b.
     * @param length The length of the operand-vectors.
     * @param a The target vector.
     * @param b The source vector.
     * @param alpha The mul factor.
     * @return The target-vector
     */
    public static byte[] mul(final int offa, final int offb, final int length, final byte[] a, final byte[] b, final byte alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = (byte) (alpha * b[offb + i]);
        }
        return a;
    }

    public static short[] mul(final int offa, final int offb, final int length, final short[] a, final short[] b, final short alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = (short) (alpha * b[offb + i]);
        }
        return a;
    }

    public static int[] mul(final int offa, final int offb, final int length, final int[] a, final int[] b, final int alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
        return a;
    }

    public static long[] mul(final int offa, final int offb, final int length, final long[] a, final long[] b, final long alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
        return a;
    }

    public static float[] mul(final int offa, final int offb, final int length, final float[] a, final float[] b, final float alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
        return a;
    }

    public static double[] mul(final int offa, final int offb, final int length, final double[] a, final double[] b, final double alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
        return a;
    }

    /**
     * Scales every element of an a by a given factor, i.e.<br>
     * 
     * {@latex[ \vec{a} = \alpha \cdot \vec{b}}
     * 
     * @param a The target vector.
     * @param b The source vector.
     * @param alpha The mul factor.
     * @return The target-vector
     */
    public static byte[] mul(final byte[] a, final byte[] b, final byte alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }

    public static short[] mul(final short[] a, final short[] b, final short alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }

    public static int[] mul(final int[] a, final int[] b, final int alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }

    public static long[] mul(final long[] a, final long[] b, final long alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }

    public static float[] mul(final float[] a, final float[] b, final float alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }

    public static double[] mul(final double[] a, final double[] b, final double alpha)
    {
        return mul(0, 0, a.length, a, b, alpha);
    }
    
    /**
     * Multiplies the elements in a segment of a vector with a scalar. The multiplication
     * is in-place.
     * 
     * @param offset The index offset to the first element.
     * @param length The number of element of the vector.
     * @param source The a which will be multiplied
     * @param alpha The scalar.
     * return The parameter vector.
     */
    public static byte[] mul(final int offset, final int length, final byte[] a, final byte alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    public static short[] mul(final int offset, final int length, final short[] a, final short alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    public static int[] mul(final int offset, final int length, final int[] a, final int alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    public static long[] mul(final int offset, final int length, final long[] a, final long alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    public static float[] mul(final int offset, final int length, final float[] a, final float alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    public static double[] mul(final int offset, final int length, final double[] a, final double alpha)
    {
        for(int i = offset; i < offset + length; i++)
        {
            a[i] *= alpha;
        }
        return a;
    }

    /**
     * Multiplies every element of a vector with a scalar. The multiplication
     * is in-place.
     * 
     * @param a The vector which will be multiplied.
     * @param alpha The scalar.
     * @return The parameter vector.
     */
    public static byte[] mul(final byte[] a, final byte alpha)
    {
        return mul(0, a.length, a, alpha);
    }

    public static short[] mul(final short[] a, final short alpha)
    {
        return mul(0, a.length, a, alpha);
    }

    public static int[] mul(final int[] a, final int alpha)
    {
        return mul(0, a.length, a, alpha);
    }

    public static long[] mul(final long[] a, final long alpha)
    {
        return mul(0, a.length, a, alpha);
    }

    public static float[] mul(final float[] a, final float alpha)
    {
        return mul(0, a.length, a, alpha);
    }

    public static double[] mul(final double[] a, final double alpha)
    {
        return mul(0, a.length, a, alpha);
    }
    
    /**
     * Calculates the dot-product of the two vectors.
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param length The length of the vectors.
     * @param a The first vector.
     * @param b The second vector.
     * @return The dot-product of the two vectors
     */
    public static long dot(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        long res = 0;
        for(int i = 0; i < length; i++)
        {
            res += (long)a[offa + i]*(long)b[offb + i];
        }
        return res;
    }

    public static long dot(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        long res = 0;
        for(int i = 0; i < length; i++)
        {
            res += (long)a[offa + i]*(long)b[offb + i];
        }
        return res;
    }

    public static long dot(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        long res = 0;
        for(int i = 0; i < length; i++)
        {
            res += (long)a[offa + i]*(long)b[offb + i];
        }
        return res;
    }

    public static double dot(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        double res = 0;
        for(int i = 0; i < length; i++)
        {
            res += (double)a[offa + i]*(double)b[offb + i];
        }
        return res;
    }    
    
    public static double dot(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        double res = 0;
        for(int i = 0; i < length; i++)
        {
            res += (double)a[offa + i]*(double)b[offb + i];
        }
        return res;
    }
    
    public static double dot(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        double res = 0;
        for(int i = 0; i < length; i++)
        {
            res += a[offa + i]*b[offb + i];
        }
        return res;
    }
    
    /**
     * Calculates the dot-product of the two vectors.
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @return The dot-product of the two vectors
     */
    public static long dot(final byte[] a, final byte[] b)
    {
        return dot(0, 0, a.length, a, b);
    }

    public static long dot(final short[] a, final short[] b)
    {
        return dot(0, 0, a.length, a, b);
    }

    public static long dot(final int[] a, final int[] b)
    {
        return dot(0, 0, a.length, a, b);
    }

    public static double dot(final long[] a, final long[] b)
    {
        return dot(0, 0, a.length, a, b);
    }    
    
    public static double dot(final float[] a, final float[] b)
    {
        return dot(0, 0, a.length, a, b);
    }    
    
    public static double dot(final double[] a, final double[] b)
    {
        return dot(0, 0, a.length, a, b);
    }    

    
    /**
     * Calculates {@latex$ \lVert\vec{a}\rVert^2} of a vector.
     * 
     * @param offset The offset to the first element of the vector.
     * @param length The length of the vector.
     * @param a The vector.
     * @return {@latex$ \lVert\vec{a}\rVert^2}
     */
    public static double normSquare2(final int offset, final int length, final byte[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    public static double normSquare2(final int offset, final int length, final short[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    public static double normSquare2(final int offset, final int length, final int[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    public static double normSquare2(final int offset, final int length, final long[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    public static double normSquare2(final int offset, final int length, final float[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    public static double normSquare2(final int offset, final int length, final double[] a)
    {
        double res = 0.0;
        double buff;
        for(int i = offset; i < offset + length; i++)
        {
            buff = a[i];
            res += buff * buff;
        }
        return res;
    }

    /**
     * Calculates {@latex$ \lVert\vec{a}\rVert^2} of a vector.
     * 
     * @param a The vector.
     * @return {@latex$ \lVert\vec{a}\rVert^2}
     */
    public static double normSquare2(final byte[] a)
    {
        return normSquare2(0, a.length, a);
    }

    public static double normSquare2(final short[] a)
    {
        return normSquare2(0, a.length, a);
    }

    public static double normSquare2(final int[] a)
    {
        return normSquare2(0, a.length, a);
    }

    public static double normSquare2(final long[] a)
    {
        return normSquare2(0, a.length, a);
    }

    public static double normSquare2(final float[] a)
    {
        return normSquare2(0, a.length, a);
    }

    public static double normSquare2(final double[] a)
    {
        return normSquare2(0, a.length, a);
    }

    /**
     * Calculates {@latex$ \lVert\vec{a}\rVert_2 } of a vector.
     * 
     * @param offset The offset to the first element of the vector.
     * @param length The length of the vector.
     * @param a The vector.
     * @return {@latex$ \lVert\vec{a}\rVert_2 }
     */
    public static double norm2(final int offset, final int length, final byte[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    public static double norm2(final int offset, final int length, final short[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    public static double norm2(final int offset, final int length, final int[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    public static double norm2(final int offset, final int length, final long[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    public static double norm2(final int offset, final int length, final float[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    public static double norm2(final int offset, final int length, final double[] a)
    {
        return Math.sqrt(normSquare2(offset, length, a));
    }

    /**
     * Calculates {@latex$ \lVert\vec{a}\rVert_2 } of a vector.
     * 
     * @param a The vector.
     * @return {@latex$ \lVert\vec{a}\rVert_2 }
     */
    public static double norm2(final byte[] a)
    {
        return norm2(0, a.length, a);
    }

    public static double norm2(final short[] a)
    {
        return norm2(0, a.length, a);
    }

    public static double norm2(final int[] a)
    {
        return norm2(0, a.length, a);
    }

    public static double norm2(final long[] a)
    {
        return norm2(0, a.length, a);
    }

    public static double norm2(final float[] a)
    {
        return norm2(0, a.length, a);
    }

    public static double norm2(final double[] a)
    {
        return norm2(0, a.length, a);
    }

    /**
     * Calculates the euclidean distance between two vectors.<br>
     * 
     * {@latex[ \lVert\vec{a} - \vec{b}\rVert_2 }
     * 
     * @param offa The offset to the first element of the first vector
     * @param offa The offset to the first element of the second vector
     * @param length The length of the both vectors.
     * @param a The first vector
     * @param b The second vector
     * @return {@latex[ \lVert\vec{a} - \vec{b}\rVert_2 }
     */
    public static double euclDist(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = (double) a[offa + i] - (double) b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    public static double euclDist(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = (double) a[offa + i] - (double) b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    public static double euclDist(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = (double) a[offa + i] - (double) b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    public static double euclDist(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = (double) a[offa + i] - (double) b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    public static double euclDist(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = (double) a[offa + i] - (double) b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    public static double euclDist(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        double res = 0;
        double buff;
        for(int i = 0; i < length; i++)
        {
            buff = a[offa + i] - b[offb + i];
            res += buff * buff;
        }
        return Math.sqrt(res);
    }

    /**
     * Calculates the euclidean distance between two vectors.<br>
     * 
     * {@latex[ \lVert\vec{a} - \vec{b}\rVert_2 }
     * 
     * @param a The first vector
     * @param b The second vector
     * @return {@latex[ \lVert\vec{a} - \vec{b}\rVert_2 }
     */
    public static double euclDist(final byte[] a, final byte[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    public static double euclDist(final short[] a, final short[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    public static double euclDist(final int[] a, final int[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    public static double euclDist(final long[] a, final long[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    public static double euclDist(final float[] a, final float[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    public static double euclDist(final double[] a, final double[] b)
    {
        return euclDist(0, 0, a.length, a, b);
    }

    /**
     * Performs the elementwise multiplication of two vectors.
     * The result of the operation is assigned to the left-hand side, i.e.<br>
     * 
     * {@latex[ a_{i} := b_{i} \cdot c_{i}}
     * 
     * @param offa The offset to the first element of the vector a.
     * @param offb The offset to the first element of the vector b.
     * @param offc The offset to the first element of the vector c.
     * @param length The length of the vectors.
     * @param a The target vector.
     * @param b The first source vector.
     * @param c The second source vector.
     * @return The target-vector
     */
    public static byte[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] * c[offc + i]);
        }
        return a;
    }

    public static short[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] * c[offc + i]);
        }
        return a;
    }

    public static int[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
        return a;
    }

    public static long[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
        return a;
    }

    public static float[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
        return a;
    }

    public static double[] elementwiseMul(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
        return a;
    }

    /**
     * Performs the elementwise multiplication of two vectors.
     * The result of the operation is assigned to the left-hand side, i.e.<br>
     * 
     * {@latex[ a_{i} := b_{i} \cdot c_{i}}
     * 
     * @param a The target vector.
     * @param b The first source vector.
     * @param c The second source vector.
     * @param The target-vector
     */
    public static byte[] elementwiseMul(final byte[] a, final byte[] b, final byte[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static short[] elementwiseMul(final short[] a, final short[] b, final short[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static int[] elementwiseMul(final int[] a, final int[] b, final int[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static long[] elementwiseMul(final long[] a, final long[] b, final long[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static float[] elementwiseMul(final float[] a, final float[] b, final float[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static double[] elementwiseMul(final double[] a, final double[] b, final double[] c)
    {
        return elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    /**
     * Performs the elementwise multiplication of two vectors.
     * The result of the operation is assigned to the left-hand side, i.e.<br>
     * 
     * {@latex[ a_{i} := a_{i} \cdot b_{i}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     * @return The first vector
     */
    public static byte[] elementwiseMul(final byte[] a, final byte[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static short[] elementwiseMul(final short[] a, final short[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static int[] elementwiseMul(final int[] a, final int[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static long[] elementwiseMul(final long[] a, final long[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static float[] elementwiseMul(final float[] a, final float[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static double[] elementwiseMul(final double[] a, final double[] b)
    {
        return elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    /**
     * Calculates the product-operator for the elements of the a, i.e.<br>
     * 
     * {@latex[ \prod_{i = o_{a}}^{o_{a} + l_{a} - 1} a_{i} }
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements.
     * @param a The a of values
     * @return The product of the values.
     */
    public static int productOperator(final int offset, final int length, final byte[] a)
    {
        int res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    public static int productOperator(final int offset, final int length, final short[] a)
    {
        int res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    public static long productOperator(final int offset, final int length, final int[] a)
    {
        long res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    public static long productOperator(final int offset, final int length, final long[] a)
    {
        long res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    public static double productOperator(final int offset, final int length, final float[] a)
    {
        double res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    public static double productOperator(final int offset, final int length, final double[] a)
    {
        double res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res *= a[i];
        }
        return res;
    }

    /**
     * Calculates the product-operator for the elements of the a, i.e.<br>
     * 
     * {@latex[ \prod_{i = 0}^{l_{a}-1} a_{i} }
     * 
     * @param a The a of values
     * @return The product of the values.
     */
    public static int productOperator(final byte[] a)
    {
        return productOperator(0, a.length, a);
    }

    public static int productOperator(final short[] a)
    {
        return productOperator(0, a.length, a);
    }

    public static long productOperator(final int[] a)
    {
        return productOperator(0, a.length, a);
    }

    public static long productOperator(final long[] a)
    {
        return productOperator(0, a.length, a);
    }

    public static double productOperator(final float[] a)
    {
        return productOperator(0, a.length, a);
    }

    public static double productOperator(final double[] a)
    {
        return productOperator(0, a.length, a);
    }

    
    /**
     * Executes the product-operator for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ a_i = a_{i - 1} \cdot b_{i - 1} \quad with \quad a_0 = 1}
     *
     * @param offa The offset to the first element of the vector a.
     * @param offb The offset to the first element of the vector b.
     * @param length The length of the vectors.
     * @param a The target vector.
     * @param b The source vector.
     * @return The target-vector
     */
    public static int[] products(final int offa, final int offb, final int length, final int[] a, final byte[] b)
    {
        int size = 1;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] products(final int offa, final int offb, final int length, final int[] a, final short[] b)
    {
        int size = 1;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= (short)b[i + offb];
        }
        return a;
    }

    public static int[] products(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        int size = 1;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= b[i + offb];
        }
        return a;
    }
    
    public static long[] products(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        int size = 1;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= b[i + offb];
        }
        return a;
    }
    
    public static float[] products(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        float size = 1.0f;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= b[i + offb];
        }
        return a;
    }
    
    public static double[] products(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        double size = 1.0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size *= b[i + offb];
        }
        return a;
    }
    
    /**
     * Executes the product-operator for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ a_i = a_{i - 1} \cdot b_{i - 1} \quad with \quad a_0 = 1}
     *
     * @param a The target vector.
     * @param b The source vector.
     * @return The target-vector
     */
    public static int[] products(final int[] a, final byte[] b)
    {
        return products(0, 0, a.length, a, b);
    }
    
    public static int[] products(final int[] a, final short[] b)
    {
        return products(0, 0, a.length, a, b);
    }

    public static int[] products(final int[] a, final int[] b)
    {
        return products(0, 0, a.length, a, b);
    }
    
    public static long[] products(final long[] a, final long[] b)
    {
        return products(0, 0, a.length, a, b);
    }
    
    public static float[] products(final float[] a, final float[] b)
    {
        return products(0, 0, a.length, a, b);
    }
    
    public static double[] products(final double[] a, final double[] b)
    {
        return products(0, 0, a.length, a, b);
    }
    
    /**
     * Calculates the sum-operator for the elements of the a, i.e.<br>
     * 
     * {@latex[ \sum_{i = o_{a}}^{o_{a} + l_{a} - 1} a_{i} }
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements.
     * @param a The a of values
     * @return The sum of the values.
     */
    public static int sumOperator(final int offset, final int length, final byte[] a)
    {
        int res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    public static int sumOperator(final int offset, final int length, final short[] a)
    {
        int res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    public static long sumOperator(final int offset, final int length, final int[] a)
    {
        long res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    public static long sumOperator(final int offset, final int length, final long[] a)
    {
        long res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    public static double sumOperator(final int offset, final int length, final float[] a)
    {
        double res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    public static double sumOperator(final int offset, final int length, final double[] a)
    {
        double res = a[offset];
        for(int i = offset + 1; i < offset + length; i++)
        {
            res += a[i];
        }
        return res;
    }

    /**
     * Calculates the sum-operator for the elements of the a, i.e.<br>
     * 
     * {@latex[ \sum_{i = 0}^{l_{a} - 1} a_{i} }
     * 
     * @param a The a of values
     * @return The sum of the values.
     */
    public static int sumOperator(final byte[] a)
    {
        return sumOperator(0, a.length, a);
    }

    public static int sumOperator(final short[] a)
    {
        return sumOperator(0, a.length, a);
    }

    public static long sumOperator(final int[] a)
    {
        return sumOperator(0, a.length, a);
    }

    public static long sumOperator(final long[] a)
    {
        return sumOperator(0, a.length, a);
    }

    public static double sumOperator(final float[] a)
    {
        return sumOperator(0, a.length, a);
    }

    public static double sumOperator(final double[] a)
    {
        return sumOperator(0, a.length, a);
    }

    
    /**
     * Executes the sum-operator for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ a_i = a_{i - 1} + b_{i - 1} \quad with \quad a_0 = 0}
     *
     * @param offa The offset to the first element of the vector a.
     * @param offb The offset to the first element of the vector b.
     * @param length The length of the vectors.
     * @param a The target vector.
     * @param b The source vector.
     * @return The target-vector
     */
    public static int[] sums(final int offa, final int offb, final int length, final int[] a, final byte[] b)
    {
        int size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] sums(final int offa, final int offb, final int length, final int[] a, final short[] b)
    {
        int size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] sums(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        int size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += (int)b[i + offb];
        }
        return a;
    }
    
    public static long[] sums(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        long size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += b[i + offb];
        }
        return a;
    }
    
    public static float[] sums(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        float size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += (int)b[i + offb];
        }
        return a;
    }
    
    public static double[] sums(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        double size = 0;
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = size;
            size += (int)b[i + offb];
        }
        return a;
    }
    
    /**
     * Executes the sum-operator for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ a_i = a_{i - 1} + b_{i - 1} \quad with \quad a_0 = 0}
     *
     * @param a The target vector.
     * @param b The source vector.
     * @return The target-vector
     */
    public static int[] sums(final int[] a, final byte[] b)
    {
        return sums(0, 0, a.length, a, b);
    }
    
    public static int[] sums(final int[] a, final short[] b)
    {
        return sums(0, 0, a.length, a, b);
    }

    public static int[] sums(final int[] a, final int[] b)
    {
        return sums(0, 0, a.length, a, b);
    }
    
    public static long[] sums(final long[] a, final long[] b)
    {
        return sums(0, 0, a.length, a, b);
    }
    
    public static float[] sums(final float[] a, final float[] b)
    {
        return sums(0, 0, a.length, a, b);
    }
    
    public static double[] sums(final double[] a, final double[] b)
    {
        return sums(0, 0, a.length, a, b);
    }
    
    /**
     * Returns <code>true</code> if all elements of an a are
     * greater than the given value.
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements in the a.
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean greaterThan(final int offset, final int length, final byte[] a, final byte value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(final int offset, final int length, final short[] a, final short value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(final int offset, final int length, final int[] a, final int value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(final int offset, final int length, final long[] a, final long value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(final int offset, final int length, final float[] a, final float value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterThan(final int offset, final int length, final double[] a, final double value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] <= value)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * greater than the given value.
     * 
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean greaterThan(final byte[] a, final byte value)
    {
        return greaterThan(0, a.length, a, value);
    }

    public static boolean greaterThan(final short[] a, final short value)
    {
        return greaterThan(0, a.length, a, value);
    }

    public static boolean greaterThan(final int[] a, final int value)
    {
        return greaterThan(0, a.length, a, value);
    }

    public static boolean greaterThan(final long[] a, final long value)
    {
        return greaterThan(0, a.length, a, value);
    }

    public static boolean greaterThan(final float[] a, final float value)
    {
        return greaterThan(0, a.length, a, value);
    }

    public static boolean greaterThan(final double[] a, final double value)
    {
        return greaterThan(0, a.length, a, value);
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * equal to or greater than the given value.
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements in the a.
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean greaterOrEqual(final int offset, final int length, final byte[] a, final byte value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterOrEqual(final int offset, final int length, final short[] a, final short value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterOrEqual(final int offset, final int length, final int[] a, final int value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterOrEqual(final int offset, final int length, final long[] a, final long value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterOrEqual(final int offset, final int length, final float[] a, final float value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean greaterOrEqual(final int offset, final int length, final double[] a, final double value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] < value)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * equal to or greater than the given value.
     * 
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean greaterOrEqual(final byte[] a, final byte value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    public static boolean greaterOrEqual(final short[] a, final short value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    public static boolean greaterOrEqual(final int[] a, final int value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    public static boolean greaterOrEqual(final long[] a, final long value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    public static boolean greaterOrEqual(final float[] a, final float value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    public static boolean greaterOrEqual(final double[] a, final double value)
    {
        return greaterOrEqual(0, a.length, a, value);
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * less than the given value.
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements in the a.
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean lessThan(final int offset, final int length, final byte[] a, final byte value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(final int offset, final int length, final short[] a, final short value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(final int offset, final int length, final int[] a, final int value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(final int offset, final int length, final long[] a, final long value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(final int offset, final int length, final float[] a, final float value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(final int offset, final int length, final double[] a, final double value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] >= value)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * less than the given value.
     * 
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean lessThan(final byte[] a, final byte value)
    {
        return lessThan(0, a.length, a, value);
    }

    public static boolean lessThan(final short[] a, final short value)
    {
        return lessThan(0, a.length, a, value);
    }

    public static boolean lessThan(final int[] a, final int value)
    {
        return lessThan(0, a.length, a, value);
    }

    public static boolean lessThan(final long[] a, final long value)
    {
        return lessThan(0, a.length, a, value);
    }

    public static boolean lessThan(final float[] a, final float value)
    {
        return lessThan(0, a.length, a, value);
    }

    public static boolean lessThan(final double[] a, final double value)
    {
        return lessThan(0, a.length, a, value);
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * equal to or less than the given value.
     * 
     * @param offset The offset to the first element of the a
     * @param length The number of elements in the a.
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean lessOrEqual(final int offset, final int length, final byte[] a, final byte value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessOrEqual(final int offset, final int length, final short[] a, final short value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessOrEqual(final int offset, final int length, final int[] a, final int value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessOrEqual(final int offset, final int length, final long[] a, final long value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessOrEqual(final int offset, final int length, final float[] a, final float value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean lessOrEqual(final int offset, final int length, final double[] a, final double value)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] > value)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns <code>true</code> if all elements of an a are
     * equal to or less than the given value.
     * 
     * @param a The a containing the values to check.
     * @param value The value to compare the elements with.
     * @return <code>true</code> if the condition is given, <code>false</code> otherwise.
     */
    public static boolean lessOrEqual(final byte[] a, final byte value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    public static boolean lessOrEqual(final short[] a, final short value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    public static boolean lessOrEqual(final int[] a, final int value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    public static boolean lessOrEqual(final long[] a, final long value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    public static boolean lessOrEqual(final float[] a, final float value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    public static boolean lessOrEqual(final double[] a, final double value)
    {
        return lessOrEqual(0, a.length, a, value);
    }

    
    
    /**
     * Finds the maximum of all elements in a.
     *
     * @param offset The offset to the first element of a
     * @param length The number of elements in a. 
     * @param a The array containing the values to check.
     * @return The maximum
     */    
    public static byte max(final int offset, final int length, final byte[] a)
    {
        byte rval = a[offset];
        byte buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }

    public static short max(final int offset, final int length, final short[] a)
    {
        short rval = a[offset];
        short buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }

    public static int max(final int offset, final int length, final int[] a)
    {
        int rval = a[offset];
        int buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }

    public static long max(final int offset, final int length, final long[] a)
    {
        long rval = a[offset];
        long buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }

    public static float max(final int offset, final int length, final float[] a)
    {
        float rval = a[offset];
        float buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }

    public static double max(final int offset, final int length, final double[] a)
    {
        double rval = a[offset];
        double buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > rval)
            {
                rval = buff;
            }
        }
        return rval;
    }


    /**
     * Finds the maximum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @return The maximum
     */    
    public static byte max(final byte[] a)
    {
        return max(0, a.length, a);
    }

    public static short max(final short[] a)
    {
        return max(0, a.length, a);
    }

    public static int max(final int[] a)
    {
        return max(0, a.length, a);
    }

    public static long max(final long[] a)
    {
        return max(0, a.length, a);
    }

    public static float max(final float[] a)
    {
        return max(0, a.length, a);
    }

    public static double max(final double[] a)
    {
        return max(0, a.length, a);
    }
    
    
    /**
     * Finds the maximum of all elements in a.
     *
     * @param offset The offset to the first element of a
     * @param length The number of elements in a. 
     * @param a The array containing the values to check.
     * @param res The index-value pair containing the maximum and its position-index
     * @return The array
     */    
    public static byte[] max(final int offset, final int length, final byte[] a, final IdxValPair.Byte res)
    {
        res.idx = offset;
        res.val = a[offset];
        byte buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    public static short[] max(final int offset, final int length, final short[] a, final IdxValPair.Short res)
    {
        res.idx = offset;
        res.val = a[offset];
        short buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    public static int[] max(final int offset, final int length, final int[] a, final IdxValPair.Int res)
    {
        res.idx = offset;
        res.val = a[offset];
        int buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    public static long[] max(final int offset, final int length, final long[] a, final IdxValPair.Long res)
    {
        res.idx = offset;
        res.val = a[offset];
        long buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    public static float[] max(final int offset, final int length, final float[] a, final IdxValPair.Float res)
    {
        res.idx = offset;
        res.val = a[offset];
        float buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    public static double[] max(final int offset, final int length, final double[] a, final IdxValPair.Double res)
    {
        res.idx = offset;
        res.val = a[offset];
        double buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff > res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        
        return a;
    }
    
    /**
     * Finds the maximum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @param res The index-value pair containing the maximum and its position-index
     * @return The array
     */    
    public static byte[] max(final byte[] a, final IdxValPair.Byte res)
    {
        return max(0, a.length, a, res);
    }

    public static short[] max(final short[] a, final IdxValPair.Short res)
    {
        return max(0, a.length, a, res);
    }

    public static int[] max(final int[] a, final IdxValPair.Int res)
    {
        return max(0, a.length, a, res);
    }

    public static long[] max(final long[] a, final IdxValPair.Long res)
    {
        return max(0, a.length, a, res);
    }

    public static float[] max(final float[] a, final IdxValPair.Float res)
    {
        return max(0, a.length, a, res);
    }

    public static double[] max(final double[] a, final IdxValPair.Double res)
    {
        return max(0, a.length, a, res);
    }

    
    /**
     * Finds the minimum of all elements in a.
     *
     * @param offset The offset to the first element of a
     * @param length The number of elements in a. 
     * @param a The array containing the values to check.
     * @return The minimum
     */    
    public static byte min(final int offset, final int length, final byte[] a)
    {
        byte rval = a[offset];
        byte buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    public static short min(final int offset, final int length, final short[] a)
    {
        short rval = a[offset];
        short buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    public static int min(final int offset, final int length, final int[] a)
    {
        int rval = a[offset];
        int buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    public static long min(final int offset, final int length, final long[] a)
    {
        long rval = a[offset];
        long buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    public static float min(final int offset, final int length, final float[] a)
    {
        float rval = a[offset];
        float buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    public static double min(final int offset, final int length, final double[] a)
    {
        double rval = a[offset];
        double buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < rval)
            {
                rval = buff;
            }
        }
        return rval;
    }
    
    /**
     * Finds the minimum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @return The minimum
     */    
    public static byte min(final byte[] a)
    {
        return min(0, a.length, a);
    }

    public static short min(final short[] a)
    {
        return min(0, a.length, a);
    }

    public static int min(final int[] a)
    {
        return min(0, a.length, a);
    }

    public static long min(final long[] a)
    {
        return min(0, a.length, a);
    }

    public static float min(final float[] a)
    {
        return min(0, a.length, a);
    }

    public static double min(final double[] a)
    {
        return min(0, a.length, a);
    }

    
    
    /**
     * Finds the minimum of all elements in a.
     *
     * @param offset The offset to the first element of a
     * @param length The number of elements in a. 
     * @param a The array containing the values to check.
     * @param res The index-value pair containing the minimum and its position-index
     * @return The array
     */    
    public static byte[] min(final int offset, final int length, final byte[] a, final IdxValPair.Byte res)
    {
        res.val = a[offset];
        res.idx = offset;
        byte buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    public static short[] min(final int offset, final int length, final short[] a, final IdxValPair.Short res)
    {
        res.val = a[offset];
        res.idx = offset;
        short buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    public static int[] min(final int offset, final int length, final int[] a, final IdxValPair.Int res)
    {
        res.val = a[offset];
        res.idx = offset;
        int buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    public static long[] min(final int offset, final int length, final long[] a, final IdxValPair.Long res)
    {
        res.val = a[offset];
        res.idx = offset;
        long buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    public static float[] min(final int offset, final int length, final float[] a, final IdxValPair.Float res)
    {
        res.val = a[offset];
        res.idx = offset;
        float buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    public static double[] min(final int offset, final int length, final double[] a, final IdxValPair.Double res)
    {
        res.val = a[offset];
        res.idx = offset;
        double buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < res.val)
            {
                res.val = buff;
                res.idx = i;
            }
        }
        return a;
    }

    
    /**
     * Finds the minimum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @param res The index-value pair containing the minimum and its position-index
     * @return The array
     */    
    public static byte[] min(final byte[] a, final IdxValPair.Byte res)
    {
        return min(0, a.length, a, res);
    }
    public static short[] min(final short[] a, final IdxValPair.Short res)
    {
        return min(0, a.length, a, res);
    }
    public static int[] min(final int[] a, final IdxValPair.Int res)
    {
        return min(0, a.length, a, res);
    }
    public static long[] min(final long[] a, final IdxValPair.Long res)
    {
        return min(0, a.length, a, res);
    }
    public static float[] min(final float[] a, final IdxValPair.Float res)
    {
        return min(0, a.length, a, res);
    }
    public static double[] min(final double[] a, final IdxValPair.Double res)
    {
        return min(0, a.length, a, res);
    }

    /**
     * Returns the minimum and maximum of all elements in a.
     *
     * @param offset The offset to the first element of a
     * @param length The number of elements in a. 
     * @param a The array containing the values to check.
     * @param max The index-value pair containing the minimum and its position-index
     * @param min The index-value pair containing the minimum and its position-index
     * @return The array
     */
    public static byte[] minmax(final int offset, final int length, final byte[] a, final IdxValPair.Byte min, final IdxValPair.Byte max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        byte buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    
    public static short[] minmax(final int offset, final int length, final short[] a, final IdxValPair.Short min, final IdxValPair.Short max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        short buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    
    public static int[] minmax(final int offset, final int length, final int[] a, final IdxValPair.Int min, final IdxValPair.Int max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        int buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    
    public static long[] minmax(final int offset, final int length, final long[] a, final IdxValPair.Long min, final IdxValPair.Long max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        long buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    
    public static float[] minmax(final int offset, final int length, final float[] a, final IdxValPair.Float min, final IdxValPair.Float max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        float buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    
    public static double[] minmax(final int offset, final int length, final double[] a, final IdxValPair.Double min, final IdxValPair.Double max)
    {
        max.val = a[offset];
        max.idx = offset;
        min.val = max.val;
        min.idx = max.idx;
        double buff;
        for(int i = offset + 1; i < offset + length; i++)
        {
            buff = a[i];
            if(buff < min.val)
            {
                min.val = buff;
                min.idx = i;
            }
            if(buff > max.val)
            {
                max.val = buff;
                max.idx = i;
            }
        }
        return a;
    }    
    

    /**
     * Returns the minimum and maximum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @param max The index-value pair containing the minimum and its position-index
     * @param min The index-value pair containing the minimum and its position-index
     * @return The array
     */
    public static byte[] minmax(final byte[] a, final IdxValPair.Byte min, final IdxValPair.Byte max)
    {
        return minmax(0, a.length, a, min, max);
    }        
    public static short[] minmax(final short[] a, final IdxValPair.Short min, final IdxValPair.Short max)
    {
        return minmax(0, a.length, a, min, max);
    }    
    public static int[] minmax(final int[] a, final IdxValPair.Int min, final IdxValPair.Int max)
    {
        return minmax(0, a.length, a, min, max);
    }    
    public static long[] minmax(final long[] a, final IdxValPair.Long min, final IdxValPair.Long max)
    {
        return minmax(0, a.length, a, min, max);
    }    
    public static float[] minmax(final float[] a, final IdxValPair.Float min, final IdxValPair.Float max)
    {
        return minmax(0, a.length, a, min, max);
    }    
    public static double[] minmax(final double[] a, final IdxValPair.Double min, final IdxValPair.Double max)
    {
        return minmax(0, a.length, a, min, max);
    }    
    
    
}
