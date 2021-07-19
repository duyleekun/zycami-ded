/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$CollectionDeactivated
extends ConfigurationFlag {
    private static ConfigurationConstants$CollectionDeactivated instance;

    private ConfigurationConstants$CollectionDeactivated() {
    }

    public static ConfigurationConstants$CollectionDeactivated getInstance() {
        Class<ConfigurationConstants$CollectionDeactivated> clazz = ConfigurationConstants$CollectionDeactivated.class;
        synchronized (clazz) {
            ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated = instance;
            if (configurationConstants$CollectionDeactivated == null) {
                instance = configurationConstants$CollectionDeactivated = new ConfigurationConstants$CollectionDeactivated();
            }
            configurationConstants$CollectionDeactivated = instance;
            return configurationConstants$CollectionDeactivated;
        }
    }

    public Boolean getDefault() {
        return Boolean.FALSE;
    }

    public String getMetadataFlag() {
        return "firebase_performance_collection_deactivated";
    }
}

