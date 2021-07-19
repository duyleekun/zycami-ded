/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.o0;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle$ConcatWithObserver;

public final class ObservableConcatWithSingle
extends a {
    public final o0 b;

    public ObservableConcatWithSingle(z z10, o0 o02) {
        super(z10);
        this.b = o02;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o0 o02 = this.b;
        ObservableConcatWithSingle$ConcatWithObserver observableConcatWithSingle$ConcatWithObserver = new ObservableConcatWithSingle$ConcatWithObserver(g02, o02);
        e02.subscribe(observableConcatWithSingle$ConcatWithObserver);
    }
}

