/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.AutoValue_TokenResult$1;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;

public final class AutoValue_TokenResult$Builder
extends TokenResult$Builder {
    private TokenResult$ResponseCode responseCode;
    private String token;
    private Long tokenExpirationTimestamp;

    public AutoValue_TokenResult$Builder() {
    }

    private AutoValue_TokenResult$Builder(TokenResult object) {
        Object object2 = object.getToken();
        this.token = object2;
        this.tokenExpirationTimestamp = object2 = Long.valueOf(object.getTokenExpirationTimestamp());
        object = object.getResponseCode();
        this.responseCode = object;
    }

    public /* synthetic */ AutoValue_TokenResult$Builder(TokenResult tokenResult, AutoValue_TokenResult$1 autoValue_TokenResult$1) {
        this(tokenResult);
    }

    public TokenResult build() {
        boolean bl2;
        Object object = this.tokenExpirationTimestamp;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" tokenExpirationTimestamp");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.token;
            long l10 = this.tokenExpirationTimestamp;
            TokenResult$ResponseCode tokenResult$ResponseCode = this.responseCode;
            Object object2 = object;
            object = new AutoValue_TokenResult(string3, l10, tokenResult$ResponseCode, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public TokenResult$Builder setResponseCode(TokenResult$ResponseCode tokenResult$ResponseCode) {
        this.responseCode = tokenResult$ResponseCode;
        return this;
    }

    public TokenResult$Builder setToken(String string2) {
        this.token = string2;
        return this;
    }

    public TokenResult$Builder setTokenExpirationTimestamp(long l10) {
        Long l11;
        this.tokenExpirationTimestamp = l11 = Long.valueOf(l10);
        return this;
    }
}

