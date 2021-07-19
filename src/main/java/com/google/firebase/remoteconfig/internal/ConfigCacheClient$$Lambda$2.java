/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

public final class ConfigCacheClient$$Lambda$2
implements SuccessContinuation {
    private final ConfigCacheClient arg$1;
    private final boolean arg$2;
    private final ConfigContainer arg$3;

    private ConfigCacheClient$$Lambda$2(ConfigCacheClient configCacheClient, boolean bl2, ConfigContainer configContainer) {
        this.arg$1 = configCacheClient;
        this.arg$2 = bl2;
        this.arg$3 = configContainer;
    }

    public static SuccessContinuation lambdaFactory$(ConfigCacheClient configCacheClient, boolean bl2, ConfigContainer configContainer) {
        ConfigCacheClient$$Lambda$2 configCacheClient$$Lambda$2 = new ConfigCacheClient$$Lambda$2(configCacheClient, bl2, configContainer);
        return configCacheClient$$Lambda$2;
    }

    public Task then(Object object) {
        ConfigCacheClient configCacheClient = this.arg$1;
        boolean bl2 = this.arg$2;
        ConfigContainer configContainer = this.arg$3;
        object = (Void)object;
        return ConfigCacheClient.lambda$put$1(configCacheClient, bl2, configContainer, (Void)object);
    }
}

