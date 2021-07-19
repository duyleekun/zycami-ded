/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter$FutureGarbageCollectedException;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class CallbackToFutureAdapter$Completer {
    private boolean attemptedSetting;
    private ResolvableFuture cancellationFuture;
    public CallbackToFutureAdapter$SafeFuture future;
    public Object tag;

    public CallbackToFutureAdapter$Completer() {
        ResolvableFuture resolvableFuture;
        this.cancellationFuture = resolvableFuture = ResolvableFuture.create();
    }

    private void setCompletedNormally() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture = null;
    }

    public void addCancellationListener(Runnable runnable, Executor executor) {
        ResolvableFuture resolvableFuture = this.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(runnable, executor);
        }
    }

    public void finalize() {
        boolean bl2;
        CallbackToFutureAdapter$FutureGarbageCollectedException callbackToFutureAdapter$FutureGarbageCollectedException;
        boolean bl3;
        ListenableFuture listenableFuture = this.future;
        if (listenableFuture != null && !(bl3 = ((CallbackToFutureAdapter$SafeFuture)listenableFuture).isDone())) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            Object object = this.tag;
            charSequence.append(object);
            charSequence = charSequence.toString();
            callbackToFutureAdapter$FutureGarbageCollectedException = new CallbackToFutureAdapter$FutureGarbageCollectedException((String)charSequence);
            ((CallbackToFutureAdapter$SafeFuture)listenableFuture).setException(callbackToFutureAdapter$FutureGarbageCollectedException);
        }
        if (!(bl2 = this.attemptedSetting) && (listenableFuture = this.cancellationFuture) != null) {
            bl3 = false;
            callbackToFutureAdapter$FutureGarbageCollectedException = null;
            ((ResolvableFuture)listenableFuture).set(null);
        }
    }

    public void fireCancellationListeners() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture.set(null);
    }

    public boolean set(Object object) {
        boolean bl2;
        boolean bl3;
        this.attemptedSetting = bl3 = true;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture == null || !(bl2 = callbackToFutureAdapter$SafeFuture.set(object))) {
            bl3 = false;
        }
        if (bl3) {
            this.setCompletedNormally();
        }
        return bl3;
    }

    public boolean setCancelled() {
        boolean bl2;
        boolean bl3;
        this.attemptedSetting = bl3 = true;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture == null || !(bl2 = callbackToFutureAdapter$SafeFuture.cancelWithoutNotifyingCompleter(bl3))) {
            bl3 = false;
        }
        if (bl3) {
            this.setCompletedNormally();
        }
        return bl3;
    }

    public boolean setException(Throwable throwable) {
        boolean bl2;
        boolean bl3;
        this.attemptedSetting = bl3 = true;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture == null || !(bl2 = callbackToFutureAdapter$SafeFuture.setException(throwable))) {
            bl3 = false;
        }
        if (bl3) {
            this.setCompletedNormally();
        }
        return bl3;
    }
}

