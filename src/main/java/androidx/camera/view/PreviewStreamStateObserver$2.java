/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class PreviewStreamStateObserver$2
extends CameraCaptureCallback {
    public final /* synthetic */ PreviewStreamStateObserver this$0;
    public final /* synthetic */ CameraInfo val$cameraInfo;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;

    public PreviewStreamStateObserver$2(PreviewStreamStateObserver previewStreamStateObserver, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, CameraInfo cameraInfo) {
        this.this$0 = previewStreamStateObserver;
        this.val$completer = callbackToFutureAdapter$Completer;
        this.val$cameraInfo = cameraInfo;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.val$completer.set(null);
        ((CameraInfoInternal)this.val$cameraInfo).removeSessionCaptureCallback(this);
    }
}

