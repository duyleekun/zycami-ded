/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class SURF
extends Feature2D {
    public SURF(long l10) {
        super(l10);
    }

    public static SURF A(double d10, int n10, int n11, boolean bl2, boolean bl3) {
        return SURF.u(SURF.create_0(d10, n10, n11, bl2, bl3));
    }

    private static native long create_0(double var0, int var2, int var3, boolean var4, boolean var5);

    private static native long create_1(double var0, int var2, int var3, boolean var4);

    private static native long create_2(double var0, int var2, int var3);

    private static native long create_3(double var0, int var2);

    private static native long create_4(double var0);

    private static native long create_5();

    private static native void delete(long var0);

    private static native boolean getExtended_0(long var0);

    private static native double getHessianThreshold_0(long var0);

    private static native int getNOctaveLayers_0(long var0);

    private static native int getNOctaves_0(long var0);

    private static native boolean getUpright_0(long var0);

    private static native void setExtended_0(long var0, boolean var2);

    private static native void setHessianThreshold_0(long var0, double var2);

    private static native void setNOctaveLayers_0(long var0, int var2);

    private static native void setNOctaves_0(long var0, int var2);

    private static native void setUpright_0(long var0, boolean var2);

    public static SURF u(long l10) {
        SURF sURF = new SURF(l10);
        return sURF;
    }

    public static SURF v() {
        return SURF.u(SURF.create_5());
    }

    public static SURF w(double d10) {
        return SURF.u(SURF.create_4(d10));
    }

    public static SURF x(double d10, int n10) {
        return SURF.u(SURF.create_3(d10, n10));
    }

    public static SURF y(double d10, int n10, int n11) {
        return SURF.u(SURF.create_2(d10, n10, n11));
    }

    public static SURF z(double d10, int n10, int n11, boolean bl2) {
        return SURF.u(SURF.create_1(d10, n10, n11, bl2));
    }

    public boolean B() {
        return SURF.getExtended_0(this.a);
    }

    public double C() {
        return SURF.getHessianThreshold_0(this.a);
    }

    public int D() {
        return SURF.getNOctaveLayers_0(this.a);
    }

    public int E() {
        return SURF.getNOctaves_0(this.a);
    }

    public boolean F() {
        return SURF.getUpright_0(this.a);
    }

    public void G(boolean bl2) {
        SURF.setExtended_0(this.a, bl2);
    }

    public void H(double d10) {
        SURF.setHessianThreshold_0(this.a, d10);
    }

    public void I(int n10) {
        SURF.setNOctaveLayers_0(this.a, n10);
    }

    public void J(int n10) {
        SURF.setNOctaves_0(this.a, n10);
    }

    public void K(boolean bl2) {
        SURF.setUpright_0(this.a, bl2);
    }

    public void finalize() {
        SURF.delete(this.a);
    }
}

