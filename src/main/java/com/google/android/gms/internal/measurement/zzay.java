/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzay
extends zzbg {
    public final /* synthetic */ zzm zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzbr zzc;

    public zzay(zzbr zzbr2, zzm zzm2, int n10) {
        this.zzc = zzbr2;
        this.zza = zzm2;
        this.zzb = n10;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzc);
        zzm zzm2 = this.zza;
        int n10 = this.zzb;
        zzp2.getTestFlag(zzm2, n10);
    }

    public final void zzb() {
        this.zza.zzb(null);
    }
}

