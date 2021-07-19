/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExecutorScheduler$ExecutorWorker$BooleanRunnable
extends AtomicBoolean
implements Runnable,
b {
    private static final long serialVersionUID = -2421395018820541164L;
    public final Runnable actual;

    public ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    public void dispose() {
        this.lazySet(true);
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void run() {
        boolean bl2 = this.get();
        if (bl2) {
            return;
        }
        bl2 = true;
        try {
            Runnable runnable = this.actual;
            runnable.run();
            return;
        }
        finally {
            this.lazySet(bl2);
        }
    }
}

