/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import k.d;
import k.e;
import k.g$a$a;
import k.g$b;

public final class g$a
implements e {
    private final Type a;

    public g$a(Type type) {
        this.a = type;
    }

    public Type a() {
        return this.a;
    }

    public CompletableFuture c(d d10) {
        g$b g$b = new g$b(d10);
        g$a$a g$a$a = new g$a$a(this, g$b);
        d10.h(g$a$a);
        return g$b;
    }
}

