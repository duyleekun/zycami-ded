/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzd;

public final class zzb
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public zzb(zzd zzd2, String string2, long l10) {
        this.zzc = zzd2;
        this.zza = string2;
        this.zzb = l10;
    }

    public final void run() {
        zzd zzd2 = this.zzc;
        String string2 = this.zza;
        long l10 = this.zzb;
        zzd.zze(zzd2, string2, l10);
    }
}

