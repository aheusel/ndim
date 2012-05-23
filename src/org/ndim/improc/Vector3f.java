/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.improc;

/**
 *
 * @author Alexander Heusel
 */
public class Vector3f extends Tuple3f
{

    /**
     * Constructs and initializes a Vector3f to (0,0,0).
     */
    public Vector3f()
    {
        super();
    }

    /**
     * Constructs and initializes a Vector3f from the array of length 3.
     *
     * @param v
     */
    public Vector3f(float[] v)
    {
        super(v);
    }

    /**
     * Constructs and initializes a Vector3f from the specified xyz coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector3f(float x, float y, float z)
    {
        super(x, y, z);
    }

    /**
     * Constructs and initializes a Vector3f from the specified Tuple3f.
     *
     * @param t1
     */
    public Vector3f(Tuple3f t1)
    {
        super(t1);
    }

    /**
     * Constructs and initializes a Vector3f from the specified Vector3f.
     *
     * @param v1
     */
    public Vector3f(Vector3f v1)
    {
        super(v1);
    }

    /**
     * Returns the angle in radians between this vector and the vector
     * parameter; the return value is constrained to the range [0,PI].
     *
     * @param v1
     * @return
     */
    public float angle(Vector3f v1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Sets this vector to be the vector cross product of vectors v1 and v2.
     *
     * @param v1
     * @param v2
     */
    public void cross(Vector3f v1, Vector3f v2)
    {
        this.x = v1.y*v2.z-v1.z*v2.y;
        this.y = v1.z*v2.x-v1.x*v2.z;
        this.z = v1.x*v2.y-v1.y*v2.x;
    }

    /**
     * Computes the dot product of this vector and vector v1.
     *
     * @param v1
     * @return
     */
    public float dot(Vector3f v1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Returns the length of this vector.
     *
     * @return
     */
    public float length()
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Returns the squared length of this vector.
     *
     * @return
     */
    public float lengthSquared()
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Normalizes this vector in place.
     */
    public void normalize()
    {
        float norm = (float)Math.sqrt(x*x + y*y + z*z);
        x /= norm;
        y /= norm;
        z /= norm;
    }

    /**
     * Sets the value of this vector to the normalization of vector v1.
     *
     * @param v1
     */
    public void normalize(Vector3f v1)
    {
        float norm = (float)Math.sqrt(v1.x*v1.x + v1.y*v1.y + v1.z*v1.z);
        x = v1.x / norm;
        y = v1.y / norm;
        z = v1.z / norm;
    }
}
