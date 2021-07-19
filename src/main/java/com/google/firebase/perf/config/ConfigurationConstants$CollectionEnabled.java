/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$CollectionEnabled
extends ConfigurationFlag {
    private static ConfigurationConstants$CollectionEnabled instance;

    private ConfigurationConstants$CollectionEnabled() {
    }

    public static ConfigurationConstants$CollectionEnabled getInstance() {
        Class<ConfigurationConstants$CollectionEnabled> clazz = ConfigurationConstants$CollectionEnabled.class;
        synchronized (clazz) {
            ConfigurationConstants$CollectionEnabled configurationConstants$CollectionEnabled = instance;
            if (configurationConstants$CollectionEnabled == null) {
                instance = configurationConstants$CollectionEnabled = new ConfigurationConstants$CollectionEnabled();
            }
            configurationConstants$CollectionEnabled = instance;
            return configurationConstants$CollectionEnabled;
        }
    }

    public Boolean getDefault() {
        return Boolean.TRUE;
    }

    public String getDeviceCacheFlag() {
        return "isEnabled";
    }

    public String getMetadataFlag() {
        return "firebase_performance_collection_enabled";
    }
}

