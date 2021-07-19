/*
 * Decompiled with CFR 0.151.
 */
package com.zhishen.imagetool;

public class ImagePixelBuffer {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public byte[] e = null;
    public long f = 0L;

    public ImagePixelBuffer(byte[] byArray, int n10, int n11, int n12, int n13) {
        this.e = byArray;
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = n13;
    }

    public static ImagePixelBuffer a(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n12 < n10 ? n10 : n12;
        ImagePixelBuffer imagePixelBuffer = new ImagePixelBuffer(byArray, n10, n11, n13, 35);
        return imagePixelBuffer;
    }

    public static ImagePixelBuffer b(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n12 < n10 ? n10 : n12;
        ImagePixelBuffer imagePixelBuffer = new ImagePixelBuffer(byArray, n10, n11, n13, 4369);
        return imagePixelBuffer;
    }

    public static ImagePixelBuffer c(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n12 < n10 ? n10 : n12;
        ImagePixelBuffer imagePixelBuffer = new ImagePixelBuffer(byArray, n10, n11, n13, 17);
        return imagePixelBuffer;
    }

    public static ImagePixelBuffer d(byte[] byArray, int n10, int n11) {
        ImagePixelBuffer imagePixelBuffer = new ImagePixelBuffer(byArray, n10, n11, n10, 1);
        return imagePixelBuffer;
    }

    public static ImagePixelBuffer e(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n12 < n10 ? n10 : n12;
        ImagePixelBuffer imagePixelBuffer = new ImagePixelBuffer(byArray, n10, n11, n13, 8738);
        return imagePixelBuffer;
    }
}

