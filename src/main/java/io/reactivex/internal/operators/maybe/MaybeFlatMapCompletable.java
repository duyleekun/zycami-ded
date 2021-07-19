/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a;
import e.a.d;
import e.a.v0.o;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable$FlatMapCompletableObserver;

public final class MaybeFlatMapCompletable
extends a {
    public final w a;
    public final o b;

    public MaybeFlatMapCompletable(w w10, o o10) {
        this.a = w10;
        this.b = o10;
    }

    public void L0(d d10) {
        o o10 = this.b;
        MaybeFlatMapCompletable$FlatMapCompletableObserver maybeFlatMapCompletable$FlatMapCompletableObserver = new MaybeFlatMapCompletable$FlatMapCompletableObserver(d10, o10);
        d10.onSubscribe(maybeFlatMapCompletable$FlatMapCompletableObserver);
        this.a.g(maybeFlatMapCompletable$FlatMapCompletableObserver);
    }
}

