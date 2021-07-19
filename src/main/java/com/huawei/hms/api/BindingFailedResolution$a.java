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

public class BindingFailedResolution$a
implements Handler.Callback {
    public final /* synthetic */ BindingFailedResolution a;

    public BindingFailedResolution$a(BindingFailedResolution bindingFailedResolution) {
        this.a = bindingFailedResolution;
    }

    public boolean handleMessage(Message message) {
        int n10;
        int n11;
        if (message != null && (n11 = message.what) == (n10 = 3)) {
            BindingFailedResolution.a(this.a, 8);
            return true;
        }
        return false;
    }
}

