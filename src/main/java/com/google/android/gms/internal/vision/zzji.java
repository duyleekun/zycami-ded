/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjg;
import com.google.android.gms.internal.vision.zzjj;
import java.lang.reflect.Constructor;

public final class zzji {
    private static final zzjg zzaag = zzji.zzic();
    private static final zzjg zzaah;

    static {
        zzjj zzjj2 = new zzjj();
        zzaah = zzjj2;
    }

    public static zzjg zzia() {
        return zzaag;
    }

    public static zzjg zzib() {
        return zzaah;
    }

    private static zzjg zzic() {
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
        return (zzjg)((Object)constructor);
    }
}

