/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0;
import e.a.j;
import e.a.w0.e.b.a;
import e.a.w0.e.b.h1$a;
import i.g.d;
import java.util.concurrent.TimeUnit;

public final class h1
extends a {
    public final h0 c;
    public final TimeUnit d;

    public h1(j j10, TimeUnit timeUnit, h0 h02) {
        super(j10);
        this.c = h02;
        this.d = timeUnit;
    }

    public void m6(d d10) {
        j j10 = this.b;
        TimeUnit timeUnit = this.d;
        h0 h02 = this.c;
        h1$a h1$a = new h1$a(d10, timeUnit, h02);
        j10.l6(h1$a);
    }
}

