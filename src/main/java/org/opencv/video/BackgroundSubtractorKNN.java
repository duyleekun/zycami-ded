/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.video.BackgroundSubtractor;

public class BackgroundSubtractorKNN
extends BackgroundSubtractor {
    public BackgroundSubtractorKNN(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native boolean getDetectShadows_0(long var0);

    private static native double getDist2Threshold_0(long var0);

    private static native int getHistory_0(long var0);

    private static native int getNSamples_0(long var0);

    private static native double getShadowThreshold_0(long var0);

    private static native int getShadowValue_0(long var0);

    private static native int getkNNSamples_0(long var0);

    public static BackgroundSubtractorKNN k(long l10) {
        BackgroundSubtractorKNN backgroundSubtractorKNN = new BackgroundSubtractorKNN(l10);
        return backgroundSubtractorKNN;
    }

    private static native void setDetectShadows_0(long var0, boolean var2);

    private static native void setDist2Threshold_0(long var0, double var2);

    private static native void setHistory_0(long var0, int var2);

    private static native void setNSamples_0(long var0, int var2);

    private static native void setShadowThreshold_0(long var0, double var2);

    private static native void setShadowValue_0(long var0, int var2);

    private static native void setkNNSamples_0(long var0, int var2);

    public void finalize() {
        BackgroundSubtractorKNN.delete(this.a);
    }

    public boolean l() {
        return BackgroundSubtractorKNN.getDetectShadows_0(this.a);
    }

    public double m() {
        return BackgroundSubtractorKNN.getDist2Threshold_0(this.a);
    }

    public int n() {
        return BackgroundSubtractorKNN.getHistory_0(this.a);
    }

    public int o() {
        return BackgroundSubtractorKNN.getNSamples_0(this.a);
    }

    public double p() {
        return BackgroundSubtractorKNN.getShadowThreshold_0(this.a);
    }

    public int q() {
        return BackgroundSubtractorKNN.getShadowValue_0(this.a);
    }

    public int r() {
        return BackgroundSubtractorKNN.getkNNSamples_0(this.a);
    }

    public void s(boolean bl2) {
        BackgroundSubtractorKNN.setDetectShadows_0(this.a, bl2);
    }

    public void t(double d10) {
        BackgroundSubtractorKNN.setDist2Threshold_0(this.a, d10);
    }

    public void u(int n10) {
        BackgroundSubtractorKNN.setHistory_0(this.a, n10);
    }

    public void v(int n10) {
        BackgroundSubtractorKNN.setNSamples_0(this.a, n10);
    }

    public void w(double d10) {
        BackgroundSubtractorKNN.setShadowThreshold_0(this.a, d10);
    }

    public void x(int n10) {
        BackgroundSubtractorKNN.setShadowValue_0(this.a, n10);
    }

    public void y(int n10) {
        BackgroundSubtractorKNN.setkNNSamples_0(this.a, n10);
    }
}

