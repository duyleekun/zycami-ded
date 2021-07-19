/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.concurrent.Callable;

public final class ConfigCacheClient$$Lambda$1
implements Callable {
    private final ConfigCacheClient arg$1;
    private final ConfigContainer arg$2;

    private ConfigCacheClient$$Lambda$1(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        this.arg$1 = configCacheClient;
        this.arg$2 = configContainer;
    }

    public static Callable lambdaFactory$(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        ConfigCacheClient$$Lambda$1 configCacheClient$$Lambda$1 = new ConfigCacheClient$$Lambda$1(configCacheClient, configContainer);
        return configCacheClient$$Lambda$1;
    }

    public Object call() {
        ConfigCacheClient configCacheClient = this.arg$1;
        ConfigContainer configContainer = this.arg$2;
        return ConfigCacheClient.lambda$put$0(configCacheClient, configContainer);
    }
}

