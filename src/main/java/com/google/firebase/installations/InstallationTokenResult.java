/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.AutoValue_InstallationTokenResult$Builder;
import com.google.firebase.installations.InstallationTokenResult$Builder;

public abstract class InstallationTokenResult {
    public static InstallationTokenResult$Builder builder() {
        AutoValue_InstallationTokenResult$Builder autoValue_InstallationTokenResult$Builder = new AutoValue_InstallationTokenResult$Builder();
        return autoValue_InstallationTokenResult$Builder;
    }

    public abstract String getToken();

    public abstract long getTokenCreationTimestamp();

    public abstract long getTokenExpirationTimestamp();

    public abstract InstallationTokenResult$Builder toBuilder();
}

