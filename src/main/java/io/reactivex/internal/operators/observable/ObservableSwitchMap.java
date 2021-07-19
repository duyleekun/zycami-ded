/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver;

public final class ObservableSwitchMap
extends a {
    public final o b;
    public final int c;
    public final boolean d;

    public ObservableSwitchMap(e0 e02, o o10, int n10, boolean bl2) {
        super(e02);
        this.b = o10;
        this.c = n10;
        this.d = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        Object object = this.b;
        boolean bl2 = ObservableScalarXMap.b(e02, g02, (o)object);
        if (bl2) {
            return;
        }
        e02 = this.a;
        o o10 = this.b;
        int n10 = this.c;
        boolean bl3 = this.d;
        object = new ObservableSwitchMap$SwitchMapObserver(g02, o10, n10, bl3);
        e02.subscribe((g0)object);
    }
}

