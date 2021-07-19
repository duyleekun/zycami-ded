/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutFallbackSubscriber;
import io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutSubscriber;

public final class FlowableTimeout
extends a {
    public final c c;
    public final o d;
    public final c e;

    public FlowableTimeout(j j10, c c10, o o10, c c11) {
        super(j10);
        this.c = c10;
        this.d = o10;
        this.e = c11;
    }

    public void m6(d object) {
        Object object2 = this.e;
        if (object2 == null) {
            o o10 = this.d;
            object2 = new FlowableTimeout$TimeoutSubscriber((d)object, o10);
            object.onSubscribe((e)object2);
            object = this.c;
            ((FlowableTimeout$TimeoutSubscriber)object2).startFirstTimeout((c)object);
            object = this.b;
            ((j)object).l6((e.a.o)object2);
        } else {
            o o11 = this.d;
            c c10 = this.e;
            object2 = new FlowableTimeout$TimeoutFallbackSubscriber((d)object, o11, c10);
            object.onSubscribe((e)object2);
            object = this.c;
            ((FlowableTimeout$TimeoutFallbackSubscriber)object2).startFirstTimeout((c)object);
            object = this.b;
            ((j)object).l6((e.a.o)object2);
        }
    }
}

