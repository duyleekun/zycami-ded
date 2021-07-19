/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsSamplingRate
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsSamplingRate instance;

    private ConfigurationConstants$SessionsSamplingRate() {
    }

    public static ConfigurationConstants$SessionsSamplingRate getInstance() {
        Class<ConfigurationConstants$SessionsSamplingRate> clazz = ConfigurationConstants$SessionsSamplingRate.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsSamplingRate configurationConstants$SessionsSamplingRate = instance;
            if (configurationConstants$SessionsSamplingRate == null) {
                instance = configurationConstants$SessionsSamplingRate = new ConfigurationConstants$SessionsSamplingRate();
            }
            configurationConstants$SessionsSamplingRate = instance;
            return configurationConstants$SessionsSamplingRate;
        }
    }

    public Float getDefault() {
        return Float.valueOf(0.01f);
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    public String getMetadataFlag() {
        return "sessions_sampling_percentage";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_session_sampling_rate";
    }
}

