/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzft;
import com.google.android.gms.internal.mlkit_vision_face.zzfu;
import java.lang.reflect.Constructor;

public final class zzfw {
    private static final zzfu zza;
    private static final zzfu zzb;

    static {
        zzft zzft2 = new zzft();
        zza = zzft2;
        zzb = zzfw.zzc();
    }

    public static zzfu zza() {
        return zza;
    }

    public static zzfu zzb() {
        Object object = zzb;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }

    private static zzfu zzc() {
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
        return (zzfu)((Object)constructor);
    }
}

