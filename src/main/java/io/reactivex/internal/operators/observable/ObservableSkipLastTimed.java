/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed$SkipLastTimedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableSkipLastTimed
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final int e;
    public final boolean f;

    public ObservableSkipLastTimed(e0 e02, long l10, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = n10;
        this.f = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        int n10 = this.e;
        boolean bl2 = this.f;
        ObservableSkipLastTimed$SkipLastTimedObserver observableSkipLastTimed$SkipLastTimedObserver = new ObservableSkipLastTimed$SkipLastTimedObserver(g02, l10, timeUnit, h02, n10, bl2);
        e02.subscribe(observableSkipLastTimed$SkipLastTimedObserver);
    }
}

