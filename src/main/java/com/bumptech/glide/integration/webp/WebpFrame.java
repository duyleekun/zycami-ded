/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;

public class WebpFrame {
    public static final int FRAME_DURATION_MS_FOR_MIN = 100;
    public static final int MIN_FRAME_DURATION_MS = 20;
    public boolean blendPreviousFrame;
    public int delay;
    public boolean disposeBackgroundColor;
    public int ih;
    public int iw;
    public int ix;
    public int iy;
    private long mNativePtr;

    public WebpFrame(long l10, int n10, int n11, int n12, int n13, int n14, boolean bl2, boolean bl3) {
        this.mNativePtr = l10;
        this.ix = n10;
        this.iy = n11;
        this.iw = n12;
        this.ih = n13;
        this.delay = n14;
        this.blendPreviousFrame = bl2;
        this.disposeBackgroundColor = bl3;
        this.fixFrameDuration();
    }

    private void fixFrameDuration() {
        int n10 = this.delay;
        int n11 = 20;
        if (n10 < n11) {
            this.delay = n10 = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int var1, int var2, Bitmap var3);

    public void dispose() {
        this.nativeDispose();
    }

    public void finalize() {
        this.nativeFinalize();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.ih;
    }

    public int getWidth() {
        return this.iw;
    }

    public int getXOffest() {
        return this.ix;
    }

    public int getYOffest() {
        return this.iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public void renderFrame(int n10, int n11, Bitmap bitmap) {
        this.nativeRenderFrame(n10, n11, bitmap);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}

