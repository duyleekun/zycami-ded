/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class h
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ Camera2CameraControl a;

    public /* synthetic */ h(Camera2CameraControl camera2CameraControl) {
        this.a = camera2CameraControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.d(callbackToFutureAdapter$Completer);
    }
}

