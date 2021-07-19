/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$c;
import d.n.a.b$d;
import e.a.h0;
import java.util.concurrent.ExecutorService;

public final class o
implements e {
    private final c a;
    private final c b;
    private final c c;

    public o(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static o a(c c10, c c11, c c12) {
        o o10 = new o(c10, c11, c12);
        return o10;
    }

    public static b$c c(ExecutorService executorService, h0 h02, ExecutorService executorService2) {
        return (b$c)l.b(b$d.r(executorService, h02, executorService2), "Cannot return null from a non-@Nullable @Provides method");
    }

    public b$c b() {
        ExecutorService executorService = (ExecutorService)this.a.get();
        h0 h02 = (h0)this.b.get();
        ExecutorService executorService2 = (ExecutorService)this.c.get();
        return (b$c)l.b(b$d.r(executorService, h02, executorService2), "Cannot return null from a non-@Nullable @Provides method");
    }
}

