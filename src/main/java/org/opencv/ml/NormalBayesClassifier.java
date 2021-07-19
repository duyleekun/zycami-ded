/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class NormalBayesClassifier
extends StatModel {
    public NormalBayesClassifier(long l10) {
        super(l10);
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    private static native float predictProb_0(long var0, long var2, long var4, long var6, int var8);

    private static native float predictProb_1(long var0, long var2, long var4, long var6);

    public static NormalBayesClassifier r(long l10) {
        NormalBayesClassifier normalBayesClassifier = new NormalBayesClassifier(l10);
        return normalBayesClassifier;
    }

    public static NormalBayesClassifier s() {
        return NormalBayesClassifier.r(NormalBayesClassifier.create_0());
    }

    public static NormalBayesClassifier t(String string2) {
        return NormalBayesClassifier.r(NormalBayesClassifier.load_1(string2));
    }

    public static NormalBayesClassifier u(String string2, String string3) {
        return NormalBayesClassifier.r(NormalBayesClassifier.load_0(string2, string3));
    }

    public void finalize() {
        NormalBayesClassifier.delete(this.a);
    }

    public float v(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return NormalBayesClassifier.predictProb_1(l10, l11, l12, l13);
    }

    public float w(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return NormalBayesClassifier.predictProb_0(l10, l11, l12, l13, n10);
    }
}

