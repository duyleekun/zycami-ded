/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import d.n.a.b$d;
import java.util.concurrent.ExecutorService;

public final class i
implements e {
    private static final i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public static i a() {
        return a;
    }

    public static ExecutorService c() {
        return (ExecutorService)l.b(b$d.l(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public ExecutorService b() {
        return (ExecutorService)l.b(b$d.l(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

