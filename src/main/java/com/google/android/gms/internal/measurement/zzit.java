/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzis;
import java.lang.reflect.Constructor;

public final class zzit {
    private static final zzis zza;
    private static final zzis zzb;

    static {
        Object object = "com.google.protobuf.MapFieldSchemaFull";
        object = Class.forName((String)object);
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        object = ((Constructor)object).newInstance(objectArray);
        try {
            object = (zzis)object;
        }
        catch (Exception exception) {
            object = null;
        }
        zza = object;
        zzb = object = new zzis();
    }

    public static zzis zza() {
        return zza;
    }

    public static zzis zzb() {
        return zzb;
    }
}

