/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.c.i;
import i.f.c.u;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.photo.AlignMTB;
import org.opencv.photo.CalibrateDebevec;
import org.opencv.photo.CalibrateRobertson;
import org.opencv.photo.MergeDebevec;
import org.opencv.photo.MergeMertens;
import org.opencv.photo.MergeRobertson;
import org.opencv.photo.Tonemap;
import org.opencv.photo.TonemapDrago;
import org.opencv.photo.TonemapMantiuk;
import org.opencv.photo.TonemapReinhard;

public class Photo {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 256;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 1;
    public static final int h = 2;

    public static TonemapDrago A(float f10, float f11, float f12) {
        return TonemapDrago.k(Photo.createTonemapDrago_0(f10, f11, f12));
    }

    public static void A0(Mat mat, Mat mat2, Mat mat3, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.pencilSketch_2(l10, l11, l12, f10);
    }

    public static TonemapMantiuk B() {
        return TonemapMantiuk.k(Photo.createTonemapMantiuk_3());
    }

    public static void B0(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.pencilSketch_1(l10, l11, l12, f10, f11);
    }

    public static TonemapMantiuk C(float f10) {
        return TonemapMantiuk.k(Photo.createTonemapMantiuk_2(f10));
    }

    public static void C0(Mat mat, Mat mat2, Mat mat3, float f10, float f11, float f12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.pencilSketch_0(l10, l11, l12, f10, f11, f12);
    }

    public static TonemapMantiuk D(float f10, float f11) {
        return TonemapMantiuk.k(Photo.createTonemapMantiuk_1(f10, f11));
    }

    public static void D0(Mat mat, Mat mat2, Mat mat3, u u10, Mat mat4, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        double d10 = u10.a;
        double d11 = u10.b;
        long l13 = mat4.a;
        Photo.seamlessClone_0(l10, l11, l12, d10, d11, l13, n10);
    }

    public static TonemapMantiuk E(float f10, float f11, float f12) {
        return TonemapMantiuk.k(Photo.createTonemapMantiuk_0(f10, f11, f12));
    }

    public static void E0(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.stylization_2(l10, l11);
    }

    public static TonemapReinhard F() {
        return TonemapReinhard.k(Photo.createTonemapReinhard_4());
    }

    public static void F0(Mat mat, Mat mat2, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.stylization_1(l10, l11, f10);
    }

    public static TonemapReinhard G(float f10) {
        return TonemapReinhard.k(Photo.createTonemapReinhard_3(f10));
    }

    public static void G0(Mat mat, Mat mat2, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.stylization_0(l10, l11, f10, f11);
    }

    public static TonemapReinhard H(float f10, float f11) {
        return TonemapReinhard.k(Photo.createTonemapReinhard_2(f10, f11));
    }

    public static void H0(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.textureFlattening_3(l10, l11, l12);
    }

    public static TonemapReinhard I(float f10, float f11, float f12) {
        return TonemapReinhard.k(Photo.createTonemapReinhard_1(f10, f11, f12));
    }

    public static void I0(Mat mat, Mat mat2, Mat mat3, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.textureFlattening_2(l10, l11, l12, f10);
    }

    public static TonemapReinhard J(float f10, float f11, float f12, float f13) {
        return TonemapReinhard.k(Photo.createTonemapReinhard_0(f10, f11, f12, f13));
    }

    public static void J0(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.textureFlattening_1(l10, l11, l12, f10, f11);
    }

    public static void K(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.decolor_0(l10, l11, l12);
    }

    public static void K0(Mat mat, Mat mat2, Mat mat3, float f10, float f11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.textureFlattening_0(l10, l11, l12, f10, f11, n10);
    }

    public static void L(List list, Mat mat) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.denoise_TVL1_2(l10, l11);
    }

    public static void M(List list, Mat mat, double d10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.denoise_TVL1_1(l10, l11, d10);
    }

    public static void N(List list, Mat mat, double d10, int n10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.denoise_TVL1_0(l10, l11, d10, n10);
    }

    public static void O(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.detailEnhance_2(l10, l11);
    }

    public static void P(Mat mat, Mat mat2, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.detailEnhance_1(l10, l11, f10);
    }

    public static void Q(Mat mat, Mat mat2, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.detailEnhance_0(l10, l11, f10, f11);
    }

    public static void R(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.edgePreservingFilter_3(l10, l11);
    }

    public static void S(Mat mat, Mat mat2, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.edgePreservingFilter_2(l10, l11, n10);
    }

    public static void T(Mat mat, Mat mat2, int n10, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.edgePreservingFilter_1(l10, l11, n10, f10);
    }

    public static void U(Mat mat, Mat mat2, int n10, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.edgePreservingFilter_0(l10, l11, n10, f10, f11);
    }

    public static void V(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoising_3(l10, l11);
    }

    public static void W(Mat mat, Mat mat2, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoising_2(l10, l11, f10);
    }

    public static void X(Mat mat, Mat mat2, float f10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoising_1(l10, l11, f10, n10);
    }

    public static void Y(Mat mat, Mat mat2, float f10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoising_0(l10, l11, f10, n10, n11);
    }

    public static void Z(Mat mat, Mat mat2, i i10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoising_7(l10, l11, l12);
    }

    public static void a(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.colorChange_3(l10, l11, l12);
    }

    public static void a0(Mat mat, Mat mat2, i i10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoising_6(l10, l11, l12, n10);
    }

    public static void b(Mat mat, Mat mat2, Mat mat3, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.colorChange_2(l10, l11, l12, f10);
    }

    public static void b0(Mat mat, Mat mat2, i i10, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoising_5(l10, l11, l12, n10, n11);
    }

    public static void c(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.colorChange_1(l10, l11, l12, f10, f11);
    }

    public static void c0(Mat mat, Mat mat2, i i10, int n10, int n11, int n12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoising_4(l10, l11, l12, n10, n11, n12);
    }

    private static native void colorChange_0(long var0, long var2, long var4, float var6, float var7, float var8);

    private static native void colorChange_1(long var0, long var2, long var4, float var6, float var7);

    private static native void colorChange_2(long var0, long var2, long var4, float var6);

    private static native void colorChange_3(long var0, long var2, long var4);

    private static native long createAlignMTB_0(int var0, int var1, boolean var2);

    private static native long createAlignMTB_1(int var0, int var1);

    private static native long createAlignMTB_2(int var0);

    private static native long createAlignMTB_3();

    private static native long createCalibrateDebevec_0(int var0, float var1, boolean var2);

    private static native long createCalibrateDebevec_1(int var0, float var1);

    private static native long createCalibrateDebevec_2(int var0);

    private static native long createCalibrateDebevec_3();

    private static native long createCalibrateRobertson_0(int var0, float var1);

    private static native long createCalibrateRobertson_1(int var0);

    private static native long createCalibrateRobertson_2();

    private static native long createMergeDebevec_0();

    private static native long createMergeMertens_0(float var0, float var1, float var2);

    private static native long createMergeMertens_1(float var0, float var1);

    private static native long createMergeMertens_2(float var0);

    private static native long createMergeMertens_3();

    private static native long createMergeRobertson_0();

    private static native long createTonemapDrago_0(float var0, float var1, float var2);

    private static native long createTonemapDrago_1(float var0, float var1);

    private static native long createTonemapDrago_2(float var0);

    private static native long createTonemapDrago_3();

    private static native long createTonemapMantiuk_0(float var0, float var1, float var2);

    private static native long createTonemapMantiuk_1(float var0, float var1);

    private static native long createTonemapMantiuk_2(float var0);

    private static native long createTonemapMantiuk_3();

    private static native long createTonemapReinhard_0(float var0, float var1, float var2, float var3);

    private static native long createTonemapReinhard_1(float var0, float var1, float var2);

    private static native long createTonemapReinhard_2(float var0, float var1);

    private static native long createTonemapReinhard_3(float var0);

    private static native long createTonemapReinhard_4();

    private static native long createTonemap_0(float var0);

    private static native long createTonemap_1();

    public static void d(Mat mat, Mat mat2, Mat mat3, float f10, float f11, float f12) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.colorChange_0(l10, l11, l12, f10, f11, f12);
    }

    public static void d0(Mat mat, Mat mat2) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoisingColored_4(l10, l11);
    }

    private static native void decolor_0(long var0, long var2, long var4);

    private static native void denoise_TVL1_0(long var0, long var2, double var4, int var6);

    private static native void denoise_TVL1_1(long var0, long var2, double var4);

    private static native void denoise_TVL1_2(long var0, long var2);

    private static native void detailEnhance_0(long var0, long var2, float var4, float var5);

    private static native void detailEnhance_1(long var0, long var2, float var4);

    private static native void detailEnhance_2(long var0, long var2);

    public static AlignMTB e() {
        return AlignMTB.i(Photo.createAlignMTB_3());
    }

    public static void e0(Mat mat, Mat mat2, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoisingColored_3(l10, l11, f10);
    }

    private static native void edgePreservingFilter_0(long var0, long var2, int var4, float var5, float var6);

    private static native void edgePreservingFilter_1(long var0, long var2, int var4, float var5);

    private static native void edgePreservingFilter_2(long var0, long var2, int var4);

    private static native void edgePreservingFilter_3(long var0, long var2);

    public static AlignMTB f(int n10) {
        return AlignMTB.i(Photo.createAlignMTB_2(n10));
    }

    public static void f0(Mat mat, Mat mat2, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoisingColored_2(l10, l11, f10, f11);
    }

    private static native void fastNlMeansDenoisingColoredMulti_0(long var0, long var2, int var4, int var5, float var6, float var7, int var8, int var9);

    private static native void fastNlMeansDenoisingColoredMulti_1(long var0, long var2, int var4, int var5, float var6, float var7, int var8);

    private static native void fastNlMeansDenoisingColoredMulti_2(long var0, long var2, int var4, int var5, float var6, float var7);

    private static native void fastNlMeansDenoisingColoredMulti_3(long var0, long var2, int var4, int var5, float var6);

    private static native void fastNlMeansDenoisingColoredMulti_4(long var0, long var2, int var4, int var5);

    private static native void fastNlMeansDenoisingColored_0(long var0, long var2, float var4, float var5, int var6, int var7);

    private static native void fastNlMeansDenoisingColored_1(long var0, long var2, float var4, float var5, int var6);

    private static native void fastNlMeansDenoisingColored_2(long var0, long var2, float var4, float var5);

    private static native void fastNlMeansDenoisingColored_3(long var0, long var2, float var4);

    private static native void fastNlMeansDenoisingColored_4(long var0, long var2);

    private static native void fastNlMeansDenoisingMulti_0(long var0, long var2, int var4, int var5, float var6, int var7, int var8);

    private static native void fastNlMeansDenoisingMulti_1(long var0, long var2, int var4, int var5, float var6, int var7);

    private static native void fastNlMeansDenoisingMulti_2(long var0, long var2, int var4, int var5, float var6);

    private static native void fastNlMeansDenoisingMulti_3(long var0, long var2, int var4, int var5);

    private static native void fastNlMeansDenoisingMulti_4(long var0, long var2, int var4, int var5, long var6, int var8, int var9, int var10);

    private static native void fastNlMeansDenoisingMulti_5(long var0, long var2, int var4, int var5, long var6, int var8, int var9);

    private static native void fastNlMeansDenoisingMulti_6(long var0, long var2, int var4, int var5, long var6, int var8);

    private static native void fastNlMeansDenoisingMulti_7(long var0, long var2, int var4, int var5, long var6);

    private static native void fastNlMeansDenoising_0(long var0, long var2, float var4, int var5, int var6);

    private static native void fastNlMeansDenoising_1(long var0, long var2, float var4, int var5);

    private static native void fastNlMeansDenoising_2(long var0, long var2, float var4);

    private static native void fastNlMeansDenoising_3(long var0, long var2);

    private static native void fastNlMeansDenoising_4(long var0, long var2, long var4, int var6, int var7, int var8);

    private static native void fastNlMeansDenoising_5(long var0, long var2, long var4, int var6, int var7);

    private static native void fastNlMeansDenoising_6(long var0, long var2, long var4, int var6);

    private static native void fastNlMeansDenoising_7(long var0, long var2, long var4);

    public static AlignMTB g(int n10, int n11) {
        return AlignMTB.i(Photo.createAlignMTB_1(n10, n11));
    }

    public static void g0(Mat mat, Mat mat2, float f10, float f11, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoisingColored_1(l10, l11, f10, f11, n10);
    }

    public static AlignMTB h(int n10, int n11, boolean bl2) {
        return AlignMTB.i(Photo.createAlignMTB_0(n10, n11, bl2));
    }

    public static void h0(Mat mat, Mat mat2, float f10, float f11, int n10, int n11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        Photo.fastNlMeansDenoisingColored_0(l10, l11, f10, f11, n10, n11);
    }

    public static CalibrateDebevec i() {
        return CalibrateDebevec.i(Photo.createCalibrateDebevec_3());
    }

    public static void i0(List list, Mat mat, int n10, int n11) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingColoredMulti_4(l10, l11, n10, n11);
    }

    private static native void illuminationChange_0(long var0, long var2, long var4, float var6, float var7);

    private static native void illuminationChange_1(long var0, long var2, long var4, float var6);

    private static native void illuminationChange_2(long var0, long var2, long var4);

    private static native void inpaint_0(long var0, long var2, long var4, double var6, int var8);

    public static CalibrateDebevec j(int n10) {
        return CalibrateDebevec.i(Photo.createCalibrateDebevec_2(n10));
    }

    public static void j0(List list, Mat mat, int n10, int n11, float f10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingColoredMulti_3(l10, l11, n10, n11, f10);
    }

    public static CalibrateDebevec k(int n10, float f10) {
        return CalibrateDebevec.i(Photo.createCalibrateDebevec_1(n10, f10));
    }

    public static void k0(List list, Mat mat, int n10, int n11, float f10, float f11) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingColoredMulti_2(l10, l11, n10, n11, f10, f11);
    }

    public static CalibrateDebevec l(int n10, float f10, boolean bl2) {
        return CalibrateDebevec.i(Photo.createCalibrateDebevec_0(n10, f10, bl2));
    }

    public static void l0(List list, Mat mat, int n10, int n11, float f10, float f11, int n12) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingColoredMulti_1(l10, l11, n10, n11, f10, f11, n12);
    }

    public static CalibrateRobertson m() {
        return CalibrateRobertson.i(Photo.createCalibrateRobertson_2());
    }

    public static void m0(List list, Mat mat, int n10, int n11, float f10, float f11, int n12, int n13) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingColoredMulti_0(l10, l11, n10, n11, f10, f11, n12, n13);
    }

    public static CalibrateRobertson n(int n10) {
        return CalibrateRobertson.i(Photo.createCalibrateRobertson_1(n10));
    }

    public static void n0(List list, Mat mat, int n10, int n11) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingMulti_3(l10, l11, n10, n11);
    }

    public static CalibrateRobertson o(int n10, float f10) {
        return CalibrateRobertson.i(Photo.createCalibrateRobertson_0(n10, f10));
    }

    public static void o0(List list, Mat mat, int n10, int n11, float f10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingMulti_2(l10, l11, n10, n11, f10);
    }

    public static MergeDebevec p() {
        return MergeDebevec.i(Photo.createMergeDebevec_0());
    }

    public static void p0(List list, Mat mat, int n10, int n11, float f10, int n12) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingMulti_1(l10, l11, n10, n11, f10, n12);
    }

    private static native void pencilSketch_0(long var0, long var2, long var4, float var6, float var7, float var8);

    private static native void pencilSketch_1(long var0, long var2, long var4, float var6, float var7);

    private static native void pencilSketch_2(long var0, long var2, long var4, float var6);

    private static native void pencilSketch_3(long var0, long var2, long var4);

    public static MergeMertens q() {
        return MergeMertens.i(Photo.createMergeMertens_3());
    }

    public static void q0(List list, Mat mat, int n10, int n11, float f10, int n12, int n13) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        Photo.fastNlMeansDenoisingMulti_0(l10, l11, n10, n11, f10, n12, n13);
    }

    public static MergeMertens r(float f10) {
        return MergeMertens.i(Photo.createMergeMertens_2(f10));
    }

    public static void r0(List list, Mat mat, int n10, int n11, i i10) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoisingMulti_7(l10, l11, n10, n11, l12);
    }

    public static MergeMertens s(float f10, float f11) {
        return MergeMertens.i(Photo.createMergeMertens_1(f10, f11));
    }

    public static void s0(List list, Mat mat, int n10, int n11, i i10, int n12) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoisingMulti_6(l10, l11, n10, n11, l12, n12);
    }

    private static native void seamlessClone_0(long var0, long var2, long var4, double var6, double var8, long var10, int var12);

    private static native void stylization_0(long var0, long var2, float var4, float var5);

    private static native void stylization_1(long var0, long var2, float var4);

    private static native void stylization_2(long var0, long var2);

    public static MergeMertens t(float f10, float f11, float f12) {
        return MergeMertens.i(Photo.createMergeMertens_0(f10, f11, f12));
    }

    public static void t0(List list, Mat mat, int n10, int n11, i i10, int n12, int n13) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoisingMulti_5(l10, l11, n10, n11, l12, n12, n13);
    }

    private static native void textureFlattening_0(long var0, long var2, long var4, float var6, float var7, int var8);

    private static native void textureFlattening_1(long var0, long var2, long var4, float var6, float var7);

    private static native void textureFlattening_2(long var0, long var2, long var4, float var6);

    private static native void textureFlattening_3(long var0, long var2, long var4);

    public static MergeRobertson u() {
        return MergeRobertson.i(Photo.createMergeRobertson_0());
    }

    public static void u0(List list, Mat mat, int n10, int n11, i i10, int n12, int n13, int n14) {
        long l10 = i.f.h.a.A((List)list).a;
        long l11 = mat.a;
        long l12 = i10.a;
        Photo.fastNlMeansDenoisingMulti_4(l10, l11, n10, n11, l12, n12, n13, n14);
    }

    public static Tonemap v() {
        return Tonemap.g(Photo.createTonemap_1());
    }

    public static void v0(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.illuminationChange_2(l10, l11, l12);
    }

    public static Tonemap w(float f10) {
        return Tonemap.g(Photo.createTonemap_0(f10));
    }

    public static void w0(Mat mat, Mat mat2, Mat mat3, float f10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.illuminationChange_1(l10, l11, l12, f10);
    }

    public static TonemapDrago x() {
        return TonemapDrago.k(Photo.createTonemapDrago_3());
    }

    public static void x0(Mat mat, Mat mat2, Mat mat3, float f10, float f11) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.illuminationChange_0(l10, l11, l12, f10, f11);
    }

    public static TonemapDrago y(float f10) {
        return TonemapDrago.k(Photo.createTonemapDrago_2(f10));
    }

    public static void y0(Mat mat, Mat mat2, Mat mat3, double d10, int n10) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.inpaint_0(l10, l11, l12, d10, n10);
    }

    public static TonemapDrago z(float f10, float f11) {
        return TonemapDrago.k(Photo.createTonemapDrago_1(f10, f11));
    }

    public static void z0(Mat mat, Mat mat2, Mat mat3) {
        long l10 = mat.a;
        long l11 = mat2.a;
        long l12 = mat3.a;
        Photo.pencilSketch_3(l10, l11, l12);
    }
}

