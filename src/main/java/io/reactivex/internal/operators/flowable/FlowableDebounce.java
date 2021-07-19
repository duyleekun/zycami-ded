/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.e1.e;
import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber;

public final class FlowableDebounce
extends a {
    public final o c;

    public FlowableDebounce(j j10, o o10) {
        super(j10);
        this.c = o10;
    }

    public void m6(d object) {
        j j10 = this.b;
        e e10 = new e((d)object);
        object = this.c;
        FlowableDebounce$DebounceSubscriber flowableDebounce$DebounceSubscriber = new FlowableDebounce$DebounceSubscriber(e10, (o)object);
        j10.l6(flowableDebounce$DebounceSubscriber);
    }
}

