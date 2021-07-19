/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.videoio;

import i.f.c.z;
import org.opencv.core.Mat;

public class VideoWriter {
    public final long a;

    public VideoWriter() {
        long l10;
        this.a = l10 = VideoWriter.VideoWriter_4();
    }

    public VideoWriter(long l10) {
        this.a = l10;
    }

    public VideoWriter(String string2, int n10, double d10, z z10) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        this.a = l10 = VideoWriter.VideoWriter_3(string2, n10, d10, d11, d12);
    }

    public VideoWriter(String string2, int n10, double d10, z z10, boolean bl2) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        this.a = l10 = VideoWriter.VideoWriter_2(string2, n10, d10, d11, d12, bl2);
    }

    public VideoWriter(String string2, int n10, int n11, double d10, z z10) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        this.a = l10 = VideoWriter.VideoWriter_1(string2, n10, n11, d10, d11, d12);
    }

    public VideoWriter(String string2, int n10, int n11, double d10, z z10, boolean bl2) {
        long l10;
        double d11 = z10.a;
        double d12 = z10.b;
        this.a = l10 = VideoWriter.VideoWriter_0(string2, n10, n11, d10, d11, d12, bl2);
    }

    private static native long VideoWriter_0(String var0, int var1, int var2, double var3, double var5, double var7, boolean var9);

    private static native long VideoWriter_1(String var0, int var1, int var2, double var3, double var5, double var7);

    private static native long VideoWriter_2(String var0, int var1, double var2, double var4, double var6, boolean var8);

    private static native long VideoWriter_3(String var0, int var1, double var2, double var4, double var6);

    private static native long VideoWriter_4();

    public static VideoWriter a(long l10) {
        VideoWriter videoWriter = new VideoWriter(l10);
        return videoWriter;
    }

    public static int b(char c10, char c11, char c12, char c13) {
        return VideoWriter.fourcc_0(c10, c11, c12, c13);
    }

    private static native void delete(long var0);

    private static native int fourcc_0(char var0, char var1, char var2, char var3);

    private static native String getBackendName_0(long var0);

    private static native double get_0(long var0, int var2);

    private static native boolean isOpened_0(long var0);

    private static native boolean open_0(long var0, String var2, int var3, int var4, double var5, double var7, double var9, boolean var11);

    private static native boolean open_1(long var0, String var2, int var3, int var4, double var5, double var7, double var9);

    private static native boolean open_2(long var0, String var2, int var3, double var4, double var6, double var8, boolean var10);

    private static native boolean open_3(long var0, String var2, int var3, double var4, double var6, double var8);

    private static native void release_0(long var0);

    private static native boolean set_0(long var0, int var2, double var3);

    private static native void write_0(long var0, long var2);

    public double c(int n10) {
        return VideoWriter.get_0(this.a, n10);
    }

    public String d() {
        return VideoWriter.getBackendName_0(this.a);
    }

    public long e() {
        return this.a;
    }

    public boolean f() {
        return VideoWriter.isOpened_0(this.a);
    }

    public void finalize() {
        VideoWriter.delete(this.a);
    }

    public boolean g(String string2, int n10, double d10, z z10) {
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        return VideoWriter.open_3(l10, string2, n10, d10, d11, d12);
    }

    public boolean h(String string2, int n10, double d10, z z10, boolean bl2) {
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        return VideoWriter.open_2(l10, string2, n10, d10, d11, d12, bl2);
    }

    public boolean i(String string2, int n10, int n11, double d10, z z10) {
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        return VideoWriter.open_1(l10, string2, n10, n11, d10, d11, d12);
    }

    public boolean j(String string2, int n10, int n11, double d10, z z10, boolean bl2) {
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        return VideoWriter.open_0(l10, string2, n10, n11, d10, d11, d12, bl2);
    }

    public void k() {
        VideoWriter.release_0(this.a);
    }

    public boolean l(int n10, double d10) {
        return VideoWriter.set_0(this.a, n10, d10);
    }

    public void m(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        VideoWriter.write_0(l10, l11);
    }
}

