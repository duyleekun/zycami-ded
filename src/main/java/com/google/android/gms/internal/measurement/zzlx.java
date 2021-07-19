/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzly;
import com.google.android.gms.internal.measurement.zzlz;

public final class zzlx
implements zzfo {
    private static final zzlx zza;
    private final zzfo zzb;

    static {
        zzlx zzlx2;
        zza = zzlx2 = new zzlx();
    }

    public zzlx() {
        Object object = new zzlz();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        zza.zzd().zza();
        return true;
    }

    public static boolean zzc() {
        return zza.zzd().zzb();
    }

    public final zzly zzd() {
        return (zzly)this.zzb.zza();
    }
}

