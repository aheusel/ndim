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
public class SparseMatrixFloatBCRS implements MatrixFloat, SparseMatrix
{
    protected int r = 0;
    protected int c = 0;
    protected int m = 0;
    protected int n = 0;
    protected int nrCoeffs = 0;
    protected int[] row_start = null;
    protected int[] block_ptr = null;
    protected int[] col_idx = null;
    protected float[] value = null;
    
    
    public SparseMatrixFloatBCRS() {}
    
    public SparseMatrixFloatBCRS(final int r, final int c, final CRSInputStream s) throws IOException
    {
        set(r, c, s);
    }
    
    public final void set(final int r, final int c, final CRSInputStream s) throws IOException
    {
        this.r = r;
        this.c = c;
        m = s.m();
        n = s.n();
        nrCoeffs = s.nrCoeffs();
        final int[] col_ind = new int[nrCoeffs];
        final float[] val = new float[nrCoeffs];
        final int[] row_ptr = new int[m];
        s.read(col_ind, val, row_ptr);
        find_cache_block(row_ptr, col_ind, val);
    }

    
    public final int r()
    {
        return r;
    }
    
    public final int c()
    {
        return c;
    }
    
    @Override
    public final int nrRows()
    {
        return m;
    }

    @Override
    public final int m()
    {
        return m;
    }

    @Override
    public final int nrColumns()
    {
        return n;
    }

    @Override
    public final int n()
    {
        return n;
    }

    @Override
    public int nrCoeffs()
    {
        return nrCoeffs;
    }
        
    @Override
    public void mul(float[] a, float[] b)
    {
        int b_m;
        int end_r;

        b_m = (m + r - 1) / r;

        for(int b_i = 0; b_i < b_m; b_i++)
        {
            end_r = (b_i+1 < b_m) ? r : m - b_i*r;

            for(int b_j = row_start[b_i]; b_j < row_start[b_i + 1]; b_j += end_r)
            {
                for(int i = 0; i < end_r; i++)
                {
                    float t = 0;
                    for(int j = block_ptr[b_j + i]; j < block_ptr[b_j + i + 1]; j++)
                    {
                        t += value[j] * a[col_idx[j]];
                    }
                    b[b_i * r + i] += t;
                }
            }
        }
    }

    @Override
    public void mul(FloatBuffer a, FloatBuffer b)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void calcResidual(float[] a, float[] b, float[] r)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void calcResidual(FloatBuffer x, FloatBuffer b, FloatBuffer r)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void find_cache_block(int[] crs_row_ptr, int[] crs_col_idx, float[] crs_val)
    {
        int k;
        int b_i, b_j, b_k;
        int b_m, b_n;
        final int[] col_ptrs = new int[r];
        int b_col_begin, b_col_end, end_r;

        // estimate the data structure size of output matrix
        b_m = (m + r - 1) / r;
        b_n = (n + c - 1) / c;

        row_start = new int[b_m + 1];
        block_ptr = new int[b_m * b_n * r + 1];
        col_idx = new int[nrCoeffs];
        value = new float[nrCoeffs];

        // find the blocks in pattern
        row_start[0] = 0;
        block_ptr[0] = 0;
        k = b_k = 0;

        for(b_i = 0; b_i < b_m;)
        {

            end_r = ((b_i * r + r) < m) ? r : m - b_i * r;

            for(int i = 0; i < end_r; i++)
            {
                if(crs_row_ptr[b_i * r + i] == crs_row_ptr[b_i * r + i + 1])
                {
                    col_ptrs[i] = nrCoeffs;    // zero row
                }
                else
                {
                    col_ptrs[i] = crs_row_ptr[b_i * r + i];
                }
            }


            b_j = 0;
            while(true)
            {
                b_col_begin = n;
                for(int i = 0; i < end_r; i++)
                {
                    if(col_ptrs[i] < nrCoeffs)
                    {
                        b_col_begin = Math.min(crs_col_idx[col_ptrs[i]], b_col_begin);
                    }
                }

                if(b_col_begin == n)
                {
                    break;  // this blocked row is done
                }

                b_col_end = b_col_begin + c;
                b_j++;

                for(int i = 0; i < end_r; i++)
                {
                    while((col_ptrs[i] < crs_row_ptr[b_i * r + i + 1])
                            && (crs_col_idx[col_ptrs[i]] < b_col_end))
                    {
                        col_idx[b_k] = crs_col_idx[col_ptrs[i]];
                        value[b_k++] = crs_val[col_ptrs[i]];
                        col_ptrs[i]++;
                    }
                    if(col_ptrs[i] == crs_row_ptr[b_i * r + i + 1])
                    {
                        col_ptrs[i] = nrCoeffs; // reached the end of the row
                    }

                    block_ptr[++k] = b_k;
                }
            }
            row_start[++b_i] = k;
        }

    }

}
