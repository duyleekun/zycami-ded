/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.huawei.hms.api;

import android.os.Handler;
import android.os.Message;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;

public class BindingFailedResolution$b
implements Handler.Callback {
    public final /* synthetic */ BindingFailedResolution a;

    public BindingFailedResolution$b(BindingFailedResolution bindingFailedResolution) {
        this.a = bindingFailedResolution;
    }

    public boolean handleMessage(Message message) {
        int n10;
        int n11;
        if (message != null && (n11 = message.what) == (n10 = 2)) {
            HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
            BindingFailedResolution.a(this.a, false);
            return true;
        }
        return false;
    }
}

