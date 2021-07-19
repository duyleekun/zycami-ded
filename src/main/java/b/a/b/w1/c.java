/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.CameraRepository;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class c
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ CameraRepository a;

    public /* synthetic */ c(CameraRepository cameraRepository) {
        this.a = cameraRepository;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.b(callbackToFutureAdapter$Completer);
    }
}

