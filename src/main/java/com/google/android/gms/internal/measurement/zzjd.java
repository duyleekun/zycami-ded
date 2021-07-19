/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjc;
import java.lang.reflect.Constructor;

public final class zzjd {
    private static final zzjc zza;
    private static final zzjc zzb;

    static {
        Object object = "com.google.protobuf.NewInstanceSchemaFull";
        object = Class.forName((String)object);
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        object = ((Constructor)object).newInstance(objectArray);
        try {
            object = (zzjc)object;
        }
        catch (Exception exception) {
            object = null;
        }
        zza = object;
        zzb = object = new zzjc();
    }

    public static zzjc zza() {
        return zza;
    }

    public static zzjc zzb() {
        return zzb;
    }
}

