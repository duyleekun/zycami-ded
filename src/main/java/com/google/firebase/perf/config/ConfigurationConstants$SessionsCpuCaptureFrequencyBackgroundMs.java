/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs instance;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs() {
    }

    public static ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
        Class<ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs> clazz = ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = instance;
            if (configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs == null) {
                instance = configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = new ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs();
            }
            configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = instance;
            return configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
        }
    }

    public Long getDefault() {
        return 0L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }
}

