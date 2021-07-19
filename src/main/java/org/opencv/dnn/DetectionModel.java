/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import i.f.c.i;
import i.f.c.k;
import i.f.c.r;
import org.opencv.core.Mat;
import org.opencv.dnn.Model;
import org.opencv.dnn.Net;

public class DetectionModel
extends Model {
    public DetectionModel(long l10) {
        super(l10);
    }

    public DetectionModel(String string2) {
        long l10 = DetectionModel.DetectionModel_2(string2);
        super(l10);
    }

    public DetectionModel(String string2, String string3) {
        long l10 = DetectionModel.DetectionModel_1(string2, string3);
        super(l10);
    }

    public DetectionModel(Net net) {
        long l10 = DetectionModel.DetectionModel_0(net.a);
        super(l10);
    }

    private static native long DetectionModel_0(long var0);

    private static native long DetectionModel_1(String var0, String var1);

    private static native long DetectionModel_2(String var0);

    public static DetectionModel b0(long l10) {
        DetectionModel detectionModel = new DetectionModel(l10);
        return detectionModel;
    }

    private static native void delete(long var0);

    private static native void detect_0(long var0, long var2, long var4, long var6, long var8, float var10, float var11);

    private static native void detect_1(long var0, long var2, long var4, long var6, long var8, float var10);

    private static native void detect_2(long var0, long var2, long var4, long var6, long var8);

    public void c0(Mat mat, k k10, i i10, r r10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = k10.a;
        long l13 = i10.a;
        long l14 = r10.a;
        DetectionModel.detect_2(l10, l11, l12, l13, l14);
    }

    public void d0(Mat mat, k k10, i i10, r r10, float f10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = k10.a;
        long l13 = i10.a;
        long l14 = r10.a;
        DetectionModel.detect_1(l10, l11, l12, l13, l14, f10);
    }

    public void e0(Mat mat, k k10, i i10, r r10, float f10, float f11) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = k10.a;
        long l13 = i10.a;
        long l14 = r10.a;
        DetectionModel.detect_0(l10, l11, l12, l13, l14, f10, f11);
    }

    public void finalize() {
        DetectionModel.delete(this.a);
    }
}

