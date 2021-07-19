/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class n
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ CameraX a;

    public /* synthetic */ n(CameraX cameraX) {
        this.a = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return CameraX.q(this.a, callbackToFutureAdapter$Completer);
    }
}

