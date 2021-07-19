/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs instance;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs() {
    }

    public static ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
        Class<ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs> clazz = ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = instance;
            if (configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs == null) {
                instance = configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = new ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs();
            }
            configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = instance;
            return configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
        }
    }

    public Long getDefault() {
        return 0L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }
}

