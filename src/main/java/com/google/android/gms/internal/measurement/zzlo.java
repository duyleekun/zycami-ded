/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzlp;
import com.google.android.gms.internal.measurement.zzlq;

public final class zzlo
implements zzfo {
    private static final zzlo zza;
    private final zzfo zzb;

    static {
        zzlo zzlo2;
        zza = zzlo2 = new zzlo();
    }

    public zzlo() {
        Object object = new zzlq();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        zza.zzf().zza();
        return true;
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

    public final zzlp zzf() {
        return (zzlp)this.zzb.zza();
    }
}

