/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

public class ResolvePendingResult
extends PendingResultImpl {
    public ResolvePendingResult(ApiClient apiClient, String string2, IMessageEntity iMessageEntity, Class clazz) {
        super(apiClient, string2, iMessageEntity, clazz);
    }

    public static ResolvePendingResult build(ApiClient apiClient, String string2, IMessageEntity iMessageEntity, Class clazz) {
        ResolvePendingResult resolvePendingResult = new ResolvePendingResult(apiClient, string2, iMessageEntity, clazz);
        return resolvePendingResult;
    }

    public IMessageEntity get() {
        return (IMessageEntity)((ResolveResult)this.await()).getValue();
    }

    public ResolveResult onComplete(IMessageEntity iMessageEntity) {
        ResolveResult resolveResult = new ResolveResult(iMessageEntity);
        iMessageEntity = new Status(0);
        resolveResult.setStatus((Status)iMessageEntity);
        return resolveResult;
    }
}

