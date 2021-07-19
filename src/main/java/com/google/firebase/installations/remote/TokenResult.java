/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;

public abstract class TokenResult {
    public static TokenResult$Builder builder() {
        AutoValue_TokenResult$Builder autoValue_TokenResult$Builder = new AutoValue_TokenResult$Builder();
        return autoValue_TokenResult$Builder.setTokenExpirationTimestamp(0L);
    }

    public abstract TokenResult$ResponseCode getResponseCode();

    public abstract String getToken();

    public abstract long getTokenExpirationTimestamp();

    public abstract TokenResult$Builder toBuilder();
}

