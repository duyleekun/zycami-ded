/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;

public abstract class InstallationTokenResult$Builder {
    public abstract InstallationTokenResult build();

    public abstract InstallationTokenResult$Builder setToken(String var1);

    public abstract InstallationTokenResult$Builder setTokenCreationTimestamp(long var1);

    public abstract InstallationTokenResult$Builder setTokenExpirationTimestamp(long var1);
}

