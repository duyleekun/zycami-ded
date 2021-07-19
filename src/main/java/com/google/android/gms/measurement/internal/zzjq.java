/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzf;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;

public final class zzjq
extends zzf {
    public final zzjp zza;
    public final zzjo zzb;
    public final zzjm zzc;
    private Handler zzd;

    public zzjq(zzfl object) {
        super((zzfl)object);
        this.zza = object = new zzjp(this);
        this.zzb = object = new zzjo(this);
        this.zzc = object = new zzjm(this);
    }

    public static /* synthetic */ void zzh(zzjq object, long l10) {
        Object object2;
        ((zzge)object).zzg();
        ((zzjq)object).zzl();
        Object object3 = ((zzge)object).zzx.zzat().zzk();
        Object object4 = l10;
        ((zzeg)object3).zzb("Activity resumed, time", object4);
        object3 = ((zzge)object).zzx.zzc();
        object4 = zzdw.zzat;
        boolean bl2 = ((zzae)object3).zzn(null, (zzdv)object4);
        if (bl2) {
            object3 = ((zzge)object).zzx.zzc();
            bl2 = ((zzae)object3).zzt();
            if (bl2 || (bl2 = ((zzes)(object3 = object.zzx.zzd().zzq)).zza())) {
                object3 = ((zzjq)object).zzb;
                ((zzjo)object3).zza(l10);
            }
            object2 = ((zzjq)object).zzc;
            ((zzjm)object2).zza();
        } else {
            ((zzjq)object).zzc.zza();
            object3 = ((zzge)object).zzx.zzc();
            bl2 = ((zzae)object3).zzt();
            if (bl2) {
                object3 = ((zzjq)object).zzb;
                ((zzjo)object3).zza(l10);
            }
        }
        object = ((zzjq)object).zza;
        ((zzge)((zzjp)object).zza).zzg();
        object2 = object.zza.zzx;
        boolean bl3 = ((zzfl)object2).zzF();
        if (!bl3) {
            return;
        }
        object2 = object.zza.zzx.zzc();
        bl3 = ((zzae)object2).zzn(null, (zzdv)object4);
        if (!bl3) {
            object2 = object.zza.zzx.zzd().zzq;
            ((zzes)object2).zzb(false);
        }
        long l11 = object.zza.zzx.zzax().currentTimeMillis();
        ((zzjp)object).zzb(l11, false);
    }

    public static /* synthetic */ void zzi(zzjq object, long l10) {
        ((zzge)object).zzg();
        ((zzjq)object).zzl();
        Object object2 = ((zzge)object).zzx.zzat().zzk();
        Long l11 = l10;
        String string2 = "Activity paused, time";
        ((zzeg)object2).zzb(string2, l11);
        ((zzjq)object).zzc.zzb(l10);
        object2 = ((zzge)object).zzx.zzc();
        boolean bl2 = ((zzae)object2).zzt();
        if (bl2) {
            object2 = ((zzjq)object).zzb;
            ((zzjo)object2).zzb(l10);
        }
        object = ((zzjq)object).zza;
        zzae zzae2 = object.zza.zzx.zzc();
        boolean bl3 = zzae2.zzn(null, (zzdv)(object2 = zzdw.zzat));
        if (!bl3) {
            object = object.zza.zzx.zzd().zzq;
            bl3 = true;
            ((zzes)object).zzb(bl3);
        }
    }

    public static /* synthetic */ void zzj(zzjq zzjq2) {
        zzjq2.zzl();
    }

    public static /* synthetic */ Handler zzk(zzjq zzjq2) {
        return zzjq2.zzd;
    }

    private final void zzl() {
        ((zzge)this).zzg();
        Handler handler = this.zzd;
        if (handler == null) {
            Looper looper = Looper.getMainLooper();
            this.zzd = handler = new zzl(looper);
        }
    }

    public final boolean zze() {
        return false;
    }
}

