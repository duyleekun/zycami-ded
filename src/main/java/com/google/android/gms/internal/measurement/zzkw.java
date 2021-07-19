/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.internal.measurement.zzky;

public final class zzkw
implements zzfo {
    private static final zzkw zza;
    private final zzfo zzb;

    static {
        zzkw zzkw2;
        zza = zzkw2 = new zzkw();
    }

    public zzkw() {
        Object object = new zzky();
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

    public final zzkx zzd() {
        return (zzkx)this.zzb.zza();
    }
}

