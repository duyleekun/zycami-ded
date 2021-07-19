/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraClosedException;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$CaptureFailedException;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class ImageCapture$8
extends CameraCaptureCallback {
    public final /* synthetic */ ImageCapture this$0;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;

    public ImageCapture$8(ImageCapture imageCapture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.this$0 = imageCapture;
        this.val$completer = callbackToFutureAdapter$Completer;
    }

    public void onCaptureCancelled() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
        CameraClosedException cameraClosedException = new CameraClosedException("Capture request is cancelled because camera is closed");
        callbackToFutureAdapter$Completer.setException(cameraClosedException);
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.val$completer.set(null);
    }

    public void onCaptureFailed(CameraCaptureFailure object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Capture request failed with reason ");
        object = object.getReason();
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        object2 = this.val$completer;
        ImageCapture$CaptureFailedException imageCapture$CaptureFailedException = new ImageCapture$CaptureFailedException((String)object);
        ((CallbackToFutureAdapter$Completer)object2).setException(imageCapture$CaptureFailedException);
    }
}

