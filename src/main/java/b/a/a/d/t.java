/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.UseCase;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class t
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ UseCase c;

    public /* synthetic */ t(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, UseCase useCase) {
        this.a = camera2CameraImpl;
        this.b = callbackToFutureAdapter$Completer;
        this.c = useCase;
    }

    public final void run() {
        Camera2CameraImpl camera2CameraImpl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        UseCase useCase = this.c;
        camera2CameraImpl.o(callbackToFutureAdapter$Completer, useCase);
    }
}

