/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver;

public final class MaybeUnsubscribeOn
extends a {
    public final h0 b;

    public MaybeUnsubscribeOn(w w10, h0 h02) {
        super(w10);
        this.b = h02;
    }

    public void t1(t t10) {
        w w10 = this.a;
        h0 h02 = this.b;
        MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver maybeUnsubscribeOn$UnsubscribeOnMaybeObserver = new MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(t10, h02);
        w10.g(maybeUnsubscribeOn$UnsubscribeOnMaybeObserver);
    }
}

