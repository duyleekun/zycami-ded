/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzf;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

public final class zzd
implements OnCanceledListener,
OnFailureListener,
OnSuccessListener,
zzr {
    private final Executor zza;
    private final Continuation zzb;
    private final zzu zzc;

    public zzd(Executor executor, Continuation continuation, zzu zzu2) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzu2;
    }

    public static /* synthetic */ Continuation zza(zzd zzd2) {
        return zzd2.zzb;
    }

    public static /* synthetic */ zzu zzb(zzd zzd2) {
        return zzd2.zzc;
    }

    public final void onCanceled() {
        this.zzc.zza();
    }

    public final void onFailure(Exception exception) {
        this.zzc.zza(exception);
    }

    public final void onSuccess(Object object) {
        this.zzc.zza(object);
    }

    public final void zza() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zza(Task task) {
        Executor executor = this.zza;
        zzf zzf2 = new zzf(this, task);
        executor.execute(zzf2);
    }
}

