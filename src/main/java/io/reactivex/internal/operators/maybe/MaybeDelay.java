/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeDelay$DelayMaybeObserver;
import java.util.concurrent.TimeUnit;

public final class MaybeDelay
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;

    public MaybeDelay(w w10, long l10, TimeUnit timeUnit, h0 h02) {
        super(w10);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public void t1(t t10) {
        w w10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        MaybeDelay$DelayMaybeObserver maybeDelay$DelayMaybeObserver = new MaybeDelay$DelayMaybeObserver(t10, l10, timeUnit, h02);
        w10.g(maybeDelay$DelayMaybeObserver);
    }
}

