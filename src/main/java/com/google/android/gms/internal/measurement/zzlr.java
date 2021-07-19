/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzls;
import com.google.android.gms.internal.measurement.zzlt;

public final class zzlr
implements zzfo {
    private static final zzlr zza;
    private final zzfo zzb;

    static {
        zzlr zzlr2;
        zza = zzlr2 = new zzlr();
    }

    public zzlr() {
        Object object = new zzlt();
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

    public final zzls zzd() {
        return (zzls)this.zzb.zza();
    }
}

