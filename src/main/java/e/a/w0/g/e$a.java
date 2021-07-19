/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.s0.a;
import e.a.s0.b;
import e.a.w0.g.e;
import e.a.w0.g.e$c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class e$a
implements Runnable {
    private final long a;
    private final ConcurrentLinkedQueue b;
    public final a c;
    private final ScheduledExecutorService d;
    private final Future e;
    private final ThreadFactory f;

    public e$a(long l10, TimeUnit timeUnit, ThreadFactory threadFactory) {
        Object object;
        l10 = timeUnit != null ? timeUnit.toNanos(l10) : 0L;
        this.a = l10;
        Object object2 = new ConcurrentLinkedQueue();
        this.b = object2;
        this.c = object2 = new a();
        this.f = threadFactory;
        int n10 = 0;
        object2 = null;
        if (timeUnit != null) {
            n10 = 1;
            object = e.a.w0.g.e.g;
            object2 = Executors.newScheduledThreadPool(n10, (ThreadFactory)object);
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            object = object2.scheduleWithFixedDelay(this, l10, l10, timeUnit2);
        } else {
            object = null;
        }
        this.d = object2;
        this.e = object;
    }

    public void a() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.b;
        boolean bl2 = concurrentLinkedQueue.isEmpty();
        if (!bl2) {
            e$c e$c;
            long l10;
            long l11;
            long l12;
            boolean bl3;
            long l13 = this.c();
            Iterator iterator2 = this.b.iterator();
            while ((bl3 = iterator2.hasNext()) && (l12 = (l11 = (l10 = (e$c = (e$c)iterator2.next()).i()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
                Object object = this.b;
                l12 = (long)((ConcurrentLinkedQueue)object).remove(e$c);
                if (l12 == false) continue;
                object = this.c;
                ((a)object).a(e$c);
            }
        }
    }

    public e$c b() {
        Object object = this.c;
        boolean bl2 = ((a)object).isDisposed();
        if (bl2) {
            return e.a.w0.g.e.l;
        }
        while (!(bl2 = ((ConcurrentLinkedQueue)(object = this.b)).isEmpty())) {
            object = (e$c)this.b.poll();
            if (object == null) continue;
            return object;
        }
        ThreadFactory threadFactory = this.f;
        object = new e$c(threadFactory);
        this.c.b((b)object);
        return object;
    }

    public long c() {
        return System.nanoTime();
    }

    public void d(e$c e$c) {
        long l10 = this.c();
        long l11 = this.a;
        e$c.j(l10 += l11);
        this.b.offer(e$c);
    }

    public void e() {
        this.c.dispose();
        Object object = this.e;
        if (object != null) {
            boolean bl2 = true;
            object.cancel(bl2);
        }
        if ((object = this.d) != null) {
            object.shutdownNow();
        }
    }

    public void run() {
        this.a();
    }
}

