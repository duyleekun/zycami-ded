/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import k.d;
import k.e;
import k.g$b;
import k.g$c$a;

public final class g$c
implements e {
    private final Type a;

    public g$c(Type type) {
        this.a = type;
    }

    public Type a() {
        return this.a;
    }

    public CompletableFuture c(d d10) {
        g$b g$b = new g$b(d10);
        g$c$a g$c$a = new g$c$a(this, g$b);
        d10.h(g$c$a);
        return g$b;
    }
}

