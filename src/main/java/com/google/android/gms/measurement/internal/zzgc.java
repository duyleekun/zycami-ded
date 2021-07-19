/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;

public final class zzgc
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzgd zze;

    public zzgc(zzgd zzgd2, String string2, String string3, String string4, long l10) {
        this.zze = zzgd2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = string4;
        this.zzd = l10;
    }

    public final void run() {
        Object object = this.zza;
        if (object == null) {
            object = zzgd.zzw(this.zze).zzR().zzx();
            String string2 = this.zzb;
            ((zzib)object).zzn(string2, null);
            return;
        }
        String string3 = this.zzc;
        long l10 = this.zzd;
        zzhu zzhu2 = new zzhu(string3, (String)object, l10);
        object = zzgd.zzw(this.zze).zzR().zzx();
        string3 = this.zzb;
        ((zzib)object).zzn(string3, zzhu2);
    }
}

