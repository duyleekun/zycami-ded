/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Mat;
import org.opencv.video.BackgroundSubtractor;

public class BackgroundSubtractorMOG2
extends BackgroundSubtractor {
    public BackgroundSubtractorMOG2(long l10) {
        super(l10);
    }

    private static native void apply_0(long var0, long var2, long var4, double var6);

    private static native void apply_1(long var0, long var2, long var4);

    private static native void delete(long var0);

    private static native double getBackgroundRatio_0(long var0);

    private static native double getComplexityReductionThreshold_0(long var0);

    private static native boolean getDetectShadows_0(long var0);

    private static native int getHistory_0(long var0);

    private static native int getNMixtures_0(long var0);

    private static native double getShadowThreshold_0(long var0);

    private static native int getShadowValue_0(long var0);

    private static native double getVarInit_0(long var0);

    private static native double getVarMax_0(long var0);

    private static native double getVarMin_0(long var0);

    private static native double getVarThresholdGen_0(long var0);

    private static native double getVarThreshold_0(long var0);

    public static BackgroundSubtractorMOG2 k(long l10) {
        BackgroundSubtractorMOG2 backgroundSubtractorMOG2 = new BackgroundSubtractorMOG2(l10);
        return backgroundSubtractorMOG2;
    }

    private static native void setBackgroundRatio_0(long var0, double var2);

    private static native void setComplexityReductionThreshold_0(long var0, double var2);

    private static native void setDetectShadows_0(long var0, boolean var2);

    private static native void setHistory_0(long var0, int var2);

    private static native void setNMixtures_0(long var0, int var2);

    private static native void setShadowThreshold_0(long var0, double var2);

    private static native void setShadowValue_0(long var0, int var2);

    private static native void setVarInit_0(long var0, double var2);

    private static native void setVarMax_0(long var0, double var2);

    private static native void setVarMin_0(long var0, double var2);

    private static native void setVarThresholdGen_0(long var0, double var2);

    private static native void setVarThreshold_0(long var0, double var2);

    public void A(int n10) {
        BackgroundSubtractorMOG2.setHistory_0(this.a, n10);
    }

    public void B(int n10) {
        BackgroundSubtractorMOG2.setNMixtures_0(this.a, n10);
    }

    public void C(double d10) {
        BackgroundSubtractorMOG2.setShadowThreshold_0(this.a, d10);
    }

    public void D(int n10) {
        BackgroundSubtractorMOG2.setShadowValue_0(this.a, n10);
    }

    public void E(double d10) {
        BackgroundSubtractorMOG2.setVarInit_0(this.a, d10);
    }

    public void F(double d10) {
        BackgroundSubtractorMOG2.setVarMax_0(this.a, d10);
    }

    public void G(double d10) {
        BackgroundSubtractorMOG2.setVarMin_0(this.a, d10);
    }

    public void H(double d10) {
        BackgroundSubtractorMOG2.setVarThreshold_0(this.a, d10);
    }

    public void I(double d10) {
        BackgroundSubtractorMOG2.setVarThresholdGen_0(this.a, d10);
    }

    public void finalize() {
        BackgroundSubtractorMOG2.delete(this.a);
    }

    public void h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        BackgroundSubtractorMOG2.apply_1(l10, l11, l12);
    }

    public void i(Mat mat, Mat mat2, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        BackgroundSubtractorMOG2.apply_0(l10, l11, l12, d10);
    }

    public double l() {
        return BackgroundSubtractorMOG2.getBackgroundRatio_0(this.a);
    }

    public double m() {
        return BackgroundSubtractorMOG2.getComplexityReductionThreshold_0(this.a);
    }

    public boolean n() {
        return BackgroundSubtractorMOG2.getDetectShadows_0(this.a);
    }

    public int o() {
        return BackgroundSubtractorMOG2.getHistory_0(this.a);
    }

    public int p() {
        return BackgroundSubtractorMOG2.getNMixtures_0(this.a);
    }

    public double q() {
        return BackgroundSubtractorMOG2.getShadowThreshold_0(this.a);
    }

    public int r() {
        return BackgroundSubtractorMOG2.getShadowValue_0(this.a);
    }

    public double s() {
        return BackgroundSubtractorMOG2.getVarInit_0(this.a);
    }

    public double t() {
        return BackgroundSubtractorMOG2.getVarMax_0(this.a);
    }

    public double u() {
        return BackgroundSubtractorMOG2.getVarMin_0(this.a);
    }

    public double v() {
        return BackgroundSubtractorMOG2.getVarThreshold_0(this.a);
    }

    public double w() {
        return BackgroundSubtractorMOG2.getVarThresholdGen_0(this.a);
    }

    public void x(double d10) {
        BackgroundSubtractorMOG2.setBackgroundRatio_0(this.a, d10);
    }

    public void y(double d10) {
        BackgroundSubtractorMOG2.setComplexityReductionThreshold_0(this.a, d10);
    }

    public void z(boolean bl2) {
        BackgroundSubtractorMOG2.setDetectShadows_0(this.a, bl2);
    }
}

