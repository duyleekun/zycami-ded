/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.objdetect;

import i.f.c.f;
import i.f.c.k;
import i.f.c.r;
import i.f.c.z;
import org.opencv.core.Mat;

public class CascadeClassifier {
    public final long a;

    public CascadeClassifier() {
        long l10;
        this.a = l10 = CascadeClassifier.CascadeClassifier_1();
    }

    public CascadeClassifier(long l10) {
        this.a = l10;
    }

    public CascadeClassifier(String string2) {
        long l10;
        this.a = l10 = CascadeClassifier.CascadeClassifier_0(string2);
    }

    private static native long CascadeClassifier_0(String var0);

    private static native long CascadeClassifier_1();

    public static CascadeClassifier a(long l10) {
        CascadeClassifier cascadeClassifier = new CascadeClassifier(l10);
        return cascadeClassifier;
    }

    public static boolean b(String string2, String string3) {
        return CascadeClassifier.convert_0(string2, string3);
    }

    private static native boolean convert_0(String var0, String var1);

    private static native void delete(long var0);

    private static native void detectMultiScale2_0(long var0, long var2, long var4, long var6, double var8, int var10, int var11, double var12, double var14, double var16, double var18);

    private static native void detectMultiScale2_1(long var0, long var2, long var4, long var6, double var8, int var10, int var11, double var12, double var14);

    private static native void detectMultiScale2_2(long var0, long var2, long var4, long var6, double var8, int var10, int var11);

    private static native void detectMultiScale2_3(long var0, long var2, long var4, long var6, double var8, int var10);

    private static native void detectMultiScale2_4(long var0, long var2, long var4, long var6, double var8);

    private static native void detectMultiScale2_5(long var0, long var2, long var4, long var6);

    private static native void detectMultiScale3_0(long var0, long var2, long var4, long var6, long var8, double var10, int var12, int var13, double var14, double var16, double var18, double var20, boolean var22);

    private static native void detectMultiScale3_1(long var0, long var2, long var4, long var6, long var8, double var10, int var12, int var13, double var14, double var16, double var18, double var20);

    private static native void detectMultiScale3_2(long var0, long var2, long var4, long var6, long var8, double var10, int var12, int var13, double var14, double var16);

    private static native void detectMultiScale3_3(long var0, long var2, long var4, long var6, long var8, double var10, int var12, int var13);

    private static native void detectMultiScale3_4(long var0, long var2, long var4, long var6, long var8, double var10, int var12);

    private static native void detectMultiScale3_5(long var0, long var2, long var4, long var6, long var8, double var10);

    private static native void detectMultiScale3_6(long var0, long var2, long var4, long var6, long var8);

    private static native void detectMultiScale_0(long var0, long var2, long var4, double var6, int var8, int var9, double var10, double var12, double var14, double var16);

    private static native void detectMultiScale_1(long var0, long var2, long var4, double var6, int var8, int var9, double var10, double var12);

    private static native void detectMultiScale_2(long var0, long var2, long var4, double var6, int var8, int var9);

    private static native void detectMultiScale_3(long var0, long var2, long var4, double var6, int var8);

    private static native void detectMultiScale_4(long var0, long var2, long var4, double var6);

    private static native void detectMultiScale_5(long var0, long var2, long var4);

    private static native boolean empty_0(long var0);

    private static native int getFeatureType_0(long var0);

    private static native double[] getOriginalWindowSize_0(long var0);

    private static native boolean isOldFormatCascade_0(long var0);

    private static native boolean load_0(long var0, String var2);

    public boolean A(String string2) {
        return CascadeClassifier.load_0(this.a, string2);
    }

    public void c(Mat mat, r r10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        CascadeClassifier.detectMultiScale_5(l10, l11, l12);
    }

    public void d(Mat mat, r r10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        CascadeClassifier.detectMultiScale_4(l10, l11, l12, d10);
    }

    public void e(Mat mat, r r10, double d10, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        CascadeClassifier.detectMultiScale_3(l10, l11, l12, d10, n10);
    }

    public void f(Mat mat, r r10, double d10, int n10, int n11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        CascadeClassifier.detectMultiScale_2(l10, l11, l12, d10, n10, n11);
    }

    public void finalize() {
        CascadeClassifier.delete(this.a);
    }

    public void g(Mat mat, r r10, double d10, int n10, int n11, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        CascadeClassifier.detectMultiScale_1(l10, l11, l12, d10, n10, n11, d11, d12);
    }

    public void h(Mat mat, r r10, double d10, int n10, int n11, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        CascadeClassifier.detectMultiScale_0(l10, l11, l12, d10, n10, n11, d11, d12, d13, d14);
    }

    public void i(Mat mat, r r10, k k10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        CascadeClassifier.detectMultiScale2_5(l10, l11, l12, l13);
    }

    public void j(Mat mat, r r10, k k10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        CascadeClassifier.detectMultiScale2_4(l10, l11, l12, l13, d10);
    }

    public void k(Mat mat, r r10, k k10, double d10, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        CascadeClassifier.detectMultiScale2_3(l10, l11, l12, l13, d10, n10);
    }

    public void l(Mat mat, r r10, k k10, double d10, int n10, int n11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        CascadeClassifier.detectMultiScale2_2(l10, l11, l12, l13, d10, n10, n11);
    }

    public void m(Mat mat, r r10, k k10, double d10, int n10, int n11, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        CascadeClassifier.detectMultiScale2_1(l10, l11, l12, l13, d10, n10, n11, d11, d12);
    }

    public void n(Mat mat, r r10, k k10, double d10, int n10, int n11, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        CascadeClassifier.detectMultiScale2_0(l10, l11, l12, l13, d10, n10, n11, d11, d12, d13, d14);
    }

    public void o(Mat mat, r r10, k k10, f f10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        CascadeClassifier.detectMultiScale3_6(l10, l11, l12, l13, l14);
    }

    public void p(Mat mat, r r10, k k10, f f10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        CascadeClassifier.detectMultiScale3_5(l10, l11, l12, l13, l14, d10);
    }

    public void q(Mat mat, r r10, k k10, f f10, double d10, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        CascadeClassifier.detectMultiScale3_4(l10, l11, l12, l13, l14, d10, n10);
    }

    public void r(Mat mat, r r10, k k10, f f10, double d10, int n10, int n11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        CascadeClassifier.detectMultiScale3_3(l10, l11, l12, l13, l14, d10, n10, n11);
    }

    public void s(Mat mat, r r10, k k10, f f10, double d10, int n10, int n11, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        CascadeClassifier.detectMultiScale3_2(l10, l11, l12, l13, l14, d10, n10, n11, d11, d12);
    }

    public void t(Mat mat, r r10, k k10, f f10, double d10, int n10, int n11, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        CascadeClassifier.detectMultiScale3_1(l10, l11, l12, l13, l14, d10, n10, n11, d11, d12, d13, d14);
    }

    public void u(Mat mat, r r10, k k10, f f10, double d10, int n10, int n11, z z10, z z11, boolean bl2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = k10.a;
        long l14 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        CascadeClassifier.detectMultiScale3_0(l10, l11, l12, l13, l14, d10, n10, n11, d11, d12, d13, d14, bl2);
    }

    public boolean v() {
        return CascadeClassifier.empty_0(this.a);
    }

    public int w() {
        return CascadeClassifier.getFeatureType_0(this.a);
    }

    public long x() {
        return this.a;
    }

    public z y() {
        double[] dArray = CascadeClassifier.getOriginalWindowSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public boolean z() {
        return CascadeClassifier.isOldFormatCascade_0(this.a);
    }
}

