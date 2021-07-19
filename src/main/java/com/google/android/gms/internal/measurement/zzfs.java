/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import java.io.Serializable;

public final class zzfs {
    public static zzfo zza(zzfo zzfo2) {
        boolean bl2 = zzfo2 instanceof zzfq;
        if (!bl2 && !(bl2 = zzfo2 instanceof zzfp)) {
            bl2 = zzfo2 instanceof Serializable;
            zzfo zzfo3 = bl2 ? new zzfp(zzfo2) : new zzfq(zzfo2);
            return zzfo3;
        }
        return zzfo2;
    }

    public static zzfo zzb(Object object) {
        zzfr zzfr2 = new zzfr(object);
        return zzfr2;
    }
}

