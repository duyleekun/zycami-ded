/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.gj;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ao;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$k
extends XMPushService$i {
    private gj a;
    public final /* synthetic */ XMPushService a;

    public XMPushService$k(XMPushService xMPushService, gj gj2) {
        this.a = xMPushService;
        super(8);
        this.a = null;
        this.a = gj2;
    }

    public String a() {
        return "receive a message.";
    }

    public void a() {
        ao ao2 = XMPushService.a(this.a);
        gj gj2 = this.a;
        ao2.a(gj2);
    }
}

