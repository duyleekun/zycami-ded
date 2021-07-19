/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.local;

import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$1;
import com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallationEntry$Builder;
import java.util.Objects;

public final class AutoValue_PersistedInstallationEntry$Builder
extends PersistedInstallationEntry$Builder {
    private String authToken;
    private Long expiresInSecs;
    private String firebaseInstallationId;
    private String fisError;
    private String refreshToken;
    private PersistedInstallation$RegistrationStatus registrationStatus;
    private Long tokenCreationEpochInSecs;

    public AutoValue_PersistedInstallationEntry$Builder() {
    }

    private AutoValue_PersistedInstallationEntry$Builder(PersistedInstallationEntry object) {
        Object object2;
        this.firebaseInstallationId = object2 = ((PersistedInstallationEntry)object).getFirebaseInstallationId();
        object2 = ((PersistedInstallationEntry)object).getRegistrationStatus();
        this.registrationStatus = object2;
        this.authToken = object2 = ((PersistedInstallationEntry)object).getAuthToken();
        this.refreshToken = object2 = ((PersistedInstallationEntry)object).getRefreshToken();
        object2 = ((PersistedInstallationEntry)object).getExpiresInSecs();
        this.expiresInSecs = object2;
        object2 = ((PersistedInstallationEntry)object).getTokenCreationEpochInSecs();
        this.tokenCreationEpochInSecs = object2;
        this.fisError = object = ((PersistedInstallationEntry)object).getFisError();
    }

    public /* synthetic */ AutoValue_PersistedInstallationEntry$Builder(PersistedInstallationEntry persistedInstallationEntry, AutoValue_PersistedInstallationEntry$1 autoValue_PersistedInstallationEntry$1) {
        this(persistedInstallationEntry);
    }

    public PersistedInstallationEntry build() {
        boolean bl2;
        Object object = this.registrationStatus;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" registrationStatus");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.expiresInSecs) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" expiresInSecs");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.tokenCreationEpochInSecs) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" tokenCreationEpochInSecs");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.firebaseInstallationId;
            PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = this.registrationStatus;
            String string4 = this.authToken;
            String string5 = this.refreshToken;
            long l10 = this.expiresInSecs;
            long l11 = this.tokenCreationEpochInSecs;
            String string6 = this.fisError;
            Object object2 = object;
            object = new AutoValue_PersistedInstallationEntry(string3, persistedInstallation$RegistrationStatus, string4, string5, l10, l11, string6, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public PersistedInstallationEntry$Builder setAuthToken(String string2) {
        this.authToken = string2;
        return this;
    }

    public PersistedInstallationEntry$Builder setExpiresInSecs(long l10) {
        Long l11;
        this.expiresInSecs = l11 = Long.valueOf(l10);
        return this;
    }

    public PersistedInstallationEntry$Builder setFirebaseInstallationId(String string2) {
        this.firebaseInstallationId = string2;
        return this;
    }

    public PersistedInstallationEntry$Builder setFisError(String string2) {
        this.fisError = string2;
        return this;
    }

    public PersistedInstallationEntry$Builder setRefreshToken(String string2) {
        this.refreshToken = string2;
        return this;
    }

    public PersistedInstallationEntry$Builder setRegistrationStatus(PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus) {
        Objects.requireNonNull(persistedInstallation$RegistrationStatus, "Null registrationStatus");
        this.registrationStatus = persistedInstallation$RegistrationStatus;
        return this;
    }

    public PersistedInstallationEntry$Builder setTokenCreationEpochInSecs(long l10) {
        Long l11;
        this.tokenCreationEpochInSecs = l11 = Long.valueOf(l10);
        return this;
    }
}

