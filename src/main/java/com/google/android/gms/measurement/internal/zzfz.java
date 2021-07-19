/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzp;

public final class zzfz
implements Runnable {
    public final /* synthetic */ zzkg zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzgd zzc;

    public zzfz(zzgd zzgd2, zzkg zzkg2, zzp zzp2) {
        this.zzc = zzgd2;
        this.zza = zzkg2;
        this.zzb = zzp2;
    }

    public final void run() {
        zzgd.zzw(this.zzc).zzK();
        Object object = this.zza.zza();
        if (object == null) {
            object = zzgd.zzw(this.zzc);
            zzkg zzkg2 = this.zza;
            zzp zzp2 = this.zzb;
            ((zzkd)object).zzO(zzkg2, zzp2);
            return;
        }
        object = zzgd.zzw(this.zzc);
        zzkg zzkg3 = this.zza;
        zzp zzp3 = this.zzb;
        ((zzkd)object).zzN(zzkg3, zzp3);
    }
}

