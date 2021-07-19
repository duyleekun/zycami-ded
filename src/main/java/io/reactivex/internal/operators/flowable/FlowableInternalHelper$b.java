/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.u0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class FlowableInternalHelper$b
implements Callable {
    private final j a;
    private final int b;
    private final long c;
    private final TimeUnit d;
    private final h0 e;

    public FlowableInternalHelper$b(j j10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = j10;
        this.b = n10;
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
    }

    public a a() {
        j j10 = this.a;
        int n10 = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        h0 h02 = this.e;
        return j10.p5(n10, l10, timeUnit, h02);
    }
}

