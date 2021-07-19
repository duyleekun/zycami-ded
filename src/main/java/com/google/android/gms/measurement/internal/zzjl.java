/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzjk;
import com.google.android.gms.measurement.internal.zzjm;

public final class zzjl
implements Runnable {
    public final long zza;
    public final long zzb;
    public final /* synthetic */ zzjm zzc;

    public zzjl(zzjm zzjm2, long l10, long l11) {
        this.zzc = zzjm2;
        this.zza = l10;
        this.zzb = l11;
    }

    public final void run() {
        zzfi zzfi2 = this.zzc.zza.zzx.zzau();
        zzjk zzjk2 = new zzjk(this);
        zzfi2.zzh(zzjk2);
    }
}

