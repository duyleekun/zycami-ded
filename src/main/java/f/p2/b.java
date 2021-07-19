/*
 * Decompiled with CFR 0.151.
 */
package f.p2;

import f.h2.s.a;
import f.h2.t.f0;

public final class b {
    public static final long a(a a10) {
        f0.p(a10, "block");
        long l10 = System.nanoTime();
        a10.invoke();
        return System.nanoTime() - l10;
    }

    public static final long b(a a10) {
        f0.p(a10, "block");
        long l10 = System.currentTimeMillis();
        a10.invoke();
        return System.currentTimeMillis() - l10;
    }
}

