/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.h.a;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class AlignExposures
extends Algorithm {
    public AlignExposures(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static AlignExposures g(long l10) {
        AlignExposures alignExposures = new AlignExposures(l10);
        return alignExposures;
    }

    private static native void process_0(long var0, long var2, long var4, long var6, long var8);

    public void finalize() {
        AlignExposures.delete(this.a);
    }

    public void h(List object, List object2, Mat mat, Mat mat2) {
        object = i.f.h.a.A((List)object);
        object2 = i.f.h.a.A((List)object2);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = ((Mat)object2).a;
        long l13 = mat.a;
        long l14 = mat2.a;
        AlignExposures.process_0(l10, l11, l12, l13, l14);
    }
}

