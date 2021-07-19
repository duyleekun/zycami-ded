/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class y
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ Camera2CameraImpl a;

    public /* synthetic */ y(Camera2CameraImpl camera2CameraImpl) {
        this.a = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.B(callbackToFutureAdapter$Completer);
    }
}

