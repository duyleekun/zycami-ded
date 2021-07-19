/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import d.j.d.a.l;

public class k
extends TaskApiCall {
    public DeleteTokenReq a;

    public k(String string2, DeleteTokenReq deleteTokenReq, String string3) {
        String string4 = JsonUtil.createJsonString(deleteTokenReq);
        super(string2, string4, string3);
        this.a = deleteTokenReq;
    }

    public void a(PushClient object, ResponseErrorCode object2, String object3, l l10) {
        int n10 = object2.getErrorCode();
        if (n10 != 0) {
            object = HmsInstanceId.TAG;
            object3 = new StringBuilder();
            String string2 = "DeleteTokenTask failed, ErrorCode: ";
            ((StringBuilder)object3).append(string2);
            n10 = object2.getErrorCode();
            ((StringBuilder)object3).append(n10);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.e((String)object, object3);
            int n11 = object2.getErrorCode();
            object = ErrorEnum.fromCode(n11);
            object3 = ErrorEnum.ERROR_UNKNOWN;
            if (object != object3) {
                object = ((ErrorEnum)((Object)object)).toApiException();
                l10.c((Exception)object);
            } else {
                n10 = object2.getErrorCode();
                object2 = object2.getErrorReason();
                object3 = new Status(n10, (String)object2);
                object = new ApiException((Status)object3);
                l10.c((Exception)object);
            }
        } else {
            Object object4 = new DeleteTokenResp();
            int n12 = ((DeleteTokenResp)JsonUtil.jsonToEntity(object3, object4)).getRetCode();
            if ((object3 = ErrorEnum.fromCode(n12)) != (object4 = ErrorEnum.SUCCESS)) {
                object = ((ErrorEnum)((Object)object3)).toApiException();
                l10.c((Exception)object);
            } else {
                n12 = 0;
                l10.d(null);
                object = ((BaseHmsClient)object).getContext();
                object3 = this.getUri();
                q.a((Context)object, object3, (ResponseErrorCode)object2);
            }
        }
    }

    public int getMinApkVersion() {
        DeleteTokenReq deleteTokenReq = this.a;
        boolean bl2 = deleteTokenReq.isMultiSender();
        if (bl2) {
            return 50004300;
        }
        return 30000000;
    }
}

