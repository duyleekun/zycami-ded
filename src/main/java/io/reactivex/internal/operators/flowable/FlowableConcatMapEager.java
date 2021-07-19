/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber;
import io.reactivex.internal.util.ErrorMode;

public final class FlowableConcatMapEager
extends a {
    public final o c;
    public final int d;
    public final int e;
    public final ErrorMode f;

    public FlowableConcatMapEager(j j10, o o10, int n10, int n11, ErrorMode errorMode) {
        super(j10);
        this.c = o10;
        this.d = n10;
        this.e = n11;
        this.f = errorMode;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        int n10 = this.d;
        int n11 = this.e;
        ErrorMode errorMode = this.f;
        FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber = new FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(d10, o10, n10, n11, errorMode);
        j10.l6(flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber);
    }
}

