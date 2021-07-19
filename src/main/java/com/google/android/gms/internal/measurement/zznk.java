/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznl;
import com.google.android.gms.internal.measurement.zznm;

public final class zznk
implements zzfo {
    private static final zznk zza;
    private final zzfo zzb;

    static {
        zznk zznk2;
        zza = zznk2 = new zznk();
    }

    public zznk() {
        Object object = new zznm();
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

    public final zznl zzd() {
        return (zznl)this.zzb.zza();
    }
}

