/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.w0;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber;

public final class FlowableSwitchMap
extends a {
    public final o c;
    public final int d;
    public final boolean e;

    public FlowableSwitchMap(j j10, o o10, int n10, boolean bl2) {
        super(j10);
        this.c = o10;
        this.d = n10;
        this.e = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        Object object = this.c;
        boolean bl2 = w0.b(j10, d10, (o)object);
        if (bl2) {
            return;
        }
        j10 = this.b;
        o o10 = this.c;
        int n10 = this.d;
        boolean bl3 = this.e;
        object = new FlowableSwitchMap$SwitchMapSubscriber(d10, o10, n10, bl3);
        j10.l6((e.a.o)object);
    }
}

