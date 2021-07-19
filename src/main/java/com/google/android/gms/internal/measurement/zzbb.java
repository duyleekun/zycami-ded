/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzbb
extends zzbg {
    public final /* synthetic */ zzbh zza;
    public final /* synthetic */ zzbr zzb;

    public zzbb(zzbr zzbr2, zzbh zzbh2) {
        this.zzb = zzbr2;
        this.zza = zzbh2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        zzbh zzbh2 = this.zza;
        zzp2.setEventInterceptor(zzbh2);
    }
}

