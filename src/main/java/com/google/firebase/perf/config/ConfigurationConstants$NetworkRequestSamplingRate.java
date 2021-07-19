/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$NetworkRequestSamplingRate
extends ConfigurationFlag {
    private static ConfigurationConstants$NetworkRequestSamplingRate instance;

    private ConfigurationConstants$NetworkRequestSamplingRate() {
    }

    public static ConfigurationConstants$NetworkRequestSamplingRate getInstance() {
        Class<ConfigurationConstants$NetworkRequestSamplingRate> clazz = ConfigurationConstants$NetworkRequestSamplingRate.class;
        synchronized (clazz) {
            ConfigurationConstants$NetworkRequestSamplingRate configurationConstants$NetworkRequestSamplingRate = instance;
            if (configurationConstants$NetworkRequestSamplingRate == null) {
                instance = configurationConstants$NetworkRequestSamplingRate = new ConfigurationConstants$NetworkRequestSamplingRate();
            }
            configurationConstants$NetworkRequestSamplingRate = instance;
            return configurationConstants$NetworkRequestSamplingRate;
        }
    }

    public Float getDefault() {
        return Float.valueOf(1.0f);
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_network_request_sampling_rate";
    }
}

