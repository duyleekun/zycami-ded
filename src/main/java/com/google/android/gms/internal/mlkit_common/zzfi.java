/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfg;
import com.google.android.gms.internal.mlkit_common.zzfj;
import java.lang.reflect.Constructor;

public final class zzfi {
    private static final zzfg zza;
    private static final zzfg zzb;

    static {
        zzfj zzfj2 = new zzfj();
        zza = zzfj2;
        zzb = zzfi.zzc();
    }

    public static zzfg zza() {
        return zza;
    }

    public static zzfg zzb() {
        Object object = zzb;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }

    private static zzfg zzc() {
        Object[] objectArray;
        Constructor constructor = "com.google.protobuf.ExtensionSchemaFull";
        try {
            constructor = Class.forName((String)((Object)constructor));
            objectArray = null;
        }
        catch (Exception exception) {
            return null;
        }
        Class[] classArray = new Class[]{};
        constructor = ((Class)((Object)constructor)).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        constructor = constructor.newInstance(objectArray);
        return (zzfg)((Object)constructor);
    }
}

