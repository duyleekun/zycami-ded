/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzik;

public abstract class zzil {
    private static final zzil zza;
    private static final zzil zzb;

    static {
        zzil zzil2 = new zzij(null);
        zza = zzil2;
        zzil2 = new zzik(null);
        zzb = zzil2;
    }

    public /* synthetic */ zzil(zzii zzii2) {
    }

    public static zzil zzc() {
        return zza;
    }

    public static zzil zzd() {
        return zzb;
    }

    public abstract void zza(Object var1, long var2);

    public abstract void zzb(Object var1, Object var2, long var3);
}

