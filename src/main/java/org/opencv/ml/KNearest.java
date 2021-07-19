/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class KNearest
extends StatModel {
    public static final int f = 1;
    public static final int g = 2;

    public KNearest(long l10) {
        super(l10);
    }

    public static KNearest A(String string2) {
        return KNearest.r(KNearest.load_0(string2));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native float findNearest_0(long var0, long var2, int var4, long var5, long var7, long var9);

    private static native float findNearest_1(long var0, long var2, int var4, long var5, long var7);

    private static native float findNearest_2(long var0, long var2, int var4, long var5);

    private static native int getAlgorithmType_0(long var0);

    private static native int getDefaultK_0(long var0);

    private static native int getEmax_0(long var0);

    private static native boolean getIsClassifier_0(long var0);

    private static native long load_0(String var0);

    public static KNearest r(long l10) {
        KNearest kNearest = new KNearest(l10);
        return kNearest;
    }

    public static KNearest s() {
        return KNearest.r(KNearest.create_0());
    }

    private static native void setAlgorithmType_0(long var0, int var2);

    private static native void setDefaultK_0(long var0, int var2);

    private static native void setEmax_0(long var0, int var2);

    private static native void setIsClassifier_0(long var0, boolean var2);

    public void B(int n10) {
        KNearest.setAlgorithmType_0(this.a, n10);
    }

    public void C(int n10) {
        KNearest.setDefaultK_0(this.a, n10);
    }

    public void D(int n10) {
        KNearest.setEmax_0(this.a, n10);
    }

    public void E(boolean bl2) {
        KNearest.setIsClassifier_0(this.a, bl2);
    }

    public void finalize() {
        KNearest.delete(this.a);
    }

    public float t(Mat mat, int n10, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return KNearest.findNearest_2(l10, l11, n10, l12);
    }

    public float u(Mat mat, int n10, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return KNearest.findNearest_1(l10, l11, n10, l12, l13);
    }

    public float v(Mat mat, int n10, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        return KNearest.findNearest_0(l10, l11, n10, l12, l13, l14);
    }

    public int w() {
        return KNearest.getAlgorithmType_0(this.a);
    }

    public int x() {
        return KNearest.getDefaultK_0(this.a);
    }

    public int y() {
        return KNearest.getEmax_0(this.a);
    }

    public boolean z() {
        return KNearest.getIsClassifier_0(this.a);
    }
}

