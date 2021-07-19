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
import com.google.android.gms.tasks.zzp;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class zzo
implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzp zzb;

    public zzo(zzp zzp2, Task task) {
        this.zzb = zzp2;
        this.zza = task;
    }

    public final void run() {
        Object object;
        Object object2;
        block9: {
            object2 = this.zzb;
            object2 = zzp.zza((zzp)object2);
            object = this.zza;
            object = ((Task)object).getResult();
            try {
                object2 = object2.then(object);
                if (object2 != null) break block9;
                object2 = this.zzb;
            }
            catch (Exception exception) {
                this.zzb.onFailure(exception);
                return;
            }
            catch (CancellationException cancellationException) {
                this.zzb.onCanceled();
                return;
            }
            catch (RuntimeExecutionException runtimeExecutionException) {
                object = runtimeExecutionException.getCause();
                boolean bl2 = object instanceof Exception;
                if (bl2) {
                    object = this.zzb;
                    Exception exception = (Exception)runtimeExecutionException.getCause();
                    ((zzp)object).onFailure(exception);
                    return;
                }
                this.zzb.onFailure(runtimeExecutionException);
                return;
            }
            object = new NullPointerException("Continuation returned null");
            ((zzp)object2).onFailure((Exception)object);
            return;
        }
        object = TaskExecutors.zza;
        zzp zzp2 = this.zzb;
        ((Task)object2).addOnSuccessListener((Executor)object, (OnSuccessListener)zzp2);
        zzp2 = this.zzb;
        ((Task)object2).addOnFailureListener((Executor)object, (OnFailureListener)zzp2);
        zzp2 = this.zzb;
        ((Task)object2).addOnCanceledListener((Executor)object, (OnCanceledListener)zzp2);
        return;
    }
}

