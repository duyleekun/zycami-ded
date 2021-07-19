/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzz;

public final class zzak
implements Runnable {
    public final /* synthetic */ zzgg zza;
    public final /* synthetic */ zzal zzb;

    public zzak(zzal zzal2, zzgg zzgg2) {
        this.zzb = zzal2;
        this.zza = zzgg2;
    }

    public final void run() {
        Object object = this.zza;
        object.zzas();
        boolean bl2 = zzz.zza();
        if (bl2) {
            this.zza.zzau().zzh(this);
            return;
        }
        object = this.zzb;
        bl2 = ((zzal)object).zzc();
        zzal zzal2 = this.zzb;
        long l10 = 0L;
        zzal.zze(zzal2, l10);
        if (bl2) {
            object = this.zzb;
            ((zzal)object).zza();
        }
    }
}

