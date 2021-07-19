/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzd;

public final class zzc
implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzd zzb;

    public zzc(zzd zzd2, long l10) {
        this.zzb = zzd2;
        this.zza = l10;
    }

    public final void run() {
        zzd zzd2 = this.zzb;
        long l10 = this.zza;
        zzd.zzf(zzd2, l10);
    }
}

