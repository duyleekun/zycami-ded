/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class q
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ q(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = camera2CameraImpl;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        Camera2CameraImpl camera2CameraImpl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        camera2CameraImpl.z(callbackToFutureAdapter$Completer);
    }
}

