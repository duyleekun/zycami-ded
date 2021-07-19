/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzau
extends zzbg {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzm zzb;
    public final /* synthetic */ zzbr zzc;

    public zzau(zzbr zzbr2, Bundle bundle, zzm zzm2) {
        this.zzc = zzbr2;
        this.zza = bundle;
        this.zzb = zzm2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzc);
        Bundle bundle = this.zza;
        zzm zzm2 = this.zzb;
        long l10 = this.zzh;
        zzp2.performAction(bundle, zzm2, l10);
    }

    public final void zzb() {
        this.zzb.zzb(null);
    }
}

