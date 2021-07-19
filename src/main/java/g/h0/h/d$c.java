/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.f0;
import g.h0.h.d;
import g.h0.h.d$a;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d$c
implements d$a {
    private final ThreadPoolExecutor a;

    public d$c(ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        f0.p(threadFactory, "threadFactory");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<Runnable>();
        this.a = threadPoolExecutor = new ThreadPoolExecutor(0, -1 >>> 1, (long)60, timeUnit, synchronousQueue, threadFactory);
    }

    public void a(d d10) {
        f0.p(d10, "taskRunner");
        d10.notify();
    }

    public void b(d d10, long l10) {
        int n10;
        String string2 = "taskRunner";
        f0.p(d10, string2);
        long l11 = 1000000L;
        long l12 = l10 / l11;
        l11 *= l12;
        l11 = l10 - l11;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 > 0 || (n10 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1))) > 0) {
            n10 = (int)l11;
            d10.wait(l12, n10);
        }
    }

    public void c(d d10) {
        f0.p(d10, "taskRunner");
    }

    public final void d() {
        this.a.shutdown();
    }

    public void execute(Runnable runnable) {
        f0.p(runnable, "runnable");
        this.a.execute(runnable);
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}

