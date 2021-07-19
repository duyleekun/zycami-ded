/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public class Utf8$UnpairedSurrogateException
extends IllegalArgumentException {
    public Utf8$UnpairedSurrogateException(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(n10);
        stringBuilder.append(" of ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        super(string2);
    }
}

