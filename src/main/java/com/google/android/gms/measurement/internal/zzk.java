/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzn;

public final class zzk
implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zzn2) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzn2;
    }

    public final void run() {
        zzhn zzhn2 = this.zzb.zza.zzk();
        zzn zzn2 = this.zza;
        zzhn2.zzI(zzn2);
    }
}

