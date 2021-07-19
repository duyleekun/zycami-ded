/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmk;
import com.google.android.gms.internal.measurement.zzml;

public final class zzmj
implements zzfo {
    private static final zzmj zza;
    private final zzfo zzb;

    static {
        zzmj zzmj2;
        zza = zzmj2 = new zzmj();
    }

    public zzmj() {
        Object object = new zzml();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzf().zza();
    }

    public static boolean zzc() {
        return zza.zzf().zzb();
    }

    public static boolean zzd() {
        return zza.zzf().zzc();
    }

    public static boolean zze() {
        return zza.zzf().zzd();
    }

    public final zzmk zzf() {
        return (zzmk)this.zzb.zza();
    }
}

