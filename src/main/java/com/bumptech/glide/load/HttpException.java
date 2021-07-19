/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException
extends IOException {
    public static final int UNKNOWN = 255;
    private static final long serialVersionUID = 1L;
    private final int statusCode;

    public HttpException(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Http request failed with status code: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        this((String)charSequence, n10);
    }

    public HttpException(String string2) {
        this(string2, -1);
    }

    public HttpException(String string2, int n10) {
        this(string2, n10, null);
    }

    public HttpException(String string2, int n10, Throwable throwable) {
        super(string2, throwable);
        this.statusCode = n10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

