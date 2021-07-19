/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class CallbackToFutureAdapter$SafeFuture
implements ListenableFuture {
    public final WeakReference completerWeakReference;
    private final AbstractResolvableFuture delegate;

    public CallbackToFutureAdapter$SafeFuture(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        WeakReference<CallbackToFutureAdapter$Completer> weakReference = new WeakReference<CallbackToFutureAdapter$Completer>(this);
        this.delegate = weakReference;
        this.completerWeakReference = weakReference = new WeakReference<CallbackToFutureAdapter$Completer>(callbackToFutureAdapter$Completer);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean bl2) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer)this.completerWeakReference.get();
        AbstractResolvableFuture abstractResolvableFuture = this.delegate;
        if ((bl2 = abstractResolvableFuture.cancel(bl2)) && callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.fireCancellationListeners();
        }
        return bl2;
    }

    public boolean cancelWithoutNotifyingCompleter(boolean bl2) {
        return this.delegate.cancel(bl2);
    }

    public Object get() {
        return this.delegate.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.delegate.get(l10, timeUnit);
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public boolean set(Object object) {
        return this.delegate.set(object);
    }

    public boolean setException(Throwable throwable) {
        return this.delegate.setException(throwable);
    }

    public String toString() {
        return this.delegate.toString();
    }
}

