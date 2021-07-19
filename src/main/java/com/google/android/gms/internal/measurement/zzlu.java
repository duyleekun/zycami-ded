/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzlv;
import com.google.android.gms.internal.measurement.zzlw;

public final class zzlu
implements zzfo {
    private static final zzlu zza;
    private final zzfo zzb;

    static {
        zzlu zzlu2;
        zza = zzlu2 = new zzlu();
    }

    public zzlu() {
        Object object = new zzlw();
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

    public final zzlv zzd() {
        return (zzlv)this.zzb.zza();
    }
}

