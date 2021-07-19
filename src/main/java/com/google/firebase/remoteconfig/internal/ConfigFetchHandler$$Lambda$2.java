/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;

public final class ConfigFetchHandler$$Lambda$2
implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final Task arg$2;
    private final Task arg$3;
    private final Date arg$4;

    private ConfigFetchHandler$$Lambda$2(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = task;
        this.arg$3 = task2;
        this.arg$4 = date;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        ConfigFetchHandler$$Lambda$2 configFetchHandler$$Lambda$2 = new ConfigFetchHandler$$Lambda$2(configFetchHandler, task, task2, date);
        return configFetchHandler$$Lambda$2;
    }

    public Object then(Task task) {
        ConfigFetchHandler configFetchHandler = this.arg$1;
        Task task2 = this.arg$2;
        Task task3 = this.arg$3;
        Date date = this.arg$4;
        return ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$1(configFetchHandler, task2, task3, date, task);
    }
}

