/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.concurrent.atomic.AtomicReference;

public final class i1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ String b;

    public /* synthetic */ i1(AtomicReference atomicReference, String string2) {
        this.a = atomicReference;
        this.b = string2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        AtomicReference atomicReference = this.a;
        String string2 = this.b;
        return SurfaceRequest.a(atomicReference, string2, callbackToFutureAdapter$Completer);
    }
}

