/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class LogisticRegression
extends StatModel {
    public static final int f = 255;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 0;
    public static final int j = 1;

    public LogisticRegression(long l10) {
        super(l10);
    }

    public static LogisticRegression A(String string2) {
        return LogisticRegression.r(LogisticRegression.load_1(string2));
    }

    public static LogisticRegression B(String string2, String string3) {
        return LogisticRegression.r(LogisticRegression.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native int getIterations_0(long var0);

    private static native double getLearningRate_0(long var0);

    private static native int getMiniBatchSize_0(long var0);

    private static native int getRegularization_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native int getTrainMethod_0(long var0);

    private static native long get_learnt_thetas_0(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    private static native float predict_0(long var0, long var2, long var4, int var6);

    private static native float predict_1(long var0, long var2, long var4);

    private static native float predict_2(long var0, long var2);

    public static LogisticRegression r(long l10) {
        LogisticRegression logisticRegression = new LogisticRegression(l10);
        return logisticRegression;
    }

    public static LogisticRegression s() {
        return LogisticRegression.r(LogisticRegression.create_0());
    }

    private static native void setIterations_0(long var0, int var2);

    private static native void setLearningRate_0(long var0, double var2);

    private static native void setMiniBatchSize_0(long var0, int var2);

    private static native void setRegularization_0(long var0, int var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    private static native void setTrainMethod_0(long var0, int var2);

    public void C(int n10) {
        LogisticRegression.setIterations_0(this.a, n10);
    }

    public void D(double d10) {
        LogisticRegression.setLearningRate_0(this.a, d10);
    }

    public void E(int n10) {
        LogisticRegression.setMiniBatchSize_0(this.a, n10);
    }

    public void F(int n10) {
        LogisticRegression.setRegularization_0(this.a, n10);
    }

    public void G(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        LogisticRegression.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void H(int n10) {
        LogisticRegression.setTrainMethod_0(this.a, n10);
    }

    public void finalize() {
        LogisticRegression.delete(this.a);
    }

    public float l(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return LogisticRegression.predict_2(l10, l11);
    }

    public float m(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return LogisticRegression.predict_1(l10, l11, l12);
    }

    public float n(Mat mat, Mat mat2, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return LogisticRegression.predict_0(l10, l11, l12, n10);
    }

    public int t() {
        return LogisticRegression.getIterations_0(this.a);
    }

    public double u() {
        return LogisticRegression.getLearningRate_0(this.a);
    }

    public int v() {
        return LogisticRegression.getMiniBatchSize_0(this.a);
    }

    public int w() {
        return LogisticRegression.getRegularization_0(this.a);
    }

    public a0 x() {
        double[] dArray = LogisticRegression.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public int y() {
        return LogisticRegression.getTrainMethod_0(this.a);
    }

    public Mat z() {
        long l10 = LogisticRegression.get_learnt_thetas_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }
}

