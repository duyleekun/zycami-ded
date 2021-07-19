/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zziq;
import com.google.android.gms.internal.measurement.zzir;
import java.util.HashMap;
import java.util.Map;

public final class zzis {
    public static final int zza(int n10, Object object, Object object2) {
        Object object3;
        boolean bl2;
        object = (zzir)object;
        object2 = (zziq)object2;
        n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
        if (n10 != 0 || !(bl2 = (object3 = ((zzir)object).entrySet().iterator()).hasNext())) {
            return 0;
        }
        object3 = (Map.Entry)object3.next();
        object3.getKey();
        object3.getValue();
        throw null;
    }

    public static final Object zzb(Object object, Object object2) {
        object = (zzir)object;
        boolean bl2 = ((HashMap)(object2 = (zzir)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzir)object).zze();
            if (!bl2) {
                object = ((zzir)object).zzc();
            }
            ((zzir)object).zzb((zzir)object2);
        }
        return object;
    }
}

