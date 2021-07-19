/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzad
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbr zzb;

    public zzad(zzbr zzbr2, String string2) {
        this.zzb = zzbr2;
        this.zza = string2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        String string2 = this.zza;
        long l10 = this.zzh;
        zzp2.setUserId(string2, l10);
    }
}

