/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.h0;
import io.reactivex.internal.operators.completable.CompletableObserveOn$ObserveOnCompletableObserver;

public final class CompletableObserveOn
extends a {
    public final g a;
    public final h0 b;

    public CompletableObserveOn(g g10, h0 h02) {
        this.a = g10;
        this.b = h02;
    }

    public void L0(d d10) {
        g g10 = this.a;
        h0 h02 = this.b;
        CompletableObserveOn$ObserveOnCompletableObserver completableObserveOn$ObserveOnCompletableObserver = new CompletableObserveOn$ObserveOnCompletableObserver(d10, h02);
        g10.f(completableObserveOn$ObserveOnCompletableObserver);
    }
}

