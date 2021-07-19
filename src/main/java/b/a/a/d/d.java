/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraCaptureCallbackSet;
import androidx.camera.core.impl.CameraCaptureCallback;

public final class d
implements Runnable {
    public final /* synthetic */ CameraCaptureCallback a;

    public /* synthetic */ d(CameraCaptureCallback cameraCaptureCallback) {
        this.a = cameraCaptureCallback;
    }

    public final void run() {
        Camera2CameraControlImpl$CameraCaptureCallbackSet.a(this.a);
    }
}

