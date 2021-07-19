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

public final class zzab
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzbr zzd;

    public zzab(zzbr zzbr2, String string2, String string3, Bundle bundle) {
        this.zzd = zzbr2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = bundle;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzd);
        String string2 = this.zza;
        String string3 = this.zzb;
        Bundle bundle = this.zzc;
        zzp2.clearConditionalUserProperty(string2, string3, bundle);
    }
}

