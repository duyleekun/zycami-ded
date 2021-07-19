/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzfo
implements Runnable {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ zzgd zzb;

    public zzfo(zzgd zzgd2, zzaa zzaa2) {
        this.zzb = zzgd2;
        this.zza = zzaa2;
    }

    public final void run() {
        zzgd.zzw(this.zzb).zzK();
        Object object = this.zza.zzc.zza();
        if (object == null) {
            object = zzgd.zzw(this.zzb);
            zzaa zzaa2 = this.zza;
            ((zzkd)object).zzV(zzaa2);
            return;
        }
        object = zzgd.zzw(this.zzb);
        zzaa zzaa3 = this.zza;
        ((zzkd)object).zzT(zzaa3);
    }
}

