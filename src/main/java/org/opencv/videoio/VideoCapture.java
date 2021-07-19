/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.videoio;

import org.opencv.core.Mat;

public class VideoCapture {
    public final long a;

    public VideoCapture() {
        long l10;
        this.a = l10 = VideoCapture.VideoCapture_4();
    }

    public VideoCapture(int n10) {
        long l10;
        this.a = l10 = VideoCapture.VideoCapture_3(n10);
    }

    public VideoCapture(int n10, int n11) {
        long l10;
        this.a = l10 = VideoCapture.VideoCapture_2(n10, n11);
    }

    public VideoCapture(long l10) {
        this.a = l10;
    }

    public VideoCapture(String string2) {
        long l10;
        this.a = l10 = VideoCapture.VideoCapture_1(string2);
    }

    public VideoCapture(String string2, int n10) {
        long l10;
        this.a = l10 = VideoCapture.VideoCapture_0(string2, n10);
    }

    private static native long VideoCapture_0(String var0, int var1);

    private static native long VideoCapture_1(String var0);

    private static native long VideoCapture_2(int var0, int var1);

    private static native long VideoCapture_3(int var0);

    private static native long VideoCapture_4();

    public static VideoCapture a(long l10) {
        VideoCapture videoCapture = new VideoCapture(l10);
        return videoCapture;
    }

    private static native void delete(long var0);

    private static native String getBackendName_0(long var0);

    private static native boolean getExceptionMode_0(long var0);

    private static native double get_0(long var0, int var2);

    private static native boolean grab_0(long var0);

    private static native boolean isOpened_0(long var0);

    private static native boolean open_0(long var0, String var2, int var3);

    private static native boolean open_1(long var0, String var2);

    private static native boolean open_2(long var0, int var2, int var3);

    private static native boolean open_3(long var0, int var2);

    private static native boolean read_0(long var0, long var2);

    private static native void release_0(long var0);

    private static native boolean retrieve_0(long var0, long var2, int var4);

    private static native boolean retrieve_1(long var0, long var2);

    private static native void setExceptionMode_0(long var0, boolean var2);

    private static native boolean set_0(long var0, int var2, double var3);

    public double b(int n10) {
        return VideoCapture.get_0(this.a, n10);
    }

    public String c() {
        return VideoCapture.getBackendName_0(this.a);
    }

    public boolean d() {
        return VideoCapture.getExceptionMode_0(this.a);
    }

    public long e() {
        return this.a;
    }

    public boolean f() {
        return VideoCapture.grab_0(this.a);
    }

    public void finalize() {
        VideoCapture.delete(this.a);
    }

    public boolean g() {
        return VideoCapture.isOpened_0(this.a);
    }

    public boolean h(int n10) {
        return VideoCapture.open_3(this.a, n10);
    }

    public boolean i(int n10, int n11) {
        return VideoCapture.open_2(this.a, n10, n11);
    }

    public boolean j(String string2) {
        return VideoCapture.open_1(this.a, string2);
    }

    public boolean k(String string2, int n10) {
        return VideoCapture.open_0(this.a, string2, n10);
    }

    public boolean l(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return VideoCapture.read_0(l10, l11);
    }

    public void m() {
        VideoCapture.release_0(this.a);
    }

    public boolean n(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return VideoCapture.retrieve_1(l10, l11);
    }

    public boolean o(Mat mat, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        return VideoCapture.retrieve_0(l10, l11, n10);
    }

    public boolean p(int n10, double d10) {
        return VideoCapture.set_0(this.a, n10, d10);
    }

    public void q(boolean bl2) {
        VideoCapture.setExceptionMode_0(this.a, bl2);
    }
}

