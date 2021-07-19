/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$RateLimitSec
extends ConfigurationFlag {
    private static ConfigurationConstants$RateLimitSec instance;

    private ConfigurationConstants$RateLimitSec() {
    }

    public static ConfigurationConstants$RateLimitSec getInstance() {
        Class<ConfigurationConstants$RateLimitSec> clazz = ConfigurationConstants$RateLimitSec.class;
        synchronized (clazz) {
            ConfigurationConstants$RateLimitSec configurationConstants$RateLimitSec = instance;
            if (configurationConstants$RateLimitSec == null) {
                instance = configurationConstants$RateLimitSec = new ConfigurationConstants$RateLimitSec();
            }
            configurationConstants$RateLimitSec = instance;
            return configurationConstants$RateLimitSec;
        }
    }

    public Long getDefault() {
        return 600L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_time_limit_sec";
    }
}

