/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.h0;
import io.reactivex.internal.operators.completable.CompletableDelay$Delay;
import java.util.concurrent.TimeUnit;

public final class CompletableDelay
extends a {
    public final g a;
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final boolean e;

    public CompletableDelay(g g10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        this.a = g10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = bl2;
    }

    public void L0(d d10) {
        g g10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        boolean bl2 = this.e;
        CompletableDelay$Delay completableDelay$Delay = new CompletableDelay$Delay(d10, l10, timeUnit, h02, bl2);
        g10.f(completableDelay$Delay);
    }
}

