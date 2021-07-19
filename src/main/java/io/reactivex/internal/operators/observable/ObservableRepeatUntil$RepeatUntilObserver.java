/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil$RepeatUntilObserver
extends AtomicInteger
implements g0 {
    private static final long serialVersionUID = -7098360935104053232L;
    public final g0 downstream;
    public final e0 source;
    public final e stop;
    public final SequentialDisposable upstream;

    public ObservableRepeatUntil$RepeatUntilObserver(g0 g02, e e10, SequentialDisposable sequentialDisposable, e0 e02) {
        this.downstream = g02;
        this.upstream = sequentialDisposable;
        this.source = e02;
        this.stop = e10;
    }

    public void onComplete() {
        Object object;
        try {
            object = this.stop;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        boolean bl2 = object.getAsBoolean();
        if (bl2) {
            object = this.downstream;
            object.onComplete();
        } else {
            this.subscribeNext();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.upstream.replace(b10);
    }

    public void subscribeNext() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 1;
            do {
                e0 e02 = this.source;
                e02.subscribe(this);
                n10 = -n10;
            } while ((n10 = this.addAndGet(n10)) != 0);
        }
    }
}

