/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfz;
import com.google.android.gms.internal.mlkit_vision_common.zzga;
import java.lang.reflect.Constructor;

public final class zzgc {
    private static final zzga zza = zzgc.zzc();
    private static final zzga zzb;

    static {
        zzfz zzfz2 = new zzfz();
        zzb = zzfz2;
    }

    public static zzga zza() {
        return zza;
    }

    public static zzga zzb() {
        return zzb;
    }

    private static zzga zzc() {
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
        return (zzga)((Object)constructor);
    }
}

