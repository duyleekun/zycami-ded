/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbu;
import com.google.android.gms.internal.clearcut.zzbv;
import java.lang.reflect.Constructor;

public final class zzbx {
    private static final zzbu zzgr;
    private static final zzbu zzgs;

    static {
        zzbv zzbv2 = new zzbv();
        zzgr = zzbv2;
        zzgs = zzbx.zzao();
    }

    private static zzbu zzao() {
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
        return (zzbu)((Object)constructor);
    }

    public static zzbu zzap() {
        return zzgr;
    }

    public static zzbu zzaq() {
        Object object = zzgs;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }
}

