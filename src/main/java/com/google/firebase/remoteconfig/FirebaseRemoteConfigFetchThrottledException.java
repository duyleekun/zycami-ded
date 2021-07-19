/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

public class FirebaseRemoteConfigFetchThrottledException
extends FirebaseRemoteConfigException {
    private final long throttleEndTimeMillis;

    public FirebaseRemoteConfigFetchThrottledException(long l10) {
        this("Fetch was throttled.", l10);
    }

    public FirebaseRemoteConfigFetchThrottledException(String string2, long l10) {
        super(string2);
        this.throttleEndTimeMillis = l10;
    }

    public long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }
}

