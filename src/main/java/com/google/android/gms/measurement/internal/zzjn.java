/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzjo;

public final class zzjn
extends zzal {
    public final /* synthetic */ zzjo zza;

    public zzjn(zzjo zzjo2, zzgg zzgg2) {
        this.zza = zzjo2;
        super(zzgg2);
    }

    public final void zza() {
        zzjo zzjo2 = this.zza;
        ((zzge)zzjo2.zzc).zzg();
        long l10 = zzjo2.zzc.zzx.zzax().elapsedRealtime();
        zzjo2.zzd(false, false, l10);
        zzd zzd2 = zzjo2.zzc.zzx.zzB();
        long l11 = zzjo2.zzc.zzx.zzax().elapsedRealtime();
        zzd2.zzc(l11);
    }
}

