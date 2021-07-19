/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public final class zzgl {
    private static final Class zzti;
    private static final boolean zztj;

    static {
        boolean bl2;
        zzti = zzgl.zzu("libcore.io.Memory");
        Class clazz = zzgl.zzu("org.robolectric.Robolectric");
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        zztj = bl2;
    }

    public static boolean zzel() {
        boolean bl2;
        Class clazz = zzti;
        return clazz != null && !(bl2 = zztj);
    }

    public static Class zzem() {
        return zzti;
    }

    private static Class zzu(String string2) {
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}

