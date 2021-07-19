/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.photo.MergeExposures;

public class MergeRobertson
extends MergeExposures {
    public MergeRobertson(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static MergeRobertson i(long l10) {
        MergeRobertson mergeRobertson = new MergeRobertson(l10);
        return mergeRobertson;
    }

    private static native void process_0(long var0, long var2, long var4, long var6, long var8);

    private static native void process_1(long var0, long var2, long var4, long var6);

    public void finalize() {
        MergeRobertson.delete(this.a);
    }

    public void h(List object, Mat mat, Mat mat2, Mat mat3) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        long l14 = mat3.a;
        MergeRobertson.process_0(l10, l11, l12, l13, l14);
    }

    public void j(List object, Mat mat, Mat mat2) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        MergeRobertson.process_1(l10, l11, l12, l13);
    }
}

