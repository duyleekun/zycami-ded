/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.e;
import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class DescriptorMatcher
extends Algorithm {
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;

    public DescriptorMatcher(long l10) {
        super(l10);
    }

    private static native void add_0(long var0, long var2);

    private static native void clear_0(long var0);

    private static native long clone_0(long var0, boolean var2);

    private static native long clone_1(long var0);

    private static native long create_0(int var0);

    private static native long create_1(String var0);

    private static native void delete(long var0);

    private static native boolean empty_0(long var0);

    public static DescriptorMatcher g(long l10) {
        DescriptorMatcher descriptorMatcher = new DescriptorMatcher(l10);
        return descriptorMatcher;
    }

    private static native long getTrainDescriptors_0(long var0);

    private static native boolean isMaskSupported_0(long var0);

    public static DescriptorMatcher k(int n10) {
        return DescriptorMatcher.g(DescriptorMatcher.create_0(n10));
    }

    private static native void knnMatch_0(long var0, long var2, long var4, long var6, int var8, long var9, boolean var11);

    private static native void knnMatch_1(long var0, long var2, long var4, long var6, int var8, long var9);

    private static native void knnMatch_2(long var0, long var2, long var4, long var6, int var8);

    private static native void knnMatch_3(long var0, long var2, long var4, int var6, long var7, boolean var9);

    private static native void knnMatch_4(long var0, long var2, long var4, int var6, long var7);

    private static native void knnMatch_5(long var0, long var2, long var4, int var6);

    public static DescriptorMatcher l(String string2) {
        return DescriptorMatcher.g(DescriptorMatcher.create_1(string2));
    }

    private static native void match_0(long var0, long var2, long var4, long var6, long var8);

    private static native void match_1(long var0, long var2, long var4, long var6);

    private static native void match_2(long var0, long var2, long var4, long var6);

    private static native void match_3(long var0, long var2, long var4);

    private static native void radiusMatch_0(long var0, long var2, long var4, long var6, float var8, long var9, boolean var11);

    private static native void radiusMatch_1(long var0, long var2, long var4, long var6, float var8, long var9);

    private static native void radiusMatch_2(long var0, long var2, long var4, long var6, float var8);

    private static native void radiusMatch_3(long var0, long var2, long var4, float var6, long var7, boolean var9);

    private static native void radiusMatch_4(long var0, long var2, long var4, float var6, long var7);

    private static native void radiusMatch_5(long var0, long var2, long var4, float var6);

    private static native void read_0(long var0, String var2);

    private static native void train_0(long var0);

    private static native void write_0(long var0, String var2);

    public void A(Mat mat, List list, float f10, List list2, boolean bl2) {
        Mat mat2 = new Mat();
        Object object = i.f.h.a.A(list2);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = ((Mat)object).a;
        DescriptorMatcher.radiusMatch_3(l10, l11, l12, f10, l13, bl2);
        object = list;
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }

    public void B(Mat mat, Mat mat2, List list, float f10) {
        Mat mat3 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        DescriptorMatcher.radiusMatch_2(l10, l11, l12, l13, f10);
        i.f.h.a.s(mat3, list);
        mat3.u0();
    }

    public void C(Mat mat, Mat mat2, List list, float f10, Mat mat3) {
        Mat mat4 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat4.a;
        long l14 = mat3.a;
        DescriptorMatcher.radiusMatch_1(l10, l11, l12, l13, f10, l14);
        i.f.h.a.s(mat4, list);
        mat4.u0();
    }

    public void D(Mat mat, Mat mat2, List list, float f10, Mat mat3, boolean bl2) {
        Mat mat4 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat4.a;
        long l14 = mat3.a;
        DescriptorMatcher.radiusMatch_0(l10, l11, l12, l13, f10, l14, bl2);
        i.f.h.a.s(mat4, list);
        mat4.u0();
    }

    public void E(String string2) {
        DescriptorMatcher.read_0(this.a, string2);
    }

    public void F() {
        DescriptorMatcher.train_0(this.a);
    }

    public void G(String string2) {
        DescriptorMatcher.write_0(this.a, string2);
    }

    public void b() {
        DescriptorMatcher.clear_0(this.a);
    }

    public boolean c() {
        return DescriptorMatcher.empty_0(this.a);
    }

    public void finalize() {
        DescriptorMatcher.delete(this.a);
    }

    public void h(List object) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        DescriptorMatcher.add_0(l10, l11);
    }

    public DescriptorMatcher i() {
        return DescriptorMatcher.g(DescriptorMatcher.clone_1(this.a));
    }

    public DescriptorMatcher j(boolean bl2) {
        return DescriptorMatcher.g(DescriptorMatcher.clone_0(this.a, bl2));
    }

    public List m() {
        ArrayList arrayList = new ArrayList();
        long l10 = DescriptorMatcher.getTrainDescriptors_0(this.a);
        Mat mat = new Mat(l10);
        i.f.h.a.c(mat, arrayList);
        return arrayList;
    }

    public boolean n() {
        return DescriptorMatcher.isMaskSupported_0(this.a);
    }

    public void o(Mat mat, List list, int n10) {
        Mat mat2 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        DescriptorMatcher.knnMatch_5(l10, l11, l12, n10);
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }

    public void p(Mat mat, List list, int n10, List object) {
        Mat mat2 = new Mat();
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = ((Mat)object).a;
        DescriptorMatcher.knnMatch_4(l10, l11, l12, n10, l13);
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }

    public void q(Mat mat, List list, int n10, List list2, boolean bl2) {
        Mat mat2 = new Mat();
        Object object = i.f.h.a.A(list2);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = ((Mat)object).a;
        DescriptorMatcher.knnMatch_3(l10, l11, l12, n10, l13, bl2);
        object = list;
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }

    public void r(Mat mat, Mat mat2, List list, int n10) {
        Mat mat3 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        DescriptorMatcher.knnMatch_2(l10, l11, l12, l13, n10);
        i.f.h.a.s(mat3, list);
        mat3.u0();
    }

    public void s(Mat mat, Mat mat2, List list, int n10, Mat mat3) {
        Mat mat4 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat4.a;
        long l14 = mat3.a;
        DescriptorMatcher.knnMatch_1(l10, l11, l12, l13, n10, l14);
        i.f.h.a.s(mat4, list);
        mat4.u0();
    }

    public void t(Mat mat, Mat mat2, List list, int n10, Mat mat3, boolean bl2) {
        Mat mat4 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat4.a;
        long l14 = mat3.a;
        DescriptorMatcher.knnMatch_0(l10, l11, l12, l13, n10, l14, bl2);
        i.f.h.a.s(mat4, list);
        mat4.u0();
    }

    public void u(Mat mat, Mat mat2, e e10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = e10.a;
        DescriptorMatcher.match_1(l10, l11, l12, l13);
    }

    public void v(Mat mat, Mat mat2, e e10, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = e10.a;
        long l14 = mat3.a;
        DescriptorMatcher.match_0(l10, l11, l12, l13, l14);
    }

    public void w(Mat mat, e e10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = e10.a;
        DescriptorMatcher.match_3(l10, l11, l12);
    }

    public void x(Mat mat, e e10, List object) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = e10.a;
        long l13 = ((Mat)object).a;
        DescriptorMatcher.match_2(l10, l11, l12, l13);
    }

    public void y(Mat mat, List list, float f10) {
        Mat mat2 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        DescriptorMatcher.radiusMatch_5(l10, l11, l12, f10);
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }

    public void z(Mat mat, List list, float f10, List object) {
        Mat mat2 = new Mat();
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = ((Mat)object).a;
        DescriptorMatcher.radiusMatch_4(l10, l11, l12, f10, l13);
        i.f.h.a.s(mat2, list);
        mat2.u0();
    }
}

