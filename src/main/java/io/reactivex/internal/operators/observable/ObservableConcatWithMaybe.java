/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe$ConcatWithObserver;

public final class ObservableConcatWithMaybe
extends a {
    public final w b;

    public ObservableConcatWithMaybe(z z10, w w10) {
        super(z10);
        this.b = w10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        w w10 = this.b;
        ObservableConcatWithMaybe$ConcatWithObserver observableConcatWithMaybe$ConcatWithObserver = new ObservableConcatWithMaybe$ConcatWithObserver(g02, w10);
        e02.subscribe(observableConcatWithMaybe$ConcatWithObserver);
    }
}

