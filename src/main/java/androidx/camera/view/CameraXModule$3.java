/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.Logger;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileResults;
import androidx.camera.view.CameraXModule;

public class CameraXModule$3
implements VideoCapture$OnVideoSavedCallback {
    public final /* synthetic */ CameraXModule this$0;
    public final /* synthetic */ VideoCapture$OnVideoSavedCallback val$callback;

    public CameraXModule$3(CameraXModule cameraXModule, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.this$0 = cameraXModule;
        this.val$callback = videoCapture$OnVideoSavedCallback;
    }

    public void onError(int n10, String string2, Throwable throwable) {
        this.this$0.mVideoIsRecording.set(false);
        Logger.e("CameraXModule", string2, throwable);
        this.val$callback.onError(n10, string2, throwable);
    }

    public void onVideoSaved(VideoCapture$OutputFileResults videoCapture$OutputFileResults) {
        this.this$0.mVideoIsRecording.set(false);
        this.val$callback.onVideoSaved(videoCapture$OutputFileResults);
    }
}

