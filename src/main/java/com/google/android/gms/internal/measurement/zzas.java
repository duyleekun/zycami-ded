/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzas
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzm zzd;
    public final /* synthetic */ zzbr zze;

    public zzas(zzbr zzbr2, String string2, String string3, boolean bl2, zzm zzm2) {
        this.zze = zzbr2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = bl2;
        this.zzd = zzm2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zze);
        String string2 = this.zza;
        String string3 = this.zzb;
        boolean bl2 = this.zzc;
        zzm zzm2 = this.zzd;
        zzp2.getUserProperties(string2, string3, bl2, zzm2);
    }

    public final void zzb() {
        this.zzd.zzb(null);
    }
}

