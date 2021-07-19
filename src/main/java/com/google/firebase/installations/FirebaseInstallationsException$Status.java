/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

public final class FirebaseInstallationsException$Status
extends Enum {
    private static final /* synthetic */ FirebaseInstallationsException$Status[] $VALUES;
    public static final /* enum */ FirebaseInstallationsException$Status BAD_CONFIG;
    public static final /* enum */ FirebaseInstallationsException$Status TOO_MANY_REQUESTS;
    public static final /* enum */ FirebaseInstallationsException$Status UNAVAILABLE;

    static {
        FirebaseInstallationsException$Status firebaseInstallationsException$Status;
        FirebaseInstallationsException$Status firebaseInstallationsException$Status2;
        FirebaseInstallationsException$Status firebaseInstallationsException$Status3;
        BAD_CONFIG = firebaseInstallationsException$Status3 = new FirebaseInstallationsException$Status("BAD_CONFIG", 0);
        int n10 = 1;
        UNAVAILABLE = firebaseInstallationsException$Status2 = new FirebaseInstallationsException$Status("UNAVAILABLE", n10);
        int n11 = 2;
        TOO_MANY_REQUESTS = firebaseInstallationsException$Status = new FirebaseInstallationsException$Status("TOO_MANY_REQUESTS", n11);
        FirebaseInstallationsException$Status[] firebaseInstallationsException$StatusArray = new FirebaseInstallationsException$Status[3];
        firebaseInstallationsException$StatusArray[0] = firebaseInstallationsException$Status3;
        firebaseInstallationsException$StatusArray[n10] = firebaseInstallationsException$Status2;
        firebaseInstallationsException$StatusArray[n11] = firebaseInstallationsException$Status;
        $VALUES = firebaseInstallationsException$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FirebaseInstallationsException$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static FirebaseInstallationsException$Status valueOf(String string2) {
        return Enum.valueOf(FirebaseInstallationsException$Status.class, string2);
    }

    public static FirebaseInstallationsException$Status[] values() {
        return (FirebaseInstallationsException$Status[])$VALUES.clone();
    }
}

