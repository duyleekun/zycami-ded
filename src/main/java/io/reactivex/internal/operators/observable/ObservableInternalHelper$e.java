/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.v0.c;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.e.e.x0;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$d;

public final class ObservableInternalHelper$e
implements o {
    private final c a;
    private final o b;

    public ObservableInternalHelper$e(c c10, o o10) {
        this.a = c10;
        this.b = o10;
    }

    public e0 a(Object object) {
        e0 e02 = (e0)e.a.w0.b.a.g(this.b.apply(object), "The mapper returned a null ObservableSource");
        c c10 = this.a;
        ObservableInternalHelper$d observableInternalHelper$d = new ObservableInternalHelper$d(c10, object);
        x0 x02 = new x0(e02, observableInternalHelper$d);
        return x02;
    }
}

