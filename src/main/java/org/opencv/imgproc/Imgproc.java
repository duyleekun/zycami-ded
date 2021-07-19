/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import i.f.c.a0;
import i.f.c.i;
import i.f.c.j;
import i.f.c.k;
import i.f.c.m;
import i.f.c.p;
import i.f.c.u;
import i.f.c.w;
import i.f.c.x;
import i.f.c.y;
import i.f.c.z;
import i.f.e.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.imgproc.CLAHE;
import org.opencv.imgproc.GeneralizedHoughBallard;
import org.opencv.imgproc.GeneralizedHoughGuil;
import org.opencv.imgproc.LineSegmentDetector;

public class Imgproc {
    private static final int A = 4;
    public static final int A0 = 4;
    public static final int A1 = 1;
    public static final int A2 = 52;
    public static final int A3 = 104;
    public static final int A4 = 128;
    public static final int A5 = 1;
    public static final int A6 = 100;
    private static final int B = 0;
    public static final int B0 = 5;
    public static final int B1 = 1;
    public static final int B2 = 53;
    public static final int B3 = 105;
    public static final int B4 = 127;
    public static final int B5 = 2;
    public static final int B6 = 0;
    private static final int C = 1;
    public static final int C0 = 6;
    public static final int C1 = 2;
    public static final int C2 = 54;
    public static final int C3 = 104;
    public static final int C4 = 128;
    public static final int C5 = 3;
    public static final int C6 = 1;
    private static final int D = 2;
    public static final int D0 = 7;
    public static final int D1 = 2;
    public static final int D2 = 55;
    public static final int D3 = 105;
    public static final int D4 = 129;
    public static final int D5 = 4;
    public static final int D6 = 2;
    private static final int E = 3;
    public static final int E0 = 8;
    public static final int E1 = 3;
    public static final int E2 = 56;
    public static final int E3 = 102;
    public static final int E4 = 130;
    public static final int E5 = 7;
    public static final int E6 = 3;
    private static final int F = 4;
    public static final int F0 = 9;
    public static final int F1 = 3;
    public static final int F2 = 57;
    public static final int F3 = 103;
    public static final int F4 = 129;
    public static final int F5 = 8;
    public static final int F6 = 0;
    private static final int G = 7;
    public static final int G0 = 10;
    public static final int G1 = 4;
    public static final int G2 = 58;
    public static final int G3 = 106;
    public static final int G4 = 130;
    public static final int G5 = 16;
    public static final int G6 = 1;
    private static final int H = 8;
    public static final int H0 = 11;
    public static final int H1 = 4;
    public static final int H2 = 59;
    public static final int H3 = 106;
    public static final int H4 = 131;
    public static final int H5 = 7;
    public static final int H6 = 2;
    private static final int I = 16;
    public static final int I0 = 12;
    public static final int I1 = 5;
    public static final int I2 = 60;
    public static final int I3 = 106;
    public static final int I4 = 132;
    public static final int I5 = 255;
    public static final int I6 = 0;
    public static final int J = 0;
    public static final int J0 = 13;
    public static final int J1 = 5;
    public static final int J2 = 61;
    public static final int J3 = 106;
    public static final int J4 = 133;
    public static final int J5 = 7;
    public static final int J6 = 1;
    public static final int K = 1;
    public static final int K0 = 14;
    public static final int K1 = 6;
    public static final int K2 = 66;
    public static final int K3 = 106;
    public static final int K4 = 134;
    public static final int K5 = 125;
    public static final int K6 = 255;
    public static final int L = 2;
    public static final int L0 = 15;
    public static final int L1 = 7;
    public static final int L2 = 67;
    public static final int L3 = 106;
    public static final int L4 = 46;
    public static final int L5 = 126;
    public static final int L6 = 1;
    public static final int M = 3;
    public static final int M0 = 16;
    public static final int M1 = 8;
    public static final int M2 = 68;
    public static final int M3 = 106;
    public static final int M4 = 47;
    public static final int M5 = 8;
    public static final int M6 = 2;
    public static final int N = 4;
    public static final int N0 = 17;
    public static final int N1 = 8;
    public static final int N2 = 69;
    public static final int N3 = 106;
    public static final int N4 = 48;
    public static final int N5 = 16;
    public static final int N6 = 3;
    public static final int O = 5;
    public static final int O0 = 18;
    public static final int O1 = 9;
    public static final int O2 = 70;
    public static final int O3 = 107;
    public static final int O4 = 49;
    public static final int O5 = 0;
    public static final int O6 = 4;
    public static final int P = 6;
    public static final int P0 = 19;
    public static final int P1 = 9;
    public static final int P2 = 71;
    public static final int P3 = 108;
    public static final int P4 = 48;
    public static final int P5 = 5;
    public static final int P6 = 5;
    public static final int Q = 7;
    public static final int Q0 = 20;
    public static final int Q1 = 10;
    public static final int Q2 = 72;
    public static final int Q3 = 107;
    public static final int Q4 = 49;
    public static final int Q5 = 0;
    public static final int Q6 = 6;
    public static final int R = 16;
    public static final int R0 = 0;
    public static final int R1 = 11;
    public static final int R2 = 73;
    public static final int R3 = 108;
    public static final int R4 = 46;
    public static final int R5 = 1;
    public static final int R6 = 7;
    public static final int S = 5;
    public static final int S0 = 1;
    public static final int S1 = 12;
    public static final int S2 = 74;
    public static final int S3 = 107;
    public static final int S4 = 47;
    public static final int S5 = 2;
    public static final int S6 = 0;
    public static final int T = 10;
    public static final int T0 = 2;
    public static final int T1 = 13;
    public static final int T2 = 75;
    public static final int T3 = 108;
    public static final int T4 = 86;
    public static final int T5 = 3;
    public static final int T6 = 1;
    public static final int U = 32;
    public static final int U0 = 3;
    public static final int U1 = 14;
    public static final int U2 = 76;
    public static final int U3 = 111;
    public static final int U4 = 87;
    public static final int U5 = 1;
    public static final int U6 = 2;
    public static final int V = 1024;
    public static final int V0 = 3;
    public static final int V1 = 15;
    public static final int V2 = 77;
    public static final int V3 = 112;
    public static final int V4 = 88;
    public static final int V5 = 2;
    public static final int V6 = 3;
    public static final int W = 0;
    public static final int W0 = 4;
    public static final int W1 = 16;
    public static final int W2 = 78;
    public static final int W3 = 111;
    public static final int W4 = 89;
    public static final int W5 = 0;
    public static final int W6 = 4;
    public static final int X = 1;
    public static final int X0 = 5;
    public static final int X1 = 17;
    public static final int X2 = 79;
    public static final int X3 = 112;
    public static final int X4 = 62;
    public static final int X5 = 1;
    public static final int X6 = 5;
    public static final int Y = 2;
    public static final int Y0 = 255;
    public static final int Y1 = 18;
    public static final int Y2 = 80;
    public static final int Y3 = 111;
    public static final int Y4 = 63;
    public static final int Y5 = 2;
    public static final int Y6 = 3;
    public static final int Z = 3;
    public static final int Z0 = 4;
    public static final int Z1 = 19;
    public static final int Z2 = 81;
    public static final int Z3 = 112;
    public static final int Z4 = 64;
    public static final int Z5 = 3;
    public static final int Z6 = 5;
    private static final int a = 0;
    public static final int a0 = 4;
    public static final int a1 = 8;
    public static final int a2 = 20;
    public static final int a3 = 82;
    public static final int a4 = 115;
    public static final int a5 = 65;
    public static final int a6 = 3;
    public static final int a7 = 0;
    private static final int b = 1;
    public static final int b0 = 5;
    public static final int b1 = 16;
    public static final int b2 = 21;
    public static final int b3 = 83;
    public static final int b4 = 116;
    public static final int b5 = 64;
    public static final int b6 = 4;
    public static final int b7 = 0;
    private static final int c = 2;
    public static final int c0 = 6;
    public static final int c1 = 0;
    public static final int c2 = 22;
    public static final int c3 = 84;
    public static final int c4 = 117;
    public static final int c5 = 65;
    public static final int c6 = 5;
    public static final int c7 = 1;
    private static final int d = 3;
    public static final int d0 = 7;
    public static final int d1 = 1;
    public static final int d2 = 23;
    public static final int d3 = 85;
    public static final int d4 = 118;
    public static final int d5 = 62;
    public static final int d6 = 3;
    public static final int d7 = 2;
    private static final int e = 4;
    public static final int e0 = 65536;
    public static final int e1 = 2;
    public static final int e2 = 24;
    public static final int e3 = 90;
    public static final int e4 = 115;
    public static final int e5 = 63;
    public static final int e6 = 5;
    public static final int e7 = 3;
    private static final int f = 5;
    public static final int f0 = 131072;
    public static final int f1 = 3;
    public static final int f2 = 25;
    public static final int f3 = 91;
    public static final int f4 = 116;
    public static final int f5 = 135;
    public static final int f6 = 0;
    public static final int f7 = 4;
    private static final int g = 0;
    public static final int g0 = 0;
    public static final int g1 = 4;
    public static final int g2 = 26;
    public static final int g3 = 92;
    public static final int g4 = 115;
    public static final int g5 = 136;
    public static final int g6 = 0;
    public static final int g7 = 5;
    private static final int h = 1;
    public static final int h0 = 1;
    public static final int h1 = 5;
    public static final int h2 = 27;
    public static final int h3 = 93;
    public static final int h4 = 116;
    public static final int h5 = 137;
    public static final int h6 = 1;
    public static final int h7 = 0;
    private static final int i = 2;
    public static final int i0 = 2;
    public static final int i1 = 7;
    public static final int i2 = 28;
    public static final int i3 = 92;
    public static final int i4 = 119;
    public static final int i5 = 138;
    public static final int i6 = 255;
    public static final int i7 = 1;
    private static final int j = 3;
    public static final int j0 = 3;
    public static final int j1 = 8;
    public static final int j2 = 29;
    public static final int j3 = 93;
    public static final int j4 = 120;
    public static final int j5 = 137;
    public static final int j6 = 1;
    public static final int j7 = 2;
    private static final int k = 4;
    public static final int k0 = 0;
    public static final int k1 = 16;
    public static final int k2 = 30;
    public static final int k3 = 94;
    public static final int k4 = 121;
    public static final int k5 = 138;
    public static final int k6 = 2;
    public static final int k7 = 3;
    private static final int l = 0;
    public static final int l0 = 255;
    public static final int l1 = 255;
    public static final int l2 = 31;
    public static final int l3 = 95;
    public static final int l4 = 122;
    public static final int l5 = 135;
    public static final int l6 = 3;
    public static final int l7 = 4;
    private static final int m = 1;
    public static final int m0 = 1;
    public static final int m1 = 1;
    public static final int m2 = 32;
    public static final int m3 = 96;
    public static final int m4 = 119;
    public static final int m5 = 136;
    public static final int m6 = 4;
    public static final int m7 = 0;
    private static final int n = 2;
    public static final int n0 = 0;
    public static final int n1 = 2;
    public static final int n2 = 33;
    public static final int n3 = 97;
    public static final int n4 = 120;
    public static final int n5 = 139;
    public static final int n6 = 5;
    public static final int n7 = 1;
    private static final int o = 3;
    public static final int o0 = 1;
    public static final int o1 = 3;
    public static final int o2 = 34;
    public static final int o3 = 96;
    public static final int o4 = 119;
    public static final int o5 = 140;
    public static final int o6 = 6;
    public static final int o7 = 2;
    private static final int p = 4;
    public static final int p0 = 2;
    public static final int p1 = 4;
    public static final int p2 = 35;
    public static final int p3 = 97;
    public static final int p4 = 120;
    public static final int p5 = 141;
    public static final int p6 = 7;
    public static final int p7 = 3;
    private static final int q = 5;
    public static final int q0 = 3;
    public static final int q1 = 0;
    public static final int q2 = 36;
    public static final int q3 = 98;
    public static final int q4 = 123;
    public static final int q5 = 142;
    public static final int q6 = Integer.MIN_VALUE;
    public static final int q7 = 4;
    private static final int r = 6;
    public static final int r0 = 4;
    public static final int r1 = 1;
    public static final int r2 = 37;
    public static final int r3 = 99;
    public static final int r4 = 124;
    public static final int r5 = 141;
    public static final int r6 = 0;
    public static final int r7 = 5;
    private static final int s = 0;
    public static final int s0 = 0;
    public static final int s1 = 2;
    public static final int s2 = 38;
    public static final int s3 = 100;
    public static final int s4 = 123;
    public static final int s5 = 142;
    public static final int s6 = 1;
    public static final int s7 = 6;
    private static final int t = 1;
    public static final int t0 = 1;
    public static final int t1 = 1;
    public static final int t2 = 39;
    public static final int t3 = 101;
    public static final int t4 = 123;
    public static final int t5 = 139;
    public static final int t6 = 2;
    private static final int u = 2;
    public static final int u0 = 2;
    public static final int u1 = 2;
    public static final int u2 = 40;
    public static final int u3 = 100;
    public static final int u4 = 124;
    public static final int u5 = 140;
    public static final int u6 = 3;
    private static final int v = 3;
    public static final int v0 = 3;
    public static final int v1 = 3;
    public static final int v2 = 41;
    public static final int v3 = 101;
    public static final int v4 = 124;
    public static final int v5 = 143;
    public static final int v6 = 0;
    private static final int w = 4;
    public static final int w0 = 0;
    public static final int w1 = 0;
    public static final int w2 = 44;
    public static final int w3 = 98;
    public static final int w4 = 124;
    public static final int w5 = 0;
    public static final int w6 = 1;
    private static final int x = 1;
    public static final int x0 = 1;
    public static final int x1 = 256;
    public static final int x2 = 45;
    public static final int x3 = 99;
    public static final int x4 = 125;
    public static final int x5 = 1;
    public static final int x6 = 0;
    private static final int y = 2;
    public static final int y0 = 2;
    public static final int y1 = 0;
    public static final int y2 = 50;
    public static final int y3 = 102;
    public static final int y4 = 126;
    public static final int y5 = 2;
    public static final int y6 = 1;
    private static final int z = 3;
    public static final int z0 = 3;
    public static final int z1 = 0;
    public static final int z2 = 51;
    public static final int z3 = 103;
    public static final int z4 = 127;
    public static final int z5 = 0;
    public static final int z6 = 2;

    public static void A(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Laplacian_4(l10, l11, n10);
    }

    public static int A0(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.connectedComponents_2(l10, l11);
    }

    public static void A1(Mat mat, List list, int n10, y y10) {
        Object object = list;
        int n11 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n11);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.drawContours_5(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6);
    }

    public static double A2(int n10, int n11, int n12) {
        return Imgproc.getFontScaleFromHeight_0(n10, n11, n12);
    }

    public static void A3(Mat mat, Mat mat2, int n10, Mat mat3, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.morphologyEx_3(l10, l11, n10, l12, d10, d11);
    }

    public static void A4(Mat mat, Mat mat2, int n10, z z10, u u10, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l12 = l10;
        l10 = l11;
        Imgproc.sqrBoxFilter_1(l12, l11, n10, d10, d11, d12, d13, bl2);
    }

    public static void B(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Laplacian_3(l10, l11, n10, n11);
    }

    public static int B0(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.connectedComponents_1(l10, l11, n10);
    }

    public static void B1(Mat mat, List list, int n10, y y10, int n11) {
        Object object = list;
        int n12 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n12);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.drawContours_4(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6, n11);
    }

    public static Mat B2(z z10, double d10, double d11, double d12, double d13) {
        double d14 = z10.a;
        double d15 = z10.b;
        long l10 = Imgproc.getGaborKernel_2(d14, d15, d10, d11, d12, d13);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void B3(Mat mat, Mat mat2, int n10, Mat mat3, u u10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.morphologyEx_2(l10, l11, n10, l12, d10, d11, n11);
    }

    public static void B4(Mat mat, Mat mat2, int n10, z z10, u u10, boolean bl2, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l12 = l10;
        l10 = l11;
        Imgproc.sqrBoxFilter_0(l12, l11, n10, d10, d11, d12, d13, bl2, n11);
    }

    public static void C(Mat mat, Mat mat2, int n10, int n11, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Laplacian_2(l10, l11, n10, n11, d10);
    }

    public static int C0(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.connectedComponents_0(l10, l11, n10, n11);
    }

    public static void C1(Mat mat, List list, int n10, y y10, int n11, int n12) {
        Object object = list;
        int n13 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n13);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.drawContours_3(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6, n11, n12);
    }

    public static Mat C2(z z10, double d10, double d11, double d12, double d13, double d14) {
        double d15 = z10.a;
        double d16 = z10.b;
        long l10 = Imgproc.getGaborKernel_1(d15, d16, d10, d11, d12, d13, d14);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void C3(Mat mat, Mat mat2, int n10, Mat mat3, u u10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.morphologyEx_1(l10, l11, n10, l12, d10, d11, n11, n12);
    }

    public static double C4(Mat mat, Mat mat2, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.threshold_0(l10, l11, d10, d11, n10);
    }

    private static native void Canny_0(long var0, long var2, long var4, double var6, double var8, boolean var10);

    private static native void Canny_1(long var0, long var2, long var4, double var6, double var8);

    private static native void Canny_2(long var0, long var2, double var4, double var6, int var8, boolean var9);

    private static native void Canny_3(long var0, long var2, double var4, double var6, int var8);

    private static native void Canny_4(long var0, long var2, double var4, double var6);

    public static void D(Mat mat, Mat mat2, int n10, int n11, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Laplacian_1(l10, l11, n10, n11, d10, d11);
    }

    public static int D0(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.connectedComponentsWithAlgorithm_0(l10, l11, n10, n11, n12);
    }

    public static void D1(Mat mat, List list, int n10, y y10, int n11, int n12, Mat mat2) {
        Object object = list;
        int n13 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n13);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        object = mat2;
        long l12 = mat2.a;
        Imgproc.drawContours_2(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6, n11, n12, l12);
    }

    public static Mat D2(z z10, double d10, double d11, double d12, double d13, double d14, int n10) {
        double d15 = z10.a;
        double d16 = z10.b;
        long l10 = Imgproc.getGaborKernel_0(d15, d16, d10, d11, d12, d13, d14, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void D3(Mat mat, Mat mat2, int n10, Mat mat3, u u10, int n11, int n12, y y10) {
        Object object = u10;
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.morphologyEx_0(l10, l11, n10, l12, d10, d11, n11, n12, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void D4(Mat mat, Mat mat2, Mat mat3, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpAffine_3(l10, l11, l12, d10, d11);
    }

    public static void E(Mat mat, Mat mat2, int n10, int n11, double d10, double d11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Laplacian_0(l10, l11, n10, n11, d10, d11, n12);
    }

    public static int E0(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Imgproc.connectedComponentsWithStats_2(l10, l11, l12, l13);
    }

    public static void E1(Mat mat, List list, int n10, y y10, int n11, int n12, Mat mat2, int n13) {
        Object object = list;
        int n14 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n14);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        object = mat2;
        long l12 = mat2.a;
        Imgproc.drawContours_1(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6, n11, n12, l12, n13);
    }

    public static Mat E2(int n10, double d10) {
        long l10 = Imgproc.getGaussianKernel_1(n10, d10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static u E3(Mat object, Mat mat) {
        long l10 = ((Mat)object).a;
        long l11 = mat.a;
        object = Imgproc.phaseCorrelate_2(l10, l11);
        u u10 = new u((double[])object);
        return u10;
    }

    public static void E4(Mat mat, Mat mat2, Mat mat3, z z10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpAffine_2(l10, l11, l12, d10, d11, n10);
    }

    private static native float EMD_0(long var0, long var2, int var4, long var5, long var7);

    private static native float EMD_1(long var0, long var2, int var4, long var5);

    private static native float EMD_3(long var0, long var2, int var4);

    public static void F(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Scharr_3(l10, l11, n10, n11, n12);
    }

    public static int F0(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Imgproc.connectedComponentsWithStats_1(l10, l11, l12, l13, n10);
    }

    public static void F1(Mat mat, List list, int n10, y y10, int n11, int n12, Mat mat2, int n13, u u10) {
        Object object = list;
        u u11 = u10;
        int n14 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n14);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        object = mat2;
        long l12 = mat2.a;
        double d10 = u11.a;
        double d11 = u11.b;
        Imgproc.drawContours_0(l10, l11, n10, (double)object3, (double)object4, (double)object5, (double)object6, n11, n12, l12, n13, d10, d11);
    }

    public static Mat F2(int n10, double d10, int n11) {
        long l10 = Imgproc.getGaussianKernel_0(n10, d10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static u F3(Mat object, Mat mat, Mat mat2) {
        long l10 = ((Mat)object).a;
        long l11 = mat.a;
        long l12 = mat2.a;
        object = Imgproc.phaseCorrelate_1(l10, l11, l12);
        u u10 = new u((double[])object);
        return u10;
    }

    public static void F4(Mat mat, Mat mat2, Mat mat3, z z10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpAffine_1(l10, l11, l12, d10, d11, n10, n11);
    }

    public static void G(Mat mat, Mat mat2, int n10, int n11, int n12, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Scharr_2(l10, l11, n10, n11, n12, d10);
    }

    public static int G0(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Imgproc.connectedComponentsWithStats_0(l10, l11, l12, l13, n10, n11);
    }

    public static void G1(Mat mat, u u10, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.drawMarker_4(l10, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static Mat G2(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = Imgproc.getPerspectiveTransform_1(l10, l11);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static u G3(Mat object, Mat mat, Mat mat2, double[] dArray) {
        int n10 = 1;
        double[] dArray2 = new double[n10];
        long l10 = ((Mat)object).a;
        long l11 = mat.a;
        long l12 = mat2.a;
        object = Imgproc.phaseCorrelate_0(l10, l11, l12, dArray2);
        u u10 = new u((double[])object);
        if (dArray != null) {
            double d10;
            object = null;
            dArray[0] = d10 = dArray2[0];
        }
        return u10;
    }

    public static void G4(Mat mat, Mat mat2, Mat mat3, z z10, int n10, int n11, y y10) {
        Object object = z10;
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.warpAffine_0(l10, l11, l12, d10, d11, n10, n11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    private static native void GaussianBlur_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12);

    private static native void GaussianBlur_1(long var0, long var2, double var4, double var6, double var8, double var10);

    private static native void GaussianBlur_2(long var0, long var2, double var4, double var6, double var8);

    public static void H(Mat mat, Mat mat2, int n10, int n11, int n12, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Scharr_1(l10, l11, n10, n11, n12, d10, d11);
    }

    public static int H0(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Imgproc.connectedComponentsWithStatsWithAlgorithm_0(l10, l11, l12, l13, n10, n11, n12);
    }

    public static void H1(Mat mat, u u10, y y10, int n10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.drawMarker_3(l10, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static Mat H2(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        l11 = Imgproc.getPerspectiveTransform_0(l10, l11, n10);
        Mat mat3 = new Mat(l11);
        return mat3;
    }

    public static double H3(m m10, u u10, boolean bl2) {
        long l10 = m10.a;
        double d10 = u10.a;
        double d11 = u10.b;
        return Imgproc.pointPolygonTest_0(l10, d10, d11, bl2);
    }

    public static void H4(Mat mat, Mat mat2, Mat mat3, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpPerspective_3(l10, l11, l12, d10, d11);
    }

    private static native void HoughCircles_0(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13, int var14);

    private static native void HoughCircles_1(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13);

    private static native void HoughCircles_2(long var0, long var2, int var4, double var5, double var7, double var9, double var11);

    private static native void HoughCircles_3(long var0, long var2, int var4, double var5, double var7, double var9);

    private static native void HoughCircles_4(long var0, long var2, int var4, double var5, double var7);

    private static native void HoughLinesP_0(long var0, long var2, double var4, double var6, int var8, double var9, double var11);

    private static native void HoughLinesP_1(long var0, long var2, double var4, double var6, int var8, double var9);

    private static native void HoughLinesP_2(long var0, long var2, double var4, double var6, int var8);

    private static native void HoughLinesPointSet_0(long var0, long var2, int var4, int var5, double var6, double var8, double var10, double var12, double var14, double var16);

    private static native void HoughLines_0(long var0, long var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15);

    private static native void HoughLines_1(long var0, long var2, double var4, double var6, int var8, double var9, double var11, double var13);

    private static native void HoughLines_2(long var0, long var2, double var4, double var6, int var8, double var9, double var11);

    private static native void HoughLines_3(long var0, long var2, double var4, double var6, int var8, double var9);

    private static native void HoughLines_4(long var0, long var2, double var4, double var6, int var8);

    private static native void HuMoments_0(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, long var20);

    public static void I(Mat mat, Mat mat2, int n10, int n11, int n12, double d10, double d11, int n13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Scharr_0(l10, l11, n10, n11, n12, d10, d11, n13);
    }

    public static double I0(Mat mat) {
        return Imgproc.contourArea_1(mat.a);
    }

    public static void I1(Mat mat, u u10, y y10, int n10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.drawMarker_2(l10, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static void I2(Mat mat, z z10, u u10, Mat mat2) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l11 = mat2.a;
        Imgproc.getRectSubPix_1(l10, d10, d11, d12, d13, l11);
    }

    public static void I3(Mat mat, List list, boolean bl2, y y10) {
        Object object = list;
        int n10 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n10);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.polylines_3(l10, l11, bl2, (double)object3, (double)object4, (double)object5, (double)object6);
    }

    public static void I4(Mat mat, Mat mat2, Mat mat3, z z10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpPerspective_2(l10, l11, l12, d10, d11, n10);
    }

    public static void J(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Sobel_4(l10, l11, n10, n11, n12);
    }

    public static double J0(Mat mat, boolean bl2) {
        return Imgproc.contourArea_0(mat.a, bl2);
    }

    public static void J1(Mat mat, u u10, y y10, int n10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.drawMarker_1(l10, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    public static void J2(Mat mat, z z10, u u10, Mat mat2, int n10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l11 = mat2.a;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        Imgproc.getRectSubPix_0(l10, d14, d10, d11, d13, l11, n10);
    }

    public static void J3(Mat mat, List list, boolean bl2, y y10, int n10) {
        Object object = list;
        int n11 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n11);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.polylines_2(l10, l11, bl2, (double)object3, (double)object4, (double)object5, (double)object6, n10);
    }

    public static void J4(Mat mat, Mat mat2, Mat mat3, z z10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.warpPerspective_1(l10, l11, l12, d10, d11, n10, n11);
    }

    public static void K(Mat mat, Mat mat2, int n10, int n11, int n12, int n13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Sobel_3(l10, l11, n10, n11, n12, n13);
    }

    public static void K0(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.convertMaps_1(l10, l11, l12, l13, n10);
    }

    public static void K1(Mat mat, u u10, y y10, int n10, int n11, int n12, int n13) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.drawMarker_0(l10, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12, n13);
    }

    public static Mat K2(u u10, double d10, double d11) {
        double d12 = u10.a;
        double d13 = u10.b;
        long l10 = Imgproc.getRotationMatrix2D_0(d12, d13, d10, d11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void K3(Mat mat, List list, boolean bl2, y y10, int n10, int n11) {
        Object object = list;
        int n12 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n12);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.polylines_1(l10, l11, bl2, (double)object3, (double)object4, (double)object5, (double)object6, n10, n11);
    }

    public static void K4(Mat mat, Mat mat2, Mat mat3, z z10, int n10, int n11, y y10) {
        Object object = z10;
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.warpPerspective_0(l10, l11, l12, d10, d11, n10, n11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void L(Mat mat, Mat mat2, int n10, int n11, int n12, int n13, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Sobel_2(l10, l11, n10, n11, n12, n13, d10);
    }

    public static void L0(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.convertMaps_0(l10, l11, l12, l13, n10, bl2);
    }

    public static void L1(Mat mat, u u10, z z10, double d10, double d11, double d12, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d13 = u10.a;
        double d14 = u10.b;
        double d15 = z10.a;
        double d16 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_3(l10, d13, d14, d15, d16, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static Mat L2(int n10, z z10) {
        double d10 = z10.a;
        double d11 = z10.b;
        long l10 = Imgproc.getStructuringElement_1(n10, d10, d11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void L3(Mat mat, List list, boolean bl2, y y10, int n10, int n11, int n12) {
        Object object = list;
        int n13 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n13);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.polylines_0(l10, l11, bl2, (double)object3, (double)object4, (double)object5, (double)object6, n10, n11, n12);
    }

    public static void L4(Mat mat, Mat mat2, z z10, u u10, double d10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = u10.a;
        double d14 = u10.b;
        long l12 = l10;
        l10 = l11;
        double d15 = d11;
        d11 = d12;
        d12 = d13;
        d13 = d14;
        d14 = d10;
        Imgproc.warpPolar_0(l12, l11, d15, d11, d12, d13, d10, n10);
    }

    private static native void Laplacian_0(long var0, long var2, int var4, int var5, double var6, double var8, int var10);

    private static native void Laplacian_1(long var0, long var2, int var4, int var5, double var6, double var8);

    private static native void Laplacian_2(long var0, long var2, int var4, int var5, double var6);

    private static native void Laplacian_3(long var0, long var2, int var4, int var5);

    private static native void Laplacian_4(long var0, long var2, int var4);

    public static void M(Mat mat, Mat mat2, int n10, int n11, int n12, int n13, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Sobel_1(l10, l11, n10, n11, n12, n13, d10, d11);
    }

    public static void M0(p p10, k k10) {
        long l10 = p10.a;
        long l11 = k10.a;
        Imgproc.convexHull_2(l10, l11);
    }

    public static void M1(Mat mat, u u10, z z10, double d10, double d11, double d12, y y10, int n10) {
        Object object = u10;
        long l10 = mat.a;
        double d13 = u10.a;
        double d14 = u10.b;
        double d15 = z10.a;
        double d16 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_2(l10, d13, d14, d15, d16, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static Mat M2(int n10, z z10, u u10) {
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l10 = Imgproc.getStructuringElement_0(n10, d10, d11, d12, d13);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void M3(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.preCornerDetect_1(l10, l11, n10);
    }

    public static void M4(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.watershed_0(l10, l11);
    }

    public static void N(Mat mat, Mat mat2, int n10, int n11, int n12, int n13, double d10, double d11, int n14) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Sobel_0(l10, l11, n10, n11, n12, n13, d10, d11, n14);
    }

    public static void N0(p p10, k k10, boolean bl2) {
        long l10 = p10.a;
        long l11 = k10.a;
        Imgproc.convexHull_0(l10, l11, bl2);
    }

    public static void N1(Mat mat, u u10, z z10, double d10, double d11, double d12, y y10, int n10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d13 = u10.a;
        double d14 = u10.b;
        double d15 = z10.a;
        double d16 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_1(l10, d13, d14, d15, d16, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static z N2(String object, int n10, double d10, int n11, int[] nArray) {
        int n12;
        int n13;
        if (nArray != null && (n13 = nArray.length) != (n12 = 1)) {
            object = new IllegalArgumentException("'baseLine' must be 'int[1]' or 'null'.");
            throw object;
        }
        object = Imgproc.n_getTextSize((String)object, n10, d10, n11, nArray);
        z z10 = new z((double[])object);
        return z10;
    }

    public static void N3(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.preCornerDetect_0(l10, l11, n10, n11);
    }

    public static void O(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.accumulate_1(l10, l11);
    }

    public static void O0(p p10, k k10, j j10) {
        long l10 = p10.a;
        long l11 = k10.a;
        long l12 = j10.a;
        Imgproc.convexityDefects_0(l10, l11, l12);
    }

    public static void O1(Mat mat, u u10, z z10, double d10, double d11, double d12, y y10, int n10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d13 = u10.a;
        double d14 = u10.b;
        double d15 = z10.a;
        double d16 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_0(l10, d13, d14, d15, d16, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    public static void O2(Mat mat, p p10, int n10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = p10.a;
        Imgproc.goodFeaturesToTrack_7(l10, l11, n10, d10, d11);
    }

    public static void O3(Mat mat, String string2, u u10, int n10, double d10, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d11 = u10.a;
        double d12 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.putText_3(l10, string2, d11, d12, n10, d10, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void P(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.accumulate_0(l10, l11, l12);
    }

    public static void P0(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerEigenValsAndVecs_1(l10, l11, n10, n11);
    }

    public static void P1(Mat mat, x x10, y y10) {
        Object object = x10;
        long l10 = mat.a;
        u u10 = x10.a;
        double d10 = u10.a;
        double d11 = u10.b;
        z z10 = x10.b;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = x10.c;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_6(l10, d10, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void P2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_6(l10, l11, n10, d10, d11, l12);
    }

    public static void P3(Mat mat, String string2, u u10, int n10, double d10, y y10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d11 = u10.a;
        double d12 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.putText_2(l10, string2, d11, d12, n10, d10, (double)object2, (double)object3, (double)object4, (double)object5, n11);
    }

    public static void Q(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.accumulateProduct_1(l10, l11, l12);
    }

    public static void Q0(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerEigenValsAndVecs_0(l10, l11, n10, n11, n12);
    }

    public static void Q1(Mat mat, x x10, y y10, int n10) {
        Object object = x10;
        long l10 = mat.a;
        u u10 = x10.a;
        double d10 = u10.a;
        double d11 = u10.b;
        z z10 = x10.b;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = x10.c;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_5(l10, d10, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static void Q2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_5(l10, l11, n10, d10, d11, l12, n11);
    }

    public static void Q3(Mat mat, String string2, u u10, int n10, double d10, y y10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d11 = u10.a;
        double d12 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.putText_1(l10, string2, d11, d12, n10, d10, (double)object2, (double)object3, (double)object4, (double)object5, n11, n12);
    }

    public static void R(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.accumulateProduct_0(l10, l11, l12, l13);
    }

    public static void R0(Mat mat, Mat mat2, int n10, int n11, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerHarris_1(l10, l11, n10, n11, d10);
    }

    public static void R1(Mat mat, x x10, y y10, int n10, int n11) {
        Object object = x10;
        long l10 = mat.a;
        u u10 = x10.a;
        double d10 = u10.a;
        double d11 = u10.b;
        z z10 = x10.b;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = x10.c;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.ellipse_4(l10, d10, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static void R2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11, int n12) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_2(l10, l11, n10, d10, d11, l12, n11, n12);
    }

    public static void R3(Mat mat, String string2, u u10, int n10, double d10, y y10, int n11, int n12, boolean bl2) {
        Object object = u10;
        long l10 = mat.a;
        double d11 = u10.a;
        double d12 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.putText_0(l10, string2, d11, d12, n10, d10, (double)object2, (double)object3, (double)object4, (double)object5, n11, n12, bl2);
    }

    public static void S(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.accumulateSquare_1(l10, l11);
    }

    public static void S0(Mat mat, Mat mat2, int n10, int n11, double d10, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerHarris_0(l10, l11, n10, n11, d10, n12);
    }

    public static void S1(u u10, z z10, int n10, int n11, int n12, int n13, p p10) {
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = z10.a;
        double d13 = z10.b;
        long l10 = p10.a;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        Imgproc.ellipse2Poly_0(d14, d10, d11, d13, n10, n11, n12, n13, l10);
    }

    public static void S2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11, int n12, boolean bl2) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_1(l10, l11, n10, d10, d11, l12, n11, n12, bl2);
    }

    public static void S3(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.pyrDown_2(l10, l11);
    }

    private static native void Scharr_0(long var0, long var2, int var4, int var5, int var6, double var7, double var9, int var11);

    private static native void Scharr_1(long var0, long var2, int var4, int var5, int var6, double var7, double var9);

    private static native void Scharr_2(long var0, long var2, int var4, int var5, int var6, double var7);

    private static native void Scharr_3(long var0, long var2, int var4, int var5, int var6);

    private static native void Sobel_0(long var0, long var2, int var4, int var5, int var6, int var7, double var8, double var10, int var12);

    private static native void Sobel_1(long var0, long var2, int var4, int var5, int var6, int var7, double var8, double var10);

    private static native void Sobel_2(long var0, long var2, int var4, int var5, int var6, int var7, double var8);

    private static native void Sobel_3(long var0, long var2, int var4, int var5, int var6, int var7);

    private static native void Sobel_4(long var0, long var2, int var4, int var5, int var6);

    public static void T(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.accumulateSquare_0(l10, l11, l12);
    }

    public static void T0(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerMinEigenVal_2(l10, l11, n10);
    }

    public static void T1(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.equalizeHist_0(l10, l11);
    }

    public static void T2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11, int n12, boolean bl2, double d12) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_0(l10, l11, n10, d10, d11, l12, n11, n12, bl2, d12);
    }

    public static void T3(Mat mat, Mat mat2, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.pyrDown_1(l10, l11, d10, d11);
    }

    public static void U(Mat mat, Mat mat2, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.accumulateWeighted_1(l10, l11, d10);
    }

    public static void U0(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerMinEigenVal_1(l10, l11, n10, n11);
    }

    public static void U1(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.erode_4(l10, l11, l12);
    }

    public static void U2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11, boolean bl2) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_4(l10, l11, n10, d10, d11, l12, n11, bl2);
    }

    public static void U3(Mat mat, Mat mat2, z z10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.pyrDown_0(l10, l11, d10, d11, n10);
    }

    public static void V(Mat mat, Mat mat2, double d10, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.accumulateWeighted_0(l10, l11, d10, l12);
    }

    public static void V0(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cornerMinEigenVal_0(l10, l11, n10, n11, n12);
    }

    public static void V1(Mat mat, Mat mat2, Mat mat3, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.erode_3(l10, l11, l12, d10, d11);
    }

    public static void V2(Mat mat, p p10, int n10, double d10, double d11, Mat mat2, int n11, boolean bl2, double d12) {
        long l10 = mat.a;
        long l11 = p10.a;
        long l12 = mat2.a;
        Imgproc.goodFeaturesToTrack_3(l10, l11, n10, d10, d11, l12, n11, bl2, d12);
    }

    public static void V3(Mat mat, Mat mat2, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.pyrMeanShiftFiltering_2(l10, l11, d10, d11);
    }

    public static void W(Mat mat, Mat mat2, double d10, int n10, int n11, int n12, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.adaptiveThreshold_0(l10, l11, d10, n10, n11, n12, d11);
    }

    public static void W0(Mat mat, Mat mat2, z z10, z z11, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        int n10 = a02.a;
        int n11 = a02.b;
        double d14 = d13;
        d13 = a02.c;
        double d15 = d10;
        double d16 = d11;
        d10 = d12;
        d11 = d14;
        Imgproc.cornerSubPix_0(l10, l11, d15, d16, d12, d14, n10, n11, d13);
    }

    public static void W1(Mat mat, Mat mat2, Mat mat3, u u10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.erode_2(l10, l11, l12, d10, d11, n10);
    }

    public static void W2(Mat mat, Mat mat2, w w10, Mat mat3, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        int n11 = w10.a;
        int n12 = w10.b;
        int n13 = w10.c;
        int n14 = w10.d;
        long l12 = mat3.a;
        long l13 = mat4.a;
        int n15 = n11;
        n11 = n12;
        n12 = n13;
        n13 = n14;
        Imgproc.grabCut_1(l10, l11, n15, n11, n12, n14, l12, l13, n10);
    }

    public static void W3(Mat mat, Mat mat2, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.pyrMeanShiftFiltering_1(l10, l11, d10, d11, n10);
    }

    public static void X(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.applyColorMap_1(l10, l11, n10);
    }

    public static CLAHE X0() {
        return CLAHE.g(Imgproc.createCLAHE_2());
    }

    public static void X1(Mat mat, Mat mat2, Mat mat3, u u10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.erode_1(l10, l11, l12, d10, d11, n10, n11);
    }

    public static void X2(Mat mat, Mat mat2, w w10, Mat mat3, Mat mat4, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        int n12 = w10.a;
        int n13 = w10.b;
        int n14 = w10.c;
        int n15 = w10.d;
        long l12 = mat3.a;
        long l13 = mat4.a;
        int n16 = n12;
        n12 = n13;
        n13 = n14;
        n14 = n15;
        Imgproc.grabCut_0(l10, l11, n16, n12, n13, n15, l12, l13, n10, n11);
    }

    public static void X3(Mat mat, Mat mat2, double d10, double d11, int n10, a0 a02) {
        long l10 = mat.a;
        long l11 = mat2.a;
        int n11 = a02.a;
        int n12 = a02.b;
        double d12 = a02.c;
        long l12 = l10;
        l10 = l11;
        Imgproc.pyrMeanShiftFiltering_0(l12, l11, d10, d11, n10, n11, n12, d12);
    }

    public static void Y(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.applyColorMap_0(l10, l11, l12);
    }

    public static CLAHE Y0(double d10) {
        return CLAHE.g(Imgproc.createCLAHE_1(d10));
    }

    public static void Y1(Mat mat, Mat mat2, Mat mat3, u u10, int n10, int n11, y y10) {
        Object object = u10;
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.erode_0(l10, l11, l12, d10, d11, n10, n11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void Y2(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.integral_1(l10, l11);
    }

    public static void Y3(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.pyrUp_2(l10, l11);
    }

    public static void Z(m m10, m m11, double d10, boolean bl2) {
        long l10 = m10.a;
        long l11 = m11.a;
        Imgproc.approxPolyDP_0(l10, l11, d10, bl2);
    }

    public static CLAHE Z0(double d10, z z10) {
        double d11 = z10.a;
        double d12 = z10.b;
        return CLAHE.g(Imgproc.createCLAHE_0(d10, d11, d12));
    }

    public static void Z1(Mat object, p p10, y y10) {
        long l10 = ((Mat)object).a;
        long l11 = p10.a;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.fillConvexPoly_2(l10, l11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void Z2(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.integral_0(l10, l11, n10);
    }

    public static void Z3(Mat mat, Mat mat2, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.pyrUp_1(l10, l11, d10, d11);
    }

    public static void a(Mat mat, Mat mat2, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Canny_4(l10, l11, d10, d11);
    }

    public static double a0(m m10, boolean bl2) {
        return Imgproc.arcLength_0(m10.a, bl2);
    }

    public static GeneralizedHoughBallard a1() {
        return GeneralizedHoughBallard.z(Imgproc.createGeneralizedHoughBallard_0());
    }

    public static void a2(Mat mat, p p10, y y10, int n10) {
        long l10 = mat.a;
        long l11 = p10.a;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.fillConvexPoly_1(l10, l11, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static void a3(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.integral2_2(l10, l11, l12);
    }

    public static void a4(Mat mat, Mat mat2, z z10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.pyrUp_0(l10, l11, d10, d11, n10);
    }

    private static native void accumulateProduct_0(long var0, long var2, long var4, long var6);

    private static native void accumulateProduct_1(long var0, long var2, long var4);

    private static native void accumulateSquare_0(long var0, long var2, long var4);

    private static native void accumulateSquare_1(long var0, long var2);

    private static native void accumulateWeighted_0(long var0, long var2, double var4, long var6);

    private static native void accumulateWeighted_1(long var0, long var2, double var4);

    private static native void accumulate_0(long var0, long var2, long var4);

    private static native void accumulate_1(long var0, long var2);

    private static native void adaptiveThreshold_0(long var0, long var2, double var4, int var6, int var7, int var8, double var9);

    private static native void applyColorMap_0(long var0, long var2, long var4);

    private static native void applyColorMap_1(long var0, long var2, int var4);

    private static native void approxPolyDP_0(long var0, long var2, double var4, boolean var6);

    private static native double arcLength_0(long var0, boolean var2);

    private static native void arrowedLine_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19, int var20, double var21);

    private static native void arrowedLine_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19, int var20);

    private static native void arrowedLine_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19);

    private static native void arrowedLine_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18);

    private static native void arrowedLine_4(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16);

    public static void b(Mat mat, Mat mat2, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Canny_3(l10, l11, d10, d11, n10);
    }

    public static void b0(Mat mat, u u10, u u11, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.arrowedLine_4(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static GeneralizedHoughGuil b1() {
        return GeneralizedHoughGuil.z(Imgproc.createGeneralizedHoughGuil_0());
    }

    public static void b2(Mat mat, p p10, y y10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = p10.a;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.fillConvexPoly_0(l10, l11, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static void b3(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.integral2_1(l10, l11, l12, n10);
    }

    public static void b4(Mat mat, u u10, u u11, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.rectangle_3(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    private static native void bilateralFilter_0(long var0, long var2, int var4, double var5, double var7, int var9);

    private static native void bilateralFilter_1(long var0, long var2, int var4, double var5, double var7);

    private static native void blur_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12);

    private static native void blur_1(long var0, long var2, double var4, double var6, double var8, double var10);

    private static native void blur_2(long var0, long var2, double var4, double var6);

    private static native double[] boundingRect_0(long var0);

    private static native void boxFilter_0(long var0, long var2, int var4, double var5, double var7, double var9, double var11, boolean var13, int var14);

    private static native void boxFilter_1(long var0, long var2, int var4, double var5, double var7, double var9, double var11, boolean var13);

    private static native void boxFilter_2(long var0, long var2, int var4, double var5, double var7, double var9, double var11);

    private static native void boxFilter_3(long var0, long var2, int var4, double var5, double var7);

    private static native void boxPoints_0(double var0, double var2, double var4, double var6, double var8, long var10);

    public static void c(Mat mat, Mat mat2, double d10, double d11, int n10, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.Canny_2(l10, l11, d10, d11, n10, bl2);
    }

    public static void c0(Mat mat, u u10, u u11, y y10, int n10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.arrowedLine_3(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static void c1(Mat mat, z z10, int n10) {
        long l10 = mat.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.createHanningWindow_0(l10, d10, d11, n10);
    }

    public static void c2(Mat mat, List list, y y10) {
        Object object = list;
        int n10 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n10);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.fillPoly_3(l10, l11, (double)object3, (double)object4, (double)object5, (double)object6);
    }

    public static void c3(Mat mat, Mat mat2, Mat mat3, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.integral2_0(l10, l11, l12, n10, n11);
    }

    public static void c4(Mat mat, u u10, u u11, y y10, int n10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.rectangle_2(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    private static native void calcBackProject_0(long var0, long var2, long var4, long var6, long var8, double var10);

    private static native void calcHist_0(long var0, long var2, long var4, long var6, long var8, long var10, boolean var12);

    private static native void calcHist_1(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void circle_0(long var0, double var2, double var4, int var6, double var7, double var9, double var11, double var13, int var15, int var16, int var17);

    private static native void circle_1(long var0, double var2, double var4, int var6, double var7, double var9, double var11, double var13, int var15, int var16);

    private static native void circle_2(long var0, double var2, double var4, int var6, double var7, double var9, double var11, double var13, int var15);

    private static native void circle_3(long var0, double var2, double var4, int var6, double var7, double var9, double var11, double var13);

    private static native boolean clipLine_0(int var0, int var1, int var2, int var3, double var4, double var6, double[] var8, double var9, double var11, double[] var13);

    private static native double compareHist_0(long var0, long var2, int var4);

    private static native int connectedComponentsWithAlgorithm_0(long var0, long var2, int var4, int var5, int var6);

    private static native int connectedComponentsWithStatsWithAlgorithm_0(long var0, long var2, long var4, long var6, int var8, int var9, int var10);

    private static native int connectedComponentsWithStats_0(long var0, long var2, long var4, long var6, int var8, int var9);

    private static native int connectedComponentsWithStats_1(long var0, long var2, long var4, long var6, int var8);

    private static native int connectedComponentsWithStats_2(long var0, long var2, long var4, long var6);

    private static native int connectedComponents_0(long var0, long var2, int var4, int var5);

    private static native int connectedComponents_1(long var0, long var2, int var4);

    private static native int connectedComponents_2(long var0, long var2);

    private static native double contourArea_0(long var0, boolean var2);

    private static native double contourArea_1(long var0);

    private static native void convertMaps_0(long var0, long var2, long var4, long var6, int var8, boolean var9);

    private static native void convertMaps_1(long var0, long var2, long var4, long var6, int var8);

    private static native void convexHull_0(long var0, long var2, boolean var4);

    private static native void convexHull_2(long var0, long var2);

    private static native void convexityDefects_0(long var0, long var2, long var4);

    private static native void cornerEigenValsAndVecs_0(long var0, long var2, int var4, int var5, int var6);

    private static native void cornerEigenValsAndVecs_1(long var0, long var2, int var4, int var5);

    private static native void cornerHarris_0(long var0, long var2, int var4, int var5, double var6, int var8);

    private static native void cornerHarris_1(long var0, long var2, int var4, int var5, double var6);

    private static native void cornerMinEigenVal_0(long var0, long var2, int var4, int var5, int var6);

    private static native void cornerMinEigenVal_1(long var0, long var2, int var4, int var5);

    private static native void cornerMinEigenVal_2(long var0, long var2, int var4);

    private static native void cornerSubPix_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12, int var13, double var14);

    private static native long createCLAHE_0(double var0, double var2, double var4);

    private static native long createCLAHE_1(double var0);

    private static native long createCLAHE_2();

    private static native long createGeneralizedHoughBallard_0();

    private static native long createGeneralizedHoughGuil_0();

    private static native void createHanningWindow_0(long var0, double var2, double var4, int var6);

    private static native long createLineSegmentDetector_0(int var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13);

    private static native long createLineSegmentDetector_1(int var0, double var1, double var3, double var5, double var7, double var9, double var11);

    private static native long createLineSegmentDetector_2(int var0, double var1, double var3, double var5, double var7, double var9);

    private static native long createLineSegmentDetector_3(int var0, double var1, double var3, double var5, double var7);

    private static native long createLineSegmentDetector_4(int var0, double var1, double var3, double var5);

    private static native long createLineSegmentDetector_5(int var0, double var1, double var3);

    private static native long createLineSegmentDetector_6(int var0, double var1);

    private static native long createLineSegmentDetector_7(int var0);

    private static native long createLineSegmentDetector_8();

    private static native void cvtColorTwoPlane_0(long var0, long var2, long var4, int var6);

    private static native void cvtColor_0(long var0, long var2, int var4, int var5);

    private static native void cvtColor_1(long var0, long var2, int var4);

    public static void d(Mat mat, Mat mat2, Mat mat3, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.Canny_1(l10, l11, l12, d10, d11);
    }

    public static void d0(Mat mat, u u10, u u11, y y10, int n10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.arrowedLine_2(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static LineSegmentDetector d1() {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_8());
    }

    public static void d2(Mat mat, List list, y y10, int n10) {
        Object object = list;
        int n11 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n11);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.fillPoly_2(l10, l11, (double)object3, (double)object4, (double)object5, (double)object6, n10);
    }

    public static void d3(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.integral3_2(l10, l11, l12, l13);
    }

    public static void d4(Mat mat, u u10, u u11, y y10, int n10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.rectangle_1(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    private static native void demosaicing_0(long var0, long var2, int var4, int var5);

    private static native void demosaicing_1(long var0, long var2, int var4);

    private static native void dilate_0(long var0, long var2, long var4, double var6, double var8, int var10, int var11, double var12, double var14, double var16, double var18);

    private static native void dilate_1(long var0, long var2, long var4, double var6, double var8, int var10, int var11);

    private static native void dilate_2(long var0, long var2, long var4, double var6, double var8, int var10);

    private static native void dilate_3(long var0, long var2, long var4, double var6, double var8);

    private static native void dilate_4(long var0, long var2, long var4);

    private static native void distanceTransformWithLabels_0(long var0, long var2, long var4, int var6, int var7, int var8);

    private static native void distanceTransformWithLabels_1(long var0, long var2, long var4, int var6, int var7);

    private static native void distanceTransform_0(long var0, long var2, int var4, int var5, int var6);

    private static native void distanceTransform_1(long var0, long var2, int var4, int var5);

    private static native void drawContours_0(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13, int var14, long var15, int var17, double var18, double var20);

    private static native void drawContours_1(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13, int var14, long var15, int var17);

    private static native void drawContours_2(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13, int var14, long var15);

    private static native void drawContours_3(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13, int var14);

    private static native void drawContours_4(long var0, long var2, int var4, double var5, double var7, double var9, double var11, int var13);

    private static native void drawContours_5(long var0, long var2, int var4, double var5, double var7, double var9, double var11);

    private static native void drawMarker_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, int var14, int var15, int var16, int var17);

    private static native void drawMarker_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, int var14, int var15, int var16);

    private static native void drawMarker_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, int var14, int var15);

    private static native void drawMarker_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, int var14);

    private static native void drawMarker_4(long var0, double var2, double var4, double var6, double var8, double var10, double var12);

    public static void e(Mat mat, Mat mat2, Mat mat3, double d10, double d11, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.Canny_0(l10, l11, l12, d10, d11, bl2);
    }

    public static void e0(Mat mat, u u10, u u11, y y10, int n10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.arrowedLine_1(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    public static LineSegmentDetector e1(int n10) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_7(n10));
    }

    public static void e2(Mat mat, List list, y y10, int n10, int n11) {
        Object object = list;
        int n12 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n12);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Imgproc.fillPoly_1(l10, l11, (double)object3, (double)object4, (double)object5, (double)object6, n10, n11);
    }

    public static void e3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.integral3_1(l10, l11, l12, l13, n10);
    }

    public static void e4(Mat mat, u u10, u u11, y y10, int n10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.rectangle_0(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    private static native void ellipse2Poly_0(double var0, double var2, double var4, double var6, int var8, int var9, int var10, int var11, long var12);

    private static native void ellipse_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20, double var22, int var24, int var25, int var26);

    private static native void ellipse_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20, double var22, int var24, int var25);

    private static native void ellipse_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20, double var22, int var24);

    private static native void ellipse_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20, double var22);

    private static native void ellipse_4(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, int var20, int var21);

    private static native void ellipse_5(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, int var20);

    private static native void ellipse_6(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18);

    private static native void equalizeHist_0(long var0, long var2);

    private static native void erode_0(long var0, long var2, long var4, double var6, double var8, int var10, int var11, double var12, double var14, double var16, double var18);

    private static native void erode_1(long var0, long var2, long var4, double var6, double var8, int var10, int var11);

    private static native void erode_2(long var0, long var2, long var4, double var6, double var8, int var10);

    private static native void erode_3(long var0, long var2, long var4, double var6, double var8);

    private static native void erode_4(long var0, long var2, long var4);

    public static float f(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.EMD_3(l10, l11, n10);
    }

    public static void f0(Mat mat, u u10, u u11, y y10, int n10, int n11, int n12, double d10) {
        Object object = u10;
        long l10 = mat.a;
        double d11 = u10.a;
        double d12 = u10.b;
        double d13 = u11.a;
        double d14 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.arrowedLine_0(l10, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12, d10);
    }

    public static LineSegmentDetector f1(int n10, double d10) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_6(n10, d10));
    }

    public static void f2(Mat mat, List list, y y10, int n10, int n11, u u10) {
        Object object = list;
        u u11 = u10;
        int n12 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n12);
        object = i.f.h.a.V((List)object, object2);
        object2 = mat;
        long l10 = mat.a;
        long l11 = ((Mat)object).a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        double d10 = u11.a;
        double d11 = u11.b;
        Imgproc.fillPoly_0(l10, l11, (double)object3, (double)object4, (double)object5, (double)object6, n10, n11, d10, d11);
    }

    public static void f3(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.integral3_0(l10, l11, l12, l13, n10, n11);
    }

    public static void f4(Mat mat, w w10, y y10) {
        Object object = w10;
        long l10 = mat.a;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        int n14 = n10;
        n10 = n11;
        n11 = n12;
        n12 = n13;
        Imgproc.rectangle_7(l10, n14, n10, n11, n13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    private static native void fillConvexPoly_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12, int var13);

    private static native void fillConvexPoly_1(long var0, long var2, double var4, double var6, double var8, double var10, int var12);

    private static native void fillConvexPoly_2(long var0, long var2, double var4, double var6, double var8, double var10);

    private static native void fillPoly_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12, int var13, double var14, double var16);

    private static native void fillPoly_1(long var0, long var2, double var4, double var6, double var8, double var10, int var12, int var13);

    private static native void fillPoly_2(long var0, long var2, double var4, double var6, double var8, double var10, int var12);

    private static native void fillPoly_3(long var0, long var2, double var4, double var6, double var8, double var10);

    private static native void filter2D_0(long var0, long var2, int var4, long var5, double var7, double var9, double var11, int var13);

    private static native void filter2D_1(long var0, long var2, int var4, long var5, double var7, double var9, double var11);

    private static native void filter2D_2(long var0, long var2, int var4, long var5, double var7, double var9);

    private static native void filter2D_3(long var0, long var2, int var4, long var5);

    private static native void findContours_0(long var0, long var2, long var4, int var6, int var7, double var8, double var10);

    private static native void findContours_1(long var0, long var2, long var4, int var6, int var7);

    private static native double[] fitEllipseAMS_0(long var0);

    private static native double[] fitEllipseDirect_0(long var0);

    private static native double[] fitEllipse_0(long var0);

    private static native void fitLine_0(long var0, long var2, int var4, double var5, double var7, double var9);

    private static native int floodFill_0(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double var14, double[] var16, double var17, double var19, double var21, double var23, double var25, double var27, double var29, double var31, int var33);

    private static native int floodFill_1(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double var14, double[] var16, double var17, double var19, double var21, double var23, double var25, double var27, double var29, double var31);

    private static native int floodFill_2(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double var14, double[] var16, double var17, double var19, double var21, double var23);

    private static native int floodFill_3(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double var14, double[] var16);

    private static native int floodFill_4(long var0, long var2, double var4, double var6, double var8, double var10, double var12, double var14);

    public static float g(Mat mat, Mat mat2, int n10, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Imgproc.EMD_1(l10, l11, n10, l12);
    }

    public static void g0(Mat mat, Mat mat2, int n10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.bilateralFilter_1(l10, l11, n10, d10, d11);
    }

    public static LineSegmentDetector g1(int n10, double d10, double d11) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_5(n10, d10, d11));
    }

    public static void g2(Mat mat, Mat mat2, int n10, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.filter2D_3(l10, l11, n10, l12);
    }

    public static float g3(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Imgproc.intersectConvexConvex_1(l10, l11, l12);
    }

    public static void g4(Mat mat, w w10, y y10, int n10) {
        Object object = w10;
        long l10 = mat.a;
        int n11 = w10.a;
        int n12 = w10.b;
        int n13 = w10.c;
        int n14 = w10.d;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        int n15 = n11;
        n11 = n12;
        n12 = n13;
        n13 = n14;
        Imgproc.rectangle_6(l10, n15, n11, n12, n14, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    private static native long getAffineTransform_0(long var0, long var2);

    private static native void getDerivKernels_0(long var0, long var2, int var4, int var5, int var6, boolean var7, int var8);

    private static native void getDerivKernels_1(long var0, long var2, int var4, int var5, int var6, boolean var7);

    private static native void getDerivKernels_2(long var0, long var2, int var4, int var5, int var6);

    private static native double getFontScaleFromHeight_0(int var0, int var1, int var2);

    private static native double getFontScaleFromHeight_1(int var0, int var1);

    private static native long getGaborKernel_0(double var0, double var2, double var4, double var6, double var8, double var10, double var12, int var14);

    private static native long getGaborKernel_1(double var0, double var2, double var4, double var6, double var8, double var10, double var12);

    private static native long getGaborKernel_2(double var0, double var2, double var4, double var6, double var8, double var10);

    private static native long getGaussianKernel_0(int var0, double var1, int var3);

    private static native long getGaussianKernel_1(int var0, double var1);

    private static native long getPerspectiveTransform_0(long var0, long var2, int var4);

    private static native long getPerspectiveTransform_1(long var0, long var2);

    private static native void getRectSubPix_0(long var0, double var2, double var4, double var6, double var8, long var10, int var12);

    private static native void getRectSubPix_1(long var0, double var2, double var4, double var6, double var8, long var10);

    private static native long getRotationMatrix2D_0(double var0, double var2, double var4, double var6);

    private static native long getStructuringElement_0(int var0, double var1, double var3, double var5, double var7);

    private static native long getStructuringElement_1(int var0, double var1, double var3);

    private static native void goodFeaturesToTrack_0(long var0, long var2, int var4, double var5, double var7, long var9, int var11, int var12, boolean var13, double var14);

    private static native void goodFeaturesToTrack_1(long var0, long var2, int var4, double var5, double var7, long var9, int var11, int var12, boolean var13);

    private static native void goodFeaturesToTrack_2(long var0, long var2, int var4, double var5, double var7, long var9, int var11, int var12);

    private static native void goodFeaturesToTrack_3(long var0, long var2, int var4, double var5, double var7, long var9, int var11, boolean var12, double var13);

    private static native void goodFeaturesToTrack_4(long var0, long var2, int var4, double var5, double var7, long var9, int var11, boolean var12);

    private static native void goodFeaturesToTrack_5(long var0, long var2, int var4, double var5, double var7, long var9, int var11);

    private static native void goodFeaturesToTrack_6(long var0, long var2, int var4, double var5, double var7, long var9);

    private static native void goodFeaturesToTrack_7(long var0, long var2, int var4, double var5, double var7);

    private static native void grabCut_0(long var0, long var2, int var4, int var5, int var6, int var7, long var8, long var10, int var12, int var13);

    private static native void grabCut_1(long var0, long var2, int var4, int var5, int var6, int var7, long var8, long var10, int var12);

    public static float h(Mat mat, Mat mat2, int n10, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        return Imgproc.EMD_0(l10, l11, n10, l12, l13);
    }

    public static void h0(Mat mat, Mat mat2, int n10, double d10, double d11, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.bilateralFilter_0(l10, l11, n10, d10, d11, n11);
    }

    public static LineSegmentDetector h1(int n10, double d10, double d11, double d12) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_4(n10, d10, d11, d12));
    }

    public static void h2(Mat mat, Mat mat2, int n10, Mat mat3, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.filter2D_2(l10, l11, n10, l12, d10, d11);
    }

    public static float h3(Mat mat, Mat mat2, Mat mat3, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        return Imgproc.intersectConvexConvex_0(l10, l11, l12, bl2);
    }

    public static void h4(Mat mat, w w10, y y10, int n10, int n11) {
        Object object = w10;
        long l10 = mat.a;
        int n12 = w10.a;
        int n13 = w10.b;
        int n14 = w10.c;
        int n15 = w10.d;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        int n16 = n12;
        n12 = n13;
        n13 = n14;
        n14 = n15;
        Imgproc.rectangle_5(l10, n16, n12, n13, n15, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static void i(Mat mat, Mat mat2, z z10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        Imgproc.GaussianBlur_2(l10, l11, d11, d12, d10);
    }

    public static void i0(Mat mat, Mat mat2, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.blur_2(l10, l11, d10, d11);
    }

    public static LineSegmentDetector i1(int n10, double d10, double d11, double d12, double d13) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_3(n10, d10, d11, d12, d13));
    }

    public static void i2(Mat mat, Mat mat2, int n10, Mat mat3, u u10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.filter2D_1(l10, l11, n10, l12, d11, d12, d10);
    }

    public static void i3(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.invertAffineTransform_0(l10, l11);
    }

    public static void i4(Mat mat, w w10, y y10, int n10, int n11, int n12) {
        Object object = w10;
        long l10 = mat.a;
        int n13 = w10.a;
        int n14 = w10.b;
        int n15 = w10.c;
        int n16 = w10.d;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.rectangle_4(l10, n13, n14, n15, n16, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    private static native void integral2_0(long var0, long var2, long var4, int var6, int var7);

    private static native void integral2_1(long var0, long var2, long var4, int var6);

    private static native void integral2_2(long var0, long var2, long var4);

    private static native void integral3_0(long var0, long var2, long var4, long var6, int var8, int var9);

    private static native void integral3_1(long var0, long var2, long var4, long var6, int var8);

    private static native void integral3_2(long var0, long var2, long var4, long var6);

    private static native void integral_0(long var0, long var2, int var4);

    private static native void integral_1(long var0, long var2);

    private static native float intersectConvexConvex_0(long var0, long var2, long var4, boolean var6);

    private static native float intersectConvexConvex_1(long var0, long var2, long var4);

    private static native void invertAffineTransform_0(long var0, long var2);

    private static native boolean isContourConvex_0(long var0);

    public static void j(Mat mat, Mat mat2, z z10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = z10.a;
        double d13 = z10.b;
        Imgproc.GaussianBlur_1(l10, l11, d12, d13, d10, d11);
    }

    public static void j0(Mat mat, Mat mat2, z z10, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        Imgproc.blur_1(l10, l11, d10, d11, d12, d13);
    }

    public static LineSegmentDetector j1(int n10, double d10, double d11, double d12, double d13, double d14) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_2(n10, d10, d11, d12, d13, d14));
    }

    public static void j2(Mat mat, Mat mat2, int n10, Mat mat3, u u10, double d10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.filter2D_0(l10, l11, n10, l12, d11, d12, d10, n11);
    }

    public static boolean j3(p p10) {
        return Imgproc.isContourConvex_0(p10.a);
    }

    public static void j4(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.remap_2(l10, l11, l12, l13, n10);
    }

    public static void k(Mat mat, Mat mat2, z z10, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = z10.a;
        double d13 = z10.b;
        Imgproc.GaussianBlur_0(l10, l11, d12, d13, d10, d11, n10);
    }

    public static void k0(Mat mat, Mat mat2, z z10, u u10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l12 = l10;
        l10 = l11;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        Imgproc.blur_0(l12, l11, d14, d10, d11, d13, n10);
    }

    public static LineSegmentDetector k1(int n10, double d10, double d11, double d12, double d13, double d14, double d15) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_1(n10, d10, d11, d12, d13, d14, d15));
    }

    public static void k2(Mat mat, List list, Mat mat2, int n10, int n11) {
        Mat mat3 = new Mat();
        long l10 = mat.a;
        long l11 = mat3.a;
        long l12 = mat2.a;
        Imgproc.findContours_1(l10, l11, l12, n10, n11);
        i.f.h.a.u(mat3, list);
        mat3.u0();
    }

    public static void k3(Mat mat, u u10, u u11, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.line_3(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void k4(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.remap_1(l10, l11, l12, l13, n10, n11);
    }

    public static void l(Mat mat, Mat mat2, int n10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughCircles_4(l10, l11, n10, d10, d11);
    }

    public static w l0(Mat object) {
        object = Imgproc.boundingRect_0(((Mat)object).a);
        w w10 = new w((double[])object);
        return w10;
    }

    public static LineSegmentDetector l1(int n10, double d10, double d11, double d12, double d13, double d14, double d15, int n11) {
        return LineSegmentDetector.g(Imgproc.createLineSegmentDetector_0(n10, d10, d11, d12, d13, d14, d15, n11));
    }

    public static void l2(Mat mat, List list, Mat mat2, int n10, int n11, u u10) {
        Mat mat3 = new Mat();
        long l10 = mat.a;
        long l11 = mat3.a;
        long l12 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.findContours_0(l10, l11, l12, n10, n11, d10, d11);
        i.f.h.a.u(mat3, list);
        mat3.u0();
    }

    public static void l3(Mat mat, u u10, u u11, y y10, int n10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.line_2(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static void l4(Mat mat, Mat mat2, Mat mat3, Mat mat4, int n10, int n11, y y10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double[] dArray = y10.a;
        double d10 = dArray[0];
        double d11 = dArray[1];
        double d12 = dArray[2];
        double d13 = dArray[3];
        Imgproc.remap_0(l10, l11, l12, l13, n10, n11, d10, d11, d12, d13);
    }

    private static native void line_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19, int var20);

    private static native void line_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19);

    private static native void line_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18);

    private static native void line_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16);

    private static native void linearPolar_0(long var0, long var2, double var4, double var6, double var8, int var10);

    private static native void logPolar_0(long var0, long var2, double var4, double var6, double var8, int var10);

    public static void m(Mat mat, Mat mat2, int n10, double d10, double d11, double d12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughCircles_3(l10, l11, n10, d10, d11, d12);
    }

    public static void m0(Mat mat, Mat mat2, int n10, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.boxFilter_3(l10, l11, n10, d10, d11);
    }

    public static void m1(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cvtColor_1(l10, l11, n10);
    }

    public static x m2(m object) {
        object = Imgproc.fitEllipse_0(((Mat)object).a);
        x x10 = new x((double[])object);
        return x10;
    }

    public static void m3(Mat mat, u u10, u u11, y y10, int n10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.line_1(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11);
    }

    public static void m4(Mat mat, Mat mat2, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.resize_3(l10, l11, d10, d11);
    }

    private static native double matchShapes_0(long var0, long var2, int var4, double var5);

    private static native void matchTemplate_0(long var0, long var2, long var4, int var6, long var7);

    private static native void matchTemplate_1(long var0, long var2, long var4, int var6);

    private static native void medianBlur_0(long var0, long var2, int var4);

    private static native double[] minAreaRect_0(long var0);

    private static native void minEnclosingCircle_0(long var0, double[] var2, double[] var3);

    private static native double minEnclosingTriangle_0(long var0, long var2);

    private static native double[] moments_0(long var0, boolean var2);

    private static native double[] moments_1(long var0);

    private static native void morphologyEx_0(long var0, long var2, int var4, long var5, double var7, double var9, int var11, int var12, double var13, double var15, double var17, double var19);

    private static native void morphologyEx_1(long var0, long var2, int var4, long var5, double var7, double var9, int var11, int var12);

    private static native void morphologyEx_2(long var0, long var2, int var4, long var5, double var7, double var9, int var11);

    private static native void morphologyEx_3(long var0, long var2, int var4, long var5, double var7, double var9);

    private static native void morphologyEx_4(long var0, long var2, int var4, long var5);

    public static void n(Mat mat, Mat mat2, int n10, double d10, double d11, double d12, double d13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughCircles_2(l10, l11, n10, d10, d11, d12, d13);
    }

    public static void n0(Mat mat, Mat mat2, int n10, z z10, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        Imgproc.boxFilter_2(l10, l11, n10, d14, d10, d11, d13);
    }

    public static void n1(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.cvtColor_0(l10, l11, n10, n11);
    }

    public static x n2(Mat object) {
        object = Imgproc.fitEllipseAMS_0(((Mat)object).a);
        x x10 = new x((double[])object);
        return x10;
    }

    public static void n3(Mat mat, u u10, u u11, y y10, int n10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.line_0(l10, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5, n10, n11, n12);
    }

    public static void n4(Mat mat, Mat mat2, z z10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        Imgproc.resize_2(l10, l11, d11, d12, d10);
    }

    private static native double[] n_getTextSize(String var0, int var1, double var2, int var4, int[] var5);

    public static void o(Mat mat, Mat mat2, int n10, double d10, double d11, double d12, double d13, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughCircles_1(l10, l11, n10, d10, d11, d12, d13, n11);
    }

    public static void o0(Mat mat, Mat mat2, int n10, z z10, u u10, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l12 = l10;
        l10 = l11;
        Imgproc.boxFilter_1(l12, l11, n10, d10, d11, d12, d13, bl2);
    }

    public static void o1(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.cvtColorTwoPlane_0(l10, l11, l12, n10);
    }

    public static x o2(Mat object) {
        object = Imgproc.fitEllipseDirect_0(((Mat)object).a);
        x x10 = new x((double[])object);
        return x10;
    }

    public static void o3(Mat mat, Mat mat2, u u10, double d10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.linearPolar_0(l10, l11, d11, d12, d10, n10);
    }

    public static void o4(Mat mat, Mat mat2, z z10, double d10, double d11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = z10.a;
        double d13 = z10.b;
        Imgproc.resize_1(l10, l11, d12, d13, d10, d11);
    }

    public static void p(Mat mat, Mat mat2, int n10, double d10, double d11, double d12, double d13, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughCircles_0(l10, l11, n10, d10, d11, d12, d13, n11, n12);
    }

    public static void p0(Mat mat, Mat mat2, int n10, z z10, u u10, boolean bl2, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        long l12 = l10;
        l10 = l11;
        Imgproc.boxFilter_0(l12, l11, n10, d10, d11, d12, d13, bl2, n11);
    }

    public static void p1(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.demosaicing_1(l10, l11, n10);
    }

    public static void p2(Mat mat, Mat mat2, int n10, double d10, double d11, double d12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.fitLine_0(l10, l11, n10, d10, d11, d12);
    }

    public static void p3(Mat mat, Mat mat2, u u10, double d10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.logPolar_0(l10, l11, d11, d12, d10, n10);
    }

    public static void p4(Mat mat, Mat mat2, z z10, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d12 = z10.a;
        double d13 = z10.b;
        Imgproc.resize_0(l10, l11, d12, d13, d10, d11, n10);
    }

    private static native double[] phaseCorrelate_0(long var0, long var2, long var4, double[] var6);

    private static native double[] phaseCorrelate_1(long var0, long var2, long var4);

    private static native double[] phaseCorrelate_2(long var0, long var2);

    private static native double pointPolygonTest_0(long var0, double var2, double var4, boolean var6);

    private static native void polylines_0(long var0, long var2, boolean var4, double var5, double var7, double var9, double var11, int var13, int var14, int var15);

    private static native void polylines_1(long var0, long var2, boolean var4, double var5, double var7, double var9, double var11, int var13, int var14);

    private static native void polylines_2(long var0, long var2, boolean var4, double var5, double var7, double var9, double var11, int var13);

    private static native void polylines_3(long var0, long var2, boolean var4, double var5, double var7, double var9, double var11);

    private static native void preCornerDetect_0(long var0, long var2, int var4, int var5);

    private static native void preCornerDetect_1(long var0, long var2, int var4);

    private static native void putText_0(long var0, String var2, double var3, double var5, int var7, double var8, double var10, double var12, double var14, double var16, int var18, int var19, boolean var20);

    private static native void putText_1(long var0, String var2, double var3, double var5, int var7, double var8, double var10, double var12, double var14, double var16, int var18, int var19);

    private static native void putText_2(long var0, String var2, double var3, double var5, int var7, double var8, double var10, double var12, double var14, double var16, int var18);

    private static native void putText_3(long var0, String var2, double var3, double var5, int var7, double var8, double var10, double var12, double var14, double var16);

    private static native void pyrDown_0(long var0, long var2, double var4, double var6, int var8);

    private static native void pyrDown_1(long var0, long var2, double var4, double var6);

    private static native void pyrDown_2(long var0, long var2);

    private static native void pyrMeanShiftFiltering_0(long var0, long var2, double var4, double var6, int var8, int var9, int var10, double var11);

    private static native void pyrMeanShiftFiltering_1(long var0, long var2, double var4, double var6, int var8);

    private static native void pyrMeanShiftFiltering_2(long var0, long var2, double var4, double var6);

    private static native void pyrUp_0(long var0, long var2, double var4, double var6, int var8);

    private static native void pyrUp_1(long var0, long var2, double var4, double var6);

    private static native void pyrUp_2(long var0, long var2);

    public static void q(Mat mat, Mat mat2, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLines_4(l10, l11, d10, d11, n10);
    }

    public static void q0(x x10, Mat mat) {
        Object object = x10.a;
        double d10 = ((u)object).a;
        double d11 = ((u)object).b;
        object = x10.b;
        double d12 = ((z)object).a;
        double d13 = ((z)object).b;
        double d14 = x10.c;
        long l10 = mat.a;
        Imgproc.boxPoints_0(d10, d11, d12, d13, d14, l10);
    }

    public static void q1(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.demosaicing_0(l10, l11, n10, n11);
    }

    public static int q2(Mat mat, Mat mat2, u u10, y y10) {
        Object object = u10;
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        return Imgproc.floodFill_4(l10, l11, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static double q3(Mat mat, Mat mat2, int n10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.matchShapes_0(l10, l11, n10, d10);
    }

    public static int q4(x x10, x x11, Mat mat) {
        Object object = x10;
        Object object2 = x10.a;
        double d10 = ((u)object2).a;
        double d11 = ((u)object2).b;
        object2 = x10.b;
        double d12 = ((z)object2).a;
        double d13 = ((z)object2).b;
        double d14 = x10.c;
        object = x11.a;
        double d15 = ((u)object).a;
        double d16 = ((u)object).b;
        object = x11.b;
        double d17 = ((z)object).a;
        double d18 = ((z)object).b;
        double d19 = x11.c;
        object = mat;
        long l10 = mat.a;
        return Imgproc.rotatedRectangleIntersection_0(d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, l10);
    }

    public static void r(Mat mat, Mat mat2, double d10, double d11, int n10, double d12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLines_3(l10, l11, d10, d11, n10, d12);
    }

    public static void r0(List list, k k10, Mat mat, Mat mat2, i i10, double d10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = k10.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = i10.a;
        Imgproc.calcBackProject_0(l10, l11, l12, l13, l14, d10);
    }

    public static void r1(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.dilate_4(l10, l11, l12);
    }

    public static int r2(Mat mat, Mat mat2, u u10, y y10, w w10) {
        Object object = u10;
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        int n11 = 1;
        Object object3 = object[n11];
        int n12 = 2;
        Object object4 = object[n12];
        int n13 = 3;
        Object object5 = object[n13];
        int n14 = Imgproc.floodFill_3(l10, l11, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, dArray);
        if (w10 != null) {
            int n15;
            w10.a = n15 = (int)dArray[0];
            w10.b = n15 = (int)dArray[n11];
            w10.c = n15 = (int)dArray[n12];
            double d12 = dArray[n13];
            w10.d = n10 = (int)d12;
        }
        return n14;
    }

    public static void r3(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.matchTemplate_1(l10, l11, l12, n10);
    }

    public static void r4(Mat mat, Mat mat2, int n10, Mat mat3, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.sepFilter2D_3(l10, l11, n10, l12, l13);
    }

    private static native void rectangle_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19, int var20);

    private static native void rectangle_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18, int var19);

    private static native void rectangle_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, int var18);

    private static native void rectangle_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16);

    private static native void rectangle_4(long var0, int var2, int var3, int var4, int var5, double var6, double var8, double var10, double var12, int var14, int var15, int var16);

    private static native void rectangle_5(long var0, int var2, int var3, int var4, int var5, double var6, double var8, double var10, double var12, int var14, int var15);

    private static native void rectangle_6(long var0, int var2, int var3, int var4, int var5, double var6, double var8, double var10, double var12, int var14);

    private static native void rectangle_7(long var0, int var2, int var3, int var4, int var5, double var6, double var8, double var10, double var12);

    private static native void remap_0(long var0, long var2, long var4, long var6, int var8, int var9, double var10, double var12, double var14, double var16);

    private static native void remap_1(long var0, long var2, long var4, long var6, int var8, int var9);

    private static native void remap_2(long var0, long var2, long var4, long var6, int var8);

    private static native void resize_0(long var0, long var2, double var4, double var6, double var8, double var10, int var12);

    private static native void resize_1(long var0, long var2, double var4, double var6, double var8, double var10);

    private static native void resize_2(long var0, long var2, double var4, double var6, double var8);

    private static native void resize_3(long var0, long var2, double var4, double var6);

    private static native int rotatedRectangleIntersection_0(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18, long var20);

    public static void s(Mat mat, Mat mat2, double d10, double d11, int n10, double d12, double d13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLines_2(l10, l11, d10, d11, n10, d12, d13);
    }

    public static void s0(List list, k k10, Mat mat, Mat mat2, k k11, i i10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = k10.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = k11.a;
        long l15 = i10.a;
        Imgproc.calcHist_1(l10, l11, l12, l13, l14, l15);
    }

    public static void s1(Mat mat, Mat mat2, Mat mat3, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.dilate_3(l10, l11, l12, d10, d11);
    }

    public static int s2(Mat mat, Mat mat2, u u10, y y10, w w10, y y11) {
        Object object = u10;
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        int n11 = 1;
        Object object3 = object[n11];
        int n12 = 2;
        Object object4 = object[n12];
        int n13 = 3;
        Object object5 = object[n13];
        object = y11;
        object = y11.a;
        Object object6 = object[0];
        Object object7 = object[n11];
        Object object8 = object[n12];
        Object object9 = object[n13];
        int n14 = Imgproc.floodFill_2(l10, l11, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, dArray, (double)object6, (double)object7, (double)object8, (double)object9);
        if (w10 != null) {
            int n15;
            w10.a = n15 = (int)dArray[0];
            w10.b = n15 = (int)dArray[n11];
            w10.c = n15 = (int)dArray[n12];
            double d12 = dArray[n13];
            w10.d = n10 = (int)d12;
        }
        return n14;
    }

    public static void s3(Mat mat, Mat mat2, Mat mat3, int n10, Mat mat4) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        Imgproc.matchTemplate_0(l10, l11, l12, n10, l13);
    }

    public static void s4(Mat mat, Mat mat2, int n10, Mat mat3, Mat mat4, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d10 = u10.a;
        double d11 = u10.b;
        long l14 = l10;
        l10 = l11;
        Imgproc.sepFilter2D_2(l14, l11, n10, l12, l13, d10, d11);
    }

    private static native void sepFilter2D_0(long var0, long var2, int var4, long var5, long var7, double var9, double var11, double var13, int var15);

    private static native void sepFilter2D_1(long var0, long var2, int var4, long var5, long var7, double var9, double var11, double var13);

    private static native void sepFilter2D_2(long var0, long var2, int var4, long var5, long var7, double var9, double var11);

    private static native void sepFilter2D_3(long var0, long var2, int var4, long var5, long var7);

    private static native void spatialGradient_0(long var0, long var2, long var4, int var6, int var7);

    private static native void spatialGradient_1(long var0, long var2, long var4, int var6);

    private static native void spatialGradient_2(long var0, long var2, long var4);

    private static native void sqrBoxFilter_0(long var0, long var2, int var4, double var5, double var7, double var9, double var11, boolean var13, int var14);

    private static native void sqrBoxFilter_1(long var0, long var2, int var4, double var5, double var7, double var9, double var11, boolean var13);

    private static native void sqrBoxFilter_2(long var0, long var2, int var4, double var5, double var7, double var9, double var11);

    private static native void sqrBoxFilter_3(long var0, long var2, int var4, double var5, double var7);

    public static void t(Mat mat, Mat mat2, double d10, double d11, int n10, double d12, double d13, double d14) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLines_1(l10, l11, d10, d11, n10, d12, d13, d14);
    }

    public static void t0(List list, k k10, Mat mat, Mat mat2, k k11, i i10, boolean bl2) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = k10.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = k11.a;
        long l15 = i10.a;
        Imgproc.calcHist_0(l10, l11, l12, l13, l14, l15, bl2);
    }

    public static void t1(Mat mat, Mat mat2, Mat mat3, u u10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.dilate_2(l10, l11, l12, d10, d11, n10);
    }

    public static int t2(Mat mat, Mat mat2, u u10, y y10, w w10, y y11, y y12) {
        Object object = u10;
        int n10 = 4;
        double[] dArray = new double[n10];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        int n11 = 1;
        Object object3 = object[n11];
        int n12 = 2;
        Object object4 = object[n12];
        int n13 = 3;
        Object object5 = object[n13];
        object = y11;
        object = y11.a;
        Object object6 = object[0];
        Object object7 = object[n11];
        Object object8 = object[n12];
        Object object9 = object[n13];
        object = y12;
        object = y12.a;
        Object object10 = object[0];
        Object object11 = object[n11];
        Object object12 = object[n12];
        Object object13 = object[n13];
        int n14 = Imgproc.floodFill_1(l10, l11, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, dArray, (double)object6, (double)object7, (double)object8, (double)object9, (double)object10, (double)object11, (double)object12, (double)object13);
        if (w10 != null) {
            int n15;
            w10.a = n15 = (int)dArray[0];
            w10.b = n15 = (int)dArray[n11];
            w10.c = n15 = (int)dArray[n12];
            double d12 = dArray[n13];
            w10.d = n10 = (int)d12;
        }
        return n14;
    }

    public static void t3(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.medianBlur_0(l10, l11, n10);
    }

    public static void t4(Mat mat, Mat mat2, int n10, Mat mat3, Mat mat4, u u10, double d10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.sepFilter2D_1(l10, l11, n10, l12, l13, d11, d12, d10);
    }

    private static native double threshold_0(long var0, long var2, double var4, double var6, int var8);

    public static void u(Mat mat, Mat mat2, double d10, double d11, int n10, double d12, double d13, double d14, double d15) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLines_0(l10, l11, d10, d11, n10, d12, d13, d14, d15);
    }

    public static void u0(Mat mat, u u10, int n10, y y10) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.circle_3(l10, d10, d11, n10, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void u1(Mat mat, Mat mat2, Mat mat3, u u10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        Imgproc.dilate_1(l10, l11, l12, d10, d11, n10, n11);
    }

    public static int u2(Mat mat, Mat mat2, u u10, y y10, w w10, y y11, y y12, int n10) {
        Object object = u10;
        int n11 = 4;
        double[] dArray = new double[n11];
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        int n12 = 1;
        Object object3 = object[n12];
        int n13 = 2;
        Object object4 = object[n13];
        int n14 = 3;
        Object object5 = object[n14];
        object = y11;
        object = y11.a;
        Object object6 = object[0];
        Object object7 = object[n12];
        Object object8 = object[n13];
        Object object9 = object[n14];
        object = y12;
        object = y12.a;
        Object object10 = object[0];
        Object object11 = object[n12];
        Object object12 = object[n13];
        Object object13 = object[n14];
        int n15 = Imgproc.floodFill_0(l10, l11, d10, d11, (double)object2, (double)object3, (double)object4, (double)object5, dArray, (double)object6, (double)object7, (double)object8, (double)object9, (double)object10, (double)object11, (double)object12, (double)object13, n10);
        if (w10 != null) {
            w10.a = n11 = (int)dArray[0];
            w10.b = n11 = (int)dArray[n12];
            w10.c = n11 = (int)dArray[n13];
            double d12 = dArray[n14];
            w10.d = n11 = (int)d12;
        }
        return n15;
    }

    public static x u3(m object) {
        object = Imgproc.minAreaRect_0(((Mat)object).a);
        x x10 = new x((double[])object);
        return x10;
    }

    public static void u4(Mat mat, Mat mat2, int n10, Mat mat3, Mat mat4, u u10, double d10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        long l13 = mat4.a;
        double d11 = u10.a;
        double d12 = u10.b;
        Imgproc.sepFilter2D_0(l10, l11, n10, l12, l13, d11, d12, d10, n11);
    }

    public static void v(Mat mat, Mat mat2, double d10, double d11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLinesP_2(l10, l11, d10, d11, n10);
    }

    public static void v0(Mat mat, u u10, int n10, y y10, int n11) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.circle_2(l10, d10, d11, n10, (double)object2, (double)object3, (double)object4, (double)object5, n11);
    }

    public static void v1(Mat mat, Mat mat2, Mat mat3, u u10, int n10, int n11, y y10) {
        Object object = u10;
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.dilate_0(l10, l11, l12, d10, d11, n10, n11, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static Mat v2(m m10, m m11) {
        long l10 = m10.a;
        long l11 = m11.a;
        l11 = Imgproc.getAffineTransform_0(l10, l11);
        Mat mat = new Mat(l11);
        return mat;
    }

    public static void v3(m m10, u u10, float[] fArray) {
        int n10 = 2;
        double[] dArray = new double[n10];
        int n11 = 1;
        double[] dArray2 = new double[n11];
        long l10 = m10.a;
        Imgproc.minEnclosingCircle_0(l10, dArray, dArray2);
        m10 = null;
        if (u10 != null) {
            double d10;
            u10.a = d10 = dArray[0];
            u10.b = d10 = dArray[n11];
        }
        if (fArray != null) {
            float f10;
            double d11 = dArray2[0];
            fArray[0] = f10 = (float)d11;
        }
    }

    public static void v4(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.spatialGradient_2(l10, l11, l12);
    }

    public static void w(Mat mat, Mat mat2, double d10, double d11, int n10, double d12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLinesP_1(l10, l11, d10, d11, n10, d12);
    }

    public static void w0(Mat mat, u u10, int n10, y y10, int n11, int n12) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.circle_1(l10, d10, d11, n10, (double)object2, (double)object3, (double)object4, (double)object5, n11, n12);
    }

    public static void w1(Mat mat, Mat mat2, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.distanceTransform_1(l10, l11, n10, n11);
    }

    public static void w2(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.getDerivKernels_2(l10, l11, n10, n11, n12);
    }

    public static double w3(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.minEnclosingTriangle_0(l10, l11);
    }

    public static void w4(Mat mat, Mat mat2, Mat mat3, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.spatialGradient_1(l10, l11, l12, n10);
    }

    private static native void warpAffine_0(long var0, long var2, long var4, double var6, double var8, int var10, int var11, double var12, double var14, double var16, double var18);

    private static native void warpAffine_1(long var0, long var2, long var4, double var6, double var8, int var10, int var11);

    private static native void warpAffine_2(long var0, long var2, long var4, double var6, double var8, int var10);

    private static native void warpAffine_3(long var0, long var2, long var4, double var6, double var8);

    private static native void warpPerspective_0(long var0, long var2, long var4, double var6, double var8, int var10, int var11, double var12, double var14, double var16, double var18);

    private static native void warpPerspective_1(long var0, long var2, long var4, double var6, double var8, int var10, int var11);

    private static native void warpPerspective_2(long var0, long var2, long var4, double var6, double var8, int var10);

    private static native void warpPerspective_3(long var0, long var2, long var4, double var6, double var8);

    private static native void warpPolar_0(long var0, long var2, double var4, double var6, double var8, double var10, double var12, int var14);

    private static native void watershed_0(long var0, long var2);

    public static void x(Mat mat, Mat mat2, double d10, double d11, int n10, double d12, double d13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLinesP_0(l10, l11, d10, d11, n10, d12, d13);
    }

    public static void x0(Mat mat, u u10, int n10, y y10, int n11, int n12, int n13) {
        Object object = u10;
        long l10 = mat.a;
        double d10 = u10.a;
        double d11 = u10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Imgproc.circle_0(l10, d10, d11, n10, (double)object2, (double)object3, (double)object4, (double)object5, n11, n12, n13);
    }

    public static void x1(Mat mat, Mat mat2, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.distanceTransform_0(l10, l11, n10, n11, n12);
    }

    public static void x2(Mat mat, Mat mat2, int n10, int n11, int n12, boolean bl2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.getDerivKernels_1(l10, l11, n10, n11, n12, bl2);
    }

    public static a x3(Mat object) {
        object = Imgproc.moments_1(((Mat)object).a);
        a a10 = new a((double[])object);
        return a10;
    }

    public static void x4(Mat mat, Mat mat2, Mat mat3, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.spatialGradient_0(l10, l11, l12, n10, n11);
    }

    public static void y(Mat mat, Mat mat2, int n10, int n11, double d10, double d11, double d12, double d13, double d14, double d15) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.HoughLinesPointSet_0(l10, l11, n10, n11, d10, d11, d12, d13, d14, d15);
    }

    public static boolean y0(w w10, u u10, u u11) {
        u u12 = u11;
        int n10 = 2;
        double[] dArray = new double[n10];
        double[] dArray2 = new double[n10];
        int n11 = w10.a;
        int n12 = w10.b;
        int n13 = w10.c;
        int n14 = w10.d;
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = u11.a;
        double d13 = u11.b;
        boolean bl2 = Imgproc.clipLine_0(n11, n12, n13, n14, d10, d11, dArray, d12, d13, dArray2);
        int n15 = 1;
        n11 = 0;
        if (u10 != null) {
            double d14;
            u10.a = d14 = dArray[0];
            u10.b = d14 = dArray[n15];
        }
        if (u12 != null) {
            double d15;
            u12.a = d15 = dArray2[0];
            u12.b = d15 = dArray2[n15];
        }
        return bl2;
    }

    public static void y1(Mat mat, Mat mat2, Mat mat3, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.distanceTransformWithLabels_1(l10, l11, l12, n10, n11);
    }

    public static void y2(Mat mat, Mat mat2, int n10, int n11, int n12, boolean bl2, int n13) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Imgproc.getDerivKernels_0(l10, l11, n10, n11, n12, bl2, n13);
    }

    public static a y3(Mat object, boolean bl2) {
        object = Imgproc.moments_0(((Mat)object).a, bl2);
        a a10 = new a((double[])object);
        return a10;
    }

    public static void y4(Mat mat, Mat mat2, int n10, z z10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Imgproc.sqrBoxFilter_3(l10, l11, n10, d10, d11);
    }

    public static void z(a a10, Mat mat) {
        double d10 = a10.a;
        double d11 = a10.b;
        double d12 = a10.c;
        double d13 = a10.d;
        double d14 = a10.e;
        double d15 = a10.f;
        double d16 = a10.g;
        double d17 = d10;
        double d18 = a10.h;
        double d19 = a10.i;
        double d20 = a10.j;
        long l10 = mat.a;
        d10 = d17;
        Imgproc.HuMoments_0(d17, d11, d12, d13, d14, d15, d16, d18, d19, d20, l10);
    }

    public static double z0(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        return Imgproc.compareHist_0(l10, l11, n10);
    }

    public static void z1(Mat mat, Mat mat2, Mat mat3, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.distanceTransformWithLabels_0(l10, l11, l12, n10, n11, n12);
    }

    public static double z2(int n10, int n11) {
        return Imgproc.getFontScaleFromHeight_1(n10, n11);
    }

    public static void z3(Mat mat, Mat mat2, int n10, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Imgproc.morphologyEx_4(l10, l11, n10, l12);
    }

    public static void z4(Mat mat, Mat mat2, int n10, z z10, u u10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = u10.a;
        double d13 = u10.b;
        double d14 = d10;
        d10 = d11;
        d11 = d12;
        d12 = d13;
        Imgproc.sqrBoxFilter_2(l10, l11, n10, d14, d10, d11, d13);
    }
}

