/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzka
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ zzkb zzc;

    public zzka(zzkb zzkb2, String string2, Bundle bundle) {
        this.zzc = zzkb2;
        this.zza = string2;
        this.zzb = bundle;
    }

    public final void run() {
        zzgg zzgg2 = this.zzc.zza.zzr();
        String string2 = this.zza;
        Bundle bundle = this.zzb;
        long l10 = this.zzc.zza.zzax().currentTimeMillis();
        zzas zzas2 = ((zzkk)zzgg2).zzV(string2, "_err", bundle, "auto", l10, false, false);
        zzgg2 = this.zzc.zza;
        string2 = this.zza;
        ((zzkd)zzgg2).zzz(zzas2, string2);
    }
}

