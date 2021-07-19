/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.ConditionVariable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class RunnableFutureTask
implements RunnableFuture {
    private final Object cancelLock;
    private boolean canceled;
    private Exception exception;
    private final ConditionVariable finished;
    private Object result;
    private final ConditionVariable started;
    private Thread workThread;

    public RunnableFutureTask() {
        Object object = new ConditionVariable();
        this.started = object;
        object = new ConditionVariable();
        this.finished = object;
        this.cancelLock = object = new Object();
    }

    private Object getResult() {
        boolean bl2 = this.canceled;
        if (!bl2) {
            Exception exception = this.exception;
            if (exception == null) {
                return this.result;
            }
            Exception exception2 = this.exception;
            exception = new ExecutionException(exception2);
            throw exception;
        }
        CancellationException cancellationException = new CancellationException();
        throw cancellationException;
    }

    public final void blockUntilFinished() {
        this.finished.blockUninterruptible();
    }

    public final void blockUntilStarted() {
        this.started.blockUninterruptible();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean cancel(boolean bl2) {
        Object object = this.cancelLock;
        synchronized (object) {
            boolean bl3 = this.canceled;
            if (bl3) return false;
            ConditionVariable conditionVariable = this.finished;
            bl3 = conditionVariable.isOpen();
            if (!bl3) {
                this.canceled = bl3 = true;
                this.cancelWork();
                Thread thread = this.workThread;
                if (thread != null) {
                    if (!bl2) return bl3;
                    thread.interrupt();
                } else {
                    ConditionVariable conditionVariable2 = this.started;
                    conditionVariable2.open();
                    conditionVariable2 = this.finished;
                    conditionVariable2.open();
                }
                return bl3;
            }
            return false;
        }
    }

    public void cancelWork() {
    }

    public abstract Object doWork();

    public final Object get() {
        this.finished.block();
        return this.getResult();
    }

    public final Object get(long l10, TimeUnit object) {
        object = this.finished;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        boolean bl2 = ((ConditionVariable)object).block(l10 = timeUnit.convert(l10, (TimeUnit)((Object)object)));
        if (bl2) {
            return this.getResult();
        }
        TimeoutException timeoutException = new TimeoutException();
        throw timeoutException;
    }

    public final boolean isCancelled() {
        return this.canceled;
    }

    public final boolean isDone() {
        return this.finished.isOpen();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Throwable throwable222;
        block15: {
            Object object;
            Object object2 = this.cancelLock;
            synchronized (object2) {
                boolean bl2 = this.canceled;
                if (bl2) {
                    return;
                }
                object = Thread.currentThread();
                this.workThread = object;
            }
            this.started.open();
            object2 = null;
            this.result = object = this.doWork();
            object = this.cancelLock;
            {
                Object object3;
                catch (Throwable throwable222) {
                    break block15;
                }
                catch (Exception exception) {}
                {
                    this.exception = exception;
                    object3 = this.cancelLock;
                }
                synchronized (object3) {
                    ConditionVariable conditionVariable = this.finished;
                    conditionVariable.open();
                    this.workThread = null;
                    Thread.interrupted();
                    return;
                }
            }
            synchronized (object) {
                ConditionVariable conditionVariable = this.finished;
                conditionVariable.open();
                this.workThread = null;
                Thread.interrupted();
                return;
            }
        }
        Object object = this.cancelLock;
        synchronized (object) {
            ConditionVariable conditionVariable = this.finished;
            conditionVariable.open();
            this.workThread = null;
            Thread.interrupted();
            throw throwable222;
        }
    }
}

