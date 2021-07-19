/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.w0;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber;

public final class FlowableFlatMap
extends a {
    public final o c;
    public final boolean d;
    public final int e;
    public final int f;

    public FlowableFlatMap(j j10, o o10, boolean bl2, int n10, int n11) {
        super(j10);
        this.c = o10;
        this.d = bl2;
        this.e = n10;
        this.f = n11;
    }

    public static e.a.o K8(d d10, o o10, boolean bl2, int n10, int n11) {
        FlowableFlatMap$MergeSubscriber flowableFlatMap$MergeSubscriber = new FlowableFlatMap$MergeSubscriber(d10, o10, bl2, n10, n11);
        return flowableFlatMap$MergeSubscriber;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        boolean bl2 = w0.b(j10, d10, o10);
        if (bl2) {
            return;
        }
        j10 = this.b;
        o10 = this.c;
        boolean bl3 = this.d;
        int n10 = this.e;
        int n11 = this.f;
        d10 = FlowableFlatMap.K8(d10, o10, bl3, n10, n11);
        j10.l6((e.a.o)d10);
    }
}

