/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;

public abstract class TokenResult$Builder {
    public abstract TokenResult build();

    public abstract TokenResult$Builder setResponseCode(TokenResult$ResponseCode var1);

    public abstract TokenResult$Builder setToken(String var1);

    public abstract TokenResult$Builder setTokenExpirationTimestamp(long var1);
}

