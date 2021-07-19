/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import i.f.c.z;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

public class LineSegmentDetector
extends Algorithm {
    public LineSegmentDetector(long l10) {
        super(l10);
    }

    private static native int compareSegments_0(long var0, double var2, double var4, long var6, long var8, long var10);

    private static native int compareSegments_1(long var0, double var2, double var4, long var6, long var8);

    private static native void delete(long var0);

    private static native void detect_0(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void detect_1(long var0, long var2, long var4, long var6, long var8);

    private static native void detect_2(long var0, long var2, long var4, long var6);

    private static native void detect_3(long var0, long var2, long var4);

    private static native void drawSegments_0(long var0, long var2, long var4);

    public static LineSegmentDetector g(long l10) {
        LineSegmentDetector lineSegmentDetector = new LineSegmentDetector(l10);
        return lineSegmentDetector;
    }

    public void finalize() {
        LineSegmentDetector.delete(this.a);
    }

    public int h(z z10, Mat mat, Mat mat2) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat.a;
        long l12 = mat2.a;
        return LineSegmentDetector.compareSegments_1(l10, d10, d11, l11, l12);
    }

    public int i(z z10, Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return LineSegmentDetector.compareSegments_0(l10, d10, d11, l11, l12, l13);
    }

    public void j(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        LineSegmentDetector.detect_3(l10, l11, l12);
    }

    public void k(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        LineSegmentDetector.detect_2(l10, l11, l12, l13);
    }

    public void l(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        LineSegmentDetector.detect_1(l10, l11, l12, l13, l14);
    }

    public void m(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        long l14 = mat4.a;
        long l15 = mat5.a;
        LineSegmentDetector.detect_0(l10, l11, l12, l13, l14, l15);
    }

    public void n(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        LineSegmentDetector.drawSegments_0(l10, l11, l12);
    }
}

