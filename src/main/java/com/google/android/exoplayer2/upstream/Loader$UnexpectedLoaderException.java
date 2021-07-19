/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class Loader$UnexpectedLoaderException
extends IOException {
    public Loader$UnexpectedLoaderException(Throwable throwable) {
        String string2 = throwable.getClass().getSimpleName();
        String string3 = throwable.getMessage();
        int n10 = String.valueOf(string2).length() + 13;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("Unexpected ");
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        super(string2, throwable);
    }
}

