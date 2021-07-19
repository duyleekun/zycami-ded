/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class k
implements Runnable {
    public final /* synthetic */ Executor a;
    public final /* synthetic */ ListenableFuture b;
    public final /* synthetic */ CallbackToFutureAdapter$Completer c;
    public final /* synthetic */ long d;

    public /* synthetic */ k(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10) {
        this.a = executor;
        this.b = listenableFuture;
        this.c = callbackToFutureAdapter$Completer;
        this.d = l10;
    }

    public final void run() {
        Executor executor = this.a;
        ListenableFuture listenableFuture = this.b;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.c;
        long l10 = this.d;
        DeferrableSurfaces.b(executor, listenableFuture, callbackToFutureAdapter$Completer, l10);
    }
}

