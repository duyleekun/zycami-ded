/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzap
extends zzbg {
    public final /* synthetic */ zzm zza;
    public final /* synthetic */ zzbr zzb;

    public zzap(zzbr zzbr2, zzm zzm2) {
        this.zzb = zzbr2;
        this.zza = zzm2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        zzm zzm2 = this.zza;
        zzp2.generateEventId(zzm2);
    }

    public final void zzb() {
        this.zza.zzb(null);
    }
}

