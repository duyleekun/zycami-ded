/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.h2.t.u;
import f.r2.d;
import f.r2.h;
import java.util.concurrent.TimeUnit;

public final class d$a {
    private d$a() {
    }

    public /* synthetic */ d$a(u u10) {
        this();
    }

    public final double a(double d10, TimeUnit timeUnit, TimeUnit timeUnit2) {
        f0.p((Object)timeUnit, "sourceUnit");
        f0.p((Object)timeUnit2, "targetUnit");
        return h.b(d10, timeUnit, timeUnit2);
    }

    public final double b() {
        return d.a();
    }

    public final double c() {
        return d.b();
    }
}

