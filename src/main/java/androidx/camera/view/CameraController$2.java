/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileResults;
import androidx.camera.view.CameraController;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileResults;

public class CameraController$2
implements VideoCapture$OnVideoSavedCallback {
    public final /* synthetic */ CameraController this$0;
    public final /* synthetic */ OnVideoSavedCallback val$callback;

    public CameraController$2(CameraController cameraController, OnVideoSavedCallback onVideoSavedCallback) {
        this.this$0 = cameraController;
        this.val$callback = onVideoSavedCallback;
    }

    public void onError(int n10, String string2, Throwable throwable) {
        this.this$0.mVideoIsRecording.set(false);
        this.val$callback.onError(n10, string2, throwable);
    }

    public void onVideoSaved(VideoCapture$OutputFileResults object) {
        this.this$0.mVideoIsRecording.set(false);
        OnVideoSavedCallback onVideoSavedCallback = this.val$callback;
        object = OutputFileResults.create(((VideoCapture$OutputFileResults)object).getSavedUri());
        onVideoSavedCallback.onVideoSaved((OutputFileResults)object);
    }
}

