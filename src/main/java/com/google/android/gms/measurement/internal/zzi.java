/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzi
implements Runnable {
    public final /* synthetic */ zzs zza;
    public final /* synthetic */ zzas zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzs2, zzas zzas2, String string2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzs2;
        this.zzb = zzas2;
        this.zzc = string2;
    }

    public final void run() {
        zzjb zzjb2 = this.zzd.zza.zzy();
        zzs zzs2 = this.zza;
        zzas zzas2 = this.zzb;
        String string2 = this.zzc;
        zzjb2.zzG(zzs2, zzas2, string2);
    }
}

