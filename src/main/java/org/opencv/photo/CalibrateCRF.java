/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import i.f.h.a;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class CalibrateCRF
extends Algorithm {
    public CalibrateCRF(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static CalibrateCRF g(long l10) {
        CalibrateCRF calibrateCRF = new CalibrateCRF(l10);
        return calibrateCRF;
    }

    private static native void process_0(long var0, long var2, long var4, long var6);

    public void finalize() {
        CalibrateCRF.delete(this.a);
    }

    public void h(List object, Mat mat, Mat mat2) {
        object = i.f.h.a.A((List)object);
        long l10 = this.a;
        long l11 = ((Mat)object).a;
        long l12 = mat.a;
        long l13 = mat2.a;
        CalibrateCRF.process_0(l10, l11, l12, l13);
    }
}

