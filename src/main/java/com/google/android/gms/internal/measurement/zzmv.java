/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmw;
import com.google.android.gms.internal.measurement.zzmx;

public final class zzmv
implements zzfo {
    private static final zzmv zza;
    private final zzfo zzb;

    static {
        zzmv zzmv2;
        zza = zzmv2 = new zzmv();
    }

    public zzmv() {
        Object object = new zzmx();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzg().zza();
    }

    public static double zzc() {
        return zza.zzg().zzb();
    }

    public static long zzd() {
        return zza.zzg().zzc();
    }

    public static long zze() {
        return zza.zzg().zzd();
    }

    public static String zzf() {
        return zza.zzg().zze();
    }

    public final zzmw zzg() {
        return (zzmw)this.zzb.zza();
    }
}

