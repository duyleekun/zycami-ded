/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$NetworkEventCountForeground
extends ConfigurationFlag {
    private static ConfigurationConstants$NetworkEventCountForeground instance;

    private ConfigurationConstants$NetworkEventCountForeground() {
    }

    public static ConfigurationConstants$NetworkEventCountForeground getInstance() {
        Class<ConfigurationConstants$NetworkEventCountForeground> clazz = ConfigurationConstants$NetworkEventCountForeground.class;
        synchronized (clazz) {
            ConfigurationConstants$NetworkEventCountForeground configurationConstants$NetworkEventCountForeground = instance;
            if (configurationConstants$NetworkEventCountForeground == null) {
                instance = configurationConstants$NetworkEventCountForeground = new ConfigurationConstants$NetworkEventCountForeground();
            }
            configurationConstants$NetworkEventCountForeground = instance;
            return configurationConstants$NetworkEventCountForeground;
        }
    }

    public Long getDefault() {
        return 700L;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_fg";
    }
}

