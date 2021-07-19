/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzl;

public final class zzk
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzl zzb;

    public zzk(zzl zzl2, Task task) {
        this.zzb = zzl2;
        this.zza = task;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = zzl.zza(this.zzb);
        synchronized (object) {
            Object object2 = this.zzb;
            object2 = zzl.zzb((zzl)object2);
            if (object2 != null) {
                object2 = this.zzb;
                object2 = zzl.zzb((zzl)object2);
                Object object3 = this.zza;
                object3 = ((Task)object3).getException();
                object2.onFailure((Exception)object3);
            }
            return;
        }
    }
}

