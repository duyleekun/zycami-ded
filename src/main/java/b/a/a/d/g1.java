/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class g1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ SynchronizedCaptureSessionImpl a;

    public /* synthetic */ g1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        this.a = synchronizedCaptureSessionImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.j(callbackToFutureAdapter$Completer);
    }
}

