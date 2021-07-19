/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal$CameraControlException;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class FocusMeteringControl$2
extends CameraCaptureCallback {
    public final /* synthetic */ FocusMeteringControl this$0;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;

    public FocusMeteringControl$2(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.this$0 = focusMeteringControl;
        this.val$completer = callbackToFutureAdapter$Completer;
    }

    public void onCaptureCancelled() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
        if (callbackToFutureAdapter$Completer != null) {
            String string2 = "Camera is closed";
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
            callbackToFutureAdapter$Completer.setException(cameraControl$OperationCanceledException);
        }
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
        if (callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.set(cameraCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.val$completer;
        if (callbackToFutureAdapter$Completer != null) {
            CameraControlInternal$CameraControlException cameraControlInternal$CameraControlException = new CameraControlInternal$CameraControlException(cameraCaptureFailure);
            callbackToFutureAdapter$Completer.setException(cameraControlInternal$CameraControlException);
        }
    }
}

