/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics;

public final class FirebaseAnalytics$ConsentStatus
extends Enum {
    public static final /* enum */ FirebaseAnalytics$ConsentStatus DENIED;
    public static final /* enum */ FirebaseAnalytics$ConsentStatus GRANTED;
    private static final /* synthetic */ FirebaseAnalytics$ConsentStatus[] zza;

    static {
        FirebaseAnalytics$ConsentStatus firebaseAnalytics$ConsentStatus;
        FirebaseAnalytics$ConsentStatus firebaseAnalytics$ConsentStatus2;
        GRANTED = firebaseAnalytics$ConsentStatus2 = new FirebaseAnalytics$ConsentStatus("GRANTED", 0);
        int n10 = 1;
        DENIED = firebaseAnalytics$ConsentStatus = new FirebaseAnalytics$ConsentStatus("DENIED", n10);
        FirebaseAnalytics$ConsentStatus[] firebaseAnalytics$ConsentStatusArray = new FirebaseAnalytics$ConsentStatus[2];
        firebaseAnalytics$ConsentStatusArray[0] = firebaseAnalytics$ConsentStatus2;
        firebaseAnalytics$ConsentStatusArray[n10] = firebaseAnalytics$ConsentStatus;
        zza = firebaseAnalytics$ConsentStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FirebaseAnalytics$ConsentStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static FirebaseAnalytics$ConsentStatus valueOf(String string2) {
        return Enum.valueOf(FirebaseAnalytics$ConsentStatus.class, string2);
    }

    public static FirebaseAnalytics$ConsentStatus[] values() {
        return (FirebaseAnalytics$ConsentStatus[])zza.clone();
    }
}

