/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzfx
implements Runnable {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzgd zzc;

    public zzfx(zzgd zzgd2, zzas zzas2, String string2) {
        this.zzc = zzgd2;
        this.zza = zzas2;
        this.zzb = string2;
    }

    public final void run() {
        zzgd.zzw(this.zzc).zzK();
        zzkd zzkd2 = zzgd.zzw(this.zzc);
        zzas zzas2 = this.zza;
        String string2 = this.zzb;
        zzkd2.zzz(zzas2, string2);
    }
}

