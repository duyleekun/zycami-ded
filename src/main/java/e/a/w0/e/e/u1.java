/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.u1$a;
import java.util.concurrent.TimeUnit;

public final class u1
extends a {
    public final h0 b;
    public final TimeUnit c;

    public u1(e0 e02, TimeUnit timeUnit, h0 h02) {
        super(e02);
        this.b = h02;
        this.c = timeUnit;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.b;
        u1$a u1$a = new u1$a(g02, timeUnit, h02);
        e02.subscribe(u1$a);
    }
}

