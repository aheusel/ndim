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

package org.ndim.Arrays;

/**
 *
 * @author Alexander Heusel
 */
public class Cast
{
    ///////////////////////////////////////////////////////////////////////////
    // byte
    ///////////////////////////////////////////////////////////////////////////
    
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final byte[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)(b[i + offb] ? 0xff : 0x00);
        }
        return a;
    }
    public static byte[] hard(final int offa, final int offb, final int length, final byte[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    
    public static byte[] hard(final byte[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static byte[] hard(final byte[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    ///////////////////////////////////////////////////////////////////////////
    // short
    ///////////////////////////////////////////////////////////////////////////
    
    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final short[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (short)(b[i + offb] ? 0xffff : 0x0000);
        }
        return a;
    }

    public static short[] hard(final int offa, final int offb, final int length, final short[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (byte)b[i + offb];
        }
        return a;
    }
    

    public static short[] hard(final short[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    public static short[] hard(final short[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // int
    ///////////////////////////////////////////////////////////////////////////
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final int[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = a[i + offa] = (int)(b[i + offb] ? 0xffffffff : 0x00000000);
        }
        return a;
    }
    
    public static int[] hard(final int offa, final int offb, final int length, final int[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (int)b[i + offb];
        }
        return a;
    }
    
    public static int[] hard(final int[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static int[] hard(final int[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    ///////////////////////////////////////////////////////////////////////////
    // long
    ///////////////////////////////////////////////////////////////////////////

    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final long[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = a[i + offa] = (int)(b[i + offb] ? Long.MIN_VALUE : 0);
        }
        return a;
    }
    
    public static long[] hard(final int offa, final int offb, final int length, final long[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (long)b[i + offb];
        }
        return a;
    }
    
    public static long[] hard(final long[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static long[] hard(final long[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }

    
    ///////////////////////////////////////////////////////////////////////////
    // float
    ///////////////////////////////////////////////////////////////////////////

    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final float[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (float)b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] ? 1.0f : 0.0f;
        }
        return a;
    }
    
    public static float[] hard(final int offa, final int offb, final int length, final float[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static float[] hard(final float[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static float[] hard(final float[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // double
    ///////////////////////////////////////////////////////////////////////////

    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final double[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] ? 1.0 : 0.0;
        }
        return a;
    }
    
    public static double[] hard(final int offa, final int offb, final int length, final double[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb];
        }
        return a;
    }
    
    public static double[] hard(final double[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static double[] hard(final double[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // boolean
    ///////////////////////////////////////////////////////////////////////////

    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0.0f ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0.0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final boolean[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static boolean[] hard(final int offa, final int offb, final int length, final boolean[] a, final char[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = b[i + offb] != 0 ? true : false;
        }
        return a;
    }
    
    public static boolean[] hard(final boolean[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static boolean[] hard(final boolean[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // char
    ///////////////////////////////////////////////////////////////////////////

    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final byte[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final short[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final int[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final long[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final float[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final double[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)b[i + offb];
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final boolean[] b)
    {
        for(int i = 0; i < length; i++)
        {
            a[i + offa] = (char)(b[i + offb] ? 0xffff : 0x0000);
        }
        return a;
    }
    
    public static char[] hard(final int offa, final int offb, final int length, final char[] a, final char[] b)
    {
        System.arraycopy(b, offb, a, offa, length);
        return a;
    }
    
    public static char[] hard(final char[] a, final byte[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final short[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final int[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final long[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final float[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final double[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final boolean[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
    public static char[] hard(final char[] a, final char[] b)
    {
        return hard(0, 0, a.length, a, b);
    }
    
}
