/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzke;

public final class zzjw
implements Runnable {
    public final /* synthetic */ zzke zza;
    public final /* synthetic */ zzkd zzb;

    public zzjw(zzkd zzkd2, zzke zzke2) {
        this.zzb = zzkd2;
        this.zza = zzke2;
    }

    public final void run() {
        zzkd zzkd2 = this.zzb;
        zzke zzke2 = this.zza;
        zzkd.zzaa(zzkd2, zzke2);
        this.zzb.zzc();
    }
}

