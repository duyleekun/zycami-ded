/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfj;
import com.google.android.gms.internal.mlkit_vision_common.zzfl;
import com.google.android.gms.internal.mlkit_vision_common.zzfm;
import com.google.android.gms.internal.mlkit_vision_common.zzfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzfn
implements zzfo {
    public final int zza(int n10, Object object, Object object2) {
        object = (zzfl)object;
        object2 = (zzfj)object2;
        n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
        object2 = null;
        if (n10 != 0) {
            return 0;
        }
        Iterator iterator2 = ((zzfl)object).entrySet().iterator();
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

    public final zzfm zza(Object object) {
        object = (zzfj)object;
        object = new NoSuchMethodError();
        throw object;
    }

    public final Object zza(Object object, Object object2) {
        object = (zzfl)object;
        boolean bl2 = ((HashMap)(object2 = (zzfl)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzfl)object).zzc();
            if (!bl2) {
                object = ((zzfl)object).zza();
            }
            ((zzfl)object).zza((zzfl)object2);
        }
        return object;
    }

    public final Map zzb(Object object) {
        return (zzfl)object;
    }

    public final Object zzc(Object object) {
        ((zzfl)object).zzb();
        return object;
    }
}

