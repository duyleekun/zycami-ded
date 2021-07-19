/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.i;
import i.f.c.k;
import org.opencv.features2d.Feature2D;

public class BRISK
extends Feature2D {
    public BRISK(long l10) {
        super(l10);
    }

    public static BRISK A(int n10, int n11, i i10, k k10, float f10) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_2(n10, n11, l10, l11, f10));
    }

    public static BRISK B(int n10, int n11, i i10, k k10, float f10, float f11) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_1(n10, n11, l10, l11, f10, f11));
    }

    public static BRISK C(int n10, int n11, i i10, k k10, float f10, float f11, k k11) {
        long l10 = i10.a;
        long l11 = k10.a;
        long l12 = k11.a;
        return BRISK.u(BRISK.create_0(n10, n11, l10, l11, f10, f11, l12));
    }

    public static BRISK D(i i10, k k10) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_11(l10, l11));
    }

    public static BRISK E(i i10, k k10, float f10) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_10(l10, l11, f10));
    }

    public static BRISK F(i i10, k k10, float f10, float f11) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_9(l10, l11, f10, f11));
    }

    public static BRISK G(i i10, k k10, float f10, float f11, k k11) {
        long l10 = i10.a;
        long l11 = k10.a;
        long l12 = k11.a;
        return BRISK.u(BRISK.create_8(l10, l11, f10, f11, l12));
    }

    private static native long create_0(int var0, int var1, long var2, long var4, float var6, float var7, long var8);

    private static native long create_1(int var0, int var1, long var2, long var4, float var6, float var7);

    private static native long create_10(long var0, long var2, float var4);

    private static native long create_11(long var0, long var2);

    private static native long create_2(int var0, int var1, long var2, long var4, float var6);

    private static native long create_3(int var0, int var1, long var2, long var4);

    private static native long create_4(int var0, int var1, float var2);

    private static native long create_5(int var0, int var1);

    private static native long create_6(int var0);

    private static native long create_7();

    private static native long create_8(long var0, long var2, float var4, float var5, long var6);

    private static native long create_9(long var0, long var2, float var4, float var5);

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    private static native int getOctaves_0(long var0);

    private static native int getThreshold_0(long var0);

    private static native void setOctaves_0(long var0, int var2);

    private static native void setThreshold_0(long var0, int var2);

    public static BRISK u(long l10) {
        BRISK bRISK = new BRISK(l10);
        return bRISK;
    }

    public static BRISK v() {
        return BRISK.u(BRISK.create_7());
    }

    public static BRISK w(int n10) {
        return BRISK.u(BRISK.create_6(n10));
    }

    public static BRISK x(int n10, int n11) {
        return BRISK.u(BRISK.create_5(n10, n11));
    }

    public static BRISK y(int n10, int n11, float f10) {
        return BRISK.u(BRISK.create_4(n10, n11, f10));
    }

    public static BRISK z(int n10, int n11, i i10, k k10) {
        long l10 = i10.a;
        long l11 = k10.a;
        return BRISK.u(BRISK.create_3(n10, n11, l10, l11));
    }

    public int H() {
        return BRISK.getOctaves_0(this.a);
    }

    public int I() {
        return BRISK.getThreshold_0(this.a);
    }

    public void J(int n10) {
        BRISK.setOctaves_0(this.a, n10);
    }

    public void K(int n10) {
        BRISK.setThreshold_0(this.a, n10);
    }

    public String d() {
        return BRISK.getDefaultName_0(this.a);
    }

    public void finalize() {
        BRISK.delete(this.a);
    }
}

