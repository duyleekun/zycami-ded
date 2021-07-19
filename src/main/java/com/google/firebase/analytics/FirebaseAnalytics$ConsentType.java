/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics;

public final class FirebaseAnalytics$ConsentType
extends Enum {
    public static final /* enum */ FirebaseAnalytics$ConsentType AD_STORAGE;
    public static final /* enum */ FirebaseAnalytics$ConsentType ANALYTICS_STORAGE;
    private static final /* synthetic */ FirebaseAnalytics$ConsentType[] zza;

    static {
        FirebaseAnalytics$ConsentType firebaseAnalytics$ConsentType;
        FirebaseAnalytics$ConsentType firebaseAnalytics$ConsentType2;
        AD_STORAGE = firebaseAnalytics$ConsentType2 = new FirebaseAnalytics$ConsentType("AD_STORAGE", 0);
        int n10 = 1;
        ANALYTICS_STORAGE = firebaseAnalytics$ConsentType = new FirebaseAnalytics$ConsentType("ANALYTICS_STORAGE", n10);
        FirebaseAnalytics$ConsentType[] firebaseAnalytics$ConsentTypeArray = new FirebaseAnalytics$ConsentType[2];
        firebaseAnalytics$ConsentTypeArray[0] = firebaseAnalytics$ConsentType2;
        firebaseAnalytics$ConsentTypeArray[n10] = firebaseAnalytics$ConsentType;
        zza = firebaseAnalytics$ConsentTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FirebaseAnalytics$ConsentType() {
        void var2_-1;
        void var1_-1;
    }

    public static FirebaseAnalytics$ConsentType valueOf(String string2) {
        return Enum.valueOf(FirebaseAnalytics$ConsentType.class, string2);
    }

    public static FirebaseAnalytics$ConsentType[] values() {
        return (FirebaseAnalytics$ConsentType[])zza.clone();
    }
}

