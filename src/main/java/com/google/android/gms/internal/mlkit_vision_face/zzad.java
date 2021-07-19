/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

public final class zzad {
    public static int zza(int n10, String string2) {
        if (n10 >= 0) {
            return n10;
        }
        int n11 = String.valueOf(string2).length() + 40;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }
}

