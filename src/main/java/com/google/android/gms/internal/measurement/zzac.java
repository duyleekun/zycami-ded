/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzac
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzm zzc;
    public final /* synthetic */ zzbr zzd;

    public zzac(zzbr zzbr2, String string2, String string3, zzm zzm2) {
        this.zzd = zzbr2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = zzm2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzd);
        String string2 = this.zza;
        String string3 = this.zzb;
        zzm zzm2 = this.zzc;
        zzp2.getConditionalUserProperties(string2, string3, zzm2);
    }

    public final void zzb() {
        this.zzc.zzb(null);
    }
}

