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
package org.ndim.Arrays;

import java.util.Arrays;

/**
 * This class contains several static utility methods for plain java-arrays.
 * 
 * @author Alexander Heusel
 */
public class Algo
{

    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="coalesce">
    
    /**
     * Collects specified elements from an array.
     * 
     * @param offset The offset to the first element of the target array.
     * @param a The target array.
     * @param b The source array.
     * @param idx The indices of the elements to be copied into the target-array.
     * @return The target array.
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

    public static boolean[] coalesce(final int offset, final boolean[] a, final boolean[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[offset + i] = b[idx[i]];
        }
        return a;
    }

    public static char[] coalesce(final int offset, final char[] a, final char[] b, final int[] idx)
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

    public static boolean[] coalesce(final boolean[] a, final boolean[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }

    public static char[] coalesce(final char[] a, final char[] b, final int[] idx)
    {
        return coalesce(0, a, b, idx);
    }
    
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="fill">

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

    public static boolean[] fill(final int offset, final int length, final boolean[] a, final boolean value)
    {
        Arrays.fill(a, offset, offset + length, value);
        return a;
    }

    public static char[] fill(final int offset, final int length, final char[] a, final char value)
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
    
    public static boolean[] fill(final boolean[] a, final boolean value)
    {
        Arrays.fill(a, value);
        return a;
    }
    
    public static char[] fill(final char[] a, final char value)
    {
        Arrays.fill(a, value);
        return a;
    }
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="find">
    
    /**
     * Finds first element in a segment of a which is equal to v
     * 
     * @param offset The offset to the first element of a
     * @param length The length of the segment
     * @param a The array
     * @param v The value
     * @param eps (float and double only!) Accuracy of the match
     * @return The index of the first match or -1 if no match was found.
     */
    public static int find(final int offset, final int length, final byte[] a, final byte v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final short[] a, final short v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final int[] a, final int v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final long[] a, final long v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final float[] a, final float v, final float eps)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(Math.abs(a[i] - v) < eps)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final double[] a, final double v, final double eps)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(Math.abs(a[i] - v) < eps)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final boolean[] a, final boolean v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    public static int find(final int offset, final int length, final char[] a, final char v)
    {
        for(int i = offset; i < offset + length; i++)
        {
            if(a[i] == v)
            {
                return i;
            }
        }
        return -1;
    }

    
    
    /**
     * Finds first element in a segment of a which is equal to v
     * 
     * @param a The array
     * @param v The value
     * @param eps (float and double only!) Accuracy of the match
     * @return The index of the first match or -1 if no match was found.
     */
    public static int find(final byte[] a, final byte v)
    {
        return find(0, a.length, a, v);
    }

    public static int find(final short[] a, final short v)
    {
        return find(0, a.length, a, v);
    }

    public static int find(final int[] a, final int v)
    {
        return find(0, a.length, a, v);
    }

    public static int find(final long[] a, final long v)
    {
        return find(0, a.length, a, v);
    }

    public static int find(final float[] a, final float v, final float eps)
    {
        return find(0, a.length, a, v, eps);
    }

    public static int find(final double[] a, final double v, final double eps)
    {
        return find(0, a.length, a, v, eps);
    }

    public static int find(final boolean[] a, final boolean v)
    {
        return find(0, a.length, a, v);
    }

    public static int find(final char[] a, final char v)
    {
        return find(0, a.length, a, v);
    }
    
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="iota">
  
    /**
     * Fills the segment with sequentially increasing values, starting with
     * value and repetitively evaluating ++value.
     * In the case of byte and short, the values are masked
     * with 0xff and 0xfff.
     * 
     * @param offset The offset of the first element
     * @param length The length of the array segment to fill
     * @param  a The array to fill
     * @param  value The start-value.
     * @return The array
     */
    public static byte[] iota(final int offset, final int length, final byte[] a, final byte value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (byte)(0xff & (i + (int)value));
        }
        return a;
    }
    
    public static short[] iota(final int offset, final int length, final short[] a, final short value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (short)(0xffff & (i + (int)value));
        }
        return a;
    }
    
    public static int[] iota(final int offset, final int length, final int[] a, final int value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i + value;
        }
        return a;
    }
    
    public static long[] iota(final int offset, final int length, final long[] a, final long value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i + value;
        }
        return a;
    }
    
    public static float[] iota(final int offset, final int length, final float[] a, final float value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i + value;
        }
        return a;
    }
    
    public static double[] iota(final int offset, final int length, final double[] a, final double value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = i + value;
        }
        return a;
    }
    
    public static char[] iota(final int offset, final int length, final char[] a, final char value)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (char)(i + (int)value);
        }
        return a;
    }
    
    /**
     * Fills the segment with sequentially increasing values, starting with
     * value and repetitively evaluating ++value.
     * In the case of byte and short, the values are masked
     * with 0xff and 0xfff.
     * 
     * @param  a The array to fill
     * @param  value The start-value.
     * @return The array
     */
    public static byte[] iota(final byte[] a, final byte value)
    {
        return iota(0, a.length, a, value);
    }

    public static short[] iota(final short[] a, final short value)
    {
        return iota(0, a.length, a, value);
    }

    public static int[] iota(final int[] a, final int value)
    {
        return iota(0, a.length, a, value);
    }

    public static long[] iota(final long[] a, final long value)
    {
        return iota(0, a.length, a, value);
    }

    public static float[] iota(final float[] a, final float value)
    {
        return iota(0, a.length, a, value);
    }

    public static double[] iota(final double[] a, final double value)
    {
        return iota(0, a.length, a, value);
    }

    public static char[] iota(final char[] a, final char value)
    {
        return iota(0, a.length, a, value);
    }

    /**
     * Fills the segment with sequentially increasing values, starting with
     * value and repetitively evaluating value += incr.
     * In the case of byte and short, the values are masked
     * with 0xff and 0xfff.
     * 
     * @param offset The offset of the first element
     * @param length The length of the array segment to fill
     * @param  a The array to fill
     * @param  value The start-value.
     * @return The array
     */
    public static byte[] iota(final int offset, final int length, final byte[] a, final byte value, final byte incr)
    {
        int iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (byte)(0xff & iter);
            iter += (int)incr;
        }
        return a;
    }
    
    public static short[] iota(final int offset, final int length, final short[] a, final short value, final short incr)
    {
        int iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (short)(0xffff & iter);
            iter += (int)incr;
        }
        return a;
    }
    
    public static int[] iota(final int offset, final int length, final int[] a, final int value, final int incr)
    {
        int iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = iter;
            iter += incr;
        }
        return a;
    }
    
    public static long[] iota(final int offset, final int length, final long[] a, final long value, final long incr)
    {
        long iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = iter;
            iter += incr;
        }
        return a;
    }
    
    public static float[] iota(final int offset, final int length, final float[] a, final float value, final float incr)
    {
        float iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = iter;
            iter += incr;
        }
        return a;
    }
    
    public static double[] iota(final int offset, final int length, final double[] a, final double value, final double incr)
    {
        double iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = iter;
            iter += incr;
        }
        return a;
    }
    
    public static char[] iota(final int offset, final int length, final char[] a, final char value, final char incr)
    {
        int iter = value;
        for(int i = 0; i < length; i++)
        {
            a[i + offset] = (char)iter;
            iter += incr;
        }
        return a;
    }
    
 
    
    /**
     * Fills the segment with sequentially increasing values, starting with
     * value and repetitively evaluating value += incr.
     * In the case of byte and short, the values are masked
     * with 0xff and 0xfff.
     * 
     * @param  a The array to fill
     * @param  value The start-value.
     * @return The array
     */
    public static byte[] iota(final byte[] a, final byte value, final byte incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static short[] iota(final short[] a, final short value, final short incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static int[] iota(final int[] a, final int value, final int incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static long[] iota(final long[] a, final long value, final long incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static float[] iota(final float[] a, final float value, final float incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static double[] iota(final double[] a, final double value, final double incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    public static char[] iota(final char[] a, final char value, final char incr)
    {
        return iota(0, a.length, a, value, incr);
    }

    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="reverse">
    
    /**
     * Reverses the order of the elements in the segment
     * 
     * @param offset The offset to the first element in the segment
     * @param length The length of the segment
     * @param a The array
     * @return The array
     */
    public static byte[] reverse(final int offset, final int length, final byte[] a)
    {
        byte buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static short[] reverse(final int offset, final int length, final short[] a)
    {
        short buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static int[] reverse(final int offset, final int length, final int[] a)
    {
        int buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static long[] reverse(final int offset, final int length, final long[] a)
    {
        long buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static float[] reverse(final int offset, final int length, final float[] a)
    {
        float buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static double[] reverse(final int offset, final int length, final double[] a)
    {
        double buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static boolean[] reverse(final int offset, final int length, final boolean[] a)
    {
        boolean buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    public static char[] reverse(final int offset, final int length, final char[] a)
    {
        char buff;
        int backwIter =  offset + length - 1;
        for(int i = offset; i < offset + (length >> 1); i++)
        {
            buff = a[i];
            a[i] = a[backwIter];
            a[backwIter--] = buff;
        }
        return a;
    }
    
    /**
     * Reverses the order of the elements in the segment
     * 
     * @param a The array
     * @return The array
     */
    public static byte[] reverse(final byte[] a)
    {
        return reverse(0, a.length, a);
    }

    public static short[] reverse(final short[] a)
    {
        return reverse(0, a.length, a);
    }

    public static int[] reverse(final int[] a)
    {
        return reverse(0, a.length, a);
    }

    public static long[] reverse(final long[] a)
    {
        return reverse(0, a.length, a);
    }

    public static float[] reverse(final float[] a)
    {
        return reverse(0, a.length, a);
    }

    public static double[] reverse(final double[] a)
    {
        return reverse(0, a.length, a);
    }

    public static boolean[] reverse(final boolean[] a)
    {
        return reverse(0, a.length, a);
    }

    public static char[] reverse(final char[] a)
    {
        return reverse(0, a.length, a);
    }

    
    /**
     * Reverses the order of the elements in the segment. a and b must be
     * different arrays.
     * 
     * @param offa The offset to the first element in the target vector
     * @param offb The offset to the first element in the source vector
     * @param length The length of the segment
     * @param a The target vector
     * @param b The source vector
     * @return  The target vector
     */
    public static byte[] reverse(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }

    public static short[] reverse(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }
    
    public static int[] reverse(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }
    
    public static long[] reverse(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }
    
    public static float[] reverse(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }
    
    public static double[] reverse(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }

    public static boolean[] reverse(final int offa, final int offb, final int length, final boolean[] a, final boolean[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }
    
    public static char[] reverse(final int offa, final int offb, final int length, final char[] a, final char[] b)
    {
        int backwIter = length - 1;
        for(int i = 0; i < (length >> 1); i++)
        {
            a[i + offa] = b[backwIter-- + offb];
        }
        return a;
    }

    
    /**
     * Reverses the order of the elements in the segment. a and b must be
     * different arrays.
     * 
     * @param a The target vector
     * @param b The source vector
     * @return  The target vector
     */
    public static byte[] reverse(final byte[] a, final byte[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static short[] reverse(final short[] a, final short[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static int[] reverse(final int[] a, final int[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static long[] reverse(final long[] a, final long[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static float[] reverse(final float[] a, final float[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static double[] reverse(final double[] a, final double[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static boolean[] reverse(final boolean[] a, final boolean[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    
    public static char[] reverse(final char[] a, final char[] b)
    {
        return reverse(0, 0, a.length, a, b);
    }
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="rotate">
    
    /**
     * Rotates the order of the elements in the segment, in such a way that the element
     * pointed by newFirst becomes the new first element.
     * 
     * @param offset The offset to the first element of the array
     * @param length The length of the segment to be rotated
     * @param a The array
     * @param newFirst The new first element of the segment of the array
     * @return The array
     */
    public static byte[] rotate(final int offset, final int length, final byte[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static short[] rotate(final int offset, final int length, final short[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static int[] rotate(final int offset, final int length, final int[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static long[] rotate(final int offset, final int length, final long[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static float[] rotate(final int offset, final int length, final float[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static double[] rotate(final int offset, final int length, final double[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static char[] rotate(final int offset, final int length, final char[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }
    
    public static boolean[] rotate(final int offset, final int length, final boolean[] a, final int newFirst)
    {
        int first = offset;
        final int last = offset + length;
        int middle = offset + newFirst;
        int next = middle;
        while(first != next)
        {
            swap(a, first++, next++);
            
            if(next == last)
            {
                next = middle;
            }
            else if(first == middle)
            {
                middle = next;
            }
        }
        return a;
    }

    /**
     * Rotates the order of the elements in the segment, in such a way that the element
     * pointed by newFirst becomes the new first element.
     * 
     * @param a The array
     * @param newFirst The new first element of the segment of the array
     * @return The array
     */
    public static byte[] rotate(final byte[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static short[] rotate(final short[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static int[] rotate(final int[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static long[] rotate(final long[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static float[] rotate(final float[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static double[] rotate(final double[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static char[] rotate(final char[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    public static boolean[] rotate(final boolean[] a, final int newFirst)
    {
        return rotate(0, a.length, a, newFirst);
    }
    
    /**
     * Rotates the order of the elements in the segment, in such a way that the element
     * pointed by newFirst becomes the new first element.
     * 
     * @note Source and target may be the same arrays.
     * @param offa The offset to the first element of the target-array
     * @param offb The offset to the first element of the source-array
     * @param length The length of the segment to be rotated
     * @param a The target array
     * @param b The source array
     * @param newFirst The element of the segment which will be the first element
     * in the segment of the target-array
     * @return The target-array
     */
    public static byte[] rotate(final int offa, final int offb, final int length, final byte[] a, final byte[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static short[] rotate(final int offa, final int offb, final int length, final short[] a, final short[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static int[] rotate(final int offa, final int offb, final int length, final int[] a, final int[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static long[] rotate(final int offa, final int offb, final int length, final long[] a, final long[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static float[] rotate(final int offa, final int offb, final int length, final float[] a, final float[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static double[] rotate(final int offa, final int offb, final int length, final double[] a, final double[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static boolean[] rotate(final int offa, final int offb, final int length, final boolean[] a, final boolean[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    public static char[] rotate(final int offa, final int offb, final int length, final char[] a, final char[] b, final int newFirst)
    {
        if(a == b && offa == offb)
        {
            return rotate(offa, length, a, newFirst);
        }
        else
        {
            int iterTarget = offa;
            for(int i = offb + newFirst; i < offb + length; i++)
            {
                a[iterTarget++] = b[i];
            }
            for(int i = offb; i < offb + newFirst; i++)
            {
                a[iterTarget++] = b[i];
            }
        }
        return a;
    }
    
    /**
     * Rotates the order of the elements in the segment, in such a way that the element
     * pointed by newFirst becomes the new first element.
     * 
     * @note Source and target may be the same arrays.
     * @param a The target array
     * @param b The source array
     * @param newFirst The element of the segment which will be the first element
     * in the segment of the target-array
     * @return The target-array
     */
    public static byte[] rotate(final byte[] a, final byte[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static short[] rotate(final short[] a, final short[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static int[] rotate(final int[] a, final int[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static long[] rotate(final long[] a, final long[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static float[] rotate(final float[] a, final float[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static double[] rotate(final double[] a, final double[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static boolean[] rotate(final boolean[] a, final boolean[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    public static char[] rotate(final char[] a, final char[] b, final int newFirst)
    {
        return rotate(0, 0, a.length, a, b, newFirst);
    }    

    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="shuffle">
    
    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array. <code>shuffle</code> does not check the integrity
     * of the index array!
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

    public static boolean[] shuffle(final int offset, final boolean[] a, final boolean[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }

    public static char[] shuffle(final int offset, final char[] a, final char[] b, final int[] idx)
    {
        for(int i = 0; i < idx.length; i++)
        {
            a[idx[i]] = b[offset + i];
        }
        return a;
    }


    /**
     * Distributes the elements of the source array to the specified positions
     * in the target array. <code>shuffle</code> does not check the integrity
     * of the index array!
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

    public static boolean[] shuffle(final boolean[] a, final boolean[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }

    public static char[] shuffle(final char[] a, final char[] b, final int[] idx)
    {
        return shuffle(0, a, b, idx);
    }
    
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="swap">
    
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


    public static boolean[] swap(final boolean[] array, final int i, final int j)
    {
        final boolean s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    public static char[] swap(final char[] array, final int i, final int j)
    {
        final char s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="swapSegments">
    
    /**
     * Swaps all elements of two segments of an array. The two segments shall not overlap.
     * 
     * @param first0 The first element of the first segment
     * @param first1 The first element of the second segment
     * @param length The length of the segment
     * @param a The array
     * @return The array
     */
    public static byte[] swapSegments(final int first0, final int first1, final int length, final byte[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static short[] swapSegments(final int first0, final int first1, final int length, final short[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static int[] swapSegments(final int first0, final int first1, final int length, final int[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static long[] swapSegments(final int first0, final int first1, final int length, final long[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static float[] swapSegments(final int first0, final int first1, final int length, final float[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static double[] swapSegments(final int first0, final int first1, final int length, final double[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static boolean[] swapSegments(final int first0, final int first1, final int length, final boolean[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    
    public static char[] swapSegments(final int first0, final int first1, final int length, final char[] a)
    {
        int iter0 = first0;
        int iter1 = first1;
        for(int i = 0; i < length; i++)
        {
            swap(a, iter0++, iter1++);
        }
        return a;
    }
    // </editor-fold>
    /////////////////////////////////////////////////////////////////////////// 
    
    ///////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="unique">

    /**
     * Moves duplicate values to the end of an array and returns the length
     * of the duplicate-free segment.
     * 
     * @param offset The offset to the first element of the target array.
     * @param  length The length of the segment.
     * @param a The array.
     * @return The length of the duplicate-free segment
     */
    public static int unique(final int offset, final int length, final byte[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final short[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final int[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final long[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final float[] a, final float eps)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(Math.abs(a[i - 1] - a[i]) < eps)
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final double[] a, final double eps)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(Math.abs(a[i - 1] - a[i]) < eps)
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }

    public static int unique(final int offset, final int length, final boolean[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }
        
    public static int unique(final int offset, final int length, final char[] a)
    {
        int last = offset + length;
        int i = offset + 1;
        while(i < last)
        {   
            while(a[i - 1] == a[i])
            {
                rotate(i, offset + length - i, a, 1);
                last--;
                if(i == last)
                {
                    return last - offset;
                }
            }
            i++;
        }
        return length;
    }

    /**
     * Moves duplicate values to the end of an array and returns the length
     * of the duplicate-free segment.
     * 
     * @param a The array.
     * @return The length of the duplicate-free segment
     */
    public static int unique(final byte[] a)
    {
        return unique(0, a.length, a);
    }
    
    public static int unique(final short[] a)
    {
        return unique(0, a.length, a);
    }
    
    public static int unique(final int[] a)
    {
        return unique(0, a.length, a);
    }
    
    public static int unique(final long[] a)
    {
        return unique(0, a.length, a);
    }
    
    public static int unique(final float[] a, final float eps)
    {
        return unique(0, a.length, a, eps);
    }
    
    public static int unique(final double[] a, final double eps)
    {
        return unique(0, a.length, a, eps);
    }
    
    public static int unique(final boolean[] a)
    {
        return unique(0, a.length, a);
    }
    
    public static int unique(final char[] a)
    {
        return unique(0, a.length, a);
    }
    
    
    /**
     * Moves duplicate values to the end of an array and returns the length
     * of the duplicate-free segment.
     * 
     * @param offa The offset to the first element of the target array.
     * @param offb The offset to the first element of the source array.
     * @param length The length of the segment
     * @param a The target array.
     * @param b The source array.
     * @return The length of the duplicate-free segment
     */    
    public static int unique(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    public static int unique(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    public static int unique(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    public static int unique(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    public static int unique(final int offa, final int offb, final int length, final float[] a, final float[] b, final float eps)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a, eps);
    }
    
    public static int unique(final int offa, final int offb, final int length, final double[] a, final double[] b, final double eps)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a, eps);
    }

    public static int unique(final int offa, final int offb, final int length, final boolean[] a, final boolean[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    public static int unique(final int offa, final int offb, final int length, final char[] a, final char[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return unique(offa, length, a);
    }
    
    
    /**
     * Moves duplicate values to the end of an array and returns the length
     * of the duplicate-free segment.
     * 
     * @param a The target array.
     * @param b The source array.
     * @return The length of the duplicate-free segment
     */    
    public static int unique(final byte[] a, final byte[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    public static int unique(final short[] a, final short[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    public static int unique(final int[] a, final int[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    public static int unique(final long[] a, final long[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    public static int unique(final float[] a, final float[] b, final float eps)
    {
        return unique(0, 0, a.length, a, b, eps);
    }
    
    public static int unique(final double[] a, final double[] b, final double eps)
    {
        return unique(0, 0, a.length, a, b, eps);
    }
    
    public static int unique(final boolean[] a, final boolean[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    public static int unique(final char[] a, final char[] b)
    {
        return unique(0, 0, a.length, a, b);
    }
    
    // </editor-fold>
    ///////////////////////////////////////////////////////////////////////////
    
    
}
