/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture$OutputFileResults;
import androidx.camera.core.ImageCaptureException;

public interface ImageCapture$OnImageSavedCallback {
    public void onError(ImageCaptureException var1);

    public void onImageSaved(ImageCapture.OutputFileResults var1);
}

