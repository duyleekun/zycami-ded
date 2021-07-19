/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest$ThrottleLatestObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableThrottleLatest
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final boolean e;

    public ObservableThrottleLatest(z z10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(z10);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0$c h0$c = this.d.c();
        boolean bl2 = this.e;
        ObservableThrottleLatest$ThrottleLatestObserver observableThrottleLatest$ThrottleLatestObserver = new ObservableThrottleLatest$ThrottleLatestObserver(g02, l10, timeUnit, h0$c, bl2);
        e02.subscribe(observableThrottleLatest$ThrottleLatestObserver);
    }
}

