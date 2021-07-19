/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zza;
import com.google.android.gms.measurement.internal.zzb;
import com.google.android.gms.measurement.internal.zze;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzib;
import java.util.Map;

public final class zzd
extends zze {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzfl object) {
        super((zzfl)object);
        this.zzb = object = new ArrayMap();
        this.zza = object = new ArrayMap();
    }

    public static /* synthetic */ void zzd(zzd object, String string2, long l10) {
        int n10;
        ((zzge)object).zzg();
        Preconditions.checkNotEmpty(string2);
        Object object2 = ((zzd)object).zzb;
        int n11 = object2.isEmpty();
        if (n11 != 0) {
            ((zzd)object).zzc = l10;
        }
        object2 = (Integer)((zzd)object).zzb.get(string2);
        int n12 = 1;
        if (object2 != null) {
            object = ((zzd)object).zzb;
            Integer n13 = (Integer)object2 + n12;
            object.put(string2, n13);
            return;
        }
        object2 = ((zzd)object).zzb;
        n11 = object2.size();
        if (n11 >= (n10 = 100)) {
            ((zzge)object).zzx.zzat().zze().zza("Too many ads visible");
            return;
        }
        object2 = ((zzd)object).zzb;
        Integer n14 = n12;
        object2.put(string2, n14);
        object = ((zzd)object).zza;
        Long l11 = l10;
        object.put(string2, l11);
    }

    public static /* synthetic */ void zze(zzd object, String object2, long l10) {
        ((zzge)object).zzg();
        Preconditions.checkNotEmpty((String)object2);
        Object object3 = (Integer)((zzd)object).zzb.get(object2);
        if (object3 != null) {
            zzhu zzhu2 = ((zzge)object).zzx.zzx().zzh(false);
            int n10 = (Integer)object3 + -1;
            if (n10 == 0) {
                long l11;
                ((zzd)object).zzb.remove(object2);
                object3 = (Long)((zzd)object).zza.get(object2);
                if (object3 == null) {
                    object2 = ((zzge)object).zzx.zzat().zzb();
                    object3 = "First ad unit exposure time was never set";
                    ((zzeg)object2).zza((String)object3);
                } else {
                    l11 = (Long)object3;
                    object3 = ((zzd)object).zza;
                    object3.remove(object2);
                    l11 = l10 - l11;
                    super.zzi((String)object2, l11, zzhu2);
                }
                object2 = ((zzd)object).zzb;
                Object object4 = object2.isEmpty();
                if (object4) {
                    l11 = ((zzd)object).zzc;
                    long l12 = 0L;
                    long l13 = l11 - l12;
                    object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (!object4) {
                        ((zzge)object).zzx.zzat().zzb().zza("First ad exposure time was never set");
                        return;
                    }
                    super.zzh(l10 -= l11, zzhu2);
                    ((zzd)object).zzc = l12;
                }
                return;
            }
            object = ((zzd)object).zzb;
            Integer n11 = n10;
            object.put(object2, n11);
            return;
        }
        ((zzge)object).zzx.zzat().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", object2);
    }

    public static /* synthetic */ void zzf(zzd zzd2, long l10) {
        zzd2.zzj(l10);
    }

    private final void zzh(long l10, zzhu object) {
        if (object == null) {
            this.zzx.zzat().zzk().zza("Not logging ad exposure. No active activity");
            return;
        }
        long l11 = 1000L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            object = this.zzx.zzat().zzk();
            Long l13 = l10;
            ((zzeg)object).zzb("Not logging ad exposure. Less than 1000 ms. exposure", l13);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", l10);
        zzib.zzm((zzhu)object, bundle, true);
        this.zzx.zzk().zzs("am", "_xa", bundle);
    }

    private final void zzi(String object, long l10, zzhu zzhu2) {
        if (zzhu2 == null) {
            this.zzx.zzat().zzk().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        long l11 = 1000L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            object = this.zzx.zzat().zzk();
            Long l13 = l10;
            ((zzeg)object).zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", l13);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", (String)object);
        bundle.putLong("_xt", l10);
        zzib.zzm(zzhu2, bundle, true);
        this.zzx.zzk().zzs("am", "_xu", bundle);
    }

    private final void zzj(long l10) {
        boolean bl2;
        Object object = this.zza.keySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            Map map = this.zza;
            Long l11 = l10;
            map.put(string2, l11);
        }
        object = this.zza;
        boolean bl3 = object.isEmpty();
        if (!bl3) {
            this.zzc = l10;
        }
    }

    public final void zza(String string2, long l10) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            zzfi zzfi2 = this.zzx.zzau();
            zza zza2 = new zza(this, string2, l10);
            zzfi2.zzh(zza2);
            return;
        }
        this.zzx.zzat().zzb().zza("Ad unit id must be a non-empty string");
    }

    public final void zzb(String string2, long l10) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            zzfi zzfi2 = this.zzx.zzau();
            zzb zzb2 = new zzb(this, string2, l10);
            zzfi2.zzh(zzb2);
            return;
        }
        this.zzx.zzat().zzb().zza("Ad unit id must be a non-empty string");
    }

    public final void zzc(long l10) {
        boolean bl2;
        Object object = this.zzx.zzx();
        boolean bl3 = false;
        object = ((zzib)object).zzh(false);
        Object object2 = this.zza.keySet().iterator();
        while (bl2 = object2.hasNext()) {
            String string2 = (String)object2.next();
            Long l11 = (Long)this.zza.get(string2);
            long l12 = l11;
            l12 = l10 - l12;
            this.zzi(string2, l12, (zzhu)object);
        }
        object2 = this.zza;
        bl3 = object2.isEmpty();
        if (!bl3) {
            long l13 = this.zzc;
            l13 = l10 - l13;
            this.zzh(l13, (zzhu)object);
        }
        this.zzj(l10);
    }
}

