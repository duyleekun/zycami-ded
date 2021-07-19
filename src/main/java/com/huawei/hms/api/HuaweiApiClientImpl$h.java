/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.api.HuaweiApiClientImpl$a;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.JosBaseResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class HuaweiApiClientImpl$h
implements ResultCallback {
    public final /* synthetic */ HuaweiApiClientImpl a;

    private HuaweiApiClientImpl$h(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.a = huaweiApiClientImpl;
    }

    public /* synthetic */ HuaweiApiClientImpl$h(HuaweiApiClientImpl huaweiApiClientImpl, HuaweiApiClientImpl$a huaweiApiClientImpl$a) {
        this(huaweiApiClientImpl);
    }

    public void a(ResolveResult object) {
        int n10;
        Status status;
        boolean bl2;
        if (object != null && (bl2 = (status = ((Result)object).getStatus()).isSuccess()) && (status = ((JosGetNoticeResp)(object = (JosGetNoticeResp)((ResolveResult)object).getValue())).getNoticeIntent()) != null && (n10 = ((JosBaseResp)object).getStatusCode()) == 0) {
            object = "HuaweiApiClientImpl";
            HMSLog.i((String)object, "get notice has intent.");
            Activity activity = (Activity)HuaweiApiClientImpl.d(this.a).get();
            Activity activity2 = this.a.getTopActivity();
            activity = Util.getValidActivity(activity, activity2);
            if (activity == null) {
                HMSLog.e((String)object, "showNotice no valid activity!");
                return;
            }
            object = this.a;
            boolean bl3 = true;
            HuaweiApiClientImpl.a((HuaweiApiClientImpl)object, bl3);
            activity.startActivity((Intent)status);
        }
    }
}

