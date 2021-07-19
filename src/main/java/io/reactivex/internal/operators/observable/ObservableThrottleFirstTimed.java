/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.y0.l;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed$DebounceTimedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableThrottleFirstTimed
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;

    public ObservableThrottleFirstTimed(e0 e02, long l10, TimeUnit timeUnit, h0 h02) {
        super(e02);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        l l10 = new l(g02);
        long l11 = this.b;
        TimeUnit timeUnit = this.c;
        h0$c h0$c = this.d.c();
        ObservableThrottleFirstTimed$DebounceTimedObserver observableThrottleFirstTimed$DebounceTimedObserver = new ObservableThrottleFirstTimed$DebounceTimedObserver(l10, l11, timeUnit, h0$c);
        e02.subscribe(observableThrottleFirstTimed$DebounceTimedObserver);
    }
}

