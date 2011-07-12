/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.io.*;
import java.util.*;

/**
 *
 * @author aheusel
 */
public class MatrixMarketCRSInputStream implements CRSInputStream
{
    final InputStream s;
    final int m;
    final int n;
    final int nrCoeffs;
    
    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    @Override
    public final int nrRows() {return m;}

    /**
     * Returns the number of rows stored in the matrix.
     *
     * @return The number of rows stored in the matrix.
     */
    @Override
    public final int m() {return m;}

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    @Override
    public final int nrColumns() {return n;}

    /**
     * Returns the number of columns stored in the matrix.
     *
     * @return The number of columns stored in the matrix.
     */
    @Override
    public final int n() {return n;}
    
    
    @Override
    public final int nrCoeffs() {return nrCoeffs;}
    
    
    public MatrixMarketCRSInputStream(final InputStream s) throws IOException
    {
        this.s = s;
        Scanner sc = new Scanner(s);
        sc.useLocale(Locale.US);
        
        // Get header and check for correct format.
        if(!sc.hasNextLine())
        {
            throw new java.io.IOException("Premature EOF.");
        }
        String[] parts = sc.nextLine().split(" ");
        for(int i = 1; i < parts.length; i++)
        {
            parts[i].toLowerCase();
        }
        if(!parts[0].equals("%%MatrixMarket") || parts.length != 5)
        {
            throw new java.io.IOException("Not in MatrixMarket format.");
        }

        if(!(   parts[1].equals("matrix") &&
                parts[2].equals("coordinate") &&
                parts[3].equals("real") &&
                parts[4].equals("general")))
        {
            throw new IOException(
                    String.format(  "Unsupported format: %s %s %s %s",
                                    parts[1], parts[2], parts[3], parts[4]));
        }

        // Continue scanning until we reach the end-of-comments
        String line = null;
        while(sc.hasNextLine())
        {
            line = sc.nextLine();
            if(!line.startsWith("%") && !line.isEmpty())
            {
                break;
            }
        }
        if(line == null)
        {
            throw new IOException("Premature EOF.");
        }
        final Scanner ls = new Scanner(line);
        m = ls.nextInt();
        n = ls.nextInt();
        nrCoeffs = ls.nextInt();

    }      
    
    private static final class ColIdxValPairF implements Comparable<ColIdxValPairF>
    {
        public final int colIdx;
        public final float value;
        public ColIdxValPairF(final int colIdx, final float value)
        {
            this.colIdx = colIdx;
            this.value = value;
        }

        @Override
        public final int compareTo(ColIdxValPairF o2)
        {
            //a negative integer as the first argument is less than the second.
            //zero as the first argument is equal to the second.
            //a positive integer as the first argument is greater than the second.

            if(colIdx < o2.colIdx)
            {
                return -1;
            }
            else if(colIdx == o2.colIdx)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }    
    
    private static final class ColIdxValPairD implements Comparable<ColIdxValPairD>
    {
        public final int colIdx;
        public final double value;
        public ColIdxValPairD(final int colIdx, final double value)
        {
            this.colIdx = colIdx;
            this.value = value;
        }

        @Override
        public final int compareTo(ColIdxValPairD o2)
        {
            //a negative integer as the first argument is less than the second.
            //zero as the first argument is equal to the second.
            //a positive integer as the first argument is greater than the second.

            if(colIdx < o2.colIdx)
            {
                return -1;
            }
            else if(colIdx == o2.colIdx)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }
    
    /**
     * Reads a matrix in MatrixMarket format from the given InputStream to a CRS format.
     * 
     * @param col_ind The col_ind-array of the CRS Matrix.
     * @param val The value-array of the CRS Matrix
     * @param row_ptr The row_ptr-array of the CRS Matrix;
     */
    @Override
    public final void read(final int[] col_ind, float[] val, final int[] row_ptr) throws IOException
    {
        Scanner sc = new Scanner(s);
        sc.useLocale(Locale.US);
        
        // Fill table with values
        ArrayList<?>[] rows = new ArrayList<?>[nrRows()];
        ArrayList<ColIdxValPairF> currentRow = null;
        int colIdx;
        int rowIdx;
        float value;
        for(int i = 0; i < nrCoeffs(); i++)
        {
            rowIdx = sc.nextInt() - 1;
            colIdx = sc.nextInt() - 1;
            value = (float)sc.nextDouble();
            currentRow = (ArrayList<ColIdxValPairF>) rows[rowIdx];
            if(currentRow == null)
            {
                 rows[rowIdx] = currentRow = new ArrayList<ColIdxValPairF>();
            }
            currentRow.add(new ColIdxValPairF(colIdx, value));
        }

        // Transfer the values to the matrix
        int coeffIdx = 0;
        ColIdxValPairF currentPair;
        row_ptr[0] = 0;
        for(int i = 0; i < nrRows(); i++)
        {
            //System.out.format("i: %d ", i);
            currentRow = (ArrayList<ColIdxValPairF>) rows[i];
            Collections.sort(currentRow);
            for(int j = 0; j < currentRow.size(); j++)
            {
                currentPair = currentRow.get(j);
                col_ind[coeffIdx] = currentPair.colIdx;
                val[coeffIdx++] = currentPair.value;
                //System.out.format("(%d|%f)", currentPair.colIdx, currentPair.value);
            }
            row_ptr[i + 1] = coeffIdx;
            //System.out.print("\n");
        }
    }
    
    /**
     * Reads a matrix in MatrixMarket format from the given InputStream to a CRS format.
     * 
     * @param col_ind The col_ind-array of the CRS Matrix.
     * @param val The value-array of the CRS Matrix
     * @param row_ptr The row_ptr-array of the CRS Matrix;
     */
    @Override
    public final void read(final int[] col_ind, double[] val, final int[] row_ptr) throws IOException
    {
        Scanner sc = new Scanner(s);
        sc.useLocale(Locale.US);
        
        // Fill table with values
        ArrayList<?>[] rows = new ArrayList<?>[nrRows()];
        ArrayList<ColIdxValPairD> currentRow = null;
        int colIdx;
        int rowIdx;
        double value;
        for(int i = 0; i < nrCoeffs(); i++)
        {
            rowIdx = sc.nextInt() - 1;
            colIdx = sc.nextInt() - 1;
            value = sc.nextDouble();
            currentRow = (ArrayList<ColIdxValPairD>) rows[rowIdx];
            if(currentRow == null)
            {
                 rows[rowIdx] = currentRow = new ArrayList<ColIdxValPairD>();
            }
            currentRow.add(new ColIdxValPairD(colIdx, value));
        }

        // Transfer the values to the matrix
        int coeffIdx = 0;
        ColIdxValPairD currentPair;
        row_ptr[0] = 0;
        for(int i = 0; i < nrRows(); i++)
        {
            //System.out.format("i: %d ", i);
            currentRow = (ArrayList<ColIdxValPairD>) rows[i];
            Collections.sort(currentRow);
            for(int j = 0; j < currentRow.size(); j++)
            {
                currentPair = currentRow.get(j);
                col_ind[coeffIdx] = currentPair.colIdx;
                val[coeffIdx++] = currentPair.value;
                //System.out.format("(%d|%f)", currentPair.colIdx, currentPair.value);
            }
            row_ptr[i + 1] = coeffIdx;
            //System.out.print("\n");
        }
    }
    
}
