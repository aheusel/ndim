/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * copyright (c) 2007 - 2009
 * Goethe Center for Scientific Computing (G-CSC)
 * University of Frankfurt
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the distribution.
 * - Neither the name of the University of Frankfurt nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.ndim.math;

/**
 *
 * @author Alexander Heusel
 */
public class Mat
{

    /**
     * Householder reduction of a real symmetric matrix. All arrays are zero-based
     * in contradiction to the numerical recipies implementation.
     * 
     * @param offa The offset to the first element of a
     * @param offd The offset to the first element of d
     * @param offe The offset to the first element of e
     * @param a The array containing the coefficients of the matrix a
     * @param n The number of rows and columns of the matrix a
     * @param d The array containing the diagonal elements of the
     * tridiagonal matrix after the call.
     * @param e The array containing the off-diagonal elements of the
     * tridiagonal matrix after the call, with <code>e[0] = 0.0f</code>
     */
    public static void householderReduction(int offa, int offd, int offe, float[] a, int n, float[] d, float[] e)
    {
        int l;
        int rowIter;
        int invRowIter;

        float scale, hh, h, g, f;

        offa = offa - 1 - n;
        offd--;
        offe--;

        for(int i = n; i >= 2; i--)
        {
            rowIter = offa + i * n;
            l = i - 1;
            h = scale = 0.0f;
            if(l > 1)
            {
                for(int k = rowIter + 1; k <= rowIter + l; k++)
                {
                    scale += Math.abs(a[k]);
                }
                if(scale == 0.0f)
                {
                    e[offe + i] = a[rowIter + l];
                }
                else
                {
                    for(int k = rowIter + 1; k <= rowIter + l; k++)
                    {
                        a[k] /= scale;
                        h += a[k] * a[k];
                    }
                    f = a[rowIter + l];
                    g = (f >= 0.0f ? (float) -Math.sqrt(h) : (float) Math.sqrt(h));
                    e[offe + i] = scale * g;
                    h -= f * g;
                    a[rowIter + l] = f - g;
                    f = 0.0f;
                    for(int j = 1; j <= l; j++)
                    {
                        invRowIter = offa + j * n;
                        a[invRowIter + i] = a[rowIter + j] / h;
                        g = 0.0f;
                        for(int k = 1; k <= j; k++)
                        {
                            g += a[invRowIter + k] * a[rowIter + k];
                        }
                        for(int k = j + 1; k <= l; k++)
                        {
                            g += a[offa + k * n + j] * a[rowIter + k];
                        }
                        e[offe + j] = g / h;
                        f += e[offe + j] * a[rowIter + j];
                    }
                    hh = f / (h + h);
                    for(int j = 1; j <= l; j++)
                    {
                        f = a[rowIter + j];
                        g = e[offe + j] - (hh * f);
                        e[offe + j] = g;
                        for(int k = 1; k <= j; k++)
                        {
                            a[offa + j * n + k] -= (f * e[offe + k] + g * a[rowIter + k]);
                        }
                    }
                }
            }
            else
            {
                e[offe + i] = a[rowIter + l];
            }
            d[offd + i] = h;
        }

        d[offd + 1] = 0.0f;
        e[offe + 1] = 0.0f;

        for(int i = 1; i <= n; i++)
        {
            rowIter = offa + i * n;
            l = i - 1;
            if(d[offd + i] > 0.0f)
            {
                for(int j = 1; j <= l; j++)
                {
                    g = 0.0f;
                    for(int k = 1; k <= l; k++)
                    {
                        g += a[rowIter + k] * a[offa + k * n + j];
                    }
                    for(int k = 1; k <= l; k++)
                    {
                        a[offa + k * n + j] -= g * a[offa + k * n + i];
                    }
                }
            }
            d[offd + i] = a[rowIter + i];
            a[rowIter + i] = 1.0f;
            for(int j = 1; j <= l; j++)
            {
                a[offa + j * n + i] = a[rowIter + j] = 0.0f;
            }
        }

    }

    public static void householderReduction(int offa, int offd, int offe, double[] a, int n, double[] d, double[] e)
    {
        int l;
        int rowIter;
        int invRowIter;

        double scale, hh, h, g, f;

        offa = offa - 1 - n;
        offd--;
        offe--;

        for(int i = n; i >= 2; i--)
        {
            rowIter = offa + i * n;
            l = i - 1;
            h = scale = 0.0;
            if(l > 1)
            {
                for(int k = rowIter + 1; k <= rowIter + l; k++)
                {
                    scale += Math.abs(a[k]);
                }
                if(scale == 0.0)
                {
                    e[offe + i] = a[rowIter + l];
                }
                else
                {
                    for(int k = rowIter + 1; k <= rowIter + l; k++)
                    {
                        a[k] /= scale;
                        h += a[k] * a[k];
                    }
                    f = a[rowIter + l];
                    g = (f >= 0.0 ? -Math.sqrt(h) : Math.sqrt(h));
                    e[offe + i] = scale * g;
                    h -= f * g;
                    a[rowIter + l] = f - g;
                    f = 0.0;
                    for(int j = 1; j <= l; j++)
                    {
                        invRowIter = offa + j * n;
                        a[invRowIter + i] = a[rowIter + j] / h;
                        g = 0.0;
                        for(int k = 1; k <= j; k++)
                        {
                            g += a[invRowIter + k] * a[rowIter + k];
                        }
                        for(int k = j + 1; k <= l; k++)
                        {
                            g += a[offa + k * n + j] * a[rowIter + k];
                        }
                        e[offe + j] = g / h;
                        f += e[offe + j] * a[rowIter + j];
                    }
                    hh = f / (h + h);
                    for(int j = 1; j <= l; j++)
                    {
                        f = a[rowIter + j];
                        g = e[offe + j] - (hh * f);
                        e[offe + j] = g;
                        for(int k = 1; k <= j; k++)
                        {
                            a[offa + j * n + k] -= (f * e[offe + k] + g * a[rowIter + k]);
                        }
                    }
                }
            }
            else
            {
                e[offe + i] = a[rowIter + l];
            }
            d[offd + i] = h;
        }

        d[offd + 1] = 0.0;
        e[offe + 1] = 0.0;

        for(int i = 1; i <= n; i++)
        {
            rowIter = offa + i * n;
            l = i - 1;
            if(d[offd + i] > 0.0)
            {
                for(int j = 1; j <= l; j++)
                {
                    g = 0.0;
                    for(int k = 1; k <= l; k++)
                    {
                        g += a[rowIter + k] * a[offa + k * n + j];
                    }
                    for(int k = 1; k <= l; k++)
                    {
                        a[offa + k * n + j] -= g * a[offa + k * n + i];
                    }
                }
            }
            d[offd + i] = a[rowIter + i];
            a[rowIter + i] = 1.0;
            for(int j = 1; j <= l; j++)
            {
                a[offa + j * n + i] = a[rowIter + j] = 0.0;
            }
        }

    }

    /**
     * 
     */
    public static void tridiagonalQLImplicit(int offd, int offe, int offz, float d[], float e[], float[] z, int n)
    {
        int u, v;
        int m, l, iter, i, k;
        float s, r, p, g, f, dd, c, b;

        offz = offz - 1 - n;
        offd--;
        offe--;

        int rowIter;

        for(i = 2; i <= n; i++)
        {
            e[offe + i - 1] = e[offe + i];
        }
        e[offe + n] = 0.0f;
        for(l = 1; l <= n; l++)
        {
            iter = 0;
            do
            {
                for(m = l; m <= n - 1; m++)
                {
                    dd = Math.abs(d[offd + m]) + Math.abs(d[offd + m + 1]);
                    if(Math.abs(e[offe + m]) + dd == dd)
                    {
                        break;
                    }
                }
                if(m != l)
                {
                    if(iter++ == 30)
                    {
                        for(v = offd + 1; v <= offd + n; v++)
                        {
                            d[v] = 1.0f;
                        }
                        for(v = 1; v <= n; v++)
                        {
                            rowIter = offz + v * n;
                            for(u = 1; u <= n; u++)
                            {
                                z[rowIter + u] = u == v ? 1.0f : 0.0f;
                            }
                        }
                        return;
                    }
                    g = (d[offd + l + 1] - d[offd + l]) / (2.0f * e[offe + l]);
                    r = MathMisc.pythag(g, 1.0f);
                    g = d[offd + m] - d[offd + l] + e[offd + l] / (g + MathMisc.sign(r, g));
                    s = c = 1.0f;
                    p = 0.0f;
                    for(i = m - 1; i >= l; i--)
                    {
                        f = s * e[offe + i];
                        b = c * e[offe + i];
                        e[offe + i + 1] = (r = MathMisc.pythag(f, g));
                        if(r == 0.0f)
                        {
                            d[offd + i + 1] -= p;
                            e[offe + m] = 0.0f;
                            break;
                        }
                        s = f / r;
                        c = g / r;
                        g = d[offd + i + 1] - p;
                        r = (d[offd + i] - g) * s + 2.0f * c * b;
                        d[offd + i + 1] = g + (p = s * r);
                        g = c * r - b;
                        for(k = 1; k <= n; k++)
                        {
                            rowIter = offz + k * n + i;
                            f = z[rowIter + 1];
                            z[rowIter + 1] = s * z[rowIter] + c * f;
                            z[rowIter] = c * z[rowIter] - s * f;
                        }
                    }
                    if(r == 0.0f && i >= l)
                    {
                        continue;
                    }
                    d[offd + l] -= p;
                    e[offe + l] = g;
                    e[offe + m] = 0.0f;
                }
            } while(m != l);
        }
    }

    public static void tridiagonalQLImplicit(int offd, int offe, int offz, double d[], double e[], double[] z, int n)
    {
        int u, v;
        int m, l, iter, i, k;
        double s, r, p, g, f, dd, c, b;

        offz = offz - 1 - n;
        offd--;
        offe--;

        int rowIter;

        for(i = 2; i <= n; i++)
        {
            e[offe + i - 1] = e[offe + i];
        }
        e[offe + n] = 0.0;
        for(l = 1; l <= n; l++)
        {
            iter = 0;
            do
            {
                for(m = l; m <= n - 1; m++)
                {
                    dd = Math.abs(d[offd + m]) + Math.abs(d[offd + m + 1]);
                    if(Math.abs(e[offe + m]) + dd == dd)
                    {
                        break;
                    }
                }
                if(m != l)
                {
                    if(iter++ == 30)
                    {
                        for(v = offd + 1; v <= offd + n; v++)
                        {
                            d[v] = 1.0;
                        }
                        for(v = 1; v <= n; v++)
                        {
                            rowIter = offz + v * n;
                            for(u = 1; u <= n; u++)
                            {
                                z[rowIter + u] = u == v ? 1.0 : 0.0;
                            }
                        }
                        return;
                    }
                    g = (d[offd + l + 1] - d[offd + l]) / (2.0 * e[offe + l]);
                    r = MathMisc.pythag(g, 1.0);
                    g = d[offd + m] - d[offd + l] + e[offd + l] / (g + MathMisc.sign(r, g));
                    s = c = 1.0;
                    p = 0.0;
                    for(i = m - 1; i >= l; i--)
                    {
                        f = s * e[offe + i];
                        b = c * e[offe + i];
                        e[offe + i + 1] = (r = MathMisc.pythag(f, g));
                        if(r == 0.0)
                        {
                            d[offd + i + 1] -= p;
                            e[offe + m] = 0.0;
                            break;
                        }
                        s = f / r;
                        c = g / r;
                        g = d[offd + i + 1] - p;
                        r = (d[offd + i] - g) * s + 2.0 * c * b;
                        d[offd + i + 1] = g + (p = s * r);
                        g = c * r - b;
                        for(k = 1; k <= n; k++)
                        {
                            rowIter = offz + k * n + i;
                            f = z[rowIter + 1];
                            z[rowIter + 1] = s * z[rowIter] + c * f;
                            z[rowIter] = c * z[rowIter] - s * f;
                        }
                    }
                    if(r == 0.0 && i >= l)
                    {
                        continue;
                    }
                    d[offd + l] -= p;
                    e[offe + l] = g;
                    e[offe + m] = 0.0;
                }
            } while(m != l);
        }
    }
}
