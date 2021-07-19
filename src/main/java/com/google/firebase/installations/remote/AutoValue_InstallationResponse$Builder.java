/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_InstallationResponse;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse$1;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.TokenResult;

public final class AutoValue_InstallationResponse$Builder
extends InstallationResponse$Builder {
    private TokenResult authToken;
    private String fid;
    private String refreshToken;
    private InstallationResponse$ResponseCode responseCode;
    private String uri;

    public AutoValue_InstallationResponse$Builder() {
    }

    private AutoValue_InstallationResponse$Builder(InstallationResponse object) {
        Object object2 = object.getUri();
        this.uri = object2;
        object2 = object.getFid();
        this.fid = object2;
        object2 = object.getRefreshToken();
        this.refreshToken = object2;
        this.authToken = object2 = object.getAuthToken();
        object = object.getResponseCode();
        this.responseCode = object;
    }

    public /* synthetic */ AutoValue_InstallationResponse$Builder(InstallationResponse installationResponse, AutoValue_InstallationResponse$1 autoValue_InstallationResponse$1) {
        this(installationResponse);
    }

    public InstallationResponse build() {
        String string2 = this.uri;
        String string3 = this.fid;
        String string4 = this.refreshToken;
        TokenResult tokenResult = this.authToken;
        InstallationResponse$ResponseCode installationResponse$ResponseCode = this.responseCode;
        AutoValue_InstallationResponse autoValue_InstallationResponse = new AutoValue_InstallationResponse(string2, string3, string4, tokenResult, installationResponse$ResponseCode, null);
        return autoValue_InstallationResponse;
    }

    public InstallationResponse$Builder setAuthToken(TokenResult tokenResult) {
        this.authToken = tokenResult;
        return this;
    }

    public InstallationResponse$Builder setFid(String string2) {
        this.fid = string2;
        return this;
    }

    public InstallationResponse$Builder setRefreshToken(String string2) {
        this.refreshToken = string2;
        return this;
    }

    public InstallationResponse$Builder setResponseCode(InstallationResponse$ResponseCode installationResponse$ResponseCode) {
        this.responseCode = installationResponse$ResponseCode;
        return this;
    }

    public InstallationResponse$Builder setUri(String string2) {
        this.uri = string2;
        return this;
    }
}

