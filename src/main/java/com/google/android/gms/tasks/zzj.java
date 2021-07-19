/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzi;

public final class zzj
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzi zzb;

    public zzj(zzi zzi2, Task task) {
        this.zzb = zzi2;
        this.zza = task;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = zzi.zza(this.zzb);
        synchronized (object) {
            Object object2 = this.zzb;
            object2 = zzi.zzb((zzi)object2);
            if (object2 != null) {
                object2 = this.zzb;
                object2 = zzi.zzb((zzi)object2);
                Task task = this.zza;
                object2.onComplete(task);
            }
            return;
        }
    }
}

