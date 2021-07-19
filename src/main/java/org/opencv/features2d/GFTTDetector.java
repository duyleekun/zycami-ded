/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class GFTTDetector
extends Feature2D {
    public GFTTDetector(long l10) {
        super(l10);
    }

    public static GFTTDetector A(int n10, double d10, double d11, int n11, int n12) {
        return GFTTDetector.u(GFTTDetector.create_2(n10, d10, d11, n11, n12));
    }

    public static GFTTDetector B(int n10, double d10, double d11, int n11, int n12, boolean bl2) {
        return GFTTDetector.u(GFTTDetector.create_1(n10, d10, d11, n11, n12, bl2));
    }

    public static GFTTDetector C(int n10, double d10, double d11, int n11, int n12, boolean bl2, double d12) {
        return GFTTDetector.u(GFTTDetector.create_0(n10, d10, d11, n11, n12, bl2, d12));
    }

    public static GFTTDetector D(int n10, double d10, double d11, int n11, boolean bl2) {
        return GFTTDetector.u(GFTTDetector.create_4(n10, d10, d11, n11, bl2));
    }

    public static GFTTDetector E(int n10, double d10, double d11, int n11, boolean bl2, double d12) {
        return GFTTDetector.u(GFTTDetector.create_3(n10, d10, d11, n11, bl2, d12));
    }

    private static native long create_0(int var0, double var1, double var3, int var5, int var6, boolean var7, double var8);

    private static native long create_1(int var0, double var1, double var3, int var5, int var6, boolean var7);

    private static native long create_2(int var0, double var1, double var3, int var5, int var6);

    private static native long create_3(int var0, double var1, double var3, int var5, boolean var6, double var7);

    private static native long create_4(int var0, double var1, double var3, int var5, boolean var6);

    private static native long create_5(int var0, double var1, double var3, int var5);

    private static native long create_6(int var0, double var1, double var3);

    private static native long create_7(int var0, double var1);

    private static native long create_8(int var0);

    private static native long create_9();

    private static native void delete(long var0);

    private static native int getBlockSize_0(long var0);

    private static native String getDefaultName_0(long var0);

    private static native boolean getHarrisDetector_0(long var0);

    private static native double getK_0(long var0);

    private static native int getMaxFeatures_0(long var0);

    private static native double getMinDistance_0(long var0);

    private static native double getQualityLevel_0(long var0);

    private static native void setBlockSize_0(long var0, int var2);

    private static native void setHarrisDetector_0(long var0, boolean var2);

    private static native void setK_0(long var0, double var2);

    private static native void setMaxFeatures_0(long var0, int var2);

    private static native void setMinDistance_0(long var0, double var2);

    private static native void setQualityLevel_0(long var0, double var2);

    public static GFTTDetector u(long l10) {
        GFTTDetector gFTTDetector = new GFTTDetector(l10);
        return gFTTDetector;
    }

    public static GFTTDetector v() {
        return GFTTDetector.u(GFTTDetector.create_9());
    }

    public static GFTTDetector w(int n10) {
        return GFTTDetector.u(GFTTDetector.create_8(n10));
    }

    public static GFTTDetector x(int n10, double d10) {
        return GFTTDetector.u(GFTTDetector.create_7(n10, d10));
    }

    public static GFTTDetector y(int n10, double d10, double d11) {
        return GFTTDetector.u(GFTTDetector.create_6(n10, d10, d11));
    }

    public static GFTTDetector z(int n10, double d10, double d11, int n11) {
        return GFTTDetector.u(GFTTDetector.create_5(n10, d10, d11, n11));
    }

    public int F() {
        return GFTTDetector.getBlockSize_0(this.a);
    }

    public boolean G() {
        return GFTTDetector.getHarrisDetector_0(this.a);
    }

    public double H() {
        return GFTTDetector.getK_0(this.a);
    }

    public int I() {
        return GFTTDetector.getMaxFeatures_0(this.a);
    }

    public double J() {
        return GFTTDetector.getMinDistance_0(this.a);
    }

    public double K() {
        return GFTTDetector.getQualityLevel_0(this.a);
    }

    public void L(int n10) {
        GFTTDetector.setBlockSize_0(this.a, n10);
    }

    public void M(boolean bl2) {
        GFTTDetector.setHarrisDetector_0(this.a, bl2);
    }

    public void N(double d10) {
        GFTTDetector.setK_0(this.a, d10);
    }

    public void O(int n10) {
        GFTTDetector.setMaxFeatures_0(this.a, n10);
    }

    public void P(double d10) {
        GFTTDetector.setMinDistance_0(this.a, d10);
    }

    public void Q(double d10) {
        GFTTDetector.setQualityLevel_0(this.a, d10);
    }

    public String d() {
        return GFTTDetector.getDefaultName_0(this.a);
    }

    public void finalize() {
        GFTTDetector.delete(this.a);
    }
}

