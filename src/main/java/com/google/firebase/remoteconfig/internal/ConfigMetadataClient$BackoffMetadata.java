/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import java.util.Date;

public class ConfigMetadataClient$BackoffMetadata {
    private Date backoffEndTime;
    private int numFailedFetches;

    public ConfigMetadataClient$BackoffMetadata(int n10, Date date) {
        this.numFailedFetches = n10;
        this.backoffEndTime = date;
    }

    public Date getBackoffEndTime() {
        return this.backoffEndTime;
    }

    public int getNumFailedFetches() {
        return this.numFailedFetches;
    }
}

