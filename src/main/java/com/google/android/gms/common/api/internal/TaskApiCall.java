/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall$Builder;
import com.google.android.gms.common.api.internal.zaci;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class TaskApiCall {
    private final Feature[] zake;
    private final boolean zakl;

    public TaskApiCall() {
        this.zake = null;
        this.zakl = false;
    }

    private TaskApiCall(Feature[] featureArray, boolean bl2) {
        this.zake = featureArray;
        this.zakl = bl2;
    }

    public /* synthetic */ TaskApiCall(Feature[] featureArray, boolean bl2, zaci zaci2) {
        this(featureArray, bl2);
    }

    public static TaskApiCall$Builder builder() {
        TaskApiCall$Builder taskApiCall$Builder = new TaskApiCall$Builder(null);
        return taskApiCall$Builder;
    }

    public abstract void doExecute(Api$AnyClient var1, TaskCompletionSource var2);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zakl;
    }

    public final Feature[] zabt() {
        return this.zake;
    }
}

