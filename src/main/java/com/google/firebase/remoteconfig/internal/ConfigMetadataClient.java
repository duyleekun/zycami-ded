/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient$BackoffMetadata;
import com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl;
import com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl$Builder;
import java.util.Date;

public class ConfigMetadataClient {
    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = 255L;
    public static final Date LAST_FETCH_TIME_NO_FETCH_YET;
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    public static final Date NO_BACKOFF_TIME;
    private static final long NO_BACKOFF_TIME_IN_MILLIS = 255L;
    public static final int NO_FAILED_FETCHES = 0;
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private final Object backoffMetadataLock;
    private final Object frcInfoLock;
    private final SharedPreferences frcMetadata;

    static {
        Date date;
        long l10 = -1;
        LAST_FETCH_TIME_NO_FETCH_YET = date = new Date(l10);
        NO_BACKOFF_TIME = date = new Date(l10);
    }

    public ConfigMetadataClient(SharedPreferences object) {
        this.frcMetadata = object;
        this.frcInfoLock = object;
        super();
        this.backoffMetadataLock = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            sharedPreferences = sharedPreferences.clear();
            sharedPreferences.commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ConfigMetadataClient$BackoffMetadata getBackoffMetadata() {
        Object object = this.backoffMetadataLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            Object object2 = NUM_FAILED_FETCHES_KEY;
            SharedPreferences sharedPreferences2 = null;
            int n10 = sharedPreferences.getInt((String)object2, 0);
            sharedPreferences2 = this.frcMetadata;
            String string2 = BACKOFF_END_TIME_IN_MILLIS_KEY;
            long l10 = -1;
            long l11 = sharedPreferences2.getLong(string2, l10);
            object2 = new Date(l11);
            return new ConfigMetadataClient$BackoffMetadata(n10, (Date)object2);
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcMetadata.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, (long)60);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FirebaseRemoteConfigInfo getInfo() {
        Object object = this.frcInfoLock;
        synchronized (object) {
            Object object2 = this.frcMetadata;
            String string2 = LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY;
            long l10 = -1;
            long l11 = object2.getLong(string2, l10);
            Object object3 = this.frcMetadata;
            Object object4 = LAST_FETCH_STATUS_KEY;
            Object object5 = null;
            int n10 = object3.getInt((String)object4, 0);
            object4 = new FirebaseRemoteConfigSettings$Builder();
            object5 = this.frcMetadata;
            String string3 = FETCH_TIMEOUT_IN_SECONDS_KEY;
            long l12 = 60;
            long l13 = object5.getLong(string3, l12);
            object4 = ((FirebaseRemoteConfigSettings$Builder)object4).setFetchTimeoutInSeconds(l13);
            object5 = this.frcMetadata;
            string3 = MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY;
            l12 = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;
            l13 = object5.getLong(string3, l12);
            object4 = ((FirebaseRemoteConfigSettings$Builder)object4).setMinimumFetchIntervalInSeconds(l13);
            object4 = ((FirebaseRemoteConfigSettings$Builder)object4).build();
            object5 = FirebaseRemoteConfigInfoImpl.newBuilder();
            object3 = ((FirebaseRemoteConfigInfoImpl$Builder)object5).withLastFetchStatus(n10);
            object2 = ((FirebaseRemoteConfigInfoImpl$Builder)object3).withLastSuccessfulFetchTimeInMillis(l11);
            object2 = ((FirebaseRemoteConfigInfoImpl$Builder)object2).withConfigSettings((FirebaseRemoteConfigSettings)object4);
            return ((FirebaseRemoteConfigInfoImpl$Builder)object2).build();
        }
    }

    public String getLastFetchETag() {
        return this.frcMetadata.getString(LAST_FETCH_ETAG_KEY, null);
    }

    public int getLastFetchStatus() {
        return this.frcMetadata.getInt(LAST_FETCH_STATUS_KEY, 0);
    }

    public Date getLastSuccessfulFetchTime() {
        long l10 = this.frcMetadata.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, (long)-1);
        Date date = new Date(l10);
        return date;
    }

    public long getMinimumFetchIntervalInSeconds() {
        SharedPreferences sharedPreferences = this.frcMetadata;
        long l10 = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;
        return sharedPreferences.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, l10);
    }

    public void resetBackoff() {
        Date date = NO_BACKOFF_TIME;
        this.setBackoffMetadata(0, date);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setBackoffMetadata(int n10, Date date) {
        Object object = this.backoffMetadataLock;
        synchronized (object) {
            Object object2 = this.frcMetadata;
            object2 = object2.edit();
            String string2 = NUM_FAILED_FETCHES_KEY;
            SharedPreferences.Editor editor = object2.putInt(string2, n10);
            object2 = BACKOFF_END_TIME_IN_MILLIS_KEY;
            long l10 = date.getTime();
            editor = editor.putLong((String)object2, l10);
            editor.apply();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string2 = FETCH_TIMEOUT_IN_SECONDS_KEY;
            long l10 = firebaseRemoteConfigSettings.getFetchTimeoutInSeconds();
            sharedPreferences = sharedPreferences.putLong(string2, l10);
            string2 = MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY;
            l10 = firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds();
            firebaseRemoteConfigSettings = sharedPreferences.putLong(string2, l10);
            firebaseRemoteConfigSettings.commit();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string2 = FETCH_TIMEOUT_IN_SECONDS_KEY;
            long l10 = firebaseRemoteConfigSettings.getFetchTimeoutInSeconds();
            sharedPreferences = sharedPreferences.putLong(string2, l10);
            string2 = MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY;
            l10 = firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds();
            firebaseRemoteConfigSettings = sharedPreferences.putLong(string2, l10);
            firebaseRemoteConfigSettings.apply();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setLastFetchETag(String string2) {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string3 = LAST_FETCH_ETAG_KEY;
            string2 = sharedPreferences.putString(string3, string2);
            string2.apply();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateLastFetchAsFailed() {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string2 = LAST_FETCH_STATUS_KEY;
            int n10 = 1;
            sharedPreferences = sharedPreferences.putInt(string2, n10);
            sharedPreferences.apply();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateLastFetchAsSuccessfulAt(Date date) {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string2 = LAST_FETCH_STATUS_KEY;
            int n10 = -1;
            sharedPreferences = sharedPreferences.putInt(string2, n10);
            string2 = LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY;
            long l10 = date.getTime();
            date = sharedPreferences.putLong(string2, l10);
            date.apply();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateLastFetchAsThrottled() {
        Object object = this.frcInfoLock;
        synchronized (object) {
            SharedPreferences sharedPreferences = this.frcMetadata;
            sharedPreferences = sharedPreferences.edit();
            String string2 = LAST_FETCH_STATUS_KEY;
            int n10 = 2;
            sharedPreferences = sharedPreferences.putInt(string2, n10);
            sharedPreferences.apply();
            return;
        }
    }
}

