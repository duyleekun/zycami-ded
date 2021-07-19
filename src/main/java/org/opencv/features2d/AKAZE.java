/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class AKAZE
extends Feature2D {
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;

    public AKAZE(long l10) {
        super(l10);
    }

    public static AKAZE A(int n10, int n11, int n12, float f10, int n13) {
        return AKAZE.u(AKAZE.create_2(n10, n11, n12, f10, n13));
    }

    public static AKAZE B(int n10, int n11, int n12, float f10, int n13, int n14) {
        return AKAZE.u(AKAZE.create_1(n10, n11, n12, f10, n13, n14));
    }

    public static AKAZE C(int n10, int n11, int n12, float f10, int n13, int n14, int n15) {
        return AKAZE.u(AKAZE.create_0(n10, n11, n12, f10, n13, n14, n15));
    }

    private static native long create_0(int var0, int var1, int var2, float var3, int var4, int var5, int var6);

    private static native long create_1(int var0, int var1, int var2, float var3, int var4, int var5);

    private static native long create_2(int var0, int var1, int var2, float var3, int var4);

    private static native long create_3(int var0, int var1, int var2, float var3);

    private static native long create_4(int var0, int var1, int var2);

    private static native long create_5(int var0, int var1);

    private static native long create_6(int var0);

    private static native long create_7();

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    private static native int getDescriptorChannels_0(long var0);

    private static native int getDescriptorSize_0(long var0);

    private static native int getDescriptorType_0(long var0);

    private static native int getDiffusivity_0(long var0);

    private static native int getNOctaveLayers_0(long var0);

    private static native int getNOctaves_0(long var0);

    private static native double getThreshold_0(long var0);

    private static native void setDescriptorChannels_0(long var0, int var2);

    private static native void setDescriptorSize_0(long var0, int var2);

    private static native void setDescriptorType_0(long var0, int var2);

    private static native void setDiffusivity_0(long var0, int var2);

    private static native void setNOctaveLayers_0(long var0, int var2);

    private static native void setNOctaves_0(long var0, int var2);

    private static native void setThreshold_0(long var0, double var2);

    public static AKAZE u(long l10) {
        AKAZE aKAZE = new AKAZE(l10);
        return aKAZE;
    }

    public static AKAZE v() {
        return AKAZE.u(AKAZE.create_7());
    }

    public static AKAZE w(int n10) {
        return AKAZE.u(AKAZE.create_6(n10));
    }

    public static AKAZE x(int n10, int n11) {
        return AKAZE.u(AKAZE.create_5(n10, n11));
    }

    public static AKAZE y(int n10, int n11, int n12) {
        return AKAZE.u(AKAZE.create_4(n10, n11, n12));
    }

    public static AKAZE z(int n10, int n11, int n12, float f10) {
        return AKAZE.u(AKAZE.create_3(n10, n11, n12, f10));
    }

    public int D() {
        return AKAZE.getDescriptorChannels_0(this.a);
    }

    public int E() {
        return AKAZE.getDescriptorSize_0(this.a);
    }

    public int F() {
        return AKAZE.getDescriptorType_0(this.a);
    }

    public int G() {
        return AKAZE.getDiffusivity_0(this.a);
    }

    public int H() {
        return AKAZE.getNOctaveLayers_0(this.a);
    }

    public int I() {
        return AKAZE.getNOctaves_0(this.a);
    }

    public double J() {
        return AKAZE.getThreshold_0(this.a);
    }

    public void K(int n10) {
        AKAZE.setDescriptorChannels_0(this.a, n10);
    }

    public void L(int n10) {
        AKAZE.setDescriptorSize_0(this.a, n10);
    }

    public void M(int n10) {
        AKAZE.setDescriptorType_0(this.a, n10);
    }

    public void N(int n10) {
        AKAZE.setDiffusivity_0(this.a, n10);
    }

    public void O(int n10) {
        AKAZE.setNOctaveLayers_0(this.a, n10);
    }

    public void P(int n10) {
        AKAZE.setNOctaves_0(this.a, n10);
    }

    public void Q(double d10) {
        AKAZE.setThreshold_0(this.a, d10);
    }

    public String d() {
        return AKAZE.getDefaultName_0(this.a);
    }

    public void finalize() {
        AKAZE.delete(this.a);
    }
}

