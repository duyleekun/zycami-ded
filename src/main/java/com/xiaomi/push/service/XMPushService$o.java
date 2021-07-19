/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$o
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;

    public XMPushService$o(XMPushService xMPushService) {
        this.a = xMPushService;
        super(3);
    }

    public String a() {
        return "reset the connection.";
    }

    public void a() {
        XMPushService xMPushService = this.a;
        int n10 = 11;
        xMPushService.a(n10, null);
        xMPushService = this.a;
        boolean bl2 = xMPushService.a();
        if (bl2) {
            xMPushService = this.a;
            XMPushService.c(xMPushService);
        }
    }
}

