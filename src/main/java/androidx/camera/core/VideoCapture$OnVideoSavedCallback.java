/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture$OutputFileResults;

public interface VideoCapture$OnVideoSavedCallback {
    public void onError(int var1, String var2, Throwable var3);

    public void onVideoSaved(VideoCapture.OutputFileResults var1);
}

