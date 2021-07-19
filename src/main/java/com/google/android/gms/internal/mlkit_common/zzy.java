/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzx;
import java.util.Objects;

public final class zzy {
    public static int zza(int n10, int n11) {
        Object object;
        if (n10 >= 0 && n10 < n11) {
            return n10;
        }
        int n12 = 1;
        int n13 = 2;
        String string2 = "index";
        if (n10 >= 0) {
            if (n11 < 0) {
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("negative size: ");
                stringBuilder.append(n11);
                String string3 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                throw illegalArgumentException;
            }
            int n14 = 3;
            Object[] objectArray = new Object[n14];
            objectArray[0] = string2;
            objectArray[n12] = object = Integer.valueOf(n10);
            objectArray[n13] = object = Integer.valueOf(n11);
            object = zzx.zza("%s (%s) must be less than size (%s)", objectArray);
        } else {
            Object[] objectArray = new Object[n13];
            objectArray[0] = string2;
            objectArray[n12] = object = Integer.valueOf(n10);
            object = zzx.zza("%s (%s) must not be negative", objectArray);
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static Object zza(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    private static String zza(int n10, int n11, String string2) {
        int n12 = 1;
        int n13 = 2;
        if (n10 < 0) {
            Object[] objectArray = new Object[n13];
            objectArray[0] = string2;
            Integer n14 = n10;
            objectArray[n12] = n14;
            return zzx.zza("%s (%s) must not be negative", objectArray);
        }
        if (n11 >= 0) {
            Object[] objectArray = new Object[3];
            objectArray[0] = string2;
            Integer n15 = n10;
            objectArray[n12] = n15;
            n15 = n11;
            objectArray[n13] = n15;
            return zzx.zza("%s (%s) must not be greater than size (%s)", objectArray);
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("negative size: ");
        stringBuilder.append(n11);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static void zza(int n10, int n11, int n12) {
        Object object;
        if (n10 >= 0 && n11 >= n10 && n11 <= n12) {
            return;
        }
        if (n10 >= 0 && n10 <= n12) {
            if (n11 >= 0 && n11 <= n12) {
                n12 = 2;
                Object[] objectArray = new Object[n12];
                Integer n13 = n11;
                objectArray[0] = n13;
                n11 = 1;
                objectArray[n11] = object = Integer.valueOf(n10);
                object = zzx.zza("end index (%s) must not be less than start index (%s)", objectArray);
            } else {
                object = zzy.zza(n11, n12, "end index");
            }
        } else {
            String string2 = "start index";
            object = zzy.zza(n10, n12, string2);
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static void zza(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public static int zzb(int n10, int n11) {
        if (n10 >= 0 && n10 <= n11) {
            return n10;
        }
        String string2 = zzy.zza(n10, n11, "index");
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }
}

