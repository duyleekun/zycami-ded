/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable$SourceObserver;

public final class CompletableAndThenCompletable
extends a {
    public final g a;
    public final g b;

    public CompletableAndThenCompletable(g g10, g g11) {
        this.a = g10;
        this.b = g11;
    }

    public void L0(d d10) {
        g g10 = this.a;
        g g11 = this.b;
        CompletableAndThenCompletable$SourceObserver completableAndThenCompletable$SourceObserver = new CompletableAndThenCompletable$SourceObserver(d10, g11);
        g10.f(completableAndThenCompletable$SourceObserver);
    }
}

