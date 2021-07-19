/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bn
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;

    public bn(XMPushService xMPushService, int n10) {
        this.a = xMPushService;
        super(n10);
    }

    public String a() {
        return "disconnect for service destroy.";
    }

    public void a() {
        Object object = XMPushService.a(this.a);
        if (object != null) {
            object = XMPushService.a(this.a);
            int n10 = 15;
            ((fs)object).b(n10, null);
            object = this.a;
            XMPushService.a((XMPushService)object, null);
        }
    }
}

