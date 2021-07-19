/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.calib3d;

import i.f.c.a0;
import i.f.c.f;
import i.f.c.m;
import i.f.c.o;
import i.f.c.u;
import i.f.c.w;
import i.f.c.z;
import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;

public class Calib3d {
    public static final int A = 32;
    public static final int B = 64;
    public static final int C = 128;
    public static final int D = 2048;
    public static final int E = 4096;
    public static final int F = 8192;
    public static final int G = 16384;
    public static final int H = 32768;
    public static final int I = 65536;
    public static final int J = 262144;
    public static final int K = 524288;
    public static final int L = 0x100000;
    public static final int M = 0x200000;
    public static final int N = 256;
    public static final int O = 512;
    public static final int P = 1024;
    public static final int Q = 131072;
    public static final int R = 0x400000;
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 4;
    public static final int V = 8;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 4;
    public static final int Z = 8;
    public static final int a = 0;
    public static final int a0 = 16;
    public static final int b = 1;
    public static final int b0 = 32;
    public static final int c = 2;
    public static final int c0 = 64;
    public static final int d = 3;
    public static final int d0 = 128;
    public static final int e = 0;
    public static final int e0 = 256;
    public static final int f = 1;
    public static final int f0 = 512;
    public static final int g = 2;
    public static final int g0 = 0;
    public static final int h = 3;
    public static final int h0 = 1;
    public static final int i = 4;
    public static final int i0 = 0;
    public static final int j = 8;
    public static final int j0 = 1;
    public static final int k = 16;
    public static final int k0 = 2;
    public static final int l = 1;
    public static final int l0 = 3;
    public static final int m = 2;
    public static final int m0 = 4;
    public static final int n = 4;
    public static final int n0 = 5;
    public static final int o = 8;
    public static final int o0 = 6;
    public static final int p = 16;
    public static final int p0 = 7;
    public static final int q = 32;
    public static final int q0 = 8;
    public static final int r = 1;
    public static final int r0 = 0;
    public static final int s = 2;
    public static final int s0 = 1;
    public static final int t = 4;
    public static final int t0 = 2;
    public static final int u = 18;
    public static final int u0 = 3;
    public static final int v = 1;
    public static final int v0 = 4;
    public static final int w = 2;
    public static final int w0 = 0;
    public static final int x = 4;
    public static final int x0 = 1;
    public static final int y = 8;
    public static final int z = 16;

    public static void A(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        long l20 = mat10.a;
        l10 = l18;
        Calib3d.composeRT_4(l18, l11, l12, l13, l14, l15, l16, l17, l19, l20);
    }

    public static Mat A0(Mat mat, Mat mat2, double d10, u u10, int n10, double d11, double d12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d13 = u10.a;
        double d14 = u10.b;
        l10 = Calib3d.findEssentialMat_6(l10, l11, d10, d13, d14, n10, d11, d12);
        Mat mat3 = new Mat(l10);
        return mat3;
    }

    public static Mat A1(List object, List object2, z z10) {
        int n10 = 0;
        int n11 = object != null ? object.size() : 0;
        Object object3 = new ArrayList(n11);
        object = i.f.h.a.U((List)object, object3);
        if (object2 != null) {
            n10 = object2.size();
        }
        object3 = new ArrayList(n10);
        object2 = i.f.h.a.T((List)object2, object3);
        long l10 = ((Mat)object).a;
        long l11 = ((Mat)object2).a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = Calib3d.initCameraMatrix2D_1(l10, l11, d10, d11);
        object3 = new Mat(l12);
        return object3;
    }

    public static void A2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, double d10, z z11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l14 = mat5.a;
        long l15 = l10;
        long l16 = mat6.a;
        long l17 = mat7.a;
        long l18 = mat8.a;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        double d13 = z11.a;
        double d14 = z11.b;
        l10 = l15;
        Calib3d.stereoRectify_2(l15, l11, l12, l13, d11, d12, l14, l16, l17, l18, l19, l20, l21, n10, d10, d13, d14);
    }

    public static void B(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        l10 = l18;
        Calib3d.composeRT_3(l18, l11, l12, l13, l14, l15, l16, l17, l19, l20, l21);
    }

    public static Mat B0(Mat mat, Mat mat2, double d10, u u10, int n10, double d11, double d12, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d13 = u10.a;
        double d14 = u10.b;
        long l12 = mat3.a;
        l12 = Calib3d.findEssentialMat_5(l10, l11, d10, d13, d14, n10, d11, d12, l12);
        Mat mat4 = new Mat(l12);
        return mat4;
    }

    public static Mat B1(List object, List object2, z z10, double d10) {
        int n10 = 0;
        int n11 = object != null ? object.size() : 0;
        Object object3 = new ArrayList(n11);
        object = i.f.h.a.U((List)object, object3);
        if (object2 != null) {
            n10 = object2.size();
        }
        object3 = new ArrayList(n10);
        object2 = i.f.h.a.T((List)object2, object3);
        long l10 = ((Mat)object).a;
        long l11 = ((Mat)object2).a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l12 = Calib3d.initCameraMatrix2D_0(l10, l11, d11, d12, d10);
        object3 = new Mat(l12);
        return object3;
    }

    public static void B2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, double d10, z z11, w w10) {
        int n11 = 4;
        double[] dArray = new double[n11];
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        double d13 = z11.a;
        double d14 = z11.b;
        Calib3d.stereoRectify_1(l10, l11, l12, l13, d11, d12, l14, l15, l16, l17, l18, l19, l20, n10, d10, d13, d14, dArray);
        if (w10 != null) {
            int n12;
            int n13;
            w10.a = n13 = (int)dArray[0];
            w10.b = n13 = (int)dArray[1];
            w10.c = n13 = (int)dArray[2];
            n13 = 3;
            d13 = dArray[n13];
            w10.d = n12 = (int)d13;
        }
    }

    public static void C(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        long l22 = mat12.a;
        l10 = l18;
        Calib3d.composeRT_2(l18, l11, l12, l13, l14, l15, l16, l17, l19, l20, l21, l22);
    }

    public static Mat C0(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.findEssentialMat_4(l10, l11, l12);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void C1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, int n10, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.initUndistortRectifyMap_0(l10, l11, l12, l13, d10, d11, n10, l14, l15);
    }

    public static void C2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, double d10, z z11, w w10, w w11) {
        int n11 = 4;
        double[] dArray = new double[n11];
        double[] dArray2 = new double[n11];
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double[] dArray3 = dArray2;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        double d13 = z11.a;
        double d14 = z11.b;
        Calib3d.stereoRectify_0(l10, l11, l12, l13, d11, d12, l14, l15, l16, l17, l18, l19, l20, n10, d10, d13, d14, dArray, dArray2);
        int n12 = 3;
        int n13 = 2;
        int n14 = 1;
        n11 = 0;
        if (w10 != null) {
            int n15;
            int n16;
            w10.a = n16 = (int)dArray[0];
            w10.b = n16 = (int)dArray[n14];
            w10.c = n16 = (int)dArray[n13];
            double d15 = dArray[n12];
            w10.d = n15 = (int)d15;
        }
        if (w11 != null) {
            double d16 = dArray3[0];
            w11.a = n11 = (int)d16;
            double d17 = dArray3[n14];
            w11.b = n14 = (int)d17;
            d13 = dArray3[n13];
            w11.c = n13 = (int)d13;
            d14 = dArray3[n12];
            w11.d = n12 = (int)d14;
        }
    }

    public static void D(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        long l22 = mat12.a;
        long l23 = mat13.a;
        l10 = l18;
        Calib3d.composeRT_1(l18, l11, l12, l13, l14, l15, l16, l17, l19, l20, l21, l22, l23);
    }

    public static Mat D0(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.findEssentialMat_3(l10, l11, l12, n10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void D1(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.matMulDeriv_0(l10, l11, l12, l13);
    }

    public static boolean D2(Mat mat, Mat mat2, Mat mat3, z z10, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return Calib3d.stereoRectifyUncalibrated_1(l10, l11, l12, d10, d11, l13, l14);
    }

    public static void E(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13, Mat mat14) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        long l22 = mat12.a;
        long l23 = mat13.a;
        long l24 = mat14.a;
        l10 = l18;
        Calib3d.composeRT_0(l18, l11, l12, l13, l14, l15, l16, l17, l19, l20, l21, l22, l23, l24);
    }

    public static Mat E0(Mat mat, Mat mat2, Mat mat3, int n10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.findEssentialMat_2(l10, l11, l12, n10, d10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void E1(o o10, Mat mat, Mat mat2, Mat mat3, f f10, m m10) {
        long l10 = o10.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = f10.a;
        long l15 = m10.a;
        Calib3d.projectPoints_2(l10, l11, l12, l13, l14, l15);
    }

    public static boolean E2(Mat mat, Mat mat2, Mat mat3, z z10, Mat mat4, Mat mat5, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return Calib3d.stereoRectifyUncalibrated_0(l10, l11, l12, d11, d12, l13, l14, d10);
    }

    public static void F(Mat mat, int n10, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Calib3d.computeCorrespondEpilines_0(l10, n10, l11, l12);
    }

    public static Mat F0(Mat mat, Mat mat2, Mat mat3, int n10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        l10 = Calib3d.findEssentialMat_1(l10, l11, l12, n10, d10, d11);
        Mat mat4 = new Mat(l10);
        return mat4;
    }

    public static void F1(o o10, Mat mat, Mat mat2, Mat mat3, f f10, m m10, Mat mat4) {
        long l10 = o10.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = f10.a;
        long l15 = m10.a;
        long l16 = mat4.a;
        Calib3d.projectPoints_1(l10, l11, l12, l13, l14, l15, l16);
    }

    public static void F2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.triangulatePoints_0(l10, l11, l12, l13, l14);
    }

    public static void G(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.convertPointsFromHomogeneous_0(l10, l11);
    }

    public static Mat G0(Mat mat, Mat mat2, Mat mat3, int n10, double d10, double d11, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        l10 = Calib3d.findEssentialMat_0(l10, l11, l12, n10, d10, d11, l13);
        Mat mat5 = new Mat(l10);
        return mat5;
    }

    public static void G1(o o10, Mat mat, Mat mat2, Mat mat3, f f10, m m10, Mat mat4, double d10) {
        long l10 = o10.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = f10.a;
        long l15 = m10.a;
        long l16 = mat4.a;
        Calib3d.projectPoints_0(l10, l11, l12, l13, l14, l15, l16, d10);
    }

    public static void G2(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.undistort_1(l10, l11, l12, l13);
    }

    public static void H(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.convertPointsToHomogeneous_0(l10, l11);
    }

    public static Mat H0(m m10, m m11) {
        long l10 = m10.a;
        long l11 = m11.a;
        l11 = Calib3d.findFundamentalMat_4(l10, l11);
        Mat mat = new Mat(l11);
        return mat;
    }

    public static int H1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return Calib3d.recoverPose_3(l10, l11, l12, l13, l14);
    }

    public static void H2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.undistort_0(l10, l11, l12, l13, l14);
    }

    public static void I(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.correctMatches_0(l10, l11, l12, l13, l14);
    }

    public static Mat I0(m m10, m m11, int n10) {
        long l10 = m10.a;
        long l11 = m11.a;
        l11 = Calib3d.findFundamentalMat_3(l10, l11, n10);
        Mat mat = new Mat(l11);
        return mat;
    }

    public static int I1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return Calib3d.recoverPose_2(l10, l11, l12, l13, l14, d10);
    }

    public static void I2(m m10, m m11, Mat mat, Mat mat2) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        Calib3d.undistortPoints_2(l10, l11, l12, l13);
    }

    public static void J(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.decomposeEssentialMat_0(l10, l11, l12, l13);
    }

    public static Mat J0(m m10, m m11, int n10, double d10) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = Calib3d.findFundamentalMat_2(l10, l11, n10, d10);
        Mat mat = new Mat(l12);
        return mat;
    }

    public static int J1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d10, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        double d11 = u10.a;
        double d12 = u10.b;
        long l15 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        return Calib3d.recoverPose_1(l15, l10, l11, l12, l14, d10, d11, d12);
    }

    public static void J2(m m10, m m11, Mat mat, Mat mat2, Mat mat3) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        Calib3d.undistortPoints_1(l10, l11, l12, l13, l14);
    }

    public static int K(Mat mat, Mat mat2, List list, List list2, List list3) {
        Object object = new Mat();
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = ((Mat)object).a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        int n10 = Calib3d.decomposeHomographyMat_0(l10, l11, l12, l13, l14);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat3, list2);
        mat3.u0();
        object = list3;
        i.f.h.a.c(mat4, list3);
        mat4.u0();
        return n10;
    }

    public static Mat K0(m m10, m m11, int n10, double d10, double d11) {
        long l10 = m10.a;
        long l11 = m11.a;
        l10 = Calib3d.findFundamentalMat_1(l10, l11, n10, d10, d11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static int K1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d10, u u10, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        double d11 = u10.a;
        double d12 = u10.b;
        long l15 = mat6.a;
        return Calib3d.recoverPose_0(l10, l11, l12, l13, l14, d10, d11, d12, l15);
    }

    public static void K2(m m10, m m11, Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        long l15 = mat4.a;
        Calib3d.undistortPoints_0(l10, l11, l12, l13, l14, l15);
    }

    public static void L(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.decomposeProjectionMatrix_4(l10, l11, l12, l13);
    }

    public static Mat L0(m m10, m m11, int n10, double d10, double d11, Mat mat) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        l10 = Calib3d.findFundamentalMat_0(l10, l11, n10, d10, d11, l12);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static int L1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        return Calib3d.recoverPose_5(l10, l11, l12, l13, l14, l15);
    }

    public static void L2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        long l16 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        Calib3d.undistortPointsIter_0(l16, l10, l11, l12, l13, l15, n10, n11, d10);
    }

    public static void M(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.decomposeProjectionMatrix_3(l10, l11, l12, l13, l14);
    }

    public static Mat M0(m m10, m m11) {
        long l10 = m10.a;
        long l11 = m11.a;
        l11 = Calib3d.findHomography_5(l10, l11);
        Mat mat = new Mat(l11);
        return mat;
    }

    public static int M1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        return Calib3d.recoverPose_8(l10, l11, l12, l13, l14, l15, d10);
    }

    public static void M2(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.validateDisparity_1(l10, l11, n10, n11);
    }

    public static void N(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.decomposeProjectionMatrix_2(l10, l11, l12, l13, l14, l15);
    }

    public static Mat N0(m m10, m m11, int n10) {
        long l10 = m10.a;
        long l11 = m11.a;
        l11 = Calib3d.findHomography_4(l10, l11, n10);
        Mat mat = new Mat(l11);
        return mat;
    }

    public static int N1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d10, Mat mat7) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        return Calib3d.recoverPose_7(l10, l11, l12, l13, l14, l15, d10, l16);
    }

    public static void N2(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.validateDisparity_0(l10, l11, n10, n11, n12);
    }

    public static void O(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        Calib3d.decomposeProjectionMatrix_1(l10, l11, l12, l13, l14, l15, l16);
    }

    public static Mat O0(m m10, m m11, int n10, double d10) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = Calib3d.findHomography_3(l10, l11, n10, d10);
        Mat mat = new Mat(l12);
        return mat;
    }

    public static int O1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d10, Mat mat7, Mat mat8) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = l10;
        long l18 = mat8.a;
        l10 = l17;
        return Calib3d.recoverPose_6(l17, l11, l12, l13, l14, l15, d10, l16, l18);
    }

    public static void P(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        Calib3d.decomposeProjectionMatrix_0(l10, l11, l12, l13, l14, l15, l16, l17);
    }

    public static Mat P0(m m10, m m11, int n10, double d10, Mat mat) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        long l13 = Calib3d.findHomography_2(l10, l11, n10, d10, l12);
        Mat mat2 = new Mat(l13);
        return mat2;
    }

    public static int P1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        return Calib3d.recoverPose_4(l10, l11, l12, l13, l14, l15, l16);
    }

    public static void Q(Mat mat, z z10, m m10, boolean bl2) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = m10.a;
        Calib3d.drawChessboardCorners_0(l10, d10, d11, l11, bl2);
    }

    public static Mat Q0(m m10, m m11, int n10, double d10, Mat mat, int n11) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        l10 = Calib3d.findHomography_1(l10, l11, n10, d10, l12, n11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static float Q1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, List object, List object2, z z10, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13, Mat mat14, Mat mat15, Mat mat16, Mat mat17, double d10, z z11, w w10, w w11, int n10) {
        double d11;
        Mat mat18 = i.f.h.a.A((List)object);
        Mat mat19 = i.f.h.a.A((List)object2);
        int n11 = 4;
        double[] dArray = new double[n11];
        double[] dArray2 = new double[n11];
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        double[] dArray3 = dArray2;
        object = mat18;
        object2 = mat19;
        mat18 = mat6;
        long l15 = mat6.a;
        long l16 = ((Mat)object).a;
        long l17 = mat19.a;
        double d12 = z10.a;
        double d13 = z10.b;
        long l18 = mat7.a;
        long l19 = mat8.a;
        long l20 = mat9.a;
        long l21 = mat10.a;
        long l22 = mat11.a;
        long l23 = mat12.a;
        long l24 = mat13.a;
        long l25 = mat14.a;
        long l26 = mat15.a;
        long l27 = mat16.a;
        long l28 = mat17.a;
        double d14 = z11.a;
        double d15 = z11.b;
        float f10 = Calib3d.rectify3Collinear_0(l10, l11, l12, l13, l14, l15, l16, l17, d12, d13, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, d10, d14, d15, dArray, dArray2, n10);
        int n12 = 3;
        int n13 = 2;
        int n14 = 1;
        n11 = 0;
        if (w10 != null) {
            int n15;
            w10.a = n15 = (int)dArray[0];
            w10.b = n15 = (int)dArray[n14];
            w10.c = n15 = (int)dArray[n13];
            d11 = dArray[n12];
            w10.d = n15 = (int)d11;
        }
        if (w11 != null) {
            d11 = dArray3[0];
            w11.a = n11 = (int)d11;
            double d16 = dArray3[n14];
            w11.b = n14 = (int)d16;
            d14 = dArray3[n13];
            w11.c = n13 = (int)d14;
            double d17 = dArray3[n12];
            w11.d = n12 = (int)d17;
        }
        return f10;
    }

    public static void R(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.drawFrameAxes_1(l10, l11, l12, l13, l14, f10);
    }

    public static Mat R0(m m10, m m11, int n10, double d10, Mat mat, int n11, double d11) {
        long l10 = m10.a;
        long l11 = m11.a;
        long l12 = mat.a;
        l10 = Calib3d.findHomography_0(l10, l11, n10, d10, l12, n11, d11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static void R1(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Calib3d.reprojectImageTo3D_2(l10, l11, l12);
    }

    private static native double[] RQDecomp3x3_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native double[] RQDecomp3x3_1(long var0, long var2, long var4, long var6, long var8);

    private static native double[] RQDecomp3x3_2(long var0, long var2, long var4, long var6);

    private static native double[] RQDecomp3x3_3(long var0, long var2, long var4);

    private static native void Rodrigues_0(long var0, long var2, long var4);

    private static native void Rodrigues_1(long var0, long var2);

    public static void S(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, float f10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.drawFrameAxes_0(l10, l11, l12, l13, l14, f10, n10);
    }

    public static double S0(List object, List list, z z10, Mat mat, Mat mat2, List list2, List list3) {
        Mat mat3 = i.f.h.a.A((List)object);
        Object object2 = i.f.h.a.A(list);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat3.a;
        long l11 = ((Mat)object2).a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat4.a;
        object = mat4;
        long l15 = mat5.a;
        double d12 = Calib3d.fisheye_calibrate_2(l10, l11, d10, d11, l12, l13, l14, l15);
        object2 = list2;
        i.f.h.a.c(mat4, list2);
        mat4.u0();
        object2 = list3;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        return d12;
    }

    public static void S1(Mat mat, Mat mat2, Mat mat3, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Calib3d.reprojectImageTo3D_1(l10, l11, l12, bl2);
    }

    public static Mat T(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = Calib3d.estimateAffine2D_6(l10, l11);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static double T0(List object, List list, z object2, Mat mat, Mat mat2, List list2, List list3, int n10) {
        Mat mat3 = i.f.h.a.A((List)object);
        Object object3 = i.f.h.a.A(list);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat3.a;
        long l11 = ((Mat)object3).a;
        double d10 = ((z)object2).a;
        double d11 = ((z)object2).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        object = mat5;
        long l14 = mat4.a;
        long l15 = l10;
        l10 = mat5.a;
        object2 = mat5;
        long l16 = l10;
        l10 = l15;
        double d12 = Calib3d.fisheye_calibrate_1(l15, l11, d10, d11, l12, l13, l14, l16, n10);
        object3 = list2;
        i.f.h.a.c(mat4, list2);
        mat4.u0();
        object3 = mat5;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        return d12;
    }

    public static void T1(Mat mat, Mat mat2, Mat mat3, boolean bl2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Calib3d.reprojectImageTo3D_0(l10, l11, l12, bl2, n10);
    }

    public static Mat U(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffine2D_5(l10, l11, l12);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static double U0(List list, List list2, z object, Mat mat, Mat mat2, List list3, List list4, int n10, a0 a02) {
        Mat mat3 = i.f.h.a.A(list);
        Mat mat4 = i.f.h.a.A(list2);
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        long l10 = mat3.a;
        long l11 = mat4.a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = l10;
        l10 = mat5.a;
        object = mat5;
        long l15 = l10;
        long l16 = mat6.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l14;
        d12 = Calib3d.fisheye_calibrate_0(l14, l11, d10, d11, l12, l13, l15, l16, n10, n11, n12, d12);
        mat4 = mat5;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        i.f.h.a.c(mat6, list4);
        mat6.u0();
        return d12;
    }

    public static double U1(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Calib3d.sampsonDistance_0(l10, l11, l12);
    }

    public static Mat V(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffine2D_4(l10, l11, l12, n10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void V0(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_distortPoints_1(l10, l11, l12, l13);
    }

    public static int V1(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, int n10) {
        Object object = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = ((Mat)object).a;
        long l15 = mat5.a;
        int n11 = Calib3d.solveP3P_0(l10, l11, l12, l13, l14, l15, n10);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat5, list2);
        mat5.u0();
        return n11;
    }

    public static Mat W(Mat mat, Mat mat2, Mat mat3, int n10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffine2D_3(l10, l11, l12, n10, d10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void W0(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_distortPoints_0(l10, l11, l12, l13, d10);
    }

    public static boolean W1(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnP_2(l10, l11, l12, l13, l14, l15);
    }

    public static Mat X(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10) {
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        l11 = Calib3d.estimateAffine2D_2(l11, l12, l13, n10, d10, l10);
        Mat mat4 = new Mat(l11);
        return mat4;
    }

    public static void X0(Mat mat, Mat mat2, z z10, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_estimateNewCameraMatrixForUndistortRectify_3(l10, l11, d10, d11, l12, l13);
    }

    public static boolean X1(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnP_1(l10, l11, l12, l13, l14, l15, bl2);
    }

    public static Mat Y(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10, double d11) {
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        l11 = Calib3d.estimateAffine2D_1(l11, l12, l13, n10, d10, l10, d11);
        Mat mat4 = new Mat(l11);
        return mat4;
    }

    public static void Y0(Mat mat, Mat mat2, z z10, Mat mat3, Mat mat4, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_estimateNewCameraMatrixForUndistortRectify_2(l10, l11, d11, d12, l12, l13, d10);
    }

    public static boolean Y1(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnP_0(l10, l11, l12, l13, l14, l15, bl2, n10);
    }

    public static Mat Z(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10, double d11, long l11) {
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        l12 = Calib3d.estimateAffine2D_0(l12, l13, l14, n10, d10, l10, d11, l11);
        Mat mat4 = new Mat(l12);
        return mat4;
    }

    public static void Z0(Mat mat, Mat mat2, z z10, Mat mat3, Mat mat4, double d10, z z11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d13 = z11.a;
        double d14 = z11.b;
        Calib3d.fisheye_estimateNewCameraMatrixForUndistortRectify_1(l10, l11, d11, d12, l12, l13, d10, d13, d14);
    }

    public static int Z1(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2) {
        Object object = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = ((Mat)object).a;
        long l15 = mat5.a;
        int n10 = Calib3d.solvePnPGeneric_5(l10, l11, l12, l13, l14, l15);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat5, list2);
        mat5.u0();
        return n10;
    }

    public static double[] a(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Calib3d.RQDecomp3x3_3(l10, l11, l12);
    }

    public static int a0(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Calib3d.estimateAffine3D_2(l10, l11, l12, l13);
    }

    public static void a1(Mat mat, Mat mat2, z z10, Mat mat3, Mat mat4, double d10, z z11, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = z10.a;
        double d13 = z10.b;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d14 = z11.a;
        double d15 = z11.b;
        Calib3d.fisheye_estimateNewCameraMatrixForUndistortRectify_0(l10, l11, d12, d13, l12, l13, d10, d14, d15, d11);
    }

    public static int a2(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, boolean bl2) {
        Object object = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = ((Mat)object).a;
        long l15 = mat5.a;
        int n10 = Calib3d.solvePnPGeneric_4(l10, l11, l12, l13, l14, l15, bl2);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat5, list2);
        mat5.u0();
        return n10;
    }

    public static double[] b(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Calib3d.RQDecomp3x3_2(l10, l11, l12, l13);
    }

    public static int b0(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Calib3d.estimateAffine3D_1(l10, l11, l12, l13, d10);
    }

    public static void b1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, int n10, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.fisheye_initUndistortRectifyMap_0(l10, l11, l12, l13, d10, d11, n10, l14, l15);
    }

    public static int b2(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, boolean bl2, int n10) {
        Object object = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = ((Mat)object).a;
        long l15 = mat5.a;
        int n11 = Calib3d.solvePnPGeneric_3(l10, l11, l12, l13, l14, l15, bl2, n10);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat5, list2);
        mat5.u0();
        return n11;
    }

    public static double[] c(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        return Calib3d.RQDecomp3x3_1(l10, l11, l12, l13, l14);
    }

    public static int c0(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Calib3d.estimateAffine3D_0(l10, l11, l12, l13, d10, d11);
    }

    public static void c1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.fisheye_projectPoints_2(l10, l11, l12, l13, l14, l15);
    }

    public static int c2(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, boolean bl2, int n10, Mat mat5) {
        Object object = new Mat();
        Mat mat6 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = ((Mat)object).a;
        long l15 = mat6.a;
        long l16 = mat5.a;
        int n11 = Calib3d.solvePnPGeneric_2(l10, l11, l12, l13, l14, l15, bl2, n10, l16);
        i.f.h.a.c((Mat)object, list);
        ((Mat)object).u0();
        object = list2;
        i.f.h.a.c(mat6, list2);
        mat6.u0();
        return n11;
    }

    private static native double calibrateCameraExtended_0(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20, int var22, int var23, int var24, double var25);

    private static native double calibrateCameraExtended_1(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20, int var22);

    private static native double calibrateCameraExtended_2(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20);

    private static native double calibrateCameraROExtended_0(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17, long var19, long var21, long var23, long var25, int var27, int var28, int var29, double var30);

    private static native double calibrateCameraROExtended_1(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17, long var19, long var21, long var23, long var25, int var27);

    private static native double calibrateCameraROExtended_2(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17, long var19, long var21, long var23, long var25);

    private static native double calibrateCameraRO_0(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17, int var19, int var20, int var21, double var22);

    private static native double calibrateCameraRO_1(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17, int var19);

    private static native double calibrateCameraRO_2(long var0, long var2, double var4, double var6, int var8, long var9, long var11, long var13, long var15, long var17);

    private static native double calibrateCamera_0(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, int var16, int var17, int var18, double var19);

    private static native double calibrateCamera_1(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, int var16);

    private static native double calibrateCamera_2(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14);

    private static native void calibrateHandEye_0(long var0, long var2, long var4, long var6, long var8, long var10, int var12);

    private static native void calibrateHandEye_1(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void calibrationMatrixValues_0(long var0, double var2, double var4, double var6, double var8, double[] var10, double[] var11, double[] var12, double[] var13, double[] var14);

    private static native boolean checkChessboard_0(long var0, double var2, double var4);

    private static native void composeRT_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, long var26);

    private static native void composeRT_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24);

    private static native void composeRT_2(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20, long var22);

    private static native void composeRT_3(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16, long var18, long var20);

    private static native void composeRT_4(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16, long var18);

    private static native void composeRT_5(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, long var16);

    private static native void composeRT_6(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14);

    private static native void composeRT_7(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native void composeRT_8(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void computeCorrespondEpilines_0(long var0, int var2, long var3, long var5);

    private static native void convertPointsFromHomogeneous_0(long var0, long var2);

    private static native void convertPointsToHomogeneous_0(long var0, long var2);

    private static native void correctMatches_0(long var0, long var2, long var4, long var6, long var8);

    public static double[] d(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        return Calib3d.RQDecomp3x3_0(l10, l11, l12, l13, l14, l15);
    }

    public static Mat d0(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = Calib3d.estimateAffinePartial2D_6(l10, l11);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static void d1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.fisheye_projectPoints_1(l10, l11, l12, l13, l14, l15, d10);
    }

    public static int d2(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, boolean bl2, int n10, Mat mat5, Mat mat6) {
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat7.a;
        long l15 = mat8.a;
        Mat mat9 = mat7;
        mat7 = mat5;
        long l16 = mat5.a;
        long l17 = l10;
        long l18 = mat6.a;
        l10 = l17;
        int n11 = Calib3d.solvePnPGeneric_1(l17, l11, l12, l13, l14, l15, bl2, n10, l16, l18);
        i.f.h.a.c(mat9, list);
        mat9.u0();
        i.f.h.a.c(mat8, list2);
        mat8.u0();
        return n11;
    }

    private static native void decomposeEssentialMat_0(long var0, long var2, long var4, long var6);

    private static native int decomposeHomographyMat_0(long var0, long var2, long var4, long var6, long var8);

    private static native void decomposeProjectionMatrix_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14);

    private static native void decomposeProjectionMatrix_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native void decomposeProjectionMatrix_2(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void decomposeProjectionMatrix_3(long var0, long var2, long var4, long var6, long var8);

    private static native void decomposeProjectionMatrix_4(long var0, long var2, long var4, long var6);

    private static native void drawChessboardCorners_0(long var0, double var2, double var4, long var6, boolean var8);

    private static native void drawFrameAxes_0(long var0, long var2, long var4, long var6, long var8, float var10, int var11);

    private static native void drawFrameAxes_1(long var0, long var2, long var4, long var6, long var8, float var10);

    public static void e(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.Rodrigues_1(l10, l11);
    }

    public static Mat e0(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffinePartial2D_5(l10, l11, l12);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static void e1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d10, Mat mat7) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        Calib3d.fisheye_projectPoints_0(l10, l11, l12, l13, l14, l15, d10, l16);
    }

    public static int e2(Mat mat, Mat mat2, Mat mat3, Mat mat4, List list, List list2, boolean bl2, int n10, Mat mat5, Mat mat6, Mat mat7) {
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat8.a;
        long l15 = mat9.a;
        Mat mat10 = mat8;
        mat8 = mat5;
        long l16 = mat5.a;
        long l17 = l10;
        long l18 = mat6.a;
        long l19 = mat7.a;
        l10 = l17;
        int n11 = Calib3d.solvePnPGeneric_0(l17, l11, l12, l13, l14, l15, bl2, n10, l16, l18, l19);
        i.f.h.a.c(mat10, list);
        mat10.u0();
        i.f.h.a.c(mat9, list2);
        mat9.u0();
        return n11;
    }

    private static native long estimateAffine2D_0(long var0, long var2, long var4, int var6, double var7, long var9, double var11, long var13);

    private static native long estimateAffine2D_1(long var0, long var2, long var4, int var6, double var7, long var9, double var11);

    private static native long estimateAffine2D_2(long var0, long var2, long var4, int var6, double var7, long var9);

    private static native long estimateAffine2D_3(long var0, long var2, long var4, int var6, double var7);

    private static native long estimateAffine2D_4(long var0, long var2, long var4, int var6);

    private static native long estimateAffine2D_5(long var0, long var2, long var4);

    private static native long estimateAffine2D_6(long var0, long var2);

    private static native int estimateAffine3D_0(long var0, long var2, long var4, long var6, double var8, double var10);

    private static native int estimateAffine3D_1(long var0, long var2, long var4, long var6, double var8);

    private static native int estimateAffine3D_2(long var0, long var2, long var4, long var6);

    private static native long estimateAffinePartial2D_0(long var0, long var2, long var4, int var6, double var7, long var9, double var11, long var13);

    private static native long estimateAffinePartial2D_1(long var0, long var2, long var4, int var6, double var7, long var9, double var11);

    private static native long estimateAffinePartial2D_2(long var0, long var2, long var4, int var6, double var7, long var9);

    private static native long estimateAffinePartial2D_3(long var0, long var2, long var4, int var6, double var7);

    private static native long estimateAffinePartial2D_4(long var0, long var2, long var4, int var6);

    private static native long estimateAffinePartial2D_5(long var0, long var2, long var4);

    private static native long estimateAffinePartial2D_6(long var0, long var2);

    public static void f(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Calib3d.Rodrigues_0(l10, l11, l12);
    }

    public static Mat f0(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffinePartial2D_4(l10, l11, l12, n10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static double f1(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6) {
        Mat mat7 = i.f.h.a.A(list);
        Mat mat8 = i.f.h.a.A(list2);
        Mat mat9 = i.f.h.a.A(list3);
        long l10 = mat7.a;
        long l11 = mat8.a;
        long l12 = mat9.a;
        mat7 = mat;
        long l13 = mat.a;
        mat7 = mat2;
        long l14 = mat2.a;
        mat7 = mat3;
        long l15 = mat3.a;
        mat7 = mat4;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        return Calib3d.fisheye_stereoCalibrate_2(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18);
    }

    public static boolean f2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnPRansac_6(l10, l11, l12, l13, l14, l15);
    }

    private static native void filterHomographyDecompByVisibleRefpoints_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void filterHomographyDecompByVisibleRefpoints_1(long var0, long var2, long var4, long var6, long var8);

    private static native void filterSpeckles_0(long var0, double var2, int var4, double var5, long var7);

    private static native void filterSpeckles_1(long var0, double var2, int var4, double var5);

    private static native boolean find4QuadCornerSubpix_0(long var0, long var2, double var4, double var6);

    private static native boolean findChessboardCornersSB_0(long var0, double var2, double var4, long var6, int var8);

    private static native boolean findChessboardCornersSB_1(long var0, double var2, double var4, long var6);

    private static native boolean findChessboardCorners_0(long var0, double var2, double var4, long var6, int var8);

    private static native boolean findChessboardCorners_1(long var0, double var2, double var4, long var6);

    private static native boolean findCirclesGrid_0(long var0, double var2, double var4, long var6, int var8);

    private static native boolean findCirclesGrid_2(long var0, double var2, double var4, long var6);

    private static native long findEssentialMat_0(long var0, long var2, long var4, int var6, double var7, double var9, long var11);

    private static native long findEssentialMat_1(long var0, long var2, long var4, int var6, double var7, double var9);

    private static native long findEssentialMat_10(long var0, long var2, double var4);

    private static native long findEssentialMat_11(long var0, long var2);

    private static native long findEssentialMat_2(long var0, long var2, long var4, int var6, double var7);

    private static native long findEssentialMat_3(long var0, long var2, long var4, int var6);

    private static native long findEssentialMat_4(long var0, long var2, long var4);

    private static native long findEssentialMat_5(long var0, long var2, double var4, double var6, double var8, int var10, double var11, double var13, long var15);

    private static native long findEssentialMat_6(long var0, long var2, double var4, double var6, double var8, int var10, double var11, double var13);

    private static native long findEssentialMat_7(long var0, long var2, double var4, double var6, double var8, int var10, double var11);

    private static native long findEssentialMat_8(long var0, long var2, double var4, double var6, double var8, int var10);

    private static native long findEssentialMat_9(long var0, long var2, double var4, double var6, double var8);

    private static native long findFundamentalMat_0(long var0, long var2, int var4, double var5, double var7, long var9);

    private static native long findFundamentalMat_1(long var0, long var2, int var4, double var5, double var7);

    private static native long findFundamentalMat_2(long var0, long var2, int var4, double var5);

    private static native long findFundamentalMat_3(long var0, long var2, int var4);

    private static native long findFundamentalMat_4(long var0, long var2);

    private static native long findHomography_0(long var0, long var2, int var4, double var5, long var7, int var9, double var10);

    private static native long findHomography_1(long var0, long var2, int var4, double var5, long var7, int var9);

    private static native long findHomography_2(long var0, long var2, int var4, double var5, long var7);

    private static native long findHomography_3(long var0, long var2, int var4, double var5);

    private static native long findHomography_4(long var0, long var2, int var4);

    private static native long findHomography_5(long var0, long var2);

    private static native double fisheye_calibrate_0(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, int var16, int var17, int var18, double var19);

    private static native double fisheye_calibrate_1(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14, int var16);

    private static native double fisheye_calibrate_2(long var0, long var2, double var4, double var6, long var8, long var10, long var12, long var14);

    private static native void fisheye_distortPoints_0(long var0, long var2, long var4, long var6, double var8);

    private static native void fisheye_distortPoints_1(long var0, long var2, long var4, long var6);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_0(long var0, long var2, double var4, double var6, long var8, long var10, double var12, double var14, double var16, double var18);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_1(long var0, long var2, double var4, double var6, long var8, long var10, double var12, double var14, double var16);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_2(long var0, long var2, double var4, double var6, long var8, long var10, double var12);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_3(long var0, long var2, double var4, double var6, long var8, long var10);

    private static native void fisheye_initUndistortRectifyMap_0(long var0, long var2, long var4, long var6, double var8, double var10, int var12, long var13, long var15);

    private static native void fisheye_projectPoints_0(long var0, long var2, long var4, long var6, long var8, long var10, double var12, long var14);

    private static native void fisheye_projectPoints_1(long var0, long var2, long var4, long var6, long var8, long var10, double var12);

    private static native void fisheye_projectPoints_2(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native double fisheye_stereoCalibrate_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, int var22, int var23, int var24, double var25);

    private static native double fisheye_stereoCalibrate_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, int var22);

    private static native double fisheye_stereoCalibrate_2(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20);

    private static native void fisheye_stereoRectify_0(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29, double var31, double var33);

    private static native void fisheye_stereoRectify_1(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29, double var31);

    private static native void fisheye_stereoRectify_2(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29);

    private static native void fisheye_stereoRectify_3(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26);

    private static native void fisheye_undistortImage_0(long var0, long var2, long var4, long var6, long var8, double var10, double var12);

    private static native void fisheye_undistortImage_1(long var0, long var2, long var4, long var6, long var8);

    private static native void fisheye_undistortImage_2(long var0, long var2, long var4, long var6);

    private static native void fisheye_undistortPoints_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void fisheye_undistortPoints_1(long var0, long var2, long var4, long var6, long var8);

    private static native void fisheye_undistortPoints_2(long var0, long var2, long var4, long var6);

    public static double g(List object, List list, z z10, Mat mat, Mat mat2, List list2, List list3) {
        Mat mat3 = i.f.h.a.A((List)object);
        Object object2 = i.f.h.a.A(list);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat3.a;
        long l11 = ((Mat)object2).a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat4.a;
        object = mat4;
        long l15 = mat5.a;
        double d12 = Calib3d.calibrateCamera_2(l10, l11, d10, d11, l12, l13, l14, l15);
        object2 = list2;
        i.f.h.a.c(mat4, list2);
        mat4.u0();
        object2 = list3;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        return d12;
    }

    public static Mat g0(Mat mat, Mat mat2, Mat mat3, int n10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = Calib3d.estimateAffinePartial2D_3(l10, l11, l12, n10, d10);
        Mat mat4 = new Mat(l13);
        return mat4;
    }

    public static double g1(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, int n10) {
        Mat mat7 = i.f.h.a.A(list);
        Mat mat8 = i.f.h.a.A(list2);
        Mat mat9 = i.f.h.a.A(list3);
        long l10 = mat7.a;
        long l11 = mat8.a;
        long l12 = mat9.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        return Calib3d.fisheye_stereoCalibrate_1(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18, n10);
    }

    public static boolean g2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnPRansac_5(l10, l11, l12, l13, l14, l15, bl2);
    }

    private static native long getDefaultNewCameraMatrix_0(long var0, double var2, double var4, boolean var6);

    private static native long getDefaultNewCameraMatrix_1(long var0, double var2, double var4);

    private static native long getDefaultNewCameraMatrix_2(long var0);

    private static native long getOptimalNewCameraMatrix_0(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double[] var14, boolean var15);

    private static native long getOptimalNewCameraMatrix_1(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double[] var14);

    private static native long getOptimalNewCameraMatrix_2(long var0, long var2, double var4, double var6, double var8, double var10, double var12);

    private static native long getOptimalNewCameraMatrix_3(long var0, long var2, double var4, double var6, double var8);

    private static native double[] getValidDisparityROI_0(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public static double h(List object, List list, z object2, Mat mat, Mat mat2, List list2, List list3, int n10) {
        Mat mat3 = i.f.h.a.A((List)object);
        Object object3 = i.f.h.a.A(list);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        long l10 = mat3.a;
        long l11 = ((Mat)object3).a;
        double d10 = ((z)object2).a;
        double d11 = ((z)object2).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        object = mat5;
        long l14 = mat4.a;
        long l15 = l10;
        l10 = mat5.a;
        object2 = mat5;
        long l16 = l10;
        l10 = l15;
        double d12 = Calib3d.calibrateCamera_1(l15, l11, d10, d11, l12, l13, l14, l16, n10);
        object3 = list2;
        i.f.h.a.c(mat4, list2);
        mat4.u0();
        object3 = mat5;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        return d12;
    }

    public static Mat h0(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10) {
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        l11 = Calib3d.estimateAffinePartial2D_2(l11, l12, l13, n10, d10, l10);
        Mat mat4 = new Mat(l11);
        return mat4;
    }

    public static double h1(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, int n10, a0 a02) {
        Mat mat7 = i.f.h.a.A(list);
        Mat mat8 = i.f.h.a.A(list2);
        Mat mat9 = i.f.h.a.A(list3);
        long l10 = mat7.a;
        long l11 = mat8.a;
        long l12 = mat9.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        long l17 = l10;
        double d10 = z10.a;
        double d11 = z10.b;
        long l18 = mat5.a;
        long l19 = mat6.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l17;
        return Calib3d.fisheye_stereoCalibrate_0(l17, l11, l12, l13, l14, l15, l16, d10, d11, l18, l19, n10, n11, n12, d12);
    }

    public static boolean h2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnPRansac_4(l10, l11, l12, l13, l14, l15, bl2, n10);
    }

    public static double i(List list, List list2, z object, Mat mat, Mat mat2, List list3, List list4, int n10, a0 a02) {
        Mat mat3 = i.f.h.a.A(list);
        Mat mat4 = i.f.h.a.A(list2);
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        long l10 = mat3.a;
        long l11 = mat4.a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = l10;
        l10 = mat5.a;
        object = mat5;
        long l15 = l10;
        long l16 = mat6.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l14;
        d12 = Calib3d.calibrateCamera_0(l14, l11, d10, d11, l12, l13, l15, l16, n10, n11, n12, d12);
        mat4 = mat5;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        i.f.h.a.c(mat6, list4);
        mat6.u0();
        return d12;
    }

    public static Mat i0(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10, double d11) {
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        l11 = Calib3d.estimateAffinePartial2D_1(l11, l12, l13, n10, d10, l10, d11);
        Mat mat4 = new Mat(l11);
        return mat4;
    }

    public static void i1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        Calib3d.fisheye_stereoRectify_3(l10, l11, l12, l13, d10, d11, l14, l15, l16, l17, l18, l19, l20, n10);
    }

    public static boolean i2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10, float f11) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnPRansac_3(l10, l11, l12, l13, l14, l15, bl2, n10, f11);
    }

    private static native long initCameraMatrix2D_0(long var0, long var2, double var4, double var6, double var8);

    private static native long initCameraMatrix2D_1(long var0, long var2, double var4, double var6);

    private static native void initUndistortRectifyMap_0(long var0, long var2, long var4, long var6, double var8, double var10, int var12, long var13, long var15);

    public static double j(List list, List list2, z z10, Mat mat, Mat mat2, List list3, List list4, Mat mat3, Mat mat4, Mat mat5) {
        Mat mat6 = i.f.h.a.A(list);
        Object object = i.f.h.a.A(list2);
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        long l10 = mat6.a;
        long l11 = ((Mat)object).a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat7.a;
        long l15 = mat8.a;
        long l16 = mat3.a;
        long l17 = mat4.a;
        long l18 = mat5.a;
        double d12 = Calib3d.calibrateCameraExtended_2(l10, l11, d10, d11, l12, l13, l14, l15, l16, l17, l18);
        object = list3;
        i.f.h.a.c(mat7, list3);
        mat7.u0();
        object = list4;
        i.f.h.a.c(mat8, list4);
        mat8.u0();
        return d12;
    }

    public static Mat j0(Mat mat, Mat mat2, Mat mat3, int n10, double d10, long l10, double d11, long l11) {
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        l12 = Calib3d.estimateAffinePartial2D_0(l12, l13, l14, n10, d10, l10, d11, l11);
        Mat mat4 = new Mat(l12);
        return mat4;
    }

    public static void j1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, z z11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = l10;
        long l16 = mat6.a;
        long l17 = mat7.a;
        long l18 = mat8.a;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        double d12 = z11.a;
        double d13 = z11.b;
        l10 = l15;
        Calib3d.fisheye_stereoRectify_2(l15, l11, l12, l13, d10, d11, l14, l16, l17, l18, l19, l20, l21, n10, d12, d13);
    }

    public static boolean j2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10, float f11, double d10) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        return Calib3d.solvePnPRansac_2(l10, l11, l12, l13, l14, l15, bl2, n10, f11, d10);
    }

    public static double k(List object, List list, z object2, Mat mat, Mat mat2, List list2, List list3, Mat mat3, Mat mat4, Mat mat5, int n10) {
        Mat mat6 = i.f.h.a.A((List)object);
        Object object3 = i.f.h.a.A(list);
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        long l10 = mat6.a;
        long l11 = ((Mat)object3).a;
        double d10 = ((z)object2).a;
        double d11 = ((z)object2).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        object = mat8;
        long l14 = mat7.a;
        long l15 = l10;
        l10 = mat8.a;
        object2 = mat8;
        long l16 = l10;
        mat6 = mat3;
        long l17 = mat3.a;
        mat6 = mat4;
        long l18 = mat4.a;
        mat6 = mat5;
        long l19 = mat5.a;
        l10 = l15;
        double d12 = Calib3d.calibrateCameraExtended_1(l15, l11, d10, d11, l12, l13, l14, l16, l17, l18, l19, n10);
        object3 = list2;
        i.f.h.a.c(mat7, list2);
        mat7.u0();
        object3 = mat8;
        i.f.h.a.c(mat8, list3);
        mat8.u0();
        return d12;
    }

    public static void k0(List object, List object2, Mat mat, Mat mat2, Mat mat3) {
        object = i.f.h.a.A((List)object);
        object2 = i.f.h.a.A((List)object2);
        long l10 = ((Mat)object).a;
        long l11 = ((Mat)object2).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        Calib3d.filterHomographyDecompByVisibleRefpoints_1(l10, l11, l12, l13, l14);
    }

    public static void k1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, z z11, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l14 = mat5.a;
        long l15 = l10;
        long l16 = mat6.a;
        long l17 = mat7.a;
        long l18 = mat8.a;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        double d13 = z11.a;
        double d14 = z11.b;
        l10 = l15;
        Calib3d.fisheye_stereoRectify_1(l15, l11, l12, l13, d11, d12, l14, l16, l17, l18, l19, l20, l21, n10, d13, d14, d10);
    }

    public static boolean k2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10, float f11, double d10, Mat mat4) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = l10;
        long l17 = mat4.a;
        l10 = l16;
        return Calib3d.solvePnPRansac_1(l16, l11, l12, l13, l14, l15, bl2, n10, f11, d10, l17);
    }

    public static double l(List list, List list2, z object, Mat mat, Mat mat2, List list3, List list4, Mat mat3, Mat mat4, Mat mat5, int n10, a0 a02) {
        Mat mat6 = i.f.h.a.A(list);
        Mat mat7 = i.f.h.a.A(list2);
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        long l10 = mat6.a;
        long l11 = mat7.a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = l10;
        l10 = mat8.a;
        object = mat8;
        long l15 = l10;
        long l16 = mat9.a;
        mat6 = mat3;
        long l17 = mat3.a;
        mat6 = mat4;
        long l18 = mat4.a;
        mat6 = mat5;
        long l19 = mat5.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l14;
        d12 = Calib3d.calibrateCameraExtended_0(l14, l11, d10, d11, l12, l13, l15, l16, l17, l18, l19, n10, n11, n12, d12);
        mat7 = mat8;
        i.f.h.a.c(mat8, list3);
        mat8.u0();
        i.f.h.a.c(mat9, list4);
        mat9.u0();
        return d12;
    }

    public static void l0(List list, List list2, Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        Mat mat5 = i.f.h.a.A(list);
        Mat mat6 = i.f.h.a.A(list2);
        long l10 = mat5.a;
        long l11 = mat6.a;
        mat5 = mat;
        long l12 = mat.a;
        mat5 = mat2;
        long l13 = mat2.a;
        mat5 = mat3;
        long l14 = mat3.a;
        mat5 = mat4;
        long l15 = mat4.a;
        Calib3d.filterHomographyDecompByVisibleRefpoints_0(l10, l11, l12, l13, l14, l15);
    }

    public static void l1(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, z z11, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d12 = z10.a;
        double d13 = z10.b;
        long l14 = mat5.a;
        long l15 = l10;
        long l16 = mat6.a;
        long l17 = mat7.a;
        long l18 = mat8.a;
        long l19 = mat9.a;
        long l20 = mat10.a;
        long l21 = mat11.a;
        double d14 = z11.a;
        double d15 = z11.b;
        l10 = l15;
        Calib3d.fisheye_stereoRectify_0(l15, l11, l12, l13, d12, d13, l14, l16, l17, l18, l19, l20, l21, n10, d14, d15, d10, d11);
    }

    public static boolean l2(o o10, m m10, Mat mat, f f10, Mat mat2, Mat mat3, boolean bl2, int n10, float f11, double d10, Mat mat4, int n11) {
        long l10 = o10.a;
        long l11 = m10.a;
        long l12 = mat.a;
        long l13 = f10.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = l10;
        long l17 = mat4.a;
        l10 = l16;
        return Calib3d.solvePnPRansac_0(l16, l11, l12, l13, l14, l15, bl2, n10, f11, d10, l17, n11);
    }

    public static double m(List list, List list2, z object, int n10, Mat mat, Mat mat2, List list3, List list4, Mat mat3) {
        Mat mat4 = i.f.h.a.A(list);
        Object object2 = i.f.h.a.A(list2);
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        long l10 = mat4.a;
        long l11 = ((Mat)object2).a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat5.a;
        object = mat5;
        long l15 = l14;
        long l16 = mat6.a;
        l14 = mat3.a;
        double d12 = Calib3d.calibrateCameraRO_2(l10, l11, d10, d11, n10, l12, l13, l15, l16, l14);
        object2 = list3;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        object2 = mat6;
        i.f.h.a.c(mat6, list4);
        mat6.u0();
        return d12;
    }

    public static void m0(Mat mat, double d10, int n10, double d11) {
        Calib3d.filterSpeckles_1(mat.a, d10, n10, d11);
    }

    public static void m1(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_undistortImage_2(l10, l11, l12, l13);
    }

    public static void m2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.solvePnPRefineLM_1(l10, l11, l12, l13, l14, l15);
    }

    private static native void matMulDeriv_0(long var0, long var2, long var4, long var6);

    public static double n(List list, List list2, z object, int n10, Mat mat, Mat mat2, List list3, List list4, Mat mat3, int n11) {
        Mat mat4 = i.f.h.a.A(list);
        Object object2 = i.f.h.a.A(list2);
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        long l10 = mat4.a;
        long l11 = ((Mat)object2).a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat5.a;
        object = mat5;
        long l15 = l14;
        long l16 = mat6.a;
        l14 = mat3.a;
        double d12 = Calib3d.calibrateCameraRO_1(l10, l11, d10, d11, n10, l12, l13, l15, l16, l14, n11);
        object2 = list3;
        i.f.h.a.c(mat5, list3);
        mat5.u0();
        object2 = mat6;
        i.f.h.a.c(mat6, list4);
        mat6.u0();
        return d12;
    }

    public static void n0(Mat mat, double d10, int n10, double d11, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Calib3d.filterSpeckles_0(l10, d10, n10, d11, l11);
    }

    public static void n1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.fisheye_undistortImage_1(l10, l11, l12, l13, l14);
    }

    public static void n2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        long l16 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        Calib3d.solvePnPRefineLM_0(l16, l10, l11, l12, l13, l15, n10, n11, d10);
    }

    public static double o(List object, List list, z z10, int n10, Mat mat, Mat mat2, List list2, List list3, Mat mat3, int n11, a0 a02) {
        Mat mat4 = i.f.h.a.A((List)object);
        Mat mat5 = i.f.h.a.A(list);
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        long l10 = mat4.a;
        long l11 = mat5.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat.a;
        object = mat7;
        long l13 = mat2.a;
        long l14 = l10;
        long l15 = mat6.a;
        long l16 = mat7.a;
        mat4 = mat3;
        long l17 = mat3.a;
        int n12 = a02.a;
        int n13 = a02.b;
        double d12 = a02.c;
        l10 = l14;
        d12 = Calib3d.calibrateCameraRO_0(l14, l11, d10, d11, n10, l12, l13, l15, l16, l17, n11, n12, n13, d12);
        mat5 = mat6;
        i.f.h.a.c(mat6, list2);
        mat6.u0();
        i.f.h.a.c(mat7, list3);
        mat7.u0();
        return d12;
    }

    public static boolean o0(Mat mat, Mat mat2, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        return Calib3d.find4QuadCornerSubpix_0(l10, l11, d10, d11);
    }

    public static void o1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l15 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        double d12 = d10;
        d10 = d11;
        Calib3d.fisheye_undistortImage_0(l15, l10, l11, l12, l14, d12, d11);
    }

    public static void o2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.solvePnPRefineVVS_2(l10, l11, l12, l13, l14, l15);
    }

    public static double p(List list, List list2, z object, int n10, Mat mat, Mat mat2, List list3, List list4, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        Mat mat8 = i.f.h.a.A(list);
        Object object2 = i.f.h.a.A(list2);
        Mat mat9 = new Mat();
        Mat mat10 = new Mat();
        long l10 = mat8.a;
        long l11 = ((Mat)object2).a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat9.a;
        object = mat9;
        long l15 = l14;
        long l16 = mat10.a;
        long l17 = mat3.a;
        long l18 = mat4.a;
        long l19 = mat5.a;
        long l20 = mat6.a;
        l14 = mat7.a;
        double d12 = Calib3d.calibrateCameraROExtended_2(l10, l11, d10, d11, n10, l12, l13, l15, l16, l17, l18, l19, l20, l14);
        object2 = list3;
        i.f.h.a.c(mat9, list3);
        mat9.u0();
        object2 = mat10;
        i.f.h.a.c(mat10, list4);
        mat10.u0();
        return d12;
    }

    public static boolean p0(Mat mat, z z10, m m10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = m10.a;
        return Calib3d.findChessboardCorners_1(l10, d10, d11, l11);
    }

    public static void p1(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Calib3d.fisheye_undistortPoints_2(l10, l11, l12, l13);
    }

    public static void p2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        long l16 = l10;
        l10 = l11;
        l11 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        Calib3d.solvePnPRefineVVS_1(l16, l10, l11, l12, l13, l15, n10, n11, d10);
    }

    private static native void projectPoints_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14);

    private static native void projectPoints_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native void projectPoints_2(long var0, long var2, long var4, long var6, long var8, long var10);

    public static double q(List list, List list2, z object, int n10, Mat mat, Mat mat2, List list3, List list4, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, int n11) {
        Mat mat8 = i.f.h.a.A(list);
        Object object2 = i.f.h.a.A(list2);
        Mat mat9 = new Mat();
        Mat mat10 = new Mat();
        long l10 = mat8.a;
        long l11 = ((Mat)object2).a;
        double d10 = ((z)object).a;
        double d11 = ((z)object).b;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat9.a;
        object = mat9;
        long l15 = l14;
        long l16 = mat10.a;
        long l17 = mat3.a;
        long l18 = mat4.a;
        long l19 = mat5.a;
        long l20 = mat6.a;
        l14 = mat7.a;
        double d12 = Calib3d.calibrateCameraROExtended_1(l10, l11, d10, d11, n10, l12, l13, l15, l16, l17, l18, l19, l20, l14, n11);
        object2 = list3;
        i.f.h.a.c(mat9, list3);
        mat9.u0();
        object2 = mat10;
        i.f.h.a.c(mat10, list4);
        mat10.u0();
        return d12;
    }

    public static boolean q0(Mat mat, z z10, m m10, int n10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = m10.a;
        return Calib3d.findChessboardCorners_0(l10, d10, d11, l11, n10);
    }

    public static void q1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        Calib3d.fisheye_undistortPoints_1(l10, l11, l12, l13, l14);
    }

    public static void q2(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, a0 a02, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d11 = a02.c;
        Calib3d.solvePnPRefineVVS_0(l10, l11, l12, l13, l14, l15, n10, n11, d11, d10);
    }

    public static double r(List object, List list, z z10, int n10, Mat mat, Mat mat2, List list2, List list3, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, int n11, a0 a02) {
        Mat mat8 = i.f.h.a.A((List)object);
        Mat mat9 = i.f.h.a.A(list);
        Mat mat10 = new Mat();
        Mat mat11 = new Mat();
        long l10 = mat8.a;
        long l11 = mat9.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l12 = mat.a;
        object = mat11;
        long l13 = mat2.a;
        long l14 = l10;
        long l15 = mat10.a;
        long l16 = mat11.a;
        mat8 = mat3;
        long l17 = mat3.a;
        mat8 = mat4;
        long l18 = mat4.a;
        mat8 = mat5;
        long l19 = mat5.a;
        mat8 = mat6;
        long l20 = mat6.a;
        mat8 = mat7;
        long l21 = mat7.a;
        int n12 = a02.a;
        int n13 = a02.b;
        double d12 = a02.c;
        l10 = l14;
        d12 = Calib3d.calibrateCameraROExtended_0(l14, l11, d10, d11, n10, l12, l13, l15, l16, l17, l18, l19, l20, l21, n11, n12, n13, d12);
        mat9 = mat10;
        i.f.h.a.c(mat10, list2);
        mat10.u0();
        i.f.h.a.c(mat11, list3);
        mat11.u0();
        return d12;
    }

    public static boolean r0(Mat mat, z z10, Mat mat2) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat2.a;
        return Calib3d.findChessboardCornersSB_1(l10, d10, d11, l11);
    }

    public static void r1(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.fisheye_undistortPoints_0(l10, l11, l12, l13, l14, l15);
    }

    public static double r2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        Mat mat9 = i.f.h.a.A(list);
        Mat mat10 = i.f.h.a.A(list2);
        Mat mat11 = i.f.h.a.A(list3);
        long l10 = mat9.a;
        long l11 = mat10.a;
        long l12 = mat11.a;
        mat9 = mat;
        long l13 = mat.a;
        mat9 = mat2;
        long l14 = mat2.a;
        mat9 = mat3;
        long l15 = mat3.a;
        mat9 = mat4;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        long l19 = mat7.a;
        long l20 = mat8.a;
        return Calib3d.stereoCalibrate_2(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18, l19, l20);
    }

    private static native int recoverPose_0(long var0, long var2, long var4, long var6, long var8, double var10, double var12, double var14, long var16);

    private static native int recoverPose_1(long var0, long var2, long var4, long var6, long var8, double var10, double var12, double var14);

    private static native int recoverPose_2(long var0, long var2, long var4, long var6, long var8, double var10);

    private static native int recoverPose_3(long var0, long var2, long var4, long var6, long var8);

    private static native int recoverPose_4(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native int recoverPose_5(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native int recoverPose_6(long var0, long var2, long var4, long var6, long var8, long var10, double var12, long var14, long var16);

    private static native int recoverPose_7(long var0, long var2, long var4, long var6, long var8, long var10, double var12, long var14);

    private static native int recoverPose_8(long var0, long var2, long var4, long var6, long var8, long var10, double var12);

    private static native float rectify3Collinear_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, long var14, double var16, double var18, long var20, long var22, long var24, long var26, long var28, long var30, long var32, long var34, long var36, long var38, long var40, double var42, double var44, double var46, double[] var48, double[] var49, int var50);

    private static native void reprojectImageTo3D_0(long var0, long var2, long var4, boolean var6, int var7);

    private static native void reprojectImageTo3D_1(long var0, long var2, long var4, boolean var6);

    private static native void reprojectImageTo3D_2(long var0, long var2, long var4);

    public static void s(List list, List list2, List list3, List list4, Mat mat, Mat mat2) {
        Mat mat3 = i.f.h.a.A(list);
        Mat mat4 = i.f.h.a.A(list2);
        Mat mat5 = i.f.h.a.A(list3);
        Mat mat6 = i.f.h.a.A(list4);
        long l10 = mat3.a;
        long l11 = mat4.a;
        long l12 = mat5.a;
        long l13 = mat6.a;
        mat3 = mat;
        long l14 = mat.a;
        mat3 = mat2;
        long l15 = mat2.a;
        Calib3d.calibrateHandEye_1(l10, l11, l12, l13, l14, l15);
    }

    public static boolean s0(Mat mat, z z10, Mat mat2, int n10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat2.a;
        return Calib3d.findChessboardCornersSB_0(l10, d10, d11, l11, n10);
    }

    public static Mat s1(Mat mat) {
        long l10 = Calib3d.getDefaultNewCameraMatrix_2(mat.a);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static double s2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, int n10) {
        Mat mat9 = i.f.h.a.A(list);
        Mat mat10 = i.f.h.a.A(list2);
        Mat mat11 = i.f.h.a.A(list3);
        long l10 = mat9.a;
        long l11 = mat10.a;
        long l12 = mat11.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        long l19 = mat7.a;
        long l20 = mat8.a;
        return Calib3d.stereoCalibrate_1(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18, l19, l20, n10);
    }

    private static native double sampsonDistance_0(long var0, long var2, long var4);

    private static native int solveP3P_0(long var0, long var2, long var4, long var6, long var8, long var10, int var12);

    private static native int solvePnPGeneric_0(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, long var14, long var16, long var18);

    private static native int solvePnPGeneric_1(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, long var14, long var16);

    private static native int solvePnPGeneric_2(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, long var14);

    private static native int solvePnPGeneric_3(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13);

    private static native int solvePnPGeneric_4(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12);

    private static native int solvePnPGeneric_5(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native boolean solvePnPRansac_0(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, float var14, double var15, long var17, int var19);

    private static native boolean solvePnPRansac_1(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, float var14, double var15, long var17);

    private static native boolean solvePnPRansac_2(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, float var14, double var15);

    private static native boolean solvePnPRansac_3(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13, float var14);

    private static native boolean solvePnPRansac_4(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13);

    private static native boolean solvePnPRansac_5(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12);

    private static native boolean solvePnPRansac_6(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void solvePnPRefineLM_0(long var0, long var2, long var4, long var6, long var8, long var10, int var12, int var13, double var14);

    private static native void solvePnPRefineLM_1(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void solvePnPRefineVVS_0(long var0, long var2, long var4, long var6, long var8, long var10, int var12, int var13, double var14, double var16);

    private static native void solvePnPRefineVVS_1(long var0, long var2, long var4, long var6, long var8, long var10, int var12, int var13, double var14);

    private static native void solvePnPRefineVVS_2(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native boolean solvePnP_0(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12, int var13);

    private static native boolean solvePnP_1(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12);

    private static native boolean solvePnP_2(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native double stereoCalibrateExtended_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24, long var26, int var28, int var29, int var30, double var31);

    private static native double stereoCalibrateExtended_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24, long var26, int var28);

    private static native double stereoCalibrateExtended_2(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24, long var26);

    private static native double stereoCalibrate_0(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24, int var26, int var27, int var28, double var29);

    private static native double stereoCalibrate_1(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24, int var26);

    private static native double stereoCalibrate_2(long var0, long var2, long var4, long var6, long var8, long var10, long var12, double var14, double var16, long var18, long var20, long var22, long var24);

    private static native boolean stereoRectifyUncalibrated_0(long var0, long var2, long var4, double var6, double var8, long var10, long var12, double var14);

    private static native boolean stereoRectifyUncalibrated_1(long var0, long var2, long var4, double var6, double var8, long var10, long var12);

    private static native void stereoRectify_0(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29, double var31, double[] var33, double[] var34);

    private static native void stereoRectify_1(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29, double var31, double[] var33);

    private static native void stereoRectify_2(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27, double var29, double var31);

    private static native void stereoRectify_3(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26, double var27);

    private static native void stereoRectify_4(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24, int var26);

    private static native void stereoRectify_5(long var0, long var2, long var4, long var6, double var8, double var10, long var12, long var14, long var16, long var18, long var20, long var22, long var24);

    public static void t(List list, List list2, List list3, List list4, Mat mat, Mat mat2, int n10) {
        Mat mat3 = i.f.h.a.A(list);
        Mat mat4 = i.f.h.a.A(list2);
        Mat mat5 = i.f.h.a.A(list3);
        Mat mat6 = i.f.h.a.A(list4);
        long l10 = mat3.a;
        long l11 = mat4.a;
        long l12 = mat5.a;
        long l13 = mat6.a;
        mat3 = mat;
        long l14 = mat.a;
        mat3 = mat2;
        long l15 = mat2.a;
        Calib3d.calibrateHandEye_0(l10, l11, l12, l13, l14, l15, n10);
    }

    public static boolean t0(Mat mat, z z10, Mat mat2) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat2.a;
        return Calib3d.findCirclesGrid_2(l10, d10, d11, l11);
    }

    public static Mat t1(Mat mat, z z10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = Calib3d.getDefaultNewCameraMatrix_1(l10, d10, d11);
        Mat mat2 = new Mat(l11);
        return mat2;
    }

    public static double t2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, int n10, a0 a02) {
        Mat mat9 = i.f.h.a.A(list);
        Mat mat10 = i.f.h.a.A(list2);
        Mat mat11 = i.f.h.a.A(list3);
        long l10 = mat9.a;
        long l11 = mat10.a;
        long l12 = mat11.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        long l17 = l10;
        double d10 = z10.a;
        double d11 = z10.b;
        long l18 = mat5.a;
        long l19 = mat6.a;
        long l20 = mat7.a;
        long l21 = mat8.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l17;
        return Calib3d.stereoCalibrate_0(l17, l11, l12, l13, l14, l15, l16, d10, d11, l18, l19, l20, l21, n10, n11, n12, d12);
    }

    private static native void triangulatePoints_0(long var0, long var2, long var4, long var6, long var8);

    public static void u(Mat mat, z z10, double d10, double d11, double[] dArray, double[] dArray2, double[] dArray3, u u10, double[] dArray4) {
        Object object;
        Object object2 = z10;
        u u11 = u10;
        int n10 = 1;
        double[] dArray5 = new double[n10];
        double[] dArray6 = new double[n10];
        double[] dArray7 = new double[n10];
        double[] dArray8 = new double[2];
        double[] dArray9 = new double[n10];
        long l10 = mat.a;
        double d12 = z10.a;
        double d13 = z10.b;
        object2 = dArray8;
        double[] dArray10 = dArray9;
        double[] dArray11 = dArray7;
        dArray7 = dArray5;
        double[] dArray12 = dArray6;
        dArray5 = dArray11;
        Calib3d.calibrationMatrixValues_0(l10, d12, d13, d10, d11, dArray7, dArray6, dArray11, dArray8, dArray9);
        if (dArray != null) {
            dArray[0] = object = dArray7[0];
        }
        if (dArray2 != null) {
            dArray2[0] = object = dArray12[0];
        }
        if (dArray3 != null) {
            dArray3[0] = object = dArray11[0];
        }
        if (u11 != null) {
            u11.a = object = (Object)object2[0];
            u11.b = object = (Object)object2[n10];
        }
        if (dArray4 != null) {
            double d14;
            dArray4[0] = d14 = dArray10[0];
        }
    }

    public static boolean u0(Mat mat, z z10, Mat mat2, int n10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat2.a;
        return Calib3d.findCirclesGrid_0(l10, d10, d11, l11, n10);
    }

    public static Mat u1(Mat mat, z z10, boolean bl2) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = Calib3d.getDefaultNewCameraMatrix_0(l10, d10, d11, bl2);
        Mat mat2 = new Mat(l11);
        return mat2;
    }

    public static double u2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9) {
        Mat mat10 = i.f.h.a.A(list);
        Mat mat11 = i.f.h.a.A(list2);
        Mat mat12 = i.f.h.a.A(list3);
        long l10 = mat10.a;
        long l11 = mat11.a;
        long l12 = mat12.a;
        mat10 = mat;
        long l13 = mat.a;
        mat10 = mat2;
        long l14 = mat2.a;
        mat10 = mat3;
        long l15 = mat3.a;
        mat10 = mat4;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        long l19 = mat7.a;
        long l20 = mat8.a;
        long l21 = mat9.a;
        return Calib3d.stereoCalibrateExtended_2(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18, l19, l20, l21);
    }

    private static native void undistortPointsIter_0(long var0, long var2, long var4, long var6, long var8, long var10, int var12, int var13, double var14);

    private static native void undistortPoints_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void undistortPoints_1(long var0, long var2, long var4, long var6, long var8);

    private static native void undistortPoints_2(long var0, long var2, long var4, long var6);

    private static native void undistort_0(long var0, long var2, long var4, long var6, long var8);

    private static native void undistort_1(long var0, long var2, long var4, long var6);

    public static boolean v(Mat mat, z z10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        return Calib3d.checkChessboard_0(l10, d10, d11);
    }

    public static Mat v0(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = Calib3d.findEssentialMat_11(l10, l11);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static Mat v1(Mat mat, Mat mat2, z z10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l12 = Calib3d.getOptimalNewCameraMatrix_3(l10, l11, d11, d12, d10);
        Mat mat3 = new Mat(l12);
        return mat3;
    }

    public static double v2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int n10) {
        Mat mat10 = i.f.h.a.A(list);
        Mat mat11 = i.f.h.a.A(list2);
        Mat mat12 = i.f.h.a.A(list3);
        long l10 = mat10.a;
        long l11 = mat11.a;
        long l12 = mat12.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l17 = mat5.a;
        long l18 = mat6.a;
        long l19 = mat7.a;
        long l20 = mat8.a;
        long l21 = mat9.a;
        return Calib3d.stereoCalibrateExtended_1(l10, l11, l12, l13, l14, l15, l16, d10, d11, l17, l18, l19, l20, l21, n10);
    }

    private static native void validateDisparity_0(long var0, long var2, int var4, int var5, int var6);

    private static native void validateDisparity_1(long var0, long var2, int var4, int var5);

    public static void w(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        Calib3d.composeRT_8(l10, l11, l12, l13, l14, l15);
    }

    public static Mat w0(Mat mat, Mat mat2, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = Calib3d.findEssentialMat_10(l10, l11, d10);
        Mat mat3 = new Mat(l12);
        return mat3;
    }

    public static Mat w1(Mat mat, Mat mat2, z z10, double d10, z z11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        long l12 = Calib3d.getOptimalNewCameraMatrix_2(l10, l11, d11, d12, d10, d13, d14);
        Mat mat3 = new Mat(l12);
        return mat3;
    }

    public static double w2(List list, List list2, List list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int n10, a0 a02) {
        Mat mat10 = i.f.h.a.A(list);
        Mat mat11 = i.f.h.a.A(list2);
        Mat mat12 = i.f.h.a.A(list3);
        long l10 = mat10.a;
        long l11 = mat11.a;
        long l12 = mat12.a;
        long l13 = mat.a;
        long l14 = mat2.a;
        long l15 = mat3.a;
        long l16 = mat4.a;
        long l17 = l10;
        double d10 = z10.a;
        double d11 = z10.b;
        long l18 = mat5.a;
        long l19 = mat6.a;
        long l20 = mat7.a;
        long l21 = mat8.a;
        long l22 = mat9.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        l10 = l17;
        return Calib3d.stereoCalibrateExtended_0(l17, l11, l12, l13, l14, l15, l16, d10, d11, l18, l19, l20, l21, l22, n10, n11, n12, d12);
    }

    public static void x(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        Calib3d.composeRT_7(l10, l11, l12, l13, l14, l15, l16);
    }

    public static Mat x0(Mat mat, Mat mat2, double d10, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = u10.a;
        double d12 = u10.b;
        long l12 = Calib3d.findEssentialMat_9(l10, l11, d10, d11, d12);
        Mat mat3 = new Mat(l12);
        return mat3;
    }

    public static Mat x1(Mat mat, Mat mat2, z z10, double d10, z z11, w w10) {
        Object object = z11;
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        double d15 = d13;
        d13 = d10;
        long l12 = Calib3d.getOptimalNewCameraMatrix_1(l10, l11, d11, d12, d10, d15, d14, dArray);
        Mat mat3 = new Mat(l12);
        object = mat3;
        if (w10 != null) {
            int n11;
            w10.a = n11 = (int)dArray[0];
            w10.b = n11 = (int)dArray[1];
            double d16 = dArray[2];
            w10.c = n11 = (int)d16;
            double d17 = dArray[3];
            w10.d = n11 = (int)d17;
        }
        return object;
    }

    public static void x2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        Calib3d.stereoRectify_5(l10, l11, l12, l13, d10, d11, l14, l15, l16, l17, l18, l19, l20);
    }

    public static void y(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        Calib3d.composeRT_6(l10, l11, l12, l13, l14, l15, l16, l17);
    }

    public static Mat y0(Mat mat, Mat mat2, double d10, u u10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = u10.a;
        double d12 = u10.b;
        l10 = Calib3d.findEssentialMat_8(l10, l11, d10, d11, d12, n10);
        Mat mat3 = new Mat(l10);
        return mat3;
    }

    public static Mat y1(Mat mat, Mat mat2, z z10, double d10, z z11, w w10, boolean bl2) {
        Object object = z11;
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        double d15 = d13;
        d13 = d10;
        long l12 = Calib3d.getOptimalNewCameraMatrix_0(l10, l11, d11, d12, d10, d15, d14, dArray, bl2);
        Mat mat3 = new Mat(l12);
        object = mat3;
        if (w10 != null) {
            int n11;
            w10.a = n11 = (int)dArray[0];
            w10.b = n11 = (int)dArray[1];
            double d16 = dArray[2];
            w10.c = n11 = (int)d16;
            double d17 = dArray[3];
            w10.d = n11 = (int)d17;
        }
        return object;
    }

    public static void y2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        Calib3d.stereoRectify_4(l10, l11, l12, l13, d10, d11, l14, l15, l16, l17, l18, l19, l20, n10);
    }

    public static void z(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = l10;
        long l19 = mat9.a;
        l10 = l18;
        Calib3d.composeRT_5(l18, l11, l12, l13, l14, l15, l16, l17, l19);
    }

    public static Mat z0(Mat mat, Mat mat2, double d10, u u10, int n10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = u10.a;
        double d13 = u10.b;
        l10 = Calib3d.findEssentialMat_7(l10, l11, d10, d12, d13, n10, d11);
        Mat mat3 = new Mat(l10);
        return mat3;
    }

    public static w z1(w w10, w w11, int n10, int n11, int n12) {
        Object object = w10;
        int n13 = w10.a;
        int n14 = w10.b;
        int n15 = w10.c;
        int n16 = w10.d;
        int n17 = w11.a;
        int n18 = w11.b;
        int n19 = w11.c;
        int n20 = w11.d;
        object = Calib3d.getValidDisparityROI_0(n13, n14, n15, n16, n17, n18, n19, n20, n10, n11, n12);
        w w12 = new w((double[])object);
        return w12;
    }

    public static void z2(Mat mat, Mat mat2, Mat mat3, Mat mat4, z z10, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int n10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l14 = mat5.a;
        long l15 = mat6.a;
        long l16 = mat7.a;
        long l17 = mat8.a;
        long l18 = mat9.a;
        long l19 = mat10.a;
        long l20 = mat11.a;
        Calib3d.stereoRectify_3(l10, l11, l12, l13, d11, d12, l14, l15, l16, l17, l18, l19, l20, n10, d10);
    }
}

