/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.v0.d;
import e.a.w0.c.b;
import i.g.c;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle$EqualCoordinator;

public final class FlowableSequenceEqualSingle
extends i0
implements b {
    public final c a;
    public final c b;
    public final d c;
    public final int d;

    public FlowableSequenceEqualSingle(c c10, c c11, d d10, int n10) {
        this.a = c10;
        this.b = c11;
        this.c = d10;
        this.d = n10;
    }

    public void e1(l0 object) {
        int n10 = this.d;
        d d10 = this.c;
        FlowableSequenceEqualSingle$EqualCoordinator flowableSequenceEqualSingle$EqualCoordinator = new FlowableSequenceEqualSingle$EqualCoordinator((l0)object, n10, d10);
        object.onSubscribe(flowableSequenceEqualSingle$EqualCoordinator);
        object = this.a;
        c c10 = this.b;
        flowableSequenceEqualSingle$EqualCoordinator.subscribe((c)object, c10);
    }

    public j l() {
        c c10 = this.a;
        c c11 = this.b;
        d d10 = this.c;
        int n10 = this.d;
        FlowableSequenceEqual flowableSequenceEqual = new FlowableSequenceEqual(c10, c11, d10, n10);
        return e.a.a1.a.P(flowableSequenceEqual);
    }
}

