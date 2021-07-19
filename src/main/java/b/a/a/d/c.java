/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraCaptureCallbackSet;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;

public final class c
implements Runnable {
    public final /* synthetic */ CameraCaptureCallback a;
    public final /* synthetic */ CameraCaptureResult b;

    public /* synthetic */ c(CameraCaptureCallback cameraCaptureCallback, CameraCaptureResult cameraCaptureResult) {
        this.a = cameraCaptureCallback;
        this.b = cameraCaptureResult;
    }

    public final void run() {
        CameraCaptureCallback cameraCaptureCallback = this.a;
        CameraCaptureResult cameraCaptureResult = this.b;
        Camera2CameraControlImpl$CameraCaptureCallbackSet.b(cameraCaptureCallback, cameraCaptureResult);
    }
}

