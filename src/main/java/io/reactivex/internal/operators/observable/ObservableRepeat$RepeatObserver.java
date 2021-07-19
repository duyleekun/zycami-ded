/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat$RepeatObserver
extends AtomicInteger
implements g0 {
    private static final long serialVersionUID = -7098360935104053232L;
    public final g0 downstream;
    public long remaining;
    public final SequentialDisposable sd;
    public final e0 source;

    public ObservableRepeat$RepeatObserver(g0 g02, long l10, SequentialDisposable sequentialDisposable, e0 e02) {
        this.downstream = g02;
        this.sd = sequentialDisposable;
        this.source = e02;
        this.remaining = l10;
    }

    public void onComplete() {
        long l10;
        long l11;
        long l12 = this.remaining;
        long l13 = Long.MAX_VALUE;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            this.remaining = l13 = l12 - 1L;
        }
        if ((l11 = (l10 = l12 - (l13 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            this.subscribeNext();
        } else {
            g0 g02 = this.downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.sd.replace(b10);
    }

    public void subscribeNext() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 1;
            do {
                Object object;
                boolean bl2;
                if (bl2 = ((SequentialDisposable)(object = this.sd)).isDisposed()) {
                    return;
                }
                object = this.source;
                object.subscribe(this);
                n10 = -n10;
            } while ((n10 = this.addAndGet(n10)) != 0);
        }
    }
}

