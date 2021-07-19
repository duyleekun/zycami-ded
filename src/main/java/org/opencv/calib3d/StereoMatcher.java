/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.calib3d;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class StereoMatcher
extends Algorithm {
    public static final int b = 4;
    public static final int c = 16;

    public StereoMatcher(long l10) {
        super(l10);
    }

    private static native void compute_0(long var0, long var2, long var4, long var6);

    private static native void delete(long var0);

    public static StereoMatcher g(long l10) {
        StereoMatcher stereoMatcher = new StereoMatcher(l10);
        return stereoMatcher;
    }

    private static native int getBlockSize_0(long var0);

    private static native int getDisp12MaxDiff_0(long var0);

    private static native int getMinDisparity_0(long var0);

    private static native int getNumDisparities_0(long var0);

    private static native int getSpeckleRange_0(long var0);

    private static native int getSpeckleWindowSize_0(long var0);

    private static native void setBlockSize_0(long var0, int var2);

    private static native void setDisp12MaxDiff_0(long var0, int var2);

    private static native void setMinDisparity_0(long var0, int var2);

    private static native void setNumDisparities_0(long var0, int var2);

    private static native void setSpeckleRange_0(long var0, int var2);

    private static native void setSpeckleWindowSize_0(long var0, int var2);

    public void finalize() {
        StereoMatcher.delete(this.a);
    }

    public void h(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        StereoMatcher.compute_0(l10, l11, l12, l13);
    }

    public int i() {
        return StereoMatcher.getBlockSize_0(this.a);
    }

    public int j() {
        return StereoMatcher.getDisp12MaxDiff_0(this.a);
    }

    public int k() {
        return StereoMatcher.getMinDisparity_0(this.a);
    }

    public int l() {
        return StereoMatcher.getNumDisparities_0(this.a);
    }

    public int m() {
        return StereoMatcher.getSpeckleRange_0(this.a);
    }

    public int n() {
        return StereoMatcher.getSpeckleWindowSize_0(this.a);
    }

    public void o(int n10) {
        StereoMatcher.setBlockSize_0(this.a, n10);
    }

    public void p(int n10) {
        StereoMatcher.setDisp12MaxDiff_0(this.a, n10);
    }

    public void q(int n10) {
        StereoMatcher.setMinDisparity_0(this.a, n10);
    }

    public void r(int n10) {
        StereoMatcher.setNumDisparities_0(this.a, n10);
    }

    public void s(int n10) {
        StereoMatcher.setSpeckleRange_0(this.a, n10);
    }

    public void t(int n10) {
        StereoMatcher.setSpeckleWindowSize_0(this.a, n10);
    }
}

