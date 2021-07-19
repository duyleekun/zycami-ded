/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CaptureSession;

public final class d0
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ CaptureSession b;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ d0(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession, Runnable runnable) {
        this.a = camera2CameraImpl;
        this.b = captureSession;
        this.c = runnable;
    }

    public final void run() {
        Camera2CameraImpl camera2CameraImpl = this.a;
        CaptureSession captureSession = this.b;
        Runnable runnable = this.c;
        camera2CameraImpl.g(captureSession, runnable);
    }
}

