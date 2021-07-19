/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle$FlatMapSingleSubscriber;

public final class FlowableFlatMapSingle
extends a {
    public final o c;
    public final boolean d;
    public final int e;

    public FlowableFlatMapSingle(j j10, o o10, boolean bl2, int n10) {
        super(j10);
        this.c = o10;
        this.d = bl2;
        this.e = n10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        boolean bl2 = this.d;
        int n10 = this.e;
        FlowableFlatMapSingle$FlatMapSingleSubscriber flowableFlatMapSingle$FlatMapSingleSubscriber = new FlowableFlatMapSingle$FlatMapSingleSubscriber(d10, o10, bl2, n10);
        j10.l6(flowableFlatMapSingle$FlatMapSingleSubscriber);
    }
}

