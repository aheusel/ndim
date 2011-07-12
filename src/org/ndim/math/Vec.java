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
     * {@latex[ \vec{a} := \vec{a} + \vec{b}}
     * 
     * @param offa The offset for vector a.
     * @param offb The offset for vector b.
     * @param offc The offset for vector c.
     * @param length The length of the vectors.
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     */
    public static void add(final int offa, final int offb, final int offc, final int length, final byte[] c, final byte[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] + c[offc + i]);
        }
    }

    public static void add(final int offa, final int offb, final int offc, final int length, final short[] c, final short[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] + c[offc + i]);
        }
    }

    public static void add(final int offa, final int offb, final int offc, final int length, final int[] c, final int[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
    }

    public static void add(final int offa, final int offb, final int offc, final int length, final long[] c, final long[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
    }

    public static void add(final int offa, final int offb, final int offc, final int length, final float[] c, final float[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
    }

    public static void add(final int offa, final int offb, final int offc, final int length, final double[] c, final double[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] + c[offc + i];
        }
    }

    /**
     * Adds two vectors. The result of the operation
     * is assigned to the left-hand side, i.e.
     * 
     * {@latex[ \vec{a} := \vec{a} + \vec{b}}
     * 
     * @param a The result vector.
     * @param b The first vector.
     * @param c The second vector.
     */
    public static void add(final byte[] c, final byte[] a, final byte[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
    }

    public static void add(final short[] c, final short[] a, final short[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
    }

    public static void add(final int[] c, final int[] a, final int[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
    }

    public static void add(final long[] c, final long[] a, final long[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
    }

    public static void add(final float[] c, final float[] a, final float[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
    }

    public static void add(final double[] c, final double[] a, final double[] b)
    {
        add(0, 0, 0, a.length, a, b, c);
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
     */
    public static void sub(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] - c[offc + i]);
        }
    }

    public static void sub(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] - c[offc + i]);
        }
    }

    public static void sub(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
    }

    public static void sub(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
    }

    public static void sub(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
    }

    public static void sub(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] - c[offc + i];
        }
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
    public static void sub(final byte[] a, final byte[] b, final byte[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    public static void sub(final short[] a, final short[] b, final short[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    public static void sub(final int[] a, final int[] b, final int[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    public static void sub(final long[] a, final long[] b, final long[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    public static void sub(final float[] a, final float[] b, final float[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    public static void sub(final double[] a, final double[] b, final double[] c)
    {
        sub(0, 0, 0, a.length, a, b, c);
    }

    /**
     * Multiplies a scalar with every element of an a.
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
     * Multiplies a scalar with every element of an a.
     * 
     * @param a The a which will be multiplied.
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
        double buff = 0;
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
        double buff = 0;
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
        double buff = 0;
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
        double buff = 0;
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
        double buff = 0;
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
        double buff = 0;
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
     */
    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final byte[] a, final byte[] b, final byte[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (byte) (b[offb + i] * c[offc + i]);
        }
    }

    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final short[] a, final short[] b, final short[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = (short) (b[offb + i] * c[offc + i]);
        }
    }

    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final int[] a, final int[] b, final int[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
    }

    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final long[] a, final long[] b, final long[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
    }

    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final float[] a, final float[] b, final float[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
    }

    public static void elementwiseMul(final int offa, final int offb, final int offc, final int length, final double[] a, final double[] b, final double[] c)
    {
        for(int i = 0; i < length; i++)
        {
            a[offa + i] = b[offb + i] * c[offc + i];
        }
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
     */
    public static void elementwiseMul(final byte[] a, final byte[] b, final byte[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static void elementwiseMul(final short[] a, final short[] b, final short[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static void elementwiseMul(final int[] a, final int[] b, final int[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static void elementwiseMul(final long[] a, final long[] b, final long[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static void elementwiseMul(final float[] a, final float[] b, final float[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    public static void elementwiseMul(final double[] a, final double[] b, final double[] c)
    {
        elementwiseMul(0, 0, 0, a.length, a, b, c);
    }

    /**
     * Performs the elementwise multiplication of two vectors.
     * The result of the operation is assigned to the left-hand side, i.e.<br>
     * 
     * {@latex[ a_{i} := a_{i} \cdot b_{i}}
     * 
     * @param a The first vector.
     * @param b The second vector.
     */
    public static void elementwiseMul(final byte[] a, final byte[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static void elementwiseMul(final short[] a, final short[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static void elementwiseMul(final int[] a, final int[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static void elementwiseMul(final long[] a, final long[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static void elementwiseMul(final float[] a, final float[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
    }

    public static void elementwiseMul(final double[] a, final double[] b)
    {
        elementwiseMul(0, 0, 0, a.length, a, a, b);
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
     * @param alpha The scale factor.
     */
    public static void scale(final int offa, final int offb, final int length, final byte[] a, final byte[] b, final byte alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = (byte) (alpha * b[offb + i]);
        }
    }

    public static void scale(final int offa, final int offb, final int length, final short[] a, final short[] b, final short alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = (short) (alpha * b[offb + i]);
        }
    }

    public static void scale(final int offa, final int offb, final int length, final int[] a, final int[] b, final int alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
    }

    public static void scale(final int offa, final int offb, final int length, final long[] a, final long[] b, final long alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
    }

    public static void scale(final int offa, final int offb, final int length, final float[] a, final float[] b, final float alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
    }

    public static void scale(final int offa, final int offb, final int length, final double[] a, final double[] b, final double alpha)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[offa + i] = alpha * b[offb + i];
        }
    }

    /**
     * Scales every element of an a by a given factor, i.e.<br>
     * 
     * {@latex[ \vec{a} = \alpha \cdot \vec{b}}
     * 
     * @param a The target vector.
     * @param b The source vector.
     * @param alpha The scale factor.
     */
    public static void scale(final byte[] a, final byte[] b, final byte alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    public static void scale(final short[] a, final short[] b, final short alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    public static void scale(final int[] a, final int[] b, final int alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    public static void scale(final long[] a, final long[] b, final long alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    public static void scale(final float[] a, final float[] b, final float alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    public static void scale(final double[] a, final double[] b, final double alpha)
    {
        scale(0, 0, a.length, a, b, alpha);
    }

    /**
     * Scales every element of an a by a given factor, i.e.<br>
     * 
     * {@latex[ \vec{a} \rightarrow \alpha \cdot \vec{a}}
     * 
     * @param a The a to be scaled
     * @param alpha The scale-factor
     */
    public static void scale(final byte[] a, final byte alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
    }

    public static void scale(final short[] a, final short alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
    }

    public static void scale(final int[] a, final int alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
    }

    public static void scale(final long[] a, final long alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
    }

    public static void scale(final float[] a, final float alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
    }

    public static void scale(final double[] a, final double alpha)
    {
        scale(0, 0, a.length, a, a, alpha);
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
     * Returns the maximum of all elements in a.
     *
     * @param a The array containing the values to check.
     * @return the maximum element of the array
     */
    public static byte max(final byte[] a)
    {
        byte res = a[0];
        byte buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }

    public static short max(final short[] a)
    {
        short res = a[0];
        short buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }

    public static int max(final int[] a)
    {
        int res = a[0];
        int buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }

    public static long max(final long[] a)
    {
        long res = a[0];
        long buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }

    public static float max(final float[] a)
    {
        float res = a[0];
        float buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }

    public static double max(final double[] a)
    {
        double res = a[0];
        double buff;
        for(int i = 1; i < a.length; i++)
        {
            buff = a[i];
            if(buff > res)
            {
                res = buff;
            }
        }
        return res;
    }
}
