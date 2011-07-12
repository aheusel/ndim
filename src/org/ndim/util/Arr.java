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
package org.ndim.util;

import java.util.Arrays;
import org.ndim.math.Vec;

/**
 * This class contains several static utility methods for plain java-arrays.
 * 
 * @author Alexander Heusel
 */
public class Arr
{

    public static final int TYPE_UNKNOWN = 0x0;
    public static final int TYPE_UBYTE = 0x2;
    public static final int TYPE_BYTE = 0x3;
    public static final int TYPE_USHORT = 0x4;
    public static final int TYPE_SHORT = 0x5;
    public static final int TYPE_UINT = 0x6;
    public static final int TYPE_INT = 0x7;
    public static final int TYPE_LONG = 0x8;
    public static final int TYPE_FLOAT = 0xa;
    public static final int TYPE_DOUBLE = 0xc;

    /**
     * Determines if a data-type is signed or not.
     * 
     * @param dataType The data-type to test.
     * @return <code>true</code> for signed types, <code>false</code> otherwise.
     */
    public static boolean isSigned(final int dataType)
    {
        return (dataType & 0x1) > 0;
    }
    
    /**
     * Collects specified elements from an array.
     * 
     * @param offset The offset to the first element of the target array.
     * @param a The target array.
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     */
    public static void coalesce(final int offset, final byte[] a, final byte[] b, final int[] idx)
    {

        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    public static void coalesce(final int offset, final short[] a, final short[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    public static void coalesce(final int offset, final int[] a, final int[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    public static void coalesce(final int offset, final long[] a, final long[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    public static void coalesce(final int offset, final float[] a, final float[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    public static void coalesce(final int offset, final double[] a, final double[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
    }

    /**
     * Collects specified elements from an array.
     * 
     * @param a The target array.
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     */
    public static void coalesce(final byte[] a, final byte[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    public static void coalesce(final short[] a, final short[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    public static void coalesce(final int[] a, final int[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    public static void coalesce(final long[] a, final long[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    public static void coalesce(final float[] a, final float[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    public static void coalesce(final double[] a, final double[] b, final int[] idx)
    {
        coalesce(0, a, b, idx);
    }

    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array.
     * 
     * @param offset The offset to the first element of the source array.
     * @param a The source array.
     * @param b The target array.
     * @param idx The positions of the source-elements int the target-array.
     */
    public static void shuffle(final int offset, final byte[] a, final byte[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    public static void shuffle(final int offset, final short[] a, final short[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    public static void shuffle(final int offset, final int[] a, final int[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    public static void shuffle(final int offset, final long[] a, final long[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    public static void shuffle(final int offset, final float[] a, final float[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    public static void shuffle(final int offset, final double[] a, final double[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            b[idx[i]] = a[offset + i];
        }
    }

    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array.
     * 
     * @param a The source array.
     * @param b The target array.
     * @param idx The positions of the source-elements int the target-array.
     */
    public static void shuffle(final byte[] a, final byte[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    public static void shuffle(final short[] a, final short[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    public static void shuffle(final int[] a, final int[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    public static void shuffle(final long[] a, final long[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    public static void shuffle(final float[] a, final float[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    public static void shuffle(final double[] a, final double[] b, final int[] idx)
    {
        shuffle(0, a, b, idx);
    }

    /**
     * Shifts all elements of an array one position to the left. The first
     * array-element is appended to the end<br>
     * 
     * {@latex[ b_{i} := a_{i + 1}, \qquad b_{n} := a_{0}}
     * 
     * @note Source and target can be the same arrays.
     * @param offa The offset to the first element of the source array
     * @param offb The offset to the first element of the target array
     * @param length The length of both arrays
     * @param a The source array
     * @param b The target array
     */
    public static void shiftLeft(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        final byte buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    public static void shiftLeft(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        short buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    public static void shiftLeft(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        final int buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    public static void shiftLeft(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        final long buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    public static void shiftLeft(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        final float buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    public static void shiftLeft(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        final double buff = a[offa];
        for(int i = 1; i < length; i++)
        {
            b[offb + i - 1] = a[offa + i];
        }
        b[offb + length - 1] = (a == b) ? buff : a[offa];
    }

    /**
     * Shifts all elements of an array one position to the left. The first
     * array-element is appended to the end<br>
     * 
     * {@latex[ b_{i} := a_{i + 1}, \qquad b_{n} := a_{0}}
     * 
     * @note Source and target can be the same arrays.
     * @param a The source array
     * @param b The target array
     */
    public static void shiftLeft(final byte[] a, final byte[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    public static void shiftLeft(final short[] a, final short[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    public static void shiftLeft(final int[] a, final int[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    public static void shiftLeft(final long[] a, final long[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    public static void shiftLeft(final float[] a, final float[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    public static void shiftLeft(final double[] a, final double[] b)
    {
        shiftLeft(0, 0, a.length, a, b);
    }

    /**
     * Shifts all elements of an array one position to the right. The last
     * array-element is appended to the begin<br>
     * 
     * {@latex[ b_{i + 1} := a_{i}, \qquad b_{0} := a_{n}}
     * 
     * @note Source and target can be the same arrays.
     * @param offa The offset to the first element of the source array
     * @param offb The offset to the first element of the target array
     * @param length The length of both arrays
     * @param a The source array
     * @param b The target array
     */
    public static void shiftRight(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        final byte buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    public static void shiftRight(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        final short buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    public static void shiftRight(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        final int buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    public static void shiftRight(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        final long buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    public static void shiftRight(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        final float buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    public static void shiftRight(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        final double buff = a[offa + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            b[offb + i] = a[offa + i - 1];
        }
        b[offb] = (a == b) ? buff : a[offa + length - 1];
    }

    /**
     * Shifts all elements of an array one position to the right. The last
     * array-element is appended to the begin<br>
     * 
     * {@latex[ b_{i + 1} := a_{i}, \qquad b_{0} := a_{n}}
     * 
     * @note Source and target can be the same arrays.
     * @param a The source array
     * @param b The target array
     */
    public static void shiftRight(final byte[] a, final byte[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }

    public static void shiftRight(final short[] a, final short[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }

    public static void shiftRight(final int[] a, final int[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }

    public static void shiftRight(final long[] a, final long[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }

    public static void shiftRight(final float[] a, final float[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }

    public static void shiftRight(final double[] a, final double[] b)
    {
        shiftRight(0, 0, a.length, a, b);
    }


    /**
     * Swap two elements in an array
     *
     * @param array The array with the elements.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    public static void swap(final byte[] array, final int i, final int j)
    {
        final byte s = array[i];
        array[i] = array[j];
        array[j] = s;
    }

    public static void swap(final short[] array, final int i, final int j)
    {
        final short s = array[i];
        array[i] = array[j];
        array[j] = s;
    }

    public static void swap(final int[] array, final int i, final int j)
    {
        final int s = array[i];
        array[i] = array[j];
        array[j] = s;
    }

    public static void swap(final long[] array, final int i, final int j)
    {
        final long s = array[i];
        array[i] = array[j];
        array[j] = s;
    }

    public static void swap(final float[] array, final int i, final int j)
    {
        final float s = array[i];
        array[i] = array[j];
        array[j] = s;
    }

    public static void swap(final double[] array, final int i, final int j)
    {
        final double s = array[i];
        array[i] = array[j];
        array[j] = s;
    }


    public static int has(final byte[] array, final byte v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final short[] array, final short v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final int[] array, final int v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final long[] array, final long v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final float[] array, final float v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final double[] array, final double v)
    {
        return has(array, v, 0, array.length);
    }

    public static int has(final byte[] array, final byte v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int has(final short[] array, final short v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int has(final int[] array, final int v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int has(final long[] array, final long v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int has(final float[] array, final float v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int has(final double[] array, final double v, final int b, final int e)
    {
        for(int i = b; i < e; i++)
        {
            if(array[i] == v)
            {
                return i;
            }
        }
        return -1;
    }


    /**
     * Creates an array with given length. All elements are initialized with
     * the given value.
     *
     * @param length The size of the array to create.
     * @param value The value to initialize the elements with.
     * @return The array.
     */
    public static byte[] fillCreateByte(final int length, final byte value)
    {
        final byte[] res = new byte[length];
        Arrays.fill(res, value);
        return res;
    }

    public static short[] fillCreateShort(final int length, final short value)
    {
        final short[] res = new short[length];
        Arrays.fill(res, value);
        return res;
    }

    public static int[] fillCreateInt(final int length, final int value)
    {
        final int[] res = new int[length];
        Arrays.fill(res, value);
        return res;
    }

    public static long[] fillCreateLong(final int length, final long value)
    {
        final long[] res = new long[length];
        Arrays.fill(res, value);
        return res;
    }

    public static float[] fillCreateFloat(final int length, final float value)
    {
        final float[] res = new float[length];
        Arrays.fill(res, value);
        return res;
    }

    public static double[] fillCreateDouble(final int length, final double value)
    {
        final double[] res = new double[length];
        Arrays.fill(res, value);
        return res;
    }

    public static Object createFromType(final int dataType, final int length)
    {
        switch(dataType)
        {
            case TYPE_BYTE:
            case TYPE_UBYTE:
                return new byte[length];
            case TYPE_SHORT:
            case TYPE_USHORT:
                return new short[length];
            case TYPE_INT:
            case TYPE_UINT:
                return new int[length];
            case TYPE_LONG:
                return new long[length];
            case TYPE_FLOAT:
                return new float[length];
            case TYPE_DOUBLE:
                return new double[length];
            default:
                throw new java.lang.IllegalStateException("Unknown data-type!");
        }
    }

    public static Object fillCreateFromType(final int dataType, final int length, final Object value)
    {

        switch(dataType)
        {
            case TYPE_BYTE:
            case TYPE_UBYTE:
                return fillCreateByte(length, (Byte)value);
            case TYPE_SHORT:
            case TYPE_USHORT:
                return fillCreateShort(length, (Short)value);
            case TYPE_INT:
            case TYPE_UINT:
                return fillCreateInt(length, (Integer)value);
            case TYPE_LONG:
                return fillCreateLong(length, (Long)value);
            case TYPE_FLOAT:
                return fillCreateFloat(length, (Float)value);
            case TYPE_DOUBLE:
                return fillCreateDouble(length, (Double)value);
            default:
                throw new java.lang.IllegalStateException("Unknown data-type!");
        }
    }

    /**
     * Creates a java integer-array in which each elements has its index as its value.<br>
     * 
     * 
     * 
     * @param length The size of the array
     * @return The index-array.
     */
    public static int[] createAscendingIndexSet(final int length)
    {
        final int[] res = new int[length];
        for(int i = 0; i < res.length; i++)
        {
            res[i] = i;
        }
        return res;
    }

    /**
     * Creates a java integer-array in which each elements has its index scaled
     * by a factor as its value.
     * 
     * @param length The size of the array.
     * @param factor A factor by which each index is scaled.
     * @return The index-array.
     */
    public static int[] createAscendingIndexSet(final int length, final int factor)
    {
        final int[] res = new int[length];
        for(int i = 0; i < res.length; i++)
        {
            res[i] = i * factor;
        }
        return res;
    }


    /**
     * Calculates the v for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ v_i = v_{i - 1} \cdot c_{i - 1} \quad with \quad v_0 = 1}
     * 
     * @param c The array of coefficients
     * @param v The array containing the volumes after the call.
     */
    public static void calcVolumes(final int[] c, final int[] v)
    {
        int size = 1;
        for(int i = 0; i < c.length; i++)
        {
            v[i] = size;
            size *= c[i];
        }
    }

    /**
     * Calculates the v for each index of an array of coefficients, i.e.<br>
     * 
     * {@latex[ v_i = v_{i - 1} \cdot c_{i - 1} \quad with \quad v_0 = 1}
     * 
     * @param c The array of coefficients
     * @return The corresponding v.
     */
    public static int[] calcVolumes(final int[] c)
    {
        final int[] res = new int[c.length];
        calcVolumes(c, res);
        return res;
    }

    /**
     * Calculates the total-volume of the array, i.e.
     * 
     * {@latex[ v = \prod_{i = 0}^{n - 1} c_i}
     * 
     * @param c The coefficient-array
     * @return The volume of the array.
     */
    public static int calcTotalVolume(final int[] c)
    {
        return (int) Vec.productOperator(c);
    }

    public static byte last(final byte[] array)
    {
        return array[array.length - 1];
    }

    public static short last(final short[] array)
    {
        return array[array.length - 1];
    }

    public static int last(final int[] array)
    {
        return array[array.length - 1];
    }

    public static long last(final long[] array)
    {
        return array[array.length - 1];
    }

    public static float last(final float[] array)
    {
        return array[array.length - 1];
    }

    public static double last(final double[] array)
    {
        return array[array.length - 1];
    }

    public static int lidx(final byte[] array)
    {
        return array.length - 1;
    }

    public static int lidx(final short[] array)
    {
        return array.length - 1;
    }

    public static int lidx(final int[] array)
    {
        return array.length - 1;
    }

    public static int lidx(final long[] array)
    {
        return array.length - 1;
    }

    public static int lidx(final float[] array)
    {
        return array.length - 1;
    }

    public static int lidx(final double[] array)
    {
        return array.length - 1;
    }
}
