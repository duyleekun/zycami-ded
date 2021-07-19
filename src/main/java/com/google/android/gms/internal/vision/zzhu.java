/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzhs;
import java.lang.reflect.Constructor;

public final class zzhu {
    private static final zzhq zzvb;
    private static final zzhq zzvc;

    static {
        zzhs zzhs2 = new zzhs();
        zzvb = zzhs2;
        zzvc = zzhu.zzgj();
    }

    private static zzhq zzgj() {
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
        return (zzhq)((Object)constructor);
    }

    public static zzhq zzgk() {
        return zzvb;
    }

    public static zzhq zzgl() {
        Object object = zzvc;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }
}

