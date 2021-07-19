/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$WithLatestFromSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$a;

public final class FlowableWithLatestFrom
extends a {
    public final e.a.v0.c c;
    public final c d;

    public FlowableWithLatestFrom(j j10, e.a.v0.c c10, c c11) {
        super(j10);
        this.c = c10;
        this.d = c11;
    }

    public void m6(d d10) {
        Object object = new e.a.e1.e(d10);
        Object object2 = this.c;
        d10 = new FlowableWithLatestFrom$WithLatestFromSubscriber((d)object, (e.a.v0.c)object2);
        ((e.a.e1.e)object).onSubscribe((e)((Object)d10));
        object = this.d;
        object2 = new FlowableWithLatestFrom$a(this, (FlowableWithLatestFrom$WithLatestFromSubscriber)d10);
        object.subscribe((d)object2);
        this.b.l6((o)d10);
    }
}

