/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.AutoValue_InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.TokenResult;

public abstract class InstallationResponse {
    public static InstallationResponse$Builder builder() {
        AutoValue_InstallationResponse$Builder autoValue_InstallationResponse$Builder = new AutoValue_InstallationResponse$Builder();
        return autoValue_InstallationResponse$Builder;
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract InstallationResponse$ResponseCode getResponseCode();

    public abstract String getUri();

    public abstract InstallationResponse$Builder toBuilder();
}

