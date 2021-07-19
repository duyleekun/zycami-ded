/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver;

public final class MaybeSwitchIfEmpty
extends a {
    public final w b;

    public MaybeSwitchIfEmpty(w w10, w w11) {
        super(w10);
        this.b = w11;
    }

    public void t1(t t10) {
        w w10 = this.a;
        w w11 = this.b;
        MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver maybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver = new MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(t10, w11);
        w10.g(maybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver);
    }
}

