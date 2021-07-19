/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SdkDisabledVersions
extends ConfigurationFlag {
    private static ConfigurationConstants$SdkDisabledVersions instance;

    public static ConfigurationConstants$SdkDisabledVersions getInstance() {
        Class<ConfigurationConstants$SdkDisabledVersions> clazz = ConfigurationConstants$SdkDisabledVersions.class;
        synchronized (clazz) {
            ConfigurationConstants$SdkDisabledVersions configurationConstants$SdkDisabledVersions = instance;
            if (configurationConstants$SdkDisabledVersions == null) {
                instance = configurationConstants$SdkDisabledVersions = new ConfigurationConstants$SdkDisabledVersions();
            }
            configurationConstants$SdkDisabledVersions = instance;
            return configurationConstants$SdkDisabledVersions;
        }
    }

    public String getDefault() {
        return "";
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    public String getRemoteConfigFlag() {
        return "fpr_disabled_android_versions";
    }
}

