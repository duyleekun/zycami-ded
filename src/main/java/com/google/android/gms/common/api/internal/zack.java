/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall$Builder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zack
extends TaskApiCall {
    private final /* synthetic */ TaskApiCall$Builder zakn;

    public zack(TaskApiCall$Builder taskApiCall$Builder, Feature[] featureArray, boolean bl2) {
        this.zakn = taskApiCall$Builder;
        super(featureArray, bl2, null);
    }

    public final void doExecute(Api$AnyClient api$AnyClient, TaskCompletionSource taskCompletionSource) {
        TaskApiCall$Builder.zaa(this.zakn).accept(api$AnyClient, taskCompletionSource);
    }
}

