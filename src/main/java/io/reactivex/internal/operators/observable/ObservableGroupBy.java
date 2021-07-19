/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver;

public final class ObservableGroupBy
extends a {
    public final o b;
    public final o c;
    public final int d;
    public final boolean e;

    public ObservableGroupBy(e0 e02, o o10, o o11, int n10, boolean bl2) {
        super(e02);
        this.b = o10;
        this.c = o11;
        this.d = n10;
        this.e = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o o10 = this.b;
        o o11 = this.c;
        int n10 = this.d;
        boolean bl2 = this.e;
        ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver = new ObservableGroupBy$GroupByObserver(g02, o10, o11, n10, bl2);
        e02.subscribe(observableGroupBy$GroupByObserver);
    }
}

