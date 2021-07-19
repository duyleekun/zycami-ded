/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzno;
import com.google.android.gms.internal.measurement.zznp;

public final class zznn
implements zzfo {
    private static final zznn zza;
    private final zzfo zzb;

    static {
        zznn zznn2;
        zza = zznn2 = new zznn();
    }

    public zznn() {
        Object object = new zznp();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzno zzc() {
        return (zzno)this.zzb.zza();
    }
}

