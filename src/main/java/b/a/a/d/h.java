/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.concurrent.Executor;

public final class h
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ CameraCaptureCallback c;

    public /* synthetic */ h(Camera2CameraControlImpl camera2CameraControlImpl, Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.a = camera2CameraControlImpl;
        this.b = executor;
        this.c = cameraCaptureCallback;
    }

    public final void run() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.a;
        Executor executor = this.b;
        CameraCaptureCallback cameraCaptureCallback = this.c;
        camera2CameraControlImpl.c(executor, cameraCaptureCallback);
    }
}

