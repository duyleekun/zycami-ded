/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class HarrisLaplaceFeatureDetector
extends Feature2D {
    public HarrisLaplaceFeatureDetector(long l10) {
        super(l10);
    }

    public static HarrisLaplaceFeatureDetector A(int n10, float f10, float f11, int n11, int n12) {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_0(n10, f10, f11, n11, n12));
    }

    private static native long create_0(int var0, float var1, float var2, int var3, int var4);

    private static native long create_1(int var0, float var1, float var2, int var3);

    private static native long create_2(int var0, float var1, float var2);

    private static native long create_3(int var0, float var1);

    private static native long create_4(int var0);

    private static native long create_5();

    private static native void delete(long var0);

    public static HarrisLaplaceFeatureDetector u(long l10) {
        HarrisLaplaceFeatureDetector harrisLaplaceFeatureDetector = new HarrisLaplaceFeatureDetector(l10);
        return harrisLaplaceFeatureDetector;
    }

    public static HarrisLaplaceFeatureDetector v() {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_5());
    }

    public static HarrisLaplaceFeatureDetector w(int n10) {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_4(n10));
    }

    public static HarrisLaplaceFeatureDetector x(int n10, float f10) {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_3(n10, f10));
    }

    public static HarrisLaplaceFeatureDetector y(int n10, float f10, float f11) {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_2(n10, f10, f11));
    }

    public static HarrisLaplaceFeatureDetector z(int n10, float f10, float f11, int n11) {
        return HarrisLaplaceFeatureDetector.u(HarrisLaplaceFeatureDetector.create_1(n10, f10, f11, n11));
    }

    public void finalize() {
        HarrisLaplaceFeatureDetector.delete(this.a);
    }
}

