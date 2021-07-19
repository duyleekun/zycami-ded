/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableSampleTimed$SampleTimedNoLast
extends ObservableSampleTimed$SampleTimedObserver {
    private static final long serialVersionUID = -7139995637533111443L;

    public ObservableSampleTimed$SampleTimedNoLast(g0 g02, long l10, TimeUnit timeUnit, h0 h02) {
        super(g02, l10, timeUnit, h02);
    }

    public void complete() {
        this.downstream.onComplete();
    }

    public void run() {
        this.emit();
    }
}

