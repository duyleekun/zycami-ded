/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzj;

public final class zzk {
    private static final zzh zza;
    private static volatile zzh zzb;

    static {
        zzj zzj2 = new zzj(null);
        zza = zzj2;
        zzb = zzj2;
    }

    public static zzh zza() {
        return zzb;
    }
}

