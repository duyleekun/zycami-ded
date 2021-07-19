/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.r2.a$a;
import f.r2.d;
import f.r2.o;
import f.r2.p;
import java.util.concurrent.TimeUnit;

public abstract class a
implements p {
    private final TimeUnit b;

    public a(TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        this.b = timeUnit;
    }

    public o a() {
        double d10 = this.c();
        double d11 = d.d.c();
        a$a a$a = new a$a(d10, this, d11, null);
        return a$a;
    }

    public final TimeUnit b() {
        return this.b;
    }

    public abstract double c();
}

