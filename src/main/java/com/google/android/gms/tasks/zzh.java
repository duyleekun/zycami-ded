/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzr;
import java.util.concurrent.Executor;

public final class zzh
implements zzr {
    private final Executor zza;
    private final Object zzb;
    private OnCanceledListener zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        Object object;
        this.zzb = object = new Object();
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    public static /* synthetic */ Object zza(zzh zzh2) {
        return zzh2.zzb;
    }

    public static /* synthetic */ OnCanceledListener zzb(zzh zzh2) {
        return zzh2.zzc;
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
    public final void zza(Task object) {
        Object object2;
        boolean bl2 = ((Task)object).isCanceled();
        if (!bl2) return;
        object = this.zzb;
        synchronized (object) {
            object2 = this.zzc;
            if (object2 == null) {
                return;
            }
        }
        object = this.zza;
        object2 = new zzg(this);
        object.execute((Runnable)object2);
    }
}

