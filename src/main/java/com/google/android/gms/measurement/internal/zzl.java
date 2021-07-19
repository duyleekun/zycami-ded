/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzl
implements Runnable {
    public final /* synthetic */ zzs zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs2, String string2, String string3) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzs2;
        this.zzb = string2;
        this.zzc = string3;
    }

    public final void run() {
        zzjb zzjb2 = this.zzd.zza.zzy();
        zzs zzs2 = this.zza;
        String string2 = this.zzb;
        String string3 = this.zzc;
        zzjb2.zzo(zzs2, string2, string3);
    }
}

