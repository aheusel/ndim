/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.improc;

/**
 *
 * @author Alexander Heusel
 */
public class Point3i extends Tuple3i
{

    /**
     * Constructs and initializes a Point3f to (0,0,0).
     */
    public Point3i()
    {
        super();
    }

    /**
     * Constructs and initializes a Point3f from the array of length 3.
     *
     * @param p
     */
    public Point3i(int[] p)
    {
        super(p);
    }

    /**
     * Constructs and initializes a Point3f from the specified xyz coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3i(int x, int y, int z)
    {
        super(x, y, z);
    }

    /**
     * Constructs and initializes a Point3f from the specified Point3f.
     *
     * @param p1
     */
    public Point3i(Point3i p1)
    {
        super(p1);
    }

    /**
     * Constructs and initializes a Point3f from the specified Tuple3f.
     *
     * @param t1
     */
    public Point3i(Tuple3i t1)
    {
        super(t1);
    }

    /**
     * Computes the distance between this point and point p1.
     *
     * @param p1
     * @return
     */
    public float distance(Point3i p1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Computes the L-1 (Manhattan) distance between this point and point p1.
     *
     * @param p1
     * @return
     */
    public float distanceL1(Point3i p1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Computes the L-infinite distance between this point and point p1.
     *
     * @param p1
     * @return
     */
    public float distanceLinf(Point3i p1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Computes the square of the distance between this point and point p1.
     *
     * @param p1
     * @return
     */
    public float distanceSquared(Point3i p1)
    {
        throw new java.lang.UnsupportedOperationException("Unsupported operation.");
    }

}
