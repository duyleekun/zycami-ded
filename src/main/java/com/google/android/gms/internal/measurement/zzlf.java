/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzlg;
import com.google.android.gms.internal.measurement.zzlh;

public final class zzlf
implements zzfo {
    private static final zzlf zza;
    private final zzfo zzb;

    static {
        zzlf zzlf2;
        zza = zzlf2 = new zzlf();
    }

    public zzlf() {
        Object object = new zzlh();
        object = zzfs.zzb(object);
        this.zzb = object = zzfs.zza((zzfo)object);
    }

    public static boolean zzb() {
        return zza.zzc().zza();
    }

    public final zzlg zzc() {
        return (zzlg)this.zzb.zza();
    }
}

