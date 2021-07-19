/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgcodecs;

import i.f.c.d;
import i.f.c.k;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;

public class Imgcodecs {
    public static final int A = 32;
    public static final int B = 33;
    public static final int C = 64;
    public static final int D = 65;
    public static final int E = 128;
    public static final int F = 0;
    public static final int G = 1;
    public static final int H = 2;
    public static final int I = 3;
    public static final int J = 4;
    public static final int K = 5;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 16;
    public static final int h = 17;
    public static final int i = 18;
    public static final int j = 32;
    public static final int k = 48;
    public static final int l = 64;
    public static final int m = 128;
    public static final int n = 256;
    public static final int o = 257;
    public static final int p = 258;
    public static final int q = 259;
    public static final int r = 272;
    public static final int s = 255;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    public static final int y = 16;
    public static final int z = 17;

    public static boolean a(String string2) {
        return Imgcodecs.haveImageReader_0(string2);
    }

    public static boolean b(String string2) {
        return Imgcodecs.haveImageWriter_0(string2);
    }

    public static Mat c(Mat mat, int n10) {
        long l10 = Imgcodecs.imdecode_0(mat.a, n10);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static boolean d(String string2, Mat mat, d d10) {
        long l10 = mat.a;
        long l11 = d10.a;
        return Imgcodecs.imencode_1(string2, l10, l11);
    }

    public static boolean e(String string2, Mat mat, d d10, k k10) {
        long l10 = mat.a;
        long l11 = d10.a;
        long l12 = k10.a;
        return Imgcodecs.imencode_0(string2, l10, l11, l12);
    }

    public static Mat f(String string2) {
        long l10 = Imgcodecs.imread_1(string2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat g(String string2, int n10) {
        long l10 = Imgcodecs.imread_0(string2, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static boolean h(String string2, List list) {
        Mat mat = new Mat();
        long l10 = mat.a;
        boolean bl2 = Imgcodecs.imreadmulti_1(string2, l10);
        i.f.h.a.c(mat, list);
        mat.u0();
        return bl2;
    }

    private static native boolean haveImageReader_0(String var0);

    private static native boolean haveImageWriter_0(String var0);

    public static boolean i(String string2, List list, int n10) {
        Mat mat = new Mat();
        long l10 = mat.a;
        boolean bl2 = Imgcodecs.imreadmulti_0(string2, l10, n10);
        i.f.h.a.c(mat, list);
        mat.u0();
        return bl2;
    }

    private static native long imdecode_0(long var0, int var2);

    private static native boolean imencode_0(String var0, long var1, long var3, long var5);

    private static native boolean imencode_1(String var0, long var1, long var3);

    private static native long imread_0(String var0, int var1);

    private static native long imread_1(String var0);

    private static native boolean imreadmulti_0(String var0, long var1, int var3);

    private static native boolean imreadmulti_1(String var0, long var1);

    private static native boolean imwrite_0(String var0, long var1, long var3);

    private static native boolean imwrite_1(String var0, long var1);

    public static boolean j(String string2, Mat mat) {
        long l10 = mat.a;
        return Imgcodecs.imwrite_1(string2, l10);
    }

    public static boolean k(String string2, Mat mat, k k10) {
        long l10 = mat.a;
        long l11 = k10.a;
        return Imgcodecs.imwrite_0(string2, l10, l11);
    }
}

