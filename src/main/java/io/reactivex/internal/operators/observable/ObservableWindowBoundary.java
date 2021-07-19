/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary$WindowBoundaryMainObserver;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary$a;

public final class ObservableWindowBoundary
extends a {
    public final e0 b;
    public final int c;

    public ObservableWindowBoundary(e0 e02, e0 e03, int n10) {
        super(e02);
        this.b = e03;
        this.c = n10;
    }

    public void K5(g0 object) {
        int n10 = this.c;
        ObservableWindowBoundary$WindowBoundaryMainObserver observableWindowBoundary$WindowBoundaryMainObserver = new ObservableWindowBoundary$WindowBoundaryMainObserver((g0)object, n10);
        object.onSubscribe(observableWindowBoundary$WindowBoundaryMainObserver);
        object = this.b;
        ObservableWindowBoundary$a observableWindowBoundary$a = observableWindowBoundary$WindowBoundaryMainObserver.boundaryObserver;
        object.subscribe(observableWindowBoundary$a);
        this.a.subscribe(observableWindowBoundary$WindowBoundaryMainObserver);
    }
}

