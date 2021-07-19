/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.l;

public class SendUpStreamTask
extends TaskApiCall {
    public String a;
    public String b;

    public SendUpStreamTask(String string2, String string3, String string4, String string5, String string6) {
        super(string2, string3, string4);
        this.a = string5;
        this.b = string6;
    }

    public final void a(PushClient pushClient, ResponseErrorCode object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("receive upstream, msgId :");
        Object object2 = this.b;
        charSequence.append((String)object2);
        charSequence.append(" , packageName = ");
        object2 = this.a;
        charSequence.append((String)object2);
        charSequence.append(" , errorCode = ");
        int n10 = object.getErrorCode();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object2 = "SendUpStreamTask";
        HMSLog.i(object2, (String)charSequence);
        charSequence = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        String string2 = this.a;
        charSequence.setPackage(string2);
        string2 = new Bundle();
        Object object3 = this.b;
        string2.putString("message_id", (String)object3);
        int n11 = object.getErrorCode();
        String string3 = "error";
        string2.putInt(string3, n11);
        object3 = ErrorEnum.SUCCESS;
        n11 = ((ErrorEnum)((Object)object3)).getInternalCode();
        int n12 = object.getErrorCode();
        String string4 = "message_type";
        if (n11 == n12) {
            object3 = "sent_message";
            string2.putString(string4, (String)object3);
        } else {
            object3 = "send_error";
            string2.putString(string4, (String)object3);
        }
        object3 = new h();
        string3 = pushClient.getContext();
        boolean bl2 = ((h)object3).a((Context)string3, (Bundle)string2, (Intent)charSequence);
        if (bl2) {
            HMSLog.i(object2, "receive upstream, start service success");
            pushClient = pushClient.getContext();
            charSequence = this.getUri();
            PushBiUtil.reportExit((Context)pushClient, (String)charSequence, (ResponseErrorCode)object);
        } else {
            HMSLog.w(object2, "receive upstream, start service failed");
            pushClient = pushClient.getContext();
            charSequence = this.getUri();
            object = object.getTransactionId();
            object2 = ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING;
            PushBiUtil.reportExit((Context)pushClient, (String)charSequence, (String)object, (ErrorEnum)((Object)object2));
        }
    }

    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String object, l l10) {
        int n10 = responseErrorCode.getErrorCode();
        Object object2 = "SendUpStreamTask";
        if (n10 == 0) {
            HMSLog.i(object2, "send up stream task,Operate succeed");
            n10 = 0;
            object = null;
            l10.d(null);
        } else {
            object = new StringBuilder();
            String string2 = "send up stream task,Operate failed with ret=";
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
        this.a(pushClient, responseErrorCode);
    }

    public int getMinApkVersion() {
        return 40003000;
    }
}

