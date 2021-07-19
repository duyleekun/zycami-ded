/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.c;
import e.a.v0.o;

public final class FlowableInternalHelper$d
implements o {
    private final c a;
    private final Object b;

    public FlowableInternalHelper$d(c c10, Object object) {
        this.a = c10;
        this.b = object;
    }

    public Object apply(Object object) {
        c c10 = this.a;
        Object object2 = this.b;
        return c10.apply(object2, object);
    }
}

