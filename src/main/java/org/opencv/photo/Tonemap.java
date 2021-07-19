/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class Tonemap
extends Algorithm {
    public Tonemap(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static Tonemap g(long l10) {
        Tonemap tonemap = new Tonemap(l10);
        return tonemap;
    }

    private static native float getGamma_0(long var0);

    private static native void process_0(long var0, long var2, long var4);

    private static native void setGamma_0(long var0, float var2);

    public void finalize() {
        Tonemap.delete(this.a);
    }

    public float h() {
        return Tonemap.getGamma_0(this.a);
    }

    public void i(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        Tonemap.process_0(l10, l11, l12);
    }

    public void j(float f10) {
        Tonemap.setGamma_0(this.a, f10);
    }
}

