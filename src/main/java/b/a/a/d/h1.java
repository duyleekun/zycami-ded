/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.TorchControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class h1
implements Runnable {
    public final /* synthetic */ TorchControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ h1(TorchControl torchControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, boolean bl2) {
        this.a = torchControl;
        this.b = callbackToFutureAdapter$Completer;
        this.c = bl2;
    }

    public final void run() {
        TorchControl torchControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        boolean bl2 = this.c;
        torchControl.b(callbackToFutureAdapter$Completer, bl2);
    }
}

