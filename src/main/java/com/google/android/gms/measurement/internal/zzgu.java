/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhn;

public final class zzgu
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzhn zze;

    public zzgu(zzhn zzhn2, String string2, String string3, Object object, long l10) {
        this.zze = zzhn2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = object;
        this.zzd = l10;
    }

    public final void run() {
        zzhn zzhn2 = this.zze;
        String string2 = this.zza;
        String string3 = this.zzb;
        Object object = this.zzc;
        long l10 = this.zzd;
        zzhn2.zzB(string2, string3, object, l10);
    }
}

