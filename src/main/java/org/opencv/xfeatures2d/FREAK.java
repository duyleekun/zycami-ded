/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import i.f.c.k;
import org.opencv.features2d.Feature2D;

public class FREAK
extends Feature2D {
    public FREAK(long l10) {
        super(l10);
    }

    public static FREAK A(boolean bl2, boolean bl3, float f10, int n10, k k10) {
        long l10 = k10.a;
        return FREAK.u(FREAK.create_0(bl2, bl3, f10, n10, l10));
    }

    private static native long create_0(boolean var0, boolean var1, float var2, int var3, long var4);

    private static native long create_1(boolean var0, boolean var1, float var2, int var3);

    private static native long create_2(boolean var0, boolean var1, float var2);

    private static native long create_3(boolean var0, boolean var1);

    private static native long create_4(boolean var0);

    private static native long create_5();

    private static native void delete(long var0);

    public static FREAK u(long l10) {
        FREAK fREAK = new FREAK(l10);
        return fREAK;
    }

    public static FREAK v() {
        return FREAK.u(FREAK.create_5());
    }

    public static FREAK w(boolean bl2) {
        return FREAK.u(FREAK.create_4(bl2));
    }

    public static FREAK x(boolean bl2, boolean bl3) {
        return FREAK.u(FREAK.create_3(bl2, bl3));
    }

    public static FREAK y(boolean bl2, boolean bl3, float f10) {
        return FREAK.u(FREAK.create_2(bl2, bl3, f10));
    }

    public static FREAK z(boolean bl2, boolean bl3, float f10, int n10) {
        return FREAK.u(FREAK.create_1(bl2, bl3, f10, n10));
    }

    public void finalize() {
        FREAK.delete(this.a);
    }
}

