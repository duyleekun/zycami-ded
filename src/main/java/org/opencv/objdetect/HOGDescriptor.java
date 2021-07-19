/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.objdetect;

import i.f.c.f;
import i.f.c.i;
import i.f.c.p;
import i.f.c.r;
import i.f.c.z;
import org.opencv.core.Mat;

public class HOGDescriptor {
    public static final int b = 64;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 1;
    public final long a;

    public HOGDescriptor() {
        long l10;
        this.a = l10 = HOGDescriptor.HOGDescriptor_9();
    }

    public HOGDescriptor(long l10) {
        this.a = l10;
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10) {
        long l10;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        double d14 = z12.a;
        double d15 = z12.b;
        double d16 = z13.a;
        double d17 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_7(d10, d11, d12, d13, d14, d15, d16, d17, n10);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11) {
        long l10;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        double d14 = z12.a;
        double d15 = z12.b;
        double d16 = z13.a;
        double d17 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_6(d10, d11, d12, d13, d14, d15, d16, d17, n10, n11);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        double d15 = z12.a;
        double d16 = z12.b;
        double d17 = z13.a;
        double d18 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_5(d11, d12, d13, d14, d15, d16, d17, d18, n10, n11, d10);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10, int n12) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        double d15 = z12.a;
        double d16 = z12.b;
        double d17 = z13.a;
        double d18 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_4(d11, d12, d13, d14, d15, d16, d17, d18, n10, n11, d10, n12);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10, int n12, double d11) {
        long l10;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = z11.a;
        double d15 = z11.b;
        double d16 = z12.a;
        double d17 = z12.b;
        double d18 = z13.a;
        double d19 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_3(d12, d13, d14, d15, d16, d17, d18, d19, n10, n11, d10, n12, d11);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10, int n12, double d11, boolean bl2) {
        long l10;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = z11.a;
        double d15 = z11.b;
        double d16 = z12.a;
        double d17 = z12.b;
        double d18 = z13.a;
        double d19 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_2(d12, d13, d14, d15, d16, d17, d18, d19, n10, n11, d10, n12, d11, bl2);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10, int n12, double d11, boolean bl2, int n13) {
        long l10;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = z11.a;
        double d15 = z11.b;
        double d16 = z12.a;
        double d17 = z12.b;
        double d18 = z13.a;
        double d19 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_1(d12, d13, d14, d15, d16, d17, d18, d19, n10, n11, d10, n12, d11, bl2, n13);
    }

    public HOGDescriptor(z z10, z z11, z z12, z z13, int n10, int n11, double d10, int n12, double d11, boolean bl2, int n13, boolean bl3) {
        long l10;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = z11.a;
        double d15 = z11.b;
        double d16 = z12.a;
        double d17 = z12.b;
        double d18 = z13.a;
        double d19 = z13.b;
        this.a = l10 = HOGDescriptor.HOGDescriptor_0(d12, d13, d14, d15, d16, d17, d18, d19, n10, n11, d10, n12, d11, bl2, n13, bl3);
    }

    public HOGDescriptor(String string2) {
        long l10;
        this.a = l10 = HOGDescriptor.HOGDescriptor_8(string2);
    }

    private static native long HOGDescriptor_0(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18, int var20, double var21, boolean var23, int var24, boolean var25);

    private static native long HOGDescriptor_1(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18, int var20, double var21, boolean var23, int var24);

    private static native long HOGDescriptor_2(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18, int var20, double var21, boolean var23);

    private static native long HOGDescriptor_3(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18, int var20, double var21);

    private static native long HOGDescriptor_4(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18, int var20);

    private static native long HOGDescriptor_5(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17, double var18);

    private static native long HOGDescriptor_6(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16, int var17);

    private static native long HOGDescriptor_7(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int var16);

    private static native long HOGDescriptor_8(String var0);

    private static native long HOGDescriptor_9();

    public static HOGDescriptor a(long l10) {
        HOGDescriptor hOGDescriptor = new HOGDescriptor(l10);
        return hOGDescriptor;
    }

    private static native boolean checkDetectorSize_0(long var0);

    private static native void computeGradient_0(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14);

    private static native void computeGradient_1(long var0, long var2, long var4, long var6, double var8, double var10);

    private static native void computeGradient_2(long var0, long var2, long var4, long var6);

    private static native void compute_0(long var0, long var2, long var4, double var6, double var8, double var10, double var12, long var14);

    private static native void compute_1(long var0, long var2, long var4, double var6, double var8, double var10, double var12);

    private static native void compute_2(long var0, long var2, long var4, double var6, double var8);

    private static native void compute_3(long var0, long var2, long var4);

    private static native void delete(long var0);

    private static native void detectMultiScale_0(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20, boolean var22);

    private static native void detectMultiScale_1(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16, double var18, double var20);

    private static native void detectMultiScale_2(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16, double var18);

    private static native void detectMultiScale_3(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16);

    private static native void detectMultiScale_4(long var0, long var2, long var4, long var6, double var8, double var10, double var12);

    private static native void detectMultiScale_5(long var0, long var2, long var4, long var6, double var8);

    private static native void detectMultiScale_6(long var0, long var2, long var4, long var6);

    private static native void detect_0(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16, long var18);

    private static native void detect_1(long var0, long var2, long var4, long var6, double var8, double var10, double var12, double var14, double var16);

    private static native void detect_2(long var0, long var2, long var4, long var6, double var8, double var10, double var12);

    private static native void detect_3(long var0, long var2, long var4, long var6, double var8);

    private static native void detect_4(long var0, long var2, long var4, long var6);

    private static native long getDaimlerPeopleDetector_0();

    private static native long getDefaultPeopleDetector_0();

    private static native long getDescriptorSize_0(long var0);

    private static native double getWinSigma_0(long var0);

    private static native double get_L2HysThreshold_0(long var0);

    private static native double[] get_blockSize_0(long var0);

    private static native double[] get_blockStride_0(long var0);

    private static native double[] get_cellSize_0(long var0);

    private static native int get_derivAperture_0(long var0);

    private static native boolean get_gammaCorrection_0(long var0);

    private static native int get_histogramNormType_0(long var0);

    private static native int get_nbins_0(long var0);

    private static native int get_nlevels_0(long var0);

    private static native boolean get_signedGradient_0(long var0);

    private static native long get_svmDetector_0(long var0);

    private static native double get_winSigma_0(long var0);

    private static native double[] get_winSize_0(long var0);

    private static native boolean load_0(long var0, String var2, String var3);

    private static native boolean load_1(long var0, String var2);

    private static native void save_0(long var0, String var2, String var3);

    private static native void save_1(long var0, String var2);

    private static native void setSVMDetector_0(long var0, long var2);

    public static i v() {
        return i.Y0(HOGDescriptor.getDaimlerPeopleDetector_0());
    }

    public static i w() {
        return i.Y0(HOGDescriptor.getDefaultPeopleDetector_0());
    }

    public double A() {
        return HOGDescriptor.get_L2HysThreshold_0(this.a);
    }

    public z B() {
        double[] dArray = HOGDescriptor.get_blockSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public z C() {
        double[] dArray = HOGDescriptor.get_blockStride_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public z D() {
        double[] dArray = HOGDescriptor.get_cellSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public int E() {
        return HOGDescriptor.get_derivAperture_0(this.a);
    }

    public boolean F() {
        return HOGDescriptor.get_gammaCorrection_0(this.a);
    }

    public int G() {
        return HOGDescriptor.get_histogramNormType_0(this.a);
    }

    public int H() {
        return HOGDescriptor.get_nbins_0(this.a);
    }

    public int I() {
        return HOGDescriptor.get_nlevels_0(this.a);
    }

    public boolean J() {
        return HOGDescriptor.get_signedGradient_0(this.a);
    }

    public i K() {
        return i.Y0(HOGDescriptor.get_svmDetector_0(this.a));
    }

    public double L() {
        return HOGDescriptor.get_winSigma_0(this.a);
    }

    public z M() {
        double[] dArray = HOGDescriptor.get_winSize_0(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public boolean N(String string2) {
        return HOGDescriptor.load_1(this.a, string2);
    }

    public boolean O(String string2, String string3) {
        return HOGDescriptor.load_0(this.a, string2, string3);
    }

    public void P(String string2) {
        HOGDescriptor.save_1(this.a, string2);
    }

    public void Q(String string2, String string3) {
        HOGDescriptor.save_0(this.a, string2, string3);
    }

    public void R(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        HOGDescriptor.setSVMDetector_0(l10, l11);
    }

    public boolean b() {
        return HOGDescriptor.checkDetectorSize_0(this.a);
    }

    public void c(Mat mat, i i10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = i10.a;
        HOGDescriptor.compute_3(l10, l11, l12);
    }

    public void d(Mat mat, i i10, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = i10.a;
        double d10 = z10.a;
        double d11 = z10.b;
        HOGDescriptor.compute_2(l10, l11, l12, d10, d11);
    }

    public void e(Mat mat, i i10, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = i10.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        HOGDescriptor.compute_1(l10, l11, l12, d10, d11, d12, d13);
    }

    public void f(Mat mat, i i10, z z10, z z11, p p10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = i10.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        long l13 = p10.a;
        HOGDescriptor.compute_0(l10, l11, l12, d10, d11, d12, d13, l13);
    }

    public void finalize() {
        HOGDescriptor.delete(this.a);
    }

    public void g(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        HOGDescriptor.computeGradient_2(l10, l11, l12, l13);
    }

    public void h(Mat mat, Mat mat2, Mat mat3, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        HOGDescriptor.computeGradient_1(l10, l11, l12, l13, d10, d11);
    }

    public void i(Mat mat, Mat mat2, Mat mat3, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        double d10 = z10.a;
        double d11 = z10.b;
        double d12 = z11.a;
        double d13 = z11.b;
        HOGDescriptor.computeGradient_0(l10, l11, l12, l13, d10, d11, d12, d13);
    }

    public void j(Mat mat, p p10, f f10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = p10.a;
        long l13 = f10.a;
        HOGDescriptor.detect_4(l10, l11, l12, l13);
    }

    public void k(Mat mat, p p10, f f10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = p10.a;
        long l13 = f10.a;
        HOGDescriptor.detect_3(l10, l11, l12, l13, d10);
    }

    public void l(Mat mat, p p10, f f10, double d10, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = p10.a;
        long l13 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        HOGDescriptor.detect_2(l10, l11, l12, l13, d10, d11, d12);
    }

    public void m(Mat mat, p p10, f f10, double d10, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = p10.a;
        long l13 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        HOGDescriptor.detect_1(l10, l11, l12, l13, d10, d11, d12, d13, d14);
    }

    public void n(Mat mat, p p10, f f10, double d10, z z10, z z11, p p11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = p10.a;
        long l13 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        long l14 = p11.a;
        HOGDescriptor.detect_0(l10, l11, l12, l13, d10, d11, d12, d13, d14, l14);
    }

    public void o(Mat mat, r r10, f f10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        HOGDescriptor.detectMultiScale_6(l10, l11, l12, l13);
    }

    public void p(Mat mat, r r10, f f10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        HOGDescriptor.detectMultiScale_5(l10, l11, l12, l13, d10);
    }

    public void q(Mat mat, r r10, f f10, double d10, z z10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        HOGDescriptor.detectMultiScale_4(l10, l11, l12, l13, d10, d11, d12);
    }

    public void r(Mat mat, r r10, f f10, double d10, z z10, z z11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        double d11 = z10.a;
        double d12 = z10.b;
        double d13 = z11.a;
        double d14 = z11.b;
        HOGDescriptor.detectMultiScale_3(l10, l11, l12, l13, d10, d11, d12, d13, d14);
    }

    public void s(Mat mat, r r10, f f10, double d10, z z10, z z11, double d11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        double d12 = z10.a;
        double d13 = z10.b;
        double d14 = z11.a;
        double d15 = z11.b;
        HOGDescriptor.detectMultiScale_2(l10, l11, l12, l13, d10, d12, d13, d14, d15, d11);
    }

    public void t(Mat mat, r r10, f f10, double d10, z z10, z z11, double d11, double d12) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        double d13 = z10.a;
        double d14 = z10.b;
        double d15 = z11.a;
        double d16 = z11.b;
        HOGDescriptor.detectMultiScale_1(l10, l11, l12, l13, d10, d13, d14, d15, d16, d11, d12);
    }

    public void u(Mat mat, r r10, f f10, double d10, z z10, z z11, double d11, double d12, boolean bl2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = r10.a;
        long l13 = f10.a;
        double d13 = z10.a;
        double d14 = z10.b;
        double d15 = z11.a;
        double d16 = z11.b;
        HOGDescriptor.detectMultiScale_0(l10, l11, l12, l13, d10, d13, d14, d15, d16, d11, d12, bl2);
    }

    public long x() {
        return HOGDescriptor.getDescriptorSize_0(this.a);
    }

    public long y() {
        return this.a;
    }

    public double z() {
        return HOGDescriptor.getWinSigma_0(this.a);
    }
}

