/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableSampleTimed$SampleTimedNoLast
extends FlowableSampleTimed$SampleTimedSubscriber {
    private static final long serialVersionUID = -7139995637533111443L;

    public FlowableSampleTimed$SampleTimedNoLast(d d10, long l10, TimeUnit timeUnit, h0 h02) {
        super(d10, l10, timeUnit, h02);
    }

    public void complete() {
        this.downstream.onComplete();
    }

    public void run() {
        this.emit();
    }
}

