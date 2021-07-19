/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.r2.b$a;
import f.r2.d;
import f.r2.o;
import f.r2.p;
import java.util.concurrent.TimeUnit;

public abstract class b
implements p {
    private final TimeUnit b;

    public b(TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        this.b = timeUnit;
    }

    public o a() {
        long l10 = this.c();
        double d10 = d.d.c();
        b$a b$a = new b$a(l10, this, d10, null);
        return b$a;
    }

    public final TimeUnit b() {
        return this.b;
    }

    public abstract long c();
}

