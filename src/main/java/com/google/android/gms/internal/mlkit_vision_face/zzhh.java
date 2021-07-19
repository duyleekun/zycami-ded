/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzhd;
import com.google.android.gms.internal.mlkit_vision_face.zzhf;
import com.google.android.gms.internal.mlkit_vision_face.zzhg;
import com.google.android.gms.internal.mlkit_vision_face.zzhi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzhh
implements zzhi {
    public final int zza(int n10, Object object, Object object2) {
        object = (zzhf)object;
        object2 = (zzhd)object2;
        n10 = (int)(((HashMap)object).isEmpty() ? 1 : 0);
        object2 = null;
        if (n10 != 0) {
            return 0;
        }
        Iterator iterator2 = ((zzhf)object).entrySet().iterator();
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

    public final zzhg zza(Object object) {
        object = (zzhd)object;
        object = new NoSuchMethodError();
        throw object;
    }

    public final Object zza(Object object, Object object2) {
        object = (zzhf)object;
        boolean bl2 = ((HashMap)(object2 = (zzhf)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((zzhf)object).zzc();
            if (!bl2) {
                object = ((zzhf)object).zza();
            }
            ((zzhf)object).zza((zzhf)object2);
        }
        return object;
    }

    public final Map zzb(Object object) {
        return (zzhf)object;
    }

    public final Object zzc(Object object) {
        ((zzhf)object).zzb();
        return object;
    }
}

