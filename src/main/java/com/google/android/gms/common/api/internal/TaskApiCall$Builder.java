/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zaci;
import com.google.android.gms.common.api.internal.zacj;
import com.google.android.gms.common.api.internal.zack;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;

public class TaskApiCall$Builder {
    private Feature[] zake;
    private boolean zakl = true;
    private RemoteCall zakm;

    private TaskApiCall$Builder() {
    }

    public /* synthetic */ TaskApiCall$Builder(zaci zaci2) {
        this();
    }

    public static /* synthetic */ RemoteCall zaa(TaskApiCall$Builder taskApiCall$Builder) {
        return taskApiCall$Builder.zakm;
    }

    public TaskApiCall build() {
        boolean bl2;
        Object object = this.zakm;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkArgument(bl2, "execute parameter required");
        Feature[] featureArray = this.zake;
        boolean bl3 = this.zakl;
        object = new zack(this, featureArray, bl3);
        return object;
    }

    public TaskApiCall$Builder execute(BiConsumer biConsumer) {
        zacj zacj2 = new zacj(biConsumer);
        this.zakm = zacj2;
        return this;
    }

    public TaskApiCall$Builder run(RemoteCall remoteCall) {
        this.zakm = remoteCall;
        return this;
    }

    public TaskApiCall$Builder setAutoResolveMissingFeatures(boolean bl2) {
        this.zakl = bl2;
        return this;
    }

    public TaskApiCall$Builder setFeatures(Feature ... featureArray) {
        this.zake = featureArray;
        return this;
    }
}

