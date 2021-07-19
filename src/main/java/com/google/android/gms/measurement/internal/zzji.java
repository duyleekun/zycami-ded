/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzjq;

public final class zzji
implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzjq zzb;

    public zzji(zzjq zzjq2, long l10) {
        this.zzb = zzjq2;
        this.zza = l10;
    }

    public final void run() {
        zzjq zzjq2 = this.zzb;
        long l10 = this.zza;
        zzjq.zzh(zzjq2, l10);
    }
}

