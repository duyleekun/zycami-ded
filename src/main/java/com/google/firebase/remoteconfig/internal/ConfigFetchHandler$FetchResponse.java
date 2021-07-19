/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.Date;

public class ConfigFetchHandler$FetchResponse {
    private final Date fetchTime;
    private final ConfigContainer fetchedConfigs;
    private final String lastFetchETag;
    private final int status;

    private ConfigFetchHandler$FetchResponse(Date date, int n10, ConfigContainer configContainer, String string2) {
        this.fetchTime = date;
        this.status = n10;
        this.fetchedConfigs = configContainer;
        this.lastFetchETag = string2;
    }

    public static ConfigFetchHandler$FetchResponse forBackendHasNoUpdates(Date date) {
        ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse = new ConfigFetchHandler$FetchResponse(date, 1, null, null);
        return configFetchHandler$FetchResponse;
    }

    public static ConfigFetchHandler$FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String string2) {
        Date date = configContainer.getFetchTime();
        ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse = new ConfigFetchHandler$FetchResponse(date, 0, configContainer, string2);
        return configFetchHandler$FetchResponse;
    }

    public static ConfigFetchHandler$FetchResponse forLocalStorageUsed(Date date) {
        ConfigFetchHandler$FetchResponse configFetchHandler$FetchResponse = new ConfigFetchHandler$FetchResponse(date, 2, null, null);
        return configFetchHandler$FetchResponse;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public ConfigContainer getFetchedConfigs() {
        return this.fetchedConfigs;
    }

    public String getLastFetchETag() {
        return this.lastFetchETag;
    }

    public int getStatus() {
        return this.status;
    }
}

