/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Messenger
 */
package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.xiaomi.push.service.XMPushService;

public class bq
extends Handler {
    public final /* synthetic */ XMPushService a;

    public bq(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        super.handleMessage(object);
        if (object == null) return;
        try {
            int n10 = object.what;
            int n11 = 17;
            if (n10 == n11) {
                Object object2 = object.obj;
                if (object2 == null) return;
                Intent intent = (Intent)object2;
                XMPushService xMPushService = this.a;
                n11 = XMPushService.a;
                xMPushService.onStart(intent, n11);
                return;
            }
            n11 = 18;
            if (n10 != n11) {
                return;
            }
            n10 = 0;
            Message message = null;
            String string2 = null;
            message = Message.obtain(null, (int)0);
            message.what = n11;
            Bundle bundle = new Bundle();
            string2 = "xmsf_region";
            Object object3 = this.a;
            object3 = XMPushService.a((XMPushService)object3);
            bundle.putString(string2, (String)object3);
            message.setData(bundle);
            Messenger messenger = object.replyTo;
            messenger.send(message);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }
}

