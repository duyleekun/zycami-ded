/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryMainObserver;
import java.util.concurrent.Callable;

public final class ObservableWindowBoundarySupplier
extends a {
    public final Callable b;
    public final int c;

    public ObservableWindowBoundarySupplier(e0 e02, Callable callable, int n10) {
        super(e02);
        this.b = callable;
        this.c = n10;
    }

    public void K5(g0 g02) {
        int n10 = this.c;
        Callable callable = this.b;
        ObservableWindowBoundarySupplier$WindowBoundaryMainObserver observableWindowBoundarySupplier$WindowBoundaryMainObserver = new ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(g02, n10, callable);
        this.a.subscribe(observableWindowBoundarySupplier$WindowBoundaryMainObserver);
    }
}

