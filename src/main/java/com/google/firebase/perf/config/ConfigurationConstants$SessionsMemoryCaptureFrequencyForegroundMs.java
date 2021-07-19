/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs instance;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs() {
    }

    public static ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
        Class<ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs> clazz = ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = instance;
            if (configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs == null) {
                instance = configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = new ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs();
            }
            configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = instance;
            return configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
        }
    }

    public Long getDefault() {
        return 100;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }
}

