/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.c.u;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.photo.AlignExposures;

public class AlignMTB
extends AlignExposures {
    public AlignMTB(long l10) {
        super(l10);
    }

    private static native double[] calculateShift_0(long var0, long var2, long var4);

    private static native void computeBitmaps_0(long var0, long var2, long var4, long var6);

    private static native void delete(long var0);

    private static native boolean getCut_0(long var0);

    private static native int getExcludeRange_0(long var0);

    private static native int getMaxBits_0(long var0);

    public static AlignMTB i(long l10) {
        AlignMTB alignMTB = new AlignMTB(l10);
        return alignMTB;
    }

    private static native void process_0(long var0, long var2, long var4, long var6, long var8);

    private static native void process_1(long var0, long var2, long var4);

    private static native void setCut_0(long var0, boolean var2);

    private static native void setExcludeRange_0(long var0, int var2);

    private static native void setMaxBits_0(long var0, int var2);

    private static native void shiftMat_0(long var0, long var2, long var4, double var6, double var8);

    public void finalize() {
        AlignMTB.delete(this.a);
    }

    public void h(List object, List object2, Mat mat, Mat mat2) {
        object = i.f.h.a.A((List)object);
        object2 = i.f.h.a.A((List)object2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = ((Mat)object2).a;
        long l13 = mat.a;
        long l14 = mat2.a;
        AlignMTB.process_0(l10, l11, l12, l13, l14);
    }

    public u j(Mat object, Mat mat) {
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        object = AlignMTB.calculateShift_0(l10, l11, l12);
        u u10 = new u((double[])object);
        return u10;
    }

    public void k(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        AlignMTB.computeBitmaps_0(l10, l11, l12, l13);
    }

    public boolean l() {
        return AlignMTB.getCut_0(this.a);
    }

    public int m() {
        return AlignMTB.getExcludeRange_0(this.a);
    }

    public int n() {
        return AlignMTB.getMaxBits_0(this.a);
    }

    public void o(List object, List object2) {
        object = i.f.h.a.A((List)object);
        object2 = i.f.h.a.A((List)object2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = ((Mat)object2).a;
        AlignMTB.process_1(l10, l11, l12);
    }

    public void p(boolean bl2) {
        AlignMTB.setCut_0(this.a, bl2);
    }

    public void q(int n10) {
        AlignMTB.setExcludeRange_0(this.a, n10);
    }

    public void r(int n10) {
        AlignMTB.setMaxBits_0(this.a, n10);
    }

    public void s(Mat mat, Mat mat2, u u10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        double d10 = u10.a;
        double d11 = u10.b;
        AlignMTB.shiftMat_0(l10, l11, l12, d10, d11);
    }
}

