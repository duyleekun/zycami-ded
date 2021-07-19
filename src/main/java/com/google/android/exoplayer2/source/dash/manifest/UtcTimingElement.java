/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

public final class UtcTimingElement {
    public final String schemeIdUri;
    public final String value;

    public UtcTimingElement(String string2, String string3) {
        this.schemeIdUri = string2;
        this.value = string3;
    }

    public String toString() {
        String string2 = this.schemeIdUri;
        String string3 = this.value;
        int n10 = String.valueOf(string2).length() + 2;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

