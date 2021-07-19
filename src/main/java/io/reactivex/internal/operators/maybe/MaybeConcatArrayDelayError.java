/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.w;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError$ConcatMaybeObserver;

public final class MaybeConcatArrayDelayError
extends j {
    public final w[] b;

    public MaybeConcatArrayDelayError(w[] wArray) {
        this.b = wArray;
    }

    public void m6(d d10) {
        w[] wArray = this.b;
        MaybeConcatArrayDelayError$ConcatMaybeObserver maybeConcatArrayDelayError$ConcatMaybeObserver = new MaybeConcatArrayDelayError$ConcatMaybeObserver(d10, wArray);
        d10.onSubscribe(maybeConcatArrayDelayError$ConcatMaybeObserver);
        maybeConcatArrayDelayError$ConcatMaybeObserver.drain();
    }
}

