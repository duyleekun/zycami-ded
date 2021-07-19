/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.y0.d;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary$WindowBoundaryMainObserver;

public final class ObservableWindowBoundary$a
extends d {
    public final ObservableWindowBoundary$WindowBoundaryMainObserver b;
    public boolean c;

    public ObservableWindowBoundary$a(ObservableWindowBoundary$WindowBoundaryMainObserver observableWindowBoundary$WindowBoundaryMainObserver) {
        this.b = observableWindowBoundary$WindowBoundaryMainObserver;
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
        this.b.innerNext();
    }
}

