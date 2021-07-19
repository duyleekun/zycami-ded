/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.w0.e.e.t$a;
import e.a.y0.l;
import java.util.concurrent.TimeUnit;

public final class t
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final boolean e;

    public t(e0 e02, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = bl2;
    }

    public void K5(g0 object) {
        g0 g02;
        g0 g03;
        boolean bl2 = this.e;
        if (bl2) {
            g03 = object;
        } else {
            g02 = new l((g0)object);
            g03 = g02;
        }
        h0$c h0$c = this.d.c();
        object = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        boolean bl3 = this.e;
        g02 = new t$a(g03, l10, timeUnit, h0$c, bl3);
        object.subscribe(g02);
    }
}

