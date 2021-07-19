/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableFlatMap$MergeObserver;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

public final class ObservableFlatMap
extends a {
    public final o b;
    public final boolean c;
    public final int d;
    public final int e;

    public ObservableFlatMap(e0 e02, o o10, boolean bl2, int n10, int n11) {
        super(e02);
        this.b = o10;
        this.c = bl2;
        this.d = n10;
        this.e = n11;
    }

    public void K5(g0 g02) {
        ObservableFlatMap$MergeObserver observableFlatMap$MergeObserver;
        e0 e02 = this.a;
        Object object = this.b;
        boolean bl2 = ObservableScalarXMap.b(e02, g02, (o)object);
        if (bl2) {
            return;
        }
        e02 = this.a;
        o o10 = this.b;
        boolean bl3 = this.c;
        int n10 = this.d;
        int n11 = this.e;
        object = observableFlatMap$MergeObserver;
        observableFlatMap$MergeObserver = new ObservableFlatMap$MergeObserver(g02, o10, bl3, n10, n11);
        e02.subscribe(observableFlatMap$MergeObserver);
    }
}

