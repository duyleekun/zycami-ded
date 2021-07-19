/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.opendevice.OpenDeviceHmsClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import d.j.d.a.l;

public class OpenDeviceTaskApiCall
extends TaskApiCall {
    public OpenDeviceTaskApiCall(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public void doExecute(OpenDeviceHmsClient object, ResponseErrorCode object2, String object3, l l10) {
        if (object2 == null) {
            object2 = new Status(1);
            object = new ApiException((Status)object2);
            l10.c((Exception)object);
            return;
        }
        Object object4 = ((BaseHmsClient)object).getContext();
        String string2 = this.getUri();
        String string3 = this.getTransactionId();
        int n10 = object2.getStatusCode();
        int n11 = object2.getErrorCode();
        int n12 = 50101300;
        HiAnalyticsClient.reportExit(object4, string2, string3, n10, n11, n12);
        int n13 = object2.getErrorCode();
        object4 = "OpenDeviceTaskApiCall";
        if (n13 == 0) {
            HMSLog.i((String)object4, "onResult, success");
            object = new OdidResp();
            JsonUtil.jsonToEntity((String)object3, (IMessageEntity)object);
            object2 = new OdidResult();
            object = ((OdidResp)object).getId();
            ((OdidResult)object2).setId((String)object);
            boolean bl2 = false;
            object3 = null;
            object = new Status(0);
            ((Result)object2).setStatus((Status)object);
            l10.d(object2);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("onResult, returnCode: ");
            int n14 = object2.getErrorCode();
            ((StringBuilder)object).append(n14);
            object = ((StringBuilder)object).toString();
            HMSLog.i((String)object4, (String)object);
            int n15 = object2.getErrorCode();
            object2 = object2.getErrorReason();
            object3 = new Status(n15, (String)object2);
            object = new ApiException((Status)object3);
            l10.c((Exception)object);
        }
    }

    public int getApiLevel() {
        return 2;
    }

    public int getMinApkVersion() {
        return 50002300;
    }
}

