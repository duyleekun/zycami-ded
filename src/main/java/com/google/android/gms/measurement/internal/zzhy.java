/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzib;

public final class zzhy
implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzib zzb;

    public zzhy(zzib zzib2, long l10) {
        this.zzb = zzib2;
        this.zza = l10;
    }

    public final void run() {
        zzd zzd2 = this.zzb.zzx.zzB();
        long l10 = this.zza;
        zzd2.zzc(l10);
        this.zzb.zza = null;
    }
}

