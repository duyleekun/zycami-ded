/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp;

import com.bumptech.glide.integration.webp.WebpFrame;
import d.c.a.n.a.b;
import d.c.a.u.k;
import java.nio.ByteBuffer;

public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    private long mNativePtr;
    private int mWidth;

    static {
        System.loadLibrary("glide-webp");
    }

    public WebpImage(long l10, int n10, int n11, int n12, int n13, int[] nArray, int n14, int n15) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.mWidth = n10;
            this.mHeigth = n11;
            this.mFrameCount = n12;
            this.mDurationMs = n13;
            this.mFrameDurations = nArray;
            this.mLoopCount = n14;
            this.fixFrameDurations(nArray);
            this.mBackgroundColor = n15;
            this.mNativePtr = l10;
            return;
        }
        RuntimeException runtimeException = new RuntimeException("internal error: native WebpImage is 0");
        throw runtimeException;
    }

    public static WebpImage create(byte[] byArray) {
        k.d(byArray);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byArray.length);
        byteBuffer.put(byArray);
        byteBuffer.rewind();
        return WebpImage.nativeCreateFromDirectByteBuffer(byteBuffer);
    }

    private void fixFrameDurations(int[] nArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            int n11 = 20;
            if (n10 >= n11) continue;
            nArray[i10] = n10 = 100;
        }
    }

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer var0);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int var1);

    private native int nativeGetSizeInBytes();

    public void dispose() {
        this.nativeDispose();
    }

    public void finalize() {
        this.nativeFinalize();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public WebpFrame getFrame(int n10) {
        return this.nativeGetFrame(n10);
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public b getFrameInfo(int n10) {
        WebpFrame webpFrame = this.getFrame(n10);
        try {
            b b10 = new b(n10, webpFrame);
            return b10;
        }
        finally {
            webpFrame.dispose();
        }
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getSizeInBytes() {
        return this.nativeGetSizeInBytes();
    }

    public int getWidth() {
        return this.mWidth;
    }
}

