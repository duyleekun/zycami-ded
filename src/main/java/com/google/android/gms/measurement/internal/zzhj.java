/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzhj
implements Runnable {
    public final /* synthetic */ zzaf zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzhn zze;

    public zzhj(zzhn zzhn2, zzaf zzaf2, int n10, long l10, boolean bl2) {
        this.zze = zzhn2;
        this.zza = zzaf2;
        this.zzb = n10;
        this.zzc = l10;
        this.zzd = bl2;
    }

    public final void run() {
        zzhn zzhn2 = this.zze;
        zzaf zzaf2 = this.zza;
        zzhn2.zzr(zzaf2);
        zzhn zzhn3 = this.zze;
        zzaf zzaf3 = this.zza;
        int n10 = this.zzb;
        long l10 = this.zzc;
        boolean bl2 = this.zzd;
        zzhn.zzW(zzhn3, zzaf3, n10, l10, false, bl2);
    }
}

