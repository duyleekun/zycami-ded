/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.log.HMSLog;

public final class ConnectService$b
extends PendingResultImpl {
    public ConnectService$b(ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        super(apiClient, string2, iMessageEntity);
    }

    public ResolveResult a(ConnectResp iMessageEntity) {
        ResolveResult resolveResult = new ResolveResult(iMessageEntity);
        iMessageEntity = Status.SUCCESS;
        resolveResult.setStatus((Status)iMessageEntity);
        HMSLog.d("connectservice", "forceConnect - onComplete: success");
        return resolveResult;
    }

    public boolean checkApiClient(ApiClient apiClient) {
        boolean bl2;
        if (apiClient != null) {
            bl2 = true;
        } else {
            bl2 = false;
            apiClient = null;
        }
        return bl2;
    }
}

