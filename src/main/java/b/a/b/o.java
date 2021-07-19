/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class o
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ CameraX a;

    public /* synthetic */ o(CameraX cameraX) {
        this.a = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.o(callbackToFutureAdapter$Completer);
    }
}

