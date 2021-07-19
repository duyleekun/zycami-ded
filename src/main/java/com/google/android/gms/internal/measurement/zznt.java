/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznu;
import com.google.android.gms.internal.measurement.zznv;

public final class zznt
implements zzfo {
    private static final zznt zza;
    private final zzfo zzb;

    static {
        zznt zznt2;
        zza = zznt2 = new zznt();
    }

    public zznt() {
        Object object = new zznv();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zznu zzc() {
        return (zznu)this.zzb.zza();
    }
}

