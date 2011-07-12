/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.io.IOException;

/**
 *
 * @author Alexander Heusel
 */
public interface CRSInputStream
{
    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    public int nrRows();

    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    public int m();

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    public int nrColumns();

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    public int n();
    
    
    /**
     * Returns the number of coefficients stored in this input-stream.
     * 
     * @return Number of ceofficients.
     */
    public int nrCoeffs();    
    
    /**
     * Reads a matrix in MatrixMarket format from the given InputStream to a CRS format.
     * 
     * @param col_ind The col_ind-array of the CRS Matrix.
     * @param val The value-array of the CRS Matrix
     * @param row_ptr The row_ptr-array of the CRS Matrix;
     */
    public void read(final int[] col_ind, float[] val, final int[] row_ptr) throws IOException;
    
    /**
     * Reads a matrix in MatrixMarket format from the given InputStream to a CRS format.
     * 
     * @param col_ind The col_ind-array of the CRS Matrix.
     * @param val The value-array of the CRS Matrix
     * @param row_ptr The row_ptr-array of the CRS Matrix;
     */
    public void read(final int[] col_ind, double[] val, final int[] row_ptr) throws IOException;
    
}
