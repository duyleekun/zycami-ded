/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;

public final class zzhv
implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhu zzb;
    public final /* synthetic */ zzhu zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzib zze;

    public zzhv(zzib zzib2, Bundle bundle, zzhu zzhu2, zzhu zzhu3, long l10) {
        this.zze = zzib2;
        this.zza = bundle;
        this.zzb = zzhu2;
        this.zzc = zzhu3;
        this.zzd = l10;
    }

    public final void run() {
        zzib zzib2 = this.zze;
        Bundle bundle = this.zza;
        zzhu zzhu2 = this.zzb;
        zzhu zzhu3 = this.zzc;
        long l10 = this.zzd;
        zzib.zzu(zzib2, bundle, zzhu2, zzhu3, l10);
    }
}

