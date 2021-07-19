/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$TraceEventCountBackground
extends ConfigurationFlag {
    private static ConfigurationConstants$TraceEventCountBackground instance;

    private ConfigurationConstants$TraceEventCountBackground() {
    }

    public static ConfigurationConstants$TraceEventCountBackground getInstance() {
        Class<ConfigurationConstants$TraceEventCountBackground> clazz = ConfigurationConstants$TraceEventCountBackground.class;
        synchronized (clazz) {
            ConfigurationConstants$TraceEventCountBackground configurationConstants$TraceEventCountBackground = instance;
            if (configurationConstants$TraceEventCountBackground == null) {
                instance = configurationConstants$TraceEventCountBackground = new ConfigurationConstants$TraceEventCountBackground();
            }
            configurationConstants$TraceEventCountBackground = instance;
            return configurationConstants$TraceEventCountBackground;
        }
    }

    public Long getDefault() {
        return 30;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_bg";
    }
}

