/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.e;
import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.q$a;
import i.g.d;
import java.util.concurrent.TimeUnit;

public final class q
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final boolean f;

    public q(j j10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
        this.f = bl2;
    }

    public void m6(d object) {
        o o10;
        d d10;
        boolean bl2 = this.f;
        if (bl2) {
            d10 = object;
        } else {
            o10 = new e((d)object);
            d10 = o10;
        }
        h0$c h0$c = this.e.c();
        object = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        boolean bl3 = this.f;
        o10 = new q$a(d10, l10, timeUnit, h0$c, bl3);
        ((j)object).l6(o10);
    }
}

