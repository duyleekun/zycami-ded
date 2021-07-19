/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzil
extends zzal {
    public final /* synthetic */ zzjb zza;

    public zzil(zzjb zzjb2, zzgg zzgg2) {
        this.zza = zzjb2;
        super(zzgg2);
    }

    public final void zza() {
        zzjb zzjb2 = this.zza;
        ((zzge)zzjb2).zzg();
        boolean bl2 = zzjb2.zzh();
        if (!bl2) {
            return;
        }
        zzjb2.zzx.zzat().zzk().zza("Inactivity, disconnecting from the service");
        zzjb2.zzF();
    }
}

