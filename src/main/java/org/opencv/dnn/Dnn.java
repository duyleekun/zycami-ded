/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import i.f.c.d;
import i.f.c.i;
import i.f.c.k;
import i.f.c.q;
import i.f.c.r;
import i.f.c.s;
import i.f.c.y;
import i.f.c.z;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.dnn.Net;

public class Dnn {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    public static final int k = 5;

    public static Net A(String string2, String string3) {
        long l10 = Dnn.readNet_3(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    public static Net B(String string2, String string3, String string4) {
        long l10 = Dnn.readNet_2(string2, string3, string4);
        Net net = new Net(l10);
        return net;
    }

    public static Net C(String string2, d d10) {
        long l10 = d10.a;
        long l11 = Dnn.readNet_1(string2, l10);
        Net net = new Net(l11);
        return net;
    }

    public static Net D(String string2, d d10, d d11) {
        long l10 = d10.a;
        long l11 = d11.a;
        long l12 = Dnn.readNet_0(string2, l10, l11);
        Net net = new Net(l12);
        return net;
    }

    public static Net E(String string2) {
        long l10 = Dnn.readNetFromCaffe_1(string2);
        Net net = new Net(l10);
        return net;
    }

    public static Net F(String string2, String string3) {
        long l10 = Dnn.readNetFromCaffe_0(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    public static Net G(d d10) {
        long l10 = Dnn.readNetFromCaffe_3(d10.a);
        Net net = new Net(l10);
        return net;
    }

    public static Net H(d d10, d d11) {
        long l10 = d10.a;
        long l11 = d11.a;
        l11 = Dnn.readNetFromCaffe_2(l10, l11);
        Net net = new Net(l11);
        return net;
    }

    public static Net I(String string2) {
        long l10 = Dnn.readNetFromDarknet_1(string2);
        Net net = new Net(l10);
        return net;
    }

    public static Net J(String string2, String string3) {
        long l10 = Dnn.readNetFromDarknet_0(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    public static Net K(d d10) {
        long l10 = Dnn.readNetFromDarknet_3(d10.a);
        Net net = new Net(l10);
        return net;
    }

    public static Net L(d d10, d d11) {
        long l10 = d10.a;
        long l11 = d11.a;
        l11 = Dnn.readNetFromDarknet_2(l10, l11);
        Net net = new Net(l11);
        return net;
    }

    public static Net M(String string2, String string3) {
        long l10 = Dnn.readNetFromModelOptimizer_0(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    public static Net N(String string2) {
        long l10 = Dnn.readNetFromONNX_0(string2);
        Net net = new Net(l10);
        return net;
    }

    private static native void NMSBoxesRotated_0(long var0, long var2, float var4, float var5, long var6, float var8, int var9);

    private static native void NMSBoxesRotated_1(long var0, long var2, float var4, float var5, long var6, float var8);

    private static native void NMSBoxesRotated_2(long var0, long var2, float var4, float var5, long var6);

    private static native void NMSBoxes_0(long var0, long var2, float var4, float var5, long var6, float var8, int var9);

    private static native void NMSBoxes_1(long var0, long var2, float var4, float var5, long var6, float var8);

    private static native void NMSBoxes_2(long var0, long var2, float var4, float var5, long var6);

    private static native void NMSBoxes_3(long var0, long var2, float var4, float var5, long var6, float var8, int var9);

    private static native void NMSBoxes_4(long var0, long var2, float var4, float var5, long var6, float var8);

    private static native void NMSBoxes_5(long var0, long var2, float var4, float var5, long var6);

    public static Net O(d d10) {
        long l10 = Dnn.readNetFromONNX_1(d10.a);
        Net net = new Net(l10);
        return net;
    }

    public static Net P(String string2) {
        long l10 = Dnn.readNetFromTensorflow_1(string2);
        Net net = new Net(l10);
        return net;
    }

    public static Net Q(String string2, String string3) {
        long l10 = Dnn.readNetFromTensorflow_0(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    public static Net R(d d10) {
        long l10 = Dnn.readNetFromTensorflow_3(d10.a);
        Net net = new Net(l10);
        return net;
    }

    public static Net S(d d10, d d11) {
        long l10 = d10.a;
        long l11 = d11.a;
        l11 = Dnn.readNetFromTensorflow_2(l10, l11);
        Net net = new Net(l11);
        return net;
    }

    public static Net T(String string2) {
        long l10 = Dnn.readNetFromTorch_2(string2);
        Net net = new Net(l10);
        return net;
    }

    public static Net U(String string2, boolean bl2) {
        long l10 = Dnn.readNetFromTorch_1(string2, bl2);
        Net net = new Net(l10);
        return net;
    }

    public static Net V(String string2, boolean bl2, boolean bl3) {
        long l10 = Dnn.readNetFromTorch_0(string2, bl2, bl3);
        Net net = new Net(l10);
        return net;
    }

    public static Mat W(String string2) {
        long l10 = Dnn.readTensorFromONNX_0(string2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat X(String string2) {
        long l10 = Dnn.readTorchBlob_1(string2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat Y(String string2, boolean bl2) {
        long l10 = Dnn.readTorchBlob_0(string2, bl2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static void Z() {
        Dnn.resetMyriadDevice_0();
    }

    public static void a(q q10, i i10, float f10, float f11, k k10) {
        long l10 = q10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_5(l10, l11, f10, f11, l12);
    }

    public static void a0(String string2, String string3) {
        Dnn.shrinkCaffeModel_1(string2, string3);
    }

    public static void b(q q10, i i10, float f10, float f11, k k10, float f12) {
        long l10 = q10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_4(l10, l11, f10, f11, l12, f12);
    }

    public static void b0(String string2, String string3, List list) {
        Dnn.shrinkCaffeModel_0(string2, string3, list);
    }

    private static native long blobFromImage_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16, boolean var17, int var18);

    private static native long blobFromImage_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16, boolean var17);

    private static native long blobFromImage_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16);

    private static native long blobFromImage_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14);

    private static native long blobFromImage_4(long var0, double var2, double var4, double var6);

    private static native long blobFromImage_5(long var0, double var2);

    private static native long blobFromImage_6(long var0);

    private static native long blobFromImages_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16, boolean var17, int var18);

    private static native long blobFromImages_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16, boolean var17);

    private static native long blobFromImages_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16);

    private static native long blobFromImages_3(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14);

    private static native long blobFromImages_4(long var0, double var2, double var4, double var6);

    private static native long blobFromImages_5(long var0, double var2);

    private static native long blobFromImages_6(long var0);

    public static void c(q q10, i i10, float f10, float f11, k k10, float f12, int n10) {
        long l10 = q10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_3(l10, l11, f10, f11, l12, f12, n10);
    }

    public static void c0(String string2, String string3) {
        Dnn.writeTextGraph_0(string2, string3);
    }

    public static void d(r r10, i i10, float f10, float f11, k k10) {
        long l10 = r10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_2(l10, l11, f10, f11, l12);
    }

    public static void e(r r10, i i10, float f10, float f11, k k10, float f12) {
        long l10 = r10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_1(l10, l11, f10, f11, l12, f12);
    }

    public static void f(r r10, i i10, float f10, float f11, k k10, float f12, int n10) {
        long l10 = r10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxes_0(l10, l11, f10, f11, l12, f12, n10);
    }

    public static void g(s s10, i i10, float f10, float f11, k k10) {
        long l10 = s10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxesRotated_2(l10, l11, f10, f11, l12);
    }

    private static native String getInferenceEngineVPUType_0();

    public static void h(s s10, i i10, float f10, float f11, k k10, float f12) {
        long l10 = s10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxesRotated_1(l10, l11, f10, f11, l12, f12);
    }

    public static void i(s s10, i i10, float f10, float f11, k k10, float f12, int n10) {
        long l10 = s10.a;
        long l11 = i10.a;
        long l12 = k10.a;
        Dnn.NMSBoxesRotated_0(l10, l11, f10, f11, l12, f12, n10);
    }

    private static native void imagesFromBlob_0(long var0, long var2);

    public static Mat j(Mat mat) {
        long l10 = Dnn.blobFromImage_6(mat.a);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat k(Mat mat, double d10) {
        long l10 = Dnn.blobFromImage_5(mat.a, d10);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat l(Mat mat, double d10, z z10) {
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l11 = Dnn.blobFromImage_4(l10, d10, d11, d12);
        Mat mat2 = new Mat(l11);
        return mat2;
    }

    public static Mat m(Mat mat, double d10, z z10, y y10) {
        Object object = z10;
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        l10 = Dnn.blobFromImage_3(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat n(Mat mat, double d10, z z10, y y10, boolean bl2) {
        Mat mat2;
        Object object = z10;
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat2;
        l10 = Dnn.blobFromImage_2(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2);
        mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat o(Mat mat, double d10, z z10, y y10, boolean bl2, boolean bl3) {
        Mat mat2;
        Object object = z10;
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat2;
        l10 = Dnn.blobFromImage_1(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2, bl3);
        mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat p(Mat mat, double d10, z z10, y y10, boolean bl2, boolean bl3, int n10) {
        Mat mat2;
        Object object = z10;
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat2;
        l10 = Dnn.blobFromImage_0(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2, bl3, n10);
        mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat q(List object) {
        object = i.f.h.a.A((List)object);
        long l10 = Dnn.blobFromImages_6(((Mat)object).a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat r(List object, double d10) {
        object = i.f.h.a.A((List)object);
        long l10 = Dnn.blobFromImages_5(((Mat)object).a, d10);
        Mat mat = new Mat(l10);
        return mat;
    }

    private static native long readNetFromCaffe_0(String var0, String var1);

    private static native long readNetFromCaffe_1(String var0);

    private static native long readNetFromCaffe_2(long var0, long var2);

    private static native long readNetFromCaffe_3(long var0);

    private static native long readNetFromDarknet_0(String var0, String var1);

    private static native long readNetFromDarknet_1(String var0);

    private static native long readNetFromDarknet_2(long var0, long var2);

    private static native long readNetFromDarknet_3(long var0);

    private static native long readNetFromModelOptimizer_0(String var0, String var1);

    private static native long readNetFromONNX_0(String var0);

    private static native long readNetFromONNX_1(long var0);

    private static native long readNetFromTensorflow_0(String var0, String var1);

    private static native long readNetFromTensorflow_1(String var0);

    private static native long readNetFromTensorflow_2(long var0, long var2);

    private static native long readNetFromTensorflow_3(long var0);

    private static native long readNetFromTorch_0(String var0, boolean var1, boolean var2);

    private static native long readNetFromTorch_1(String var0, boolean var1);

    private static native long readNetFromTorch_2(String var0);

    private static native long readNet_0(String var0, long var1, long var3);

    private static native long readNet_1(String var0, long var1);

    private static native long readNet_2(String var0, String var1, String var2);

    private static native long readNet_3(String var0, String var1);

    private static native long readNet_4(String var0);

    private static native long readTensorFromONNX_0(String var0);

    private static native long readTorchBlob_0(String var0, boolean var1);

    private static native long readTorchBlob_1(String var0);

    private static native void resetMyriadDevice_0();

    public static Mat s(List object, double d10, z z10) {
        object = i.f.h.a.A((List)object);
        long l10 = ((Mat)object).a;
        double d11 = z10.a;
        double d12 = z10.b;
        long l11 = Dnn.blobFromImages_4(l10, d10, d11, d12);
        Mat mat = new Mat(l11);
        return mat;
    }

    private static native void shrinkCaffeModel_0(String var0, String var1, List var2);

    private static native void shrinkCaffeModel_1(String var0, String var1);

    public static Mat t(List list, double d10, z z10, y y10) {
        Object object = z10;
        Mat mat = i.f.h.a.A(list);
        long l10 = mat.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        long l11 = Dnn.blobFromImages_3(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5);
        Mat mat2 = new Mat(l11);
        return mat2;
    }

    public static Mat u(List list, double d10, z z10, y y10, boolean bl2) {
        Mat mat;
        Object object = z10;
        Mat mat2 = i.f.h.a.A(list);
        long l10 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat;
        l10 = Dnn.blobFromImages_2(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2);
        mat = new Mat(l10);
        return mat;
    }

    public static Mat v(List list, double d10, z z10, y y10, boolean bl2, boolean bl3) {
        Mat mat;
        Object object = z10;
        Mat mat2 = i.f.h.a.A(list);
        long l10 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat;
        l10 = Dnn.blobFromImages_1(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2, bl3);
        mat = new Mat(l10);
        return mat;
    }

    public static Mat w(List list, double d10, z z10, y y10, boolean bl2, boolean bl3, int n10) {
        Mat mat;
        Object object = z10;
        Mat mat2 = i.f.h.a.A(list);
        long l10 = mat2.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = mat;
        l10 = Dnn.blobFromImages_0(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2, bl3, n10);
        mat = new Mat(l10);
        return mat;
    }

    private static native void writeTextGraph_0(String var0, String var1);

    public static String x() {
        return Dnn.getInferenceEngineVPUType_0();
    }

    public static void y(Mat mat, List list) {
        Mat mat2 = new Mat();
        long l10 = mat.a;
        long l11 = mat2.a;
        Dnn.imagesFromBlob_0(l10, l11);
        i.f.h.a.c(mat2, list);
        mat2.u0();
    }

    public static Net z(String string2) {
        long l10 = Dnn.readNet_4(string2);
        Net net = new Net(l10);
        return net;
    }
}

