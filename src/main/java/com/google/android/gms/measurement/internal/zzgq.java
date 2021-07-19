/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzgq
implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzhn zzb;

    public zzgq(zzhn zzhn2, boolean bl2) {
        this.zzb = zzhn2;
        this.zza = bl2;
    }

    public final void run() {
        String string2;
        Object object = this.zzb.zzx;
        boolean bl2 = ((zzfl)object).zzF();
        Object object2 = this.zzb.zzx;
        boolean bl3 = ((zzfl)object2).zzE();
        Object object3 = this.zzb.zzx;
        boolean bl4 = this.zza;
        ((zzfl)object3).zzD(bl4);
        boolean bl5 = this.zza;
        if (bl3 == bl5) {
            object2 = this.zzb.zzx.zzat().zzk();
            bl5 = this.zza;
            object3 = bl5;
            string2 = "Default data collection state already set to";
            ((zzeg)object2).zzb(string2, object3);
        }
        if ((bl3 = ((zzfl)(object2 = this.zzb.zzx)).zzF()) == bl2 || (bl3 = ((zzfl)(object2 = this.zzb.zzx)).zzF()) != (bl5 = ((zzfl)(object3 = this.zzb.zzx)).zzE())) {
            object2 = this.zzb.zzx.zzat().zzh();
            bl5 = this.zza;
            object3 = bl5;
            object = bl2;
            string2 = "Default data collection is different than actual status";
            ((zzeg)object2).zzc(string2, object3, object);
        }
        zzhn.zzX(this.zzb);
    }
}

