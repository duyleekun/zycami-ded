/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzja;
import com.google.android.gms.internal.vision.zzke;
import com.google.android.gms.internal.vision.zzkf;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzkb {
    private static final zzkb zzabh;
    private final zzke zzabi;
    private final ConcurrentMap zzabj;

    static {
        zzkb zzkb2;
        zzabh = zzkb2 = new zzkb();
    }

    private zzkb() {
        Object object = new ConcurrentHashMap();
        this.zzabj = object;
        this.zzabi = object = new zzja();
    }

    public static zzkb zzik() {
        return zzabh;
    }

    public final zzkf zzf(Class object) {
        Object object2 = "messageType";
        zzie.zza(object, (String)object2);
        Object object3 = (zzkf)this.zzabj.get(object);
        if (object3 == null) {
            object3 = this.zzabi.zze((Class)object);
            zzie.zza(object, (String)object2);
            zzie.zza(object3, "schema");
            object2 = this.zzabj;
            object = object2.putIfAbsent(object, object3);
            if (object != null) {
                object3 = object;
            }
        }
        return object3;
    }

    public final zzkf zzx(Object clazz) {
        clazz = clazz.getClass();
        return this.zzf(clazz);
    }
}

