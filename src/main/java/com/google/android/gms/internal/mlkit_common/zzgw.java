/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzgx;
import java.lang.reflect.Constructor;

public final class zzgw {
    private static final zzgu zza = zzgw.zzc();
    private static final zzgu zzb;

    static {
        zzgx zzgx2 = new zzgx();
        zzb = zzgx2;
    }

    public static zzgu zza() {
        return zza;
    }

    public static zzgu zzb() {
        return zzb;
    }

    private static zzgu zzc() {
        Object[] objectArray;
        Constructor constructor = "com.google.protobuf.MapFieldSchemaFull";
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
        return (zzgu)((Object)constructor);
    }
}

