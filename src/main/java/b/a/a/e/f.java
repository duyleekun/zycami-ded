/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class f
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ Camera2CameraControl a;

    public /* synthetic */ f(Camera2CameraControl camera2CameraControl) {
        this.a = camera2CameraControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.p(callbackToFutureAdapter$Completer);
    }
}

