/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SdkEnabled
extends ConfigurationFlag {
    private static ConfigurationConstants$SdkEnabled instance;

    public static ConfigurationConstants$SdkEnabled getInstance() {
        Class<ConfigurationConstants$SdkEnabled> clazz = ConfigurationConstants$SdkEnabled.class;
        synchronized (clazz) {
            ConfigurationConstants$SdkEnabled configurationConstants$SdkEnabled = instance;
            if (configurationConstants$SdkEnabled == null) {
                instance = configurationConstants$SdkEnabled = new ConfigurationConstants$SdkEnabled();
            }
            configurationConstants$SdkEnabled = instance;
            return configurationConstants$SdkEnabled;
        }
    }

    public Boolean getDefault() {
        return Boolean.TRUE;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    public String getRemoteConfigFlag() {
        return "fpr_enabled";
    }
}

