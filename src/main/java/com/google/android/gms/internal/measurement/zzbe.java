/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzbe
extends zzbg {
    public final /* synthetic */ Long zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ zzbr zzg;

    public zzbe(zzbr zzbr2, Long l10, String string2, String string3, Bundle bundle, boolean bl2, boolean bl3) {
        this.zzg = zzbr2;
        this.zza = l10;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = bundle;
        this.zze = bl2;
        this.zzf = bl3;
        super(zzbr2, true);
    }

    public final void zza() {
        Long l10 = this.zza;
        long l11 = l10 == null ? this.zzh : l10;
        zzp zzp2 = zzbr.zzR(this.zzg);
        String string2 = this.zzb;
        String string3 = this.zzc;
        Bundle bundle = this.zzd;
        boolean bl2 = this.zze;
        boolean bl3 = this.zzf;
        zzp2.logEvent(string2, string3, bundle, bl2, bl3, l11);
    }
}

