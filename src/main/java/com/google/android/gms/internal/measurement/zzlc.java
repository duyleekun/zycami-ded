/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzld;
import com.google.android.gms.internal.measurement.zzle;

public final class zzlc
implements zzfo {
    private static final zzlc zza;
    private final zzfo zzb;

    static {
        zzlc zzlc2;
        zza = zzlc2 = new zzlc();
    }

    public zzlc() {
        Object object = new zzle();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        zza.zzg().zza();
        return true;
    }

    public static boolean zzc() {
        return zza.zzg().zzb();
    }

    public static boolean zzd() {
        return zza.zzg().zzc();
    }

    public static boolean zze() {
        return zza.zzg().zzd();
    }

    public static long zzf() {
        return zza.zzg().zze();
    }

    public final zzld zzg() {
        return (zzld)this.zzb.zza();
    }
}

