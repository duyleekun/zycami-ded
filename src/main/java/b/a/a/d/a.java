/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.impl.CameraCaptureCallback;

public final class a
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;
    public final /* synthetic */ CameraCaptureCallback b;

    public /* synthetic */ a(Camera2CameraControlImpl camera2CameraControlImpl, CameraCaptureCallback cameraCaptureCallback) {
        this.a = camera2CameraControlImpl;
        this.b = cameraCaptureCallback;
    }

    public final void run() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.a;
        CameraCaptureCallback cameraCaptureCallback = this.b;
        camera2CameraControlImpl.j(cameraCaptureCallback);
    }
}

