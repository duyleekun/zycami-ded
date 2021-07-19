/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfg;
import com.google.android.gms.internal.mlkit_common.zzfl;
import com.google.android.gms.internal.mlkit_common.zzfn;
import com.google.android.gms.internal.mlkit_common.zzge;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzht;
import com.google.android.gms.internal.mlkit_common.zzij;
import com.google.android.gms.internal.mlkit_common.zzja;
import com.google.android.gms.internal.mlkit_common.zzjd;
import java.util.Map;

public final class zzhe
implements zzhr {
    private final zzhb zza;
    private final zzij zzb;
    private final boolean zzc;
    private final zzfg zzd;

    private zzhe(zzij zzij2, zzfg zzfg2, zzhb zzhb2) {
        boolean bl2;
        this.zzb = zzij2;
        this.zzc = bl2 = zzfg2.zza(zzhb2);
        this.zzd = zzfg2;
        this.zza = zzhb2;
    }

    public static zzhe zza(zzij zzij2, zzfg zzfg2, zzhb zzhb2) {
        zzhe zzhe2 = new zzhe(zzij2, zzfg2, zzhb2);
        return zzhe2;
    }

    public final int zza(Object object) {
        Object object2 = this.zzb.zza(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzc;
        if (bl2) {
            zzfg zzfg2 = this.zzd;
            object = zzfg2.zza(object);
            n10 *= 53;
            int n11 = ((zzfl)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final void zza(Object object, zzjd zzjd2) {
        boolean bl2;
        Object object2 = this.zzd.zza(object).zzd();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            zzja zzja2;
            Object object3 = (Map.Entry)object2.next();
            zzfn zzfn2 = (zzfn)object3.getKey();
            zzja zzja3 = zzfn2.zzc();
            if (zzja3 == (zzja2 = zzja.zzi) && !(bl3 = zzfn2.zzd()) && !(bl3 = zzfn2.zze())) {
                int n10;
                bl3 = object3 instanceof zzge;
                if (bl3) {
                    n10 = zzfn2.zza();
                    object3 = ((zzge)object3).zza().zzc();
                    zzjd2.zza(n10, object3);
                    continue;
                }
                n10 = zzfn2.zza();
                object3 = object3.getValue();
                zzjd2.zza(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.zzb;
        object = ((zzij)object2).zza(object);
        ((zzij)object2).zzb(object, zzjd2);
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
            return ((zzfl)object).equals(object2);
        }
        return true;
    }

    public final void zzb(Object object) {
        this.zzb.zzb(object);
        this.zzd.zzc(object);
    }

    public final void zzb(Object object, Object object2) {
        Object object3 = this.zzb;
        zzht.zza((zzij)object3, object, object2);
        boolean bl2 = this.zzc;
        if (bl2) {
            object3 = this.zzd;
            zzht.zza((zzfg)object3, object, object2);
        }
    }

    public final boolean zzc(Object object) {
        return this.zzd.zza(object).zzf();
    }

    public final int zzd(Object object) {
        zzij zzij2 = this.zzb;
        Object object2 = zzij2.zza(object);
        int n10 = zzij2.zzc(object2) + 0;
        boolean bl2 = this.zzc;
        if (bl2) {
            object2 = this.zzd;
            object = ((zzfg)object2).zza(object);
            int n11 = ((zzfl)object).zzg();
            n10 += n11;
        }
        return n10;
    }
}

