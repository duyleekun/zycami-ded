/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import com.google.mlkit.common.sdkinternal.zzk;
import com.google.mlkit.common.sdkinternal.zzl;
import com.google.mlkit.common.sdkinternal.zzm;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ModelResource {
    public final TaskQueue taskQueue;
    private final AtomicInteger zza;
    private final AtomicBoolean zzb;

    public ModelResource() {
        Object object = new AtomicInteger(0);
        this.zza = object;
        this.taskQueue = object = new TaskQueue();
        this.zzb = object = new AtomicBoolean(false);
    }

    public Task callAfterLoad(Executor object, Callable callable, CancellationToken cancellationToken) {
        zzl zzl2;
        Object object2 = this.zza;
        int n10 = ((AtomicInteger)object2).get();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        Preconditions.checkState(n10 != 0);
        n10 = cancellationToken.isCancellationRequested();
        if (n10) {
            return Tasks.forCanceled();
        }
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        object2 = cancellationTokenSource.getToken();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource((CancellationToken)object2);
        zzm zzm2 = new zzm((Executor)object, cancellationToken, cancellationTokenSource, taskCompletionSource);
        object = this.taskQueue;
        object2 = zzl2;
        zzl2 = new zzl(this, cancellationToken, cancellationTokenSource, callable, taskCompletionSource);
        ((TaskQueue)object).submit(zzm2, zzl2);
        return taskCompletionSource.getTask();
    }

    public boolean isLoaded() {
        return this.zzb.get();
    }

    public abstract void load();

    public void pin() {
        this.zza.incrementAndGet();
    }

    public abstract void release();

    public void unpin(Executor executor) {
        Object object = this.zza;
        int n10 = ((AtomicInteger)object).get();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        Preconditions.checkState(n10 != 0);
        object = this.taskQueue;
        zzk zzk2 = new zzk(this);
        ((TaskQueue)object).submit(executor, zzk2);
    }

    public final /* synthetic */ void zza() {
        Serializable serializable = this.zza;
        int n10 = ((AtomicInteger)serializable).decrementAndGet();
        boolean bl2 = n10 >= 0;
        Preconditions.checkState(bl2);
        if (n10 == 0) {
            this.release();
            serializable = this.zzb;
            ((AtomicBoolean)serializable).set(false);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void zza(CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, Callable callable, TaskCompletionSource taskCompletionSource) {
        boolean bl2 = cancellationToken.isCancellationRequested();
        if (bl2) {
            cancellationTokenSource.cancel();
            return;
        }
        try {
            try {
                AtomicBoolean atomicBoolean = this.zzb;
                bl2 = atomicBoolean.get();
                if (!bl2) {
                    this.load();
                    atomicBoolean = this.zzb;
                    boolean bl3 = true;
                    atomicBoolean.set(bl3);
                }
                if (bl2 = cancellationToken.isCancellationRequested()) {
                    cancellationTokenSource.cancel();
                    return;
                }
                callable = callable.call();
            }
            catch (RuntimeException runtimeException) {
                String string2 = "Internal error has occurred when executing ML Kit tasks";
                int n10 = 13;
                MlKitException mlKitException = new MlKitException(string2, n10, runtimeException);
                throw mlKitException;
            }
            bl2 = cancellationToken.isCancellationRequested();
            if (bl2) {
                cancellationTokenSource.cancel();
                return;
            }
            taskCompletionSource.setResult(callable);
            return;
        }
        catch (Exception exception) {}
        boolean bl4 = cancellationToken.isCancellationRequested();
        if (bl4) {
            cancellationTokenSource.cancel();
            return;
        }
        taskCompletionSource.setException(exception);
    }
}

