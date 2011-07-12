/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

/**
 *
 * @author Alexander Heusel
 */
public interface Matrix
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
    
}
