/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class SVMSGD
extends StatModel {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 0;
    public static final int i = 1;

    public SVMSGD(long l10) {
        super(l10);
    }

    public static SVMSGD B(String string2) {
        return SVMSGD.r(SVMSGD.load_1(string2));
    }

    public static SVMSGD C(String string2, String string3) {
        return SVMSGD.r(SVMSGD.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native float getInitialStepSize_0(long var0);

    private static native float getMarginRegularization_0(long var0);

    private static native int getMarginType_0(long var0);

    private static native float getShift_0(long var0);

    private static native float getStepDecreasingPower_0(long var0);

    private static native int getSvmsgdType_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native long getWeights_0(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    public static SVMSGD r(long l10) {
        SVMSGD sVMSGD = new SVMSGD(l10);
        return sVMSGD;
    }

    public static SVMSGD s() {
        return SVMSGD.r(SVMSGD.create_0());
    }

    private static native void setInitialStepSize_0(long var0, float var2);

    private static native void setMarginRegularization_0(long var0, float var2);

    private static native void setMarginType_0(long var0, int var2);

    private static native void setOptimalParameters_0(long var0, int var2, int var3);

    private static native void setOptimalParameters_1(long var0, int var2);

    private static native void setOptimalParameters_2(long var0);

    private static native void setStepDecreasingPower_0(long var0, float var2);

    private static native void setSvmsgdType_0(long var0, int var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    public Mat A() {
        long l10 = SVMSGD.getWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void D(float f10) {
        SVMSGD.setInitialStepSize_0(this.a, f10);
    }

    public void E(float f10) {
        SVMSGD.setMarginRegularization_0(this.a, f10);
    }

    public void F(int n10) {
        SVMSGD.setMarginType_0(this.a, n10);
    }

    public void G() {
        SVMSGD.setOptimalParameters_2(this.a);
    }

    public void H(int n10) {
        SVMSGD.setOptimalParameters_1(this.a, n10);
    }

    public void I(int n10, int n11) {
        SVMSGD.setOptimalParameters_0(this.a, n10, n11);
    }

    public void J(float f10) {
        SVMSGD.setStepDecreasingPower_0(this.a, f10);
    }

    public void K(int n10) {
        SVMSGD.setSvmsgdType_0(this.a, n10);
    }

    public void L(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        SVMSGD.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void finalize() {
        SVMSGD.delete(this.a);
    }

    public float t() {
        return SVMSGD.getInitialStepSize_0(this.a);
    }

    public float u() {
        return SVMSGD.getMarginRegularization_0(this.a);
    }

    public int v() {
        return SVMSGD.getMarginType_0(this.a);
    }

    public float w() {
        return SVMSGD.getShift_0(this.a);
    }

    public float x() {
        return SVMSGD.getStepDecreasingPower_0(this.a);
    }

    public int y() {
        return SVMSGD.getSvmsgdType_0(this.a);
    }

    public a0 z() {
        double[] dArray = SVMSGD.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }
}

