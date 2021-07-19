/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

public final class zzaw {
    private static final Class zzfb;
    private static final boolean zzfc;

    static {
        boolean bl2;
        zzfb = zzaw.zze("libcore.io.Memory");
        Class clazz = zzaw.zze("org.robolectric.Robolectric");
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        zzfc = bl2;
    }

    private static Class zze(String string2) {
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static boolean zzx() {
        boolean bl2;
        Class clazz = zzfb;
        return clazz != null && !(bl2 = zzfc);
    }

    public static Class zzy() {
        return zzfb;
    }
}

