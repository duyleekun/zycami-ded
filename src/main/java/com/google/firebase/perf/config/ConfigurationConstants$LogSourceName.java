/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.config.ConfigurationConstants$LogSourceName$1;
import com.google.firebase.perf.config.ConfigurationFlag;
import java.util.Collections;
import java.util.Map;

public final class ConfigurationConstants$LogSourceName
extends ConfigurationFlag {
    private static final Map LOG_SOURCE_MAP;
    private static ConfigurationConstants$LogSourceName instance;

    static {
        ConfigurationConstants$LogSourceName$1 configurationConstants$LogSourceName$1 = new ConfigurationConstants$LogSourceName$1();
        LOG_SOURCE_MAP = Collections.unmodifiableMap(configurationConstants$LogSourceName$1);
    }

    private ConfigurationConstants$LogSourceName() {
    }

    public static ConfigurationConstants$LogSourceName getInstance() {
        Class<ConfigurationConstants$LogSourceName> clazz = ConfigurationConstants$LogSourceName.class;
        synchronized (clazz) {
            ConfigurationConstants$LogSourceName configurationConstants$LogSourceName = instance;
            if (configurationConstants$LogSourceName == null) {
                instance = configurationConstants$LogSourceName = new ConfigurationConstants$LogSourceName();
            }
            configurationConstants$LogSourceName = instance;
            return configurationConstants$LogSourceName;
        }
    }

    public static String getLogSourceName(long l10) {
        Map map = LOG_SOURCE_MAP;
        Long l11 = l10;
        return (String)map.get(l11);
    }

    public static boolean isLogSourceKnown(long l10) {
        Map map = LOG_SOURCE_MAP;
        Long l11 = l10;
        return map.containsKey(l11);
    }

    public String getDefault() {
        return BuildConfig.TRANSPORT_LOG_SRC;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.LogSourceName";
    }

    public String getRemoteConfigFlag() {
        return "fpr_log_source";
    }
}

