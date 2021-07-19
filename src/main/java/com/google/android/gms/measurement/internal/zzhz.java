/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;

public final class zzhz
implements Runnable {
    public final /* synthetic */ zzhu zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzib zzc;

    public zzhz(zzib zzib2, zzhu zzhu2, long l10) {
        this.zzc = zzib2;
        this.zza = zzhu2;
        this.zzb = l10;
    }

    public final void run() {
        zzib zzib2 = this.zzc;
        zzhu zzhu2 = this.zza;
        long l10 = this.zzb;
        zzib.zzy(zzib2, zzhu2, false, l10);
        zzib2 = this.zzc;
        zzib2.zza = null;
        zzib2.zzx.zzy().zzz(null);
    }
}

