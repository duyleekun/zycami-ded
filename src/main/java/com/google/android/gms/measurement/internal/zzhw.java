/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;

public final class zzhw
implements Runnable {
    public final /* synthetic */ zzhu zza;
    public final /* synthetic */ zzhu zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzib zze;

    public zzhw(zzib zzib2, zzhu zzhu2, zzhu zzhu3, long l10, boolean bl2) {
        this.zze = zzib2;
        this.zza = zzhu2;
        this.zzb = zzhu3;
        this.zzc = l10;
        this.zzd = bl2;
    }

    public final void run() {
        zzib zzib2 = this.zze;
        zzhu zzhu2 = this.zza;
        zzhu zzhu3 = this.zzb;
        long l10 = this.zzc;
        boolean bl2 = this.zzd;
        zzib.zzv(zzib2, zzhu2, zzhu3, l10, bl2, null);
    }
}

