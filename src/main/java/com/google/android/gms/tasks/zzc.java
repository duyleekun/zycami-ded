/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zze;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

public final class zzc
implements zzr {
    private final Executor zza;
    private final Continuation zzb;
    private final zzu zzc;

    public zzc(Executor executor, Continuation continuation, zzu zzu2) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzu2;
    }

    public static /* synthetic */ zzu zza(zzc zzc2) {
        return zzc2.zzc;
    }

    public static /* synthetic */ Continuation zzb(zzc zzc2) {
        return zzc2.zzb;
    }

    public final void zza() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zza(Task task) {
        Executor executor = this.zza;
        zze zze2 = new zze(this, task);
        executor.execute(zze2);
    }
}

