/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzr;
import java.util.concurrent.Executor;

public final class zzi
implements zzr {
    private final Executor zza;
    private final Object zzb;
    private OnCompleteListener zzc;

    public zzi(Executor executor, OnCompleteListener onCompleteListener) {
        Object object;
        this.zzb = object = new Object();
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public static /* synthetic */ Object zza(zzi zzi2) {
        return zzi2.zzb;
    }

    public static /* synthetic */ OnCompleteListener zzb(zzi zzi2) {
        return zzi2.zzc;
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
        Object object2 = this.zzb;
        synchronized (object2) {
            object = this.zzc;
            if (object == null) {
                return;
            }
        }
        object2 = this.zza;
        object = new zzj(this, task);
        object2.execute((Runnable)object);
    }
}

