/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.l;
import d.n.a.b$d;
import java.util.concurrent.ExecutorService;

public final class e
implements c.a.l.e {
    private static final e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public static e a() {
        return a;
    }

    public static ExecutorService c() {
        return (ExecutorService)l.b(b$d.h(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public ExecutorService b() {
        return (ExecutorService)l.b(b$d.h(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

