/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.d;
import e.a.w0.g.j;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class g
extends h0$c
implements b {
    private final ScheduledExecutorService a;
    public volatile boolean b;

    public g(ThreadFactory object) {
        this.a = object = j.a((ThreadFactory)object);
    }

    public b b(Runnable runnable) {
        return this.c(runnable, 0L, null);
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        boolean bl2 = this.b;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        return this.e(runnable, l10, timeUnit, null);
    }

    public void dispose() {
        boolean bl2 = this.b;
        if (!bl2) {
            this.b = bl2 = true;
            ScheduledExecutorService scheduledExecutorService = this.a;
            scheduledExecutorService.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable future, long l10, TimeUnit timeUnit, e.a.w0.a.a a10) {
        Object object;
        future = e.a.a1.a.b0((Runnable)((Object)future));
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable((Runnable)((Object)future), a10);
        if (a10 != null && (object = a10.b(scheduledRunnable)) == 0) {
            return scheduledRunnable;
        }
        long l11 = 0L;
        long l12 = l10 - l11;
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            future = this.a;
            future = future.submit(scheduledRunnable);
        } else {
            future = this.a;
            future = future.schedule(scheduledRunnable, l10, timeUnit);
        }
        try {
            scheduledRunnable.setFuture(future);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            if (a10 != null) {
                a10.a(scheduledRunnable);
            }
            e.a.a1.a.Y(rejectedExecutionException);
        }
        return scheduledRunnable;
    }

    public b f(Runnable future, long l10, TimeUnit timeUnit) {
        future = e.a.a1.a.b0((Runnable)((Object)future));
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask((Runnable)((Object)future));
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            future = this.a;
            future = future.submit(scheduledDirectTask);
        } else {
            future = this.a;
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
        ScheduledExecutorService scheduledExecutorService;
        future = e.a.a1.a.b0((Runnable)((Object)future));
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            ScheduledExecutorService scheduledExecutorService2 = this.a;
            d d10 = new d((Runnable)((Object)future), scheduledExecutorService2);
            Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object2 <= 0) {
                future = this.a;
                future = future.submit(d10);
            }
            try {
                future = this.a;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            future = future.schedule(d10, l10, timeUnit);
            d10.b(future);
            return d10;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask((Runnable)((Object)future));
        try {
            scheduledExecutorService = this.a;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            e.a.a1.a.Y(rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
        future = scheduledExecutorService.scheduleAtFixedRate(scheduledDirectPeriodicTask, l10, l11, timeUnit);
        scheduledDirectPeriodicTask.setFuture(future);
        return scheduledDirectPeriodicTask;
    }

    public void h() {
        boolean bl2 = this.b;
        if (!bl2) {
            this.b = bl2 = true;
            ScheduledExecutorService scheduledExecutorService = this.a;
            scheduledExecutorService.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.b;
    }
}

