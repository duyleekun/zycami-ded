/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzni;
import com.google.android.gms.internal.measurement.zznj;

public final class zznh
implements zzfo {
    private static final zznh zza;
    private final zzfo zzb;

    static {
        zznh zznh2;
        zza = zznh2 = new zznh();
    }

    public zznh() {
        Object object = new zznj();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzni zzc() {
        return (zzni)this.zzb.zza();
    }
}

