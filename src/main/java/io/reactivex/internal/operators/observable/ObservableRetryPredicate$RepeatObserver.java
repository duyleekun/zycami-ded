/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.r;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate$RepeatObserver
extends AtomicInteger
implements g0 {
    private static final long serialVersionUID = -7098360935104053232L;
    public final g0 downstream;
    public final r predicate;
    public long remaining;
    public final e0 source;
    public final SequentialDisposable upstream;

    public ObservableRetryPredicate$RepeatObserver(g0 g02, long l10, r r10, SequentialDisposable sequentialDisposable, e0 e02) {
        this.downstream = g02;
        this.upstream = sequentialDisposable;
        this.source = e02;
        this.predicate = r10;
        this.remaining = l10;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        long l10;
        long l11;
        long l12 = this.remaining;
        long l13 = Long.MAX_VALUE;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            this.remaining = l13 = l12 - 1L;
        }
        if ((l11 = (l10 = l12 - (l13 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            g0 g02 = this.downstream;
            g02.onError(throwable);
            return;
        }
        try {
            r r10 = this.predicate;
            l11 = (long)r10.test(throwable);
            if (l11 == false) {
                this.downstream.onError(throwable);
                return;
            }
            this.subscribeNext();
            return;
        }
        catch (Throwable throwable2) {
            a.b(throwable2);
            g0 g03 = this.downstream;
            Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
            CompositeException compositeException = new CompositeException(throwableArray);
            g03.onError(compositeException);
            return;
        }
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
                Object object;
                boolean bl2;
                if (bl2 = ((SequentialDisposable)(object = this.upstream)).isDisposed()) {
                    return;
                }
                object = this.source;
                object.subscribe(this);
                n10 = -n10;
            } while ((n10 = this.addAndGet(n10)) != 0);
        }
    }
}

