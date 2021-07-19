/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class AgastFeatureDetector
extends Feature2D {
    public static final int b = 10000;
    public static final int c = 10001;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;

    public AgastFeatureDetector(long l10) {
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

    public static AgastFeatureDetector u(long l10) {
        AgastFeatureDetector agastFeatureDetector = new AgastFeatureDetector(l10);
        return agastFeatureDetector;
    }

    public static AgastFeatureDetector v() {
        return AgastFeatureDetector.u(AgastFeatureDetector.create_3());
    }

    public static AgastFeatureDetector w(int n10) {
        return AgastFeatureDetector.u(AgastFeatureDetector.create_2(n10));
    }

    public static AgastFeatureDetector x(int n10, boolean bl2) {
        return AgastFeatureDetector.u(AgastFeatureDetector.create_1(n10, bl2));
    }

    public static AgastFeatureDetector y(int n10, boolean bl2, int n11) {
        return AgastFeatureDetector.u(AgastFeatureDetector.create_0(n10, bl2, n11));
    }

    public int A() {
        return AgastFeatureDetector.getThreshold_0(this.a);
    }

    public int B() {
        return AgastFeatureDetector.getType_0(this.a);
    }

    public void C(boolean bl2) {
        AgastFeatureDetector.setNonmaxSuppression_0(this.a, bl2);
    }

    public void D(int n10) {
        AgastFeatureDetector.setThreshold_0(this.a, n10);
    }

    public void E(int n10) {
        AgastFeatureDetector.setType_0(this.a, n10);
    }

    public String d() {
        return AgastFeatureDetector.getDefaultName_0(this.a);
    }

    public void finalize() {
        AgastFeatureDetector.delete(this.a);
    }

    public boolean z() {
        return AgastFeatureDetector.getNonmaxSuppression_0(this.a);
    }
}

