/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.h2.t.f0;
import f.k2.a;
import f.k2.b$a;
import java.util.Random;

public final class b
extends a {
    private final b$a c;

    public b() {
        b$a b$a;
        this.c = b$a = new b$a();
    }

    public Random r() {
        Object t10 = this.c.get();
        f0.o(t10, "implStorage.get()");
        return (Random)t10;
    }
}

