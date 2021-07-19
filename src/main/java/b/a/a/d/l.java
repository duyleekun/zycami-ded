/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class l
implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ l(Camera2CameraControlImpl camera2CameraControlImpl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = camera2CameraControlImpl;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        camera2CameraControlImpl.r(callbackToFutureAdapter$Completer);
    }
}

