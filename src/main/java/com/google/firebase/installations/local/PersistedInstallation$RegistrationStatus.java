/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.local;

public final class PersistedInstallation$RegistrationStatus
extends Enum {
    private static final /* synthetic */ PersistedInstallation$RegistrationStatus[] $VALUES;
    public static final /* enum */ PersistedInstallation$RegistrationStatus ATTEMPT_MIGRATION;
    public static final /* enum */ PersistedInstallation$RegistrationStatus NOT_GENERATED;
    public static final /* enum */ PersistedInstallation$RegistrationStatus REGISTERED;
    public static final /* enum */ PersistedInstallation$RegistrationStatus REGISTER_ERROR;
    public static final /* enum */ PersistedInstallation$RegistrationStatus UNREGISTERED;

    static {
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus2;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus3;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus4;
        PersistedInstallation$RegistrationStatus persistedInstallation$RegistrationStatus5;
        ATTEMPT_MIGRATION = persistedInstallation$RegistrationStatus5 = new PersistedInstallation$RegistrationStatus("ATTEMPT_MIGRATION", 0);
        int n10 = 1;
        NOT_GENERATED = persistedInstallation$RegistrationStatus4 = new PersistedInstallation$RegistrationStatus("NOT_GENERATED", n10);
        int n11 = 2;
        UNREGISTERED = persistedInstallation$RegistrationStatus3 = new PersistedInstallation$RegistrationStatus("UNREGISTERED", n11);
        int n12 = 3;
        REGISTERED = persistedInstallation$RegistrationStatus2 = new PersistedInstallation$RegistrationStatus("REGISTERED", n12);
        int n13 = 4;
        REGISTER_ERROR = persistedInstallation$RegistrationStatus = new PersistedInstallation$RegistrationStatus("REGISTER_ERROR", n13);
        PersistedInstallation$RegistrationStatus[] persistedInstallation$RegistrationStatusArray = new PersistedInstallation$RegistrationStatus[5];
        persistedInstallation$RegistrationStatusArray[0] = persistedInstallation$RegistrationStatus5;
        persistedInstallation$RegistrationStatusArray[n10] = persistedInstallation$RegistrationStatus4;
        persistedInstallation$RegistrationStatusArray[n11] = persistedInstallation$RegistrationStatus3;
        persistedInstallation$RegistrationStatusArray[n12] = persistedInstallation$RegistrationStatus2;
        persistedInstallation$RegistrationStatusArray[n13] = persistedInstallation$RegistrationStatus;
        $VALUES = persistedInstallation$RegistrationStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PersistedInstallation$RegistrationStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static PersistedInstallation$RegistrationStatus valueOf(String string2) {
        return Enum.valueOf(PersistedInstallation$RegistrationStatus.class, string2);
    }

    public static PersistedInstallation$RegistrationStatus[] values() {
        return (PersistedInstallation$RegistrationStatus[])$VALUES.clone();
    }
}

