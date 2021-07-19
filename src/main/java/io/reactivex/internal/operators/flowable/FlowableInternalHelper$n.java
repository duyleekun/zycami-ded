/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.u0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class FlowableInternalHelper$n
implements Callable {
    private final j a;
    private final long b;
    private final TimeUnit c;
    private final h0 d;

    public FlowableInternalHelper$n(j j10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = j10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public a a() {
        j j10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        return j10.s5(l10, timeUnit, h02);
    }
}

