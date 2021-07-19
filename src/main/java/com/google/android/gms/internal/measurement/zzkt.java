/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzku;
import com.google.android.gms.internal.measurement.zzkv;

public final class zzkt
implements zzfo {
    private static final zzkt zza;
    private final zzfo zzb;

    static {
        zzkt zzkt2;
        zza = zzkt2 = new zzkt();
    }

    public zzkt() {
        Object object = new zzkv();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzku zzc() {
        return (zzku)this.zzb.zza();
    }
}

