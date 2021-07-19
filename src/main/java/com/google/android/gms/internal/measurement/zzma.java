/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmc;

public final class zzma
implements zzfo {
    private static final zzma zza;
    private final zzfo zzb;

    static {
        zzma zzma2;
        zza = zzma2 = new zzma();
    }

    public zzma() {
        Object object = new zzmc();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzmb zzc() {
        return (zzmb)this.zzb.zza();
    }
}

