/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed$TakeLastTimedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableTakeLastTimed
extends a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final int f;
    public final boolean g;

    public ObservableTakeLastTimed(e0 e02, long l10, long l11, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = l11;
        this.d = timeUnit;
        this.e = h02;
        this.f = n10;
        this.g = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        long l10 = this.b;
        long l11 = this.c;
        TimeUnit timeUnit = this.d;
        h0 h02 = this.e;
        int n10 = this.f;
        boolean bl2 = this.g;
        ObservableTakeLastTimed$TakeLastTimedObserver observableTakeLastTimed$TakeLastTimedObserver = new ObservableTakeLastTimed$TakeLastTimedObserver(g02, l10, l11, timeUnit, h02, n10, bl2);
        e02.subscribe(observableTakeLastTimed$TakeLastTimedObserver);
    }
}

