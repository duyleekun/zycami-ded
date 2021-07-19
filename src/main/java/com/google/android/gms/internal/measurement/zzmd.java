/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzme;
import com.google.android.gms.internal.measurement.zzmf;

public final class zzmd
implements zzfo {
    private static final zzmd zza;
    private final zzfo zzb;

    static {
        zzmd zzmd2;
        zza = zzmd2 = new zzmd();
    }

    public zzmd() {
        Object object = new zzmf();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzme zzc() {
        return (zzme)this.zzb.zza();
    }
}

