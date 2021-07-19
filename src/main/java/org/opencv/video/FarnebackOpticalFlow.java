/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.video.DenseOpticalFlow;

public class FarnebackOpticalFlow
extends DenseOpticalFlow {
    public FarnebackOpticalFlow(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, double var1, boolean var3, int var4, int var5, int var6, double var7, int var9);

    private static native long create_1(int var0, double var1, boolean var3, int var4, int var5, int var6, double var7);

    private static native long create_2(int var0, double var1, boolean var3, int var4, int var5, int var6);

    private static native long create_3(int var0, double var1, boolean var3, int var4, int var5);

    private static native long create_4(int var0, double var1, boolean var3, int var4);

    private static native long create_5(int var0, double var1, boolean var3);

    private static native long create_6(int var0, double var1);

    private static native long create_7(int var0);

    private static native long create_8();

    private static native void delete(long var0);

    private static native boolean getFastPyramids_0(long var0);

    private static native int getFlags_0(long var0);

    private static native int getNumIters_0(long var0);

    private static native int getNumLevels_0(long var0);

    private static native int getPolyN_0(long var0);

    private static native double getPolySigma_0(long var0);

    private static native double getPyrScale_0(long var0);

    private static native int getWinSize_0(long var0);

    public static FarnebackOpticalFlow j(long l10) {
        FarnebackOpticalFlow farnebackOpticalFlow = new FarnebackOpticalFlow(l10);
        return farnebackOpticalFlow;
    }

    public static FarnebackOpticalFlow k() {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_8());
    }

    public static FarnebackOpticalFlow l(int n10) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_7(n10));
    }

    public static FarnebackOpticalFlow m(int n10, double d10) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_6(n10, d10));
    }

    public static FarnebackOpticalFlow n(int n10, double d10, boolean bl2) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_5(n10, d10, bl2));
    }

    public static FarnebackOpticalFlow o(int n10, double d10, boolean bl2, int n11) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_4(n10, d10, bl2, n11));
    }

    public static FarnebackOpticalFlow p(int n10, double d10, boolean bl2, int n11, int n12) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_3(n10, d10, bl2, n11, n12));
    }

    public static FarnebackOpticalFlow q(int n10, double d10, boolean bl2, int n11, int n12, int n13) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_2(n10, d10, bl2, n11, n12, n13));
    }

    public static FarnebackOpticalFlow r(int n10, double d10, boolean bl2, int n11, int n12, int n13, double d11) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_1(n10, d10, bl2, n11, n12, n13, d11));
    }

    public static FarnebackOpticalFlow s(int n10, double d10, boolean bl2, int n11, int n12, int n13, double d11, int n14) {
        return FarnebackOpticalFlow.j(FarnebackOpticalFlow.create_0(n10, d10, bl2, n11, n12, n13, d11, n14));
    }

    private static native void setFastPyramids_0(long var0, boolean var2);

    private static native void setFlags_0(long var0, int var2);

    private static native void setNumIters_0(long var0, int var2);

    private static native void setNumLevels_0(long var0, int var2);

    private static native void setPolyN_0(long var0, int var2);

    private static native void setPolySigma_0(long var0, double var2);

    private static native void setPyrScale_0(long var0, double var2);

    private static native void setWinSize_0(long var0, int var2);

    public int A() {
        return FarnebackOpticalFlow.getWinSize_0(this.a);
    }

    public void B(boolean bl2) {
        FarnebackOpticalFlow.setFastPyramids_0(this.a, bl2);
    }

    public void C(int n10) {
        FarnebackOpticalFlow.setFlags_0(this.a, n10);
    }

    public void D(int n10) {
        FarnebackOpticalFlow.setNumIters_0(this.a, n10);
    }

    public void E(int n10) {
        FarnebackOpticalFlow.setNumLevels_0(this.a, n10);
    }

    public void F(int n10) {
        FarnebackOpticalFlow.setPolyN_0(this.a, n10);
    }

    public void G(double d10) {
        FarnebackOpticalFlow.setPolySigma_0(this.a, d10);
    }

    public void H(double d10) {
        FarnebackOpticalFlow.setPyrScale_0(this.a, d10);
    }

    public void I(int n10) {
        FarnebackOpticalFlow.setWinSize_0(this.a, n10);
    }

    public void finalize() {
        FarnebackOpticalFlow.delete(this.a);
    }

    public boolean t() {
        return FarnebackOpticalFlow.getFastPyramids_0(this.a);
    }

    public int u() {
        return FarnebackOpticalFlow.getFlags_0(this.a);
    }

    public int v() {
        return FarnebackOpticalFlow.getNumIters_0(this.a);
    }

    public int w() {
        return FarnebackOpticalFlow.getNumLevels_0(this.a);
    }

    public int x() {
        return FarnebackOpticalFlow.getPolyN_0(this.a);
    }

    public double y() {
        return FarnebackOpticalFlow.getPolySigma_0(this.a);
    }

    public double z() {
        return FarnebackOpticalFlow.getPyrScale_0(this.a);
    }
}

