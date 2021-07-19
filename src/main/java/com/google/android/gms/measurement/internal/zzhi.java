/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzhi
implements Runnable {
    public final /* synthetic */ zzaf zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzhn zzf;

    public zzhi(zzhn zzhn2, zzaf zzaf2, long l10, int n10, long l11, boolean bl2) {
        this.zzf = zzhn2;
        this.zza = zzaf2;
        this.zzb = l10;
        this.zzc = n10;
        this.zzd = l11;
        this.zze = bl2;
    }

    public final void run() {
        zzhn zzhn2 = this.zzf;
        zzaf zzaf2 = this.zza;
        zzhn2.zzr(zzaf2);
        zzhn2 = this.zzf;
        long l10 = this.zzb;
        zzhn2.zzG(l10, false);
        zzhn zzhn3 = this.zzf;
        zzaf zzaf3 = this.zza;
        int n10 = this.zzc;
        long l11 = this.zzd;
        boolean bl2 = this.zze;
        zzhn.zzW(zzhn3, zzaf3, n10, l11, true, bl2);
    }
}

