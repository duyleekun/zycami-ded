/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn$SubscribeOnMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 8571289934935992137L;
    public final t downstream;
    public final SequentialDisposable task;

    public MaybeSubscribeOn$SubscribeOnMaybeObserver(t object) {
        this.downstream = object;
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

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }
}

