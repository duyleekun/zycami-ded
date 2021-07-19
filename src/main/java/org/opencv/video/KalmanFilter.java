/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Mat;

public class KalmanFilter {
    public final long a;

    public KalmanFilter() {
        long l10;
        this.a = l10 = KalmanFilter.KalmanFilter_3();
    }

    public KalmanFilter(int n10, int n11) {
        long l10;
        this.a = l10 = KalmanFilter.KalmanFilter_2(n10, n11);
    }

    public KalmanFilter(int n10, int n11, int n12) {
        long l10;
        this.a = l10 = KalmanFilter.KalmanFilter_1(n10, n11, n12);
    }

    public KalmanFilter(int n10, int n11, int n12, int n13) {
        long l10;
        this.a = l10 = KalmanFilter.KalmanFilter_0(n10, n11, n12, n13);
    }

    public KalmanFilter(long l10) {
        this.a = l10;
    }

    private static native long KalmanFilter_0(int var0, int var1, int var2, int var3);

    private static native long KalmanFilter_1(int var0, int var1, int var2);

    private static native long KalmanFilter_2(int var0, int var1);

    private static native long KalmanFilter_3();

    public static KalmanFilter a(long l10) {
        KalmanFilter kalmanFilter = new KalmanFilter(l10);
        return kalmanFilter;
    }

    private static native long correct_0(long var0, long var2);

    private static native void delete(long var0);

    private static native long get_controlMatrix_0(long var0);

    private static native long get_errorCovPost_0(long var0);

    private static native long get_errorCovPre_0(long var0);

    private static native long get_gain_0(long var0);

    private static native long get_measurementMatrix_0(long var0);

    private static native long get_measurementNoiseCov_0(long var0);

    private static native long get_processNoiseCov_0(long var0);

    private static native long get_statePost_0(long var0);

    private static native long get_statePre_0(long var0);

    private static native long get_transitionMatrix_0(long var0);

    private static native long predict_0(long var0, long var2);

    private static native long predict_1(long var0);

    private static native void set_controlMatrix_0(long var0, long var2);

    private static native void set_errorCovPost_0(long var0, long var2);

    private static native void set_errorCovPre_0(long var0, long var2);

    private static native void set_gain_0(long var0, long var2);

    private static native void set_measurementMatrix_0(long var0, long var2);

    private static native void set_measurementNoiseCov_0(long var0, long var2);

    private static native void set_processNoiseCov_0(long var0, long var2);

    private static native void set_statePost_0(long var0, long var2);

    private static native void set_statePre_0(long var0, long var2);

    private static native void set_transitionMatrix_0(long var0, long var2);

    public Mat b(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = KalmanFilter.correct_0(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public long c() {
        return this.a;
    }

    public Mat d() {
        long l10 = KalmanFilter.get_controlMatrix_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat e() {
        long l10 = KalmanFilter.get_errorCovPost_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat f() {
        long l10 = KalmanFilter.get_errorCovPre_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void finalize() {
        KalmanFilter.delete(this.a);
    }

    public Mat g() {
        long l10 = KalmanFilter.get_gain_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat h() {
        long l10 = KalmanFilter.get_measurementMatrix_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat i() {
        long l10 = KalmanFilter.get_measurementNoiseCov_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat j() {
        long l10 = KalmanFilter.get_processNoiseCov_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat k() {
        long l10 = KalmanFilter.get_statePost_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat l() {
        long l10 = KalmanFilter.get_statePre_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat m() {
        long l10 = KalmanFilter.get_transitionMatrix_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat n() {
        long l10 = KalmanFilter.predict_1(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat o(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = KalmanFilter.predict_0(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public void p(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_controlMatrix_0(l10, l11);
    }

    public void q(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_errorCovPost_0(l10, l11);
    }

    public void r(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_errorCovPre_0(l10, l11);
    }

    public void s(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_gain_0(l10, l11);
    }

    public void t(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_measurementMatrix_0(l10, l11);
    }

    public void u(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_measurementNoiseCov_0(l10, l11);
    }

    public void v(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_processNoiseCov_0(l10, l11);
    }

    public void w(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_statePost_0(l10, l11);
    }

    public void x(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_statePre_0(l10, l11);
    }

    public void y(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        KalmanFilter.set_transitionMatrix_0(l10, l11);
    }
}

