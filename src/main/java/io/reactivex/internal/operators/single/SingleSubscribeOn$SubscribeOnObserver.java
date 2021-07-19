/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn$SubscribeOnObserver
extends AtomicReference
implements l0,
b,
Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    public final l0 downstream;
    public final o0 source;
    public final SequentialDisposable task;

    public SingleSubscribeOn$SubscribeOnObserver(l0 object, o0 o02) {
        this.downstream = object;
        this.source = o02;
        this.task = object = new SequentialDisposable();
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
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

    public void run() {
        this.source.f(this);
    }
}

