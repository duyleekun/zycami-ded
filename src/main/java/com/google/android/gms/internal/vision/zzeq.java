/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public final class zzeq {
    public static Object zzb(Object object, int n10) {
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append("at index ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new NullPointerException(string2);
        throw object;
    }
}

