/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks$ComboSessionCaptureCallback;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks$NoOpSessionCaptureCallback;
import java.util.Arrays;
import java.util.List;

public final class Camera2CaptureCallbacks {
    private Camera2CaptureCallbacks() {
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(List list) {
        Camera2CaptureCallbacks$ComboSessionCaptureCallback camera2CaptureCallbacks$ComboSessionCaptureCallback = new Camera2CaptureCallbacks$ComboSessionCaptureCallback(list);
        return camera2CaptureCallbacks$ComboSessionCaptureCallback;
    }

    public static CameraCaptureSession.CaptureCallback createComboCallback(CameraCaptureSession.CaptureCallback ... captureCallbackArray) {
        return Camera2CaptureCallbacks.createComboCallback(Arrays.asList(captureCallbackArray));
    }

    public static CameraCaptureSession.CaptureCallback createNoOpCallback() {
        Camera2CaptureCallbacks$NoOpSessionCaptureCallback camera2CaptureCallbacks$NoOpSessionCaptureCallback = new Camera2CaptureCallbacks$NoOpSessionCaptureCallback();
        return camera2CaptureCallbacks$NoOpSessionCaptureCallback;
    }
}

