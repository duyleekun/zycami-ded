/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import i.g.c;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver;

public final class MaybeTakeUntilPublisher
extends a {
    public final c b;

    public MaybeTakeUntilPublisher(w w10, c c10) {
        super(w10);
        this.b = c10;
    }

    public void t1(t object) {
        MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver maybeTakeUntilPublisher$TakeUntilMainMaybeObserver = new MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver((t)object);
        object.onSubscribe(maybeTakeUntilPublisher$TakeUntilMainMaybeObserver);
        object = this.b;
        MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver maybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver = maybeTakeUntilPublisher$TakeUntilMainMaybeObserver.other;
        object.subscribe(maybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver);
        this.a.g(maybeTakeUntilPublisher$TakeUntilMainMaybeObserver);
    }
}

