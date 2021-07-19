/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.video;

import i.f.c.a0;
import i.f.c.d;
import i.f.c.i;
import i.f.c.m;
import i.f.c.w;
import i.f.c.x;
import i.f.c.z;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.video.BackgroundSubtractorKNN;
import org.opencv.video.BackgroundSubtractorMOG2;

public class Video {
    private static final int a = 4;
    private static final int b = 8;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 256;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;

    public static boolean A(String string2, Mat mat) {
        long l10 = mat.a;
        return Video.writeOpticalFlow_0(string2, l10);
    }

    private static native double[] CamShift_0(long var0, int var2, int var3, int var4, int var5, double[] var6, int var7, int var8, double var9);

    public static x a(Mat object, w w10, a0 a02) {
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = ((Mat)object).a;
        int n11 = w10.a;
        int n12 = w10.b;
        int n13 = w10.c;
        int n14 = w10.d;
        int n15 = a02.a;
        int n16 = a02.b;
        double d10 = a02.c;
        object = Video.CamShift_0(l10, n11, n12, n13, n14, dArray, n15, n16, d10);
        x x10 = new x((double[])object);
        if (w10 != null) {
            int n17;
            object = null;
            w10.a = n17 = (int)dArray[0];
            w10.b = n17 = (int)dArray[1];
            w10.c = n17 = (int)dArray[2];
            double d11 = dArray[3];
            w10.d = n17 = (int)d11;
        }
        return x10;
    }

    public static int b(Mat mat, List list, z z10, int n10) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        int n11 = Video.buildOpticalFlowPyramid_4(l10, l11, d10, d11, n10);
        i.f.h.a.c(mat2, list);
        mat2.u0();
        return n11;
    }

    private static native int buildOpticalFlowPyramid_0(long var0, long var2, double var4, double var6, int var8, boolean var9, int var10, int var11, boolean var12);

    private static native int buildOpticalFlowPyramid_1(long var0, long var2, double var4, double var6, int var8, boolean var9, int var10, int var11);

    private static native int buildOpticalFlowPyramid_2(long var0, long var2, double var4, double var6, int var8, boolean var9, int var10);

    private static native int buildOpticalFlowPyramid_3(long var0, long var2, double var4, double var6, int var8, boolean var9);

    private static native int buildOpticalFlowPyramid_4(long var0, long var2, double var4, double var6, int var8);

    public static int c(Mat mat, List list, z z10, int n10, boolean bl2) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        int n11 = Video.buildOpticalFlowPyramid_3(l10, l11, d10, d11, n10, bl2);
        i.f.h.a.c(mat2, list);
        mat2.u0();
        return n11;
    }

    private static native void calcOpticalFlowFarneback_0(long var0, long var2, long var4, double var6, int var8, int var9, int var10, int var11, double var12, int var14);

    private static native void calcOpticalFlowPyrLK_0(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, int var16, int var17, int var18, double var19, int var21, double var22);

    private static native void calcOpticalFlowPyrLK_1(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, int var16, int var17, int var18, double var19, int var21);

    private static native void calcOpticalFlowPyrLK_2(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, int var16, int var17, int var18, double var19);

    private static native void calcOpticalFlowPyrLK_3(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, int var16);

    private static native void calcOpticalFlowPyrLK_4(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14);

    private static native void calcOpticalFlowPyrLK_5(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native double computeECC_0(long var0, long var2, long var4);

    private static native double computeECC_1(long var0, long var2);

    private static native long createBackgroundSubtractorKNN_0(int var0, double var1, boolean var3);

    private static native long createBackgroundSubtractorKNN_1(int var0, double var1);

    private static native long createBackgroundSubtractorKNN_2(int var0);

    private static native long createBackgroundSubtractorKNN_3();

    private static native long createBackgroundSubtractorMOG2_0(int var0, double var1, boolean var3);

    private static native long createBackgroundSubtractorMOG2_1(int var0, double var1);

    private static native long createBackgroundSubtractorMOG2_2(int var0);

    private static native long createBackgroundSubtractorMOG2_3();

    public static int d(Mat mat, List list, z z10, int n10, boolean bl2, int n11) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        int n12 = Video.buildOpticalFlowPyramid_2(l10, l11, d10, d11, n10, bl2, n11);
        i.f.h.a.c(mat2, list);
        mat2.u0();
        return n12;
    }

    public static int e(Mat mat, List list, z z10, int n10, boolean bl2, int n11, int n12) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        int n13 = Video.buildOpticalFlowPyramid_1(l10, l11, d10, d11, n10, bl2, n11, n12);
        i.f.h.a.c(mat2, list);
        mat2.u0();
        return n13;
    }

    public static int f(Mat mat, List list, z z10, int n10, boolean bl2, int n11, int n12, boolean bl3) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        int n13 = Video.buildOpticalFlowPyramid_0(l10, l11, d10, d11, n10, bl2, n11, n12, bl3);
        i.f.h.a.c(mat2, list);
        mat2.u0();
        return n13;
    }

    private static native double findTransformECC_0(long var0, long var2, long var4, int var6, int var7, int var8, double var9, long var11, int var13);

    public static void g(Mat mat, Mat mat2, Mat mat3, double d10, int n10, int n11, int n12, int n13, double d11, int n14) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Video.calcOpticalFlowFarneback_0(l10, l11, l12, d10, n10, n11, n12, n13, d11, n14);
    }

    public static void h(Mat mat, Mat mat2, m m10, m m11, d d10, i i10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        Video.calcOpticalFlowPyrLK_5(l10, l11, l12, l13, l14, l15);
    }

    public static void i(Mat mat, Mat mat2, m m10, m m11, d d10, i i10, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l16 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        double d13 = d11;
        d11 = d12;
        Video.calcOpticalFlowPyrLK_4(l16, l10, l11, l12, l13, l15, d13, d12);
    }

    public static void j(Mat mat, Mat mat2, m m10, m m11, d d10, i i10, z z10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        Video.calcOpticalFlowPyrLK_3(l10, l11, l12, l13, l14, l15, d11, d12, n10);
    }

    public static void k(Mat mat, Mat mat2, m m10, m m11, d d10, i i10, z z10, int n10, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        int n11 = a02.a;
        int n12 = a02.b;
        double d13 = a02.c;
        Video.calcOpticalFlowPyrLK_2(l10, l11, l12, l13, l14, l15, d11, d12, n10, n11, n12, d13);
    }

    public static void l(Mat mat, Mat mat2, m m10, m m11, d d10, i i10, z z10, int n10, a0 a02, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        int n12 = a02.a;
        int n13 = a02.b;
        double d13 = a02.c;
        Video.calcOpticalFlowPyrLK_1(l10, l11, l12, l13, l14, l15, d11, d12, n10, n12, n13, d13, n11);
    }

    public static void m(Mat mat, Mat mat2, m m10, m m11, d d10, i i10, z z10, int n10, a0 a02, int n11, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = m10.a;
        long l13 = m11.a;
        long l14 = d10.a;
        long l15 = i10.a;
        double d12 = z10.a;
        double d13 = z10.b;
        int n12 = a02.a;
        int n13 = a02.b;
        double d14 = a02.c;
        Video.calcOpticalFlowPyrLK_0(l10, l11, l12, l13, l14, l15, d12, d13, n10, n12, n13, d14, n11, d11);
    }

    private static native int meanShift_0(long var0, int var2, int var3, int var4, int var5, double[] var6, int var7, int var8, double var9);

    public static double n(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Video.computeECC_1(l10, l11);
    }

    public static double o(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Video.computeECC_0(l10, l11, l12);
    }

    public static BackgroundSubtractorKNN p() {
        return BackgroundSubtractorKNN.k(Video.createBackgroundSubtractorKNN_3());
    }

    public static BackgroundSubtractorKNN q(int n10) {
        return BackgroundSubtractorKNN.k(Video.createBackgroundSubtractorKNN_2(n10));
    }

    public static BackgroundSubtractorKNN r(int n10, double d10) {
        return BackgroundSubtractorKNN.k(Video.createBackgroundSubtractorKNN_1(n10, d10));
    }

    private static native long readOpticalFlow_0(String var0);

    public static BackgroundSubtractorKNN s(int n10, double d10, boolean bl2) {
        return BackgroundSubtractorKNN.k(Video.createBackgroundSubtractorKNN_0(n10, d10, bl2));
    }

    public static BackgroundSubtractorMOG2 t() {
        return BackgroundSubtractorMOG2.k(Video.createBackgroundSubtractorMOG2_3());
    }

    public static BackgroundSubtractorMOG2 u(int n10) {
        return BackgroundSubtractorMOG2.k(Video.createBackgroundSubtractorMOG2_2(n10));
    }

    public static BackgroundSubtractorMOG2 v(int n10, double d10) {
        return BackgroundSubtractorMOG2.k(Video.createBackgroundSubtractorMOG2_1(n10, d10));
    }

    public static BackgroundSubtractorMOG2 w(int n10, double d10, boolean bl2) {
        return BackgroundSubtractorMOG2.k(Video.createBackgroundSubtractorMOG2_0(n10, d10, bl2));
    }

    private static native boolean writeOpticalFlow_0(String var0, long var1);

    public static double x(Mat mat, Mat mat2, Mat mat3, int n10, a0 a02, Mat mat4, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        int n12 = a02.a;
        int n13 = a02.b;
        double d10 = a02.c;
        long l13 = mat4.a;
        return Video.findTransformECC_0(l10, l11, l12, n10, n12, n13, d10, l13, n11);
    }

    public static int y(Mat mat, w w10, a0 a02) {
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        int n11 = w10.a;
        int n12 = w10.b;
        int n13 = w10.c;
        int n14 = w10.d;
        int n15 = a02.a;
        int n16 = a02.b;
        double d10 = a02.c;
        int n17 = Video.meanShift_0(l10, n11, n12, n13, n14, dArray, n15, n16, d10);
        if (w10 != null) {
            int n18;
            a02 = null;
            w10.a = n18 = (int)dArray[0];
            w10.b = n18 = (int)dArray[1];
            w10.c = n18 = (int)dArray[2];
            double d11 = dArray[3];
            w10.d = n18 = (int)d11;
        }
        return n17;
    }

    public static Mat z(String string2) {
        long l10 = Video.readOpticalFlow_0(string2);
        Mat mat = new Mat(l10);
        return mat;
    }
}

