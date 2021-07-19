/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzs;
import com.google.android.gms.tasks.zzu;

public class TaskCompletionSource {
    private final zzu zza;

    public TaskCompletionSource() {
        zzu zzu2;
        this.zza = zzu2 = new zzu();
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        Object object = new zzu();
        this.zza = object;
        object = new zzs(this);
        cancellationToken.onCanceledRequested((OnTokenCanceledListener)object);
    }

    public static /* synthetic */ zzu zza(TaskCompletionSource taskCompletionSource) {
        return taskCompletionSource.zza;
    }

    public Task getTask() {
        return this.zza;
    }

    public void setException(Exception exception) {
        this.zza.zza(exception);
    }

    public void setResult(Object object) {
        this.zza.zza(object);
    }

    public boolean trySetException(Exception exception) {
        return this.zza.zzb(exception);
    }

    public boolean trySetResult(Object object) {
        return this.zza.zzb(object);
    }
}

