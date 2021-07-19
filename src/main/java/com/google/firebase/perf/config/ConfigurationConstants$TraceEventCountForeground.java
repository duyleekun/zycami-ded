/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$TraceEventCountForeground
extends ConfigurationFlag {
    private static ConfigurationConstants$TraceEventCountForeground instance;

    private ConfigurationConstants$TraceEventCountForeground() {
    }

    public static ConfigurationConstants$TraceEventCountForeground getInstance() {
        Class<ConfigurationConstants$TraceEventCountForeground> clazz = ConfigurationConstants$TraceEventCountForeground.class;
        synchronized (clazz) {
            ConfigurationConstants$TraceEventCountForeground configurationConstants$TraceEventCountForeground = instance;
            if (configurationConstants$TraceEventCountForeground == null) {
                instance = configurationConstants$TraceEventCountForeground = new ConfigurationConstants$TraceEventCountForeground();
            }
            configurationConstants$TraceEventCountForeground = instance;
            return configurationConstants$TraceEventCountForeground;
        }
    }

    public Long getDefault() {
        return 300L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_fg";
    }
}

