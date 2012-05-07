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

/**
 * This class contains several static utility methods for plain java-arrays.
 * 
 * @author Alexander Heusel
 */
public class Arr
{
    
    /**
     * Collects specified elements from an array.
     * 
     * @param offset The offset to the first element of the target array.
     * @param a The target array.
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     * @return Returns the target array.
     */
    public static byte[] coalesce(final int offset, final byte[] a, final byte[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static short[] coalesce(final int offset, final short[] a, final short[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static int[] coalesce(final int offset, final int[] a, final int[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static long[] coalesce(final int offset, final long[] a, final long[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static float[] coalesce(final int offset, final float[] a, final float[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static double[] coalesce(final int offset, final double[] a, final double[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    /**
     * Collects specified elements from an array.
     * 
     * @param a The target array.
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     * @return Returns the target array.
     */
    public static byte[] coalesce(final byte[] a, final byte[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static short[] coalesce(final short[] a, final short[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static int[] coalesce(final int[] a, final int[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static long[] coalesce(final long[] a, final long[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static float[] coalesce(final float[] a, final float[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static double[] coalesce(final double[] a, final double[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    /**
     * Collects specified elements from an array.
     * 
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     * @return Returns A new array containing the elements.
     */    
    public static byte[] coalesce(final byte[] b, final int[] idx)
    {   
        return coalesce(0, new byte[idx.length], b, idx);
    }

    public static short[] coalesce(final short[] b, final int[] idx)
    {   
        return coalesce(0, new short[idx.length], b, idx);
    }
    
    public static int[] coalesce(final int[] b, final int[] idx)
    {   
        return coalesce(0, new int[idx.length], b, idx);
    }
    
    public static long[] coalesce(final long[] b, final int[] idx)
    {   
        return coalesce(0, new long[idx.length], b, idx);
    }
    
    public static float[] coalesce(final float[] b, final int[] idx)
    {   
        return coalesce(0, new float[idx.length], b, idx);
    }
    
    public static double[] coalesce(final double[] b, final int[] idx)
    {   
        return coalesce(0, new double[idx.length], b, idx);
    }
    
    
    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array.
     * 
     * @param offset The offset to the first element of the source array.
     * @param a The target array.
     * @param b The source array.
     * @param idx The positions of the source-elements int the target-array.
     * @return The target array
     */
    public static byte[] shuffle(final int offset, final byte[] a, final byte[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static short[] shuffle(final int offset, final short[] a, final short[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static int[] shuffle(final int offset, final int[] a, final int[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static long[] shuffle(final int offset, final long[] a, final long[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static float[] shuffle(final int offset, final float[] a, final float[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static double[] shuffle(final int offset, final double[] a, final double[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }


    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array.
     * 
     * @param a The target array.
     * @param b The source array.
     * @param idx The positions of the source-elements int the target-array.
     * @return The target array
     */
    public static byte[] shuffle(final byte[] a, final byte[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static short[] shuffle(final short[] a, final short[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static int[] shuffle(final int[] a, final int[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static long[] shuffle(final long[] a, final long[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static float[] shuffle(final float[] a, final float[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static double[] shuffle(final double[] a, final double[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    /**
     * Shifts all elements of an array one position to the left. The first
     * array-element is appended to the end<br>
     * 
     * {@latex[ a_{i} := b_{i + 1}, \qquad a_{n} := b_{0}}
     * 
     * @note Source and target can be the same arrays.
     * @param offa The offset to the first element of the target array
     * @param offb The offset to the first element of the source array
     * @param length The length of both arrays
     * @param a The target array
     * @param b The source array
     * @return The target array
     */
    public static byte[] shiftLeft(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        final byte buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }

    public static short[] shiftLeft(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        final short buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }

    public static int[] shiftLeft(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        final int buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }

    public static long[] shiftLeft(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        final long buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }

    public static float[] shiftLeft(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        final float buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }

    public static double[] shiftLeft(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        final double buff = b[offb];
        for(int i = 1; i < length; i++)
        {
            a[offa + i - 1] = b[offb + i];
        }
        a[offa + length - 1] = (b == a) ? buff : b[offb];
        return a;
    }


    /**
     * Shifts all elements of an array one position to the left. The first
     * array-element is appended to the end<br>
     * 
     * {@latex[ a_{i} := b_{i + 1}, \qquad a_{n} := b_{0}}
     * 
     * @note Source and target can be the same arrays.
     * @param a The target array
     * @param b The source array
     * @return The target array
     */
    public static byte[] shiftLeft(final byte[] a, final byte[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    public static short[] shiftLeft(final short[] a, final short[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    public static int[] shiftLeft(final int[] a, final int[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    public static long[] shiftLeft(final long[] a, final long[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    public static float[] shiftLeft(final float[] a, final float[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    public static double[] shiftLeft(final double[] a, final double[] b)
    {
        return shiftLeft(0, 0, a.length, a, b);
    }

    /**
     * Shifts all elements of an array one position to the right. The last
     * array-element is appended to the begin<br>
     * 
     * {@latex[ a_{i + 1} := b_{i}, \qquad a_{0} := b_{n}}
     * 
     * @note Source and target can be the same arrays.
     * @param offa The offset to the first element of the target array
     * @param offb The offset to the first element of the source array
     * @param length The length of both arrays
     * @param a The target array
     * @param b The source array
     * @return  The target array
     */
    public static byte[] shiftRight(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        final byte buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }

    public static short[] shiftRight(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        final short buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }

    public static int[] shiftRight(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        final int buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }

    public static long[] shiftRight(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        final long buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }

    public static float[] shiftRight(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        final float buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }

    public static double[] shiftRight(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        final double buff = b[offb + length - 1];
        for(int i = length - 1; i > 0; i--)
        {
            a[offa + i] = b[offb + i - 1];
        }
        a[offa] = (b == a) ? buff : b[offb + length - 1];
        return a;
    }


    /**
     * Shifts all elements of an array one position to the right. The last
     * array-element is appended to the begin<br>
     * 
     * {@latex[ a_{i + 1} := b_{i}, \qquad a_{0} := b_{n}}
     * 
     * @note Source and target can be the same arrays.
     * @param a The target array
     * @param b The source array
     * @return  The target array
     */
    public static byte[] shiftRight(final byte[] a, final byte[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }

    public static short[] shiftRight(final short[] a, final short[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }

    public static int[] shiftRight(final int[] a, final int[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }

    public static long[] shiftRight(final long[] a, final long[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }

    public static float[] shiftRight(final float[] a, final float[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }

    public static double[] shiftRight(final double[] a, final double[] b)
    {
        return shiftRight(0, 0, a.length, a, b);
    }


    /**
     * Swap two elements in an array
     *
     * @param array The array with the elements.
     * @param i The index of the first element.
     * @param j The index of the second element.
     * @return The array
     */
    public static byte[] swap(final byte[] array, final int i, final int j)
    {
        final byte s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static short[] swap(final short[] array, final int i, final int j)
    {
        final short s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static int[] swap(final int[] array, final int i, final int j)
    {
        final int s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static long[] swap(final long[] array, final int i, final int j)
    {
        final long s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static float[] swap(final float[] array, final int i, final int j)
    {
        final float s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static double[] swap(final double[] array, final int i, final int j)
    {
        final double s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
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
     * Checks whether an array contains a value or not
     * @param array
     * @param v
     * @return The array
     */
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



    /**
     * Fills a segment of an array with a given value
     * 
     * @param offset The index of the first array-element to fill
     * @param length The length of the segment to fill
     * @param a The array
     * @param value The value to fill
     * @return The array
     */
    public static byte[] fill(final int offset, final int length, final byte[] a, final byte value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static short[] fill(final int offset, final int length, final short[] a, final short value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static int[] fill(final int offset, final int length, final int[] a, final int value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static long[] fill(final int offset, final int length, final long[] a, final long value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static float[] fill(final int offset, final int length, final float[] a, final float value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static double[] fill(final int offset, final int length, final double[] a, final double value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    
    /**
     * Fills a segment of an array with a given value
     * 
     * @param a The array
     * @param value The value to fill
     * @return The array
     */
    public static byte[] fill(final byte[] a, final byte value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static short[] fill(final short[] a, final short value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static int[] fill(final int[] a, final int value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static long[] fill(final long[] a, final long value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static float[] fill(final float[] a, final float value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static double[] fill(final double[] a, final double value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    
    
    /**
     * Assigns its index to each element of the denoted segment of a java-array.
     * The index starts with zero even if offset is > 0. In the case of byte and
     * short values the integer index is masked
     * with 0xff and 0xfff.
     * 
     * @param offset The offset of the first element
     * @param length The length of the array segment to fill
     * @param  a The array to fill
     * @return The array
     */
    public  static byte[] fillWithIndex(final int offset, final int length, final byte[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (byte)(0xff & i);
        }
        return a;
    }
    
    public  static short[] fillWithIndex(final int offset, final int length, final short[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (short)(0xffff & i);
        }
        return a;
    }
    
    public  static int[] fillWithIndex(final int offset, final int length, final int[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i;
        }
        return a;
    }
    
    public  static long[] fillWithIndex(final int offset, final int length, final long[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i;
        }
        return a;
    }
    
    public  static float[] fillWithIndex(final int offset, final int length, final float[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i;
        }
        return a;
    }
    
    public  static double[] fillWithIndex(final int offset, final int length, final double[] a)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i;
        }
        return a;
    }
    
    /**
     * Assigns its index to each element of a java-array. In the case of byte and
     * short values the integer index is masked with 0xff and 0xfff.
     * 
     * @param  a The array to fill
     * @return The array
     */
    public static byte[] fillWithIndex(final byte[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    public static short[] fillWithIndex(final short[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    public static int[] fillWithIndex(final int[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    public static long[] fillWithIndex(final long[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    public static float[] fillWithIndex(final float[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    public static double[] fillWithIndex(final double[] a)
    {
        return fillWithIndex(0, a.length, a);
    }

    /**
     * For each element of the denoted segment of a java-array its index is multiplied
     * by alpha. The result is assigned to that very element.
     * The index starts with zero even if offset is > 0. In the case of byte and
     * short values the product is masked with 0xff and 0xfff.
     * 
     * @param offset The offset of the first element
     * @param length The length of the array segment to fill
     * @param  a The array to fill
     * @param  alpha The factor which is multiplied with the index
     * @return The array
     */
    public  static byte[] fillWithScaledIndex(final int offset, final int length, final byte[] a, final byte alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (byte)(0xff & (i*(int)alpha));
        }
        return a;
    }
    
    public  static short[] fillWithScaledIndex(final int offset, final int length, final short[] a, final short alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (short)(0xffff & (i*(short)alpha));
        }
        return a;
    }
    
    public  static int[] fillWithScaledIndex(final int offset, final int length, final int[] a, final int alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i*alpha;
        }
        return a;
    }
    
    public  static long[] fillWithScaledIndex(final int offset, final int length, final long[] a, final long alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (long)(i)*alpha;
        }
        return a;
    }
    
    public  static float[] fillWithScaledIndex(final int offset, final int length, final float[] a, final float alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (float)(i)*alpha;
        }
        return a;
    }
    
    public  static double[] fillWithScaledIndex(final int offset, final int length, final double[] a, final double alpha)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (double)(i)*alpha;
        }
        return a;
    }
 
    
    /**
     * For each element of a java-array its index is multiplied by alpha and the result
     * assigned to that very element. In the case of byte and
     * short values the product is masked with 0xff and 0xfff.
     * 
     * @param  a The array to fill
     * @param  alpha The factor which is multiplied with the index
     * @return The array
     */    
    public static byte[] fillWithScaledIndex(final byte[] a, final byte alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }

    public static short[] fillWithScaledIndex(final short[] a, final short alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }
    public static int[] fillWithScaledIndex(final int[] a, final int alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }
    public static long[] fillWithScaledIndex(final long[] a, final long alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }
    public static float[] fillWithScaledIndex(final float[] a, final float alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }
    public static double[] fillWithScaledIndex(final double[] a, final double alpha)
    {
        return fillWithScaledIndex(0, a.length, a, alpha);
    }
    
}
