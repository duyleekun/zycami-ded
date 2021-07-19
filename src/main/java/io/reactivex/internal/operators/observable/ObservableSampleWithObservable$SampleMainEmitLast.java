/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSampleWithObservable$SampleMainEmitLast
extends ObservableSampleWithObservable$SampleMainObserver {
    private static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip;

    public ObservableSampleWithObservable$SampleMainEmitLast(g0 object, e0 e02) {
        super((g0)object, e02);
        this.wip = object = new AtomicInteger();
    }

    public void completion() {
        this.done = true;
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            this.emit();
            object = this.downstream;
            object.onComplete();
        }
    }

    public void run() {
        AtomicInteger atomicInteger = this.wip;
        int n10 = atomicInteger.getAndIncrement();
        if (n10 == 0) {
            do {
                n10 = (int)(this.done ? 1 : 0);
                this.emit();
                if (n10 == 0) continue;
                this.downstream.onComplete();
                return;
            } while ((n10 = (atomicInteger = this.wip).decrementAndGet()) != 0);
        }
    }
}

