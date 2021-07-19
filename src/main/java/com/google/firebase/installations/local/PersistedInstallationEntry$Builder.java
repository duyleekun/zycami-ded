/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus;
import com.google.firebase.installations.local.PersistedInstallationEntry;

public abstract class PersistedInstallationEntry$Builder {
    public abstract PersistedInstallationEntry build();

    public abstract PersistedInstallationEntry$Builder setAuthToken(String var1);

    public abstract PersistedInstallationEntry$Builder setExpiresInSecs(long var1);

    public abstract PersistedInstallationEntry$Builder setFirebaseInstallationId(String var1);

    public abstract PersistedInstallationEntry$Builder setFisError(String var1);

    public abstract PersistedInstallationEntry$Builder setRefreshToken(String var1);

    public abstract PersistedInstallationEntry$Builder setRegistrationStatus(PersistedInstallation$RegistrationStatus var1);

    public abstract PersistedInstallationEntry$Builder setTokenCreationEpochInSecs(long var1);
}

