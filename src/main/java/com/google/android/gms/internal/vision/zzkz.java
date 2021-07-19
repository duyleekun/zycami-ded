/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzkw;
import com.google.android.gms.internal.vision.zzkx;
import com.google.android.gms.internal.vision.zzlq;

public final class zzkz
extends zzkx {
    private static void zza(Object object, zzkw zzkw2) {
        ((zzid)object).zzxz = zzkw2;
    }

    public final /* synthetic */ void zza(Object object, int n10, long l10) {
        object = (zzkw)object;
        Long l11 = l10;
        ((zzkw)object).zzb(n10 <<= 3, l11);
    }

    public final /* synthetic */ void zza(Object object, int n10, zzgs zzgs2) {
        object = (zzkw)object;
        n10 = n10 << 3 | 2;
        ((zzkw)object).zzb(n10, zzgs2);
    }

    public final /* synthetic */ void zza(Object object, int n10, Object object2) {
        object = (zzkw)object;
        object2 = (zzkw)object2;
        n10 = n10 << 3 | 3;
        ((zzkw)object).zzb(n10, object2);
    }

    public final /* synthetic */ void zza(Object object, zzlq zzlq2) {
        ((zzkw)object).zzb(zzlq2);
    }

    public final boolean zza(zzkc zzkc2) {
        return false;
    }

    public final /* synthetic */ int zzaa(Object object) {
        return ((zzkw)object).zzjc();
    }

    public final /* synthetic */ void zzb(Object object, int n10, long l10) {
        object = (zzkw)object;
        n10 = n10 << 3 | 1;
        Long l11 = l10;
        ((zzkw)object).zzb(n10, l11);
    }

    public final /* synthetic */ void zzc(Object object, zzlq zzlq2) {
        ((zzkw)object).zza(zzlq2);
    }

    public final /* synthetic */ void zzd(Object object, int n10, int n11) {
        object = (zzkw)object;
        n10 = n10 << 3 | 5;
        Integer n12 = n11;
        ((zzkw)object).zzb(n10, n12);
    }

    public final /* synthetic */ void zzf(Object object, Object object2) {
        object2 = (zzkw)object2;
        zzkz.zza(object, (zzkw)object2);
    }

    public final /* synthetic */ void zzg(Object object, Object object2) {
        object2 = (zzkw)object2;
        zzkz.zza(object, (zzkw)object2);
    }

    public final /* synthetic */ Object zzh(Object object, Object object2) {
        object = (zzkw)object;
        zzkw zzkw2 = zzkw.zzja();
        boolean bl2 = ((zzkw)(object2 = (zzkw)object2)).equals(zzkw2);
        if (bl2) {
            return object;
        }
        return zzkw.zza((zzkw)object, (zzkw)object2);
    }

    public final void zzj(Object object) {
        ((zzid)object).zzxz.zzej();
    }

    public final /* synthetic */ Object zzjd() {
        return zzkw.zzjb();
    }

    public final /* synthetic */ Object zzq(Object object) {
        object = (zzkw)object;
        ((zzkw)object).zzej();
        return object;
    }

    public final /* synthetic */ int zzu(Object object) {
        return ((zzkw)object).zzgz();
    }

    public final /* synthetic */ Object zzy(Object object) {
        return ((zzid)object).zzxz;
    }

    public final /* synthetic */ Object zzz(Object object) {
        Object object2 = object;
        object2 = ((zzid)object).zzxz;
        zzkw zzkw2 = zzkw.zzja();
        if (object2 == zzkw2) {
            object2 = zzkw.zzjb();
            zzkz.zza(object, (zzkw)object2);
        }
        return object2;
    }
}

