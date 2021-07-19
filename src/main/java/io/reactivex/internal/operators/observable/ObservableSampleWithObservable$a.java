/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;

public final class ObservableSampleWithObservable$a
implements g0 {
    public final ObservableSampleWithObservable$SampleMainObserver a;

    public ObservableSampleWithObservable$a(ObservableSampleWithObservable$SampleMainObserver observableSampleWithObservable$SampleMainObserver) {
        this.a = observableSampleWithObservable$SampleMainObserver;
    }

    public void onComplete() {
        this.a.complete();
    }

    public void onError(Throwable throwable) {
        this.a.error(throwable);
    }

    public void onNext(Object object) {
        this.a.run();
    }

    public void onSubscribe(b b10) {
        this.a.setOther(b10);
    }
}

