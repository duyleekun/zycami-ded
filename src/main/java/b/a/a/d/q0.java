/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class q0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ FocusMeteringControl a;

    public /* synthetic */ q0(FocusMeteringControl focusMeteringControl) {
        this.a = focusMeteringControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a.d(callbackToFutureAdapter$Completer);
    }
}

