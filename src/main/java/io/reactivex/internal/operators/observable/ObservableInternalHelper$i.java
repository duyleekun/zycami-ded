/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.v0.g;

public final class ObservableInternalHelper$i
implements g {
    public final g0 a;

    public ObservableInternalHelper$i(g0 g02) {
        this.a = g02;
    }

    public void accept(Object object) {
        this.a.onNext(object);
    }
}

