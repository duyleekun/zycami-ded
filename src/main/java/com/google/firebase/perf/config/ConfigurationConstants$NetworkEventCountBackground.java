/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.config.ConfigurationFlag;

public final class ConfigurationConstants$NetworkEventCountBackground
extends ConfigurationFlag {
    private static ConfigurationConstants$NetworkEventCountBackground instance;

    private ConfigurationConstants$NetworkEventCountBackground() {
    }

    public static ConfigurationConstants$NetworkEventCountBackground getInstance() {
        Class<ConfigurationConstants$NetworkEventCountBackground> clazz = ConfigurationConstants$NetworkEventCountBackground.class;
        synchronized (clazz) {
            ConfigurationConstants$NetworkEventCountBackground configurationConstants$NetworkEventCountBackground = instance;
            if (configurationConstants$NetworkEventCountBackground == null) {
                instance = configurationConstants$NetworkEventCountBackground = new ConfigurationConstants$NetworkEventCountBackground();
            }
            configurationConstants$NetworkEventCountBackground = instance;
            return configurationConstants$NetworkEventCountBackground;
        }
    }

    public Long getDefault() {
        return 70;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_bg";
    }
}

