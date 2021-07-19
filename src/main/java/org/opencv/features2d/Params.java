/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

public class Params {
    public final long a;

    public Params() {
        long l10;
        this.a = l10 = Params.Params_0();
    }

    public Params(long l10) {
        this.a = l10;
    }

    private static native long Params_0();

    public static Params a(long l10) {
        Params params = new Params(l10);
        return params;
    }

    private static native void delete(long var0);

    private static native boolean get_filterByArea_0(long var0);

    private static native boolean get_filterByCircularity_0(long var0);

    private static native boolean get_filterByColor_0(long var0);

    private static native boolean get_filterByConvexity_0(long var0);

    private static native boolean get_filterByInertia_0(long var0);

    private static native float get_maxArea_0(long var0);

    private static native float get_maxCircularity_0(long var0);

    private static native float get_maxConvexity_0(long var0);

    private static native float get_maxInertiaRatio_0(long var0);

    private static native float get_maxThreshold_0(long var0);

    private static native float get_minArea_0(long var0);

    private static native float get_minCircularity_0(long var0);

    private static native float get_minConvexity_0(long var0);

    private static native float get_minDistBetweenBlobs_0(long var0);

    private static native float get_minInertiaRatio_0(long var0);

    private static native long get_minRepeatability_0(long var0);

    private static native float get_minThreshold_0(long var0);

    private static native float get_thresholdStep_0(long var0);

    private static native void set_filterByArea_0(long var0, boolean var2);

    private static native void set_filterByCircularity_0(long var0, boolean var2);

    private static native void set_filterByColor_0(long var0, boolean var2);

    private static native void set_filterByConvexity_0(long var0, boolean var2);

    private static native void set_filterByInertia_0(long var0, boolean var2);

    private static native void set_maxArea_0(long var0, float var2);

    private static native void set_maxCircularity_0(long var0, float var2);

    private static native void set_maxConvexity_0(long var0, float var2);

    private static native void set_maxInertiaRatio_0(long var0, float var2);

    private static native void set_maxThreshold_0(long var0, float var2);

    private static native void set_minArea_0(long var0, float var2);

    private static native void set_minCircularity_0(long var0, float var2);

    private static native void set_minConvexity_0(long var0, float var2);

    private static native void set_minDistBetweenBlobs_0(long var0, float var2);

    private static native void set_minInertiaRatio_0(long var0, float var2);

    private static native void set_minRepeatability_0(long var0, long var2);

    private static native void set_minThreshold_0(long var0, float var2);

    private static native void set_thresholdStep_0(long var0, float var2);

    public void A(float f10) {
        Params.set_maxCircularity_0(this.a, f10);
    }

    public void B(float f10) {
        Params.set_maxConvexity_0(this.a, f10);
    }

    public void C(float f10) {
        Params.set_maxInertiaRatio_0(this.a, f10);
    }

    public void D(float f10) {
        Params.set_maxThreshold_0(this.a, f10);
    }

    public void E(float f10) {
        Params.set_minArea_0(this.a, f10);
    }

    public void F(float f10) {
        Params.set_minCircularity_0(this.a, f10);
    }

    public void G(float f10) {
        Params.set_minConvexity_0(this.a, f10);
    }

    public void H(float f10) {
        Params.set_minDistBetweenBlobs_0(this.a, f10);
    }

    public void I(float f10) {
        Params.set_minInertiaRatio_0(this.a, f10);
    }

    public void J(long l10) {
        Params.set_minRepeatability_0(this.a, l10);
    }

    public void K(float f10) {
        Params.set_minThreshold_0(this.a, f10);
    }

    public void L(float f10) {
        Params.set_thresholdStep_0(this.a, f10);
    }

    public long b() {
        return this.a;
    }

    public boolean c() {
        return Params.get_filterByArea_0(this.a);
    }

    public boolean d() {
        return Params.get_filterByCircularity_0(this.a);
    }

    public boolean e() {
        return Params.get_filterByColor_0(this.a);
    }

    public boolean f() {
        return Params.get_filterByConvexity_0(this.a);
    }

    public void finalize() {
        Params.delete(this.a);
    }

    public boolean g() {
        return Params.get_filterByInertia_0(this.a);
    }

    public float h() {
        return Params.get_maxArea_0(this.a);
    }

    public float i() {
        return Params.get_maxCircularity_0(this.a);
    }

    public float j() {
        return Params.get_maxConvexity_0(this.a);
    }

    public float k() {
        return Params.get_maxInertiaRatio_0(this.a);
    }

    public float l() {
        return Params.get_maxThreshold_0(this.a);
    }

    public float m() {
        return Params.get_minArea_0(this.a);
    }

    public float n() {
        return Params.get_minCircularity_0(this.a);
    }

    public float o() {
        return Params.get_minConvexity_0(this.a);
    }

    public float p() {
        return Params.get_minDistBetweenBlobs_0(this.a);
    }

    public float q() {
        return Params.get_minInertiaRatio_0(this.a);
    }

    public long r() {
        return Params.get_minRepeatability_0(this.a);
    }

    public float s() {
        return Params.get_minThreshold_0(this.a);
    }

    public float t() {
        return Params.get_thresholdStep_0(this.a);
    }

    public void u(boolean bl2) {
        Params.set_filterByArea_0(this.a, bl2);
    }

    public void v(boolean bl2) {
        Params.set_filterByCircularity_0(this.a, bl2);
    }

    public void w(boolean bl2) {
        Params.set_filterByColor_0(this.a, bl2);
    }

    public void x(boolean bl2) {
        Params.set_filterByConvexity_0(this.a, bl2);
    }

    public void y(boolean bl2) {
        Params.set_filterByInertia_0(this.a, bl2);
    }

    public void z(float f10) {
        Params.set_maxArea_0(this.a, f10);
    }
}

