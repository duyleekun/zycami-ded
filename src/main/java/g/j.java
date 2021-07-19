/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.h0.h.d;
import g.h0.i.g;
import java.util.concurrent.TimeUnit;

public final class j {
    private final g a;

    public j() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this(5, 5, timeUnit);
    }

    public j(int n10, long l10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "timeUnit");
        d d10 = d.h;
        g g10 = new g(d10, n10, l10, timeUnit);
        this(g10);
    }

    public j(g g10) {
        f0.p(g10, "delegate");
        this.a = g10;
    }

    public final int a() {
        return this.a.d();
    }

    public final void b() {
        this.a.e();
    }

    public final g c() {
        return this.a;
    }

    public final int d() {
        return this.a.f();
    }
}

