/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.VideoCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.concurrent.atomic.AtomicReference;

public final class r1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ AtomicReference a;

    public /* synthetic */ r1(AtomicReference atomicReference) {
        this.a = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return VideoCapture.f(this.a, callbackToFutureAdapter$Completer);
    }
}

