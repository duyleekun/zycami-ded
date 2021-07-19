/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_InstallationResponse$1;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.TokenResult;

public final class AutoValue_InstallationResponse
extends InstallationResponse {
    private final TokenResult authToken;
    private final String fid;
    private final String refreshToken;
    private final InstallationResponse$ResponseCode responseCode;
    private final String uri;

    private AutoValue_InstallationResponse(String string2, String string3, String string4, TokenResult tokenResult, InstallationResponse$ResponseCode installationResponse$ResponseCode) {
        this.uri = string2;
        this.fid = string3;
        this.refreshToken = string4;
        this.authToken = tokenResult;
        this.responseCode = installationResponse$ResponseCode;
    }

    public /* synthetic */ AutoValue_InstallationResponse(String string2, String string3, String string4, TokenResult tokenResult, InstallationResponse$ResponseCode installationResponse$ResponseCode, AutoValue_InstallationResponse$1 autoValue_InstallationResponse$1) {
        this(string2, string3, string4, tokenResult, installationResponse$ResponseCode);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof InstallationResponse;
        if (bl3) {
            boolean bl4;
            Object object2;
            object = (InstallationResponse)object;
            Object object3 = this.uri;
            if (!((object3 == null ? (object3 = ((InstallationResponse)object).getUri()) == null : (bl3 = ((String)object3).equals(object2 = ((InstallationResponse)object).getUri()))) && ((object3 = this.fid) == null ? (object3 = ((InstallationResponse)object).getFid()) == null : (bl3 = ((String)object3).equals(object2 = ((InstallationResponse)object).getFid()))) && ((object3 = this.refreshToken) == null ? (object3 = ((InstallationResponse)object).getRefreshToken()) == null : (bl3 = ((String)object3).equals(object2 = ((InstallationResponse)object).getRefreshToken()))) && ((object3 = this.authToken) == null ? (object3 = ((InstallationResponse)object).getAuthToken()) == null : (bl3 = object3.equals(object2 = ((InstallationResponse)object).getAuthToken()))) && ((object3 = this.responseCode) == null ? (object = ((InstallationResponse)object).getResponseCode()) == null : (bl4 = ((Enum)object3).equals(object = ((InstallationResponse)object).getResponseCode()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public TokenResult getAuthToken() {
        return this.authToken;
    }

    public String getFid() {
        return this.fid;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public InstallationResponse$ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getUri() {
        return this.uri;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.uri;
        int n12 = 0;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        int n13 = 1000003;
        n11 = (n11 ^ n13) * n13;
        Object object = this.fid;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        object = this.refreshToken;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        object = this.authToken;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n11 = (n11 ^ n10) * n13;
        InstallationResponse$ResponseCode installationResponse$ResponseCode = this.responseCode;
        if (installationResponse$ResponseCode != null) {
            n12 = installationResponse$ResponseCode.hashCode();
        }
        return n11 ^ n12;
    }

    public InstallationResponse$Builder toBuilder() {
        AutoValue_InstallationResponse$Builder autoValue_InstallationResponse$Builder = new AutoValue_InstallationResponse$Builder(this, null);
        return autoValue_InstallationResponse$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstallationResponse{uri=");
        Object object = this.uri;
        stringBuilder.append((String)object);
        stringBuilder.append(", fid=");
        object = this.fid;
        stringBuilder.append((String)object);
        stringBuilder.append(", refreshToken=");
        object = this.refreshToken;
        stringBuilder.append((String)object);
        stringBuilder.append(", authToken=");
        object = this.authToken;
        stringBuilder.append(object);
        stringBuilder.append(", responseCode=");
        object = this.responseCode;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

