/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.measurement.internal;

import android.content.Intent;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzjh;

public final class zzjd
implements Runnable {
    private final zzjh zza;
    private final int zzb;
    private final zzei zzc;
    private final Intent zzd;

    public zzjd(zzjh zzjh2, int n10, zzei zzei2, Intent intent) {
        this.zza = zzjh2;
        this.zzb = n10;
        this.zzc = zzei2;
        this.zzd = intent;
    }

    public final void run() {
        zzjh zzjh2 = this.zza;
        int n10 = this.zzb;
        zzei zzei2 = this.zzc;
        Intent intent = this.zzd;
        zzjh2.zzj(n10, zzei2, intent);
    }
}

