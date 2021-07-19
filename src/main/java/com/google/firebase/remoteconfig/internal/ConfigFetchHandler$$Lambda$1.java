/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

public final class ConfigFetchHandler$$Lambda$1
implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final long arg$2;

    private ConfigFetchHandler$$Lambda$1(ConfigFetchHandler configFetchHandler, long l10) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = l10;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, long l10) {
        ConfigFetchHandler$$Lambda$1 configFetchHandler$$Lambda$1 = new ConfigFetchHandler$$Lambda$1(configFetchHandler, l10);
        return configFetchHandler$$Lambda$1;
    }

    public Object then(Task task) {
        ConfigFetchHandler configFetchHandler = this.arg$1;
        long l10 = this.arg$2;
        return ConfigFetchHandler.lambda$fetch$0(configFetchHandler, l10, task);
    }
}

