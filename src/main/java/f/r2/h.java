/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import java.util.concurrent.TimeUnit;

public class h {
    public static /* synthetic */ void a() {
    }

    public static final double b(double d10, TimeUnit timeUnit, TimeUnit timeUnit2) {
        f0.p((Object)timeUnit, "sourceUnit");
        String string2 = "targetUnit";
        f0.p((Object)timeUnit2, string2);
        long l10 = 1L;
        long l11 = timeUnit2.convert(l10, timeUnit);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            double d11 = l11;
            return d10 * d11;
        }
        double d12 = timeUnit.convert(l10, timeUnit2);
        return d10 / d12;
    }
}

