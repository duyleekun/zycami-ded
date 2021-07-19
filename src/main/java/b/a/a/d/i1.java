/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.TorchControl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class i1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ TorchControl a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ i1(TorchControl torchControl, boolean bl2) {
        this.a = torchControl;
        this.b = bl2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        TorchControl torchControl = this.a;
        boolean bl2 = this.b;
        return torchControl.d(bl2, callbackToFutureAdapter$Completer);
    }
}

