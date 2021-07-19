/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.l;
import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class Feature2D
extends Algorithm {
    public Feature2D(long l10) {
        super(l10);
    }

    private static native void compute_0(long var0, long var2, long var4, long var6);

    private static native void compute_1(long var0, long var2, long var4, long var6);

    private static native int defaultNorm_0(long var0);

    private static native void delete(long var0);

    private static native int descriptorSize_0(long var0);

    private static native int descriptorType_0(long var0);

    private static native void detectAndCompute_0(long var0, long var2, long var4, long var6, long var8, boolean var10);

    private static native void detectAndCompute_1(long var0, long var2, long var4, long var6, long var8);

    private static native void detect_0(long var0, long var2, long var4, long var6);

    private static native void detect_1(long var0, long var2, long var4);

    private static native void detect_2(long var0, long var2, long var4, long var6);

    private static native void detect_3(long var0, long var2, long var4);

    private static native boolean empty_0(long var0);

    public static Feature2D g(long l10) {
        Feature2D feature2D = new Feature2D(l10);
        return feature2D;
    }

    private static native String getDefaultName_0(long var0);

    private static native void read_0(long var0, String var2);

    private static native void write_0(long var0, String var2);

    public boolean c() {
        return Feature2D.empty_0(this.a);
    }

    public String d() {
        return Feature2D.getDefaultName_0(this.a);
    }

    public void finalize() {
        Feature2D.delete(this.a);
    }

    public void h(List object, List list, List list2) {
        Mat mat;
        int n10;
        object = i.f.h.a.A((List)object);
        if (list != null) {
            n10 = list.size();
        } else {
            n10 = 0;
            mat = null;
        }
        Object object2 = new ArrayList(n10);
        object2 = i.f.h.a.S(list, object2);
        mat = new Mat();
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = ((Mat)object2).a;
        long l13 = mat.a;
        Feature2D.compute_1(l10, l11, l12, l13);
        i.f.h.a.t((Mat)object2, list);
        ((Mat)object2).u0();
        i.f.h.a.c(mat, list2);
        mat.u0();
    }

    public void i(Mat mat, l l10, Mat mat2) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        Feature2D.compute_0(l11, l12, l13, l14);
    }

    public int j() {
        return Feature2D.defaultNorm_0(this.a);
    }

    public int k() {
        return Feature2D.descriptorSize_0(this.a);
    }

    public int l() {
        return Feature2D.descriptorType_0(this.a);
    }

    public void m(List object, List list) {
        object = i.f.h.a.A((List)object);
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        Feature2D.detect_3(l10, l11, l12);
        i.f.h.a.t(mat, list);
        mat.u0();
    }

    public void n(List object, List list, List object2) {
        object = i.f.h.a.A((List)object);
        Mat mat = new Mat();
        object2 = i.f.h.a.A((List)object2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = ((Mat)object2).a;
        Feature2D.detect_2(l10, l11, l12, l13);
        i.f.h.a.t(mat, list);
        mat.u0();
    }

    public void o(Mat mat, l l10) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = l10.a;
        Feature2D.detect_1(l11, l12, l13);
    }

    public void p(Mat mat, l l10, Mat mat2) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        Feature2D.detect_0(l11, l12, l13, l14);
    }

    public void q(Mat mat, Mat mat2, l l10, Mat mat3) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = l10.a;
        long l15 = mat3.a;
        Feature2D.detectAndCompute_1(l11, l12, l13, l14, l15);
    }

    public void r(Mat mat, Mat mat2, l l10, Mat mat3, boolean bl2) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = l10.a;
        long l15 = mat3.a;
        Feature2D.detectAndCompute_0(l11, l12, l13, l14, l15, bl2);
    }

    public void s(String string2) {
        Feature2D.read_0(this.a, string2);
    }

    public void t(String string2) {
        Feature2D.write_0(this.a, string2);
    }
}

