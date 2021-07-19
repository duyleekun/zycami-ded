/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzmu;

public final class zzms
implements zzfo {
    private static final zzms zza;
    private final zzfo zzb;

    static {
        zzms zzms2;
        zza = zzms2 = new zzms();
    }

    public zzms() {
        Object object = new zzmu();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzmt zzc() {
        return (zzmt)this.zzb.zza();
    }
}

