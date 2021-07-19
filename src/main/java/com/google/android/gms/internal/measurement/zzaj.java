/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzaj
extends zzbg {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzbr zzb;

    public zzaj(zzbr zzbr2, long l10) {
        this.zzb = zzbr2;
        this.zza = l10;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        long l10 = this.zza;
        zzp2.setSessionTimeoutDuration(l10);
    }
}

