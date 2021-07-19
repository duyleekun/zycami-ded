/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.h2.t.f0;
import f.k2.a;
import java.util.Random;

public final class c
extends a {
    private final Random c;

    public c(Random random) {
        f0.p(random, "impl");
        this.c = random;
    }

    public Random r() {
        return this.c;
    }
}

