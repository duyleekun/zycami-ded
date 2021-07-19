/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznr;
import com.google.android.gms.internal.measurement.zzns;

public final class zznq
implements zzfo {
    private static final zznq zza;
    private final zzfo zzb;

    static {
        zznq zznq2;
        zza = zznq2 = new zznq();
    }

    public zznq() {
        Object object = new zzns();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zznr zzc() {
        return (zznr)this.zzb.zza();
    }
}

