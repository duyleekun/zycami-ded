/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzhh;
import com.google.android.gms.internal.mlkit_vision_face.zzhi;
import java.lang.reflect.Constructor;

public final class zzhk {
    private static final zzhi zza = zzhk.zzc();
    private static final zzhi zzb;

    static {
        zzhh zzhh2 = new zzhh();
        zzb = zzhh2;
    }

    public static zzhi zza() {
        return zza;
    }

    public static zzhi zzb() {
        return zzb;
    }

    private static zzhi zzc() {
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
        return (zzhi)((Object)constructor);
    }
}

