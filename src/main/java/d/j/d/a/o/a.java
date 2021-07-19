/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.o.a$a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final a b;
    private static final int c;
    public static final int d;
    public static final int e;
    private final Executor a;

    static {
        int n10;
        a a10;
        b = a10 = new a();
        c = n10 = Runtime.getRuntime().availableProcessors();
        d = n10 + 1;
        e = n10 * 2 + 1;
    }

    public a() {
        a$a a$a = new a$a(0);
        this.a = a$a;
    }

    public static ExecutorService a() {
        int n10 = d;
        int n11 = e;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(n10, n11, 1L, timeUnit, linkedBlockingQueue);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return d.j.d.a.o.a.b.a;
    }
}

