/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeOnMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn$a;

public final class MaybeSubscribeOn
extends a {
    public final h0 b;

    public MaybeSubscribeOn(w w10, h0 h02) {
        super(w10);
        this.b = h02;
    }

    public void t1(t object) {
        b b10 = new MaybeSubscribeOn$SubscribeOnMaybeObserver((t)object);
        object.onSubscribe(b10);
        object = b10.task;
        h0 h02 = this.b;
        w w10 = this.a;
        MaybeSubscribeOn$a maybeSubscribeOn$a = new MaybeSubscribeOn$a((t)((Object)b10), w10);
        b10 = h02.e(maybeSubscribeOn$a);
        ((SequentialDisposable)object).replace(b10);
    }
}

