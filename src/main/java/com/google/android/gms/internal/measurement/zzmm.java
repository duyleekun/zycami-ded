/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmn;
import com.google.android.gms.internal.measurement.zzmo;

public final class zzmm
implements zzfo {
    private static final zzmm zza;
    private final zzfo zzb;

    static {
        zzmm zzmm2;
        zza = zzmm2 = new zzmm();
    }

    public zzmm() {
        Object object = new zzmo();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzd().zza();
    }

    public static boolean zzc() {
        return zza.zzd().zzb();
    }

    public final zzmn zzd() {
        return (zzmn)this.zzb.zza();
    }
}

