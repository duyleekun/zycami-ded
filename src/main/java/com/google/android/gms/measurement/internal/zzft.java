/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzp;

public final class zzft
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzgd zzb;

    public zzft(zzgd zzgd2, zzp zzp2) {
        this.zzb = zzgd2;
        this.zza = zzp2;
    }

    public final void run() {
        zzgd.zzw(this.zzb).zzK();
        zzkd zzkd2 = zzgd.zzw(this.zzb);
        zzp zzp2 = this.zza;
        zzkd2.zzM(zzp2);
    }
}

