/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmz;
import com.google.android.gms.internal.measurement.zzna;

public final class zzmy
implements zzfo {
    private static final zzmy zza;
    private final zzfo zzb;

    static {
        zzmy zzmy2;
        zza = zzmy2 = new zzmy();
    }

    public zzmy() {
        Object object = new zzna();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzmz zzc() {
        return (zzmz)this.zzb.zza();
    }
}

