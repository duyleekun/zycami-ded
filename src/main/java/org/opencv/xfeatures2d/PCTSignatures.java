/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import i.f.c.i;
import i.f.c.k;
import i.f.c.m;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class PCTSignatures
extends Algorithm {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 6;

    public PCTSignatures(long l10) {
        super(l10);
    }

    private static native void computeSignature_0(long var0, long var2, long var4);

    private static native void computeSignatures_0(long var0, long var2, long var4);

    private static native long create_0(int var0, int var1, int var2);

    private static native long create_1(int var0, int var1);

    private static native long create_2(int var0);

    private static native long create_3();

    private static native long create_4(long var0, int var2);

    private static native long create_5(long var0, long var2);

    private static native void delete(long var0);

    private static native void drawSignature_0(long var0, long var2, long var4, float var6, int var7);

    private static native void drawSignature_1(long var0, long var2, long var4, float var6);

    private static native void drawSignature_2(long var0, long var2, long var4);

    public static PCTSignatures g(long l10) {
        PCTSignatures pCTSignatures = new PCTSignatures(l10);
        return pCTSignatures;
    }

    private static native void generateInitPoints_0(long var0, int var2, int var3);

    private static native int getClusterMinSize_0(long var0);

    private static native int getDistanceFunction_0(long var0);

    private static native float getDropThreshold_0(long var0);

    private static native int getGrayscaleBits_0(long var0);

    private static native int getInitSeedCount_0(long var0);

    private static native long getInitSeedIndexes_0(long var0);

    private static native int getIterationCount_0(long var0);

    private static native float getJoiningDistance_0(long var0);

    private static native int getMaxClustersCount_0(long var0);

    private static native int getSampleCount_0(long var0);

    private static native long getSamplingPoints_0(long var0);

    private static native float getWeightA_0(long var0);

    private static native float getWeightB_0(long var0);

    private static native float getWeightContrast_0(long var0);

    private static native float getWeightEntropy_0(long var0);

    private static native float getWeightL_0(long var0);

    private static native float getWeightX_0(long var0);

    private static native float getWeightY_0(long var0);

    private static native int getWindowRadius_0(long var0);

    public static PCTSignatures j() {
        return PCTSignatures.g(PCTSignatures.create_3());
    }

    public static PCTSignatures k(int n10) {
        return PCTSignatures.g(PCTSignatures.create_2(n10));
    }

    public static PCTSignatures l(int n10, int n11) {
        return PCTSignatures.g(PCTSignatures.create_1(n10, n11));
    }

    public static PCTSignatures m(int n10, int n11, int n12) {
        return PCTSignatures.g(PCTSignatures.create_0(n10, n11, n12));
    }

    public static PCTSignatures n(m m10, int n10) {
        return PCTSignatures.g(PCTSignatures.create_4(m10.a, n10));
    }

    public static PCTSignatures o(m m10, k k10) {
        long l10 = m10.a;
        long l11 = k10.a;
        return PCTSignatures.g(PCTSignatures.create_5(l10, l11));
    }

    public static void p(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        PCTSignatures.drawSignature_2(l10, l11, l12);
    }

    public static void q(Mat mat, Mat mat2, Mat mat3, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        PCTSignatures.drawSignature_1(l10, l11, l12, f10);
    }

    public static void r(Mat mat, Mat mat2, Mat mat3, float f10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        PCTSignatures.drawSignature_0(l10, l11, l12, f10, n10);
    }

    public static void s(m m10, int n10, int n11) {
        PCTSignatures.generateInitPoints_0(m10.a, n10, n11);
    }

    private static native void setClusterMinSize_0(long var0, int var2);

    private static native void setDistanceFunction_0(long var0, int var2);

    private static native void setDropThreshold_0(long var0, float var2);

    private static native void setGrayscaleBits_0(long var0, int var2);

    private static native void setInitSeedIndexes_0(long var0, long var2);

    private static native void setIterationCount_0(long var0, int var2);

    private static native void setJoiningDistance_0(long var0, float var2);

    private static native void setMaxClustersCount_0(long var0, int var2);

    private static native void setSamplingPoints_0(long var0, long var2);

    private static native void setTranslation_0(long var0, int var2, float var3);

    private static native void setTranslations_0(long var0, long var2);

    private static native void setWeightA_0(long var0, float var2);

    private static native void setWeightB_0(long var0, float var2);

    private static native void setWeightContrast_0(long var0, float var2);

    private static native void setWeightEntropy_0(long var0, float var2);

    private static native void setWeightL_0(long var0, float var2);

    private static native void setWeightX_0(long var0, float var2);

    private static native void setWeightY_0(long var0, float var2);

    private static native void setWeight_0(long var0, int var2, float var3);

    private static native void setWeights_0(long var0, long var2);

    private static native void setWindowRadius_0(long var0, int var2);

    public float A() {
        return PCTSignatures.getJoiningDistance_0(this.a);
    }

    public int B() {
        return PCTSignatures.getMaxClustersCount_0(this.a);
    }

    public int C() {
        return PCTSignatures.getSampleCount_0(this.a);
    }

    public m D() {
        return i.f.c.m.Y0(PCTSignatures.getSamplingPoints_0(this.a));
    }

    public float E() {
        return PCTSignatures.getWeightA_0(this.a);
    }

    public float F() {
        return PCTSignatures.getWeightB_0(this.a);
    }

    public float G() {
        return PCTSignatures.getWeightContrast_0(this.a);
    }

    public float H() {
        return PCTSignatures.getWeightEntropy_0(this.a);
    }

    public float I() {
        return PCTSignatures.getWeightL_0(this.a);
    }

    public float J() {
        return PCTSignatures.getWeightX_0(this.a);
    }

    public float K() {
        return PCTSignatures.getWeightY_0(this.a);
    }

    public int L() {
        return PCTSignatures.getWindowRadius_0(this.a);
    }

    public void M(int n10) {
        PCTSignatures.setClusterMinSize_0(this.a, n10);
    }

    public void N(int n10) {
        PCTSignatures.setDistanceFunction_0(this.a, n10);
    }

    public void O(float f10) {
        PCTSignatures.setDropThreshold_0(this.a, f10);
    }

    public void P(int n10) {
        PCTSignatures.setGrayscaleBits_0(this.a, n10);
    }

    public void Q(k k10) {
        long l10 = this.a;
        long l11 = k10.a;
        PCTSignatures.setInitSeedIndexes_0(l10, l11);
    }

    public void R(int n10) {
        PCTSignatures.setIterationCount_0(this.a, n10);
    }

    public void S(float f10) {
        PCTSignatures.setJoiningDistance_0(this.a, f10);
    }

    public void T(int n10) {
        PCTSignatures.setMaxClustersCount_0(this.a, n10);
    }

    public void U(m m10) {
        long l10 = this.a;
        long l11 = m10.a;
        PCTSignatures.setSamplingPoints_0(l10, l11);
    }

    public void V(int n10, float f10) {
        PCTSignatures.setTranslation_0(this.a, n10, f10);
    }

    public void W(i i10) {
        long l10 = this.a;
        long l11 = i10.a;
        PCTSignatures.setTranslations_0(l10, l11);
    }

    public void X(int n10, float f10) {
        PCTSignatures.setWeight_0(this.a, n10, f10);
    }

    public void Y(float f10) {
        PCTSignatures.setWeightA_0(this.a, f10);
    }

    public void Z(float f10) {
        PCTSignatures.setWeightB_0(this.a, f10);
    }

    public void a0(float f10) {
        PCTSignatures.setWeightContrast_0(this.a, f10);
    }

    public void b0(float f10) {
        PCTSignatures.setWeightEntropy_0(this.a, f10);
    }

    public void c0(float f10) {
        PCTSignatures.setWeightL_0(this.a, f10);
    }

    public void d0(float f10) {
        PCTSignatures.setWeightX_0(this.a, f10);
    }

    public void e0(float f10) {
        PCTSignatures.setWeightY_0(this.a, f10);
    }

    public void f0(i i10) {
        long l10 = this.a;
        long l11 = i10.a;
        PCTSignatures.setWeights_0(l10, l11);
    }

    public void finalize() {
        PCTSignatures.delete(this.a);
    }

    public void g0(int n10) {
        PCTSignatures.setWindowRadius_0(this.a, n10);
    }

    public void h(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        PCTSignatures.computeSignature_0(l10, l11, l12);
    }

    public void i(List object, List object2) {
        object = i.f.h.a.A((List)object);
        object2 = i.f.h.a.A((List)object2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = ((Mat)object2).a;
        PCTSignatures.computeSignatures_0(l10, l11, l12);
    }

    public int t() {
        return PCTSignatures.getClusterMinSize_0(this.a);
    }

    public int u() {
        return PCTSignatures.getDistanceFunction_0(this.a);
    }

    public float v() {
        return PCTSignatures.getDropThreshold_0(this.a);
    }

    public int w() {
        return PCTSignatures.getGrayscaleBits_0(this.a);
    }

    public int x() {
        return PCTSignatures.getInitSeedCount_0(this.a);
    }

    public k y() {
        return i.f.c.k.Y0(PCTSignatures.getInitSeedIndexes_0(this.a));
    }

    public int z() {
        return PCTSignatures.getIterationCount_0(this.a);
    }
}

