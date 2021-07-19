/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture$OutputFileResults;
import androidx.camera.core.ImageSaver$SaveError;

public interface ImageSaver$OnImageSavedCallback {
    public void onError(ImageSaver$SaveError var1, String var2, Throwable var3);

    public void onImageSaved(ImageCapture$OutputFileResults var1);
}

