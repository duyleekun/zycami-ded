/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgg;
import com.google.android.gms.internal.mlkit_vision_face.zzhc;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzie;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzia {
    private static final zzia zza;
    private final zzie zzb;
    private final ConcurrentMap zzc;

    static {
        zzia zzia2;
        zza = zzia2 = new zzia();
    }

    private zzia() {
        Object object = new ConcurrentHashMap();
        this.zzc = object;
        this.zzb = object = new zzhc();
    }

    public static zzia zza() {
        return zza;
    }

    public final zzib zza(Class object) {
        Object object2 = "messageType";
        zzgg.zza(object, (String)object2);
        Object object3 = (zzib)this.zzc.get(object);
        if (object3 == null) {
            object3 = this.zzb.zza((Class)object);
            zzgg.zza(object, (String)object2);
            zzgg.zza(object3, "schema");
            object2 = this.zzc;
            object = object2.putIfAbsent(object, object3);
            if (object != null) {
                object3 = object;
            }
        }
        return object3;
    }

    public final zzib zza(Object clazz) {
        clazz = clazz.getClass();
        return this.zza(clazz);
    }
}

