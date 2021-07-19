/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsMaxDurationMinutes
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsMaxDurationMinutes instance;

    private ConfigurationConstants$SessionsMaxDurationMinutes() {
    }

    public static ConfigurationConstants$SessionsMaxDurationMinutes getInstance() {
        Class<ConfigurationConstants$SessionsMaxDurationMinutes> clazz = ConfigurationConstants$SessionsMaxDurationMinutes.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsMaxDurationMinutes configurationConstants$SessionsMaxDurationMinutes = instance;
            if (configurationConstants$SessionsMaxDurationMinutes == null) {
                instance = configurationConstants$SessionsMaxDurationMinutes = new ConfigurationConstants$SessionsMaxDurationMinutes();
            }
            configurationConstants$SessionsMaxDurationMinutes = instance;
            return configurationConstants$SessionsMaxDurationMinutes;
        }
    }

    public Long getDefault() {
        return 240L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    public String getMetadataFlag() {
        return "sessions_max_length_minutes";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_max_duration_min";
    }
}

