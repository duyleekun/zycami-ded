/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class ANN_MLP
extends StatModel {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 4;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;

    public ANN_MLP(long l10) {
        super(l10);
    }

    public static ANN_MLP I(String string2) {
        return ANN_MLP.r(ANN_MLP.load_0(string2));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native double getAnnealCoolingRatio_0(long var0);

    private static native double getAnnealFinalT_0(long var0);

    private static native double getAnnealInitialT_0(long var0);

    private static native int getAnnealItePerStep_0(long var0);

    private static native double getBackpropMomentumScale_0(long var0);

    private static native double getBackpropWeightScale_0(long var0);

    private static native long getLayerSizes_0(long var0);

    private static native double getRpropDW0_0(long var0);

    private static native double getRpropDWMax_0(long var0);

    private static native double getRpropDWMin_0(long var0);

    private static native double getRpropDWMinus_0(long var0);

    private static native double getRpropDWPlus_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native int getTrainMethod_0(long var0);

    private static native long getWeights_0(long var0, int var2);

    private static native long load_0(String var0);

    public static ANN_MLP r(long l10) {
        ANN_MLP aNN_MLP = new ANN_MLP(l10);
        return aNN_MLP;
    }

    public static ANN_MLP s() {
        return ANN_MLP.r(ANN_MLP.create_0());
    }

    private static native void setActivationFunction_0(long var0, int var2, double var3, double var5);

    private static native void setActivationFunction_1(long var0, int var2, double var3);

    private static native void setActivationFunction_2(long var0, int var2);

    private static native void setAnnealCoolingRatio_0(long var0, double var2);

    private static native void setAnnealFinalT_0(long var0, double var2);

    private static native void setAnnealInitialT_0(long var0, double var2);

    private static native void setAnnealItePerStep_0(long var0, int var2);

    private static native void setBackpropMomentumScale_0(long var0, double var2);

    private static native void setBackpropWeightScale_0(long var0, double var2);

    private static native void setLayerSizes_0(long var0, long var2);

    private static native void setRpropDW0_0(long var0, double var2);

    private static native void setRpropDWMax_0(long var0, double var2);

    private static native void setRpropDWMin_0(long var0, double var2);

    private static native void setRpropDWMinus_0(long var0, double var2);

    private static native void setRpropDWPlus_0(long var0, double var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    private static native void setTrainMethod_0(long var0, int var2, double var3, double var5);

    private static native void setTrainMethod_1(long var0, int var2, double var3);

    private static native void setTrainMethod_2(long var0, int var2);

    public double A() {
        return ANN_MLP.getRpropDW0_0(this.a);
    }

    public double B() {
        return ANN_MLP.getRpropDWMax_0(this.a);
    }

    public double C() {
        return ANN_MLP.getRpropDWMin_0(this.a);
    }

    public double D() {
        return ANN_MLP.getRpropDWMinus_0(this.a);
    }

    public double E() {
        return ANN_MLP.getRpropDWPlus_0(this.a);
    }

    public a0 F() {
        double[] dArray = ANN_MLP.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public int G() {
        return ANN_MLP.getTrainMethod_0(this.a);
    }

    public Mat H(int n10) {
        long l10 = ANN_MLP.getWeights_0(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void J(int n10) {
        ANN_MLP.setActivationFunction_2(this.a, n10);
    }

    public void K(int n10, double d10) {
        ANN_MLP.setActivationFunction_1(this.a, n10, d10);
    }

    public void L(int n10, double d10, double d11) {
        ANN_MLP.setActivationFunction_0(this.a, n10, d10, d11);
    }

    public void M(double d10) {
        ANN_MLP.setAnnealCoolingRatio_0(this.a, d10);
    }

    public void N(double d10) {
        ANN_MLP.setAnnealFinalT_0(this.a, d10);
    }

    public void O(double d10) {
        ANN_MLP.setAnnealInitialT_0(this.a, d10);
    }

    public void P(int n10) {
        ANN_MLP.setAnnealItePerStep_0(this.a, n10);
    }

    public void Q(double d10) {
        ANN_MLP.setBackpropMomentumScale_0(this.a, d10);
    }

    public void R(double d10) {
        ANN_MLP.setBackpropWeightScale_0(this.a, d10);
    }

    public void S(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        ANN_MLP.setLayerSizes_0(l10, l11);
    }

    public void T(double d10) {
        ANN_MLP.setRpropDW0_0(this.a, d10);
    }

    public void U(double d10) {
        ANN_MLP.setRpropDWMax_0(this.a, d10);
    }

    public void V(double d10) {
        ANN_MLP.setRpropDWMin_0(this.a, d10);
    }

    public void W(double d10) {
        ANN_MLP.setRpropDWMinus_0(this.a, d10);
    }

    public void X(double d10) {
        ANN_MLP.setRpropDWPlus_0(this.a, d10);
    }

    public void Y(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        ANN_MLP.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void Z(int n10) {
        ANN_MLP.setTrainMethod_2(this.a, n10);
    }

    public void a0(int n10, double d10) {
        ANN_MLP.setTrainMethod_1(this.a, n10, d10);
    }

    public void b0(int n10, double d10, double d11) {
        ANN_MLP.setTrainMethod_0(this.a, n10, d10, d11);
    }

    public void finalize() {
        ANN_MLP.delete(this.a);
    }

    public double t() {
        return ANN_MLP.getAnnealCoolingRatio_0(this.a);
    }

    public double u() {
        return ANN_MLP.getAnnealFinalT_0(this.a);
    }

    public double v() {
        return ANN_MLP.getAnnealInitialT_0(this.a);
    }

    public int w() {
        return ANN_MLP.getAnnealItePerStep_0(this.a);
    }

    public double x() {
        return ANN_MLP.getBackpropMomentumScale_0(this.a);
    }

    public double y() {
        return ANN_MLP.getBackpropWeightScale_0(this.a);
    }

    public Mat z() {
        long l10 = ANN_MLP.getLayerSizes_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }
}

