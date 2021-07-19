/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.x0.b;
import io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver;
import io.reactivex.internal.operators.observable.ObservableGroupBy$State;

public final class ObservableGroupBy$a
extends b {
    public final ObservableGroupBy$State b;

    public ObservableGroupBy$a(Object object, ObservableGroupBy$State observableGroupBy$State) {
        super(object);
        this.b = observableGroupBy$State;
    }

    public static ObservableGroupBy$a i8(Object object, int n10, ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver, boolean bl2) {
        ObservableGroupBy$State observableGroupBy$State = new ObservableGroupBy$State(n10, observableGroupBy$GroupByObserver, object, bl2);
        ObservableGroupBy$a observableGroupBy$a = new ObservableGroupBy$a(object, observableGroupBy$State);
        return observableGroupBy$a;
    }

    public void K5(g0 g02) {
        this.b.subscribe(g02);
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        this.b.onNext(object);
    }
}

