/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.improc;

/**
 *
 * @author Alexander Heusel
 */
public class Tuple3i
{

    public int x;
    public int y;
    public int z;

    /**
     * Constructs and initializes a Tuple3f to (0,0,0).
     */
    public Tuple3i()
    {
        x = y = z = 0;
    }

    /**
     * Constructs and initializes a Tuple3f from the array of length 3.
     *
     * @param t
     */
    public Tuple3i(int[] t)
    {
        x = t[0];
        y = t[1];
        z = t[2];
    }

    /**
     * Constructs and initializes a Tuple3f from the specified xyz coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public Tuple3i(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @param t1
     */
    public Tuple3i(Tuple3i t1)
    {
        this.x = t1.x;
        this.y = t1.y;
        this.z = t1.z;
    }

    /**
     * Sets each component of this tuple to its absolute value.
     */
    public void absolute()
    {
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
    }

    /**
     * Sets each component of the tuple parameter to its absolute value and
     * places the modified values into this tuple.
     *
     * @param t
     */
    public void absolute(Tuple3i t)
    {
        x = Math.abs(t.x);
        y = Math.abs(t.y);
        z = Math.abs(t.z);
    }

    /**
     * Sets the value of this tuple to the vector sum of itself and tuple t1.
     *
     * @param t1
     */
    public void add(Tuple3i t1)
    {
        x += t1.x;
        y += t1.y;
        z += t1.z;
    }

    /**
     * Sets the value of this tuple to the vector sum of tuples t1 and t2.
     *
     * @param t1
     * @param t2
     */
    public void add(Tuple3i t1, Tuple3i t2)
    {
        x = t1.x + t2.x;
        y = t1.y + t2.y;
        z = t1.z + t2.z;
    }

    /**
     * Clamps this tuple to the range [low, high].
     *
     * @param min
     * @param max
     */
    public void clamp(int min, int max)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Clamps the tuple parameter to the range [low, high] and places the values
     * into this tuple.
     *
     * @param min
     * @param max
     * @param t
     */
    public void clamp(int min, int max, Tuple3i t)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Clamps the maximum value of this tuple to the max parameter.
     *
     * @param max
     */
    public void clampMax(int max)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Clamps the maximum value of the tuple parameter to the max parameter and
     * places the values into this tuple.
     *
     * @param max
     * @param t
     */
    public void clampMax(int max, Tuple3i t)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Clamps the minimum value of this tuple to the min parameter.
     *
     * @param min
     */
    public void clampMin(int min)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Clamps the minimum value of the tuple parameter to the min parameter and
     * places the values into this tuple.
     *
     * @param min
     * @param t
     */
    public void clampMin(int min, Tuple3i t)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Creates a new object of the same class as this object.
     */
    @Override
    public java.lang.Object clone()
    {
        return new Tuple3i(this.x, this.y, this.z);
    }

    /**
     * Returns true if the L-infinite distance between this tuple and tuple t1
     * is less than or equal to the epsilon parameter, otherwise returns false.
     *
     * @param t1
     * @param epsilon
     * @return
     */
    public boolean epsilonEquals(Tuple3i t1, int epsilon)
    {
        return Math.abs(x - t1.x) < epsilon && Math.abs(y - t1.y) < epsilon && Math.abs(z - t1.z) < epsilon;
    }

    /**
     * Returns true if the Object t1 is of type Tuple3f and all of the data
     * members of t1 are equal to the corresponding data members in this
     * Tuple3f.
     *
     * @param t1
     * @return
     */
    @Override
    public boolean equals(java.lang.Object t1)
    {
        if(!(t1 instanceof Tuple3i))
        {
            return false;
        }
        return equals((Tuple3i) t1);
    }

    /**
     * Returns true if the Object t1 is of type Tuple3f and all of the data
     * members of t1 are equal to the corresponding data members in this
     * Tuple3f.
     *
     * @param t1
     * @return
     */
    public boolean equals(Tuple3i t1)
    {
        return epsilonEquals(t1, Integer.MIN_VALUE);
    }

    /**
     * Gets the value of this tuple and copies the values into t.
     *
     * @param t
     */
    public void get(int[] t)
    {
        t[0] = x;
        t[1] = y;
        t[2] = z;
    }

    /**
     * Gets the value of this tuple and copies the values into t.
     *
     * @param t
     */
    public void get(Tuple3i t)
    {
        t.x = x;
        t.y = y;
        t.z = z;
    }

    /**
     * Returns a hash code value based on the data values in this object.
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    /**
     * Linearly interpolates between this tuple and tuple t1 and places the
     * result into this tuple: this = (1-alpha)*this + alpha*t1.
     *
     * @param t1
     * @param alpha
     */
    public void interpolate(Tuple3i t1, int alpha)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Linearly interpolates between tuples t1 and t2 and places the result into
     * this tuple: this = (1-alpha)*t1 + alpha*t2.
     *
     * @param t1
     * @param t2
     * @param alpha
     */
    public void interpolate(Tuple3i t1, Tuple3i t2, int alpha)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Negates the value of this tuple in place.
     */
    public void negate()
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this tuple to the negation of tuple t1.
     *
     * @param t1
     */
    public void negate(Tuple3i t1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this tuple to the scalar multiplication of the scale
     * factor with this.
     *
     * @param s
     */
    public void scale(int s)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this vector to the scalar multiplication of tuple t1.
     *
     * @param s
     * @param t1
     */
    public void scale(int s, Tuple3i t1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this tuple to the scalar multiplication of itself and
     * then adds tuple t1 (this = s*this + t1).
     *
     * @param s
     * @param t1
     */
    public void scaleAdd(int s, Tuple3i t1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this tuple to the scalar multiplication of tuple t1 and
     * then adds tuple t2 (this = s*t1 + t2).
     *
     * @param s
     * @param t1
     * @param t2
     */
    public void scaleAdd(int s, Tuple3i t1, Tuple3i t2)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets the value of this tuple to the xyz coordinates specified in the
     * array of length 3.
     *
     * @param t
     */
    public void set(int[] t)
    {
        x = t[0];
        y = t[1];
        z = t[2];
    }

    /**
     * Sets the value of this tuple to the specified xyz coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public void set(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Sets the value of this tuple to the value of tuple t1.
     *
     * @param t1
     */
    public void set(Tuple3i t1)
    {
        this.x = t1.x;
        this.y = t1.y;
        this.z = t1.z;
    }

    /**
     * Sets the value of this tuple to the vector difference of itself and tuple
     * t1 (this = this - t1) .
     *
     * @param t1
     */
    public void sub(Tuple3i t1)
    {
        this.x -= t1.x;
        this.y -= t1.y;
        this.z -= t1.z;
    }

    /**
     * Sets the value of this tuple to the vector difference of tuples t1 and t2
     * (this = t1 - t2).
     *
     * @param t1
     * @param t2
     */
    public void sub(Tuple3i t1, Tuple3i t2)
    {
        this.x = t1.x - t2.x;
        this.y = t1.y - t2.y;
        this.z = t1.z - t2.z;
    }

    /**
     * Returns a string that contains the values of this Tuple3f.
     */
    @Override
    public java.lang.String toString()
    {
        return String.format("(%f, %f, %f)", x, y, z);
    }

    private static int clamp(final int min, final int max, final int value)
    {
        if(value > max)
        {
            return max;
        }
        if(value < min)
        {
            return min;
        }
        return value;
    }
}
