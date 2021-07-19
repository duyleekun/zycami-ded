/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs
extends ConfigurationFlag {
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs instance;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs() {
    }

    public static ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs getInstance() {
        Class<ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs> clazz = ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.class;
        synchronized (clazz) {
            ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = instance;
            if (configurationConstants$SessionsCpuCaptureFrequencyForegroundMs == null) {
                instance = configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = new ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs();
            }
            configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = instance;
            return configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
        }
    }

    public Long getDefault() {
        return 100;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }
}

