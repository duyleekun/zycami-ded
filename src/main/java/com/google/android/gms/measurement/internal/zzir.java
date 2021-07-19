/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzir
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzaa zzc;
    public final /* synthetic */ zzaa zzd;
    public final /* synthetic */ zzjb zze;

    public zzir(zzjb zzjb2, boolean bl2, zzp zzp2, boolean bl3, zzaa zzaa2, zzaa zzaa3) {
        this.zze = zzjb2;
        this.zza = zzp2;
        this.zzb = bl3;
        this.zzc = zzaa2;
        this.zzd = zzaa3;
    }

    public final void run() {
        zzaa zzaa2;
        zzdz zzdz2 = zzjb.zzM(this.zze);
        if (zzdz2 == null) {
            this.zze.zzx.zzat().zzb().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb2 = this.zze;
        boolean bl2 = this.zzb;
        if (bl2) {
            bl2 = false;
            zzaa2 = null;
        } else {
            zzaa2 = this.zzc;
        }
        zzp zzp2 = this.zza;
        zzjb2.zzk(zzdz2, zzaa2, zzp2);
        zzjb.zzN(this.zze);
    }
}

