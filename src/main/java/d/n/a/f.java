/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;
import e.a.h0;
import java.util.concurrent.ExecutorService;

public final class f
implements e {
    private final c a;

    public f(c c10) {
        this.a = c10;
    }

    public static f a(c c10) {
        f f10 = new f(c10);
        return f10;
    }

    public static h0 c(ExecutorService executorService) {
        return (h0)l.b(b$d.i(executorService), "Cannot return null from a non-@Nullable @Provides method");
    }

    public h0 b() {
        return (h0)l.b(b$d.i((ExecutorService)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

