/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzht;
import com.google.android.gms.internal.mlkit_vision_face.zzhu;
import java.lang.reflect.Constructor;

public final class zzhw {
    private static final zzhu zza = zzhw.zzc();
    private static final zzhu zzb;

    static {
        zzht zzht2 = new zzht();
        zzb = zzht2;
    }

    public static zzhu zza() {
        return zza;
    }

    public static zzhu zzb() {
        return zzb;
    }

    private static zzhu zzc() {
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
        return (zzhu)((Object)constructor);
    }
}

