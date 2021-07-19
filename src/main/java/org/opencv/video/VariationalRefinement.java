/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Mat;
import org.opencv.video.DenseOpticalFlow;

public class VariationalRefinement
extends DenseOpticalFlow {
    public VariationalRefinement(long l10) {
        super(l10);
    }

    private static native void calcUV_0(long var0, long var2, long var4, long var6, long var8);

    private static native long create_0();

    private static native void delete(long var0);

    private static native float getAlpha_0(long var0);

    private static native float getDelta_0(long var0);

    private static native int getFixedPointIterations_0(long var0);

    private static native float getGamma_0(long var0);

    private static native float getOmega_0(long var0);

    private static native int getSorIterations_0(long var0);

    public static VariationalRefinement j(long l10) {
        VariationalRefinement variationalRefinement = new VariationalRefinement(l10);
        return variationalRefinement;
    }

    public static VariationalRefinement l() {
        return VariationalRefinement.j(VariationalRefinement.create_0());
    }

    private static native void setAlpha_0(long var0, float var2);

    private static native void setDelta_0(long var0, float var2);

    private static native void setFixedPointIterations_0(long var0, int var2);

    private static native void setGamma_0(long var0, float var2);

    private static native void setOmega_0(long var0, float var2);

    private static native void setSorIterations_0(long var0, int var2);

    public void finalize() {
        VariationalRefinement.delete(this.a);
    }

    public void k(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        VariationalRefinement.calcUV_0(l10, l11, l12, l13, l14);
    }

    public float m() {
        return VariationalRefinement.getAlpha_0(this.a);
    }

    public float n() {
        return VariationalRefinement.getDelta_0(this.a);
    }

    public int o() {
        return VariationalRefinement.getFixedPointIterations_0(this.a);
    }

    public float p() {
        return VariationalRefinement.getGamma_0(this.a);
    }

    public float q() {
        return VariationalRefinement.getOmega_0(this.a);
    }

    public int r() {
        return VariationalRefinement.getSorIterations_0(this.a);
    }

    public void s(float f10) {
        VariationalRefinement.setAlpha_0(this.a, f10);
    }

    public void t(float f10) {
        VariationalRefinement.setDelta_0(this.a, f10);
    }

    public void u(int n10) {
        VariationalRefinement.setFixedPointIterations_0(this.a, n10);
    }

    public void v(float f10) {
        VariationalRefinement.setGamma_0(this.a, f10);
    }

    public void w(float f10) {
        VariationalRefinement.setOmega_0(this.a, f10);
    }

    public void x(int n10) {
        VariationalRefinement.setSorIterations_0(this.a, n10);
    }
}

