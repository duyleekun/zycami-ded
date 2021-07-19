/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class EM
extends StatModel {
    public static final int f = 5;
    public static final int g = 100;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 1;

    public EM(long l10) {
        super(l10);
    }

    public static EM A(String string2, String string3) {
        return EM.r(EM.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native int getClustersNumber_0(long var0);

    private static native int getCovarianceMatrixType_0(long var0);

    private static native void getCovs_0(long var0, long var2);

    private static native long getMeans_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native long getWeights_0(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    private static native double[] predict2_0(long var0, long var2, long var4);

    private static native float predict_0(long var0, long var2, long var4, int var6);

    private static native float predict_1(long var0, long var2, long var4);

    private static native float predict_2(long var0, long var2);

    public static EM r(long l10) {
        EM eM = new EM(l10);
        return eM;
    }

    public static EM s() {
        return EM.r(EM.create_0());
    }

    private static native void setClustersNumber_0(long var0, int var2);

    private static native void setCovarianceMatrixType_0(long var0, int var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    private static native boolean trainEM_0(long var0, long var2, long var4, long var6, long var8);

    private static native boolean trainEM_1(long var0, long var2, long var4, long var6);

    private static native boolean trainEM_2(long var0, long var2, long var4);

    private static native boolean trainEM_3(long var0, long var2);

    private static native boolean trainE_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14);

    private static native boolean trainE_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native boolean trainE_2(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native boolean trainE_3(long var0, long var2, long var4, long var6, long var8);

    private static native boolean trainE_4(long var0, long var2, long var4, long var6);

    private static native boolean trainE_5(long var0, long var2, long var4);

    private static native boolean trainM_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native boolean trainM_1(long var0, long var2, long var4, long var6, long var8);

    private static native boolean trainM_2(long var0, long var2, long var4, long var6);

    private static native boolean trainM_3(long var0, long var2, long var4);

    public static EM z(String string2) {
        return EM.r(EM.load_1(string2));
    }

    public double[] B(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.predict2_0(l10, l11, l12);
    }

    public void C(int n10) {
        EM.setClustersNumber_0(this.a, n10);
    }

    public void D(int n10) {
        EM.setCovarianceMatrixType_0(this.a, n10);
    }

    public void E(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        EM.setTermCriteria_0(l10, n10, n11, d10);
    }

    public boolean F(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.trainE_5(l10, l11, l12);
    }

    public boolean G(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return EM.trainE_4(l10, l11, l12, l13);
    }

    public boolean H(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        return EM.trainE_3(l10, l11, l12, l13, l14);
    }

    public boolean I(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        return EM.trainE_2(l10, l11, l12, l13, l14, l15);
    }

    public boolean J(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        long l16 = mat6.a;
        return EM.trainE_1(l10, l11, l12, l13, l14, l15, l16);
    }

    public boolean K(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        long l16 = mat6.a;
        long l17 = mat7.a;
        return EM.trainE_0(l10, l11, l12, l13, l14, l15, l16, l17);
    }

    public boolean L(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return EM.trainEM_3(l10, l11);
    }

    public boolean M(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.trainEM_2(l10, l11, l12);
    }

    public boolean N(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return EM.trainEM_1(l10, l11, l12, l13);
    }

    public boolean O(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        return EM.trainEM_0(l10, l11, l12, l13, l14);
    }

    public boolean P(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.trainM_3(l10, l11, l12);
    }

    public boolean Q(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return EM.trainM_2(l10, l11, l12, l13);
    }

    public boolean R(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        return EM.trainM_1(l10, l11, l12, l13, l14);
    }

    public boolean S(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        return EM.trainM_0(l10, l11, l12, l13, l14, l15);
    }

    public void finalize() {
        EM.delete(this.a);
    }

    public float l(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return EM.predict_2(l10, l11);
    }

    public float m(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.predict_1(l10, l11, l12);
    }

    public float n(Mat mat, Mat mat2, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return EM.predict_0(l10, l11, l12, n10);
    }

    public int t() {
        return EM.getClustersNumber_0(this.a);
    }

    public int u() {
        return EM.getCovarianceMatrixType_0(this.a);
    }

    public void v(List list) {
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        EM.getCovs_0(l10, l11);
        i.f.h.a.c(mat, list);
        mat.u0();
    }

    public Mat w() {
        long l10 = EM.getMeans_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public a0 x() {
        double[] dArray = EM.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public Mat y() {
        long l10 = EM.getWeights_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }
}

