/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.push.task;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.l;

public class BaseVoidTask
extends TaskApiCall {
    public BaseVoidTask(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String object, l l10) {
        int n10 = responseErrorCode.getErrorCode();
        Object object2 = "BaseVoidTask";
        if (n10 == 0) {
            HMSLog.i(object2, "Operate succeed");
            n10 = 0;
            object = null;
            l10.d(null);
        } else {
            object = new StringBuilder();
            String string2 = "Operate failed with ret=";
            ((StringBuilder)object).append(string2);
            int n11 = responseErrorCode.getErrorCode();
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            HMSLog.e(object2, (String)object);
            n10 = responseErrorCode.getErrorCode();
            object = ErrorEnum.fromCode(n10);
            object2 = ErrorEnum.ERROR_UNKNOWN;
            if (object != object2) {
                object = ((ErrorEnum)((Object)object)).toApiException();
                l10.c((Exception)object);
            } else {
                n11 = responseErrorCode.getErrorCode();
                String string3 = responseErrorCode.getErrorReason();
                object2 = new Status(n11, string3);
                object = new ApiException((Status)object2);
                l10.c((Exception)object);
            }
        }
        pushClient = pushClient.getContext();
        object = this.getUri();
        PushBiUtil.reportExit((Context)pushClient, (String)object, responseErrorCode);
    }

    public int getMinApkVersion() {
        return 30000000;
    }
}

