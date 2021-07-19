/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.w;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeConcatArray$ConcatMaybeObserver;

public final class MaybeConcatArray
extends j {
    public final w[] b;

    public MaybeConcatArray(w[] wArray) {
        this.b = wArray;
    }

    public void m6(d d10) {
        w[] wArray = this.b;
        MaybeConcatArray$ConcatMaybeObserver maybeConcatArray$ConcatMaybeObserver = new MaybeConcatArray$ConcatMaybeObserver(d10, wArray);
        d10.onSubscribe(maybeConcatArray$ConcatMaybeObserver);
        maybeConcatArray$ConcatMaybeObserver.drain();
    }
}

