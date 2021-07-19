/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import i.f.c.i;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class PCTSignaturesSQFD
extends Algorithm {
    public PCTSignaturesSQFD(long l10) {
        super(l10);
    }

    private static native float computeQuadraticFormDistance_0(long var0, long var2, long var4);

    private static native void computeQuadraticFormDistances_0(long var0, long var2, long var4, long var6);

    private static native long create_0(int var0, int var1, float var2);

    private static native long create_1(int var0, int var1);

    private static native long create_2(int var0);

    private static native long create_3();

    private static native void delete(long var0);

    public static PCTSignaturesSQFD g(long l10) {
        PCTSignaturesSQFD pCTSignaturesSQFD = new PCTSignaturesSQFD(l10);
        return pCTSignaturesSQFD;
    }

    public static PCTSignaturesSQFD j() {
        return PCTSignaturesSQFD.g(PCTSignaturesSQFD.create_3());
    }

    public static PCTSignaturesSQFD k(int n10) {
        return PCTSignaturesSQFD.g(PCTSignaturesSQFD.create_2(n10));
    }

    public static PCTSignaturesSQFD l(int n10, int n11) {
        return PCTSignaturesSQFD.g(PCTSignaturesSQFD.create_1(n10, n11));
    }

    public static PCTSignaturesSQFD m(int n10, int n11, float f10) {
        return PCTSignaturesSQFD.g(PCTSignaturesSQFD.create_0(n10, n11, f10));
    }

    public void finalize() {
        PCTSignaturesSQFD.delete(this.a);
    }

    public float h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return PCTSignaturesSQFD.computeQuadraticFormDistance_0(l10, l11, l12);
    }

    public void i(Mat mat, List object, i i10) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = ((Mat)object).a;
        long l13 = i10.a;
        PCTSignaturesSQFD.computeQuadraticFormDistances_0(l10, l11, l12, l13);
    }
}

