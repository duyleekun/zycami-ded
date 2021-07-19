/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromObserver;

public final class ObservableWithLatestFrom$a
implements g0 {
    private final ObservableWithLatestFrom$WithLatestFromObserver a;
    public final /* synthetic */ ObservableWithLatestFrom b;

    public ObservableWithLatestFrom$a(ObservableWithLatestFrom observableWithLatestFrom, ObservableWithLatestFrom$WithLatestFromObserver observableWithLatestFrom$WithLatestFromObserver) {
        this.b = observableWithLatestFrom;
        this.a = observableWithLatestFrom$WithLatestFromObserver;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.a.otherError(throwable);
    }

    public void onNext(Object object) {
        this.a.lazySet(object);
    }

    public void onSubscribe(b b10) {
        this.a.setOther(b10);
    }
}

