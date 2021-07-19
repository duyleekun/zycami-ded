/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.h0;
import e.a.x0.a;
import e.a.z;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper$b
implements Callable {
    private final z a;
    private final int b;
    private final long c;
    private final TimeUnit d;
    private final h0 e;

    public ObservableInternalHelper$b(z z10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = z10;
        this.b = n10;
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
    }

    public a a() {
        z z10 = this.a;
        int n10 = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        h0 h02 = this.e;
        return z10.O4(n10, l10, timeUnit, h02);
    }
}

