/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations.remote;

public final class InstallationResponse$ResponseCode
extends Enum {
    private static final /* synthetic */ InstallationResponse$ResponseCode[] $VALUES;
    public static final /* enum */ InstallationResponse$ResponseCode BAD_CONFIG;
    public static final /* enum */ InstallationResponse$ResponseCode OK;

    static {
        InstallationResponse$ResponseCode installationResponse$ResponseCode;
        InstallationResponse$ResponseCode installationResponse$ResponseCode2;
        OK = installationResponse$ResponseCode2 = new InstallationResponse$ResponseCode("OK", 0);
        int n10 = 1;
        BAD_CONFIG = installationResponse$ResponseCode = new InstallationResponse$ResponseCode("BAD_CONFIG", n10);
        InstallationResponse$ResponseCode[] installationResponse$ResponseCodeArray = new InstallationResponse$ResponseCode[2];
        installationResponse$ResponseCodeArray[0] = installationResponse$ResponseCode2;
        installationResponse$ResponseCodeArray[n10] = installationResponse$ResponseCode;
        $VALUES = installationResponse$ResponseCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private InstallationResponse$ResponseCode() {
        void var2_-1;
        void var1_-1;
    }

    public static InstallationResponse$ResponseCode valueOf(String string2) {
        return Enum.valueOf(InstallationResponse$ResponseCode.class, string2);
    }

    public static InstallationResponse$ResponseCode[] values() {
        return (InstallationResponse$ResponseCode[])$VALUES.clone();
    }
}

