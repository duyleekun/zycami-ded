/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgd;

public final class zzfm
implements Runnable {
    private final zzgd zza;
    private final String zzb;
    private final Bundle zzc;

    public zzfm(zzgd zzgd2, String string2, Bundle bundle) {
        this.zza = zzgd2;
        this.zzb = string2;
        this.zzc = bundle;
    }

    public final void run() {
        zzgd zzgd2 = this.zza;
        String string2 = this.zzb;
        Bundle bundle = this.zzc;
        zzgd2.zzv(string2, bundle);
    }
}

