/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$f;
import com.xiaomi.push.service.XMPushService$i;

public class bu
extends ContentObserver {
    public final /* synthetic */ XMPushService a;

    public bu(XMPushService xMPushService, Handler handler) {
        this.a = xMPushService;
        super(handler);
    }

    public void onChange(boolean bl2) {
        super.onChange(bl2);
        XMPushService xMPushService = this.a;
        bl2 = XMPushService.b(xMPushService);
        Object object = new StringBuilder();
        String string2 = "SuperPowerMode:";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(bl2);
        b.a(((StringBuilder)object).toString());
        object = this.a;
        XMPushService.a((XMPushService)object);
        if (bl2) {
            xMPushService = this.a;
            int n10 = 24;
            object = new XMPushService$f(xMPushService, n10, null);
            xMPushService.a((XMPushService$i)object);
        } else {
            xMPushService = this.a;
            boolean bl3 = true;
            xMPushService.a(bl3);
        }
    }
}

