/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.e.e.a;
import e.a.y0.l;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromObserver;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom$a;

public final class ObservableWithLatestFrom
extends a {
    public final c b;
    public final e0 c;

    public ObservableWithLatestFrom(e0 e02, c c10, e0 e03) {
        super(e02);
        this.b = c10;
        this.c = e03;
    }

    public void K5(g0 g02) {
        Object object = new l(g02);
        Object object2 = this.b;
        g02 = new ObservableWithLatestFrom$WithLatestFromObserver((g0)object, (c)object2);
        ((l)object).onSubscribe((b)((Object)g02));
        object = this.c;
        object2 = new ObservableWithLatestFrom$a(this, (ObservableWithLatestFrom$WithLatestFromObserver)g02);
        object.subscribe((g0)object2);
        this.a.subscribe(g02);
    }
}

