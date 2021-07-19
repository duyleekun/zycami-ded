/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzgo
implements Runnable {
    private final zzhn zza;
    private final Bundle zzb;

    public zzgo(zzhn zzhn2, Bundle bundle) {
        this.zza = zzhn2;
        this.zzb = bundle;
    }

    public final void run() {
        zzhn zzhn2 = this.zza;
        Bundle bundle = this.zzb;
        zzhn2.zzU(bundle);
    }
}

