/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzh
implements Runnable {
    public final /* synthetic */ zzs zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs2) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzs2;
    }

    public final void run() {
        zzjb zzjb2 = this.zzb.zza.zzy();
        zzs zzs2 = this.zza;
        zzjb2.zzx(zzs2);
    }
}

