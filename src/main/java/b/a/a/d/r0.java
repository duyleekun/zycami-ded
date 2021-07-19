/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class r0
implements Runnable {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;

    public /* synthetic */ r0(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = focusMeteringControl;
        this.b = callbackToFutureAdapter$Completer;
    }

    public final void run() {
        FocusMeteringControl focusMeteringControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        focusMeteringControl.b(callbackToFutureAdapter$Completer);
    }
}

