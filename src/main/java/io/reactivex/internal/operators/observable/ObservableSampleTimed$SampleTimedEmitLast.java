/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSampleTimed$SampleTimedEmitLast
extends ObservableSampleTimed$SampleTimedObserver {
    private static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip;

    public ObservableSampleTimed$SampleTimedEmitLast(g0 object, long l10, TimeUnit timeUnit, h0 h02) {
        super((g0)object, l10, timeUnit, h02);
        this.wip = object = new AtomicInteger(1);
    }

    public void complete() {
        this.emit();
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void run() {
        int n10;
        Object object = this.wip;
        int n11 = ((AtomicInteger)object).incrementAndGet();
        if (n11 == (n10 = 2)) {
            this.emit();
            object = this.wip;
            n11 = ((AtomicInteger)object).decrementAndGet();
            if (n11 == 0) {
                object = this.downstream;
                object.onComplete();
            }
        }
    }
}

