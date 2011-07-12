/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.nio.FloatBuffer;


/**
 *
 * @author Alexander Heusel
 */
public interface MatrixFloat extends Matrix
{

    /**
     * Performs a multiplication of a vector with this matrix.<br>
     *
     * {@latex[ A\cdot\vec{a} \rightarrow \vec{b}}
     *
     * @param a Source vector.
     * @param b Target vector.
     */
    public void mul(final float[] a, final float[] b);

    
    /**
     * Performs a multiplication of a vector with this matrix.<br>
     *
     * {@latex[ A\cdot\vec{a} \rightarrow \vec{b}}
     *
     * @param a Source vector.
     * @param b Target vector.
     */
    public void mul(final FloatBuffer a, final FloatBuffer b);
    
    
    /**
     * Calculates the residual of the linear equation
     *
     * @param x The left-hand-side of the equation
     * @param b The right-hand-side of the equation
     * @param r The residual
     */
    public void calcResidual(final float[] x, final float[] b, final float[] r);

    
    /**
     * Calculates the residual of the linear equation
     *
     * @param x The left-hand-side of the equation
     * @param b The right-hand-side of the equation
     * @param r The residual
     */
    public void calcResidual(final FloatBuffer x, final FloatBuffer b, final FloatBuffer r);
    
    
}
