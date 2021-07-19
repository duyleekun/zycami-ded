/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.BaseContentWrapper;
import com.huawei.hms.common.internal.TaskApiCall;
import d.j.d.a.l;

public class TaskApiCallWrapper
extends BaseContentWrapper {
    private final TaskApiCall mTaskApiCall;
    private final l mTaskCompletionSource;

    public TaskApiCallWrapper(TaskApiCall taskApiCall, l l10) {
        super(1);
        this.mTaskApiCall = taskApiCall;
        this.mTaskCompletionSource = l10;
    }

    public TaskApiCall getTaskApiCall() {
        return this.mTaskApiCall;
    }

    public l getTaskCompletionSource() {
        return this.mTaskCompletionSource;
    }
}

