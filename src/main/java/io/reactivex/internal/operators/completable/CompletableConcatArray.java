/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import io.reactivex.internal.operators.completable.CompletableConcatArray$ConcatInnerObserver;

public final class CompletableConcatArray
extends a {
    public final g[] a;

    public CompletableConcatArray(g[] gArray) {
        this.a = gArray;
    }

    public void L0(d d10) {
        Object object = this.a;
        CompletableConcatArray$ConcatInnerObserver completableConcatArray$ConcatInnerObserver = new CompletableConcatArray$ConcatInnerObserver(d10, (g[])object);
        object = completableConcatArray$ConcatInnerObserver.sd;
        d10.onSubscribe((b)object);
        completableConcatArray$ConcatInnerObserver.next();
    }
}

