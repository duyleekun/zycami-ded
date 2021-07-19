/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutMainMaybeObserver;

public final class MaybeTimeoutPublisher
extends a {
    public final c b;
    public final w c;

    public MaybeTimeoutPublisher(w w10, c c10, w w11) {
        super(w10);
        this.b = c10;
        this.c = w11;
    }

    public void t1(t object) {
        Object object2 = this.c;
        MaybeTimeoutPublisher$TimeoutMainMaybeObserver maybeTimeoutPublisher$TimeoutMainMaybeObserver = new MaybeTimeoutPublisher$TimeoutMainMaybeObserver((t)object, (w)object2);
        object.onSubscribe(maybeTimeoutPublisher$TimeoutMainMaybeObserver);
        object = this.b;
        object2 = maybeTimeoutPublisher$TimeoutMainMaybeObserver.other;
        object.subscribe((d)object2);
        this.a.g(maybeTimeoutPublisher$TimeoutMainMaybeObserver);
    }
}

