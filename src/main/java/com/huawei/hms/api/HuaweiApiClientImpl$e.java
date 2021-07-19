/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

public class HuaweiApiClientImpl$e
extends PendingResultImpl {
    public HuaweiApiClientImpl$e(ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        super(apiClient, string2, iMessageEntity);
    }

    public Status onComplete(IMessageEntity iMessageEntity) {
        iMessageEntity = new Status(0);
        return iMessageEntity;
    }
}

