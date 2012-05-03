/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ndim;

/**
 *
 * @author aheusel
 */
public final class Geometry
{
    final double[] spacing;
    private final GridTopo outer;

    Geometry(final double[] spacing, final GridTopo outer)
    {
        this.outer = outer;
        this.spacing = spacing.clone();
    }

    /**
     * Returns the spacing of the <code>idx</code>-th dimension.
     *
     * @param idx The index of the dimension
     * @return The spacing of this dimension
     */
    public final double spacing(int idx)
    {
        return spacing[idx];
    }

    public final double[] spacing()
    {
        return spacing.clone();
    }

    public final void spacing(double[] spacing)
    {
        System.arraycopy(this.spacing, 0, spacing, 0, Math.min(spacing.length, this.spacing.length));
    }

    public final void spacing(float[] spacing)
    {
        int length = Math.min(spacing.length, this.spacing.length);
        for(int i = 0; i < length; i++)
        {
            spacing[i] = (float) this.spacing[i];
        }
    }

    /**
     * Returns the physical coordinates of a grid-node.
     *
     * @param gridIdx The discrete coordinate of the grid-node
     * @param pos Contains the physical coordinate of the node after the call.
     */
    public final void physCoordinate(final int[] gridIdx, final float[] pos)
    {
        for(int i = 0; i < gridIdx.length; i++)
        {
            pos[i] = (float) (gridIdx[i] * spacing[i]);
        }
    }

    /**
     * Returns the physical coordinates of a grid-node.
     *
     * @param gridIdx The discrete coordinate of the grid-node
     * @param pos Contains the physical coordinate of the node after the call.
     */
    public final void physCoordinate(final int[] gridIdx, final double[] pos)
    {
        for(int i = 0; i < gridIdx.length; i++)
        {
            pos[i] = gridIdx[i] * spacing[i];
        }
    }

    /**
     * Returns the physical coordinates of a grid-node.
     *
     * @param gridIdx The discrete coordinate of the grid-node
     * @return The physical coordinate of the node.
     */
    public final double[] physCoordinate(final int[] gridIdx)
    {
        double[] coor = new double[spacing.length];
        physCoordinate(gridIdx, coor);
        return coor;
    }

//    /**
//     * Returns the physical extent of a grid.
//     *
//     * @param GridTopo The layout of the grid.
//     * @param physExtent The discreet extent of the grid.
//     */
//    public final void physExtent(final double[] physExtent)
//    {
//        for(int i = 0; i < extent.length; i++)
//        {
//            physExtent[i] = spacing[i] * (extent[i] - 1);
//        }
//    }
//
//    /**
//     * Returns the physical extent of the given dimension of a grid.
//     *
//     * @param GridTopo The layout of the grid.
//     * @param dimIdx The index of the dimension to query
//     * @return The extent of the dimension.
//     */
//    public final double physExtent(int dimIdx)
//    {
//        return spacing[dimIdx] * (extent[dimIdx] - 1);
//    }

    /**
     * Returns the number of dimensions of the descriptor.
     *
     * @return The number of dimensions.
     */
    public final int nrDims()
    {
        return outer.nrDims();
    }
    
}
