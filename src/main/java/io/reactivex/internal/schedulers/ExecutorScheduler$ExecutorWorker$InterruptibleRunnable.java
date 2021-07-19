/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.s0.b;
import e.a.w0.a.a;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExecutorScheduler$ExecutorWorker$InterruptibleRunnable
extends AtomicInteger
implements Runnable,
b {
    public static final int FINISHED = 2;
    public static final int INTERRUPTED = 4;
    public static final int INTERRUPTING = 3;
    public static final int READY = 0;
    public static final int RUNNING = 1;
    private static final long serialVersionUID = -3603436687413320876L;
    public final Runnable run;
    public final a tasks;
    public volatile Thread thread;

    public ExecutorScheduler$ExecutorWorker$InterruptibleRunnable(Runnable runnable, a a10) {
        this.run = runnable;
        this.tasks = a10;
    }

    public void cleanup() {
        a a10 = this.tasks;
        if (a10 != null) {
            a10.c(this);
        }
    }

    public void dispose() {
        int n10;
        int n11;
        while ((n11 = this.get()) < (n10 = 2)) {
            Thread thread;
            n10 = 4;
            if (n11 == 0) {
                thread = null;
                n11 = (int)(this.compareAndSet(0, n10) ? 1 : 0);
                if (n11 == 0) continue;
                this.cleanup();
                break;
            }
            int n12 = 3;
            n11 = (int)(this.compareAndSet(1, n12) ? 1 : 0);
            if (n11 == 0) continue;
            thread = this.thread;
            if (thread != null) {
                thread.interrupt();
                n11 = 0;
                thread = null;
                this.thread = null;
            }
            this.set(n10);
            this.cleanup();
            break;
        }
    }

    public boolean isDisposed() {
        int n10;
        int n11 = this.get();
        n11 = n11 >= (n10 = 2) ? 1 : 0;
        return n11 != 0;
    }

    public void run() {
        block9: {
            block10: {
                Thread thread;
                int n10 = this.get();
                if (n10 != 0) break block9;
                this.thread = thread = Thread.currentThread();
                thread = null;
                int n11 = 1;
                n10 = (int)(this.compareAndSet(0, n11) ? 1 : 0);
                if (n10 == 0) break block10;
                n10 = 3;
                int n12 = 2;
                Runnable runnable = this.run;
                try {
                    runnable.run();
                    this.thread = null;
                }
                catch (Throwable throwable) {
                    this.thread = null;
                    n11 = (int)(this.compareAndSet(n11, n12) ? 1 : 0);
                    if (n11 == 0) {
                        while ((n11 = this.get()) == n10) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } else {
                        this.cleanup();
                    }
                    throw throwable;
                }
                n11 = (int)(this.compareAndSet(n11, n12) ? 1 : 0);
                if (n11 != 0) {
                    this.cleanup();
                } else {
                    while ((n11 = this.get()) == n10) {
                        Thread.yield();
                    }
                    Thread.interrupted();
                }
                break block9;
            }
            this.thread = null;
        }
    }
}

