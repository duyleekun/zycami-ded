/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver;

public final class MaybeTakeUntilMaybe
extends a {
    public final w b;

    public MaybeTakeUntilMaybe(w w10, w w11) {
        super(w10);
        this.b = w11;
    }

    public void t1(t object) {
        MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver maybeTakeUntilMaybe$TakeUntilMainMaybeObserver = new MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver((t)object);
        object.onSubscribe(maybeTakeUntilMaybe$TakeUntilMainMaybeObserver);
        object = this.b;
        MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver maybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver = maybeTakeUntilMaybe$TakeUntilMainMaybeObserver.other;
        object.g(maybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver);
        this.a.g(maybeTakeUntilMaybe$TakeUntilMainMaybeObserver);
    }
}

