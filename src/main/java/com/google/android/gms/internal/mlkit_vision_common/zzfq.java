/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzfn;
import com.google.android.gms.internal.mlkit_vision_common.zzfo;
import java.lang.reflect.Constructor;

public final class zzfq {
    private static final zzfo zza = zzfq.zzc();
    private static final zzfo zzb;

    static {
        zzfn zzfn2 = new zzfn();
        zzb = zzfn2;
    }

    public static zzfo zza() {
        return zza;
    }

    public static zzfo zzb() {
        return zzb;
    }

    private static zzfo zzc() {
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
        return (zzfo)((Object)constructor);
    }
}

