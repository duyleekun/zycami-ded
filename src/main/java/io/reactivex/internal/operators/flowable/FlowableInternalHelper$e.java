/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.b.q0;
import i.g.c;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$d;

public final class FlowableInternalHelper$e
implements o {
    private final e.a.v0.c a;
    private final o b;

    public FlowableInternalHelper$e(e.a.v0.c c10, o o10) {
        this.a = c10;
        this.b = o10;
    }

    public c a(Object object) {
        c c10 = (c)e.a.w0.b.a.g(this.b.apply(object), "The mapper returned a null Publisher");
        e.a.v0.c c11 = this.a;
        FlowableInternalHelper$d flowableInternalHelper$d = new FlowableInternalHelper$d(c11, object);
        q0 q02 = new q0(c10, flowableInternalHelper$d);
        return q02;
    }
}

