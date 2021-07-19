/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzh;

public final class zzg
implements Runnable {
    private final /* synthetic */ zzh zza;

    public zzg(zzh zzh2) {
        this.zza = zzh2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = zzh.zza(this.zza);
        synchronized (object) {
            Object object2 = this.zza;
            object2 = zzh.zzb((zzh)object2);
            if (object2 != null) {
                object2 = this.zza;
                object2 = zzh.zzb((zzh)object2);
                object2.onCanceled();
            }
            return;
        }
    }
}

