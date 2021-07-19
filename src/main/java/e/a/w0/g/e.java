/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0;
import e.a.h0$c;
import e.a.w0.g.e$a;
import e.a.w0.g.e$b;
import e.a.w0.g.e$c;
import e.a.w0.g.g;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class e
extends h0 {
    private static final String d = "RxCachedThreadScheduler";
    public static final RxThreadFactory e;
    private static final String f = "RxCachedWorkerPoolEvictor";
    public static final RxThreadFactory g;
    private static final String h = "rx2.io-keep-alive-time";
    public static final long i = 60L;
    private static final long j = 0L;
    private static final TimeUnit k;
    public static final e$c l;
    private static final String m = "rx2.io-priority";
    public static final e$a n;
    public final ThreadFactory b;
    public final AtomicReference c;

    static {
        RxThreadFactory rxThreadFactory;
        k = TimeUnit.SECONDS;
        j = Long.getLong(h, 60);
        RxThreadFactory rxThreadFactory2 = new RxThreadFactory("RxCachedThreadSchedulerShutdown");
        Object object = new e$c(rxThreadFactory2);
        l = object;
        ((g)object).dispose();
        int n10 = Integer.getInteger(m, 5);
        n10 = Math.min(10, n10);
        n10 = Math.max(1, n10);
        e = rxThreadFactory2 = new RxThreadFactory(d, n10);
        g = rxThreadFactory = new RxThreadFactory(f, n10);
        n = object = new e$a(0L, null, rxThreadFactory2);
        ((e$a)object).e();
    }

    public e() {
        RxThreadFactory rxThreadFactory = e;
        this(rxThreadFactory);
    }

    public e(ThreadFactory atomicReference) {
        this.b = atomicReference;
        e$a e$a = n;
        this.c = atomicReference = new AtomicReference<e$a>(e$a);
        this.i();
    }

    public h0$c c() {
        e$a e$a = (e$a)this.c.get();
        e$b e$b = new e$b(e$a);
        return e$b;
    }

    public void h() {
        e$a e$a;
        e$a e$a2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            if ((e$a2 = (e$a)this.c.get()) != (e$a = n)) continue;
            return;
        } while (!(bl2 = (atomicReference = this.c).compareAndSet(e$a2, e$a)));
        e$a2.e();
    }

    public void i() {
        AtomicReference atomicReference = this.c;
        e$a e$a = n;
        long l10 = j;
        TimeUnit timeUnit = k;
        ThreadFactory threadFactory = this.b;
        e$a e$a2 = new e$a(l10, timeUnit, threadFactory);
        boolean bl2 = atomicReference.compareAndSet(e$a, e$a2);
        if (!bl2) {
            e$a2.e();
        }
    }

    public int k() {
        return ((e$a)this.c.get()).c.g();
    }
}

