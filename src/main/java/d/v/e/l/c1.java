/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import d.v.e.l.c1$b;
import d.v.e.l.j2;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c1 {
    private static volatile c1 e;
    private static final int f = 3;
    private final Executor a;
    private final Executor b;
    private final Executor c;
    private final Executor d;

    private c1() {
        j2 j22 = new j2();
        int n10 = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(n10);
        c1$b c1$b = new c1$b(null);
        ExecutorService executorService2 = Executors.newFixedThreadPool(n10);
        this(j22, executorService, c1$b, executorService2);
    }

    private c1(Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        this.a = executor;
        this.b = executor2;
        this.c = executor3;
        this.d = executor4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c1 b() {
        Object object = e;
        if (object != null) return e;
        object = c1.class;
        synchronized (object) {
            c1 c12 = e;
            if (c12 != null) return e;
            e = c12 = new c1();
            return e;
        }
    }

    public Executor a() {
        return this.a;
    }

    public Executor c() {
        return this.c;
    }

    public Executor d() {
        return this.d;
    }

    public Executor e() {
        return this.b;
    }
}

