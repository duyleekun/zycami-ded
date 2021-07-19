/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzjb;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgw
implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhn zzb;

    public zzgw(zzhn zzhn2, long l10) {
        this.zzb = zzhn2;
        this.zza = l10;
    }

    public final void run() {
        zzf zzf2 = this.zzb;
        long l10 = this.zza;
        ((zzhn)zzf2).zzG(l10, true);
        zzf2 = this.zzb.zzx.zzy();
        AtomicReference atomicReference = new AtomicReference();
        ((zzjb)zzf2).zzv(atomicReference);
    }
}

