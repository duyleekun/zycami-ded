/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.huawei.hms.adapter;

import android.os.Handler;
import android.os.Message;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.support.log.HMSLog;

public class BinderAdapter$1
implements Handler.Callback {
    public final /* synthetic */ BinderAdapter this$0;

    public BinderAdapter$1(BinderAdapter binderAdapter) {
        this.this$0 = binderAdapter;
    }

    public boolean handleMessage(Message message) {
        int n10;
        int n11;
        if (message != null && (n11 = message.what) == (n10 = 1001)) {
            HMSLog.e("BinderAdapter", "In connect, bind core service time out");
            BinderAdapter.access$000(this.this$0);
            return true;
        }
        return false;
    }
}

