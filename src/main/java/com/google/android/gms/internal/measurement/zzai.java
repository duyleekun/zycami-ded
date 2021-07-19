/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzai
extends zzbg {
    public final /* synthetic */ zzbr zza;

    public zzai(zzbr zzbr2) {
        this.zza = zzbr2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zza);
        long l10 = this.zzh;
        zzp2.resetAnalyticsData(l10);
    }
}

