/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.photo.MergeExposures;

public class MergeMertens
extends MergeExposures {
    public MergeMertens(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native float getContrastWeight_0(long var0);

    private static native float getExposureWeight_0(long var0);

    private static native float getSaturationWeight_0(long var0);

    public static MergeMertens i(long l10) {
        MergeMertens mergeMertens = new MergeMertens(l10);
        return mergeMertens;
    }

    private static native void process_0(long var0, long var2, long var4, long var6, long var8);

    private static native void process_1(long var0, long var2, long var4);

    private static native void setContrastWeight_0(long var0, float var2);

    private static native void setExposureWeight_0(long var0, float var2);

    private static native void setSaturationWeight_0(long var0, float var2);

    public void finalize() {
        MergeMertens.delete(this.a);
    }

    public void h(List object, Mat mat, Mat mat2, Mat mat3) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        MergeMertens.process_0(l10, l11, l12, l13, l14);
    }

    public float j() {
        return MergeMertens.getContrastWeight_0(this.a);
    }

    public float k() {
        return MergeMertens.getExposureWeight_0(this.a);
    }

    public float l() {
        return MergeMertens.getSaturationWeight_0(this.a);
    }

    public void m(List object, Mat mat) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        MergeMertens.process_1(l10, l11, l12);
    }

    public void n(float f10) {
        MergeMertens.setContrastWeight_0(this.a, f10);
    }

    public void o(float f10) {
        MergeMertens.setExposureWeight_0(this.a, f10);
    }

    public void p(float f10) {
        MergeMertens.setSaturationWeight_0(this.a, f10);
    }
}

