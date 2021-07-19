/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.objdetect;

import org.opencv.core.Mat;

public class QRCodeDetector {
    public final long a;

    public QRCodeDetector() {
        long l10;
        this.a = l10 = QRCodeDetector.QRCodeDetector_0();
    }

    public QRCodeDetector(long l10) {
        this.a = l10;
    }

    private static native long QRCodeDetector_0();

    public static QRCodeDetector a(long l10) {
        QRCodeDetector qRCodeDetector = new QRCodeDetector(l10);
        return qRCodeDetector;
    }

    private static native String decode_0(long var0, long var2, long var4, long var6);

    private static native String decode_1(long var0, long var2, long var4);

    private static native void delete(long var0);

    private static native String detectAndDecode_0(long var0, long var2, long var4, long var6);

    private static native String detectAndDecode_1(long var0, long var2, long var4);

    private static native String detectAndDecode_2(long var0, long var2);

    private static native boolean detect_0(long var0, long var2, long var4);

    private static native void setEpsX_0(long var0, double var2);

    private static native void setEpsY_0(long var0, double var2);

    public String b(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return QRCodeDetector.decode_1(l10, l11, l12);
    }

    public String c(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return QRCodeDetector.decode_0(l10, l11, l12, l13);
    }

    public boolean d(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return QRCodeDetector.detect_0(l10, l11, l12);
    }

    public String e(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return QRCodeDetector.detectAndDecode_2(l10, l11);
    }

    public String f(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        return QRCodeDetector.detectAndDecode_1(l10, l11, l12);
    }

    public void finalize() {
        QRCodeDetector.delete(this.a);
    }

    public String g(Mat mat, Mat mat2, Mat mat3) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = mat3.a;
        return QRCodeDetector.detectAndDecode_0(l10, l11, l12, l13);
    }

    public long h() {
        return this.a;
    }

    public void i(double d10) {
        QRCodeDetector.setEpsX_0(this.a, d10);
    }

    public void j(double d10) {
        QRCodeDetector.setEpsY_0(this.a, d10);
    }
}

