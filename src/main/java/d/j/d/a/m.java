/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a;

import d.j.d.a.o.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class m {
    private static final m d;
    private final Executor a;
    private final ExecutorService b;
    private final Executor c;

    static {
        m m10;
        d = m10 = new m();
    }

    private m() {
        Executor executor;
        this.b = executor = d.j.d.a.o.a.a();
        this.a = executor;
        executor = d.j.d.a.o.a.b();
        this.c = executor;
    }

    public static ExecutorService a() {
        return m.d.b;
    }

    public static Executor b() {
        return m.d.a;
    }

    public static Executor c() {
        return m.d.c;
    }
}

