/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.u;
import f.r2.a;
import f.r2.d;
import f.r2.e;
import f.r2.o;
import java.util.concurrent.TimeUnit;

public final class a$a
extends o {
    private final double a;
    private final a b;
    private final double c;

    private a$a(double d10, a a10, double d11) {
        this.a = d10;
        this.b = a10;
        this.c = d11;
    }

    public /* synthetic */ a$a(double d10, a a10, double d11, u u10) {
        this(d10, a10, d11);
    }

    public double a() {
        double d10 = this.b.c();
        double d11 = this.a;
        d10 -= d11;
        TimeUnit timeUnit = this.b.b();
        d10 = e.V(d10, timeUnit);
        d11 = this.c;
        return d.H(d10, d11);
    }

    public o e(double d10) {
        double d11 = this.a;
        a a10 = this.b;
        double d12 = d.I(this.c, d10);
        a$a a$a = new a$a(d11, a10, d12, null);
        return a$a;
    }
}

