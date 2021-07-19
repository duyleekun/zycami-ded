/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;

public final class FlowableInternalHelper$c
implements o {
    private final o a;

    public FlowableInternalHelper$c(o o10) {
        this.a = o10;
    }

    public c a(Object object) {
        object = (Iterable)e.a.w0.b.a.g(this.a.apply(object), "The mapper returned a null Iterable");
        FlowableFromIterable flowableFromIterable = new FlowableFromIterable((Iterable)object);
        return flowableFromIterable;
    }
}

