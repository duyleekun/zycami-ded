/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class SparseOpticalFlow
extends Algorithm {
    public SparseOpticalFlow(long l10) {
        super(l10);
    }

    private static native void calc_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native void calc_1(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void delete(long var0);

    public static SparseOpticalFlow g(long l10) {
        SparseOpticalFlow sparseOpticalFlow = new SparseOpticalFlow(l10);
        return sparseOpticalFlow;
    }

    public void finalize() {
        SparseOpticalFlow.delete(this.a);
    }

    public void h(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        SparseOpticalFlow.calc_1(l10, l11, l12, l13, l14, l15);
    }

    public void i(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        long l16 = mat6.a;
        SparseOpticalFlow.calc_0(l10, l11, l12, l13, l14, l15, l16);
    }
}

