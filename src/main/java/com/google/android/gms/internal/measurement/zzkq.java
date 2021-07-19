/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzks;

public final class zzkq
implements zzfo {
    private static final zzkq zza;
    private final zzfo zzb;

    static {
        zzkq zzkq2;
        zza = zzkq2 = new zzkq();
    }

    public zzkq() {
        Object object = new zzks();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzkr zzc() {
        return (zzkr)this.zzb.zza();
    }
}

