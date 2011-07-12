/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.nio.DoubleBuffer;

/**
 *
 * @author Alexander Heusel
 */
public interface MatrixDouble extends Matrix
{

    /**
     * Performs a multiplication of a vector with this matrix.<br>
     *
     * {@latex[ A\cdot\vec{a} \rightarrow \vec{b}}
     *
     * @param a Source vector.
     * @param b Target vector.
     */
    public void mul(final double[] a, final double[] b);

    
    /**
     * Performs a multiplication of a vector with this matrix.<br>
     *
     * {@latex[ A\cdot\vec{a} \rightarrow \vec{b}}
     *
     * @param a Source vector.
     * @param b Target vector.
     */
    public void mul(final DoubleBuffer a, final DoubleBuffer b);
    
    
    /**
     * Calculates the residual of the linear equation
     *
     * @param x The left-hand-side of the equation
     * @param b The right-hand-side of the equation
     * @param r The residual
     */
    public void calcResidual(final double[] x, final double[] b, final double[] r);

    
    /**
     * Calculates the residual of the linear equation
     *
     * @param x The left-hand-side of the equation
     * @param b The right-hand-side of the equation
     * @param r The residual
     */
    public void calcResidual(final DoubleBuffer x, final DoubleBuffer b, final DoubleBuffer r);
    
}
