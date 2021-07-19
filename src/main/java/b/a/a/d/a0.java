/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.UseCase;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class a0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ UseCase b;

    public /* synthetic */ a0(Camera2CameraImpl camera2CameraImpl, UseCase useCase) {
        this.a = camera2CameraImpl;
        this.b = useCase;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Camera2CameraImpl camera2CameraImpl = this.a;
        UseCase useCase = this.b;
        return camera2CameraImpl.m(useCase, callbackToFutureAdapter$Completer);
    }
}

