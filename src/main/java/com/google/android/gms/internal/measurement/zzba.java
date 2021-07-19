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
import com.google.android.gms.internal.measurement.zzp;

public final class zzba
extends zzbg {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzbr zzb;

    public zzba(zzbr zzbr2, Bundle bundle) {
        this.zzb = zzbr2;
        this.zza = bundle;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb);
        Bundle bundle = this.zza;
        zzp2.setDefaultEventParameters(bundle);
    }
}

