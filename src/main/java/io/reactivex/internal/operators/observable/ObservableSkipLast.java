/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableSkipLast$SkipLastObserver;

public final class ObservableSkipLast
extends a {
    public final int b;

    public ObservableSkipLast(e0 e02, int n10) {
        super(e02);
        this.b = n10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        int n10 = this.b;
        ObservableSkipLast$SkipLastObserver observableSkipLast$SkipLastObserver = new ObservableSkipLast$SkipLastObserver(g02, n10);
        e02.subscribe(observableSkipLast$SkipLastObserver);
    }
}

