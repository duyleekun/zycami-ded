/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver;

public final class ObservableUnsubscribeOn
extends a {
    public final h0 b;

    public ObservableUnsubscribeOn(e0 e02, h0 h02) {
        super(e02);
        this.b = h02;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        h0 h02 = this.b;
        ObservableUnsubscribeOn$UnsubscribeObserver observableUnsubscribeOn$UnsubscribeObserver = new ObservableUnsubscribeOn$UnsubscribeObserver(g02, h02);
        e02.subscribe(observableUnsubscribeOn$UnsubscribeObserver);
    }
}

