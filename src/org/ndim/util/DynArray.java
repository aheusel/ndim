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

/**
 * This class contains a set of static function to manage plain java-arrays as
 * dynamic ones. It supplies functions to resize them insert, remove, prepend and
 * append elements.
 * 
 * @author Alexander Heusel
 */
public class DynArray
{

    private static int capacityFromSize(int size, int minCapacity)
    {
        if(size <= minCapacity)
        {
            return minCapacity;
        }

        int capacity = 1;
        while(capacity < size)
        {
            capacity <<= 1;
        }

        return capacity > minCapacity ? capacity : minCapacity;
    }

    /**
     * Creates a dynamic resizeable plain Java-array.
     * 
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @return Returns a new array.
     */
    public static byte[] createByte(int size, int minCapacity)
    {
        return resize((byte[]) null, size, minCapacity);
    }

    /**
     * @see createByte
     */
    public static short[] createShort(int size, int minCapacity)
    {
        return resize((short[]) null, size, minCapacity);
    }

    public static int[] createInt(int size, int minCapacity)
    {
        return resize((int[]) null, size, minCapacity);
    }

    public static long[] createLong(int size, int minCapacity)
    {
        return resize((long[]) null, size, minCapacity);
    }

    public static float[] createFloat(int size, int minCapacity)
    {
        return resize((float[]) null, size, minCapacity);
    }

    public static double[] createDouble(int size, int minCapacity)
    {
        return resize((double[]) null, size, minCapacity);
    }

    /**
     * Handles the dynamic resizing of plain Java-arrays.
     * 
     * @param array The array to resize.
     * @param size The new size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] resize(byte[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new byte[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            byte[] res = new byte[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            byte[] res = new byte[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    public static short[] resize(short[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new short[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            short[] res = new short[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            short[] res = new short[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    public static int[] resize(int[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new int[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            int[] res = new int[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            int[] res = new int[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    public static long[] resize(long[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new long[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            long[] res = new long[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            long[] res = new long[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    public static float[] resize(float[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new float[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            float[] res = new float[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            float[] res = new float[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    public static double[] resize(double[] array, int size, int minCapacity)
    {

        // Init capacity with neg. value to show that it has to be determined.
        int capacity = -1;

        // NULL-Pointer; create array
        if(array == null)
        {
            capacity = capacityFromSize(size, minCapacity);
            return (capacity > 0) ? new double[capacity] : null;
        }

        // Determine the capacity required for the new size
        // of the array.
        capacity = capacityFromSize(size, minCapacity);

        // Capacity is smaller, shrink the array.
        if(capacity < array.length)
        {
            double[] res = new double[capacity];
            System.arraycopy(array, 0, res, 0, size);
            return res;
        } // Capacity is greater, grow the array.
        else if(capacity > array.length)
        {
            double[] res = new double[capacity];
            System.arraycopy(array, 0, res, 0, array.length);
            return res;
        }

        // No capacity change.
        return array;
    }

    /**
     * Inserts space for a given number of values in an array.
     * 
     * @param array The array to resize.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param pos The index at which the values are inserted.
     * @param length The number of values to insert.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] insertSpace(byte[] array, int size, int minCapacity, int pos, int length)
    {
        byte[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    public static short[] insertSpace(short[] array, int size, int minCapacity, int pos, int length)
    {
        short[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    public static int[] insertSpace(int[] array, int size, int minCapacity, int pos, int length)
    {
        int[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    public static long[] insertSpace(long[] array, int size, int minCapacity, int pos, int length)
    {
        long[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    public static float[] insertSpace(float[] array, int size, int minCapacity, int pos, int length)
    {
        float[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    public static double[] insertSpace(double[] array, int size, int minCapacity, int pos, int length)
    {
        double[] res = resize(array, length + size, minCapacity);
        for(int i = size - 1; i > pos - 1; i--)
        {
            res[i + length] = res[i];
        }
        return res;
    }

    /**
     * Inserts values in an array.
     * 
     * @param array The array to resize.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param pos The index at which the values are inserted.
     * @param values The number of values to insert.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] insert(byte[] array, int size, int minCapacity, int pos, byte[] values)
    {
        byte[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    public static short[] insert(short[] array, int size, int minCapacity, int pos, short[] values)
    {
        short[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    public static int[] insert(int[] array, int size, int minCapacity, int pos, int[] values)
    {
        int[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    public static long[] insert(long[] array, int size, int minCapacity, int pos, long[] values)
    {
        long[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    public static float[] insert(float[] array, int size, int minCapacity, int pos, float[] values)
    {
        float[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    public static double[] insert(double[] array, int size, int minCapacity, int pos, double[] values)
    {
        double[] res = insertSpace(array, size, minCapacity, pos, values.length);
        for(int i = 0; i < values.length; i++)
        {
            res[pos + i] = values[i];
        }
        return res;
    }

    /**
     * Inserts a value in an array.
     * 
     * @param array The array to resize.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param pos The index at which the values are inserted.
     * @param value The values to insert.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] insert(byte[] array, int size, int minCapacity, int pos, byte value)
    {
        byte[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = value;
        return res;
    }

    public static short[] insert(short[] array, int size, int minCapacity, int pos, short values)
    {
        short[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = values;
        return res;
    }

    public static int[] insert(int[] array, int size, int minCapacity, int pos, int values)
    {
        int[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = values;
        return res;
    }

    public static long[] insert(long[] array, int size, int minCapacity, int pos, long values)
    {
        long[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = values;
        return res;
    }

    public static float[] insert(float[] array, int size, int minCapacity, int pos, float values)
    {
        float[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = values;
        return res;
    }

    public static double[] insert(double[] array, int size, int minCapacity, int pos, double values)
    {
        double[] res = insertSpace(array, size, minCapacity, pos, 1);
        res[pos] = values;
        return res;
    }

    /**
     * Removes the given number of values from the array
     * 
     * @param array The array to remove the values from.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param pos The start index from which the values are removed.
     * @param length The number of values to be removed.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] remove(byte[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    public static short[] remove(short[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    public static int[] remove(int[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    public static long[] remove(long[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    public static float[] remove(float[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    public static double[] remove(double[] array, int size, int minCapacity, int pos, int length)
    {
        for(int i = pos + length; i < size; i++)
        {
            array[i - length] = array[i];
        }
        return resize(array, size - length, minCapacity);
    }

    /**
     * Replaces a block in the array by the argument values.
     * 
     * @param array The array containing the values to replace.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param pos The start index of the values to be replaced.
     * @param length The number of values to be replaced.
     * @param values The values which replace the original ones.
     * @return Returns a new array when the capacity changes, the old one
     * when the capacity remains the same.
     */
    public static byte[] replace(byte[] array, int size, int minCapacity, int pos, int length, byte[] values)
    {
        byte[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    public static short[] replace(short[] array, int size, int minCapacity, int pos, int length, short[] values)
    {
        short[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    public static int[] replace(int[] array, int size, int minCapacity, int pos, int length, int[] values)
    {
        int[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    public static long[] replace(long[] array, int size, int minCapacity, int pos, int length, long[] values)
    {
        long[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    public static float[] replace(float[] array, int size, int minCapacity, int pos, int length, float[] values)
    {
        float[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    public static double[] replace(double[] array, int size, int minCapacity, int pos, int length, double[] values)
    {
        double[] res = array;
        int delta = values.length - length;
        if(delta > 0)
        {
            res = insertSpace(array, size, minCapacity, pos, delta);
        }
        else if(delta < 0)
        {
            res = remove(array, size, minCapacity, pos, -delta);
        }

        System.arraycopy(values, 0, res, pos, values.length);
        return res;
    }

    /**
     * Appends a single value to an array.
     * 
     * @param array The array to which the value will be appended.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param value The value to append.
     */
    public static byte[] append(byte[] array, int size, int minCapacity, byte value)
    {
        byte[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    public static short[] append(short[] array, int size, int minCapacity, short value)
    {
        short[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    public static int[] append(int[] array, int size, int minCapacity, int value)
    {
        int[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    public static long[] append(long[] array, int size, int minCapacity, long value)
    {
        long[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    public static float[] append(float[] array, int size, int minCapacity, float value)
    {
        float[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    public static double[] append(double[] array, int size, int minCapacity, double value)
    {
        double[] res = resize(array, size + 1, minCapacity);
        res[size] = value;
        return res;
    }

    /**
     * Appends an value-array to this array.
     * 
     * @param array The array to which the other array will be appended.
     * @param size The size of this array.
     * @param minCapacity The minimal capacity of the array.
     * @param values The values to append.
     */
    public static byte[] append(byte[] array, int size, int minCapacity, byte[] values)
    {
        byte[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    public static short[] append(short[] array, int size, int minCapacity, short[] values)
    {
        short[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    public static int[] append(int[] array, int size, int minCapacity, int[] values)
    {
        int[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    public static long[] append(long[] array, int size, int minCapacity, long[] values)
    {
        long[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    public static float[] append(float[] array, int size, int minCapacity, float[] values)
    {
        float[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    public static double[] append(double[] array, int size, int minCapacity, double[] values)
    {
        double[] res = resize(array, size + values.length, minCapacity);
        System.arraycopy(values, 0, res, size, values.length);
        return res;
    }

    /**
     * Prepends a single value to an array.
     * 
     * @param array The array to which the value will be prepended.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param value The value to prepend.
     */
    public static byte[] prepend(byte[] array, int size, int minCapacity, byte value)
    {
        byte[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    public static short[] prepend(short[] array, int size, int minCapacity, short value)
    {
        short[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    public static int[] prepend(int[] array, int size, int minCapacity, int value)
    {
        int[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    public static long[] prepend(long[] array, int size, int minCapacity, long value)
    {
        long[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    public static float[] prepend(float[] array, int size, int minCapacity, float value)
    {
        float[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    public static double[] prepend(double[] array, int size, int minCapacity, double value)
    {
        double[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, 1, size);
        res[0] = value;
        return res;
    }

    /**
     * Prepends a value-array to an array.
     * 
     * @param array The array to which the value will be prepended.
     * @param size The size of the array.
     * @param minCapacity The minimal capacity of the array.
     * @param value The values to be prepended.
     */
    public static byte[] prepend(byte[] array, int size, int minCapacity, byte[] value)
    {
        byte[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }

    public static short[] prepend(short[] array, int size, int minCapacity, short[] value)
    {
        short[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }

    public static int[] prepend(int[] array, int size, int minCapacity, int[] value)
    {
        int[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }

    public static long[] prepend(long[] array, int size, int minCapacity, long[] value)
    {
        long[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }

    public static float[] prepend(float[] array, int size, int minCapacity, float[] value)
    {
        float[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }

    public static double[] prepend(double[] array, int size, int minCapacity, double[] value)
    {
        double[] res = resize(array, size + 1, minCapacity);
        System.arraycopy(array, 0, res, value.length, size);
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }
}
