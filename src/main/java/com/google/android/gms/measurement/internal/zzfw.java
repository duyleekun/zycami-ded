/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzp;

public final class zzfw
implements Runnable {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzgd zzc;

    public zzfw(zzgd zzgd2, zzas zzas2, zzp zzp2) {
        this.zzc = zzgd2;
        this.zza = zzas2;
        this.zzb = zzp2;
    }

    public final void run() {
        Object object = this.zzc;
        Object object2 = this.zza;
        zzp zzp2 = this.zzb;
        object = ((zzgd)object).zzb((zzas)object2, zzp2);
        zzgd.zzw(this.zzc).zzK();
        object2 = zzgd.zzw(this.zzc);
        zzp2 = this.zzb;
        ((zzkd)object2).zzB((zzas)object, zzp2);
    }
}

