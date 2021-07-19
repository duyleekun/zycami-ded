/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import java.util.List;
import org.opencv.core.Mat;

public class TrainData {
    public final long a;

    public TrainData(long l10) {
        this.a = l10;
    }

    public static Mat A(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = TrainData.getSubMatrix_0(l10, l11, n10);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static Mat B(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = TrainData.getSubVector_0(l10, l11);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static TrainData a(long l10) {
        TrainData trainData = new TrainData(l10);
        return trainData;
    }

    public static TrainData b(Mat mat, int n10, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return TrainData.a(TrainData.create_4(l10, n10, l11));
    }

    public static TrainData c(Mat mat, int n10, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return TrainData.a(TrainData.create_3(l10, n10, l11, l12));
    }

    private static native long create_0(long var0, int var2, long var3, long var5, long var7, long var9, long var11);

    private static native long create_1(long var0, int var2, long var3, long var5, long var7, long var9);

    private static native long create_2(long var0, int var2, long var3, long var5, long var7);

    private static native long create_3(long var0, int var2, long var3, long var5);

    private static native long create_4(long var0, int var2, long var3);

    public static TrainData d(Mat mat, int n10, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return TrainData.a(TrainData.create_2(l10, n10, l11, l12, l13));
    }

    private static native void delete(long var0);

    public static TrainData e(Mat mat, int n10, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return TrainData.a(TrainData.create_1(l10, n10, l11, l12, l13, l14));
    }

    public static TrainData f(Mat mat, int n10, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        return TrainData.a(TrainData.create_0(l10, n10, l11, l12, l13, l14, l15));
    }

    private static native int getCatCount_0(long var0, int var2);

    private static native long getCatMap_0(long var0);

    private static native long getCatOfs_0(long var0);

    private static native long getClassLabels_0(long var0);

    private static native long getDefaultSubstValues_0(long var0);

    private static native int getLayout_0(long var0);

    private static native long getMissing_0(long var0);

    private static native int getNAllVars_0(long var0);

    private static native int getNSamples_0(long var0);

    private static native int getNTestSamples_0(long var0);

    private static native int getNTrainSamples_0(long var0);

    private static native int getNVars_0(long var0);

    private static native void getNames_0(long var0, List var2);

    private static native long getNormCatResponses_0(long var0);

    private static native int getResponseType_0(long var0);

    private static native long getResponses_0(long var0);

    private static native long getSampleWeights_0(long var0);

    private static native void getSample_0(long var0, long var2, int var4, float var5);

    private static native long getSamples_0(long var0);

    private static native long getSubMatrix_0(long var0, long var2, int var4);

    private static native long getSubVector_0(long var0, long var2);

    private static native long getTestNormCatResponses_0(long var0);

    private static native long getTestResponses_0(long var0);

    private static native long getTestSampleIdx_0(long var0);

    private static native long getTestSampleWeights_0(long var0);

    private static native long getTestSamples_0(long var0);

    private static native long getTrainNormCatResponses_0(long var0);

    private static native long getTrainResponses_0(long var0);

    private static native long getTrainSampleIdx_0(long var0);

    private static native long getTrainSampleWeights_0(long var0);

    private static native long getTrainSamples_0(long var0, int var2, boolean var3, boolean var4);

    private static native long getTrainSamples_1(long var0, int var2, boolean var3);

    private static native long getTrainSamples_2(long var0, int var2);

    private static native long getTrainSamples_3(long var0);

    private static native void getValues_0(long var0, int var2, long var3, float var5);

    private static native long getVarIdx_0(long var0);

    private static native long getVarSymbolFlags_0(long var0);

    private static native long getVarType_0(long var0);

    private static native void setTrainTestSplitRatio_0(long var0, double var2, boolean var4);

    private static native void setTrainTestSplitRatio_1(long var0, double var2);

    private static native void setTrainTestSplit_0(long var0, int var2, boolean var3);

    private static native void setTrainTestSplit_1(long var0, int var2);

    private static native void shuffleTrainTest_0(long var0);

    public Mat C() {
        long l10 = TrainData.getTestNormCatResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat D() {
        long l10 = TrainData.getTestResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat E() {
        long l10 = TrainData.getTestSampleIdx_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat F() {
        long l10 = TrainData.getTestSampleWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat G() {
        long l10 = TrainData.getTestSamples_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat H() {
        long l10 = TrainData.getTrainNormCatResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat I() {
        long l10 = TrainData.getTrainResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat J() {
        long l10 = TrainData.getTrainSampleIdx_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat K() {
        long l10 = TrainData.getTrainSampleWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat L() {
        long l10 = TrainData.getTrainSamples_3(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat M(int n10) {
        long l10 = TrainData.getTrainSamples_2(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat N(int n10, boolean bl2) {
        long l10 = TrainData.getTrainSamples_1(this.a, n10, bl2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat O(int n10, boolean bl2, boolean bl3) {
        long l10 = TrainData.getTrainSamples_0(this.a, n10, bl2, bl3);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void P(int n10, Mat mat, float f10) {
        long l10 = this.a;
        long l11 = mat.a;
        TrainData.getValues_0(l10, n10, l11, f10);
    }

    public Mat Q() {
        long l10 = TrainData.getVarIdx_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat R() {
        long l10 = TrainData.getVarSymbolFlags_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat S() {
        long l10 = TrainData.getVarType_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void T(int n10) {
        TrainData.setTrainTestSplit_1(this.a, n10);
    }

    public void U(int n10, boolean bl2) {
        TrainData.setTrainTestSplit_0(this.a, n10, bl2);
    }

    public void V(double d10) {
        TrainData.setTrainTestSplitRatio_1(this.a, d10);
    }

    public void W(double d10, boolean bl2) {
        TrainData.setTrainTestSplitRatio_0(this.a, d10, bl2);
    }

    public void X() {
        TrainData.shuffleTrainTest_0(this.a);
    }

    public void finalize() {
        TrainData.delete(this.a);
    }

    public int g(int n10) {
        return TrainData.getCatCount_0(this.a, n10);
    }

    public Mat h() {
        long l10 = TrainData.getCatMap_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat i() {
        long l10 = TrainData.getCatOfs_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat j() {
        long l10 = TrainData.getClassLabels_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat k() {
        long l10 = TrainData.getDefaultSubstValues_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int l() {
        return TrainData.getLayout_0(this.a);
    }

    public Mat m() {
        long l10 = TrainData.getMissing_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int n() {
        return TrainData.getNAllVars_0(this.a);
    }

    public int o() {
        return TrainData.getNSamples_0(this.a);
    }

    public int p() {
        return TrainData.getNTestSamples_0(this.a);
    }

    public int q() {
        return TrainData.getNTrainSamples_0(this.a);
    }

    public int r() {
        return TrainData.getNVars_0(this.a);
    }

    public void s(List list) {
        TrainData.getNames_0(this.a, list);
    }

    public long t() {
        return this.a;
    }

    public Mat u() {
        long l10 = TrainData.getNormCatResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int v() {
        return TrainData.getResponseType_0(this.a);
    }

    public Mat w() {
        long l10 = TrainData.getResponses_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void x(Mat mat, int n10, float f10) {
        long l10 = this.a;
        long l11 = mat.a;
        TrainData.getSample_0(l10, l11, n10, f10);
    }

    public Mat y() {
        long l10 = TrainData.getSampleWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat z() {
        long l10 = TrainData.getSamples_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }
}

