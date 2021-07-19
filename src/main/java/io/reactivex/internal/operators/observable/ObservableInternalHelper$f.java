/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.e.q1;
import io.reactivex.internal.functions.Functions;

public final class ObservableInternalHelper$f
implements o {
    public final o a;

    public ObservableInternalHelper$f(o o10) {
        this.a = o10;
    }

    public e0 a(Object object) {
        Object object2 = (e0)e.a.w0.b.a.g(this.a.apply(object), "The itemDelay returned a null ObservableSource");
        q1 q12 = new q1((e0)object2, 1L);
        object2 = Functions.n(object);
        return q12.H3((o)object2).C1(object);
    }
}

