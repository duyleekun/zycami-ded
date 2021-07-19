/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

public final class zzhm
extends IllegalArgumentException {
    public zzhm(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(n10);
        stringBuilder.append(" of ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        super(string2);
    }
}

