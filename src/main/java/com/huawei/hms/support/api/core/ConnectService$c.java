/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

public final class ConnectService$c
extends PendingResultImpl {
    public ConnectService$c(ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        super(apiClient, string2, iMessageEntity);
    }

    public ResolveResult a(JosGetNoticeResp iMessageEntity) {
        Object object = "connectservice";
        if (iMessageEntity == null) {
            HMSLog.e((String)object, "JosNoticeResp is null");
            return null;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("josNoticeResp status code :");
        int n10 = iMessageEntity.getStatusCode();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i((String)object, (String)charSequence);
        object = new ResolveResult(iMessageEntity);
        iMessageEntity = Status.SUCCESS;
        ((Result)object).setStatus((Status)iMessageEntity);
        return object;
    }
}

