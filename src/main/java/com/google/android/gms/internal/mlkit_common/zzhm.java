/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzgo;
import com.google.android.gms.internal.mlkit_common.zzhq;
import com.google.android.gms.internal.mlkit_common.zzhr;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzhm {
    private static final zzhm zza;
    private final zzhq zzb;
    private final ConcurrentMap zzc;

    static {
        zzhm zzhm2;
        zza = zzhm2 = new zzhm();
    }

    private zzhm() {
        Object object = new ConcurrentHashMap();
        this.zzc = object;
        this.zzb = object = new zzgo();
    }

    public static zzhm zza() {
        return zza;
    }

    public final zzhr zza(Class object) {
        Object object2 = "messageType";
        zzfs.zza(object, (String)object2);
        Object object3 = (zzhr)this.zzc.get(object);
        if (object3 == null) {
            object3 = this.zzb.zza((Class)object);
            zzfs.zza(object, (String)object2);
            zzfs.zza(object3, "schema");
            object2 = this.zzc;
            object = object2.putIfAbsent(object, object3);
            if (object != null) {
                object3 = object;
            }
        }
        return object3;
    }

    public final zzhr zza(Object clazz) {
        clazz = clazz.getClass();
        return this.zza(clazz);
    }
}

