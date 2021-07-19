/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.v0.g;

public final class ObservableInternalHelper$h
implements g {
    public final g0 a;

    public ObservableInternalHelper$h(g0 g02) {
        this.a = g02;
    }

    public void a(Throwable throwable) {
        this.a.onError(throwable);
    }
}

