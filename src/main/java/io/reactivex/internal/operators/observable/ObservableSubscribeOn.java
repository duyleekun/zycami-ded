/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn$a;

public final class ObservableSubscribeOn
extends a {
    public final h0 b;

    public ObservableSubscribeOn(e0 e02, h0 h02) {
        super(e02);
        this.b = h02;
    }

    public void K5(g0 object) {
        ObservableSubscribeOn$SubscribeOnObserver observableSubscribeOn$SubscribeOnObserver = new ObservableSubscribeOn$SubscribeOnObserver((g0)object);
        object.onSubscribe(observableSubscribeOn$SubscribeOnObserver);
        object = this.b;
        ObservableSubscribeOn$a observableSubscribeOn$a = new ObservableSubscribeOn$a(this, observableSubscribeOn$SubscribeOnObserver);
        object = ((h0)object).e(observableSubscribeOn$a);
        observableSubscribeOn$SubscribeOnObserver.setDisposable((b)object);
    }
}

