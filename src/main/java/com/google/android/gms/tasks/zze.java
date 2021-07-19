/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzc;
import com.google.android.gms.tasks.zzu;

public final class zze
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzc zzb;

    public zze(zzc zzc2, Task task) {
        this.zzb = zzc2;
        this.zza = task;
    }

    public final void run() {
        Object object = this.zza;
        boolean bl2 = ((Task)object).isCanceled();
        if (bl2) {
            zzc.zza(this.zzb).zza();
            return;
        }
        object = this.zzb;
        object = zzc.zzb((zzc)object);
        Object object2 = this.zza;
        try {
            object = object.then((Task)object2);
        }
        catch (Exception exception) {
            zzc.zza(this.zzb).zza(exception);
            return;
        }
        catch (RuntimeExecutionException runtimeExecutionException) {
            object2 = runtimeExecutionException.getCause();
            boolean bl3 = object2 instanceof Exception;
            if (bl3) {
                object2 = zzc.zza(this.zzb);
                Exception exception = (Exception)runtimeExecutionException.getCause();
                ((zzu)object2).zza(exception);
                return;
            }
            zzc.zza(this.zzb).zza(runtimeExecutionException);
            return;
        }
        zzc.zza(this.zzb).zza(object);
        return;
    }
}

