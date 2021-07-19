/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.b.e1;
import i.g.c;
import io.reactivex.internal.functions.Functions;

public final class FlowableInternalHelper$f
implements o {
    public final o a;

    public FlowableInternalHelper$f(o o10) {
        this.a = o10;
    }

    public c a(Object object) {
        Object object2 = (c)e.a.w0.b.a.g(this.a.apply(object), "The itemDelay returned a null Publisher");
        e1 e12 = new e1((c)object2, 1L);
        object2 = Functions.n(object);
        return e12.R3((o)object2).H1(object);
    }
}

