/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class StarDetector
extends Feature2D {
    public StarDetector(long l10) {
        super(l10);
    }

    public static StarDetector A(int n10, int n11, int n12, int n13, int n14) {
        return StarDetector.u(StarDetector.create_0(n10, n11, n12, n13, n14));
    }

    private static native long create_0(int var0, int var1, int var2, int var3, int var4);

    private static native long create_1(int var0, int var1, int var2, int var3);

    private static native long create_2(int var0, int var1, int var2);

    private static native long create_3(int var0, int var1);

    private static native long create_4(int var0);

    private static native long create_5();

    private static native void delete(long var0);

    public static StarDetector u(long l10) {
        StarDetector starDetector = new StarDetector(l10);
        return starDetector;
    }

    public static StarDetector v() {
        return StarDetector.u(StarDetector.create_5());
    }

    public static StarDetector w(int n10) {
        return StarDetector.u(StarDetector.create_4(n10));
    }

    public static StarDetector x(int n10, int n11) {
        return StarDetector.u(StarDetector.create_3(n10, n11));
    }

    public static StarDetector y(int n10, int n11, int n12) {
        return StarDetector.u(StarDetector.create_2(n10, n11, n12));
    }

    public static StarDetector z(int n10, int n11, int n12, int n13) {
        return StarDetector.u(StarDetector.create_1(n10, n11, n12, n13));
    }

    public void finalize() {
        StarDetector.delete(this.a);
    }
}

