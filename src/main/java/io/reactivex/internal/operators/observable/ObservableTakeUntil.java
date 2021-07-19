/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver;
import io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver$OtherObserver;

public final class ObservableTakeUntil
extends a {
    public final e0 b;

    public ObservableTakeUntil(e0 e02, e0 e03) {
        super(e02);
        this.b = e03;
    }

    public void K5(g0 object) {
        ObservableTakeUntil$TakeUntilMainObserver observableTakeUntil$TakeUntilMainObserver = new ObservableTakeUntil$TakeUntilMainObserver((g0)object);
        object.onSubscribe(observableTakeUntil$TakeUntilMainObserver);
        object = this.b;
        ObservableTakeUntil$TakeUntilMainObserver$OtherObserver observableTakeUntil$TakeUntilMainObserver$OtherObserver = observableTakeUntil$TakeUntilMainObserver.otherObserver;
        object.subscribe(observableTakeUntil$TakeUntilMainObserver$OtherObserver);
        this.a.subscribe(observableTakeUntil$TakeUntilMainObserver);
    }
}

