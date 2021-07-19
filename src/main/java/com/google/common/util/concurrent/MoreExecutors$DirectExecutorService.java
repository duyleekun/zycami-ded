/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors$1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors$DirectExecutorService
extends AbstractListeningExecutorService {
    private final Object lock;
    private int runningTasks;
    private boolean shutdown;

    private MoreExecutors$DirectExecutorService() {
        Object object;
        this.lock = object = new Object();
        this.runningTasks = 0;
        this.shutdown = false;
    }

    public /* synthetic */ MoreExecutors$DirectExecutorService(MoreExecutors$1 moreExecutors$1) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void endTask() {
        Object object = this.lock;
        synchronized (object) {
            int n10;
            this.runningTasks = n10 = this.runningTasks + -1;
            if (n10 == 0) {
                Object object2 = this.lock;
                object2.notifyAll();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startTask() {
        Object object = this.lock;
        synchronized (object) {
            int n10 = this.shutdown;
            if (n10 == 0) {
                this.runningTasks = n10 = this.runningTasks + 1;
                return;
            }
            String string2 = "Executor already shutdown";
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(string2);
            throw rejectedExecutionException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean awaitTermination(long l10, TimeUnit object) {
        l10 = object.toNanos(l10);
        object = this.lock;
        synchronized (object) {
            int n10;
            while ((n10 = this.shutdown) == 0 || (n10 = this.runningTasks) != 0) {
                long l11 = 0L;
                long l12 = l10 - l11;
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    return false;
                }
                l11 = System.nanoTime();
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                Object object2 = this.lock;
                timeUnit.timedWait(object2, l10);
                long l13 = System.nanoTime() - l11;
                l10 -= l13;
            }
            return true;
        }
    }

    public void execute(Runnable runnable) {
        this.startTask();
        try {
            runnable.run();
            return;
        }
        finally {
            this.endTask();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isShutdown() {
        Object object = this.lock;
        synchronized (object) {
            return this.shutdown;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isTerminated() {
        Object object = this.lock;
        synchronized (object) {
            int n10 = this.shutdown;
            if (n10 == 0) return 0 != 0;
            n10 = this.runningTasks;
            if (n10 != 0) return 0 != 0;
            return 1 != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void shutdown() {
        Object object = this.lock;
        synchronized (object) {
            int n10;
            this.shutdown = n10 = 1;
            n10 = this.runningTasks;
            if (n10 == 0) {
                Object object2 = this.lock;
                object2.notifyAll();
            }
            return;
        }
    }

    public List shutdownNow() {
        this.shutdown();
        return Collections.emptyList();
    }
}

