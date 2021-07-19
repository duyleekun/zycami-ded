/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.y0.d;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryMainObserver;

public final class ObservableWindowBoundarySupplier$a
extends d {
    public final ObservableWindowBoundarySupplier$WindowBoundaryMainObserver b;
    public boolean c;

    public ObservableWindowBoundarySupplier$a(ObservableWindowBoundarySupplier$WindowBoundaryMainObserver observableWindowBoundarySupplier$WindowBoundaryMainObserver) {
        this.b = observableWindowBoundarySupplier$WindowBoundaryMainObserver;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.b.innerComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.b.innerError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.dispose();
        this.b.innerNext(this);
    }
}

