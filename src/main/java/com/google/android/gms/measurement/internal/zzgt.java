/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzgt
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ String zzh;
    public final /* synthetic */ zzhn zzi;

    public zzgt(zzhn zzhn2, String string2, String string3, long l10, Bundle bundle, boolean bl2, boolean bl3, boolean bl4, String string4) {
        this.zzi = zzhn2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = l10;
        this.zzd = bundle;
        this.zze = bl2;
        this.zzf = bl3;
        this.zzg = bl4;
        this.zzh = string4;
    }

    public final void run() {
        zzhn zzhn2 = this.zzi;
        String string2 = this.zza;
        String string3 = this.zzb;
        long l10 = this.zzc;
        Bundle bundle = this.zzd;
        boolean bl2 = this.zze;
        boolean bl3 = this.zzf;
        boolean bl4 = this.zzg;
        String string4 = this.zzh;
        zzhn2.zzu(string2, string3, l10, bundle, bl2, bl3, bl4, string4);
    }
}

