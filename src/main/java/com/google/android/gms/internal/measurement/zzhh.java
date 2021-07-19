/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhg;
import java.lang.reflect.Constructor;

public final class zzhh {
    private static final zzhf zza;
    private static final zzhf zzb;

    static {
        Object object = new zzhg();
        zza = object;
        object = "com.google.protobuf.ExtensionSchemaFull";
        object = Class.forName((String)object);
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        object = ((Constructor)object).newInstance(objectArray);
        try {
            object = (zzhf)object;
        }
        catch (Exception exception) {
            object = null;
        }
        zzb = object;
    }

    public static zzhf zza() {
        return zza;
    }

    public static zzhf zzb() {
        Object object = zzb;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }
}

