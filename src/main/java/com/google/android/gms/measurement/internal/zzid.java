/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzp;

public final class zzid
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzkg zzc;
    public final /* synthetic */ zzjb zzd;

    public zzid(zzjb zzjb2, zzp zzp2, boolean bl2, zzkg zzkg2) {
        this.zzd = zzjb2;
        this.zza = zzp2;
        this.zzb = bl2;
        this.zzc = zzkg2;
    }

    public final void run() {
        zzkg zzkg2;
        zzdz zzdz2 = zzjb.zzM(this.zzd);
        if (zzdz2 == null) {
            this.zzd.zzx.zzat().zzb().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjb zzjb2 = this.zzd;
        boolean bl2 = this.zzb;
        if (bl2) {
            bl2 = false;
            zzkg2 = null;
        } else {
            zzkg2 = this.zzc;
        }
        zzp zzp2 = this.zza;
        zzjb2.zzk(zzdz2, zzkg2, zzp2);
        zzjb.zzN(this.zzd);
    }
}

