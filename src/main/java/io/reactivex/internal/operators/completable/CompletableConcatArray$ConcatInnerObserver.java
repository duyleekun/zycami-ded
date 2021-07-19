/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray$ConcatInnerObserver
extends AtomicInteger
implements d {
    private static final long serialVersionUID = -7965400327305809232L;
    public final d downstream;
    public int index;
    public final SequentialDisposable sd;
    public final g[] sources;

    public CompletableConcatArray$ConcatInnerObserver(d object, g[] gArray) {
        this.downstream = object;
        this.sources = gArray;
        this.sd = object = new SequentialDisposable();
    }

    public void next() {
        int n10;
        g[] gArray = this.sd;
        int n11 = gArray.isDisposed();
        if (n11 != 0) {
            return;
        }
        n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        gArray = this.sources;
        do {
            int n12;
            Object object;
            if ((n10 = ((SequentialDisposable)(object = this.sd)).isDisposed()) != 0) {
                return;
            }
            n10 = this.index;
            this.index = n12 = n10 + 1;
            n12 = gArray.length;
            if (n10 == n12) {
                this.downstream.onComplete();
                return;
            }
            object = gArray[n10];
            object.f(this);
        } while ((n10 = this.decrementAndGet()) != 0);
    }

    public void onComplete() {
        this.next();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.sd.replace(b10);
    }
}

