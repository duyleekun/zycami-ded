/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.v0.g;
import io.reactivex.internal.operators.flowable.FlowableReplay$c;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;

public final class FlowableReplay$c$a
implements g {
    private final SubscriberResourceWrapper a;
    public final /* synthetic */ FlowableReplay.c b;

    public FlowableReplay$c$a(FlowableReplay.c c10, SubscriberResourceWrapper subscriberResourceWrapper) {
        this.b = c10;
        this.a = subscriberResourceWrapper;
    }

    public void a(b b10) {
        this.a.setResource(b10);
    }
}

