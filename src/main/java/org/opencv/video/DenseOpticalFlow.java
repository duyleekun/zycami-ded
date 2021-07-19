/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class DenseOpticalFlow
extends Algorithm {
    public DenseOpticalFlow(long l10) {
        super(l10);
    }

    private static native void calc_0(long var0, long var2, long var4, long var6);

    private static native void collectGarbage_0(long var0);

    private static native void delete(long var0);

    public static DenseOpticalFlow g(long l10) {
        DenseOpticalFlow denseOpticalFlow = new DenseOpticalFlow(l10);
        return denseOpticalFlow;
    }

    public void finalize() {
        DenseOpticalFlow.delete(this.a);
    }

    public void h(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        DenseOpticalFlow.calc_0(l10, l11, l12, l13);
    }

    public void i() {
        DenseOpticalFlow.collectGarbage_0(this.a);
    }
}

