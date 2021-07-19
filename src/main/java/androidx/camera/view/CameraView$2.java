/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileResults;
import androidx.camera.view.CameraView;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileResults;

public class CameraView$2
implements VideoCapture$OnVideoSavedCallback {
    public final /* synthetic */ CameraView this$0;
    public final /* synthetic */ OnVideoSavedCallback val$callback;

    public CameraView$2(CameraView cameraView, OnVideoSavedCallback onVideoSavedCallback) {
        this.this$0 = cameraView;
        this.val$callback = onVideoSavedCallback;
    }

    public void onError(int n10, String string2, Throwable throwable) {
        this.val$callback.onError(n10, string2, throwable);
    }

    public void onVideoSaved(VideoCapture$OutputFileResults object) {
        OnVideoSavedCallback onVideoSavedCallback = this.val$callback;
        object = OutputFileResults.create(((VideoCapture$OutputFileResults)object).getSavedUri());
        onVideoSavedCallback.onVideoSaved((OutputFileResults)object);
    }
}

