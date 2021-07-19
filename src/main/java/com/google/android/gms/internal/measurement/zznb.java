/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznc;
import com.google.android.gms.internal.measurement.zznd;

public final class zznb
implements zzfo {
    private static final zznb zza;
    private final zzfo zzb;

    static {
        zznb zznb2;
        zza = zznb2 = new zznb();
    }

    public zznb() {
        Object object = new zznd();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        zza.zzd().zza();
        return true;
    }

    public static boolean zzc() {
        return zza.zzd().zzb();
    }

    public final zznc zzd() {
        return (zznc)this.zzb.zza();
    }
}

