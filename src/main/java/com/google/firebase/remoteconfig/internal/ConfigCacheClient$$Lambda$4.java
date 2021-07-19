/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

public final class ConfigCacheClient$$Lambda$4
implements Executor {
    private static final ConfigCacheClient$$Lambda$4 instance;

    static {
        ConfigCacheClient$$Lambda$4 configCacheClient$$Lambda$4;
        instance = configCacheClient$$Lambda$4 = new ConfigCacheClient$$Lambda$4();
    }

    private ConfigCacheClient$$Lambda$4() {
    }

    public static Executor lambdaFactory$() {
        return instance;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}

