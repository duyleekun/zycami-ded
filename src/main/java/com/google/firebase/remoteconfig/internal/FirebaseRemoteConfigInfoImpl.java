/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl$1;
import com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl$Builder;

public class FirebaseRemoteConfigInfoImpl
implements FirebaseRemoteConfigInfo {
    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    private FirebaseRemoteConfigInfoImpl(long l10, int n10, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.lastSuccessfulFetchTimeInMillis = l10;
        this.lastFetchStatus = n10;
        this.configSettings = firebaseRemoteConfigSettings;
    }

    public /* synthetic */ FirebaseRemoteConfigInfoImpl(long l10, int n10, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings, FirebaseRemoteConfigInfoImpl$1 firebaseRemoteConfigInfoImpl$1) {
        this(l10, n10, firebaseRemoteConfigSettings);
    }

    public static FirebaseRemoteConfigInfoImpl$Builder newBuilder() {
        FirebaseRemoteConfigInfoImpl$Builder firebaseRemoteConfigInfoImpl$Builder = new FirebaseRemoteConfigInfoImpl$Builder(null);
        return firebaseRemoteConfigInfoImpl$Builder;
    }

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public long getFetchTimeMillis() {
        return this.lastSuccessfulFetchTimeInMillis;
    }

    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }
}

