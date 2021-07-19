/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$1;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$2;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$3;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker$4;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsBackgroundWorker {
    private final Executor executor;
    private final ThreadLocal isExecutorThread;
    private Task tail;
    private final Object tailLock;

    public CrashlyticsBackgroundWorker(Executor executor) {
        Object object = Tasks.forResult(null);
        this.tail = object;
        this.tailLock = object = new Object();
        object = new ThreadLocal();
        this.isExecutorThread = object;
        this.executor = executor;
        object = new CrashlyticsBackgroundWorker$1(this);
        executor.execute((Runnable)object);
    }

    public static /* synthetic */ ThreadLocal access$000(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        return crashlyticsBackgroundWorker.isExecutorThread;
    }

    private Task ignoreResult(Task task) {
        Executor executor = this.executor;
        CrashlyticsBackgroundWorker$4 crashlyticsBackgroundWorker$4 = new CrashlyticsBackgroundWorker$4(this);
        return task.continueWith(executor, crashlyticsBackgroundWorker$4);
    }

    private boolean isRunningOnThread() {
        Boolean bl2 = Boolean.TRUE;
        Object t10 = this.isExecutorThread.get();
        return bl2.equals(t10);
    }

    private Continuation newContinuation(Callable callable) {
        CrashlyticsBackgroundWorker$3 crashlyticsBackgroundWorker$3 = new CrashlyticsBackgroundWorker$3(this, callable);
        return crashlyticsBackgroundWorker$3;
    }

    public void checkRunningOnThread() {
        boolean bl2 = this.isRunningOnThread();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not running on background worker thread as intended.");
        throw illegalStateException;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public Task submit(Runnable runnable) {
        CrashlyticsBackgroundWorker$2 crashlyticsBackgroundWorker$2 = new CrashlyticsBackgroundWorker$2(this, runnable);
        return this.submit(crashlyticsBackgroundWorker$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Task submit(Callable object) {
        Object object2 = this.tailLock;
        synchronized (object2) {
            Task task = this.tail;
            Executor executor = this.executor;
            object = this.newContinuation((Callable)object);
            object = task.continueWith(executor, (Continuation)object);
            this.tail = task = this.ignoreResult((Task)object);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Task submitTask(Callable object) {
        Object object2 = this.tailLock;
        synchronized (object2) {
            Task task = this.tail;
            Executor executor = this.executor;
            object = this.newContinuation((Callable)object);
            object = task.continueWithTask(executor, (Continuation)object);
            this.tail = task = this.ignoreResult((Task)object);
            return object;
        }
    }
}

