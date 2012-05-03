/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim.linalg;

import java.io.IOException;
import java.util.Arrays;
import org.ndim.GridTopo;
import org.ndim.Stencil;

/**
 *
 * @author aheusel
 */
public class LaplacianCRSInputStream implements CRSInputStream
{
    private final int m;
    private final int n;
    private final int nrCoeffs;
    private final GridTopo layout;
    private final float[] op_f;
    private final double[] op_d;
    private final int offs[];
    
    public LaplacianCRSInputStream(final GridTopo layout)
    {
       m = layout.nrEntities();
       n = layout.nrEntities();
       
       final int nrEntitiesInner = layout.shrink(1).nrEntities();
       final int nrEntitiesBorder = layout.nrEntities() - nrEntitiesInner;
       final int nrCoeffsOperator = layout.nrDims()*2 + 1;
       nrCoeffs = nrEntitiesBorder + nrEntitiesInner*nrCoeffsOperator;
       this.layout = layout.clone();
       
        op_f = new float[layout.nrDims()*2 + 1];
        op_d = new double[layout.nrDims()*2 + 1];
        offs = new int[op_f.length];
        for(int i = 0; i < layout.nrDims(); i++)
        {
            offs[i] = layout.incr(i);
            offs[i*2] = -offs[i];
        }
        offs[offs.length - 1] = 0;
        Arrays.sort(offs);
        Arrays.fill(op_f, -1);
        Arrays.fill(op_d, -1);
        op_f[layout.nrDims()] = 2*layout.nrDims();
        op_d[layout.nrDims()] = 2*layout.nrDims();
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
    public final int nrCoeffs()
    {
        return nrCoeffs;
    }

    @Override
    public void read(int[] col_ind, float[] val, int[] row_ptr) throws IOException
    {
        Stencil iter = new Stencil(layout.extent());
        final int[] pos = new int[iter.nrDims()];
        Arrays.fill(pos, 0);
        
        int elemIter = 0;
        int coeffIter = 0;
        int offsIter = 0;
        row_ptr[0] = 0;
        while(iter.hasNext(pos))
        {
            row_ptr[elemIter] = coeffIter;
            // Check if we are inside the lattice or on the border
            if(iter.isOnBorder(pos))
            {
                // on the border -> unit matrix
                val[coeffIter] = 1;
                col_ind[coeffIter++] = elemIter;                
            }
            else
            {
                // inside the lattice -> N-dimensional-laplace-stencil
                for(int i = 0; i < offs.length; i++)
                {
                    offsIter = offs[i];
                    val[elemIter + offsIter] = op_f[i];
                }
                coeffIter += offs.length;
            }
            
            elemIter++;
            iter.next(pos);
        }
        // The last row-pointer
        row_ptr[elemIter] = coeffIter;        
    }

    @Override
    public void read(int[] col_ind, double[] val, int[] row_ptr) throws IOException
    {
        Stencil iter = new Stencil(layout.extent());
        final int[] pos = new int[iter.nrDims()];
        Arrays.fill(pos, 0);
        
        int elemIter = 0;
        int coeffIter = 0;
        int offsIter = 0;
        row_ptr[0] = 0;
        while(iter.hasNext(pos))
        {
            row_ptr[elemIter] = coeffIter;
            // Check if we are inside the lattice or on the border
            if(iter.isOnBorder(pos))
            {
                // on the border -> unit matrix
                val[coeffIter] = 1;
                col_ind[coeffIter++] = elemIter;                
            }
            else
            {
                // inside the lattice -> N-dimensional-laplace-stencil
                for(int i = 0; i < offs.length; i++)
                {
                    offsIter = offs[i];
                    val[elemIter + offsIter] = op_d[i];
                }
                coeffIter += offs.length;
            }
            
            elemIter++;
            iter.next(pos);
        }
        // The last row-pointer
        row_ptr[elemIter] = coeffIter;        
        
    }
    
}
