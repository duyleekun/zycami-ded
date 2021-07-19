/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber;
import io.reactivex.internal.operators.flowable.FlowableJoin$JoinSubscription;

public final class FlowableJoin
extends a {
    public final c c;
    public final o d;
    public final o e;
    public final e.a.v0.c f;

    public FlowableJoin(j j10, c c10, o o10, o o11, e.a.v0.c c11) {
        super(j10);
        this.c = c10;
        this.d = o10;
        this.e = o11;
        this.f = c11;
    }

    public void m6(d d10) {
        Object object = this.d;
        o o10 = this.e;
        e.a.v0.c c10 = this.f;
        FlowableJoin$JoinSubscription flowableJoin$JoinSubscription = new FlowableJoin$JoinSubscription(d10, (o)object, o10, c10);
        d10.onSubscribe(flowableJoin$JoinSubscription);
        d10 = new FlowableGroupJoin$LeftRightSubscriber(flowableJoin$JoinSubscription, true);
        flowableJoin$JoinSubscription.disposables.b((b)((Object)d10));
        object = new FlowableGroupJoin$LeftRightSubscriber(flowableJoin$JoinSubscription, false);
        flowableJoin$JoinSubscription.disposables.b((b)object);
        this.b.l6((e.a.o)d10);
        this.c.subscribe((d)object);
    }
}

