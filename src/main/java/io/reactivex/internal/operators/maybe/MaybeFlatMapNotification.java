/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification$FlatMapMaybeObserver;
import java.util.concurrent.Callable;

public final class MaybeFlatMapNotification
extends a {
    public final o b;
    public final o c;
    public final Callable d;

    public MaybeFlatMapNotification(w w10, o o10, o o11, Callable callable) {
        super(w10);
        this.b = o10;
        this.c = o11;
        this.d = callable;
    }

    public void t1(t t10) {
        w w10 = this.a;
        o o10 = this.b;
        o o11 = this.c;
        Callable callable = this.d;
        MaybeFlatMapNotification$FlatMapMaybeObserver maybeFlatMapNotification$FlatMapMaybeObserver = new MaybeFlatMapNotification$FlatMapMaybeObserver(t10, o10, o11, callable);
        w10.g(maybeFlatMapNotification$FlatMapMaybeObserver);
    }
}

