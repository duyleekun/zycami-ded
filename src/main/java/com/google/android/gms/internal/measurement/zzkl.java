/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

public final class zzkl
extends IllegalArgumentException {
    public zzkl(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(n10);
        stringBuilder.append(" of ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        super(string2);
    }
}

