/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zzjb;

public final class zziv
implements Runnable {
    public final /* synthetic */ zzdz zza;
    public final /* synthetic */ zzja zzb;

    public zziv(zzja zzja2, zzdz zzdz2) {
        this.zzb = zzja2;
        this.zza = zzdz2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        zzja zzja2 = this.zzb;
        synchronized (zzja2) {
            Object object = this.zzb;
            Object object2 = null;
            zzja.zzd((zzja)object, false);
            object = this.zzb;
            object = ((zzja)object).zza;
            boolean bl2 = ((zzjb)object).zzh();
            if (!bl2) {
                object = this.zzb;
                object = ((zzja)object).zza;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzk();
                object2 = "Connected to service";
                ((zzeg)object).zza((String)object2);
                object = this.zzb;
                object = ((zzja)object).zza;
                object2 = this.zza;
                ((zzjb)object).zzE((zzdz)object2);
            }
            return;
        }
    }
}

