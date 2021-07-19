/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.a1.a;
import e.a.c1.b;
import e.a.h0;
import e.a.h0$c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.AbstractDirectTask;
import io.reactivex.internal.schedulers.ExecutorScheduler$DelayedRunnable;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$BooleanRunnable;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;
import io.reactivex.internal.schedulers.ExecutorScheduler$a;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class ExecutorScheduler
extends h0 {
    public static final h0 d = e.a.c1.b.g();
    public final boolean b;
    public final Executor c;

    public ExecutorScheduler(Executor executor, boolean bl2) {
        this.c = executor;
        this.b = bl2;
    }

    public h0$c c() {
        Executor executor = this.c;
        boolean bl2 = this.b;
        ExecutorScheduler$ExecutorWorker executorScheduler$ExecutorWorker = new ExecutorScheduler$ExecutorWorker(executor, bl2);
        return executorScheduler$ExecutorWorker;
    }

    public e.a.s0.b e(Runnable future) {
        Object object;
        block15: {
            future = e.a.a1.a.b0((Runnable)((Object)future));
            try {
                object = this.c;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            boolean bl2 = object instanceof ExecutorService;
            if (bl2) {
                object = new ScheduledDirectTask((Runnable)((Object)future));
                future = this.c;
                future = (ExecutorService)((Object)future);
                future = future.submit(object);
                ((AbstractDirectTask)object).setFuture(future);
                return object;
            }
            bl2 = this.b;
            if (!bl2) break block15;
            object = new ExecutorScheduler$ExecutorWorker$InterruptibleRunnable((Runnable)((Object)future), null);
            future = this.c;
            future.execute((Runnable)object);
            return object;
        }
        object = new ExecutorScheduler$ExecutorWorker$BooleanRunnable((Runnable)((Object)future));
        future = this.c;
        future.execute((Runnable)object);
        return object;
    }

    public e.a.s0.b f(Runnable scheduledFuture, long l10, TimeUnit timeUnit) {
        scheduledFuture = e.a.a1.a.b0((Runnable)((Object)scheduledFuture));
        Object object = this.c;
        boolean bl2 = object instanceof ScheduledExecutorService;
        if (bl2) {
            try {
                object = new ScheduledDirectTask((Runnable)((Object)scheduledFuture));
                scheduledFuture = this.c;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            scheduledFuture = (ScheduledExecutorService)((Object)scheduledFuture);
            scheduledFuture = scheduledFuture.schedule(object, l10, timeUnit);
            ((AbstractDirectTask)object).setFuture(scheduledFuture);
            return object;
        }
        object = new ExecutorScheduler$DelayedRunnable((Runnable)((Object)scheduledFuture));
        scheduledFuture = d;
        ExecutorScheduler$a executorScheduler$a = new ExecutorScheduler$a(this, (ExecutorScheduler$DelayedRunnable)object);
        scheduledFuture = ((h0)((Object)scheduledFuture)).f(executorScheduler$a, l10, timeUnit);
        ((ExecutorScheduler$DelayedRunnable)object).timed.replace((e.a.s0.b)((Object)scheduledFuture));
        return object;
    }

    public e.a.s0.b g(Runnable scheduledFuture, long l10, long l11, TimeUnit timeUnit) {
        Object object = this.c;
        boolean bl2 = object instanceof ScheduledExecutorService;
        if (bl2) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask;
            scheduledFuture = e.a.a1.a.b0((Runnable)((Object)scheduledFuture));
            try {
                scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask((Runnable)((Object)scheduledFuture));
                scheduledFuture = this.c;
                object = scheduledFuture;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            object = (ScheduledExecutorService)((Object)scheduledFuture);
            scheduledFuture = object.scheduleAtFixedRate(scheduledDirectPeriodicTask, l10, l11, timeUnit);
            scheduledDirectPeriodicTask.setFuture(scheduledFuture);
            return scheduledDirectPeriodicTask;
        }
        return super.g((Runnable)((Object)scheduledFuture), l10, l11, timeUnit);
    }
}

