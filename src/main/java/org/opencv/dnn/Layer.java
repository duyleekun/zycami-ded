/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class Layer
extends Algorithm {
    public Layer(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native void finalize_0(long var0, long var2, long var4);

    public static Layer g(long l10) {
        Layer layer = new Layer(l10);
        return layer;
    }

    private static native long get_blobs_0(long var0);

    private static native String get_name_0(long var0);

    private static native int get_preferableTarget_0(long var0);

    private static native String get_type_0(long var0);

    private static native int outputNameToIndex_0(long var0, String var2);

    private static native void run_0(long var0, long var2, long var4, long var6);

    private static native void set_blobs_0(long var0, long var2);

    public void finalize() {
        Layer.delete(this.a);
    }

    public void h(List object, List list) {
        object = i.f.h.a.A((List)object);
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        Layer.finalize_0(l10, l11, l12);
        i.f.h.a.c(mat, list);
        mat.u0();
    }

    public List i() {
        ArrayList arrayList = new ArrayList();
        long l10 = Layer.get_blobs_0(this.a);
        Mat mat = new Mat(l10);
        i.f.h.a.c(mat, arrayList);
        return arrayList;
    }

    public String j() {
        return Layer.get_name_0(this.a);
    }

    public int k() {
        return Layer.get_preferableTarget_0(this.a);
    }

    public String l() {
        return Layer.get_type_0(this.a);
    }

    public int m(String string2) {
        return Layer.outputNameToIndex_0(this.a, string2);
    }

    public void n(List object, List list, List list2) {
        object = i.f.h.a.A((List)object);
        Mat mat = new Mat();
        Mat mat2 = i.f.h.a.A(list2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        Layer.run_0(l10, l11, l12, l13);
        i.f.h.a.c(mat, list);
        mat.u0();
        i.f.h.a.c(mat2, list2);
        mat2.u0();
    }

    public void o(List object) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        Layer.set_blobs_0(l10, l11);
    }
}

