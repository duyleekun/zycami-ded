/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn$SubscribeOnObserver
extends AtomicReference
implements d,
b,
Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    public final d downstream;
    public final g source;
    public final SequentialDisposable task;

    public CompletableSubscribeOn$SubscribeOnObserver(d object, g g10) {
        this.downstream = object;
        this.source = g10;
        this.task = object = new SequentialDisposable();
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void run() {
        this.source.f(this);
    }
}

