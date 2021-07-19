/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzd;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

public final class zzf
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzd zzb;

    public zzf(zzd zzd2, Task task) {
        this.zzb = zzd2;
        this.zza = task;
    }

    public final void run() {
        Object object;
        Object object2;
        block8: {
            object2 = this.zzb;
            object2 = zzd.zza((zzd)object2);
            object = this.zza;
            object2 = object2.then((Task)object);
            try {
                object2 = (Task)object2;
                if (object2 != null) break block8;
                object2 = this.zzb;
            }
            catch (Exception exception) {
                zzd.zzb(this.zzb).zza(exception);
                return;
            }
            catch (RuntimeExecutionException runtimeExecutionException) {
                object = runtimeExecutionException.getCause();
                boolean bl2 = object instanceof Exception;
                if (bl2) {
                    object = zzd.zzb(this.zzb);
                    Exception exception = (Exception)runtimeExecutionException.getCause();
                    ((zzu)object).zza(exception);
                    return;
                }
                zzd.zzb(this.zzb).zza(runtimeExecutionException);
                return;
            }
            object = new NullPointerException("Continuation returned null");
            ((zzd)object2).onFailure((Exception)object);
            return;
        }
        object = TaskExecutors.zza;
        zzd zzd2 = this.zzb;
        ((Task)object2).addOnSuccessListener((Executor)object, (OnSuccessListener)zzd2);
        zzd2 = this.zzb;
        ((Task)object2).addOnFailureListener((Executor)object, (OnFailureListener)zzd2);
        zzd2 = this.zzb;
        ((Task)object2).addOnCanceledListener((Executor)object, (OnCanceledListener)zzd2);
        return;
    }
}

