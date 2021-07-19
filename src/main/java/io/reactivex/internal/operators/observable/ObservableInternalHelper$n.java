/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.h0;
import e.a.x0.a;
import e.a.z;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper$n
implements Callable {
    private final z a;
    private final long b;
    private final TimeUnit c;
    private final h0 d;

    public ObservableInternalHelper$n(z z10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = z10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public a a() {
        z z10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        return z10.R4(l10, timeUnit, h02);
    }
}

