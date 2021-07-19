/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class BackgroundSubtractor
extends Algorithm {
    public BackgroundSubtractor(long l10) {
        super(l10);
    }

    private static native void apply_0(long var0, long var2, long var4, double var6);

    private static native void apply_1(long var0, long var2, long var4);

    private static native void delete(long var0);

    public static BackgroundSubtractor g(long l10) {
        BackgroundSubtractor backgroundSubtractor = new BackgroundSubtractor(l10);
        return backgroundSubtractor;
    }

    private static native void getBackgroundImage_0(long var0, long var2);

    public void finalize() {
        BackgroundSubtractor.delete(this.a);
    }

    public void h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        BackgroundSubtractor.apply_1(l10, l11, l12);
    }

    public void i(Mat mat, Mat mat2, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        BackgroundSubtractor.apply_0(l10, l11, l12, d10);
    }

    public void j(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        BackgroundSubtractor.getBackgroundImage_0(l10, l11);
    }
}

