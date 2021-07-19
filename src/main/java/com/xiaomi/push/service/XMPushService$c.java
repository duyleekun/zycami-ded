/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.fl;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ao;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$c
extends XMPushService$i {
    private fl a;
    public final /* synthetic */ XMPushService a;

    public XMPushService$c(XMPushService xMPushService, fl fl2) {
        this.a = xMPushService;
        super(8);
        this.a = null;
        this.a = fl2;
    }

    public String a() {
        return "receive a message.";
    }

    public void a() {
        ao ao2 = XMPushService.a(this.a);
        fl fl2 = this.a;
        ao2.a(fl2);
    }
}

