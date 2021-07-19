/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe$TimeoutMainMaybeObserver;

public final class MaybeTimeoutMaybe
extends a {
    public final w b;
    public final w c;

    public MaybeTimeoutMaybe(w w10, w w11, w w12) {
        super(w10);
        this.b = w11;
        this.c = w12;
    }

    public void t1(t object) {
        Object object2 = this.c;
        MaybeTimeoutMaybe$TimeoutMainMaybeObserver maybeTimeoutMaybe$TimeoutMainMaybeObserver = new MaybeTimeoutMaybe$TimeoutMainMaybeObserver((t)object, (w)object2);
        object.onSubscribe(maybeTimeoutMaybe$TimeoutMainMaybeObserver);
        object = this.b;
        object2 = maybeTimeoutMaybe$TimeoutMainMaybeObserver.other;
        object.g((t)object2);
        this.a.g(maybeTimeoutMaybe$TimeoutMainMaybeObserver);
    }
}

