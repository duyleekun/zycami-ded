/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain$1;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FutureChain
implements ListenableFuture {
    public CallbackToFutureAdapter$Completer mCompleter;
    private final ListenableFuture mDelegate;

    public FutureChain() {
        Object object = new FutureChain$1(this);
        this.mDelegate = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
    }

    public FutureChain(ListenableFuture listenableFuture) {
        this.mDelegate = listenableFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    public static FutureChain from(ListenableFuture listenableFuture) {
        boolean bl2 = listenableFuture instanceof FutureChain;
        if (bl2) {
            listenableFuture = (FutureChain)listenableFuture;
        } else {
            FutureChain futureChain = new FutureChain(listenableFuture);
            listenableFuture = futureChain;
        }
        return listenableFuture;
    }

    public final void addCallback(FutureCallback futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean bl2) {
        return this.mDelegate.cancel(bl2);
    }

    public Object get() {
        return this.mDelegate.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.mDelegate.get(l10, timeUnit);
    }

    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public boolean set(Object object) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            return callbackToFutureAdapter$Completer.set(object);
        }
        return false;
    }

    public boolean setException(Throwable throwable) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            return callbackToFutureAdapter$Completer.setException(throwable);
        }
        return false;
    }

    public final FutureChain transform(Function function, Executor executor) {
        return (FutureChain)Futures.transform(this, function, executor);
    }

    public final FutureChain transformAsync(AsyncFunction asyncFunction, Executor executor) {
        return (FutureChain)Futures.transformAsync(this, asyncFunction, executor);
    }
}

