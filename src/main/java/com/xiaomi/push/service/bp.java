/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.XMPushService;

public class bp
implements ServiceConnection {
    public final /* synthetic */ XMPushService a;

    public bp(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = new StringBuilder();
        String string2 = "onServiceConnected ";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(object2);
        b.b(((StringBuilder)object).toString());
        object = XMJobService.a();
        if (object != null) {
            object2 = this.a;
            int n10 = XMPushService.a();
            Notification notification = XMPushService.a((Context)this.a);
            object2.startForeground(n10, notification);
            int bl2 = XMPushService.a();
            string2 = XMPushService.a((Context)this.a);
            object.startForeground(bl2, (Notification)string2);
            boolean bl3 = true;
            object.stopForeground(bl3);
            object = this.a;
            object.unbindService((ServiceConnection)this);
        } else {
            object = new StringBuilder();
            string2 = "XMService connected but innerService is null ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            b.a((String)object);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

