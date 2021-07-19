/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class FastFeatureDetector
extends Feature2D {
    public static final int b = 10000;
    public static final int c = 10001;
    public static final int d = 10002;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;

    public FastFeatureDetector(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, boolean var1, int var2);

    private static native long create_1(int var0, boolean var1);

    private static native long create_2(int var0);

    private static native long create_3();

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    private static native boolean getNonmaxSuppression_0(long var0);

    private static native int getThreshold_0(long var0);

    private static native int getType_0(long var0);

    private static native void setNonmaxSuppression_0(long var0, boolean var2);

    private static native void setThreshold_0(long var0, int var2);

    private static native void setType_0(long var0, int var2);

    public static FastFeatureDetector u(long l10) {
        FastFeatureDetector fastFeatureDetector = new FastFeatureDetector(l10);
        return fastFeatureDetector;
    }

    public static FastFeatureDetector v() {
        return FastFeatureDetector.u(FastFeatureDetector.create_3());
    }

    public static FastFeatureDetector w(int n10) {
        return FastFeatureDetector.u(FastFeatureDetector.create_2(n10));
    }

    public static FastFeatureDetector x(int n10, boolean bl2) {
        return FastFeatureDetector.u(FastFeatureDetector.create_1(n10, bl2));
    }

    public static FastFeatureDetector y(int n10, boolean bl2, int n11) {
        return FastFeatureDetector.u(FastFeatureDetector.create_0(n10, bl2, n11));
    }

    public int A() {
        return FastFeatureDetector.getThreshold_0(this.a);
    }

    public int B() {
        return FastFeatureDetector.getType_0(this.a);
    }

    public void C(boolean bl2) {
        FastFeatureDetector.setNonmaxSuppression_0(this.a, bl2);
    }

    public void D(int n10) {
        FastFeatureDetector.setThreshold_0(this.a, n10);
    }

    public void E(int n10) {
        FastFeatureDetector.setType_0(this.a, n10);
    }

    public String d() {
        return FastFeatureDetector.getDefaultName_0(this.a);
    }

    public void finalize() {
        FastFeatureDetector.delete(this.a);
    }

    public boolean z() {
        return FastFeatureDetector.getNonmaxSuppression_0(this.a);
    }
}

