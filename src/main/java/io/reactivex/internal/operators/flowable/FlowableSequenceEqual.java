/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinator;

public final class FlowableSequenceEqual
extends j {
    public final c b;
    public final c c;
    public final e.a.v0.d d;
    public final int e;

    public FlowableSequenceEqual(c c10, c c11, e.a.v0.d d10, int n10) {
        this.b = c10;
        this.c = c11;
        this.d = d10;
        this.e = n10;
    }

    public void m6(d object) {
        int n10 = this.e;
        e.a.v0.d d10 = this.d;
        FlowableSequenceEqual$EqualCoordinator flowableSequenceEqual$EqualCoordinator = new FlowableSequenceEqual$EqualCoordinator((d)object, n10, d10);
        object.onSubscribe(flowableSequenceEqual$EqualCoordinator);
        object = this.b;
        c c10 = this.c;
        flowableSequenceEqual$EqualCoordinator.subscribe((c)object, c10);
    }
}

