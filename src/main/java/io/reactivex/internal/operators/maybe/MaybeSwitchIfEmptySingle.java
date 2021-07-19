/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.w;
import e.a.w0.c.f;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver;

public final class MaybeSwitchIfEmptySingle
extends i0
implements f {
    public final w a;
    public final o0 b;

    public MaybeSwitchIfEmptySingle(w w10, o0 o02) {
        this.a = w10;
        this.b = o02;
    }

    public void e1(l0 l02) {
        w w10 = this.a;
        o0 o02 = this.b;
        MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver maybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver = new MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(l02, o02);
        w10.g(maybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver);
    }

    public w source() {
        return this.a;
    }
}

