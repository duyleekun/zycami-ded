/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_TokenResult$1;
import com.google.firebase.installations.remote.AutoValue_TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;

public final class AutoValue_TokenResult
extends TokenResult {
    private final TokenResult$ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    private AutoValue_TokenResult(String string2, long l10, TokenResult$ResponseCode tokenResult$ResponseCode) {
        this.token = string2;
        this.tokenExpirationTimestamp = l10;
        this.responseCode = tokenResult$ResponseCode;
    }

    public /* synthetic */ AutoValue_TokenResult(String string2, long l10, TokenResult$ResponseCode tokenResult$ResponseCode, AutoValue_TokenResult$1 autoValue_TokenResult$1) {
        this(string2, l10, tokenResult$ResponseCode);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof TokenResult;
        if (bl3) {
            boolean bl4;
            long l10;
            long l11;
            long l12;
            String string2;
            object = (TokenResult)object;
            Object object2 = this.token;
            if (!(object2 == null ? (object2 = ((TokenResult)object).getToken()) == null : (bl3 = ((String)object2).equals(string2 = ((TokenResult)object).getToken()))) || (bl3 = (l12 = (l11 = this.tokenExpirationTimestamp) - (l10 = ((TokenResult)object).getTokenExpirationTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) || !((object2 = this.responseCode) == null ? (object = ((TokenResult)object).getResponseCode()) == null : (bl4 = ((Enum)object2).equals(object = ((TokenResult)object).getResponseCode())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public TokenResult$ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getToken() {
        return this.token;
    }

    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        int n10;
        String string2 = this.token;
        int n11 = 0;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        int n12 = 1000003;
        n10 = (n10 ^ n12) * n12;
        long l10 = this.tokenExpirationTimestamp;
        int n13 = 32;
        long l11 = l10 >>> n13;
        int n14 = (int)(l10 ^= l11);
        n10 = (n10 ^ n14) * n12;
        TokenResult$ResponseCode tokenResult$ResponseCode = this.responseCode;
        if (tokenResult$ResponseCode != null) {
            n11 = tokenResult$ResponseCode.hashCode();
        }
        return n10 ^ n11;
    }

    public TokenResult$Builder toBuilder() {
        AutoValue_TokenResult$Builder autoValue_TokenResult$Builder = new AutoValue_TokenResult$Builder(this, null);
        return autoValue_TokenResult$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TokenResult{token=");
        Object object = this.token;
        stringBuilder.append((String)object);
        stringBuilder.append(", tokenExpirationTimestamp=");
        long l10 = this.tokenExpirationTimestamp;
        stringBuilder.append(l10);
        stringBuilder.append(", responseCode=");
        object = this.responseCode;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

