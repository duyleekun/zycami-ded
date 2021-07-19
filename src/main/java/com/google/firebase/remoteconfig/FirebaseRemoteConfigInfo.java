/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public interface FirebaseRemoteConfigInfo {
    public FirebaseRemoteConfigSettings getConfigSettings();

    public long getFetchTimeMillis();

    public int getLastFetchStatus();
}

