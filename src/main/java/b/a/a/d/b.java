/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class b
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ Camera2CameraControlImpl a;

    public /* synthetic */ b(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.a = camera2CameraControlImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.t(callbackToFutureAdapter$Completer);
    }
}

