/*
 * Decompiled with CFR 0.151.
 */
package f.r2.t;

import f.h2.t.f0;
import f.r2.d;
import f.r2.e;
import j$.time.Duration;

public final class a {
    private static final Duration a(double d10) {
        long l10 = (long)d.u(d10);
        long l11 = d.y(d10);
        Duration duration = Duration.ofSeconds(l10, l11);
        f0.o(duration, "toComponents { seconds, \u2026, nanoseconds.toLong()) }");
        return duration;
    }

    private static final double b(Duration duration) {
        double d10 = e.N(duration.getSeconds());
        double d11 = e.G(duration.getNano());
        return d.I(d10, d11);
    }
}

