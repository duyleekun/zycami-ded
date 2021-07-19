/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.e.m0;

public final class ObservableInternalHelper$c
implements o {
    private final o a;

    public ObservableInternalHelper$c(o o10) {
        this.a = o10;
    }

    public e0 a(Object object) {
        object = (Iterable)e.a.w0.b.a.g(this.a.apply(object), "The mapper returned a null Iterable");
        m0 m02 = new m0((Iterable)object);
        return m02;
    }
}

