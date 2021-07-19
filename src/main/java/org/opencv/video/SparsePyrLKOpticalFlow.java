/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import i.f.c.a0;
import i.f.c.z;
import org.opencv.video.SparseOpticalFlow;

public class SparsePyrLKOpticalFlow
extends SparseOpticalFlow {
    public SparsePyrLKOpticalFlow(long l10) {
        super(l10);
    }

    private static native long create_0(double var0, double var2, int var4, int var5, int var6, double var7, int var9, double var10);

    private static native long create_1(double var0, double var2, int var4, int var5, int var6, double var7, int var9);

    private static native long create_2(double var0, double var2, int var4, int var5, int var6, double var7);

    private static native long create_3(double var0, double var2, int var4);

    private static native long create_4(double var0, double var2);

    private static native long create_5();

    private static native void delete(long var0);

    private static native int getFlags_0(long var0);

    private static native int getMaxLevel_0(long var0);

    private static native double getMinEigThreshold_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native double[] getWinSize_0(long var0);

    public static SparsePyrLKOpticalFlow j(long l10) {
        SparsePyrLKOpticalFlow sparsePyrLKOpticalFlow = new SparsePyrLKOpticalFlow(l10);
        return sparsePyrLKOpticalFlow;
    }

    public static SparsePyrLKOpticalFlow k() {
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_5());
    }

    public static SparsePyrLKOpticalFlow l(z z10) {
        double d10 = z10.a;
        double d11 = z10.b;
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_4(d10, d11));
    }

    public static SparsePyrLKOpticalFlow m(z z10, int n10) {
        double d10 = z10.a;
        double d11 = z10.b;
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_3(d10, d11, n10));
    }

    public static SparsePyrLKOpticalFlow n(z z10, int n10, a0 a02) {
        double d10 = z10.a;
        double d11 = z10.b;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_2(d10, d11, n10, n11, n12, d12));
    }

    public static SparsePyrLKOpticalFlow o(z z10, int n10, a0 a02, int n11) {
        double d10 = z10.a;
        double d11 = z10.b;
        int n12 = a02.a;
        int n13 = a02.b;
        double d12 = a02.c;
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_1(d10, d11, n10, n12, n13, d12, n11));
    }

    public static SparsePyrLKOpticalFlow p(z z10, int n10, a0 a02, int n11, double d10) {
        double d11 = z10.a;
        double d12 = z10.b;
        int n12 = a02.a;
        int n13 = a02.b;
        double d13 = a02.c;
        double d14 = d11;
        d11 = d12;
        int n14 = n12;
        n12 = n13;
        return SparsePyrLKOpticalFlow.j(SparsePyrLKOpticalFlow.create_0(d14, d12, n10, n14, n13, d13, n11, d10));
    }

    private static native void setFlags_0(long var0, int var2);

    private static native void setMaxLevel_0(long var0, int var2);

    private static native void setMinEigThreshold_0(long var0, double var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    private static native void setWinSize_0(long var0, double var2, double var4);

    public void finalize() {
        SparsePyrLKOpticalFlow.delete(this.a);
    }

    public int q() {
        return SparsePyrLKOpticalFlow.getFlags_0(this.a);
    }

    public int r() {
        return SparsePyrLKOpticalFlow.getMaxLevel_0(this.a);
    }

    public double s() {
        return SparsePyrLKOpticalFlow.getMinEigThreshold_0(this.a);
    }

    public a0 t() {
        double[] dArray = SparsePyrLKOpticalFlow.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public z u() {
        double[] dArray = SparsePyrLKOpticalFlow.getWinSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public void v(int n10) {
        SparsePyrLKOpticalFlow.setFlags_0(this.a, n10);
    }

    public void w(int n10) {
        SparsePyrLKOpticalFlow.setMaxLevel_0(this.a, n10);
    }

    public void x(double d10) {
        SparsePyrLKOpticalFlow.setMinEigThreshold_0(this.a, d10);
    }

    public void y(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        SparsePyrLKOpticalFlow.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void z(z z10) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        SparsePyrLKOpticalFlow.setWinSize_0(l10, d10, d11);
    }
}

