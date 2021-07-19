/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzaz
extends zzbg {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzbr zzb;

    public zzaz(zzbr zzbr2, boolean bl2) {
        this.zzb = zzbr2;
        this.zza = bl2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        boolean bl2 = this.zza;
        zzp2.setDataCollectionEnabled(bl2);
    }
}

