/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzjo;

public final class zzjk
implements Runnable {
    private final zzjl zza;

    public zzjk(zzjl zzjl2) {
        this.zza = zzjl2;
    }

    public final void run() {
        Object object = this.zza;
        zzjm zzjm2 = ((zzjl)object).zzc;
        long l10 = ((zzjl)object).zza;
        long l11 = ((zzjl)object).zzb;
        ((zzge)zzjm2.zza).zzg();
        zzjm2.zza.zzx.zzat().zzj().zza("Application going to the background");
        object = zzjm2.zza.zzx.zzc();
        zzdv zzdv2 = zzdw.zzat;
        boolean bl2 = false;
        Object object2 = null;
        boolean bl3 = ((zzae)object).zzn(null, zzdv2);
        boolean bl4 = true;
        if (bl3) {
            object = zzjm2.zza.zzx.zzd().zzq;
            ((zzes)object).zzb(bl4);
        }
        object = new Bundle();
        zzae zzae2 = zzjm2.zza.zzx.zzc();
        boolean bl5 = zzae2.zzt();
        if (!bl5) {
            zzjm2.zza.zzb.zzb(l11);
            zzae2 = zzjm2.zza.zzx.zzc();
            zzdv zzdv3 = zzdw.zzak;
            bl2 = zzae2.zzn(null, zzdv3);
            bl5 = false;
            zzae2 = null;
            if (bl2) {
                object2 = zzjm2.zza.zzb;
                long l12 = ((zzjo)object2).zzb;
                ((zzjo)object2).zzb = l11;
                l12 = l11 - l12;
                object.putLong("_et", l12);
                object2 = zzjm2.zza.zzx.zzx().zzh(bl4);
                zzib.zzm((zzhu)object2, (Bundle)object, bl4);
            } else {
                bl4 = false;
                zzdv2 = null;
            }
            object2 = zzjm2.zza.zzb;
            ((zzjo)object2).zzd(false, bl4, l11);
        }
        zzhn zzhn2 = zzjm2.zza.zzx.zzk();
        object2 = object;
        zzhn2.zzt("auto", "_ab", l10, (Bundle)object);
    }
}

