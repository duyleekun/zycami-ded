/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.CaptureSession;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class g0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ CaptureSession a;

    public /* synthetic */ g0(CaptureSession captureSession) {
        this.a = captureSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.f(callbackToFutureAdapter$Completer);
    }
}

