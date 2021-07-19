/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber;

public final class FlowableTakeUntil
extends a {
    public final c c;

    public FlowableTakeUntil(j j10, c c10) {
        super(j10);
        this.c = c10;
    }

    public void m6(d object) {
        FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = new FlowableTakeUntil$TakeUntilMainSubscriber((d)object);
        object.onSubscribe(flowableTakeUntil$TakeUntilMainSubscriber);
        object = this.c;
        FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber flowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber = flowableTakeUntil$TakeUntilMainSubscriber.other;
        object.subscribe(flowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber);
        this.b.l6(flowableTakeUntil$TakeUntilMainSubscriber);
    }
}

