/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.c1.a;
import e.a.s0.b;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractDirectTask
extends AtomicReference
implements b,
a {
    public static final FutureTask DISPOSED;
    public static final FutureTask FINISHED;
    private static final long serialVersionUID = 1811839108042568751L;
    public final Runnable runnable;
    public Thread runner;

    static {
        FutureTask<Object> futureTask;
        Runnable runnable = Functions.b;
        FINISHED = futureTask = new FutureTask<Object>(runnable, null);
        DISPOSED = futureTask = new FutureTask<Object>(runnable, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    public final void dispose() {
        boolean bl2;
        Runnable runnable;
        Future future = (Future)this.get();
        if (future != (runnable = FINISHED) && future != (runnable = DISPOSED) && (bl2 = this.compareAndSet(future, runnable)) && future != null) {
            runnable = this.runner;
            Thread thread = Thread.currentThread();
            if (runnable != thread) {
                bl2 = true;
            } else {
                bl2 = false;
                runnable = null;
            }
            future.cancel(bl2);
        }
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    public final boolean isDisposed() {
        boolean bl2;
        FutureTask futureTask;
        Future future = (Future)this.get();
        if (future != (futureTask = FINISHED) && future != (futureTask = DISPOSED)) {
            bl2 = false;
            future = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final void setFuture(Future future) {
        Runnable runnable;
        Object object;
        while ((object = (Future)this.get()) != (runnable = FINISHED)) {
            boolean bl2;
            runnable = DISPOSED;
            if (object == runnable) {
                object = this.runner;
                runnable = Thread.currentThread();
                if (object != runnable) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    object = null;
                }
                future.cancel(bl2);
                break;
            }
            bl2 = this.compareAndSet(object, future);
            if (!bl2) continue;
        }
    }
}

