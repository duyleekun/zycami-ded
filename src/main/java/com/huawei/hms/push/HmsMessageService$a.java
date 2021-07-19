/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 */
package com.huawei.hms.push;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.a;
import com.huawei.hms.support.log.HMSLog;

public class HmsMessageService$a
extends Handler {
    public final /* synthetic */ HmsMessageService a;

    public HmsMessageService$a(HmsMessageService hmsMessageService) {
        this.a = hmsMessageService;
    }

    public /* synthetic */ HmsMessageService$a(HmsMessageService hmsMessageService, a a10) {
        this(hmsMessageService);
    }

    public void handleMessage(Message message) {
        Object object = "HmsMessageService";
        if (message == null) {
            HMSLog.e((String)object, "receive message is null");
            return;
        }
        String string2 = "handle message start ";
        HMSLog.i((String)object, string2);
        object = message.getData();
        if (object != null) {
            string2 = new Intent();
            string2.putExtras((Bundle)object);
            int n10 = -1;
            String string3 = "inputType";
            int n11 = object.getInt(string3, n10);
            string2.putExtra(string3, n11);
            object = this.a;
            ((HmsMessageService)((Object)object)).handleIntentMessage((Intent)string2);
        }
        super.handleMessage(message);
    }
}

