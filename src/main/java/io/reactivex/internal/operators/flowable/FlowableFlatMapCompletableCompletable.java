/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.d;
import e.a.j;
import e.a.v0.o;
import e.a.w0.c.b;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber;

public final class FlowableFlatMapCompletableCompletable
extends e.a.a
implements b {
    public final j a;
    public final o b;
    public final int c;
    public final boolean d;

    public FlowableFlatMapCompletableCompletable(j j10, o o10, boolean bl2, int n10) {
        this.a = j10;
        this.b = o10;
        this.d = bl2;
        this.c = n10;
    }

    public void L0(d d10) {
        j j10 = this.a;
        o o10 = this.b;
        boolean bl2 = this.d;
        int n10 = this.c;
        FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber flowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber = new FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber(d10, o10, bl2, n10);
        j10.l6(flowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber);
    }

    public j l() {
        j j10 = this.a;
        o o10 = this.b;
        boolean bl2 = this.d;
        int n10 = this.c;
        FlowableFlatMapCompletable flowableFlatMapCompletable = new FlowableFlatMapCompletable(j10, o10, bl2, n10);
        return e.a.a1.a.P(flowableFlatMapCompletable);
    }
}

