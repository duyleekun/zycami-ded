/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.google.common.util.concurrent.ListenableFuture;

public final class i
implements Runnable {
    public final /* synthetic */ ListenableFuture a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ long c;

    public /* synthetic */ i(ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        this.a = listenableFuture;
        this.b = callbackToFutureAdapter$Completer;
        this.c = l10;
    }

    public final void run() {
        ListenableFuture listenableFuture = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        long l10 = this.c;
        DeferrableSurfaces.a(listenableFuture, callbackToFutureAdapter$Completer, l10);
    }
}

