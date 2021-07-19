/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zziq
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzas zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzjb zze;

    public zziq(zzjb zzjb2, boolean bl2, zzp zzp2, boolean bl3, zzas zzas2, String string2) {
        this.zze = zzjb2;
        this.zza = zzp2;
        this.zzb = bl3;
        this.zzc = zzas2;
        this.zzd = string2;
    }

    public final void run() {
        zzas zzas2;
        zzdz zzdz2 = zzjb.zzM(this.zze);
        if (zzdz2 == null) {
            this.zze.zzx.zzat().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb2 = this.zze;
        boolean bl2 = this.zzb;
        if (bl2) {
            bl2 = false;
            zzas2 = null;
        } else {
            zzas2 = this.zzc;
        }
        zzp zzp2 = this.zza;
        zzjb2.zzk(zzdz2, zzas2, zzp2);
        zzjb.zzN(this.zze);
    }
}

