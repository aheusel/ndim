/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.io.IOException;
import java.nio.FloatBuffer;



/**
 *
 * @author Alexander Heusel
 */
public class SparseMatrixFloatCRSe implements MatrixFloat, SparseMatrix
{
    protected int m = 0;
    protected int n = 0;
    protected int nrCoeffs = 0;
    protected int[] col_ind = null;
    protected float[] val = null;
    protected int[] row_ptr = null;

    public SparseMatrixFloatCRSe() {}

    public SparseMatrixFloatCRSe(final CRSInputStream s) throws IOException
    {
        set(s);
    }
    
    /**
     * Sets the matrix storage to the given number of columns, rows and coefficients.
     *
     * @param nrRows The number of rows of the matrix.
     * @param nrCols The number of columns of the matrix.
     * @param nrCoeffs The number of coefficients of the matrix.

     */
    protected final void set(final int nrRows, final int nrCols, final int nrCoeffs)
    {
        m = nrRows;
        n = nrCols;
        this.nrCoeffs = nrCoeffs;
        col_ind = new int[nrCoeffs];
        val = new float[nrCoeffs];
        row_ptr = new int[nrRows + 1];
    }


    /**
     * Sets the matrix to the contents of the CRSInputStream
     * 
     * @param s CRSInputStream containing the matrix-data.
     */
    public final void set(final CRSInputStream s) throws IOException
    {
        set(s.nrRows(), s.nrColumns(), s.nrCoeffs());
        s.read(col_ind, val, row_ptr);        
    }
    
    
    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    @Override
    public final int nrRows() {return m; }

    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    @Override
    public final int m() { return m;}

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    @Override
    public final int nrColumns() { return n;}

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    @Override
    public final int n() { return n; }

    /**
     * Returns the number of coefficients stored in the matrix.
     *
     * @return The number of coefficients stored in the matrix.
     */
    @Override
    public final int nrCoeffs() {return nrCoeffs;}

    /**
     * Performs a multiplication of a vector with this matrix.<br>
     *
     * {@latex[ A\cdot\vec{a} \rightarrow \vec{b}}
     *
     * @param a Source vector.
     * @param b Target vector.
     */
    @Override
    public final void mul(final float[] a, final float[] b)
    {
        float rowSum;
        int bIter = 0;

        for(int i = 0; i < m; i++)
        {
            rowSum = 0.0f;

            for(int j = row_ptr[i]; j < row_ptr[i + 1]; j++)
            {
                rowSum += val[j] * a[col_ind[j]];
            }
            b[bIter++] = rowSum;
        }

    }

    @Override
    public void mul(FloatBuffer a, FloatBuffer b)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public final void calcResidual(float[] x, float[] b, float[] r)
    {
        int bIter = 0;
        int xIter = 0;

        float rowSum;

        for(int i = 0; i < m; i++)
        {
            rowSum = 0.0f;

            for(int j = row_ptr[i]; j < row_ptr[i + 1]; j++)
            {
                rowSum += val[j] * x[col_ind[j]];
            }
            r[xIter++] = b[bIter++] - rowSum;
        }
        
    }

    @Override
    public void calcResidual(FloatBuffer x, FloatBuffer b, FloatBuffer r)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        int rowIter;
        int rowEnd;
        for(int i = 0; i < m; i++)
        {
            rowIter = row_ptr[i];
            rowEnd = row_ptr[i + 1];
            for(int j = 0; j < n; j++)
            {
                if(rowIter < rowEnd)
                {
                    if(j == col_ind[rowIter])
                    {
                        sb.append(String.format("%+5.2f ", val[rowIter++]));
                    }
                    else
                    {
                        sb.append("  0   ");
                    }
                }
                else
                {
                    sb.append("  0   ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    
    
    
}
