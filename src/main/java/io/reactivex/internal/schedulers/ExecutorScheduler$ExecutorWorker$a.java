/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker;

public final class ExecutorScheduler$ExecutorWorker$a
implements Runnable {
    private final SequentialDisposable a;
    private final Runnable b;
    public final /* synthetic */ ExecutorScheduler$ExecutorWorker c;

    public ExecutorScheduler$ExecutorWorker$a(ExecutorScheduler$ExecutorWorker executorWorker, SequentialDisposable sequentialDisposable, Runnable runnable) {
        this.c = executorWorker;
        this.a = sequentialDisposable;
        this.b = runnable;
    }

    public void run() {
        SequentialDisposable sequentialDisposable = this.a;
        b b10 = this.c;
        Runnable runnable = this.b;
        b10 = b10.b(runnable);
        sequentialDisposable.replace(b10);
    }
}

