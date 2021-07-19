/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzem;
import com.google.android.gms.internal.mlkit_vision_common.zzfi;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzgk;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzgg {
    private static final zzgg zza;
    private final zzgk zzb;
    private final ConcurrentMap zzc;

    static {
        zzgg zzgg2;
        zza = zzgg2 = new zzgg();
    }

    private zzgg() {
        Object object = new ConcurrentHashMap();
        this.zzc = object;
        this.zzb = object = new zzfi();
    }

    public static zzgg zza() {
        return zza;
    }

    public final zzgh zza(Class object) {
        Object object2 = "messageType";
        zzem.zza(object, (String)object2);
        Object object3 = (zzgh)this.zzc.get(object);
        if (object3 == null) {
            object3 = this.zzb.zza((Class)object);
            zzem.zza(object, (String)object2);
            zzem.zza(object3, "schema");
            object2 = this.zzc;
            object = object2.putIfAbsent(object, object3);
            if (object != null) {
                object3 = object;
            }
        }
        return object3;
    }

    public final zzgh zza(Object clazz) {
        clazz = clazz.getClass();
        return this.zza(clazz);
    }
}

