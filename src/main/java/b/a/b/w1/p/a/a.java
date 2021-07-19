/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1.p.a;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import com.google.common.util.concurrent.ListenableFuture;

public final class a
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ListenableFuture a;

    public /* synthetic */ a(ListenableFuture listenableFuture) {
        this.a = listenableFuture;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return Futures.a(this.a, callbackToFutureAdapter$Completer);
    }
}

