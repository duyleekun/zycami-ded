/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzmr;

public final class zzmp
implements zzfo {
    private static final zzmp zza;
    private final zzfo zzb;

    static {
        zzmp zzmp2;
        zza = zzmp2 = new zzmp();
    }

    public zzmp() {
        Object object = new zzmr();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        zza.zze().zza();
        return true;
    }

    public static boolean zzc() {
        return zza.zze().zzb();
    }

    public static boolean zzd() {
        return zza.zze().zzc();
    }

    public final zzmq zze() {
        return (zzmq)this.zzb.zza();
    }
}

