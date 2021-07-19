/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzm;

public final class zzn
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzm zzb;

    public zzn(zzm zzm2, Task task) {
        this.zzb = zzm2;
        this.zza = task;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = zzm.zza(this.zzb);
        synchronized (object) {
            Object object2 = this.zzb;
            object2 = zzm.zzb((zzm)object2);
            if (object2 != null) {
                object2 = this.zzb;
                object2 = zzm.zzb((zzm)object2);
                Object object3 = this.zza;
                object3 = ((Task)object3).getResult();
                object2.onSuccess(object3);
            }
            return;
        }
    }
}

