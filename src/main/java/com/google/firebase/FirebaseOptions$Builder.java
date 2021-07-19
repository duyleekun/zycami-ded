/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseOptions;

public final class FirebaseOptions$Builder {
    private String apiKey;
    private String applicationId;
    private String databaseUrl;
    private String gaTrackingId;
    private String gcmSenderId;
    private String projectId;
    private String storageBucket;

    public FirebaseOptions$Builder() {
    }

    public FirebaseOptions$Builder(FirebaseOptions object) {
        String string2;
        this.applicationId = string2 = FirebaseOptions.access$000((FirebaseOptions)object);
        this.apiKey = string2 = FirebaseOptions.access$100((FirebaseOptions)object);
        this.databaseUrl = string2 = FirebaseOptions.access$200((FirebaseOptions)object);
        this.gaTrackingId = string2 = FirebaseOptions.access$300((FirebaseOptions)object);
        this.gcmSenderId = string2 = FirebaseOptions.access$400((FirebaseOptions)object);
        this.storageBucket = string2 = FirebaseOptions.access$500((FirebaseOptions)object);
        this.projectId = object = FirebaseOptions.access$600((FirebaseOptions)object);
    }

    public FirebaseOptions build() {
        String string2 = this.applicationId;
        String string3 = this.apiKey;
        String string4 = this.databaseUrl;
        String string5 = this.gaTrackingId;
        String string6 = this.gcmSenderId;
        String string7 = this.storageBucket;
        String string8 = this.projectId;
        FirebaseOptions firebaseOptions = new FirebaseOptions(string2, string3, string4, string5, string6, string7, string8, null);
        return firebaseOptions;
    }

    public FirebaseOptions$Builder setApiKey(String string2) {
        this.apiKey = string2 = Preconditions.checkNotEmpty(string2, "ApiKey must be set.");
        return this;
    }

    public FirebaseOptions$Builder setApplicationId(String string2) {
        this.applicationId = string2 = Preconditions.checkNotEmpty(string2, "ApplicationId must be set.");
        return this;
    }

    public FirebaseOptions$Builder setDatabaseUrl(String string2) {
        this.databaseUrl = string2;
        return this;
    }

    public FirebaseOptions$Builder setGaTrackingId(String string2) {
        this.gaTrackingId = string2;
        return this;
    }

    public FirebaseOptions$Builder setGcmSenderId(String string2) {
        this.gcmSenderId = string2;
        return this;
    }

    public FirebaseOptions$Builder setProjectId(String string2) {
        this.projectId = string2;
        return this;
    }

    public FirebaseOptions$Builder setStorageBucket(String string2) {
        this.storageBucket = string2;
        return this;
    }
}

