/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zzjb;

public final class zziz
implements Runnable {
    public final /* synthetic */ zzja zza;

    public zziz(zzja zzja2) {
        this.zza = zzja2;
    }

    public final void run() {
        zzjb.zzK(this.zza.zza, null);
        zzjb.zzL(this.zza.zza);
    }
}

