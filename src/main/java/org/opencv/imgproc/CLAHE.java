/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import i.f.c.z;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class CLAHE
extends Algorithm {
    public CLAHE(long l10) {
        super(l10);
    }

    private static native void apply_0(long var0, long var2, long var4);

    private static native void collectGarbage_0(long var0);

    private static native void delete(long var0);

    public static CLAHE g(long l10) {
        CLAHE cLAHE = new CLAHE(l10);
        return cLAHE;
    }

    private static native double getClipLimit_0(long var0);

    private static native double[] getTilesGridSize_0(long var0);

    private static native void setClipLimit_0(long var0, double var2);

    private static native void setTilesGridSize_0(long var0, double var2, double var4);

    public void finalize() {
        CLAHE.delete(this.a);
    }

    public void h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        CLAHE.apply_0(l10, l11, l12);
    }

    public void i() {
        CLAHE.collectGarbage_0(this.a);
    }

    public double j() {
        return CLAHE.getClipLimit_0(this.a);
    }

    public z k() {
        double[] dArray = CLAHE.getTilesGridSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public void l(double d10) {
        CLAHE.setClipLimit_0(this.a, d10);
    }

    public void m(z z10) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        CLAHE.setTilesGridSize_0(l10, d10, d11);
    }
}

