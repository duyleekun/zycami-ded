/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzn;
import com.google.android.gms.tasks.zzr;
import java.util.concurrent.Executor;

public final class zzm
implements zzr {
    private final Executor zza;
    private final Object zzb;
    private OnSuccessListener zzc;

    public zzm(Executor executor, OnSuccessListener onSuccessListener) {
        Object object;
        this.zzb = object = new Object();
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public static /* synthetic */ Object zza(zzm zzm2) {
        return zzm2.zzb;
    }

    public static /* synthetic */ OnSuccessListener zzb(zzm zzm2) {
        return zzm2.zzc;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza() {
        Object object = this.zzb;
        synchronized (object) {
            Object var2_2 = null;
            this.zzc = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Task task) {
        Object object;
        boolean bl2 = task.isSuccessful();
        if (!bl2) return;
        Object object2 = this.zzb;
        synchronized (object2) {
            object = this.zzc;
            if (object == null) {
                return;
            }
        }
        object2 = this.zza;
        object = new zzn(this, task);
        object2.execute((Runnable)object);
    }
}

