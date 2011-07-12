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
public abstract class SparseMatrixFloatCRS implements MatrixFloat, SparseMatrix
{

    @Override
    public void mul(float[] a, float[] b)
    {
        
    }

    @Override
    public void mul(FloatBuffer a, FloatBuffer b)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void calcResidual(float[] x, float[] b, float[] r)
    {
        
    }

    @Override
    public void calcResidual(FloatBuffer x, FloatBuffer b, FloatBuffer r)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public final int nrRows()
    {
        
    }

    @Override
    public final int m()
    {
        
    }

    @Override
    public final int nrColumns()
    {
        
    }

    @Override
    public final int n()
    {
        
    }

    @Override
    public final int nrCoeff()
    {
        
    }
    
}
