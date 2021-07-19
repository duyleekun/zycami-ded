/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;

public final class ConfigFetchHandler$$Lambda$3
implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final Date arg$2;

    private ConfigFetchHandler$$Lambda$3(ConfigFetchHandler configFetchHandler, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = date;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, Date date) {
        ConfigFetchHandler$$Lambda$3 configFetchHandler$$Lambda$3 = new ConfigFetchHandler$$Lambda$3(configFetchHandler, date);
        return configFetchHandler$$Lambda$3;
    }

    public Object then(Task task) {
        ConfigFetchHandler configFetchHandler = this.arg$1;
        Date date = this.arg$2;
        return ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$2(configFetchHandler, date, task);
    }
}

