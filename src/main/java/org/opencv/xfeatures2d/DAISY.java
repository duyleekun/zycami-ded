/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.core.Mat;
import org.opencv.features2d.Feature2D;

public class DAISY
extends Feature2D {
    public static final int b = 100;
    public static final int c = 101;
    public static final int d = 102;
    public static final int e = 103;

    public DAISY(long l10) {
        super(l10);
    }

    public static DAISY A(float f10, int n10, int n11, int n12, Mat mat) {
        long l10 = mat.a;
        return DAISY.u(DAISY.create_2(f10, n10, n11, n12, l10));
    }

    public static DAISY B(float f10, int n10, int n11, int n12, Mat mat, boolean bl2) {
        long l10 = mat.a;
        return DAISY.u(DAISY.create_1(f10, n10, n11, n12, l10, bl2));
    }

    public static DAISY C(float f10, int n10, int n11, int n12, Mat mat, boolean bl2, boolean bl3) {
        long l10 = mat.a;
        return DAISY.u(DAISY.create_0(f10, n10, n11, n12, l10, bl2, bl3));
    }

    private static native long create_0(float var0, int var1, int var2, int var3, long var4, boolean var6, boolean var7);

    private static native long create_1(float var0, int var1, int var2, int var3, long var4, boolean var6);

    private static native long create_2(float var0, int var1, int var2, int var3, long var4);

    private static native long create_3(float var0, int var1, int var2, int var3);

    private static native long create_5(float var0, int var1, int var2);

    private static native long create_6(float var0, int var1);

    private static native long create_7(float var0);

    private static native long create_8();

    private static native void delete(long var0);

    public static DAISY u(long l10) {
        DAISY dAISY = new DAISY(l10);
        return dAISY;
    }

    public static DAISY v() {
        return DAISY.u(DAISY.create_8());
    }

    public static DAISY w(float f10) {
        return DAISY.u(DAISY.create_7(f10));
    }

    public static DAISY x(float f10, int n10) {
        return DAISY.u(DAISY.create_6(f10, n10));
    }

    public static DAISY y(float f10, int n10, int n11) {
        return DAISY.u(DAISY.create_5(f10, n10, n11));
    }

    public static DAISY z(float f10, int n10, int n11, int n12) {
        return DAISY.u(DAISY.create_3(f10, n10, n11, n12));
    }

    public void finalize() {
        DAISY.delete(this.a);
    }
}

