/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzip;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjj;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzjf {
    private static final zzjf zza;
    private final zzjj zzb;
    private final ConcurrentMap zzc;

    static {
        zzjf zzjf2;
        zza = zzjf2 = new zzjf();
    }

    private zzjf() {
        Object object = new ConcurrentHashMap();
        this.zzc = object;
        this.zzb = object = new zzip();
    }

    public static zzjf zza() {
        return zza;
    }

    public final zzji zzb(Class object) {
        Object object2 = "messageType";
        zzia.zzb(object, (String)object2);
        zzji zzji2 = (zzji)this.zzc.get(object);
        if (zzji2 == null) {
            zzji2 = this.zzb.zza((Class)object);
            zzia.zzb(object, (String)object2);
            zzia.zzb(zzji2, "schema");
            object2 = this.zzc;
            object = object2.putIfAbsent(object, zzji2);
            if (object != null) {
                return object;
            }
        }
        return zzji2;
    }
}

