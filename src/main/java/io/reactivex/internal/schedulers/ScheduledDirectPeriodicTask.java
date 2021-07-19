/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.a1.a;
import io.reactivex.internal.schedulers.AbstractDirectTask;

public final class ScheduledDirectPeriodicTask
extends AbstractDirectTask
implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        Runnable runnable;
        this.runner = runnable = Thread.currentThread();
        runnable = null;
        Runnable runnable2 = this.runnable;
        runnable2.run();
        try {
            this.runner = null;
        }
        catch (Throwable throwable) {
            this.runner = null;
            runnable = AbstractDirectTask.FINISHED;
            this.lazySet(runnable);
            a.Y(throwable);
        }
    }
}

