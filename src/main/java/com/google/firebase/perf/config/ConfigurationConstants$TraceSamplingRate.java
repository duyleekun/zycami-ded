/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$TraceSamplingRate
extends ConfigurationFlag {
    private static ConfigurationConstants$TraceSamplingRate instance;

    private ConfigurationConstants$TraceSamplingRate() {
    }

    public static ConfigurationConstants$TraceSamplingRate getInstance() {
        Class<ConfigurationConstants$TraceSamplingRate> clazz = ConfigurationConstants$TraceSamplingRate.class;
        synchronized (clazz) {
            ConfigurationConstants$TraceSamplingRate configurationConstants$TraceSamplingRate = instance;
            if (configurationConstants$TraceSamplingRate == null) {
                instance = configurationConstants$TraceSamplingRate = new ConfigurationConstants$TraceSamplingRate();
            }
            configurationConstants$TraceSamplingRate = instance;
            return configurationConstants$TraceSamplingRate;
        }
    }

    public Float getDefault() {
        return Float.valueOf(1.0f);
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_trace_sampling_rate";
    }
}

