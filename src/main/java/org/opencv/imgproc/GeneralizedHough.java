/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import i.f.c.u;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class GeneralizedHough
extends Algorithm {
    public GeneralizedHough(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native void detect_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void detect_1(long var0, long var2, long var4, long var6, long var8);

    private static native void detect_2(long var0, long var2, long var4, long var6);

    private static native void detect_3(long var0, long var2, long var4);

    public static GeneralizedHough g(long l10) {
        GeneralizedHough generalizedHough = new GeneralizedHough(l10);
        return generalizedHough;
    }

    private static native int getCannyHighThresh_0(long var0);

    private static native int getCannyLowThresh_0(long var0);

    private static native double getDp_0(long var0);

    private static native int getMaxBufferSize_0(long var0);

    private static native double getMinDist_0(long var0);

    private static native void setCannyHighThresh_0(long var0, int var2);

    private static native void setCannyLowThresh_0(long var0, int var2);

    private static native void setDp_0(long var0, double var2);

    private static native void setMaxBufferSize_0(long var0, int var2);

    private static native void setMinDist_0(long var0, double var2);

    private static native void setTemplate_0(long var0, long var2, long var4, long var6, double var8, double var10);

    private static native void setTemplate_1(long var0, long var2, long var4, long var6);

    private static native void setTemplate_2(long var0, long var2, double var4, double var6);

    private static native void setTemplate_3(long var0, long var2);

    public void finalize() {
        GeneralizedHough.delete(this.a);
    }

    public void h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        GeneralizedHough.detect_3(l10, l11, l12);
    }

    public void i(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        GeneralizedHough.detect_2(l10, l11, l12, l13);
    }

    public void j(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        GeneralizedHough.detect_1(l10, l11, l12, l13, l14);
    }

    public void k(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        GeneralizedHough.detect_0(l10, l11, l12, l13, l14, l15);
    }

    public int l() {
        return GeneralizedHough.getCannyHighThresh_0(this.a);
    }

    public int m() {
        return GeneralizedHough.getCannyLowThresh_0(this.a);
    }

    public double n() {
        return GeneralizedHough.getDp_0(this.a);
    }

    public int o() {
        return GeneralizedHough.getMaxBufferSize_0(this.a);
    }

    public double p() {
        return GeneralizedHough.getMinDist_0(this.a);
    }

    public void q(int n10) {
        GeneralizedHough.setCannyHighThresh_0(this.a, n10);
    }

    public void r(int n10) {
        GeneralizedHough.setCannyLowThresh_0(this.a, n10);
    }

    public void s(double d10) {
        GeneralizedHough.setDp_0(this.a, d10);
    }

    public void t(int n10) {
        GeneralizedHough.setMaxBufferSize_0(this.a, n10);
    }

    public void u(double d10) {
        GeneralizedHough.setMinDist_0(this.a, d10);
    }

    public void v(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        GeneralizedHough.setTemplate_3(l10, l11);
    }

    public void w(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        GeneralizedHough.setTemplate_1(l10, l11, l12, l13);
    }

    public void x(Mat mat, Mat mat2, Mat mat3, u u10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        GeneralizedHough.setTemplate_0(l10, l11, l12, l13, d10, d11);
    }

    public void y(Mat mat, u u10) {
        long l10 = this.a;
        long l11 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        GeneralizedHough.setTemplate_2(l10, l11, d10, d11);
    }
}

