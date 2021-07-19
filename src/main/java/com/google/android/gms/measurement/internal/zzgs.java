/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzgs
implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhn zzb;

    public zzgs(zzhn zzhn2, long l10) {
        this.zzb = zzhn2;
        this.zza = l10;
    }

    public final void run() {
        Object object = this.zzb.zzx.zzd().zzk;
        long l10 = this.zza;
        ((zzeu)object).zzb(l10);
        object = this.zzb.zzx.zzat().zzj();
        Long l11 = this.zza;
        ((zzeg)object).zzb("Session timeout duration set", l11);
    }
}

