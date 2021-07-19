/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.TokenResult;

public abstract class InstallationResponse$Builder {
    public abstract InstallationResponse build();

    public abstract InstallationResponse$Builder setAuthToken(TokenResult var1);

    public abstract InstallationResponse$Builder setFid(String var1);

    public abstract InstallationResponse$Builder setRefreshToken(String var1);

    public abstract InstallationResponse$Builder setResponseCode(InstallationResponse$ResponseCode var1);

    public abstract InstallationResponse$Builder setUri(String var1);
}

