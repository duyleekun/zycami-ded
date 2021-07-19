/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.objdetect;

import i.f.c.k;
import i.f.c.r;

public class Objdetect {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;

    public static void a(r r10, k k10, int n10) {
        long l10 = r10.a;
        long l11 = k10.a;
        Objdetect.groupRectangles_1(l10, l11, n10);
    }

    public static void b(r r10, k k10, int n10, double d10) {
        long l10 = r10.a;
        long l11 = k10.a;
        Objdetect.groupRectangles_0(l10, l11, n10, d10);
    }

    private static native void groupRectangles_0(long var0, long var2, int var4, double var5);

    private static native void groupRectangles_1(long var0, long var2, int var4);
}

