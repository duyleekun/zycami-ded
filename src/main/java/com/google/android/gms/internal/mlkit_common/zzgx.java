/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgs;
import com.google.android.gms.internal.mlkit_common.zzgt;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzgv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzgx
implements zzgu {
    public final int zza(int n10, Object object, Object object2) {
        object = (zzgv)object;
        object2 = (zzgt)object2;
        n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
        object2 = null;
        if (n10 != 0) {
            return 0;
        }
        Iterator iterator2 = ((zzgv)object).entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return 0;
        }
        iterator2 = (Map.Entry)iterator2.next();
        iterator2.getKey();
        iterator2.getValue();
        iterator2 = new NoSuchMethodError();
        throw iterator2;
    }

    public final Object zza(Object object, Object object2) {
        object = (zzgv)object;
        boolean bl2 = ((HashMap)(object2 = (zzgv)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzgv)object).zzc();
            if (!bl2) {
                object = ((zzgv)object).zza();
            }
            ((zzgv)object).zza((zzgv)object2);
        }
        return object;
    }

    public final Map zza(Object object) {
        return (zzgv)object;
    }

    public final Object zzb(Object object) {
        ((zzgv)object).zzb();
        return object;
    }

    public final zzgs zzc(Object object) {
        object = (zzgt)object;
        object = new NoSuchMethodError();
        throw object;
    }
}

