/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;

public final class ConfigFetchHandler$$Lambda$4
implements SuccessContinuation {
    private final ConfigFetchHandler$FetchResponse arg$1;

    private ConfigFetchHandler$$Lambda$4(ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse) {
        this.arg$1 = configFetchHandler$FetchResponse;
    }

    public static SuccessContinuation lambdaFactory$(ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse) {
        ConfigFetchHandler$$Lambda$4 configFetchHandler$$Lambda$4 = new ConfigFetchHandler$$Lambda$4(configFetchHandler$FetchResponse);
        return configFetchHandler$$Lambda$4;
    }

    public Task then(Object object) {
        ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse = this.arg$1;
        object = (ConfigContainer)object;
        return ConfigFetchHandler.lambda$fetchFromBackendAndCacheResponse$3(configFetchHandler$FetchResponse, (ConfigContainer)object);
    }
}

