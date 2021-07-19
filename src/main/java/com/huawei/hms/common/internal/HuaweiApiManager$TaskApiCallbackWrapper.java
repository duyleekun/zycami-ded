/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.common.internal.TaskApiCallWrapper;

public class HuaweiApiManager$TaskApiCallbackWrapper {
    private final TaskApiCallWrapper mApiCallWrapper;
    private final AnyClient$CallBack mCallBack;

    public HuaweiApiManager$TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient$CallBack anyClient$CallBack) {
        this.mApiCallWrapper = taskApiCallWrapper;
        this.mCallBack = anyClient$CallBack;
    }

    public TaskApiCallWrapper getApiCallWrapper() {
        return this.mApiCallWrapper;
    }

    public AnyClient$CallBack getCallBack() {
        return this.mCallBack;
    }
}

