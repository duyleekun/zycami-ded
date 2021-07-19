/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$c;
import com.xiaomi.push.service.XMPushService$k;

public class bl
implements fx {
    public final /* synthetic */ XMPushService a;

    public bl(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a(fl fl2) {
        XMPushService xMPushService = this.a;
        XMPushService$c xMPushService$c = new XMPushService$c(xMPushService, fl2);
        xMPushService.a(xMPushService$c);
    }

    public void a(gj gj2) {
        XMPushService xMPushService = this.a;
        XMPushService$k xMPushService$k = new XMPushService$k(xMPushService, gj2);
        xMPushService.a(xMPushService$k);
    }
}

