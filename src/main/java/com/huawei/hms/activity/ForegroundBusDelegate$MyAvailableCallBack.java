/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.activity;

import com.huawei.hms.activity.ForegroundBusDelegate;
import com.huawei.hms.activity.ForegroundBusDelegate$1;
import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.support.log.HMSLog;

public class ForegroundBusDelegate$MyAvailableCallBack
implements AvailableAdapter$AvailableCallBack {
    public final /* synthetic */ ForegroundBusDelegate this$0;

    private ForegroundBusDelegate$MyAvailableCallBack(ForegroundBusDelegate foregroundBusDelegate) {
        this.this$0 = foregroundBusDelegate;
    }

    public /* synthetic */ ForegroundBusDelegate$MyAvailableCallBack(ForegroundBusDelegate foregroundBusDelegate, ForegroundBusDelegate$1 foregroundBusDelegate$1) {
        this(foregroundBusDelegate);
    }

    public void onComplete(int n10) {
        if (n10 == 0) {
            ForegroundBusDelegate foregroundBusDelegate = this.this$0;
            ForegroundBusDelegate.access$100(foregroundBusDelegate);
        } else {
            HMSLog.i("ForegroundBusDelegate", "version check failed");
            ForegroundBusDelegate foregroundBusDelegate = this.this$0;
            String string2 = "apk version is invalid";
            ForegroundBusDelegate.access$200(foregroundBusDelegate, 0, string2);
        }
    }
}

