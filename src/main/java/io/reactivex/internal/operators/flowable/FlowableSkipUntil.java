/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber;

public final class FlowableSkipUntil
extends a {
    public final c c;

    public FlowableSkipUntil(j j10, c c10) {
        super(j10);
        this.c = c10;
    }

    public void m6(d object) {
        FlowableSkipUntil$SkipUntilMainSubscriber flowableSkipUntil$SkipUntilMainSubscriber = new FlowableSkipUntil$SkipUntilMainSubscriber((d)object);
        object.onSubscribe(flowableSkipUntil$SkipUntilMainSubscriber);
        object = this.c;
        FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber flowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber = flowableSkipUntil$SkipUntilMainSubscriber.other;
        object.subscribe(flowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber);
        this.b.l6(flowableSkipUntil$SkipUntilMainSubscriber);
    }
}

