/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhg;
import com.google.android.gms.internal.mlkit_common.zzhj;
import java.lang.reflect.Constructor;

public final class zzhi {
    private static final zzhg zza = zzhi.zzc();
    private static final zzhg zzb;

    static {
        zzhj zzhj2 = new zzhj();
        zzb = zzhj2;
    }

    public static zzhg zza() {
        return zza;
    }

    public static zzhg zzb() {
        return zzb;
    }

    private static zzhg zzc() {
        Object[] objectArray;
        Constructor constructor = "com.google.protobuf.NewInstanceSchemaFull";
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
        return (zzhg)((Object)constructor);
    }
}

