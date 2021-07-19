/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.internal.measurement.zzln;

public final class zzll
implements zzfo {
    private static final zzll zza;
    private final zzfo zzb;

    static {
        zzll zzll2;
        zza = zzll2 = new zzll();
    }

    public zzll() {
        Object object = new zzln();
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

    public final zzlm zzd() {
        return (zzlm)this.zzb.zza();
    }
}

