/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractScheduledService$CustomScheduler$ReschedulableCallable
extends ForwardingFuture
implements Callable {
    private Future currentFuture;
    private final ScheduledExecutorService executor;
    private final ReentrantLock lock;
    private final AbstractService service;
    public final /* synthetic */ AbstractScheduledService$CustomScheduler this$0;
    private final Runnable wrappedRunnable;

    public AbstractScheduledService$CustomScheduler$ReschedulableCallable(AbstractScheduledService$CustomScheduler object, AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        this.this$0 = object;
        this.lock = object = new ReentrantLock();
        this.wrappedRunnable = runnable;
        this.executor = scheduledExecutorService;
        this.service = abstractService;
    }

    public Void call() {
        this.wrappedRunnable.run();
        this.reschedule();
        return null;
    }

    public boolean cancel(boolean bl2) {
        Object object = this.lock;
        ((ReentrantLock)object).lock();
        try {
            object = this.currentFuture;
            bl2 = object.cancel(bl2);
            return bl2;
        }
        finally {
            this.lock.unlock();
        }
    }

    public Future delegate() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
        throw unsupportedOperationException;
    }

    public boolean isCancelled() {
        Object object = this.lock;
        ((ReentrantLock)object).lock();
        try {
            object = this.currentFuture;
            boolean bl2 = object.isCancelled();
            return bl2;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void reschedule() {
        Throwable throwable;
        ScheduledFuture scheduledFuture;
        block13: {
            Object object;
            block12: {
                try {
                    scheduledFuture = this.this$0;
                }
                catch (Throwable throwable2) {
                    this.service.notifyFailed(throwable2);
                    return;
                }
                scheduledFuture = ((AbstractScheduledService$CustomScheduler)((Object)scheduledFuture)).getNextSchedule();
                throwable = null;
                object = this.lock;
                ((ReentrantLock)object).lock();
                object = this.currentFuture;
                if (object == null) break block12;
                boolean bl2 = object.isCancelled();
                if (bl2) break block13;
            }
            object = this.executor;
            long l10 = AbstractScheduledService$CustomScheduler$Schedule.access$800((AbstractScheduledService$CustomScheduler$Schedule)((Object)scheduledFuture));
            scheduledFuture = AbstractScheduledService$CustomScheduler$Schedule.access$900((AbstractScheduledService$CustomScheduler$Schedule)((Object)scheduledFuture));
            scheduledFuture = object.schedule(this, l10, (TimeUnit)((Object)scheduledFuture));
            try {
                this.currentFuture = scheduledFuture;
            }
            catch (Throwable throwable3) {
                throwable = throwable3;
            }
        }
        scheduledFuture = this.lock;
        ((ReentrantLock)((Object)scheduledFuture)).unlock();
        if (throwable != null) {
            scheduledFuture = this.service;
            ((AbstractService)((Object)scheduledFuture)).notifyFailed(throwable);
        }
    }
}

