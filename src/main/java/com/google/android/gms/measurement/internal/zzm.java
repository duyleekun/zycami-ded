/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzm
implements Runnable {
    public final /* synthetic */ zzs zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs2) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzs2;
    }

    public final void run() {
        zzkk zzkk2 = this.zzb.zza.zzl();
        zzs zzs2 = this.zza;
        boolean bl2 = this.zzb.zza.zzE();
        zzkk2.zzah(zzs2, bl2);
    }
}

