/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzk;
import com.google.android.gms.tasks.zzr;
import java.util.concurrent.Executor;

public final class zzl
implements zzr {
    private final Executor zza;
    private final Object zzb;
    private OnFailureListener zzc;

    public zzl(Executor executor, OnFailureListener onFailureListener) {
        Object object;
        this.zzb = object = new Object();
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public static /* synthetic */ Object zza(zzl zzl2) {
        return zzl2.zzb;
    }

    public static /* synthetic */ OnFailureListener zzb(zzl zzl2) {
        return zzl2.zzc;
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
        if (bl2) return;
        bl2 = task.isCanceled();
        if (bl2) return;
        Object object2 = this.zzb;
        synchronized (object2) {
            object = this.zzc;
            if (object == null) {
                return;
            }
        }
        object2 = this.zza;
        object = new zzk(this, task);
        object2.execute((Runnable)object);
    }
}

