/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzp;

public final class zzfn
implements Runnable {
    public final /* synthetic */ zzaa zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzgd zzc;

    public zzfn(zzgd zzgd2, zzaa zzaa2, zzp zzp2) {
        this.zzc = zzgd2;
        this.zza = zzaa2;
        this.zzb = zzp2;
    }

    public final void run() {
        zzgd.zzw(this.zzc).zzK();
        Object object = this.zza.zzc.zza();
        if (object == null) {
            object = zzgd.zzw(this.zzc);
            zzaa zzaa2 = this.zza;
            zzp zzp2 = this.zzb;
            ((zzkd)object).zzW(zzaa2, zzp2);
            return;
        }
        object = zzgd.zzw(this.zzc);
        zzaa zzaa3 = this.zza;
        zzp zzp3 = this.zzb;
        ((zzkd)object).zzU(zzaa3, zzp3);
    }
}

