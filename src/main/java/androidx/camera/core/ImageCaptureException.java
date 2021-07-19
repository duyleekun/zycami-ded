/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public class ImageCaptureException
extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int n10, String string2, Throwable throwable) {
        super(string2, throwable);
        this.mImageCaptureError = n10;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}

