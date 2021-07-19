/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import i.f.c.g;
import i.f.c.h;
import i.f.c.k;
import i.f.c.m;
import i.f.c.u;
import i.f.c.w;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;

public class Subdiv2D {
    public static final int b = 254;
    public static final int c = 255;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 0;
    public static final int h = 34;
    public static final int i = 17;
    public static final int j = 51;
    public static final int k = 19;
    public static final int l = 49;
    public static final int m = 32;
    public static final int n = 2;
    public final long a;

    public Subdiv2D() {
        long l10;
        this.a = l10 = Subdiv2D.Subdiv2D_1();
    }

    public Subdiv2D(long l10) {
        this.a = l10;
    }

    public Subdiv2D(w w10) {
        long l10;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        this.a = l10 = Subdiv2D.Subdiv2D_0(n10, n11, n12, n13);
    }

    private static native long Subdiv2D_0(int var0, int var1, int var2, int var3);

    private static native long Subdiv2D_1();

    public static Subdiv2D a(long l10) {
        Subdiv2D subdiv2D = new Subdiv2D(l10);
        return subdiv2D;
    }

    private static native void delete(long var0);

    private static native int edgeDst_0(long var0, int var2, double[] var3);

    private static native int edgeDst_1(long var0, int var2);

    private static native int edgeOrg_0(long var0, int var2, double[] var3);

    private static native int edgeOrg_1(long var0, int var2);

    private static native int findNearest_0(long var0, double var2, double var4, double[] var6);

    private static native int findNearest_1(long var0, double var2, double var4);

    private static native void getEdgeList_0(long var0, long var2);

    private static native int getEdge_0(long var0, int var2, int var3);

    private static native void getLeadingEdgeList_0(long var0, long var2);

    private static native void getTriangleList_0(long var0, long var2);

    private static native double[] getVertex_0(long var0, int var2, double[] var3);

    private static native double[] getVertex_1(long var0, int var2);

    private static native void getVoronoiFacetList_0(long var0, long var2, long var4, long var6);

    private static native void initDelaunay_0(long var0, int var2, int var3, int var4, int var5);

    private static native int insert_0(long var0, double var2, double var4);

    private static native void insert_1(long var0, long var2);

    private static native int locate_0(long var0, double var2, double var4, double[] var6, double[] var7);

    private static native int nextEdge_0(long var0, int var2);

    private static native int rotateEdge_0(long var0, int var2, int var3);

    private static native int symEdge_0(long var0, int var2);

    public int b(int n10) {
        return Subdiv2D.edgeDst_1(this.a, n10);
    }

    public int c(int n10, u u10) {
        int n11 = 2;
        double[] dArray = new double[n11];
        long l10 = this.a;
        n10 = Subdiv2D.edgeDst_0(l10, n10, dArray);
        if (u10 != null) {
            double d10;
            u10.a = d10 = dArray[0];
            int n12 = 1;
            u10.b = d10 = dArray[n12];
        }
        return n10;
    }

    public int d(int n10) {
        return Subdiv2D.edgeOrg_1(this.a, n10);
    }

    public int e(int n10, u u10) {
        int n11 = 2;
        double[] dArray = new double[n11];
        long l10 = this.a;
        n10 = Subdiv2D.edgeOrg_0(l10, n10, dArray);
        if (u10 != null) {
            double d10;
            u10.a = d10 = dArray[0];
            int n12 = 1;
            u10.b = d10 = dArray[n12];
        }
        return n10;
    }

    public int f(u u10) {
        long l10 = this.a;
        double d10 = u10.a;
        double d11 = u10.b;
        return Subdiv2D.findNearest_1(l10, d10, d11);
    }

    public void finalize() {
        Subdiv2D.delete(this.a);
    }

    public int g(u u10, u u11) {
        int n10 = 2;
        double[] dArray = new double[n10];
        long l10 = this.a;
        double d10 = u10.a;
        double d11 = u10.b;
        int n11 = Subdiv2D.findNearest_0(l10, d10, d11, dArray);
        if (u11 != null) {
            double d12;
            u11.a = d12 = dArray[0];
            int n12 = 1;
            u11.b = d12 = dArray[n12];
        }
        return n11;
    }

    public int h(int n10, int n11) {
        return Subdiv2D.getEdge_0(this.a, n10, n11);
    }

    public void i(g g10) {
        long l10 = this.a;
        long l11 = g10.a;
        Subdiv2D.getEdgeList_0(l10, l11);
    }

    public void j(k k10) {
        long l10 = this.a;
        long l11 = k10.a;
        Subdiv2D.getLeadingEdgeList_0(l10, l11);
    }

    public long k() {
        return this.a;
    }

    public void l(h h10) {
        long l10 = this.a;
        long l11 = h10.a;
        Subdiv2D.getTriangleList_0(l10, l11);
    }

    public u m(int n10) {
        double[] dArray = Subdiv2D.getVertex_1(this.a, n10);
        u u10 = new u(dArray);
        return u10;
    }

    public u n(int n10, int[] nArray) {
        int n11 = 1;
        double[] dArray = new double[n11];
        long l10 = this.a;
        double[] dArray2 = Subdiv2D.getVertex_0(l10, n10, dArray);
        u u10 = new u(dArray2);
        if (nArray != null) {
            n10 = 0;
            dArray2 = null;
            double d10 = dArray[0];
            nArray[0] = n11 = (int)d10;
        }
        return u10;
    }

    public void o(k k10, List list, m m10) {
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = k10.a;
        long l12 = mat.a;
        long l13 = m10.a;
        Subdiv2D.getVoronoiFacetList_0(l10, l11, l12, l13);
        i.f.h.a.v(mat, list);
        mat.u0();
    }

    public void p(w w10) {
        long l10 = this.a;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        Subdiv2D.initDelaunay_0(l10, n10, n11, n12, n13);
    }

    public int q(u u10) {
        long l10 = this.a;
        double d10 = u10.a;
        double d11 = u10.b;
        return Subdiv2D.insert_0(l10, d10, d11);
    }

    public void r(m m10) {
        long l10 = this.a;
        long l11 = m10.a;
        Subdiv2D.insert_1(l10, l11);
    }

    public int s(u u10, int[] nArray, int[] nArray2) {
        double d10;
        int n10 = 1;
        double[] dArray = new double[n10];
        double[] dArray2 = new double[n10];
        long l10 = this.a;
        double d11 = u10.a;
        double d12 = u10.b;
        int n11 = Subdiv2D.locate_0(l10, d11, d12, dArray, dArray2);
        if (nArray != null) {
            int n12;
            d10 = dArray[0];
            nArray[0] = n12 = (int)d10;
        }
        if (nArray2 != null) {
            int n13;
            d10 = dArray2[0];
            nArray2[0] = n13 = (int)d10;
        }
        return n11;
    }

    public int t(int n10) {
        return Subdiv2D.nextEdge_0(this.a, n10);
    }

    public int u(int n10, int n11) {
        return Subdiv2D.rotateEdge_0(this.a, n10, n11);
    }

    public int v(int n10) {
        return Subdiv2D.symEdge_0(this.a, n10);
    }
}

