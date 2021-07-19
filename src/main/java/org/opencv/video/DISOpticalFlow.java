/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.video.DenseOpticalFlow;

public class DISOpticalFlow
extends DenseOpticalFlow {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;

    public DISOpticalFlow(long l10) {
        super(l10);
    }

    private static native long create_0(int var0);

    private static native long create_1();

    private static native void delete(long var0);

    private static native int getFinestScale_0(long var0);

    private static native int getGradientDescentIterations_0(long var0);

    private static native int getPatchSize_0(long var0);

    private static native int getPatchStride_0(long var0);

    private static native boolean getUseMeanNormalization_0(long var0);

    private static native boolean getUseSpatialPropagation_0(long var0);

    private static native float getVariationalRefinementAlpha_0(long var0);

    private static native float getVariationalRefinementDelta_0(long var0);

    private static native float getVariationalRefinementGamma_0(long var0);

    private static native int getVariationalRefinementIterations_0(long var0);

    public static DISOpticalFlow j(long l10) {
        DISOpticalFlow dISOpticalFlow = new DISOpticalFlow(l10);
        return dISOpticalFlow;
    }

    public static DISOpticalFlow k() {
        return DISOpticalFlow.j(DISOpticalFlow.create_1());
    }

    public static DISOpticalFlow l(int n10) {
        return DISOpticalFlow.j(DISOpticalFlow.create_0(n10));
    }

    private static native void setFinestScale_0(long var0, int var2);

    private static native void setGradientDescentIterations_0(long var0, int var2);

    private static native void setPatchSize_0(long var0, int var2);

    private static native void setPatchStride_0(long var0, int var2);

    private static native void setUseMeanNormalization_0(long var0, boolean var2);

    private static native void setUseSpatialPropagation_0(long var0, boolean var2);

    private static native void setVariationalRefinementAlpha_0(long var0, float var2);

    private static native void setVariationalRefinementDelta_0(long var0, float var2);

    private static native void setVariationalRefinementGamma_0(long var0, float var2);

    private static native void setVariationalRefinementIterations_0(long var0, int var2);

    public void A(boolean bl2) {
        DISOpticalFlow.setUseMeanNormalization_0(this.a, bl2);
    }

    public void B(boolean bl2) {
        DISOpticalFlow.setUseSpatialPropagation_0(this.a, bl2);
    }

    public void C(float f10) {
        DISOpticalFlow.setVariationalRefinementAlpha_0(this.a, f10);
    }

    public void D(float f10) {
        DISOpticalFlow.setVariationalRefinementDelta_0(this.a, f10);
    }

    public void E(float f10) {
        DISOpticalFlow.setVariationalRefinementGamma_0(this.a, f10);
    }

    public void F(int n10) {
        DISOpticalFlow.setVariationalRefinementIterations_0(this.a, n10);
    }

    public void finalize() {
        DISOpticalFlow.delete(this.a);
    }

    public int m() {
        return DISOpticalFlow.getFinestScale_0(this.a);
    }

    public int n() {
        return DISOpticalFlow.getGradientDescentIterations_0(this.a);
    }

    public int o() {
        return DISOpticalFlow.getPatchSize_0(this.a);
    }

    public int p() {
        return DISOpticalFlow.getPatchStride_0(this.a);
    }

    public boolean q() {
        return DISOpticalFlow.getUseMeanNormalization_0(this.a);
    }

    public boolean r() {
        return DISOpticalFlow.getUseSpatialPropagation_0(this.a);
    }

    public float s() {
        return DISOpticalFlow.getVariationalRefinementAlpha_0(this.a);
    }

    public float t() {
        return DISOpticalFlow.getVariationalRefinementDelta_0(this.a);
    }

    public float u() {
        return DISOpticalFlow.getVariationalRefinementGamma_0(this.a);
    }

    public int v() {
        return DISOpticalFlow.getVariationalRefinementIterations_0(this.a);
    }

    public void w(int n10) {
        DISOpticalFlow.setFinestScale_0(this.a, n10);
    }

    public void x(int n10) {
        DISOpticalFlow.setGradientDescentIterations_0(this.a, n10);
    }

    public void y(int n10) {
        DISOpticalFlow.setPatchSize_0(this.a, n10);
    }

    public void z(int n10) {
        DISOpticalFlow.setPatchStride_0(this.a, n10);
    }
}

