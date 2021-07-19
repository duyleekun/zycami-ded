/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdz;
import com.google.android.gms.internal.mlkit_vision_common.zzea;
import java.lang.reflect.Constructor;

public final class zzec {
    private static final zzea zza;
    private static final zzea zzb;

    static {
        zzdz zzdz2 = new zzdz();
        zza = zzdz2;
        zzb = zzec.zzc();
    }

    public static zzea zza() {
        return zza;
    }

    public static zzea zzb() {
        Object object = zzb;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }

    private static zzea zzc() {
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
        return (zzea)((Object)constructor);
    }
}

