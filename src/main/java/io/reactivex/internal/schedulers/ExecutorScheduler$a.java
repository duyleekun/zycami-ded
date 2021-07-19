/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler$DelayedRunnable;

public final class ExecutorScheduler$a
implements Runnable {
    private final ExecutorScheduler$DelayedRunnable a;
    public final /* synthetic */ ExecutorScheduler b;

    public ExecutorScheduler$a(ExecutorScheduler executorScheduler, ExecutorScheduler$DelayedRunnable delayedRunnable) {
        this.b = executorScheduler;
        this.a = delayedRunnable;
    }

    public void run() {
        b b10 = this.a;
        SequentialDisposable sequentialDisposable = b10.direct;
        b10 = this.b.e((Runnable)((Object)b10));
        sequentialDisposable.replace(b10);
    }
}

