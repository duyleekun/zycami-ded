/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.network;

public class HttpResponse {
    private final String body;
    private final int code;

    public HttpResponse(int n10, String string2) {
        this.code = n10;
        this.body = string2;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}

