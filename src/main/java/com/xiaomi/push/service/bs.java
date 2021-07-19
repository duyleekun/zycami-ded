/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$f;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$a;

public class bs
implements ap$a {
    public final /* synthetic */ XMPushService a;

    public bs(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a() {
        XMPushService.a(this.a);
        Object object = ap.a();
        int n10 = ((ap)object).a();
        if (n10 <= 0) {
            object = this.a;
            int n11 = 12;
            XMPushService$f xMPushService$f = new XMPushService$f((XMPushService)object, n11, null);
            ((XMPushService)object).a(xMPushService$f);
        }
    }
}

