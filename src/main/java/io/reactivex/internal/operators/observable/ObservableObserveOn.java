/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.w0.g.l;
import io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver;

public final class ObservableObserveOn
extends a {
    public final h0 b;
    public final boolean c;
    public final int d;

    public ObservableObserveOn(e0 e02, h0 h02, boolean bl2, int n10) {
        super(e02);
        this.b = h02;
        this.c = bl2;
        this.d = n10;
    }

    public void K5(g0 g02) {
        Object object = this.b;
        boolean bl2 = object instanceof l;
        if (bl2) {
            object = this.a;
            object.subscribe(g02);
        } else {
            object = ((h0)object).c();
            e0 e02 = this.a;
            boolean bl3 = this.c;
            int n10 = this.d;
            ObservableObserveOn$ObserveOnObserver observableObserveOn$ObserveOnObserver = new ObservableObserveOn$ObserveOnObserver(g02, (h0$c)object, bl3, n10);
            e02.subscribe(observableObserveOn$ObserveOnObserver);
        }
    }
}

