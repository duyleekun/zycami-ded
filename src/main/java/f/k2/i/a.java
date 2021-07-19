/*
 * Decompiled with CFR 0.151.
 */
package f.k2.i;

import f.h2.t.f0;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class a
extends f.k2.a {
    public double i(double d10) {
        return ThreadLocalRandom.current().nextDouble(d10);
    }

    public int n(int n10, int n11) {
        return ThreadLocalRandom.current().nextInt(n10, n11);
    }

    public long p(long l10) {
        return ThreadLocalRandom.current().nextLong(l10);
    }

    public long q(long l10, long l11) {
        return ThreadLocalRandom.current().nextLong(l10, l11);
    }

    public Random r() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        f0.o(threadLocalRandom, "ThreadLocalRandom.current()");
        return threadLocalRandom;
    }
}

