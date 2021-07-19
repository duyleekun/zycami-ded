/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzjh;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzjf
implements Runnable {
    public final /* synthetic */ zzkd zza;
    public final /* synthetic */ Runnable zzb;

    public zzjf(zzjh zzjh2, zzkd zzkd2, Runnable runnable) {
        this.zza = zzkd2;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzK();
        zzkd zzkd2 = this.zza;
        Runnable runnable = this.zzb;
        zzkd2.zzJ(runnable);
        this.zza.zzF();
    }
}

