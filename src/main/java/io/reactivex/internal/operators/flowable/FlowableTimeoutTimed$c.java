/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$b;

public final class FlowableTimeoutTimed$c
implements Runnable {
    public final FlowableTimeoutTimed$b a;
    public final long b;

    public FlowableTimeoutTimed$c(long l10, FlowableTimeoutTimed$b flowableTimeoutTimed$b) {
        this.b = l10;
        this.a = flowableTimeoutTimed$b;
    }

    public void run() {
        FlowableTimeoutTimed$b flowableTimeoutTimed$b = this.a;
        long l10 = this.b;
        flowableTimeoutTimed$b.onTimeout(l10);
    }
}

