/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.a1.a;
import e.a.h0$c;
import e.a.w0.g.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$BooleanRunnable;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$InterruptibleRunnable;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$a;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExecutorScheduler$ExecutorWorker
extends h0$c
implements Runnable {
    public final boolean a;
    public final Executor b;
    public final MpscLinkedQueue c;
    public volatile boolean d;
    public final AtomicInteger e;
    public final e.a.s0.a f;

    public ExecutorScheduler$ExecutorWorker(Executor object, boolean bl2) {
        Object object2 = new AtomicInteger();
        this.e = object2;
        this.f = object2 = new e.a.s0.a();
        this.b = object;
        this.c = object = new MpscLinkedQueue();
        this.a = bl2;
    }

    public e.a.s0.b b(Runnable object) {
        Runnable runnable;
        boolean bl2 = this.d;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        object = e.a.a1.a.b0((Runnable)object);
        bl2 = this.a;
        if (bl2) {
            e.a.s0.a a10 = this.f;
            runnable = new ExecutorScheduler$ExecutorWorker$InterruptibleRunnable((Runnable)object, a10);
            object = this.f;
            ((e.a.s0.a)object).b((e.a.s0.b)((Object)runnable));
        } else {
            runnable = new ExecutorScheduler$ExecutorWorker$BooleanRunnable((Runnable)object);
        }
        this.c.offer(runnable);
        object = this.e;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            try {
                object = this.b;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                this.d = true;
                this.c.clear();
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            object.execute(this);
        }
        return runnable;
    }

    public e.a.s0.b c(Runnable scheduledFuture, long l10, TimeUnit timeUnit) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return this.b((Runnable)((Object)scheduledFuture));
        }
        object = this.d;
        if (object != false) {
            return EmptyDisposable.INSTANCE;
        }
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
        scheduledFuture = e.a.a1.a.b0((Runnable)((Object)scheduledFuture));
        ExecutorScheduler$ExecutorWorker$a executorScheduler$ExecutorWorker$a = new ExecutorScheduler$ExecutorWorker$a(this, sequentialDisposable2, (Runnable)((Object)scheduledFuture));
        scheduledFuture = this.f;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(executorScheduler$ExecutorWorker$a, (e.a.w0.a.a)((Object)scheduledFuture));
        this.f.b(scheduledRunnable);
        scheduledFuture = this.b;
        boolean bl2 = scheduledFuture instanceof ScheduledExecutorService;
        if (bl2) {
            try {
                scheduledFuture = (ScheduledExecutorService)((Object)scheduledFuture);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                this.d = true;
                e.a.a1.a.Y(rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
            scheduledFuture = scheduledFuture.schedule(scheduledRunnable, l10, timeUnit);
            scheduledRunnable.setFuture(scheduledFuture);
        } else {
            scheduledFuture = ExecutorScheduler.d.f(scheduledRunnable, l10, timeUnit);
            b b10 = new b((e.a.s0.b)((Object)scheduledFuture));
            scheduledRunnable.setFuture(b10);
        }
        sequentialDisposable.replace(scheduledRunnable);
        return sequentialDisposable2;
    }

    public void dispose() {
        int n10 = this.d;
        if (n10 == 0) {
            this.d = true;
            this.f.dispose();
            Object object = this.e;
            n10 = ((AtomicInteger)object).getAndIncrement();
            if (n10 == 0) {
                object = this.c;
                ((MpscLinkedQueue)object).clear();
            }
        }
    }

    public boolean isDisposed() {
        return this.d;
    }

    public void run() {
        MpscLinkedQueue mpscLinkedQueue = this.c;
        int n10 = 1;
        block0: while (true) {
            boolean bl2;
            if (bl2 = this.d) {
                mpscLinkedQueue.clear();
                return;
            }
            do {
                Object object;
                if ((object = (Runnable)mpscLinkedQueue.poll()) == null) {
                    bl2 = this.d;
                    if (bl2) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                    object = this.e;
                    n10 = -n10;
                    if ((n10 = ((AtomicInteger)object).addAndGet(n10)) != 0) continue block0;
                    return;
                }
                object.run();
            } while (!(bl2 = this.d));
            break;
        }
        mpscLinkedQueue.clear();
    }
}

