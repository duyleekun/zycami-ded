/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.ml.TrainData;

public class StatModel
extends Algorithm {
    public static final int b = 1;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 4;

    public StatModel(long l10) {
        super(l10);
    }

    private static native float calcError_0(long var0, long var2, boolean var4, long var5);

    private static native void delete(long var0);

    private static native boolean empty_0(long var0);

    public static StatModel g(long l10) {
        StatModel statModel = new StatModel(l10);
        return statModel;
    }

    private static native int getVarCount_0(long var0);

    private static native boolean isClassifier_0(long var0);

    private static native boolean isTrained_0(long var0);

    private static native float predict_0(long var0, long var2, long var4, int var6);

    private static native float predict_1(long var0, long var2, long var4);

    private static native float predict_2(long var0, long var2);

    private static native boolean train_0(long var0, long var2, int var4, long var5);

    private static native boolean train_1(long var0, long var2, int var4);

    private static native boolean train_2(long var0, long var2);

    public boolean c() {
        return StatModel.empty_0(this.a);
    }

    public void finalize() {
        StatModel.delete(this.a);
    }

    public float h(TrainData trainData, boolean bl2, Mat mat) {
        long l10 = this.a;
        long l11 = trainData.t();
        long l12 = mat.a;
        return StatModel.calcError_0(l10, l11, bl2, l12);
    }

    public int i() {
        return StatModel.getVarCount_0(this.a);
    }

    public boolean j() {
        return StatModel.isClassifier_0(this.a);
    }

    public boolean k() {
        return StatModel.isTrained_0(this.a);
    }

    public float l(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return StatModel.predict_2(l10, l11);
    }

    public float m(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return StatModel.predict_1(l10, l11, l12);
    }

    public float n(Mat mat, Mat mat2, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return StatModel.predict_0(l10, l11, l12, n10);
    }

    public boolean o(Mat mat, int n10, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return StatModel.train_0(l10, l11, n10, l12);
    }

    public boolean p(TrainData trainData) {
        long l10 = this.a;
        long l11 = trainData.t();
        return StatModel.train_2(l10, l11);
    }

    public boolean q(TrainData trainData, int n10) {
        long l10 = this.a;
        long l11 = trainData.t();
        return StatModel.train_1(l10, l11, n10);
    }
}

