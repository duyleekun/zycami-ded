/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.adapter;

import com.huawei.hms.adapter.CoreBaseResponse;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

public class BaseAdapter$MPendingResultImpl
extends PendingResultImpl {
    public BaseAdapter$MPendingResultImpl(ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        super(apiClient, string2, iMessageEntity);
    }

    public ResolveResult onComplete(CoreBaseResponse iMessageEntity) {
        ResolveResult resolveResult = new ResolveResult(iMessageEntity);
        iMessageEntity = Status.SUCCESS;
        resolveResult.setStatus((Status)iMessageEntity);
        return resolveResult;
    }
}

