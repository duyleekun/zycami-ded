/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class LATCH
extends Feature2D {
    public LATCH(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, boolean var1, int var2, double var3);

    private static native long create_1(int var0, boolean var1, int var2);

    private static native long create_2(int var0, boolean var1);

    private static native long create_3(int var0);

    private static native long create_4();

    private static native void delete(long var0);

    public static LATCH u(long l10) {
        LATCH lATCH = new LATCH(l10);
        return lATCH;
    }

    public static LATCH v() {
        return LATCH.u(LATCH.create_4());
    }

    public static LATCH w(int n10) {
        return LATCH.u(LATCH.create_3(n10));
    }

    public static LATCH x(int n10, boolean bl2) {
        return LATCH.u(LATCH.create_2(n10, bl2));
    }

    public static LATCH y(int n10, boolean bl2, int n11) {
        return LATCH.u(LATCH.create_1(n10, bl2, n11));
    }

    public static LATCH z(int n10, boolean bl2, int n11, double d10) {
        return LATCH.u(LATCH.create_0(n10, bl2, n11, d10));
    }

    public void finalize() {
        LATCH.delete(this.a);
    }
}

