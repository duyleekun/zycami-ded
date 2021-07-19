/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class a
implements Runnable {
    public final /* synthetic */ Camera2CameraControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ a(Camera2CameraControl camera2CameraControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = camera2CameraControl;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        Camera2CameraControl camera2CameraControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        camera2CameraControl.f(callbackToFutureAdapter$Completer);
    }
}

