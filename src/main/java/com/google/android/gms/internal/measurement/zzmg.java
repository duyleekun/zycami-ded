/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmh;
import com.google.android.gms.internal.measurement.zzmi;

public final class zzmg
implements zzfo {
    private static final zzmg zza;
    private final zzfo zzb;

    static {
        zzmg zzmg2;
        zza = zzmg2 = new zzmg();
    }

    public zzmg() {
        Object object = new zzmi();
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

    public final zzmh zzd() {
        return (zzmh)this.zzb.zza();
    }
}

