/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfn;
import java.io.Serializable;

public abstract class zzfm
implements Serializable {
    public static zzfm zzc() {
        return zzfk.zza;
    }

    public static zzfm zzd(Object object) {
        zzfn zzfn2 = new zzfn(object);
        return zzfn2;
    }

    public abstract boolean zza();

    public abstract Object zzb();
}

