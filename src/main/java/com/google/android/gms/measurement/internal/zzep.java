/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzeq;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzep
implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzeq zzb;

    public zzep(zzeq zzeq2, boolean bl2) {
        this.zzb = zzeq2;
        this.zza = bl2;
    }

    public final void run() {
        zzkd zzkd2 = zzeq.zzc(this.zzb);
        boolean bl2 = this.zza;
        zzkd2.zzZ(bl2);
    }
}

