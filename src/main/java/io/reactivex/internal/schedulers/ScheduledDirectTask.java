/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.AbstractDirectTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class ScheduledDirectTask
extends AbstractDirectTask
implements Callable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    public Void call() {
        Thread thread;
        this.runner = thread = Thread.currentThread();
        thread = null;
        try {
            Runnable runnable = this.runnable;
            runnable.run();
            return null;
        }
        finally {
            FutureTask futureTask = AbstractDirectTask.FINISHED;
            this.lazySet(futureTask);
            this.runner = null;
        }
    }
}

