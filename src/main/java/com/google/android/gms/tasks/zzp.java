/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzo;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

public final class zzp
implements OnCanceledListener,
OnFailureListener,
OnSuccessListener,
zzr {
    private final Executor zza;
    private final SuccessContinuation zzb;
    private final zzu zzc;

    public zzp(Executor executor, SuccessContinuation successContinuation, zzu zzu2) {
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzu2;
    }

    public static /* synthetic */ SuccessContinuation zza(zzp zzp2) {
        return zzp2.zzb;
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
        zzo zzo2 = new zzo(this, task);
        executor.execute(zzo2);
    }
}

