/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.ml.ParamGrid;
import org.opencv.ml.StatModel;

public class SVM
extends StatModel {
    public static final int f = 255;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 100;
    public static final int n = 101;
    public static final int o = 102;
    public static final int p = 103;
    public static final int q = 104;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    public static final int w = 5;

    public SVM(long l10) {
        super(l10);
    }

    public static SVM H(String string2) {
        return SVM.r(SVM.load_0(string2));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native double getC_0(long var0);

    private static native long getClassWeights_0(long var0);

    private static native double getCoef0_0(long var0);

    private static native double getDecisionFunction_0(long var0, int var2, long var3, long var5);

    private static native long getDefaultGridPtr_0(int var0);

    private static native double getDegree_0(long var0);

    private static native double getGamma_0(long var0);

    private static native int getKernelType_0(long var0);

    private static native double getNu_0(long var0);

    private static native double getP_0(long var0);

    private static native long getSupportVectors_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native int getType_0(long var0);

    private static native long getUncompressedSupportVectors_0(long var0);

    private static native long load_0(String var0);

    public static SVM r(long l10) {
        SVM sVM = new SVM(l10);
        return sVM;
    }

    public static SVM s() {
        return SVM.r(SVM.create_0());
    }

    private static native void setC_0(long var0, double var2);

    private static native void setClassWeights_0(long var0, long var2);

    private static native void setCoef0_0(long var0, double var2);

    private static native void setDegree_0(long var0, double var2);

    private static native void setGamma_0(long var0, double var2);

    private static native void setKernel_0(long var0, int var2);

    private static native void setNu_0(long var0, double var2);

    private static native void setP_0(long var0, double var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    private static native void setType_0(long var0, int var2);

    private static native boolean trainAuto_0(long var0, long var2, int var4, long var5, int var7, long var8, long var10, long var12, long var14, long var16, long var18, boolean var20);

    private static native boolean trainAuto_1(long var0, long var2, int var4, long var5, int var7, long var8, long var10, long var12, long var14, long var16, long var18);

    private static native boolean trainAuto_2(long var0, long var2, int var4, long var5, int var7, long var8, long var10, long var12, long var14, long var16);

    private static native boolean trainAuto_3(long var0, long var2, int var4, long var5, int var7, long var8, long var10, long var12, long var14);

    private static native boolean trainAuto_4(long var0, long var2, int var4, long var5, int var7, long var8, long var10, long var12);

    private static native boolean trainAuto_5(long var0, long var2, int var4, long var5, int var7, long var8, long var10);

    private static native boolean trainAuto_6(long var0, long var2, int var4, long var5, int var7, long var8);

    private static native boolean trainAuto_7(long var0, long var2, int var4, long var5, int var7);

    private static native boolean trainAuto_8(long var0, long var2, int var4, long var5);

    public static ParamGrid x(int n10) {
        return ParamGrid.a(SVM.getDefaultGridPtr_0(n10));
    }

    public int A() {
        return SVM.getKernelType_0(this.a);
    }

    public double B() {
        return SVM.getNu_0(this.a);
    }

    public double C() {
        return SVM.getP_0(this.a);
    }

    public Mat D() {
        long l10 = SVM.getSupportVectors_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public a0 E() {
        double[] dArray = SVM.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public int F() {
        return SVM.getType_0(this.a);
    }

    public Mat G() {
        long l10 = SVM.getUncompressedSupportVectors_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void I(double d10) {
        SVM.setC_0(this.a, d10);
    }

    public void J(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        SVM.setClassWeights_0(l10, l11);
    }

    public void K(double d10) {
        SVM.setCoef0_0(this.a, d10);
    }

    public void L(double d10) {
        SVM.setDegree_0(this.a, d10);
    }

    public void M(double d10) {
        SVM.setGamma_0(this.a, d10);
    }

    public void N(int n10) {
        SVM.setKernel_0(this.a, n10);
    }

    public void O(double d10) {
        SVM.setNu_0(this.a, d10);
    }

    public void P(double d10) {
        SVM.setP_0(this.a, d10);
    }

    public void Q(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        SVM.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void R(int n10) {
        SVM.setType_0(this.a, n10);
    }

    public boolean S(Mat mat, int n10, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return SVM.trainAuto_8(l10, l11, n10, l12);
    }

    public boolean T(Mat mat, int n10, Mat mat2, int n11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return SVM.trainAuto_7(l10, l11, n10, l12, n11);
    }

    public boolean U(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        return SVM.trainAuto_6(l10, l11, n10, l12, n11, l13);
    }

    public boolean V(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        return SVM.trainAuto_5(l10, l11, n10, l12, n11, l13, l14);
    }

    public boolean W(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2, ParamGrid paramGrid3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        long l15 = paramGrid3.f();
        return SVM.trainAuto_4(l10, l11, n10, l12, n11, l13, l14, l15);
    }

    public boolean X(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2, ParamGrid paramGrid3, ParamGrid paramGrid4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        long l15 = paramGrid3.f();
        long l16 = paramGrid4.f();
        return SVM.trainAuto_3(l10, l11, n10, l12, n11, l13, l14, l15, l16);
    }

    public boolean Y(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2, ParamGrid paramGrid3, ParamGrid paramGrid4, ParamGrid paramGrid5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        long l15 = paramGrid3.f();
        long l16 = paramGrid4.f();
        long l17 = paramGrid5.f();
        return SVM.trainAuto_2(l10, l11, n10, l12, n11, l13, l14, l15, l16, l17);
    }

    public boolean Z(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2, ParamGrid paramGrid3, ParamGrid paramGrid4, ParamGrid paramGrid5, ParamGrid paramGrid6) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        long l15 = paramGrid3.f();
        long l16 = paramGrid4.f();
        long l17 = paramGrid5.f();
        long l18 = paramGrid6.f();
        return SVM.trainAuto_1(l10, l11, n10, l12, n11, l13, l14, l15, l16, l17, l18);
    }

    public boolean a0(Mat mat, int n10, Mat mat2, int n11, ParamGrid paramGrid, ParamGrid paramGrid2, ParamGrid paramGrid3, ParamGrid paramGrid4, ParamGrid paramGrid5, ParamGrid paramGrid6, boolean bl2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = paramGrid.f();
        long l14 = paramGrid2.f();
        long l15 = paramGrid3.f();
        long l16 = paramGrid4.f();
        long l17 = paramGrid5.f();
        long l18 = paramGrid6.f();
        return SVM.trainAuto_0(l10, l11, n10, l12, n11, l13, l14, l15, l16, l17, l18, bl2);
    }

    public void finalize() {
        SVM.delete(this.a);
    }

    public double t() {
        return SVM.getC_0(this.a);
    }

    public Mat u() {
        long l10 = SVM.getClassWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public double v() {
        return SVM.getCoef0_0(this.a);
    }

    public double w(int n10, Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return SVM.getDecisionFunction_0(l10, n10, l11, l12);
    }

    public double y() {
        return SVM.getDegree_0(this.a);
    }

    public double z() {
        return SVM.getGamma_0(this.a);
    }
}

