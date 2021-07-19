/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import i.f.c.e;
import i.f.c.l;
import i.f.c.z;

public class Xfeatures2d {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;

    public static void a(z z10, z z11, l l10, l l11, e e10, e e11) {
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        long l12 = l10.a;
        long l13 = l11.a;
        long l14 = e10.a;
        long l15 = e11.a;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        long l16 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        Xfeatures2d.matchGMS_3(d14, d10, d11, d13, l16, l12, l13, l15);
    }

    public static void b(z z10, z z11, l l10, l l11, e e10, e e11, boolean bl2) {
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        long l12 = l10.a;
        long l13 = l11.a;
        long l14 = e10.a;
        long l15 = e11.a;
        Xfeatures2d.matchGMS_2(d10, d11, d12, d13, l12, l13, l14, l15, bl2);
    }

    public static void c(z z10, z z11, l l10, l l11, e e10, e e11, boolean bl2, boolean bl3) {
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        long l12 = l10.a;
        long l13 = l11.a;
        long l14 = e10.a;
        long l15 = e11.a;
        Xfeatures2d.matchGMS_1(d10, d11, d12, d13, l12, l13, l14, l15, bl2, bl3);
    }

    public static void d(z z10, z z11, l l10, l l11, e e10, e e11, boolean bl2, boolean bl3, double d10) {
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        long l12 = l10.a;
        long l13 = l11.a;
        long l14 = e10.a;
        long l15 = e11.a;
        Xfeatures2d.matchGMS_0(d11, d12, d13, d14, l12, l13, l14, l15, bl2, bl3, d10);
    }

    private static native void matchGMS_0(double var0, double var2, double var4, double var6, long var8, long var10, long var12, long var14, boolean var16, boolean var17, double var18);

    private static native void matchGMS_1(double var0, double var2, double var4, double var6, long var8, long var10, long var12, long var14, boolean var16, boolean var17);

    private static native void matchGMS_2(double var0, double var2, double var4, double var6, long var8, long var10, long var12, long var14, boolean var16);

    private static native void matchGMS_3(double var0, double var2, double var4, double var6, long var8, long var10, long var12, long var14);
}

