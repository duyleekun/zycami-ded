/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class SIFT
extends Feature2D {
    public SIFT(long l10) {
        super(l10);
    }

    public static SIFT A(int n10, int n11, double d10, double d11, double d12) {
        return SIFT.u(SIFT.create_0(n10, n11, d10, d11, d12));
    }

    private static native long create_0(int var0, int var1, double var2, double var4, double var6);

    private static native long create_1(int var0, int var1, double var2, double var4);

    private static native long create_2(int var0, int var1, double var2);

    private static native long create_3(int var0, int var1);

    private static native long create_4(int var0);

    private static native long create_5();

    private static native void delete(long var0);

    public static SIFT u(long l10) {
        SIFT sIFT = new SIFT(l10);
        return sIFT;
    }

    public static SIFT v() {
        return SIFT.u(SIFT.create_5());
    }

    public static SIFT w(int n10) {
        return SIFT.u(SIFT.create_4(n10));
    }

    public static SIFT x(int n10, int n11) {
        return SIFT.u(SIFT.create_3(n10, n11));
    }

    public static SIFT y(int n10, int n11, double d10) {
        return SIFT.u(SIFT.create_2(n10, n11, d10));
    }

    public static SIFT z(int n10, int n11, double d10, double d11) {
        return SIFT.u(SIFT.create_1(n10, n11, d10, d11));
    }

    public void finalize() {
        SIFT.delete(this.a);
    }
}

