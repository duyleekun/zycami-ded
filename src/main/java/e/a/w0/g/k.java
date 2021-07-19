/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.d;
import e.a.w0.g.j;
import e.a.w0.g.k$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class k
extends h0 {
    private static final String d = "rx2.single-priority";
    private static final String e = "RxSingleScheduler";
    public static final RxThreadFactory f;
    public static final ScheduledExecutorService g;
    public final ThreadFactory b;
    public final AtomicReference c;

    static {
        RxThreadFactory rxThreadFactory;
        ScheduledExecutorService scheduledExecutorService;
        g = scheduledExecutorService = Executors.newScheduledThreadPool(0);
        scheduledExecutorService.shutdown();
        int n10 = Integer.getInteger(d, 5);
        n10 = Math.min(10, n10);
        boolean bl2 = true;
        n10 = Math.max((int)(bl2 ? 1 : 0), n10);
        f = rxThreadFactory = new RxThreadFactory(e, n10, bl2);
    }

    public k() {
        RxThreadFactory rxThreadFactory = f;
        this(rxThreadFactory);
    }

    public k(ThreadFactory object) {
        AtomicReference<Object> atomicReference;
        this.c = atomicReference = new AtomicReference<Object>();
        this.b = object;
        object = k.k((ThreadFactory)object);
        atomicReference.lazySet(object);
    }

    public static ScheduledExecutorService k(ThreadFactory threadFactory) {
        return j.a(threadFactory);
    }

    public h0$c c() {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService)this.c.get();
        k$a k$a = new k$a(scheduledExecutorService);
        return k$a;
    }

    public b f(Runnable future, long l10, TimeUnit timeUnit) {
        future = e.a.a1.a.b0((Runnable)((Object)future));
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask((Runnable)((Object)future));
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            future = this.c;
            future = ((AtomicReference)((Object)future)).get();
            future = (ScheduledExecutorService)((Object)future);
            future = future.submit(scheduledDirectTask);
        } else {
            future = this.c;
            future = ((AtomicReference)((Object)future)).get();
            future = (ScheduledExecutorService)((Object)future);
            future = future.schedule(scheduledDirectTask, l10, timeUnit);
        }
        try {
            scheduledDirectTask.setFuture(future);
            return scheduledDirectTask;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            e.a.a1.a.Y(rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
    }

    public b g(Runnable future, long l10, long l11, TimeUnit timeUnit) {
        future = e.a.a1.a.b0((Runnable)((Object)future));
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService)this.c.get();
            d d10 = new d((Runnable)((Object)future), scheduledExecutorService);
            Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object2 <= 0) {
                future = scheduledExecutorService.submit(d10);
            }
            try {
                future = scheduledExecutorService.schedule(d10, l10, timeUnit);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            d10.b(future);
            return d10;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask((Runnable)((Object)future));
        try {
            future = this.c;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            e.a.a1.a.Y(rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
        Future future2 = future = ((AtomicReference)((Object)future)).get();
        future2 = (ScheduledExecutorService)((Object)future);
        future = future2.scheduleAtFixedRate(scheduledDirectPeriodicTask, l10, l11, timeUnit);
        scheduledDirectPeriodicTask.setFuture(future);
        return scheduledDirectPeriodicTask;
    }

    public void h() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService)this.c.get();
        if (scheduledExecutorService2 != (scheduledExecutorService = g) && (scheduledExecutorService2 = this.c.getAndSet(scheduledExecutorService)) != scheduledExecutorService) {
            scheduledExecutorService2.shutdownNow();
        }
    }

    public void i() {
        ScheduledExecutorService scheduledExecutorService;
        Object object;
        boolean bl2;
        ExecutorService executorService = null;
        do {
            if ((scheduledExecutorService = (ScheduledExecutorService)this.c.get()) != (object = g)) {
                if (executorService != null) {
                    executorService.shutdown();
                }
                return;
            }
            if (executorService != null) continue;
            executorService = k.k(this.b);
        } while (!(bl2 = ((AtomicReference)(object = this.c)).compareAndSet(scheduledExecutorService, executorService)));
    }
}

