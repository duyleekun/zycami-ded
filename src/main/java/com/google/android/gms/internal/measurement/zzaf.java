/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;

public final class zzaf
extends zzbg {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzbr zzb;

    public zzaf(zzbr zzbr2, Boolean bl2) {
        this.zzb = zzbr2;
        this.zza = bl2;
        super(zzbr2, true);
    }

    public final void zza() {
        Object object = this.zza;
        if (object != null) {
            object = zzbr.zzR(this.zzb);
            boolean bl2 = this.zza;
            long l10 = this.zzh;
            object.setMeasurementEnabled(bl2, l10);
            return;
        }
        object = zzbr.zzR(this.zzb);
        long l11 = this.zzh;
        object.clearMeasurementEnabled(l11);
    }
}

