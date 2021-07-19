/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzdw;
import com.google.android.gms.internal.clearcut.zzdx;
import java.lang.reflect.Constructor;

public final class zzdy {
    private static final zzdw zzna = zzdy.zzcl();
    private static final zzdw zznb;

    static {
        zzdx zzdx2 = new zzdx();
        zznb = zzdx2;
    }

    public static zzdw zzcj() {
        return zzna;
    }

    public static zzdw zzck() {
        return zznb;
    }

    private static zzdw zzcl() {
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
        return (zzdw)((Object)constructor);
    }
}

