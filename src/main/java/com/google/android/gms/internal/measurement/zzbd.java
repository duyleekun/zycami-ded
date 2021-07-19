/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbi;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzbd
extends zzbg {
    public final /* synthetic */ zzbi zza;
    public final /* synthetic */ zzbr zzb;

    public zzbd(zzbr zzbr2, zzbi zzbi2) {
        this.zzb = zzbr2;
        this.zza = zzbi2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        zzbi zzbi2 = this.zza;
        zzp2.unregisterOnMeasurementEventListener(zzbi2);
    }
}

