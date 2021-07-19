/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjq;

public final class zzjm {
    public final /* synthetic */ zzjq zza;
    private zzjl zzb;

    public zzjm(zzjq zzjq2) {
        this.zza = zzjq2;
    }

    public final void zza() {
        zzjl zzjl2;
        ((zzge)this.zza).zzg();
        Object object = this.zzb;
        if (object != null) {
            object = zzjq.zzk(this.zza);
            zzjl2 = this.zzb;
            object.removeCallbacks((Runnable)zzjl2);
        }
        object = this.zza.zzx.zzc();
        zzjl2 = null;
        zzdv zzdv2 = zzdw.zzat;
        boolean bl2 = ((zzae)object).zzn(null, zzdv2);
        if (bl2) {
            object = this.zza.zzx.zzd().zzq;
            zzjl2 = null;
            ((zzes)object).zzb(false);
        }
    }

    public final void zzb(long l10) {
        zzjl zzjl2;
        long l11 = this.zza.zzx.zzax().currentTimeMillis();
        this.zzb = zzjl2 = new zzjl(this, l11, l10);
        Handler handler = zzjq.zzk(this.zza);
        zzjl zzjl3 = this.zzb;
        handler.postDelayed((Runnable)zzjl3, 2000L);
    }
}

