/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.TaskQueue$zzb;
import com.google.mlkit.common.sdkinternal.zzp;
import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class TaskQueue {
    private final Object zza;
    private boolean zzb;
    private final Queue zzc;
    private final AtomicReference zzd;

    public TaskQueue() {
        Serializable serializable = new Serializable();
        this.zza = serializable;
        this.zzc = serializable = new Serializable();
        this.zzd = serializable;
    }

    public static /* synthetic */ AtomicReference zza(TaskQueue taskQueue) {
        return taskQueue.zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zza() {
        Object object;
        Object object2 = this.zza;
        synchronized (object2) {
            object = this.zzc;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                bl2 = false;
                object = null;
                this.zzb = false;
                return;
            }
            object = this.zzc;
            object = object.remove();
            object = (TaskQueue$zzb)object;
        }
        object2 = ((TaskQueue$zzb)object).zza;
        object = ((TaskQueue$zzb)object).zzb;
        this.zza((Executor)object2, (Runnable)object);
    }

    private final void zza(Executor executor, Runnable runnable) {
        zzp zzp2 = new zzp(this, runnable);
        try {
            executor.execute(zzp2);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.zza();
            return;
        }
    }

    public static /* synthetic */ void zzb(TaskQueue taskQueue) {
        taskQueue.zza();
    }

    public void checkIsRunningOnCurrentThread() {
        Thread thread = Thread.currentThread();
        Object v10 = this.zzd.get();
        Preconditions.checkState(thread.equals(v10));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void submit(Executor executor, Runnable runnable) {
        Object object = this.zza;
        synchronized (object) {
            boolean bl2 = this.zzb;
            if (bl2) {
                Queue queue = this.zzc;
                TaskQueue$zzb taskQueue$zzb = new TaskQueue$zzb(executor, runnable, null);
                queue.add(taskQueue$zzb);
                return;
            }
            this.zzb = bl2 = true;
        }
        this.zza(executor, runnable);
    }
}

