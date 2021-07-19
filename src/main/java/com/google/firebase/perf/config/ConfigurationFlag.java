/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

public abstract class ConfigurationFlag {
    public abstract Object getDefault();

    public String getDeviceCacheFlag() {
        return null;
    }

    public String getMetadataFlag() {
        return null;
    }

    public String getRemoteConfigFlag() {
        return null;
    }
}

