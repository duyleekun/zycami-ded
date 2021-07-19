/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable$ConcatWithObserver;

public final class ObservableConcatWithCompletable
extends a {
    public final g b;

    public ObservableConcatWithCompletable(z z10, g g10) {
        super(z10);
        this.b = g10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        g g10 = this.b;
        ObservableConcatWithCompletable$ConcatWithObserver observableConcatWithCompletable$ConcatWithObserver = new ObservableConcatWithCompletable$ConcatWithObserver(g02, g10);
        e02.subscribe(observableConcatWithCompletable$ConcatWithObserver);
    }
}

