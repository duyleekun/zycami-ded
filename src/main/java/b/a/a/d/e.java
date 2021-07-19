/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraCaptureCallbackSet;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;

public final class e
implements Runnable {
    public final /* synthetic */ CameraCaptureCallback a;
    public final /* synthetic */ CameraCaptureFailure b;

    public /* synthetic */ e(CameraCaptureCallback cameraCaptureCallback, CameraCaptureFailure cameraCaptureFailure) {
        this.a = cameraCaptureCallback;
        this.b = cameraCaptureFailure;
    }

    public final void run() {
        CameraCaptureCallback cameraCaptureCallback = this.a;
        CameraCaptureFailure cameraCaptureFailure = this.b;
        Camera2CameraControlImpl$CameraCaptureCallbackSet.c(cameraCaptureCallback, cameraCaptureFailure);
    }
}

