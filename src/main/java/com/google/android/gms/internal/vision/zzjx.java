/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzju;
import com.google.android.gms.internal.vision.zzjv;
import java.lang.reflect.Constructor;

public final class zzjx {
    private static final zzjv zzabb = zzjx.zzii();
    private static final zzjv zzabc;

    static {
        zzju zzju2 = new zzju();
        zzabc = zzju2;
    }

    public static zzjv zzig() {
        return zzabb;
    }

    public static zzjv zzih() {
        return zzabc;
    }

    private static zzjv zzii() {
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
        return (zzjv)((Object)constructor);
    }
}

