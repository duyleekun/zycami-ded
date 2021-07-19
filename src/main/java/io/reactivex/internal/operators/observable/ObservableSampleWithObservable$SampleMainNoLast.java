/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver;

public final class ObservableSampleWithObservable$SampleMainNoLast
extends ObservableSampleWithObservable$SampleMainObserver {
    private static final long serialVersionUID = -3029755663834015785L;

    public ObservableSampleWithObservable$SampleMainNoLast(g0 g02, e0 e02) {
        super(g02, e02);
    }

    public void completion() {
        this.downstream.onComplete();
    }

    public void run() {
        this.emit();
    }
}

