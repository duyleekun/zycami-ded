/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class VGG
extends Feature2D {
    public VGG(long l10) {
        super(l10);
    }

    public static VGG A(int n10, float f10, boolean bl2, boolean bl3, float f11) {
        return VGG.u(VGG.create_1(n10, f10, bl2, bl3, f11));
    }

    public static VGG B(int n10, float f10, boolean bl2, boolean bl3, float f11, boolean bl4) {
        return VGG.u(VGG.create_0(n10, f10, bl2, bl3, f11, bl4));
    }

    private static native long create_0(int var0, float var1, boolean var2, boolean var3, float var4, boolean var5);

    private static native long create_1(int var0, float var1, boolean var2, boolean var3, float var4);

    private static native long create_2(int var0, float var1, boolean var2, boolean var3);

    private static native long create_3(int var0, float var1, boolean var2);

    private static native long create_4(int var0, float var1);

    private static native long create_5(int var0);

    private static native long create_6();

    private static native void delete(long var0);

    private static native float getScaleFactor_0(long var0);

    private static native float getSigma_0(long var0);

    private static native boolean getUseNormalizeDescriptor_0(long var0);

    private static native boolean getUseNormalizeImage_0(long var0);

    private static native boolean getUseScaleOrientation_0(long var0);

    private static native void setScaleFactor_0(long var0, float var2);

    private static native void setSigma_0(long var0, float var2);

    private static native void setUseNormalizeDescriptor_0(long var0, boolean var2);

    private static native void setUseNormalizeImage_0(long var0, boolean var2);

    private static native void setUseScaleOrientation_0(long var0, boolean var2);

    public static VGG u(long l10) {
        VGG vGG = new VGG(l10);
        return vGG;
    }

    public static VGG v() {
        return VGG.u(VGG.create_6());
    }

    public static VGG w(int n10) {
        return VGG.u(VGG.create_5(n10));
    }

    public static VGG x(int n10, float f10) {
        return VGG.u(VGG.create_4(n10, f10));
    }

    public static VGG y(int n10, float f10, boolean bl2) {
        return VGG.u(VGG.create_3(n10, f10, bl2));
    }

    public static VGG z(int n10, float f10, boolean bl2, boolean bl3) {
        return VGG.u(VGG.create_2(n10, f10, bl2, bl3));
    }

    public float C() {
        return VGG.getScaleFactor_0(this.a);
    }

    public float D() {
        return VGG.getSigma_0(this.a);
    }

    public boolean E() {
        return VGG.getUseNormalizeDescriptor_0(this.a);
    }

    public boolean F() {
        return VGG.getUseNormalizeImage_0(this.a);
    }

    public boolean G() {
        return VGG.getUseScaleOrientation_0(this.a);
    }

    public void H(float f10) {
        VGG.setScaleFactor_0(this.a, f10);
    }

    public void I(float f10) {
        VGG.setSigma_0(this.a, f10);
    }

    public void J(boolean bl2) {
        VGG.setUseNormalizeDescriptor_0(this.a, bl2);
    }

    public void K(boolean bl2) {
        VGG.setUseNormalizeImage_0(this.a, bl2);
    }

    public void L(boolean bl2) {
        VGG.setUseScaleOrientation_0(this.a, bl2);
    }

    public void finalize() {
        VGG.delete(this.a);
    }
}

