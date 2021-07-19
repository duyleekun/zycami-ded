/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException
extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    public final String getMessage() {
        String string2 = String.valueOf(this.zza);
        int n10 = String.valueOf(string2).length() + 8;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Missing ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

