/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.log.HMSLog;

public class u
extends PendingResultImpl {
    public final /* synthetic */ HuaweiOpendeviceApiImpl a;

    public u(HuaweiOpendeviceApiImpl huaweiOpendeviceApiImpl, ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        this.a = huaweiOpendeviceApiImpl;
        super(apiClient, string2, iMessageEntity);
    }

    public OdidResult a(OdidResp object) {
        Object object2 = null;
        String string2 = "OpenIdentifierApiImpl";
        if (object == null) {
            HMSLog.e(string2, "getOdid OaidResp is null");
            return null;
        }
        Status status = ((AbstractMessageEntity)object).getCommonStatus();
        if (status == null) {
            HMSLog.e(string2, "getOdid commonStatus is null");
            return null;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getOdid onComplete:");
        int n10 = status.getStatusCode();
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.i(string2, (String)object2);
        object2 = new OdidResult();
        ((Result)object2).setStatus(status);
        object = ((OdidResp)object).getId();
        ((OdidResult)object2).setId((String)object);
        return object2;
    }
}

