/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.z;

import d.c.a.o.k.z.a$a;
import d.c.a.o.k.z.a$b;
import d.c.a.o.k.z.a$c;
import d.c.a.o.k.z.b;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
implements ExecutorService {
    private static final String b = "source";
    private static final String c = "disk-cache";
    private static final int d = 1;
    private static final String e = "GlideExecutor";
    private static final String f = "source-unlimited";
    private static final String g = "animation";
    private static final long h = 0L;
    private static final int i = 4;
    private static volatile int j;
    private final ExecutorService a;

    static {
        h = TimeUnit.SECONDS.toMillis(10);
    }

    public a(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        int n10 = j;
        if (n10 == 0) {
            int n11 = d.c.a.o.k.z.b.a();
            j = n10 = Math.min(4, n11);
        }
        return j;
    }

    public static a$a b() {
        int n10 = d.c.a.o.k.z.a.a();
        int n11 = 1;
        int n12 = 4;
        n10 = n10 >= n12 ? 2 : n11;
        a$a a$a = new a$a(n11 != 0);
        return a$a.c(n10).b(g);
    }

    public static a c() {
        return d.c.a.o.k.z.a.b().a();
    }

    public static a d(int n10, a$c a$c) {
        return d.c.a.o.k.z.a.b().c(n10).e(a$c).a();
    }

    public static a$a e() {
        int n10 = 1;
        a$a a$a = new a$a(n10 != 0);
        return a$a.c(n10).b(c);
    }

    public static a f() {
        return d.c.a.o.k.z.a.e().a();
    }

    public static a g(int n10, String string2, a$c a$c) {
        return d.c.a.o.k.z.a.e().c(n10).b(string2).e(a$c).a();
    }

    public static a h(a$c a$c) {
        return d.c.a.o.k.z.a.e().e(a$c).a();
    }

    public static a$a i() {
        a$a a$a = new a$a(false);
        int n10 = d.c.a.o.k.z.a.a();
        return a$a.c(n10).b(b);
    }

    public static a j() {
        return d.c.a.o.k.z.a.i().a();
    }

    public static a k(int n10, String string2, a$c a$c) {
        return d.c.a.o.k.z.a.i().c(n10).b(string2).e(a$c).a();
    }

    public static a l(a$c a$c) {
        return d.c.a.o.k.z.a.i().e(a$c).a();
    }

    public static a m() {
        ThreadPoolExecutor threadPoolExecutor;
        long l10 = h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<Runnable>();
        Object object = a$c.d;
        a$b a$b = new a$b(f, (a$c)object, false);
        object = threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(0, -1 >>> 1, l10, timeUnit, synchronousQueue, a$b);
        a a10 = new a(threadPoolExecutor);
        return a10;
    }

    public boolean awaitTermination(long l10, TimeUnit timeUnit) {
        return this.a.awaitTermination(l10, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.a.invokeAll(collection);
    }

    public List invokeAll(Collection collection, long l10, TimeUnit timeUnit) {
        return this.a.invokeAll(collection, l10, timeUnit);
    }

    public Object invokeAny(Collection collection) {
        return this.a.invokeAny(collection);
    }

    public Object invokeAny(Collection collection, long l10, TimeUnit timeUnit) {
        return this.a.invokeAny(collection, l10, timeUnit);
    }

    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    public void shutdown() {
        this.a.shutdown();
    }

    public List shutdownNow() {
        return this.a.shutdownNow();
    }

    public Future submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public Future submit(Runnable runnable, Object object) {
        return this.a.submit(runnable, object);
    }

    public Future submit(Callable callable) {
        return this.a.submit(callable);
    }

    public String toString() {
        return this.a.toString();
    }
}

