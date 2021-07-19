/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzdj;
import com.google.android.gms.internal.clearcut.zzdk;
import java.lang.reflect.Constructor;

public final class zzdl {
    private static final zzdj zzmf = zzdl.zzce();
    private static final zzdj zzmg;

    static {
        zzdk zzdk2 = new zzdk();
        zzmg = zzdk2;
    }

    public static zzdj zzcc() {
        return zzmf;
    }

    public static zzdj zzcd() {
        return zzmg;
    }

    private static zzdj zzce() {
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
        return (zzdj)((Object)constructor);
    }
}

