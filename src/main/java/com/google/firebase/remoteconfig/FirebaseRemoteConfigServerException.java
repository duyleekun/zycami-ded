/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

public class FirebaseRemoteConfigServerException
extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int n10, String string2) {
        super(string2);
        this.httpStatusCode = n10;
    }

    public FirebaseRemoteConfigServerException(int n10, String string2, Throwable throwable) {
        super(string2, throwable);
        this.httpStatusCode = n10;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}

