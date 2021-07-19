/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.c1.d;
import e.a.h0;
import e.a.v0.o;
import java.util.concurrent.TimeUnit;

public final class Functions$g0
implements o {
    public final TimeUnit a;
    public final h0 b;

    public Functions$g0(TimeUnit timeUnit, h0 h02) {
        this.a = timeUnit;
        this.b = h02;
    }

    public d a(Object object) {
        h0 h02 = this.b;
        TimeUnit timeUnit = this.a;
        long l10 = h02.d(timeUnit);
        TimeUnit timeUnit2 = this.a;
        d d10 = new d(object, l10, timeUnit2);
        return d10;
    }
}

