/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznf;
import com.google.android.gms.internal.measurement.zzng;

public final class zzne
implements zzfo {
    private static final zzne zza;
    private final zzfo zzb;

    static {
        zzne zzne2;
        zza = zzne2 = new zzne();
    }

    public zzne() {
        Object object = new zzng();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zznf zzc() {
        return (zznf)this.zzb.zza();
    }
}

