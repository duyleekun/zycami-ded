/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.FirebaseOptions$1;

public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    private FirebaseOptions(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        Preconditions.checkState(Strings.isEmptyOrWhitespace(string2) ^ true, "ApplicationId must be set.");
        this.applicationId = string2;
        this.apiKey = string3;
        this.databaseUrl = string4;
        this.gaTrackingId = string5;
        this.gcmSenderId = string6;
        this.storageBucket = string7;
        this.projectId = string8;
    }

    public /* synthetic */ FirebaseOptions(String string2, String string3, String string4, String string5, String string6, String string7, String string8, FirebaseOptions$1 firebaseOptions$1) {
        this(string2, string3, string4, string5, string6, string7, string8);
    }

    public static /* synthetic */ String access$000(FirebaseOptions firebaseOptions) {
        return firebaseOptions.applicationId;
    }

    public static /* synthetic */ String access$100(FirebaseOptions firebaseOptions) {
        return firebaseOptions.apiKey;
    }

    public static /* synthetic */ String access$200(FirebaseOptions firebaseOptions) {
        return firebaseOptions.databaseUrl;
    }

    public static /* synthetic */ String access$300(FirebaseOptions firebaseOptions) {
        return firebaseOptions.gaTrackingId;
    }

    public static /* synthetic */ String access$400(FirebaseOptions firebaseOptions) {
        return firebaseOptions.gcmSenderId;
    }

    public static /* synthetic */ String access$500(FirebaseOptions firebaseOptions) {
        return firebaseOptions.storageBucket;
    }

    public static /* synthetic */ String access$600(FirebaseOptions firebaseOptions) {
        return firebaseOptions.projectId;
    }

    public static FirebaseOptions fromResource(Context object) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader((Context)object);
        String string2 = stringResourceValueReader.getString((String)(object = APP_ID_RESOURCE_NAME));
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        String string3 = stringResourceValueReader.getString(API_KEY_RESOURCE_NAME);
        String string4 = stringResourceValueReader.getString(DATABASE_URL_RESOURCE_NAME);
        String string5 = stringResourceValueReader.getString(GA_TRACKING_ID_RESOURCE_NAME);
        String string6 = stringResourceValueReader.getString(GCM_SENDER_ID_RESOURCE_NAME);
        String string7 = stringResourceValueReader.getString(STORAGE_BUCKET_RESOURCE_NAME);
        String string8 = stringResourceValueReader.getString(PROJECT_ID_RESOURCE_NAME);
        object = new FirebaseOptions(string2, string3, string4, string5, string6, string7, string8);
        return object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof FirebaseOptions;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (FirebaseOptions)object;
        String string2 = this.applicationId;
        String string3 = ((FirebaseOptions)object).applicationId;
        bl3 = Objects.equal(string2, string3);
        if (bl3 && (bl3 = Objects.equal(string2 = this.apiKey, string3 = ((FirebaseOptions)object).apiKey)) && (bl3 = Objects.equal(string2 = this.databaseUrl, string3 = ((FirebaseOptions)object).databaseUrl)) && (bl3 = Objects.equal(string2 = this.gaTrackingId, string3 = ((FirebaseOptions)object).gaTrackingId)) && (bl3 = Objects.equal(string2 = this.gcmSenderId, string3 = ((FirebaseOptions)object).gcmSenderId)) && (bl3 = Objects.equal(string2 = this.storageBucket, string3 = ((FirebaseOptions)object).storageBucket)) && (bl2 = Objects.equal(string2 = this.projectId, object = ((FirebaseOptions)object).projectId))) {
            bl4 = true;
        }
        return bl4;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        Object[] objectArray = new Object[7];
        String string2 = this.applicationId;
        objectArray[0] = string2;
        string2 = this.apiKey;
        objectArray[1] = string2;
        string2 = this.databaseUrl;
        objectArray[2] = string2;
        string2 = this.gaTrackingId;
        objectArray[3] = string2;
        string2 = this.gcmSenderId;
        objectArray[4] = string2;
        string2 = this.storageBucket;
        objectArray[5] = string2;
        string2 = this.projectId;
        objectArray[6] = string2;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        String string2 = this.applicationId;
        objects$ToStringHelper = objects$ToStringHelper.add("applicationId", string2);
        string2 = this.apiKey;
        objects$ToStringHelper = objects$ToStringHelper.add("apiKey", string2);
        string2 = this.databaseUrl;
        objects$ToStringHelper = objects$ToStringHelper.add("databaseUrl", string2);
        string2 = this.gcmSenderId;
        objects$ToStringHelper = objects$ToStringHelper.add("gcmSenderId", string2);
        string2 = this.storageBucket;
        objects$ToStringHelper = objects$ToStringHelper.add("storageBucket", string2);
        string2 = this.projectId;
        return objects$ToStringHelper.add("projectId", string2).toString();
    }
}

