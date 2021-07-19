/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.local;

import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder;
import com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus;
import com.google.firebase.installations.local.PersistedInstallationEntry$Builder;

public abstract class PersistedInstallationEntry {
    public static PersistedInstallationEntry INSTANCE = PersistedInstallationEntry.builder().build();

    public static PersistedInstallationEntry$Builder builder() {
        PersistedInstallationEntry$Builder persistedInstallationEntry$Builder = new AutoValue_PersistedInstallationEntry$Builder();
        long l10 = 0L;
        persistedInstallationEntry$Builder = ((AutoValue_PersistedInstallationEntry$Builder)persistedInstallationEntry$Builder).setTokenCreationEpochInSecs(l10);
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.ATTEMPT_MIGRATION;
        return persistedInstallationEntry$Builder.setRegistrationStatus(persistedInstallation$RegistrationStatus).setExpiresInSecs(l10);
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract PersistedInstallation$RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();

    public boolean isErrored() {
        boolean bl2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus();
        if (persistedInstallation$RegistrationStatus2 == (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.REGISTER_ERROR)) {
            bl2 = true;
        } else {
            bl2 = false;
            persistedInstallation$RegistrationStatus2 = null;
        }
        return bl2;
    }

    public boolean isNotGenerated() {
        boolean bl2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus();
        if (persistedInstallation$RegistrationStatus2 != (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.NOT_GENERATED) && (persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus()) != (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.ATTEMPT_MIGRATION)) {
            bl2 = false;
            persistedInstallation$RegistrationStatus2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isRegistered() {
        boolean bl2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus();
        if (persistedInstallation$RegistrationStatus2 == (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.REGISTERED)) {
            bl2 = true;
        } else {
            bl2 = false;
            persistedInstallation$RegistrationStatus2 = null;
        }
        return bl2;
    }

    public boolean isUnregistered() {
        boolean bl2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus();
        if (persistedInstallation$RegistrationStatus2 == (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.UNREGISTERED)) {
            bl2 = true;
        } else {
            bl2 = false;
            persistedInstallation$RegistrationStatus2 = null;
        }
        return bl2;
    }

    public boolean shouldAttemptMigration() {
        boolean bl2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2 = this.getRegistrationStatus();
        if (persistedInstallation$RegistrationStatus2 == (persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.ATTEMPT_MIGRATION)) {
            bl2 = true;
        } else {
            bl2 = false;
            persistedInstallation$RegistrationStatus2 = null;
        }
        return bl2;
    }

    public abstract PersistedInstallationEntry$Builder toBuilder();

    public PersistedInstallationEntry withAuthToken(String string2, long l10, long l11) {
        return this.toBuilder().setAuthToken(string2).setExpiresInSecs(l10).setTokenCreationEpochInSecs(l11).build();
    }

    public PersistedInstallationEntry withClearedAuthToken() {
        return this.toBuilder().setAuthToken(null).build();
    }

    public PersistedInstallationEntry withFisError(String object) {
        object = this.toBuilder().setFisError((String)object);
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.REGISTER_ERROR;
        return ((PersistedInstallationEntry$Builder)object).setRegistrationStatus(persistedInstallation$RegistrationStatus).build();
    }

    public PersistedInstallationEntry withNoGeneratedFid() {
        PersistedInstallationEntry$Builder persistedInstallationEntry$Builder = this.toBuilder();
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.NOT_GENERATED;
        return persistedInstallationEntry$Builder.setRegistrationStatus(persistedInstallation$RegistrationStatus).build();
    }

    public PersistedInstallationEntry withRegisteredFid(String object, String string2, long l10, String string3, long l11) {
        object = this.toBuilder().setFirebaseInstallationId((String)object);
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.REGISTERED;
        return ((PersistedInstallationEntry$Builder)object).setRegistrationStatus(persistedInstallation$RegistrationStatus).setAuthToken(string3).setRefreshToken(string2).setExpiresInSecs(l11).setTokenCreationEpochInSecs(l10).build();
    }

    public PersistedInstallationEntry withUnregisteredFid(String object) {
        object = this.toBuilder().setFirebaseInstallationId((String)object);
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus = PersistedInstallation$RegistrationStatus.UNREGISTERED;
        return ((PersistedInstallationEntry$Builder)object).setRegistrationStatus(persistedInstallation$RegistrationStatus).build();
    }
}

