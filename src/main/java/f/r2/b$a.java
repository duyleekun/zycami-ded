/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.u;
import f.r2.b;
import f.r2.d;
import f.r2.e;
import f.r2.o;
import java.util.concurrent.TimeUnit;

public final class b$a
extends o {
    private final long a;
    private final b b;
    private final double c;

    private b$a(long l10, b b10, double d10) {
        this.a = l10;
        this.b = b10;
        this.c = d10;
    }

    public /* synthetic */ b$a(long l10, b b10, double d10, u u10) {
        this(l10, b10, d10);
    }

    public double a() {
        long l10 = this.b.c();
        long l11 = this.a;
        TimeUnit timeUnit = this.b.b();
        double d10 = e.X(l10 -= l11, timeUnit);
        double d11 = this.c;
        return d.H(d10, d11);
    }

    public o e(double d10) {
        long l10 = this.a;
        b b10 = this.b;
        double d11 = d.I(this.c, d10);
        b$a b$a = new b$a(l10, b10, d11, null);
        return b$a;
    }
}

