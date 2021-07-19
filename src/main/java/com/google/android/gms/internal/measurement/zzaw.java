/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzaw
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzm zzb;
    public final /* synthetic */ zzbr zzc;

    public zzaw(zzbr zzbr2, String string2, zzm zzm2) {
        this.zzc = zzbr2;
        this.zza = string2;
        this.zzb = zzm2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzc);
        String string2 = this.zza;
        zzm zzm2 = this.zzb;
        zzp2.getMaxUserProperties(string2, zzm2);
    }

    public final void zzb() {
        this.zzb.zzb(null);
    }
}

