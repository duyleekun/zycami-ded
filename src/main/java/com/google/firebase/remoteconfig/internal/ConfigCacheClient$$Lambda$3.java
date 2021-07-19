/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.concurrent.Callable;

public final class ConfigCacheClient$$Lambda$3
implements Callable {
    private final ConfigStorageClient arg$1;

    private ConfigCacheClient$$Lambda$3(ConfigStorageClient configStorageClient) {
        this.arg$1 = configStorageClient;
    }

    public static Callable lambdaFactory$(ConfigStorageClient configStorageClient) {
        ConfigCacheClient$$Lambda$3 configCacheClient$$Lambda$3 = new ConfigCacheClient$$Lambda$3(configStorageClient);
        return configCacheClient$$Lambda$3;
    }

    public Object call() {
        return this.arg$1.read();
    }
}

