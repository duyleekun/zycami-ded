/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

public final class zzgd {
    private static final Class zza;
    private static final boolean zzb;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        boolean bl2;
        Object object = "libcore.io.Memory";
        Class<?> clazz = null;
        try {
            object = Class.forName((String)object);
        }
        catch (Throwable throwable) {
            bl2 = false;
            object = null;
        }
        zza = object;
        object = "org.robolectric.Robolectric";
        try {
            clazz = Class.forName((String)object);
        }
        catch (Throwable throwable) {}
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        zzb = bl2;
    }

    public static boolean zza() {
        boolean bl2;
        Class clazz = zza;
        return clazz != null && !(bl2 = zzb);
    }

    public static Class zzb() {
        return zza;
    }
}

