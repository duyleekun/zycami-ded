/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.calib3d;

import i.f.c.w;
import org.opencv.calib3d.StereoMatcher;

public class StereoBM
extends StereoMatcher {
    public static final int d = 0;
    public static final int e = 1;

    public StereoBM(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, int var1);

    private static native long create_1(int var0);

    private static native long create_2();

    private static native void delete(long var0);

    private static native int getPreFilterCap_0(long var0);

    private static native int getPreFilterSize_0(long var0);

    private static native int getPreFilterType_0(long var0);

    private static native double[] getROI1_0(long var0);

    private static native double[] getROI2_0(long var0);

    private static native int getSmallerBlockSize_0(long var0);

    private static native int getTextureThreshold_0(long var0);

    private static native int getUniquenessRatio_0(long var0);

    private static native void setPreFilterCap_0(long var0, int var2);

    private static native void setPreFilterSize_0(long var0, int var2);

    private static native void setPreFilterType_0(long var0, int var2);

    private static native void setROI1_0(long var0, int var2, int var3, int var4, int var5);

    private static native void setROI2_0(long var0, int var2, int var3, int var4, int var5);

    private static native void setSmallerBlockSize_0(long var0, int var2);

    private static native void setTextureThreshold_0(long var0, int var2);

    private static native void setUniquenessRatio_0(long var0, int var2);

    public static StereoBM u(long l10) {
        StereoBM stereoBM = new StereoBM(l10);
        return stereoBM;
    }

    public static StereoBM v() {
        return StereoBM.u(StereoBM.create_2());
    }

    public static StereoBM w(int n10) {
        return StereoBM.u(StereoBM.create_1(n10));
    }

    public static StereoBM x(int n10, int n11) {
        return StereoBM.u(StereoBM.create_0(n10, n11));
    }

    public int A() {
        return StereoBM.getPreFilterType_0(this.a);
    }

    public w B() {
        double[] dArray = StereoBM.getROI1_0(this.a);
        w w10 = new w(dArray);
        return w10;
    }

    public w C() {
        double[] dArray = StereoBM.getROI2_0(this.a);
        w w10 = new w(dArray);
        return w10;
    }

    public int D() {
        return StereoBM.getSmallerBlockSize_0(this.a);
    }

    public int E() {
        return StereoBM.getTextureThreshold_0(this.a);
    }

    public int F() {
        return StereoBM.getUniquenessRatio_0(this.a);
    }

    public void G(int n10) {
        StereoBM.setPreFilterCap_0(this.a, n10);
    }

    public void H(int n10) {
        StereoBM.setPreFilterSize_0(this.a, n10);
    }

    public void I(int n10) {
        StereoBM.setPreFilterType_0(this.a, n10);
    }

    public void J(w w10) {
        long l10 = this.a;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        StereoBM.setROI1_0(l10, n10, n11, n12, n13);
    }

    public void K(w w10) {
        long l10 = this.a;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        StereoBM.setROI2_0(l10, n10, n11, n12, n13);
    }

    public void L(int n10) {
        StereoBM.setSmallerBlockSize_0(this.a, n10);
    }

    public void M(int n10) {
        StereoBM.setTextureThreshold_0(this.a, n10);
    }

    public void N(int n10) {
        StereoBM.setUniquenessRatio_0(this.a, n10);
    }

    public void finalize() {
        StereoBM.delete(this.a);
    }

    public int y() {
        return StereoBM.getPreFilterCap_0(this.a);
    }

    public int z() {
        return StereoBM.getPreFilterSize_0(this.a);
    }
}

