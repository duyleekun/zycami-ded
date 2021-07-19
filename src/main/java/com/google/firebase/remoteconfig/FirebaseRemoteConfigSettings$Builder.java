/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

public class FirebaseRemoteConfigSettings$Builder {
    private long fetchTimeoutInSeconds = 60;
    private long minimumFetchInterval;

    public FirebaseRemoteConfigSettings$Builder() {
        long l10;
        this.minimumFetchInterval = l10 = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;
    }

    public static /* synthetic */ long access$000(FirebaseRemoteConfigSettings$Builder firebaseRemoteConfigSettings$Builder) {
        return firebaseRemoteConfigSettings$Builder.fetchTimeoutInSeconds;
    }

    public static /* synthetic */ long access$100(FirebaseRemoteConfigSettings$Builder firebaseRemoteConfigSettings$Builder) {
        return firebaseRemoteConfigSettings$Builder.minimumFetchInterval;
    }

    public FirebaseRemoteConfigSettings build() {
        FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings(this, null);
        return firebaseRemoteConfigSettings;
    }

    public long getFetchTimeoutInSeconds() {
        return this.fetchTimeoutInSeconds;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.minimumFetchInterval;
    }

    public FirebaseRemoteConfigSettings$Builder setFetchTimeoutInSeconds(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            this.fetchTimeoutInSeconds = l10;
            return this;
        }
        Object object2 = l10;
        Object[] objectArray = new Object[]{object2};
        object2 = String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2);
        throw illegalArgumentException;
    }

    public FirebaseRemoteConfigSettings$Builder setMinimumFetchIntervalInSeconds(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            this.minimumFetchInterval = l10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Minimum interval between fetches has to be a non-negative number. ");
        stringBuilder.append(l10);
        stringBuilder.append(" is an invalid argument");
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

