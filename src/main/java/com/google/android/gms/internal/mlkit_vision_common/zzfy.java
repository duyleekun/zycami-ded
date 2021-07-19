/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzea;
import com.google.android.gms.internal.mlkit_vision_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_common.zzed;
import com.google.android.gms.internal.mlkit_vision_common.zzey;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzgj;
import com.google.android.gms.internal.mlkit_vision_common.zzgz;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import com.google.android.gms.internal.mlkit_vision_common.zzhu;
import java.util.Map;

public final class zzfy
implements zzgh {
    private final zzfr zza;
    private final zzgz zzb;
    private final boolean zzc;
    private final zzea zzd;

    private zzfy(zzgz zzgz2, zzea zzea2, zzfr zzfr2) {
        boolean bl2;
        this.zzb = zzgz2;
        this.zzc = bl2 = zzea2.zza(zzfr2);
        this.zzd = zzea2;
        this.zza = zzfr2;
    }

    public static zzfy zza(zzgz zzgz2, zzea zzea2, zzfr zzfr2) {
        zzfy zzfy2 = new zzfy(zzgz2, zzea2, zzfr2);
        return zzfy2;
    }

    public final int zza(Object object) {
        Object object2 = this.zzb.zza(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzc;
        if (bl2) {
            zzea zzea2 = this.zzd;
            object = zzea2.zza(object);
            n10 *= 53;
            int n11 = ((zzeb)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final void zza(Object object, zzht zzht2) {
        boolean bl2;
        Object object2 = this.zzd.zza(object).zzd();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            zzhu zzhu2;
            Object object3 = (Map.Entry)object2.next();
            zzed zzed2 = (zzed)object3.getKey();
            zzhu zzhu3 = zzed2.zzc();
            if (zzhu3 == (zzhu2 = zzhu.zzi) && !(bl3 = zzed2.zzd()) && !(bl3 = zzed2.zze())) {
                int n10;
                bl3 = object3 instanceof zzey;
                if (bl3) {
                    n10 = zzed2.zza();
                    object3 = ((zzey)object3).zza().zzc();
                    zzht2.zza(n10, object3);
                    continue;
                }
                n10 = zzed2.zza();
                object3 = object3.getValue();
                zzht2.zza(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.zzb;
        object = ((zzgz)object2).zza(object);
        ((zzgz)object2).zzb(object, zzht2);
    }

    public final boolean zza(Object object, Object object2) {
        Object object3;
        Object object4 = this.zzb.zza(object);
        boolean bl2 = object4.equals(object3 = this.zzb.zza(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.zzc;
        if (bl2) {
            object = this.zzd.zza(object);
            object2 = this.zzd.zza(object2);
            return ((zzeb)object).equals(object2);
        }
        return true;
    }

    public final int zzb(Object object) {
        zzgz zzgz2 = this.zzb;
        Object object2 = zzgz2.zza(object);
        int n10 = zzgz2.zzc(object2) + 0;
        boolean bl2 = this.zzc;
        if (bl2) {
            object2 = this.zzd;
            object = ((zzea)object2).zza(object);
            int n11 = ((zzeb)object).zzg();
            n10 += n11;
        }
        return n10;
    }

    public final void zzb(Object object, Object object2) {
        Object object3 = this.zzb;
        zzgj.zza((zzgz)object3, object, object2);
        boolean bl2 = this.zzc;
        if (bl2) {
            object3 = this.zzd;
            zzgj.zza((zzea)object3, object, object2);
        }
    }

    public final void zzc(Object object) {
        this.zzb.zzb(object);
        this.zzd.zzc(object);
    }

    public final boolean zzd(Object object) {
        return this.zzd.zza(object).zzf();
    }
}

