/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class KAZE
extends Feature2D {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;

    public KAZE(long l10) {
        super(l10);
    }

    public static KAZE A(boolean bl2, boolean bl3, float f10, int n10, int n11) {
        return KAZE.u(KAZE.create_1(bl2, bl3, f10, n10, n11));
    }

    public static KAZE B(boolean bl2, boolean bl3, float f10, int n10, int n11, int n12) {
        return KAZE.u(KAZE.create_0(bl2, bl3, f10, n10, n11, n12));
    }

    private static native long create_0(boolean var0, boolean var1, float var2, int var3, int var4, int var5);

    private static native long create_1(boolean var0, boolean var1, float var2, int var3, int var4);

    private static native long create_2(boolean var0, boolean var1, float var2, int var3);

    private static native long create_3(boolean var0, boolean var1, float var2);

    private static native long create_4(boolean var0, boolean var1);

    private static native long create_5(boolean var0);

    private static native long create_6();

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    private static native int getDiffusivity_0(long var0);

    private static native boolean getExtended_0(long var0);

    private static native int getNOctaveLayers_0(long var0);

    private static native int getNOctaves_0(long var0);

    private static native double getThreshold_0(long var0);

    private static native boolean getUpright_0(long var0);

    private static native void setDiffusivity_0(long var0, int var2);

    private static native void setExtended_0(long var0, boolean var2);

    private static native void setNOctaveLayers_0(long var0, int var2);

    private static native void setNOctaves_0(long var0, int var2);

    private static native void setThreshold_0(long var0, double var2);

    private static native void setUpright_0(long var0, boolean var2);

    public static KAZE u(long l10) {
        KAZE kAZE = new KAZE(l10);
        return kAZE;
    }

    public static KAZE v() {
        return KAZE.u(KAZE.create_6());
    }

    public static KAZE w(boolean bl2) {
        return KAZE.u(KAZE.create_5(bl2));
    }

    public static KAZE x(boolean bl2, boolean bl3) {
        return KAZE.u(KAZE.create_4(bl2, bl3));
    }

    public static KAZE y(boolean bl2, boolean bl3, float f10) {
        return KAZE.u(KAZE.create_3(bl2, bl3, f10));
    }

    public static KAZE z(boolean bl2, boolean bl3, float f10, int n10) {
        return KAZE.u(KAZE.create_2(bl2, bl3, f10, n10));
    }

    public int C() {
        return KAZE.getDiffusivity_0(this.a);
    }

    public boolean D() {
        return KAZE.getExtended_0(this.a);
    }

    public int E() {
        return KAZE.getNOctaveLayers_0(this.a);
    }

    public int F() {
        return KAZE.getNOctaves_0(this.a);
    }

    public double G() {
        return KAZE.getThreshold_0(this.a);
    }

    public boolean H() {
        return KAZE.getUpright_0(this.a);
    }

    public void I(int n10) {
        KAZE.setDiffusivity_0(this.a, n10);
    }

    public void J(boolean bl2) {
        KAZE.setExtended_0(this.a, bl2);
    }

    public void K(int n10) {
        KAZE.setNOctaveLayers_0(this.a, n10);
    }

    public void L(int n10) {
        KAZE.setNOctaves_0(this.a, n10);
    }

    public void M(double d10) {
        KAZE.setThreshold_0(this.a, d10);
    }

    public void N(boolean bl2) {
        KAZE.setUpright_0(this.a, bl2);
    }

    public String d() {
        return KAZE.getDefaultName_0(this.a);
    }

    public void finalize() {
        KAZE.delete(this.a);
    }
}

